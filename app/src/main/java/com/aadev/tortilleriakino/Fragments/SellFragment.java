package com.aadev.tortilleriakino.Fragments;

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

import com.aadev.tortilleriakino.Adapters.SellAdapter;
import com.aadev.tortilleriakino.Classes.Clients;
import com.aadev.tortilleriakino.OrderActivity;
import com.aadev.tortilleriakino.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sell, container, false);

        mRecyclerView = root.findViewById(R.id.recycler_view_sell);
        mainProgressBar = root.findViewById(R.id.progress_sell_fragment);
        clientsList = this.getClientsInfo();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(inflater.getContext());
        mAdapter = new SellAdapter(clientsList, new SellAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Clients client, int position) {
                Intent orderAct = new Intent(inflater.getContext(), OrderActivity.class);
                orderAct.putExtra("CLIENT", client.getClient_name());
                orderAct.putExtra("DEFAULTS", new int[]{1, 2, 3});
                startActivity(orderAct);
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

    private ArrayList<Clients> getClientsInfo() {
        Log.w("Query log", "IN query");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final Query feedQuery = db.collection("clients");
        return new ArrayList<Clients>() {{
            feedQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot documentSnapshot : Objects.requireNonNull(task.getResult())) {
                            Clients query = documentSnapshot.toObject(Clients.class);
                            clientsList.add(query);
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
}
