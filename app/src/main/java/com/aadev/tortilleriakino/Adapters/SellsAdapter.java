package com.aadev.tortilleriakino.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Classes.Sell;
import com.aadev.tortilleriakino.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SellsAdapter extends RecyclerView.Adapter<SellsAdapter.ViewHolder> {

    private ArrayList<Sell> items;
    private SellsAdapter.onItemClickListeer onItemClickListeer;

    public SellsAdapter(ArrayList<Sell> item, SellsAdapter.onItemClickListeer onItemClickListeer) {
        this.items = item;
        this.onItemClickListeer = onItemClickListeer;
    }

    @NonNull
    @Override
    public SellsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_take_out, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SellsAdapter.ViewHolder holder, int position) {
        holder.bind(items.get(position), onItemClickListeer);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date, total;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.text_view_sell_date);
            total = itemView.findViewById(R.id.text_view_total_price);

        }

        void bind(final Sell item, final onItemClickListeer onItemClickListeer) {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm a");
            date.setText(sdf.format(item.getSell_date()));
            total.setText(String.valueOf(item.getTotal()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListeer.onItemClick(item, getAdapterPosition());
                }
            });

        }
    }

    public interface onItemClickListeer {
        void onItemClick(Sell item, int position);
    }
}
