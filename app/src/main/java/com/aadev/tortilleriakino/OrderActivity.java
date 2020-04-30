package com.aadev.tortilleriakino;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Adapters.ItemsAdapter;
import com.aadev.tortilleriakino.Classes.ItemSell;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    private String client;
    private ArrayList<ItemSell> articels;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private TextView clientName;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mRecyclerView = findViewById(R.id.recycler_view_order);
        clientName = findViewById(R.id.client_name);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            client = bundle.getString("CLIENT");
            clientName.setText(client);
        }
        articels = new ArrayList<ItemSell>() {{
        }};
        articels.add(new ItemSell("Hello", 20, 0));
        articels.add(new ItemSell("Hello", 21, 0));
        articels.add(new ItemSell("Hello", 22, 0));
        articels.add(new ItemSell("Hello", 23, 0));
        articels.add(new ItemSell("Hello", 25, 0));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemsAdapter(articels, new ItemsAdapter.OnAddItemClickListener() {
            @Override
            public void onItemClick(ItemSell itemSell, int position) {
                int newQuantity = itemSell.getQuantity() + 1;
                articels.get(position).setQuantity(newQuantity);
                mAdapter.notifyDataSetChanged();
            }
        }, new ItemsAdapter.OnRemoveItemClickListener() {
            @Override
            public void onItemClick(ItemSell itemSell, int position) {
                int newQuantity = itemSell.getQuantity() - 1;
                articels.get(position).setQuantity(newQuantity);
                mAdapter.notifyDataSetChanged();
            }
        }, new ItemsAdapter.OnKeyListener() {
            @Override
            public void onKeyClick(ItemSell itemSell, int position) {
                int newQuantity = itemSell.getQuantity() - 1;
                articels.get(position).setQuantity(newQuantity);
                Toast.makeText(OrderActivity.this, "Tiping in " + position, Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
