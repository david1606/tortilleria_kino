package com.aadev.tortilleriakino.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Classes.Clients;
import com.aadev.tortilleriakino.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private ArrayList<Clients> clientsList;
    private int layout;
    private OrderAdapter.OnItemClickListener itemClickListener;
    private OrderAdapter.OnButtonClickListener buttonClickListener;

    public OrderAdapter(ArrayList<Clients> clientsList, int layout, OnItemClickListener itemClickListener, OnButtonClickListener buttonClickListener) {
        this.layout=layout;
        this.clientsList = clientsList;
        this.itemClickListener = itemClickListener;
        this.buttonClickListener = buttonClickListener;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        holder.bind(clientsList.get(position), itemClickListener, buttonClickListener);
    }

    @Override
    public int getItemCount() {
        return clientsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView clientName;
        Button orderButton;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            clientName = itemView.findViewById(R.id.item_client_sell_name);
            orderButton = itemView.findViewById(R.id.buutton_order_rv);
        }

        void bind(final Clients clients, final OnItemClickListener itemClickListener, final OnButtonClickListener buttonClickListener) {
            clientName.setText(clients.getClient_name());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(clients, getAdapterPosition());
                }
            });

            orderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClickListener.onItemClick(clients, getAdapterPosition());
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(Clients clients, int position);
    }

    public interface OnButtonClickListener {
        void onItemClick(Clients clients, int position);
    }
}
