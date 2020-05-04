package com.aadev.tortilleriakino;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aadev.tortilleriakino.Classes.Keys;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ClientViewActivity extends AppCompatActivity {


    private String client, docRef;
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
            client = bundle.getString(new Keys().getCLIENT_KEY());
            defaults = bundle.getIntArray(new Keys().getDEFAULT_VALUES_KEY());
            docRef = bundle.getString(new Keys().getDOC_REF_KEY());
            clientName.setText(client);
            Toast.makeText(this, docRef, Toast.LENGTH_SHORT).show();
        }

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

    @Override
    public void onBackPressed() {
        Intent orderAct = new Intent(ClientViewActivity.this, MainActivity.class);
        startActivity(orderAct);
    }

    public void out(View view) {
        onBackPressed();
    }
}
