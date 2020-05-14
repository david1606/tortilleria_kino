package com.aadev.tortilleriakino.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Adapters.OrderAdapter;
import com.aadev.tortilleriakino.Classes.Clients;
import com.aadev.tortilleriakino.Classes.Keys;
import com.aadev.tortilleriakino.ClientViewActivity;
import com.aadev.tortilleriakino.OrderActivity;
import com.aadev.tortilleriakino.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class SellFragment extends Fragment {

    private ArrayList<Clients> clientsList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ProgressBar mainProgressBar;
    private String userN;
    private Context context;
    private String UID = "";

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sell, container, false);

        context = inflater.getContext();

        mRecyclerView = root.findViewById(R.id.recycler_view_sell);
        mainProgressBar = root.findViewById(R.id.progress_sell_fragment);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        UID = currentUser.getUid();


        clientsList = this.getClientsInfo();
        // Toast.makeText(inflater.getContext(), "User:" + UID, Toast.LENGTH_SHORT).show();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(inflater.getContext());
        mAdapter = new OrderAdapter(clientsList, R.layout.item_client_sell, new OrderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Clients client, int position) {
                Intent orderAct = new Intent(inflater.getContext(), ClientViewActivity.class);
                int[] list = new int[]{client.getDefaults().get(0),
                        client.getDefaults().get(1),
                        client.getDefaults().get(2),
                        client.getDefaults().get(3),
                        client.getDefaults().get(4),
                        client.getDefaults().get(5),
                        client.getDefaults().get(6),
                        client.getDefaults().get(7),
                        client.getDefaults().get(8),
                        client.getDefaults().get(9),
                        client.getDefaults().get(10)};
                orderAct.putExtra(new Keys().getCLIENT_KEY(), client.getClient_name());
                orderAct.putExtra(new Keys().getDEFAULT_VALUES_KEY(), list);
                orderAct.putExtra(new Keys().getDOC_REF_KEY(), client.getDoc_ref());
                startActivity(orderAct);
            }
        }, new OrderAdapter.OnButtonClickListener() {
            @Override
            public void onItemClick(Clients client, int position) {
                Intent orderAct = new Intent(inflater.getContext(), OrderActivity.class);
                int[] list = new int[]{client.getDefaults().get(0),
                        client.getDefaults().get(1),
                        client.getDefaults().get(2),
                        client.getDefaults().get(3),
                        client.getDefaults().get(4),
                        client.getDefaults().get(5),
                        client.getDefaults().get(6),
                        client.getDefaults().get(7),
                        client.getDefaults().get(8),
                        client.getDefaults().get(9),
                        client.getDefaults().get(10)};
                orderAct.putExtra(new Keys().getCLIENT_KEY(), client.getClient_name());
                orderAct.putExtra(new Keys().getDEFAULT_VALUES_KEY(), list);
                orderAct.putExtra(new Keys().getDOC_REF_KEY(), client.getDoc_ref());
                startActivity(orderAct);
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        //Toast.makeText(inflater.getContext(), "Array: " + clientsList.size(), Toast.LENGTH_SHORT).show();
        return root;
    }


    private ArrayList<Clients> getClientsInfo() {

        Log.w("Query log", "IN query");
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        switch (UID) {
            case "p62AtFmPPPWHkgEoFU3hQ4HnG5I3":
                userN = "1";
                Log.d("KEY", "One");
                break;
            case "ZSiu55avlAcuJ9eGZTtTqxfmR5w2":
                userN = "2";
                Log.d("KEY", "two");
                break;
            case "Zis5ROO8jgWfpaYVEpqKbO7hKIw2":
                userN = "3";
                Log.d("KEY", "three");
                break;
            default:
                Toast.makeText(context, "unknown: " + UID, Toast.LENGTH_SHORT).show();
                Log.e("Error: ", "unknown: " + UID);
        }
        //Log.w("KEY:HELP", userN);

        Toast.makeText(context, "UserN: " + userN, Toast.LENGTH_SHORT).show();

        final Query feedQuery = db.collection("clients").whereEqualTo("clientID", userN);

        return new ArrayList<Clients>() {{
            feedQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())) {
                            Clients query = documentSnapshot.toObject(Clients.class);
                            query.setDoc_ref(documentSnapshot.getId());
                            clientsList.add(query);
                            mAdapter.notifyDataSetChanged();
                            mRecyclerView.setVisibility(View.VISIBLE);
                            mainProgressBar.setVisibility(View.GONE);
                        }
                    } else {
                        Log.w("Query log", "Query failed");
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }};
    }

    private void checkUser() {

    }

}
