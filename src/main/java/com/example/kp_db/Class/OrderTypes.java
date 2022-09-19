package com.example.kp_db.Class;

public class OrderTypes {
    private int id_orTP;
    private int cost;
    private String orderType;

    public OrderTypes(int id_orTP, int cost, String orderType) {
        this.id_orTP = id_orTP;
        this.cost = cost;
        this.orderType = orderType;
    }

    public int getId_orTP() {
        return id_orTP;
    }

    public void setId_orTP(int id_orTP) {
        this.id_orTP = id_orTP;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
