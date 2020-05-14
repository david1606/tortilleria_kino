package com.aadev.tortilleriakino.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Classes.Articles;
import com.aadev.tortilleriakino.R;

import java.util.ArrayList;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    private ArrayList<Articles> articles;
    private OnAddItemClickListener addItemClickListener;
    private OnRemoveItemClickListener removeItemClickListener;

    public ArticlesAdapter(ArrayList<Articles> articles,
                           OnAddItemClickListener addItemClickListener,
                           OnRemoveItemClickListener removeItemClickListener) {
        this.articles = articles;
        this.addItemClickListener = addItemClickListener;
        this.removeItemClickListener = removeItemClickListener;
    }

    @NonNull
    @Override
    public ArticlesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_products, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesAdapter.ViewHolder holder, int position) {
        holder.bind(articles.get(position), addItemClickListener, removeItemClickListener);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView article, numberArticles, price;
        ImageView add, remove;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            article = itemView.findViewById(R.id.text_view_product_name);
            add = itemView.findViewById(R.id.add_button);
            remove = itemView.findViewById(R.id.remove_button);
            numberArticles = itemView.findViewById(R.id.edit_text_number_articles);
            price = itemView.findViewById(R.id.text_view_price);
        }

        void bind(final Articles articles,
                  final OnAddItemClickListener addItemClickListener,
                  final OnRemoveItemClickListener removeItemClickListener) {
            article.setText(articles.getArticle());
            price.setText("$" + articles.getPrice());

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItemClickListener.onItemClick(articles, getAdapterPosition());
                }
            });
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItemClickListener.onItemClick(articles, getAdapterPosition());
                }
            });
            numberArticles.setText(articles.getQuantity() + "");
        }
    }

    public interface OnRemoveItemClickListener {
        void onItemClick(Articles articles, int position);
    }

    public interface OnAddItemClickListener {
        void onItemClick(Articles articles, int position);
    }
}
