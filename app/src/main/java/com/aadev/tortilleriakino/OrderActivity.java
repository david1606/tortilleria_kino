package com.aadev.tortilleriakino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Adapters.ArticlesAdapter;
import com.aadev.tortilleriakino.Classes.Articles;
import com.aadev.tortilleriakino.Classes.Keys;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderActivity extends AppCompatActivity {
    private String client, docRef;
    private int[] defaults;
    private ArrayList<Articles> articels = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private TextView totalET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mRecyclerView = findViewById(R.id.recycler_view_order);
        TextView clientName = findViewById(R.id.client_name);
        totalET = findViewById(R.id.total_text);
        Button saveButton = findViewById(R.id.save_button);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            client = bundle.getString(new Keys().getCLIENT_KEY());
            defaults = bundle.getIntArray(new Keys().getDEFAULT_VALUES_KEY());
            docRef = bundle.getString(new Keys().getDOC_REF_KEY());
            clientName.setText(client);
        }

        articels = saveArticles();


        totalET.setText("$".concat(String.valueOf(getTotalPrice())));

        createRecyclerView(articels);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo();
            }
        });
    }

    private void saveInfo() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> info = new HashMap<>();
        info.put("sell_date", new Timestamp(new Date()));

        Map<String, Object> articlesToSave = new HashMap<>();
        if (articels.get(0).getQuantity() != 0) {
            articlesToSave.put(articels.get(0).getCode(), articels.get(0).getQuantity());
        }
        if (articels.get(1).getQuantity() != 0) {
            articlesToSave.put(articels.get(1).getCode(), articels.get(1).getQuantity());
        }
        if (articels.get(2).getQuantity() != 0) {
            articlesToSave.put(articels.get(2).getCode(), articels.get(2).getQuantity());
        }
        if (articels.get(3).getQuantity() != 0) {
            articlesToSave.put(articels.get(3).getCode(), articels.get(3).getQuantity());
        }
        if (articels.get(4).getQuantity() != 0) {
            articlesToSave.put(articels.get(4).getCode(), articels.get(4).getQuantity());
        }
        if (articels.get(5).getQuantity() != 0) {
            articlesToSave.put(articels.get(5).getCode(), articels.get(5).getQuantity());
        }
        if (articels.get(6).getQuantity() != 0) {
            articlesToSave.put(articels.get(6).getCode(), articels.get(6).getQuantity());
        }
        if (articels.get(7).getQuantity() != 0) {
            articlesToSave.put(articels.get(7).getCode(), articels.get(7).getQuantity());
        }
        if (articels.get(8).getQuantity() != 0) {
            articlesToSave.put(articels.get(8).getCode(), articels.get(8).getQuantity());
        }
        if (articels.get(9).getQuantity() != 0) {
            articlesToSave.put(articels.get(9).getCode(), articels.get(9).getQuantity());
        }
        if (articels.get(10).getQuantity() != 0) {
            articlesToSave.put(articels.get(10).getCode(), articels.get(10).getQuantity());
        }


        info.put("sell_articles", articlesToSave);

        info.put("total", getTotalPrice());

        db.collection("clients/" + docRef + "/sells/")
                .add(info)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(OrderActivity.this, documentReference.getId(), Toast.LENGTH_SHORT).show();
                        Intent orderAct = new Intent(OrderActivity.this, ViewSellActivity.class);
                        orderAct.putExtra(new Keys().getCLIENT_KEY(), client);
                        orderAct.putExtra(new Keys().getDEFAULT_VALUES_KEY(), defaults);
                        orderAct.putExtra(new Keys().getDOC_REF_KEY(), docRef);
                        orderAct.putExtra(new Keys().getSellDocRef(), documentReference.getId());
                        startActivity(orderAct);
                    }
                });
    }

    private void createRecyclerView(ArrayList<Articles> arrayList) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ArticlesAdapter(arrayList, new ArticlesAdapter.OnAddItemClickListener() {
            @Override
            public void onItemClick(Articles articles, int position) {
                int newQuantity = articles.getQuantity() + 1;
                articels.get(position).setQuantity(newQuantity);
                mAdapter.notifyDataSetChanged();
                totalET.setText("$".concat(String.valueOf(getTotalPrice())));
            }
        }, new ArticlesAdapter.OnRemoveItemClickListener() {
            @Override
            public void onItemClick(Articles articles, int position) {
                if (articles.getQuantity() != 0) {
                    int newQuantity = articles.getQuantity() - 1;
                    articels.get(position).setQuantity(newQuantity);
                    mAdapter.notifyDataSetChanged();
                    totalET.setText("$".concat(String.valueOf(getTotalPrice())));
                }
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private double getTotalPrice() {
        double total = 0;
        for (int i = 0; i < articels.size(); i++)
            total = total + (articels.get(i).getPrice() * articels.get(i).getQuantity());
        return total;
    }

    @Override
    public void onBackPressed() {
        Intent orderAct = new Intent(OrderActivity.this, ClientViewActivity.class);
        orderAct.putExtra(new Keys().getCLIENT_KEY(), client);
        orderAct.putExtra(new Keys().getDEFAULT_VALUES_KEY(), defaults);
        orderAct.putExtra(new Keys().getDOC_REF_KEY(), docRef);
        startActivity(orderAct);
        finish();
    }


    public void out(View view) {
        onBackPressed();
    }

    private ArrayList<Articles> saveArticles() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final Query query = db.collection("articles");
        return new ArrayList<Articles>() {{
            query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        int i = 0;
                        for (QueryDocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())) {
                            Articles query = documentSnapshot.toObject(Articles.class);
                            query.setQuantity(defaults[i]);
                            i++;
                            articels.add(query);
                            mAdapter.notifyDataSetChanged();
                            mRecyclerView.setVisibility(View.VISIBLE);
                        }
                    }
                }
            });
        }};

    }
}
