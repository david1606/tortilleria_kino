/*
package com.aadev.tortilleriakino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aadev.tortilleriakino.Classes.Clients;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TempoActivity extends AppCompatActivity {
    private ArrayList<Clients> clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo);

        clients = new ArrayList<Clients>() {{
        }};

    }

    public void clickone(View view) {
        clients.add(new Clients("1", "David", Arrays.asList(4, 2, 2)));
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        for (int i = 0; i < clients.size(); i++) {
            Clients client = clients.get(i);
            db.collection("test1").add(client)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(TempoActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        clients.clear();
    }

    public void clicktwo(View view) {
        clients.add(new Clients("1", "Andres", Arrays.asList(4, 2, 2)));
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        for (int i = 0; i < clients.size(); i++) {
            Clients client = clients.get(i);
            db.collection("test2").add(client)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(TempoActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        clients.clear();
    }
}
*/
