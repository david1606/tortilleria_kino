package com.aadev.tortilleriakino.Classes;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.List;

public class Clients {
    private String clientID;
    private String client_name;
    private List<Integer> defaults;
    private String doc_ref;
    private @ServerTimestamp
    Date last_ordered_day;


    private Clients() {
    }

    public Clients(String clientID, String client_name, List<Integer> defaults, String doc_ref) {
        this.clientID = clientID;
        this.client_name = client_name;
        this.defaults = defaults;
        this.doc_ref = doc_ref;
    }

    public String getDoc_ref() {
        return doc_ref;
    }

    public void setDoc_ref(String doc_ref) {
        this.doc_ref = doc_ref;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public List<Integer> getDefaults() {
        return defaults;
    }

    public void setDefaults(List<Integer> defaults) {
        this.defaults = defaults;
    }

    public Date getLast_ordered_day() {
        return last_ordered_day;
    }

    public void setLast_ordered_day(Date last_ordered_day) {
        this.last_ordered_day = last_ordered_day;
    }
}
