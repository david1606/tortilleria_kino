package com.aadev.tortilleriakino;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    private String client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            client = bundle.getString("CLIENT");
        }
        Toast.makeText(this, client, Toast.LENGTH_SHORT).show();
        setTitle("Orden para " + client);
    }
}
