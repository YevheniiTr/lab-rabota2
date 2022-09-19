package com.example.kp_db.Class;

public class Client {



    private int idClient;
    private String   name;
    private String surname;
    private String patronymic;
    private String mobPhone;
    private String email;
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
    public Client(int id_Client, String name, String surname, String patronymic, String mobPhone, String email) {
        this.idClient = id_Client;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.mobPhone = mobPhone;
        this.email = email;
    }
}
