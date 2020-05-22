package com.aadev.tortilleriakino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aadev.tortilleriakino.Adapters.OrderViewAdapter;
import com.aadev.tortilleriakino.Classes.Articles;
import com.aadev.tortilleriakino.Classes.Clients;
import com.aadev.tortilleriakino.Classes.Keys;
import com.aadev.tortilleriakino.Classes.Sell;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ViewSellActivity extends AppCompatActivity {

    private String client, docRef, sellDocRef;
    private ArrayList<Articles> articlesList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private TextView totalPrice, sellDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sell);

        TextView clientName = findViewById(R.id.client_name);
        totalPrice = findViewById(R.id.total_view);
        sellDate = findViewById(R.id.date_text_view);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            client = bundle.getString(new Keys().getCLIENT_KEY());
            docRef = bundle.getString(new Keys().getDOC_REF_KEY());
            sellDocRef = bundle.getString(new Keys().getSellDocRef());
            Log.w("Key", "Client: " + client + " docRef: " + docRef);
            clientName.setText(client);
            Toast.makeText(this, docRef, Toast.LENGTH_SHORT).show();
        }

        getInfo();
        mRecyclerView = findViewById(R.id.items_order_view);
        articlesList = this.getSoldArticles();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new OrderViewAdapter(articlesList);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }


    private void getInfo() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final DocumentReference documentReference = db.document("clients/" + docRef + "/sells/" + sellDocRef);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    assert document != null;
                    if (document.exists()) {
                        Toast.makeText(ViewSellActivity.this, "Exists", Toast.LENGTH_SHORT).show();
                        Sell object = document.toObject(Sell.class);
                        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm a");
                        sellDate.setText(sdf.format(Objects.requireNonNull(document.getDate("sell_date"))));
                        totalPrice.setText(String.valueOf(document.get("total")));
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ViewSellActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Articles> getSoldArticles() {
        Log.w("Query log", "IN query");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final Query feedQuery = db.collection("clients/" + docRef + "/sold_articles").whereEqualTo("sell", sellDocRef);
        return new ArrayList<Articles>() {{
            feedQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())) {
                            Articles query = documentSnapshot.toObject(Articles.class);
                            articlesList.add(query);
                            mAdapter.notifyDataSetChanged();
                            mRecyclerView.setVisibility(View.VISIBLE);
                        }
                    } else {
                        Log.w("Query log", "Query failed");
                    }
                }
            });
        }};

    }


}
