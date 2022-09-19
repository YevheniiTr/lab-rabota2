package com.example.kp_db.Class;

import java.sql.*;


public class DatabaseHandler {
    protected  String USER_NAME = "root";
    protected  String PASSWORD = "YevheniiTR0918";
    protected  String URL  = "jdbc:mysql://localhost:3306/advertisingagency";
    protected  String dbName = "advertisingagency";
    Connection dbConnection;
    public  Connection getDbConnection() throws ClassNotFoundException,SQLException{
        String connectionString = URL;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,USER_NAME,PASSWORD);
        return dbConnection;
    }
    public void signUpUser(User user){
        String insert2 = "INSERT INTO  USERS (login,pass)  VALUES (?,?)";

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_LOGIN + ","
                + Const.USERS_PASSWORD + ")" + "VALUES(?,?)";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(insert2);
            prST.setString(1, user.getLogin());
            prST.setString(2, user.getPassword());
            prST.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD
                + "=? and uRole = 2" ;
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST = getDbConnection().prepareStatement(select);
            prST.setString(1, user.getLogin());
            prST.setString(2, user.getPassword());
             resSet = prST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public ResultSet getAdmin(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD
                + "=? and uRole = 1" ;
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST = getDbConnection().prepareStatement(select);
            prST.setString(1, user.getLogin());
            prST.setString(2, user.getPassword());
            resSet = prST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public ResultSet get4Role(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_LOGIN + "=? AND " + Const.USERS_PASSWORD
                + "=? and uRole = 3" ;
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST = getDbConnection().prepareStatement(select);
            prST.setString(1, user.getLogin());
            prST.setString(2, user.getPassword());
            resSet = prST.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
