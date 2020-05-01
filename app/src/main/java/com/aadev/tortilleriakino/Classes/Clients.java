package com.aadev.tortilleriakino.Classes;

public class Clients {

    private String client_name;
    private String sector;
    private String clientID;
    private int[] defaults;

    public int[] getDefaults() {
        return defaults;
    }

    public void setDefaults(int[] defaults) {
        this.defaults = defaults;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
}
