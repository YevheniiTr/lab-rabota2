package com.example.kp_db.Class;

import java.util.Date;

public class Specialist {
     private int idEmployee;
     private int idAct;
     private int bonus;
     private double salary;
     private int  ordersDone;
     private int prinesenoOrder;
     private Date salaryDate;

    public Specialist(int idEmployee, int idAct, int bonus, double salary, int ordersDone, int getOrder, Date salaryDate) {
        this.idEmployee = idEmployee;
        this.idAct = idAct;
        this.bonus = bonus;
        this.salary = salary;
        this.ordersDone = ordersDone;
        this.prinesenoOrder = getOrder;
        this.salaryDate = salaryDate;
    }

    public int getPrinesenoOrder() {
        return prinesenoOrder;
    }

    public void setPrinesenoOrder(int prinesenoOrder) {
        this.prinesenoOrder = prinesenoOrder;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdAct() {
        return idAct;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getOrdersDone() {
        return ordersDone;
    }

    public void setOrdersDone(int ordersDone) {
        this.ordersDone = ordersDone;
    }





    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }
}
