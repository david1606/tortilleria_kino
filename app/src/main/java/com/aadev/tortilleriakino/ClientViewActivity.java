package com.aadev.tortilleriakino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ClientViewActivity extends AppCompatActivity {
    private String client;
    private int[] defaults;
    private FloatingActionButton orderFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients_view);

        orderFloatingActionButton = findViewById(R.id.fab_order);
        TextView clientName = findViewById(R.id.client_name);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            client = bundle.getString("CLIENT");
            clientName.setText(client);
            defaults = bundle.getIntArray("DEFAULTS");
        }


        orderFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderAct = new Intent(ClientViewActivity.this, OrderActivity.class);
                orderAct.putExtra("CLIENT", client);
                orderAct.putExtra("DEFAULTS", defaults);
                startActivity(orderAct);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void out(View view) {
        onBackPressed();
    }
}
