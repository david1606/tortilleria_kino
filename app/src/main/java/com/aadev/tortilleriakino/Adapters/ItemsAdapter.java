package com.aadev.tortilleriakino.Adapters;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aadev.tortilleriakino.Classes.ItemSell;
import com.aadev.tortilleriakino.R;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private ArrayList<ItemSell> articles;
    private OnAddItemClickListener addItemClickListener;
    private OnRemoveItemClickListener removeItemClickListener;
    private OnKeyListener keyListener;

    public ItemsAdapter(ArrayList<ItemSell> articles,
                        OnAddItemClickListener addItemClickListener,
                        OnRemoveItemClickListener removeItemClickListener,
                        OnKeyListener keyListener) {
        this.articles = articles;
        this.addItemClickListener = addItemClickListener;
        this.removeItemClickListener = removeItemClickListener;
        this.keyListener = keyListener;

    }

    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_products, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        holder.bind(articles.get(position), addItemClickListener, removeItemClickListener, keyListener);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView article;
        ImageView add, remove;
        EditText numberArticles;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            article = itemView.findViewById(R.id.text_view_product_name);
            add = itemView.findViewById(R.id.add_button);
            remove = itemView.findViewById(R.id.remove_button);
            numberArticles = itemView.findViewById(R.id.edit_text_number_articles);

        }

        void bind(final ItemSell itemSell,
                  final OnAddItemClickListener addItemClickListener,
                  final OnRemoveItemClickListener removeItemClickListener,
                  final OnKeyListener keyListener) {
            article.setText(itemSell.getArticle());

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItemClickListener.onItemClick(itemSell, getAdapterPosition());
                }
            });
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItemClickListener.onItemClick(itemSell, getAdapterPosition());
                }
            });
            numberArticles.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    keyListener.onKeyClick(itemSell, getAdapterPosition());
                    return false;
                }
            });
            numberArticles.setText(itemSell.getQuantity() + "");
        }
    }

    public interface OnRemoveItemClickListener {
        void onItemClick(ItemSell itemSell, int position);
    }

    public interface OnAddItemClickListener {
        void onItemClick(ItemSell itemSell, int position);
    }

    public interface OnKeyListener {
        void onKeyClick(ItemSell itemSell, int position);
    }
}
