package com.aadev.tortilleriakino.Classes;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.Map;

public class Sell {
    private @ServerTimestamp
    Date sell_date;
    private Map<String, Object> articles;
    private String total;

    public Sell(Date sell_date, Map<String, Integer> articles, String total) {
        this.sell_date = sell_date;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
