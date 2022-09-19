package com.example.kp_db.Class;

import java.util.Date;

public class Employee {
    private int id_Employee;
    private String name;
    private String surname;
    private String patronymic;
    private String mobPhone;
    private String email;
    private String addres;
    private java.util.Date date_start_work;

    public Employee(int id_Employee, String name, String surname, String patronymic, String mobPhone, String addres, String email, Date date_start_work) {
        this.id_Employee = id_Employee;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mobPhone = mobPhone;
        this.email = email;
        this.addres = addres;
        this.date_start_work = date_start_work;
    }

    public Date getDate_start_work() {
        return date_start_work;
    }

    public void setDate_start_work(Date date_start_work) {
        this.date_start_work = date_start_work;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }


    public int getId_Employee() {
        return id_Employee;
    }

    public void setId_Employee(int id_Employee) {
        this.id_Employee = id_Employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(int id_Employee, String name, String surname, String patronymic, String mobPhone, String email, String addres) {
        this.id_Employee = id_Employee;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mobPhone = mobPhone;
        this.email = email;
        this.addres = addres;
    }

    public Employee(String name, String surname, String patronymic, String mobPhone, String email, String addres) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mobPhone = mobPhone;
        this.email = email;
        this.addres = addres;
    }

}

