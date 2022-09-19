package com.example.kp_db.Class;

public class User {
    private int id;
    private int role;

    private String login;
    private String password;
    private String name;
    private String surname;
    private String company;
    private String mobilePhone;
    private String patronymic;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        name = null;
        surname = null;
        company = null;
        mobilePhone = null;
        patronymic = null;
    }

    public User(String login, String password, String name, String surname,
                String company, String mobilePhone, String patronymic) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.mobilePhone = mobilePhone;
        this.patronymic = patronymic;
    }

    public User(int id, String login, String password, int role) {
        this.login = login;
        this.password = password;
        this.id = id;
        this.role = role;
    }



    public User() {

    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
