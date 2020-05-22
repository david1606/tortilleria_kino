package com.aadev.tortilleriakino.Classes;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Sell {
    private @ServerTimestamp
    Date sell_date;
    private String docRef;
    private String seller;
    private List<String> articles;
    private double total;

    public Sell(Date sell_date, String docRef, List<String> articles, double total) {
        this.sell_date = sell_date;
        this.docRef = docRef;
        this.articles = articles;
        this.total = total;
    }

    public Sell() {

    }

    public Date getSell_date() {
        return sell_date;
    }

    public void setSell_date(Date sell_date) {
        this.sell_date = sell_date;
    }

    public String getDocRef() {
        return docRef;
    }

    public void setDocRef(String docRef) {
        this.docRef = docRef;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
