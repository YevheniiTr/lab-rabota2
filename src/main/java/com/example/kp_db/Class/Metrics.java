package com.example.kp_db.Class;

public class Metrics {
    private int ID_order;
    private int impressions;
    private int clicks;
    private int  unicUsers;

    public Metrics(int ID_order, int impressions, int clicks, int unicUsers) {
        this.ID_order = ID_order;
        this.impressions = impressions;
        this.clicks = clicks;
        this.unicUsers = unicUsers;
    }

    public int getID_order() {
        return ID_order;
    }

    public void setID_order(int ID_order) {
        this.ID_order = ID_order;
    }

    public int getImpressions() {
        return impressions;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getUnicUsers() {
        return unicUsers;
    }

    public void setUnicUsers(int unicUsers) {
        this.unicUsers = unicUsers;
    }
}
