package com.aadev.tortilleriakino.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Classes.Articles;
import com.aadev.tortilleriakino.Classes.Clients;
import com.aadev.tortilleriakino.R;

import java.util.ArrayList;

public class OrderViewAdapter extends RecyclerView.Adapter<OrderViewAdapter.ViewHolder> {

    private ArrayList<Articles> articlesArrayList;

    public OrderViewAdapter(ArrayList<Articles> articlesArrayList) {
        this.articlesArrayList = articlesArrayList;
    }

    @NonNull
    @Override
    public OrderViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewAdapter.ViewHolder holder, int position) {
        holder.bind(articlesArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView subtotal, price, qty, article;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            subtotal = itemView.findViewById(R.id.subtotal_article_view);
            price = itemView.findViewById(R.id.price_article_view);
            qty = itemView.findViewById(R.id.quantity_article_view);
            article = itemView.findViewById(R.id.article_name_view);
        }

        void bind(Articles articles) {
            price.setText(String.valueOf(articles.getPrice()));
            article.setText(articles.getArticle());
            qty.setText(String.valueOf(articles.getQuantity()));
            subtotal.setText(String.valueOf(articles.getPrice() * articles.getQuantity()));
        }
    }
}
