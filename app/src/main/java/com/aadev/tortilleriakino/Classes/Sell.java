package com.aadev.tortilleriakino.Classes;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.Map;

public class Sell {
    private @ServerTimestamp
    Date sell_date;
    private Map<String, Object> articles;
    private double total;

    public Sell(Date sell_date, Map<String, Object> articles, double total) {
        this.sell_date = sell_date;
        this.articles = articles;
        this.total = total;
    }

    public Sell(){

    }

    public Date getSell_date() {
        return sell_date;
    }

    public void setSell_date(Date sell_date) {
        this.sell_date = sell_date;
    }

    public Map<String, Object> getArticles() {
        return articles;
    }

    public void setArticles(Map<String, Object> articles) {
        this.articles = articles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
