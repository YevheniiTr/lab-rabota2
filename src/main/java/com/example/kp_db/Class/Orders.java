package com.example.kp_db.Class;

import java.util.Date;

public class Orders {
    private int ID_order;
    private int IDClient;
    private int IDEmployee;
    private int ID_order_type;
    private Date orderDate;
    private Date delieveryDate;
    private  float cost;
    private String orderName;



    public Orders(int id_order, int idClient, int idEmployee, java.sql.Date orderDate, java.sql.Date delieveryDate, int id_order_type,float cost, String nameOrder) {
        this.ID_order=id_order;
        this.IDClient=idClient;
        this.IDEmployee=idEmployee;
        this.orderDate=orderDate;
        this.delieveryDate = delieveryDate;
        this.ID_order_type = id_order_type;
        this.cost = cost;
        this.orderName = nameOrder;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDelieveryDate() {
        return delieveryDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setDelieveryDate(Date delieveryDate) {
        this.delieveryDate = delieveryDate;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getID_order() {
        return ID_order;
    }

    public void setID_order(int ID_order) {
        this.ID_order = ID_order;
    }

    public int getIDClient() {
        return IDClient;
    }

    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }

    public int getIDEmployee() {
        return IDEmployee;
    }

    public void setIDEmployee(int IDEmployee) {
        this.IDEmployee = IDEmployee;
    }

    public int getID_order_type() {
        return ID_order_type;
    }

    public void setID_order_type(int ID_order_type) {
        this.ID_order_type = ID_order_type;
    }



    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}

