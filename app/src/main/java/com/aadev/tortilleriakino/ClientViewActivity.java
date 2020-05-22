package com.aadev.tortilleriakino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aadev.tortilleriakino.Adapters.SellsAdapter;
import com.aadev.tortilleriakino.Classes.Articles;
import com.aadev.tortilleriakino.Classes.Clients;
import com.aadev.tortilleriakino.Classes.Keys;
import com.aadev.tortilleriakino.Classes.Sell;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class ClientViewActivity extends AppCompatActivity {

    private ProgressBar mainProgressBar;
    private String client, docRef, sellDocRef;
    private int[] defaults;
    private ArrayList<Sell> item;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_view);

        FloatingActionButton orderFloatingActionButton = findViewById(R.id.fab_order);
        TextView clientName = findViewById(R.id.client_name);
        mainProgressBar = findViewById(R.id.progress_bar_orders);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            client = bundle.getString(new Keys().getCLIENT_KEY());
            defaults = bundle.getIntArray(new Keys().getDEFAULT_VALUES_KEY());
            docRef = bundle.getString(new Keys().getDOC_REF_KEY());
            clientName.setText(client);
            Toast.makeText(this, docRef, Toast.LENGTH_SHORT).show();
        }

        mRecyclerView = findViewById(R.id.sells_rv);
        item = getSellsInfo();
        createRecyclerView();


        orderFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderAct = new Intent(ClientViewActivity.this, OrderActivity.class);
                orderAct.putExtra(new Keys().getCLIENT_KEY(), client);
                orderAct.putExtra(new Keys().getDEFAULT_VALUES_KEY(), defaults);
                orderAct.putExtra(new Keys().getDOC_REF_KEY(), docRef);
                startActivity(orderAct);
            }
        });
    }

    private ArrayList<Sell> getSellsInfo() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        //                                                  /clients/00vyttdMiRZwB1L3EFjT/ventas
        final Query feedQuery = db.collection("clients/" + docRef + "/sells/").orderBy("sell_date", Query.Direction.DESCENDING);
        return new ArrayList<Sell>() {{
            feedQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())) {
                            Sell query = documentSnapshot.toObject(Sell.class);
                            query.setDocRef(documentSnapshot.getId());
                            item.add(query);
                            mAdapter.notifyDataSetChanged();
                            mRecyclerView.setVisibility(View.VISIBLE);
                            mainProgressBar.setVisibility(View.GONE);
                        }
                    } else {
                        Log.w("Query log", "Query failed");
                    }
                }
            });
        }};
    }

    private void createRecyclerView() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SellsAdapter(item, new SellsAdapter.onItemClickListeer() {
            @Override
            public void onItemClick(Sell item, int position) {
                Intent orderAct = new Intent(ClientViewActivity.this, ViewSellActivity.class);
                orderAct.putExtra(new Keys().getCLIENT_KEY(), client);
                orderAct.putExtra(new Keys().getDEFAULT_VALUES_KEY(), defaults);
                orderAct.putExtra(new Keys().getSellDocRef(), item.getDocRef());
                orderAct.putExtra(new Keys().getDOC_REF_KEY(), docRef);
                startActivity(orderAct);
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent orderAct = new Intent(ClientViewActivity.this, MainActivity.class);
        startActivity(orderAct);
    }

    public void out(View view) {
        onBackPressed();
    }
}
