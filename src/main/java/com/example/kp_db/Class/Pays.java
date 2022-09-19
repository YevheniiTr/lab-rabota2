package com.example.kp_db.Class;

import java.util.Date;

public class Pays {
    private int idPay;
    private int idOrder;
    private float pay;
    private  Date payDate;

    public Pays(int idPay, int idOrder, float pay, Date payDate) {
        this.idPay = idPay;
        this.idOrder = idOrder;
        this.pay = pay;
        this.payDate = payDate;
    }

    public Pays(int idPay, float pay, Date payDate) {
        this.idPay = idPay;
        this.pay = pay;
        this.payDate = payDate;
    }

    public int getIdPay() {
        return idPay;
    }

    public void setIdPay(int idPay) {
        this.idPay = idPay;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}
