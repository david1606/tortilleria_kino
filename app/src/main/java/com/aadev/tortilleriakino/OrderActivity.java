package com.aadev.tortilleriakino;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Adapters.ItemsAdapter;
import com.aadev.tortilleriakino.Classes.Articles;
import com.aadev.tortilleriakino.Classes.Keys;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {
    private String client, docRef;
    private int[] defaults;
    private ArrayList<Articles> articels = new ArrayList<>(), articlesTackOut = new ArrayList<>();
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

        saveArticles();


        totalET.setText("$".concat(String.valueOf(getTotalPrice())));

        createRecyclerView(articels);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo();
                Intent orderAct = new Intent(OrderActivity.this, ClientViewActivity.class);
                orderAct.putExtra(new Keys().getCLIENT_KEY(), client);
                orderAct.putExtra(new Keys().getDEFAULT_VALUES_KEY(), defaults);
                orderAct.putExtra(new Keys().getDOC_REF_KEY(), docRef);
                startActivity(orderAct);

            }
        });
    }

    private void saveInfo() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> info = new HashMap<>();
        info.put("sell_date", new Timestamp(new Date()));

        Map<String, Object> articlesToSave = new HashMap<>();
        if (articels.get(0).getQuantity() != 0) {
            articlesToSave.put(articels.get(0).getArticle(), articels.get(0).getQuantity());
        }
        if (articels.get(1).getQuantity() != 0) {
            articlesToSave.put(articels.get(1).getArticle(), articels.get(1).getQuantity());
        }
        if (articels.get(2).getQuantity() != 0) {
            articlesToSave.put(articels.get(2).getArticle(), articels.get(2).getQuantity());
        }
        if (articels.get(3).getQuantity() != 0) {
            articlesToSave.put(articels.get(3).getArticle(), articels.get(3).getQuantity());
        }
        if (articels.get(4).getQuantity() != 0) {
            articlesToSave.put(articels.get(4).getArticle(), articels.get(4).getQuantity());
        }
        if (articels.get(5).getQuantity() != 0) {
            articlesToSave.put(articels.get(5).getArticle(), articels.get(5).getQuantity());
        }
        if (articels.get(6).getQuantity() != 0) {
            articlesToSave.put(articels.get(6).getArticle(), articels.get(6).getQuantity());
        }
        if (articels.get(7).getQuantity() != 0) {
            articlesToSave.put(articels.get(7).getArticle(), articels.get(7).getQuantity());
        }
        if (articels.get(8).getQuantity() != 0) {
            articlesToSave.put(articels.get(8).getArticle(), articels.get(8).getQuantity());
        }
        if (articels.get(9).getQuantity() != 0) {
            articlesToSave.put(articels.get(9).getArticle(), articels.get(9).getQuantity());
        }
        if (articels.get(10).getQuantity() != 0) {
            articlesToSave.put(articels.get(10).getArticle(), articels.get(10).getQuantity());
        }


        info.put("sell_articles", articlesToSave);

        info.put("total", getTotalPrice());

        db.collection("clients/" + docRef + "/ventas/")
                .add(info)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "write done");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });


    }


    private void createRecyclerView(ArrayList<Articles> arrayList) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemsAdapter(arrayList, new ItemsAdapter.OnAddItemClickListener() {
            @Override
            public void onItemClick(Articles articles, int position) {
                int newQuantity = articles.getQuantity() + 1;
                articels.get(position).setQuantity(newQuantity);
                mAdapter.notifyDataSetChanged();
                totalET.setText("$".concat(String.valueOf(getTotalPrice())));
            }
        }, new ItemsAdapter.OnRemoveItemClickListener() {
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

    private void saveArticles() {
        articels.add(new Articles("Tortillas de harina 12pz", 12, defaults[0]));
        articels.add(new Articles("Tortillas de harina 20pz", 20, defaults[1]));
        articels.add(new Articles("Tortillas de Maíz 700g", 14, defaults[2]));
        articels.add(new Articles("Totopo Natural 360g", 13, defaults[3]));
        articels.add(new Articles("Totopo Sazonado", 17, defaults[4]));
        articels.add(new Articles("Chorizo Don Ely 250g", 13, defaults[5]));
        articels.add(new Articles("Cartera de Machaca 10/50g", 120, defaults[6]));
        articels.add(new Articles("Machaca Kino 100g", 23, defaults[7]));
        articels.add(new Articles("Tortilla Maiz 1kg", 15, defaults[8]));
        articels.add(new Articles("Totopo Natural 700g", 20, defaults[9]));
        articels.add(new Articles("Tortillas taquera 20pz", 16, defaults[10]));
    }
}
