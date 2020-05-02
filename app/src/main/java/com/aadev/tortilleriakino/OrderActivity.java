package com.aadev.tortilleriakino;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Adapters.ItemsAdapter;
import com.aadev.tortilleriakino.Classes.Articles;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private String client;
    private int[] defaults;
    private ArrayList<Articles> articels;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private TextView clientName, totalET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mRecyclerView = findViewById(R.id.recycler_view_order);
        clientName = findViewById(R.id.client_name);
        totalET = findViewById(R.id.total_text);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            client = bundle.getString("CLIENT");
            clientName.setText(client);
            defaults = bundle.getIntArray("DEFAULTS");
        }
        articels = new ArrayList<Articles>() {{
        }};
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


        updateTotalPrice();
        ;

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemsAdapter(articels, new ItemsAdapter.OnAddItemClickListener() {
            @Override
            public void onItemClick(Articles articles, int position) {
                int newQuantity = articles.getQuantity() + 1;
                articels.get(position).setQuantity(newQuantity);
                mAdapter.notifyDataSetChanged();
                updateTotalPrice();
            }
        }, new ItemsAdapter.OnRemoveItemClickListener() {
            @Override
            public void onItemClick(Articles articles, int position) {
                int newQuantity = articles.getQuantity() - 1;
                articels.get(position).setQuantity(newQuantity);
                mAdapter.notifyDataSetChanged();
                updateTotalPrice();
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void updateTotalPrice() {
        double total = 0;
        for (int i = 0; i < articels.size(); i++) {
            double price = articels.get(i).getPrice();
            int quantity = articels.get(i).getQuantity();
            total = total + (price * quantity);
        }
        totalET.setText("$" + total);

    }

    boolean option = false;

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("¿Salir?")
                .setMessage("¿Esta seguro que desea salir?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent orderAct = new Intent(OrderActivity.this, ClientViewActivity.class);
                        orderAct.putExtra("CLIENT", client);
                        //orderAct.putExtra("DEFAULTS", new int[]{1, 2, 3});
                        startActivity(orderAct);
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert);
        alert.show();


    }

    public void out(View view) {
        onBackPressed();
    }
}
