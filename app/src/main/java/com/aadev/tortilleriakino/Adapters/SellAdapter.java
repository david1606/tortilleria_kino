package com.aadev.tortilleriakino.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Classes.Clients;
import com.aadev.tortilleriakino.R;

import java.util.ArrayList;

public class SellAdapter extends RecyclerView.Adapter<SellAdapter.ViewHolder> {

    private ArrayList<Clients> clientsList;
    private SellAdapter.OnItemClickListener itemClickListener;

    public SellAdapter(ArrayList<Clients> clientsList, OnItemClickListener itemClickListener) {
        this.clientsList = clientsList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SellAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_client_sell, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SellAdapter.ViewHolder holder, int position) {
        holder.bind(clientsList.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return clientsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView clientName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            clientName = itemView.findViewById(R.id.item_client_sell_name);
        }

        void bind(final Clients clients, final OnItemClickListener itemClickListener) {
            clientName.setText(clients.getClient_name());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(clients, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Clients clients, int position);
    }
}
