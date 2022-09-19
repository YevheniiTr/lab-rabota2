package com.example.kp_db.Class;

import java.util.Date;

public class makeOrder {
    private int id_makeOrder;
    private  java.util.Date stageDate;
    private String stageType;

    private int  IDEmployee;
    private int IDOrder;

    public makeOrder(int id_makeOrder, Date stageDate, String stageType, int IDEmployee, int IDOrder) {
        this.id_makeOrder = id_makeOrder;
        this.IDEmployee = IDEmployee;
        this.IDOrder = IDOrder;
        this.stageDate = stageDate;
        this.stageType = stageType;
    }



    public int getId_makeOrder() {
        return id_makeOrder;
    }

    public void setId_makeOrder(int id_makeOrder) {
        this.id_makeOrder = id_makeOrder;
    }

    public Date getStageDate() {
        return stageDate;
    }

    public void setStageDate(Date stageDate) {
        this.stageDate = stageDate;
    }

    public String getStageType() {
        return stageType;
    }

    public void setStageType(String stageType) {
        this.stageType = stageType;
    }


    public int getIDEmployee() {
        return IDEmployee;
    }

    public void setIDEmployee(int IDEmployee) {
        this.IDEmployee = IDEmployee;
    }

    public int getIDOrder() {
        return IDOrder;
    }

    public void setIDOrder(int IDOrder) {
        this.IDOrder = IDOrder;
    }
}
