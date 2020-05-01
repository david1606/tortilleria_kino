package com.aadev.tortilleriakino.Classes;

public class Articles {
    private String article;
    private double price;
    private int quantity;

    public Articles(String article, double price, int quantity) {
        this.article = article;
        this.price = price;
        this.quantity = quantity;
    }


    public String getArticle() {
        return article;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
