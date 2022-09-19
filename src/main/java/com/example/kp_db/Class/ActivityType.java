package com.example.kp_db.Class;

public class ActivityType {

    private int  id;
    private String typeAct;
    private int workingRate;

    public ActivityType(int id, String typeAct, int workingRate) {
        this.id = id;
        this.typeAct = typeAct;
        this.workingRate = workingRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeAct() {
        return typeAct;
    }

    public void setTypeAct(String typeAct) {
        this.typeAct = typeAct;
    }

    public int getWorkingRate() {
        return workingRate;
    }

    public void setWorkingRate(int workingRate) {
        this.workingRate = workingRate;
    }
}
