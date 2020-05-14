package com.aadev.tortilleriakino.Classes;

public class Articles {
    private String article;
    private double price;
    private int quantity;
    private String code;

    public Articles() {

    }

    public Articles(String article, double price, String code) {
        this.article = article;
        this.price = price;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
