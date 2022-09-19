package com.example.kp_db.Class;

public class ClassBAZA {

    private  float salary;
    private int avgImpr;
    private int avgClicks;
    private int avgUsers;
    private String orderType;
    private  float sumDays;
    private int ID_order;
    private int IDClient;
    private int IDEmployee;
    private int ID_order_type;
    private String orderDate;
    private String delieveryDate;
    private  float orderCost;
    private String orderName;
    private String stageType;
    private String name;
    private String surname;
    private String patronymic;
    private String startWorkDate;
    private String typeActv;
    private String mobPhone;
    private int count;
    private int getOrders;
    private String comment;
    private  float cost;


    public ClassBAZA( String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public ClassBAZA(int ID_order, String orderName, int ID_order_type) {
        this.orderName = orderName;
        this.ID_order = ID_order;
        this.ID_order_type = ID_order_type;
    }

    public ClassBAZA(int ID_order, int IDClient, int IDEmployee, String orderDate, String delieveryDate, float cost, int ID_order_type , String orderName, String stageType) {
        this.ID_order = ID_order;
        this.IDClient = IDClient;
        this.IDEmployee = IDEmployee;
        this.ID_order_type = ID_order_type;
        this.orderDate = orderDate;
        this.delieveryDate = delieveryDate;
        this.orderCost = cost;
        this.orderName = orderName;
        this.stageType = stageType;
    }
   // nameOrder,OrderType,orderDate,deliveryDate,avg(impressions), \n" +
        //    "avg( clicks),avg(unicUsers)
    public ClassBAZA(String orderName,String orderType, String orderDate,String delieveryDate, int avgImpr, int avgClicks, int avgUsers) {
        this.avgImpr = avgImpr;
        this.avgClicks = avgClicks;
        this.avgUsers = avgUsers;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.orderName = orderName;
        this.delieveryDate = delieveryDate;
    }

    public ClassBAZA(int avgImpr, int avgClicks, int avgUsers, String orderType) {
        this.avgImpr = avgImpr;
        this.avgClicks = avgClicks;
        this.avgUsers = avgUsers;
        this.orderType = orderType;
    }

    public ClassBAZA(String orderType, float sumDays) {
        this.orderType = orderType;
        this.sumDays = sumDays;
    }

    public ClassBAZA(int ID_order, int IDEmployee, String name, String surname, String patronymic) {
        this.ID_order = ID_order;
        this.IDEmployee = IDEmployee;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public ClassBAZA(String name, String surname, String patronymic, String mobPhone,String startWorkDate, String typeActv) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.startWorkDate = startWorkDate;
        this.typeActv = typeActv;
        this.mobPhone = mobPhone;
    }

    public ClassBAZA( String name, String surname, String patronymic, int count) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.count = count;
    }
    //Name1,Surname,patronymic,getOrders,'Приніс найбільшу кількість замовлень' as 'Коментар'
    public ClassBAZA(String name, String surname, String patronymic, int getOrders, String comment) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.getOrders = getOrders;
        this.comment = comment;
        typeActv = comment;
    }
    public ClassBAZA(String name, String surname, String patronymic, float salary, String typeActv) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.salary = salary;
        this.typeActv = typeActv;
    }

    public ClassBAZA(String orderName,String orderType, String orderDate, String delieveryDate) {
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.delieveryDate = delieveryDate;
        this.orderName = orderName;
    }



    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public ClassBAZA(int cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getGetOrders() {
        return getOrders;
    }

    public void setGetOrders(int getOrders) {
        this.getOrders = getOrders;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(String startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public String getTypeActv() {
        return typeActv;
    }

    public void setTypeActv(String typeActv) {
        this.typeActv = typeActv;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
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

    public void setSumDays(float sumDays) {
        this.sumDays = sumDays;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDelieveryDate() {
        return delieveryDate;
    }

    public void setDelieveryDate(String delieveryDate) {
        this.delieveryDate = delieveryDate;
    }

    public float getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(float orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getStageType() {
        return stageType;
    }

    public void setStageType(String stageType) {
        this.stageType = stageType;
    }

    public float getSumDays() {
        return sumDays;
    }

    public void setSumDays(int sumDays) {
        this.sumDays = sumDays;
    }

    public int getAvgImpr() {
        return avgImpr;
    }

    public void setAvgImpr(int avgImpr) {
        this.avgImpr = avgImpr;
    }

    public int getAvgClicks() {
        return avgClicks;
    }

    public void setAvgClicks(int avgClicks) {
        this.avgClicks = avgClicks;
    }

    public int getAvgUsers() {
        return avgUsers;
    }

    public void setAvgUsers(int avgUsers) {
        this.avgUsers = avgUsers;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
