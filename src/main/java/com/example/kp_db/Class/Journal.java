package com.example.kp_db.Class;

public class Journal {


    private int id;
    private String  time;
    private String login;
    private int role;
    private String text;

    public Journal(int id,String time, String login, int role, String text) {
        this.id = id;
        this.time = time;
        this.login = login;
        this.role = role;
        this.text = text;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
