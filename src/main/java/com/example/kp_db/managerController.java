package com.example.kp_db;

import com.example.kp_db.Class.*;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Optional;
import java.util.function.Predicate;

public class managerController {
    private String login;
    private int role;
    @FXML
    private TextField tField_search_orderType;


    public void setRole(int role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @FXML
    private Button addClientBtn;

    @FXML
    private Button authBtn;

    @FXML
    private Button changeClientBtn;

    @FXML
    private Button changeMetrBtn;

    @FXML
    private Button changeOrderBtn;
    @FXML
    private TableColumn<ClassBAZA, Integer> col_getOrders = new TableColumn<>("Принесено замовлень");
    @FXML
    private TableColumn<ClassBAZA, String> col_comment = new TableColumn<>("Коментар");
    @FXML
    private TableColumn<ClassBAZA, Integer> col_countOrderDone = new TableColumn<>("Кількість виконаних замовлень");
    @FXML
    private TableColumn<ClassBAZA, String> col_name = new TableColumn<>("Ім'я");
    @FXML
    private TableColumn<ClassBAZA, String> col_surname = new TableColumn<>("Прізвище");
    @FXML
    private TableColumn<ClassBAZA, String> col_patr = new TableColumn<>("По-батькові");

    private TableColumn<ClassBAZA, ?> col_mobPhone = new TableColumn<>("Мобільний телефон");
    private TableColumn<ClassBAZA, ?> col_startWorkDate = new TableColumn<>("Дата прийняття на роботу");
    private TableColumn<ClassBAZA, ?> col_typeActv = new TableColumn<>("Вид діяльності");

    //col_IDorder?col_idClient,col_idEmployee,col_orderDate,col_deliveryDate,col_idOrType,col_nameOrder,col_stageType
    @FXML
    private TableColumn<ClassBAZA, Float> col_cost = new TableColumn<>("Вартість");
    @FXML
    private TableColumn<ClassBAZA, Integer> col_IDorder = new TableColumn<>("ID замовлення");
    @FXML
    private TableColumn<ClassBAZA, Integer> col_idClient = new TableColumn<>("ID  клієнту");
    @FXML
    private TableColumn<ClassBAZA, Integer> col_idEmployee = new TableColumn<>("ID робітника,що працює над ним");
    @FXML
    private TableColumn<ClassBAZA, String> col_orderDate = new TableColumn<>("Дата оформлення замовлення");
    @FXML
    private TableColumn<ClassBAZA, String> col_deliveryDate = new TableColumn<>("Дата  збиту");
    @FXML
    private TableColumn<ClassBAZA, Integer> col_idOrType = new TableColumn<>("ID виду замовлення");
    @FXML
    private TableColumn<ClassBAZA, String> col_nameOrder = new TableColumn<>(" Назва замовлення");
    @FXML
    private TableColumn<ClassBAZA, String> col_stageType = new TableColumn<>("Етап виконання");


    @FXML
    private TableColumn<ClassBAZA, Float> col_sum = new TableColumn<>("Середня кількість днів");
    @FXML
    private TableColumn<ClassBAZA, Integer> col_avgImpr = new TableColumn<>("Середня кількість переглядів");
    @FXML
    private TableColumn<ClassBAZA, Integer> col_avgClicks = new TableColumn<>("Середня кількість кліків");
    @FXML
    private TableColumn<ClassBAZA, Integer> col_avgUsers = new TableColumn<>("Середня кількість унікальник користувачів");
    @FXML
    private TableColumn<ClassBAZA, String> col_orderType = new TableColumn<>("Тип замовлення");

    @FXML
    private TableColumn<Client, Integer> client_col_ID;

    @FXML
    private TableColumn<Client, String> client_col_email;

    @FXML
    private TableColumn<Client, String> client_col_name;

    @FXML
    private TableColumn<Client, String> client_col_patron;

    @FXML
    private TableColumn<Client, String> client_col_phone;

    @FXML
    private TableColumn<Client, String> client_col_sName;
    @FXML
    private TableColumn<Employee, String> employees_col_addres;

    @FXML
    private TableColumn<Employee, String> employees_col_email;

    @FXML
    private TableColumn<Employee, String> employees_col_iName;

    @FXML
    private TableColumn<Employee, Integer> employees_col_id;

    @FXML
    private TableColumn<Employee, String> employees_col_mobPhone;

    @FXML
    private TableColumn<Employee, String> employees_col_patron;
    @FXML
    private TableColumn<Employee, String> employees_col_dateWork;

    @FXML
    private TableColumn<Employee, String> employees_col_sName;

    @FXML
    private Button createOrderBtn;

    @FXML
    private Button deleteClientBtn;

    @FXML
    private Button deleteMetrBtn;
    @FXML
    private TabPane tabPane = new TabPane();
    @FXML
    private Button deleteOrdBrn;
    @FXML
    private TextField tField_search_actvType;
    @FXML
    private TableColumn<makeOrder, String> makeOrder_col_dataStage;

    @FXML
    private TableColumn<makeOrder, Integer> makeOrder_col_id;

    @FXML
    private TableColumn<makeOrder, Integer> makeOrder_col_idEmployees;

    @FXML
    private TableColumn<makeOrder, Integer> makeOrder_col_idOrder;

    @FXML
    private TableColumn<makeOrder, String> makeOrder_col_stage;

    @FXML
    private TableColumn<makeOrder, Integer> makeOrder_col_stagePay;

    @FXML
    private TableColumn<Metrics, Integer> metrics_col_clics;

    @FXML
    private TableColumn<Metrics, Integer> metrics_col_idOrder;

    @FXML
    private TableColumn<Metrics, Integer> metrics_col_unicUsers;

    @FXML
    private TableColumn<Metrics, Integer> metrics_col_views;

    @FXML
    private Button refreshClientBtn;

    @FXML
    private Button refreshEmployeesBtn;

    @FXML
    private Button refreshMakeOrderBtn;

    @FXML
    private Button refreshMetricsBtn;

    @FXML
    private Button refreshSpecialistBtn;

    @FXML
    private Button refresuOrderBtn;

    @FXML
    private Button searchClientBtn;

    @FXML
    private Button showOrdersBtn;
    @FXML
    private Button workOnOrderBtn;

    @FXML
    private Label errorLbl;
    @FXML
    private TableColumn<Orders, Integer> order_col_cost;
    @FXML
    private TableColumn<Orders, String> order_col_name;
    @FXML
    private TableColumn<Orders, String> order_col_date_end;

    @FXML
    private TableColumn<Orders, String> order_col_date_start;

    @FXML
    private TableColumn<Orders, Integer> order_col_id;

    @FXML
    private TableColumn<Orders, Integer> order_col_id_client;

    @FXML
    private TableColumn<Orders, Integer> order_col_id_type;

    @FXML
    private TableColumn<Orders, Integer> order_col_id_worker;
    @FXML
    private TableColumn<Orders, Integer> specialist_col_getOrders;

    @FXML
    private TableColumn<Specialist, Integer> specialist_col_amountOrderMade;

    @FXML
    private TableColumn<Specialist, Integer> specialist_col_bonus;

    @FXML
    private TableColumn<Specialist, Integer> specialist_col_idActivType;

    @FXML
    private TableColumn<Specialist, Integer> specialist_col_idEmployees;

    @FXML
    private TableColumn<Specialist, Integer> specialist_col_salary;
    @FXML
    private TableColumn<Specialist, String> specialist_col_salaryDate;

    @FXML
    private TableColumn<ActivityType, Integer> activType_col_id;

    @FXML
    private TableColumn<ActivityType, Integer> activType_col_salary;

    @FXML
    private TableColumn<ActivityType, String> activType_col_type;

    @FXML
    private TableColumn<OrderTypes, Integer> orderTypes_col_id;

    @FXML
    private TableColumn<OrderTypes, Integer> orderTypes_col_price;

    @FXML
    private TableColumn<OrderTypes, String> orderTypes_col_type;
    @FXML
    private DatePicker order_dateStart;
    @FXML
    private Button createFileAverageMetricBtn;
    @FXML
    private Button createFileAverageTimeBtn;
    @FXML
    private Button getAmountMadeOrderBtn;

    @FXML
    private Button getMaxMetrickBtn;

    @FXML
    private Button getMaxOrdersBtn;

    @FXML
    private Button getOrderBeginStageBtn;

    @FXML
    private Button getOrderTimeMoreAverageBtn;
    @FXML
    private Button searchEmplBtn;
    @FXML
    private Button getOrdersDateBtn;
    @FXML
    private Button averageTimeMakeBtn;

    @FXML
    private ComboBox<String> actTypeBox;

    @FXML
    private TextField tField_clients_email;

    @FXML
    private TextField tField_clients_id;

    @FXML
    private TextField tField_clients_mobPhone;

    @FXML
    private TextField tField_clients_name;

    @FXML
    private TextField tField_clients_patron;

    @FXML
    private TextField tField_clients_sName;

    @FXML
    private TextField tField_metrics_clicks;

    @FXML
    private TextField tField_metrics_idOrder;

    @FXML
    private TextField tField_metrics_unicUsers;

    @FXML
    private TextField tField_metrics_views;

    @FXML
    private TextField tField_order_cost;

    @FXML
    private DatePicker tField_order_dateEnd;

    @FXML
    private TextField tField_order_id;

    @FXML
    private TextField tField_order_idClient;

    @FXML
    private TextField tField_order_idEmpl;

    @FXML
    private TextField tField_order_idTypeAct;
    @FXML
    private TextField tField_order_name;

    @FXML
    private TextField tField_search_client;
    @FXML
    private Button refreshOrderTypeBtn;
    @FXML
    private Button refreshActvTypeBtn;
    @FXML
    private TextField tField_search_metrics;

    @FXML
    private TextField tField_search_specialist;
    @FXML
    private TableView<ClassBAZA> tb_Queys;
    @FXML
    private Tab tabQuerys;
    @FXML
    private Tab tabActType;
    @FXML
    private Tab tabOrdersType;
    @FXML
    private Tab tabClients;

    @FXML
    private Tab tabEmployees;

    @FXML
    private Tab tabMetics;

    @FXML
    private Tab tabOrders;

    @FXML
    private Tab tabOrdersMake;

    @FXML
    private Tab tabSpecialist;
    @FXML
    private TableView<OrderTypes> tbOrderTypes;
    @FXML
    private TableView<ActivityType> tbActType;
    @FXML
    private TableView<Employee> tb_Employees;

    @FXML
    private TableView<Orders> tb_Order;
    @FXML
    private TableView<Metrics> tb_Metrics;

    @FXML
    private TableView<Specialist> tb_Specialist;

    @FXML
    private TableView<makeOrder> tb_madeOrder;

    @FXML
    private TableView<Client> tb_clients;

    @FXML
    private TextField text_field_searchEmployees;

    @FXML
    private TextField text_field_searchUsers;

    @FXML
    private TextField text_field_search_makeOrders;
    @FXML
    private TextField tFIled_order_idOrderType;
    @FXML
    private Button addMetrBtn;


    @FXML
    private Button statisticBtn;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User user = null;
    Client client = null;
    Employee employee = null;
    ActivityType activityType = null;
    makeOrder makeOrder = null;
    Metrics metrics = null;
    Orders order = null;
    OrderTypes orderType = null;
    Specialist specialist = null;
    Pays pay;

    ObservableList<ClassBAZA> bazaList = FXCollections.observableArrayList();
    ObservableList<User> userList = FXCollections.observableArrayList();
    ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    ObservableList<Client> clientList = FXCollections.observableArrayList();
    ObservableList<ActivityType> activityTypeList = FXCollections.observableArrayList();
    ObservableList<makeOrder> makeOrderList = FXCollections.observableArrayList();
    ObservableList<Metrics> metricsList = FXCollections.observableArrayList();
    ObservableList<Orders> orderList = FXCollections.observableArrayList();
    ObservableList<OrderTypes> orderTypesList = FXCollections.observableArrayList();
    ObservableList<Specialist> specialistsList = FXCollections.observableArrayList();
    ObservableList<Pays> paysList = FXCollections.observableArrayList();
    ObservableList<User> userList2 = FXCollections.observableArrayList();


    @FXML
    private TextField tField_order_idEmployee;

    @FXML
    void initialize() {
        System.out.println(login);
        setActTypeBox();
        actTypeBox.setValue("IT");

        refreshEmployees();
        refreshMetrics();
        refreshOrderTypes();
        refreshActType();
        refreshClient();
        refreshOrder();
        refreshSpecialist();
        refreshMakeOrder();


        tb_madeOrder.setOnMouseClicked(event -> {
            makeOrder = tb_madeOrder.getSelectionModel().getSelectedItem();
        });
        tb_Specialist.setOnMouseClicked(event -> {
            specialist = tb_Specialist.getSelectionModel().getSelectedItem();
        });
        tb_Employees.setOnMouseClicked(event -> {
            employee = tb_Employees.getSelectionModel().getSelectedItem();
        });
        tb_Metrics.setOnMouseClicked(event -> {
            metrics = tb_Metrics.getSelectionModel().getSelectedItem();
            tField_metrics_idOrder.setText(String.valueOf(metrics.getID_order()));
            tField_metrics_clicks.setText(String.valueOf(metrics.getClicks()));
            tField_metrics_views.setText(String.valueOf(metrics.getImpressions()));
            tField_metrics_unicUsers.setText(String.valueOf(metrics.getUnicUsers()));

        });
        tb_Order.setOnMouseClicked(event -> {
            order = tb_Order.getSelectionModel().getSelectedItem();
            tField_order_cost.setText(String.valueOf(order.getCost()));
            tField_order_id.setText(String.valueOf(order.getID_order()));
            tField_order_idClient.setText(String.valueOf(order.getIDClient()));
            tField_order_idEmployee.setText(String.valueOf(order.getIDEmployee()));
            tFIled_order_idOrderType.setText(String.valueOf(order.getID_order_type()));
            //activityTypeBox
            tField_order_name.setText(order.getOrderName());
            ((TextField) order_dateStart.getEditor()).setText(String.valueOf(order.getOrderDate()));
            ((TextField) tField_order_dateEnd.getEditor()).setText(String.valueOf(order.getDelieveryDate()));
        });

        tbOrderTypes.setOnMouseClicked(event -> {
            orderType = tbOrderTypes.getSelectionModel().getSelectedItem();
        });
        tbActType.setOnMouseClicked(event -> {
            activityType = tbActType.getSelectionModel().getSelectedItem();

        });
        tb_clients.setOnMouseClicked(event -> {
            client = tb_clients.getSelectionModel().getSelectedItem();
            tField_clients_id.setText(String.valueOf(client.getIdClient()));
            tField_clients_name.setText(client.getName());
            tField_clients_sName.setText(client.getSurname());
            tField_clients_patron.setText(client.getPatronymic());
            tField_clients_email.setText(client.getEmail());
            tField_clients_mobPhone.setText(client.getMobPhone());
        });

    }

    private void setActTypeBox() {
        actTypeBox.setItems(main.activityTypesList);
        actTypeBox.setValue("IT");
    }

    private void refreshEmployees() {
        employees_col_id.setCellValueFactory(new PropertyValueFactory<>("id_Employee"));
        employees_col_iName.setCellValueFactory(new PropertyValueFactory<>("name"));
        employees_col_sName.setCellValueFactory(new PropertyValueFactory<>("surname"));
        employees_col_patron.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        employees_col_mobPhone.setCellValueFactory(new PropertyValueFactory<>("mobPhone"));
        employees_col_addres.setCellValueFactory(new PropertyValueFactory<>("addres"));
        employees_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        employees_col_dateWork.setCellValueFactory(new PropertyValueFactory<>("date_start_work"));
        employeeList.clear();
        query = "SELECT * FROM  employees";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeList.add(new Employee(
                                resultSet.getInt("ID_Employee"),
                                resultSet.getString("Name1"),
                                resultSet.getString("Surname"),
                                resultSet.getString("patronymic"),
                                resultSet.getString("mobPhone"),
                                resultSet.getString("addres"),
                                resultSet.getString("email"),
                                resultSet.getDate("date_start_Work")
                        )
                );
                tb_Employees.setItems(employeeList);
            }
            FilteredList<Employee> filteredData = new FilteredList<Employee>(FXCollections.observableList(employeeList));
            tb_Employees.setItems(filteredData);
            text_field_searchEmployees.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate4(newValue))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Predicate<Employee> createPredicate4(String searchText) {
        return employee -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchEmployee(employee, searchText);
        };
    }

    private boolean searchEmployee(Employee employee, String searchText) {
        return (Integer.valueOf(employee.getId_Employee()).toString().equals(searchText.toLowerCase()) ||
                (employee.getName().toLowerCase().contains(searchText.toLowerCase())) ||
                (employee.getSurname().toLowerCase().contains(searchText.toLowerCase())) ||
                (employee.getPatronymic().toLowerCase().contains(searchText.toLowerCase())) ||
                (employee.getMobPhone().toLowerCase().contains(searchText.toLowerCase())) ||
                (employee.getEmail().toLowerCase().contains(searchText.toLowerCase())) ||
                (employee.getAddres().toLowerCase().contains(searchText.toLowerCase()))
        );
    }

    private void refreshOrder() {
        order_col_id.setCellValueFactory(new PropertyValueFactory<>("ID_order"));
        order_col_id_client.setCellValueFactory(new PropertyValueFactory<>("IDClient"));
        order_col_id_worker.setCellValueFactory(new PropertyValueFactory<>("IDEmployee"));
        order_col_date_start.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        order_col_date_end.setCellValueFactory(new PropertyValueFactory<>("delieveryDate"));
        order_col_id_type.setCellValueFactory(new PropertyValueFactory<>("ID_order_type"));
        order_col_name.setCellValueFactory(new PropertyValueFactory<>("orderName"));
        order_col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        orderList.clear();
        query = "SELECT * FROM orders";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderList.add(new Orders(
                                resultSet.getInt("ID_Order"),
                                resultSet.getInt("IDClient"),
                                resultSet.getInt("IDEmployee"),
                                resultSet.getDate("orderDate"),
                                resultSet.getDate("deliveryDate"),
                                resultSet.getInt("ID_order_type"),
                                resultSet.getFloat("cost"),
                                resultSet.getString("nameOrder")
                        )
                );
                tb_Order.setItems(orderList);
            }
            FilteredList<Orders> filteredData = new FilteredList<Orders>(FXCollections.observableList(orderList));
            tb_Order.setItems(filteredData);
            text_field_searchUsers.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate(newValue))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Predicate<Orders> createPredicate(String searchText) {
        return order -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchOrder(order, searchText);
        };
    }

    private boolean searchOrder(Orders order, String searchText) {
        return (Integer.valueOf(order.getID_order()).toString().equals(searchText.toLowerCase()) ||
                (order.getOrderName().toLowerCase().contains(searchText.toLowerCase())) ||
                Integer.valueOf(order.getID_order()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(order.getIDEmployee()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(order.getIDClient()).toString().equals(searchText.toLowerCase()) ||
                Float.valueOf(order.getCost()).toString().equals(searchText.toLowerCase()));
    }

    public void refreshActType() {
        main.activityTypesList.clear();
        activType_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        activType_col_type.setCellValueFactory(new PropertyValueFactory<>("typeAct"));
        activType_col_salary.setCellValueFactory(new PropertyValueFactory<>("workingRate"));
        activityTypeList.clear();
        query = "SELECT * FROM activitytype";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                activityTypeList.add(new ActivityType(
                                resultSet.getInt("id"),
                                resultSet.getString("typeActv"),
                                resultSet.getInt("workingRate")
                        )
                );
                tbActType.setItems(activityTypeList);
            }
            FilteredList<ActivityType> filteredData = new FilteredList<ActivityType>(FXCollections.observableList(activityTypeList));
            tbActType.setItems(filteredData);
            tField_search_actvType.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate6(newValue))
            );
            for (int i = 0; i < activityTypeList.size(); i++) {
                main.activityTypesList.add(activityTypeList.get(i).getTypeAct());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Predicate<ActivityType> createPredicate6(String searchText) {
        return aType -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchActivityType(aType, searchText);
        };
    }

    private boolean searchActivityType(ActivityType aType, String searchText) {
        return (aType.getTypeAct().toLowerCase().contains(searchText.toLowerCase()));
    }

    private void refreshOrderTypes() {
        orderTypes_col_id.setCellValueFactory(new PropertyValueFactory<>("id_orTP"));
        orderTypes_col_price.setCellValueFactory(new PropertyValueFactory<>("cost"));
        orderTypes_col_type.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        orderTypesList.clear();
        query = "SELECT * FROM ordertype";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderTypesList.add(new OrderTypes(
                                resultSet.getInt("id_orTP"),
                                resultSet.getInt("cost"),
                                resultSet.getString("orderType")
                        )
                );
                tbOrderTypes.setItems(orderTypesList);
            }
            FilteredList<OrderTypes> filteredData = new FilteredList<OrderTypes>(FXCollections.observableList(orderTypesList));
            tbOrderTypes.setItems(filteredData);
            tField_search_orderType.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate5(newValue))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Predicate<OrderTypes> createPredicate5(String searchText) {
        return oType -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchOrderType(oType, searchText);
        };
    }

    private boolean searchOrderType(OrderTypes oType, String searchText) {
        return (oType.getOrderType().toLowerCase().contains(searchText.toLowerCase()));
    }

    public void refreshSpecialist() {
        specialist_col_idEmployees.setCellValueFactory(new PropertyValueFactory<>("idEmployee"));
        specialist_col_idActivType.setCellValueFactory(new PropertyValueFactory<>("idAct"));
        specialist_col_bonus.setCellValueFactory(new PropertyValueFactory<>("bonus"));
        specialist_col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        specialist_col_getOrders.setCellValueFactory(new PropertyValueFactory<>("prinesenoOrder"));
        specialist_col_amountOrderMade.setCellValueFactory(new PropertyValueFactory<>("ordersDone"));
        specialist_col_salaryDate.setCellValueFactory(new PropertyValueFactory<>("salaryDate"));
        specialistsList.clear();
        query = "SELECT * FROM specialist";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialistsList.add(new Specialist(
                                resultSet.getInt("idEmployee"),
                                resultSet.getInt("idAct"),
                                resultSet.getInt("bonus"),
                                resultSet.getDouble("salary"),
                                resultSet.getInt("ordersDone"),
                                resultSet.getInt("getOrders"),
                                resultSet.getDate("salaryDate")
                        )
                );
                tb_Specialist.setItems(specialistsList);
            }
            FilteredList<Specialist> filteredData = new FilteredList<Specialist>(FXCollections.observableList(specialistsList));
            tb_Specialist.setItems(filteredData);
            tField_search_specialist.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate2(newValue))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Predicate<Specialist> createPredicate2(String searchText) {
        return specialist -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchSpecialist(specialist, searchText);
        };
    }

    private boolean searchSpecialist(Specialist specialist, String searchText) {
        return (Integer.valueOf(specialist.getIdEmployee()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(specialist.getIdAct()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(specialist.getBonus()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(specialist.getOrdersDone()).toString().equals(searchText.toLowerCase()) ||
                Double.valueOf(specialist.getSalary()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(specialist.getPrinesenoOrder()).toString().equals(searchText.toLowerCase()));
    }

    public void refreshMakeOrder() {
        makeOrder_col_id.setCellValueFactory(new PropertyValueFactory<>("id_makeOrder"));
        makeOrder_col_idEmployees.setCellValueFactory(new PropertyValueFactory<>("IDEmployee"));
        makeOrder_col_idOrder.setCellValueFactory(new PropertyValueFactory<>("IDOrder"));
        makeOrder_col_stage.setCellValueFactory(new PropertyValueFactory<>("stageType"));
        makeOrder_col_dataStage.setCellValueFactory(new PropertyValueFactory<>("stageDate"));
        makeOrderList.clear();
        query = "SELECT * FROM  makeorder ";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                makeOrderList.add(new makeOrder(
                                resultSet.getInt("ID_makeOrder"),
                                resultSet.getDate("stageDate"),
                                resultSet.getString("stageType"),
                                resultSet.getInt("IDEmployee"),
                                resultSet.getInt("IDOrder")
                        )
                );
                tb_madeOrder.setItems(makeOrderList);
            }
            FilteredList<makeOrder> filteredData = new FilteredList<makeOrder>(FXCollections.observableList(makeOrderList));
            tb_madeOrder.setItems(filteredData);
            text_field_search_makeOrders.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate8(newValue))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private Predicate<makeOrder> createPredicate8(String searchText) {
        return makeOrder -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchMakeOrder(makeOrder, searchText);
        };
    }

    private boolean searchMakeOrder(makeOrder mOrder, String searchText) {
        return (Integer.valueOf(mOrder.getIDOrder()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(mOrder.getId_makeOrder()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(mOrder.getIDEmployee()).toString().equals(searchText.toLowerCase()) ||
                mOrder.getStageType().toLowerCase().contains(searchText.toLowerCase()));
    }
    public void refreshClient() {
        client_col_ID.setCellValueFactory(new PropertyValueFactory<>("id_Client"));
        client_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        client_col_sName.setCellValueFactory(new PropertyValueFactory<>("surname"));
        client_col_patron.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        client_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        client_col_phone.setCellValueFactory(new PropertyValueFactory<>("mobPhone"));
        clientList.clear();
        query = "SELECT * FROM  clients";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clientList.add(new Client(
                                resultSet.getInt("ID_Client"),
                                resultSet.getString("Name1"),
                                resultSet.getString("Surname"),
                                resultSet.getString("patronymic"),
                                resultSet.getString("mobPhone"),
                                resultSet.getString("email")
                        )
                );
                tb_clients.setItems(clientList);
            }
            FilteredList<Client> filteredData = new FilteredList<Client>(FXCollections.observableList(clientList));
            tb_clients.setItems(filteredData);
            tField_search_client.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate3(newValue))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Predicate<Client> createPredicate3(String searchText) {
        return client -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchClient(client, searchText);
        };
    }

    private boolean searchClient(Client client, String searchText) {
        return (Integer.valueOf(client.getIdClient()).toString().toString().equals(searchText.toLowerCase()) ||
                (client.getName().toLowerCase().contains(searchText.toLowerCase())) ||
                (client.getSurname().toLowerCase().contains(searchText.toLowerCase())) ||
                (client.getPatronymic().toLowerCase().contains(searchText.toLowerCase())) ||
                (client.getMobPhone().toLowerCase().contains(searchText.toLowerCase())) ||
                (client.getEmail().toLowerCase().contains(searchText.toLowerCase())));
    }

    public void deleteClient(ActionEvent actionEvent) {
        client = tb_clients.getSelectionModel().getSelectedItem();
        query = "DELETE FROM clients WHERE ID_Client = " + client.getIdClient();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Видалено клієнта  з id:" + client.getIdClient() + "')";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити клієнта?");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(q2);
                preparedStatement.setString(1, login);
                preparedStatement.setInt(2, role);
                preparedStatement.executeUpdate();
                refreshClient();
            } else {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeClient(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            client = tb_clients.getSelectionModel().getSelectedItem();
            query = "UPDATE clients SET   ID_Client = ? , Name1 = ?, Surname = ?, patronymic = ?, " +
                    "mobPhone= ?, email = ?   WHERE ID_Client = " + client.getIdClient();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Зміна  даних клієнта  з id:" + client.getIdClient() + "')";

            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_clients_id.getText()));
            prST.setString(2, tField_clients_name.getText());
            prST.setString(3, tField_clients_sName.getText());
            prST.setString(4, tField_clients_patron.getText());
            prST.setString(5, tField_clients_mobPhone.getText());
            prST.setString(6, tField_clients_email.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Оновити метрики?");
            alert.setContentText("Ви згодні?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = connection.prepareStatement(q2);
                prST.setString(1, login);
                prST.setInt(2, role);
                prST.executeUpdate();
                refreshClient();
            } else {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addClient(ActionEvent actionEvent) {

        if (!(tField_clients_id.getText().equals("") || tField_clients_sName.getText().equals("")
                || tField_clients_name.equals("") || tField_clients_patron.getText().equals("") || tField_clients_mobPhone.getText().equals("")
                || tField_clients_email.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Додано клієнта  з id:" + tField_clients_id.getText() + "')";
                String query = query = "INSERT INTO CLIENTS(ID_Client,Name1,Surname,patronymic,mobPhone,email) VALUES (?,?,?,?,?,?)";
                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_clients_id.getText()));
                prST.setString(2, tField_clients_name.getText());
                prST.setString(3, tField_clients_sName.getText());
                prST.setString(4, tField_clients_patron.getText());
                prST.setString(5, tField_clients_mobPhone.getText());
                prST.setString(6, tField_clients_email.getText());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити нового клієнта");
                alert.setContentText("Ви згодні?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST = dbCon.connect().prepareStatement(q2);
                    prST.setString(1, login);
                    prST.setInt(2, role);
                    prST.executeUpdate();
                    refreshClient();
                } else {
                    return;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Введено неповні данні");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
        }


    }

    public void refreshMetrics() {
        metrics_col_idOrder.setCellValueFactory(new PropertyValueFactory<>("ID_order"));
        metrics_col_clics.setCellValueFactory(new PropertyValueFactory<>("clicks"));
        metrics_col_views.setCellValueFactory(new PropertyValueFactory<>("impressions"));
        metrics_col_unicUsers.setCellValueFactory(new PropertyValueFactory<>("unicUsers"));
        metricsList.clear();
        query = "SELECT * FROM  advmetrics";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                metricsList.add(new Metrics(
                                resultSet.getInt("ID_order"),
                                resultSet.getInt("impressions"),
                                resultSet.getInt("clicks"),
                                resultSet.getInt("unicUsers")
                        )
                );
                tb_Metrics.setItems(metricsList);
            }
            FilteredList<Metrics> filteredData = new FilteredList<Metrics>(FXCollections.observableList(metricsList));
            tb_Metrics.setItems(filteredData);
            tField_search_metrics.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate7(newValue))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Predicate<Metrics> createPredicate7(String searchText) {
        return metrick -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchMetrick(metrick, searchText);
        };
    }

    private boolean searchMetrick(Metrics metrics, String searchText) {
        return (Integer.valueOf(metrics.getID_order()).toString().equals(searchText.toLowerCase()));
    }
    public void addMetr(ActionEvent actionEvent) {
        if (!(tField_metrics_idOrder.getText().equals("") || tField_metrics_clicks.getText().equals("")
                || tField_metrics_views.equals("") || tField_metrics_unicUsers.getText().equals("")))
            try {
                connection = dbCon.getConnection();
                String query = query = "INSERT INTO advmetrics(ID_Order,impressions,clicks,unicUsers) VALUES (?,?,?,?)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Додано характеристики до замовлення з id:" + tField_metrics_idOrder.getText() + "')";

                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_metrics_idOrder.getText()));
                prST.setString(2, tField_metrics_views.getText());
                prST.setString(3, tField_metrics_clicks.getText());
                prST.setString(4, tField_metrics_unicUsers.getText());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити характеристики замовлення?");
                alert.setContentText("Ви згодні?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST = connection.prepareStatement(q2);
                    prST.setString(1, login);
                    prST.setInt(2, role);
                    prST.executeUpdate();
                    refreshMetrics();
                } else {
                    return;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Введено неповні данні");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
        }
    }

    @FXML
    public void deleteMetr(ActionEvent actionEvent) {
        employee = tb_Employees.getSelectionModel().getSelectedItem();
        query = "DELETE FROM advmetrics WHERE ID_order = " + metrics.getID_order();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Видалено характеристики замовлення з id:" + metrics.getID_order() + "')";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити характеристики системи");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(q2);
                preparedStatement.setString(1, login);
                preparedStatement.setInt(2, role);
                refreshMetrics();

            } else {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void changeMtrBtn(ActionEvent event) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            query = "UPDATE advmetrics SET   impressions = ? , clicks = ?, unicUsers = ?    WHERE ID_order = ?";
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Зміна в  характеристиках замовлення з id:" + metrics.getID_order() + "')";
            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_metrics_views.getText()));
            prST.setInt(2, Integer.parseInt(tField_metrics_clicks.getText()));
            prST.setInt(3, Integer.parseInt(tField_metrics_unicUsers.getText()));
            prST.setInt(4, Integer.parseInt(tField_metrics_idOrder.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Оновити дані про клієнта?");
            alert.setContentText("Ви згодні?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = connection.prepareStatement(q2);
                prST.setString(1, login);
                prST.setInt(2, role);
                prST.executeUpdate();
                refreshMetrics();
            } else {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeOrd(ActionEvent event) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            order = tb_Order.getSelectionModel().getSelectedItem();
            query = "UPDATE orders SET  ID_Order = ? , IDClient = ?, IDEmployee = ?, orderDate = ?, deliveryDate = ? , cost=?, ID_order_type=?, nameOrder= ? WHERE ID_Order = " + order.getID_order();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Змінено  замовлення з id:" + order.getID_order() + "')";

            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_order_id.getText()));
            prST.setInt(2, Integer.parseInt(tField_order_idClient.getText()));
            prST.setInt(3, Integer.parseInt(tField_order_idEmployee.getText()));
            java.util.Date date = java.util.Date.from(order_dateStart.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateStart = new java.sql.Date((date.getTime()));
            prST.setDate(4, sqlDateStart);
            date = java.util.Date.from(tField_order_dateEnd.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateEnd = new java.sql.Date((date.getTime()));
            prST.setDate(5, sqlDateEnd);
            prST.setFloat(6, Float.valueOf(tField_order_cost.getText()));
            prST.setInt(7, Integer.parseInt(tFIled_order_idOrderType.getText()));
            prST.setString(8, tField_order_name.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Зміна даних  замовлення");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.setInt(2, role);
                prST.executeUpdate();
                refreshOrder();
                refreshMetrics();
            } else {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void createOrder(ActionEvent event) {
        if (!(tField_order_idEmployee.getText().equals("") || tField_order_id.getText().equals("")
                || tField_order_idClient.equals("") || tField_order_cost.getText().equals("") || tField_order_name.getText().equals("")
                || tFIled_order_idOrderType.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String query = "INSERT INTO  orders (ID_Order, IDClient, IDEmployee, orderDate,deliveryDate,cost,ID_order_type,nameOrder)" +
                        "  VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement prST = null;
                String query2 = "INSERT INTO advmetrics (ID_Order,impressions,clicks,unicUsers) VALUES (?,0,0,0)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Додане  замовлення з id:" + tField_order_id.getText() + "')";
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_order_id.getText()));
                prST.setInt(2, Integer.parseInt(tField_order_idClient.getText()));
                prST.setInt(3, Integer.parseInt(tField_order_idEmployee.getText()));

                PreparedStatement prST2;
                prST2 = dbCon.connect().prepareStatement(query2);

                prST2.setInt(1, Integer.parseInt(tField_order_id.getText()));
                java.util.Date date = java.util.Date.from(order_dateStart.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDateStart = new java.sql.Date((date.getTime()));
                prST.setDate(4, sqlDateStart);
                date = java.util.Date.from(tField_order_dateEnd.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDateEnd = new java.sql.Date((date.getTime()));
                prST.setDate(5, sqlDateEnd);
                prST.setFloat(6, Float.valueOf(tField_order_cost.getText()));
                prST.setInt(7, Integer.parseInt(tFIled_order_idOrderType.getText()));
                prST.setString(8, tField_order_name.getText());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити заказ");
                alert.setContentText("Ви згодні?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST2.executeUpdate();
                    prST = connection.prepareStatement(q2);
                    prST.setInt(2, role);
                    prST.setString(1, login);
                    prST.executeUpdate();
                    refreshOrder();
                    refreshMetrics();
                    refreshJournal();
                } else {
                    return;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Введено неповні данні");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
        }

    }

    private void refreshJournal() {
    }


    @FXML
    public void deleteOrder(ActionEvent actionEvent) {
        order = tb_Order.getSelectionModel().getSelectedItem();
        query = "DELETE FROM orders WHERE ID_Order = " + order.getID_order();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Видалене  замовлення з id:" + order.getID_order() + "')";

        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити замовлення?");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(q2);
                preparedStatement.setInt(2, role);
                preparedStatement.setString(1, login);
                preparedStatement.executeUpdate();
                refreshOrder();
                refreshMetrics();
            } else {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void getOnWorkDate(ActionEvent event) {
        try {
            bazaList.clear();
            tabPane.getSelectionModel().select(tabQuerys);
            tb_Queys.getColumns().clear();
            tb_Queys.getColumns().addAll(col_name, col_surname, col_patr, col_mobPhone, col_startWorkDate, col_typeActv);
            connection = dbCon.getConnection();
            /*if(actTypeBox.getValue().equals("IT")) {
                String query = "SELECT DISTINCT Name1,Surname,patronymic,mobPhone,date_start_Work,typeActv FROM employees em join specialist sp join activitytype act\n" +
                        "ON em.ID_Employee =  sp. idEmployee and sp.idAct= act.ID\n" +
                        "WHERE typeActv = 'IT' and date_start_Work BETWEEN '2022-01-01' and '2022-06-01';\n";
            }
            else if(actTypeBox.getValue().equals("Менеджер")){
                String query = "SELECT DISTINCT Name1,Surname,patronymic,mobPhone,date_start_Work,typeActv FROM employees em join specialist sp join activitytype act\n" +
                        "ON em.ID_Employee =  sp. idEmployee and sp.idAct= act.ID\n" +
                        "WHERE typeActv = 'Менеджер' and date_start_Work BETWEEN '2022-01-01' and '2022-06-01';\n";
            }
            else if(actTypeBox.getValue().equals("Дизайн")){
                String query = "SELECT DISTINCT Name1,Surname,patronymic,mobPhone,date_start_Work,typeActv FROM employees em join specialist sp join activitytype act\n" +
                        "ON em.ID_Employee =  sp. idEmployee and sp.idAct= act.ID\n" +
                        "WHERE typeActv = 'Дизайн' and date_start_Work BETWEEN '2022-01-01' and '2022-06-01';\n";
            }*/
            String query = "SELECT DISTINCT Name1,Surname,patronymic,mobPhone,date_start_Work,typeActv FROM employees em join specialist sp join activitytype act\n" +
                    "ON em.ID_Employee =  sp. idEmployee and sp.idAct= act.ID\n" +
                    "WHERE typeActv = '" + actTypeBox.getValue() + "' and date_start_Work BETWEEN '2022-01-01' and '2022-06-01';\n";
            PreparedStatement prST = null;
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
            col_patr.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
            col_mobPhone.setCellValueFactory(new PropertyValueFactory<>("mobPhone"));
            col_startWorkDate.setCellValueFactory(new PropertyValueFactory<>("startWorkDate"));
            col_typeActv.setCellValueFactory(new PropertyValueFactory<>("typeActv"));
            bazaList.clear();

            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6)
                        )
                );
                tb_Queys.setItems(bazaList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void getStatistic(ActionEvent event) {
        try {
            bazaList.clear();
            tabPane.getSelectionModel().select(tabQuerys);
            tb_Queys.getColumns().clear();
            tb_Queys.getColumns().addAll(col_orderType, col_avgClicks, col_avgUsers, col_avgImpr);
            connection = dbCon.getConnection();
            String query = "SELECT  avg(impressions), avg(clicks),avg(unicUsers),OrderType FROM advmetrics a  join orders o join ordertype ot\n" +
                    "ON a.ID_Order = o.ID_Order and o.ID_order_type = ot.ID_OrTp\n" +
                    "WHERE deliveryDate>  '2022-01-01'\n" +
                    "group by OrderType;";
            PreparedStatement prST = null;
            col_avgClicks.setCellValueFactory(new PropertyValueFactory<>("avgImpr"));
            col_avgImpr.setCellValueFactory(new PropertyValueFactory<>("avgClicks"));
            col_avgUsers.setCellValueFactory(new PropertyValueFactory<>("avgUsers"));
            col_orderType.setCellValueFactory(new PropertyValueFactory<>("orderType"));
            bazaList.clear();

            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getInt(3),
                                resultSet.getString(4)
                        )
                );
                tb_Queys.setItems(bazaList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void workOnOrder(ActionEvent event) {
        try {
            if (order != null) {
                order = tb_Order.getSelectionModel().getSelectedItem();
                bazaList.clear();
                tabPane.getSelectionModel().select(tabQuerys);
                tb_Queys.getColumns().clear();
                tb_Queys.getColumns().addAll(col_IDorder, col_idEmployee, col_name, col_surname, col_patr);
                connection = dbCon.getConnection();
                String query = "SELECT IDOrder,ID_Employee, Name1,Surname,patronymic  FROM makeorder  join employees\n" +
                        "on   makeorder.IDEmployee = employees.ID_Employee\n" +
                        "WHERE IDOrder =" + order.getID_order();
                PreparedStatement prST = null;
                col_IDorder.setCellValueFactory(new PropertyValueFactory<>("ID_order"));
                col_idEmployee.setCellValueFactory(new PropertyValueFactory<>("IDEmployee"));
                col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
                col_patr.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
                bazaList.clear();
                connection = dbCon.getConnection();
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    bazaList.add(new ClassBAZA(
                                    resultSet.getInt(1),
                                    resultSet.getInt(2),
                                    resultSet.getString(3),
                                    resultSet.getString(4),
                                    resultSet.getString(5)
                            )
                    );
                    tb_Queys.setItems(bazaList);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Не обрано замовлення в таблиці");
                alert.setContentText("Ooops, there was an error!");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void authentication(ActionEvent event) {
        authBtn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LogIn.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void refreshMetricsB(ActionEvent actionEvent) {
        refreshMetrics();
    }

    @FXML
    public void getOrderBeginStage(ActionEvent actionEvent) {
        try {
            bazaList.clear();
            tabPane.getSelectionModel().select(tabQuerys);
            tb_Queys.getColumns().clear();
            tb_Queys.getColumns().addAll(col_IDorder, col_idClient, col_idEmployee, col_orderDate, col_deliveryDate, col_idOrType, col_nameOrder, col_stageType, col_cost);
            connection = dbCon.getConnection();
            String query = "SELECT  ID_Order,IDClient,orders.IDEmployee,orderDate,deliveryDate,cost,ID_order_type,nameOrder,stageType FROM orders    join makeorder\n" +
                    "    on orders.ID_Order = makeorder.IDOrder\n" +
                    "    WHERE stageType ='Початковий етап'";
            PreparedStatement prST = null;
            col_IDorder.setCellValueFactory(new PropertyValueFactory<>("ID_order"));
            col_idClient.setCellValueFactory(new PropertyValueFactory<>("IDClient"));
            col_idEmployee.setCellValueFactory(new PropertyValueFactory<>("IDEmployee"));
            col_orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            col_deliveryDate.setCellValueFactory(new PropertyValueFactory<>("delieveryDate"));
            col_idOrType.setCellValueFactory(new PropertyValueFactory<>("ID_order_type"));
            col_nameOrder.setCellValueFactory(new PropertyValueFactory<>("orderName"));
            col_stageType.setCellValueFactory(new PropertyValueFactory<>("stageType"));
            col_cost.setCellValueFactory(new PropertyValueFactory<>("orderCost"));
            bazaList.clear();

            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getInt(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getFloat(6),
                                resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getString(9)
                        )
                );
                tb_Queys.setItems(bazaList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void getOrdersDate(ActionEvent actionEvent) {
        tabPane.getSelectionModel().select(tabOrders);
        order_col_id.setCellValueFactory(new PropertyValueFactory<>("ID_order"));
        order_col_id_client.setCellValueFactory(new PropertyValueFactory<>("IDClient"));
        order_col_id_worker.setCellValueFactory(new PropertyValueFactory<>("IDEmployee"));
        order_col_date_start.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        order_col_date_end.setCellValueFactory(new PropertyValueFactory<>("delieveryDate"));
        order_col_id_type.setCellValueFactory(new PropertyValueFactory<>("ID_order_type"));
        order_col_name.setCellValueFactory(new PropertyValueFactory<>("orderName"));
        order_col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        orderList.clear();
        query = "SELECT * FROM  orders \n" +
                "WHERE  orderDate BETWEEN '2020-01-01' and '2023-01-01';";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderList.add(new Orders(
                                resultSet.getInt("ID_Order"),
                                resultSet.getInt("IDClient"),
                                resultSet.getInt("IDEmployee"),
                                resultSet.getDate("orderDate"),
                                resultSet.getDate("deliveryDate"),
                                resultSet.getInt("ID_order_type"),
                                resultSet.getFloat("cost"),
                                resultSet.getString("nameOrder")
                        )
                );
                tb_Order.setItems(orderList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getAmountMadeOrderBtn(ActionEvent actionEvent) {
        try {
            if (employee != null) {
                employee = tb_Employees.getSelectionModel().getSelectedItem();
                tabPane.getSelectionModel().select(tabOrders);
                tabPane.getSelectionModel().select(tabQuerys);
                tb_Queys.getColumns().clear();
                tb_Queys.getColumns().addAll(col_name, col_surname, col_patr, col_countOrderDone);
                bazaList.clear();
                query = "SELECT   Name1,Surname,patronymic, COUNT(*) \n" +
                        "FROM makeorder join employees\n" +
                        "on employees.ID_Employee = makeorder.IDEmployee\n" +
                        "WHERE ID_Employee =" + employee.getId_Employee();
                col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
                col_patr.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
                col_countOrderDone.setCellValueFactory(new PropertyValueFactory<>("count"));

                connection = dbCon.getConnection();
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    bazaList.add(new ClassBAZA(
                                    resultSet.getString(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getInt(4)
                            )
                    );
                    tb_Queys.setItems(bazaList);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Не обрано працівника в таблиці");
                alert.setContentText("Ooops, there was an error!");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void averageTimeMake(ActionEvent actionEvent) {
        try {
            bazaList.clear();
            tabPane.getSelectionModel().select(tabQuerys);
            tb_Queys.getColumns().clear();
            tb_Queys.getColumns().addAll(col_orderType, col_sum);
            connection = dbCon.getConnection();
            String query = "SELECT   OrderType, sum(datediff(deliveryDate,orderDate)) FROM orders o join ordertype ot\n" +
                    "ON o.ID_order_type = ot.ID_OrTp\n" +
                    "group by OrderType;";
            PreparedStatement prST = null;
            col_sum.setCellValueFactory(new PropertyValueFactory<>("sumDays"));
            col_orderType.setCellValueFactory(new PropertyValueFactory<>("orderType"));
            bazaList.clear();

            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getFloat(2)
                        )
                );
                tb_Queys.setItems(bazaList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getMaxMetrick(ActionEvent actionEvent) {
        try {
            bazaList.clear();
            tabPane.getSelectionModel().select(tabQuerys);
            tb_Queys.getColumns().clear();
            tb_Queys.getColumns().addAll(col_nameOrder, col_orderType, col_orderDate, col_deliveryDate, col_avgImpr, col_avgClicks, col_avgUsers);
            connection = dbCon.getConnection();
            String query = "SELECT nameOrder,OrderType,orderDate,deliveryDate,avg(impressions), \n" +
                    "avg( clicks),avg(unicUsers) \n" +
                    "FROM advmetrics a  join orders o join ordertype ot\n" +
                    "ON a.ID_Order = o.ID_Order and o.ID_order_type = ot.ID_OrTp\n" +
                    "group by nameOrder\n" +
                    "HAVING  avg(impressions + clicks + unicUsers)  >=ALL (\n" +
                    "SELECT avg(impressions + clicks + unicUsers) \n" +
                    "FROM orders  o2 join advmetrics a2\n" +
                    "on a2.ID_Order = o2.ID_Order\n" +
                    "GROUp BY nameOrder);\n";
            PreparedStatement prST = null;
            col_avgClicks.setCellValueFactory(new PropertyValueFactory<>("avgImpr"));
            col_avgImpr.setCellValueFactory(new PropertyValueFactory<>("avgClicks"));
            col_avgUsers.setCellValueFactory(new PropertyValueFactory<>("avgUsers"));
            col_orderType.setCellValueFactory(new PropertyValueFactory<>("orderType"));
            col_orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            col_nameOrder.setCellValueFactory(new PropertyValueFactory<>("orderName"));
            col_deliveryDate.setCellValueFactory(new PropertyValueFactory<>("delieveryDate"));
            bazaList.clear();

            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getInt(5),
                                resultSet.getInt(6),
                                resultSet.getInt(7)
                        )
                );
                tb_Queys.setItems(bazaList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getMaxOrders(ActionEvent actionEvent) {
        try {
            bazaList.clear();
            tabPane.getSelectionModel().select(tabQuerys);
            tb_Queys.getColumns().clear();
            tb_Queys.getColumns().addAll(col_name, col_surname, col_patr, col_getOrders, col_comment);
            connection = dbCon.getConnection();
            String query = "SELECT  Name1,Surname,patronymic,getOrders,'Приніс найбільшу кількість замовлень' as 'Коментар'\n" +
                    "        FROM employees E join specialist S\n" +
                    "        ON  E.ID_Employee = S.idEmployee\n" +
                    "        WHERE getOrders >=ALL (SELECT getOrders from specialist)\n" +
                    "        UNION\n" +
                    "        SELECT  Name1,Surname,patronymic,getOrders,'Приніс найменшу кількість замовлень' as 'Коментар'\n" +
                    "        FROM employees E join specialist S\n" +
                    "        ON  E.ID_Employee = S.idEmployee\n" +
                    "        WHERE getOrders <=ALL (SELECT getOrders from specialist)";
            PreparedStatement prST = null;
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
            col_patr.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
            col_getOrders.setCellValueFactory(new PropertyValueFactory<>("getOrders"));
            col_comment.setCellValueFactory(new PropertyValueFactory<>("comment"));

            bazaList.clear();

            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getInt(4),
                                resultSet.getString(5)
                        )
                );
                tb_Queys.setItems(bazaList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getOrderTimeMoreAverage(ActionEvent actionEvent) {

        try {
            bazaList.clear();
            tabPane.getSelectionModel().select(tabQuerys);
            tb_Queys.getColumns().clear();
            tb_Queys.getColumns().addAll(col_nameOrder, col_orderType, col_orderDate, col_deliveryDate);
            connection = dbCon.getConnection();
            String query = "SELECT  nameOrder,OrderType,orderDate,deliveryDate\n" +
                    "        FROM  orders o join ordertype ot\n" +
                    "        ON o.ID_order_type = ot.ID_OrTp\n" +
                    "        WHERE datediff(deliveryDate,orderDate) >\n" +
                    "        (SELECT AVG(datediff(deliveryDate,orderDate))\n" +
                    "        FROM orders o2\n" +
                    "        WHERE o.ID_order_type = o2.ID_order_type);";
            PreparedStatement prST = null;
            col_orderType.setCellValueFactory(new PropertyValueFactory<>("orderType"));
            col_orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            col_nameOrder.setCellValueFactory(new PropertyValueFactory<>("orderName"));
            col_deliveryDate.setCellValueFactory(new PropertyValueFactory<>("delieveryDate"));

            bazaList.clear();

            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        )
                );
                tb_Queys.setItems(bazaList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void refreshClientB(ActionEvent actionEvent) {
        refreshClient();
    }

    public void searchEmpl(ActionEvent actionEvent) {
        // SELECT * FROM  clients WHERE  Surname LIKE '%ць'
        employeeList.clear();
        query = "SELECT * FROM  employees WHERE  Surname LIKE '%" + text_field_searchEmployees.getText() + "'";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeList.add(new Employee(
                                resultSet.getInt("ID_Employee"),
                                resultSet.getString("Name1"),
                                resultSet.getString("Surname"),
                                resultSet.getString("patronymic"),
                                resultSet.getString("mobPhone"),
                                resultSet.getString("addres"),
                                resultSet.getString("email"),
                                resultSet.getDate("date_start_Work")
                        )
                );
                tb_Employees.setItems(employeeList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void searchClient(ActionEvent actionEvent) {
        client_col_ID.setCellValueFactory(new PropertyValueFactory<>("id_Client"));
        client_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        client_col_sName.setCellValueFactory(new PropertyValueFactory<>("surname"));
        client_col_patron.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        client_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        client_col_phone.setCellValueFactory(new PropertyValueFactory<>("mobPhone"));
        clientList.clear();
        query = "SELECT * FROM  clients WHERE  Surname LIKE '%" + tField_search_client.getText() + "'";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clientList.add(new Client(
                                resultSet.getInt("ID_Client"),
                                resultSet.getString("Name1"),
                                resultSet.getString("Surname"),
                                resultSet.getString("patronymic"),
                                resultSet.getString("mobPhone"),
                                resultSet.getString("email")
                        )
                );
                tb_clients.setItems(clientList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void refreshSpecialistB(ActionEvent actionEvent) {
        refreshSpecialist();
    }

    @FXML
    public void refreshMakeOrderB(ActionEvent actionEvent) {
        refreshMakeOrder();
    }

    @FXML
    public void refreshEmployeesBtn(ActionEvent actionEvent) {
        refreshEmployees();
    }

    @FXML
    public void refresuOrderB(ActionEvent actionEvent) {
        refreshOrder();
    }


    public void createFileLateOrder(ActionEvent actionEvent) {
        try {
            bazaList.clear();
            String file_name = "C:\\Users\\Yevhenii\\IdeaProjects\\kp_db\\PDF_Files\\FileLateOrder.pdf";
            Document FileLateOrder = new Document();
            new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file_name), true), StandardCharsets.UTF_8));
            PdfWriter.getInstance(FileLateOrder, new FileOutputStream(file_name));
            PdfPTable pTabl = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase(new Chunk("Назва замовлення", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Тип замовлення", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Дата створення", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Дата виконання", PDFfont.getFont())));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);
            //Font f1 = FontFactory.getFont(FONT, "Cp1250", true);
            connection = dbCon.getConnection();
            query = "SELECT  nameOrder,OrderType,orderDate,deliveryDate \n" +
                    "FROM  orders o join ordertype ot\n" +
                    "ON o.ID_order_type = ot.ID_OrTp\n" +
                    "WHERE datediff(deliveryDate,orderDate) >\n" +
                    "(SELECT AVG(datediff(deliveryDate,orderDate)) \n" +
                    "FROM orders o2 \n" +
                    "WHERE o.ID_order_type = o2.ID_order_type);\n";
            PreparedStatement prSt;
            prSt = connection.prepareStatement(query);
            FileLateOrder.open();
            Paragraph paragraph = new Paragraph("Замовлення однакового типу, час виконання якого перевищало  середній час виконання  інших замовлень", PDFfont.getFont());
            FileLateOrder.add(paragraph);
            FileLateOrder.add(new Paragraph(" "));
            FileLateOrder.add(new Paragraph(" "));
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        )
                );

            }
            for (int i = 0; i < bazaList.size(); i++) {
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getOrderName(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getOrderType(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getOrderDate(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getDelieveryDate(), PDFfont.getFont())));
                pTabl.addCell(c1);
            }
            FileLateOrder.add(pTabl);
            FileLateOrder.close();
            JOptionPane.showMessageDialog(null, "File has been created");
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "File error");
        }
    }

    public void createFileAverageTime(ActionEvent actionEvent) {
        try {
            bazaList.clear();
            String file_name = "C:\\Users\\Yevhenii\\IdeaProjects\\kp_db\\PDF_Files\\FileAverageTime.pdf";
            Document FileLateOrder = new Document();
            PdfWriter.getInstance(FileLateOrder, new FileOutputStream(file_name));
            PdfPTable pTabl = new PdfPTable(2);
            PdfPCell c1 = new PdfPCell(new Phrase(new Chunk("Вид замовлення", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Витрачено днів", PDFfont.getFont())));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);
            //Font f1 = FontFactory.getFont(FONT, "Cp1250", true);
            connection = dbCon.getConnection();
            query = "SELECT   OrderType, sum(datediff(deliveryDate,orderDate)) FROM orders o join ordertype ot ON o.ID_order_type = ot.ID_OrTp group by OrderType";

            PreparedStatement prSt;
            prSt = connection.prepareStatement(query);
            FileLateOrder.open();
            Paragraph paragraph = new Paragraph("Середній час(у днях) на виконання  кожного типу замовлень ", PDFfont.getFont());
            FileLateOrder.add(paragraph);
            FileLateOrder.add(new Paragraph(" "));
            FileLateOrder.add(new Paragraph(" "));
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getFloat(2)
                        )
                );
            }
            for (int i = 0; i < bazaList.size(); i++) {
                c1 = new PdfPCell(new Phrase(new Chunk(String.valueOf(bazaList.get(i).getSumDays()), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getOrderType(), PDFfont.getFont())));
                pTabl.addCell(c1);

            }
            FileLateOrder.add(pTabl);
            FileLateOrder.close();
            JOptionPane.showMessageDialog(null, "File has been created");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "File error");
        }

    }


    public void createFileAverageMetric(ActionEvent actionEvent) {
        try {
            bazaList.clear();
            String file_name = "C:\\Users\\Yevhenii\\IdeaProjects\\kp_db\\PDF_Files\\FileAverageMetrics.pdf";
            Document FileLateOrder = new Document();
            PdfWriter.getInstance(FileLateOrder, new FileOutputStream(file_name));
            PdfPTable pTabl = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase(new Chunk("Середня кількість переглядів", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Середня кількість кліків", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Середня кількість унікальних користувачів", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Вид Замовлення", PDFfont.getFont())));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);
            connection = dbCon.getConnection();
            query = "SELECT  avg(impressions), avg( clicks),avg(unicUsers),OrderType FROM advmetrics a  join orders o join ordertype ot\n" +
                    "ON a.ID_Order = o.ID_Order and o.ID_order_type = ot.ID_OrTp\n" +
                    "WHERE deliveryDate>  '2022-01-01'\n" +
                    "group by OrderType";

            PreparedStatement prSt;
            prSt = connection.prepareStatement(query);
            FileLateOrder.open();
            Paragraph paragraph = new Paragraph("Середні показники характеристик кожного типу замовлення", PDFfont.getFont());
            FileLateOrder.add(paragraph);
            FileLateOrder.add(new Paragraph(" "));
            FileLateOrder.add(new Paragraph(" "));
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getInt(3),
                                resultSet.getString(4)
                        )

                );

            }
            for (int i = 0; i < bazaList.size(); i++) {
                c1 = new PdfPCell(new Phrase(new Chunk(Integer.toString(bazaList.get(i).getAvgImpr()), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(Integer.toString(bazaList.get(i).getAvgClicks()), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(Integer.toString(bazaList.get(i).getAvgUsers()), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getOrderType(), PDFfont.getFont())));
                pTabl.addCell(c1);
            }
            FileLateOrder.add(pTabl);
            FileLateOrder.close();
            JOptionPane.showMessageDialog(null, "File has been created");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "File error");
        }

    }

    public void createPDF_Employ(ActionEvent actionEvent) {
        try {
            bazaList.clear();


            String file_name = "C:\\Users\\Yevhenii\\IdeaProjects\\kp_db\\PDF_Files\\FileDiffEmpl.pdf";
            Document FileLateOrder = new Document();
            PdfWriter.getInstance(FileLateOrder, new FileOutputStream(file_name));
            PdfPTable pTabl = new PdfPTable(5);
            PdfPCell c1 = new PdfPCell(new Phrase(new Chunk("ім'я", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Прізвище", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("По-батькові", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Принесено замовлень ", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Коментар", PDFfont.getFont())));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);

            connection = dbCon.getConnection();
            query = "SELECT  Name1,Surname,patronymic,getOrders,'Приніс найбільшу кількість замовлень' as 'Коментар'\n" +
                    " FROM employees E join specialist S\n" +
                    "ON  E.ID_Employee = S.idEmployee\n" +
                    "WHERE getOrders >=ALL (SELECT getOrders from specialist)\n" +
                    "UNION\n" +
                    "SELECT  Name1,Surname,patronymic,getOrders,'Приніс найменшу кількість замовлень' as 'Коментар' \n" +
                    "FROM employees E join specialist S\n" +
                    "ON  E.ID_Employee = S.idEmployee\n" +
                    "WHERE getOrders <=ALL (SELECT getOrders from specialist)\n";

            PreparedStatement prSt = null;
            FileLateOrder.open();
            Paragraph paragraph = new Paragraph("Принесено замовлень", PDFfont.getFont());
            FileLateOrder.add(paragraph);
            FileLateOrder.add(new Paragraph(" "));
            FileLateOrder.add(new Paragraph(" "));
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getInt(4),
                                resultSet.getString(5)
                        )
                );


            }
            System.out.println(bazaList.size());
            for (int i = 0; i < bazaList.size(); i++) {
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getName(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getSurname(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getPatronymic(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(Integer.toString(bazaList.get(i).getGetOrders()), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getComment(), PDFfont.getFont())));
                pTabl.addCell(c1);
            }
            FileLateOrder.add(pTabl);
            FileLateOrder.close();
            JOptionPane.showMessageDialog(null, "File has been created");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "File error");
        }

    }


    public void refreshOrderType(ActionEvent actionEvent) {
        refreshOrderTypes();
    }

    public void refreshActvType(ActionEvent actionEvent) {
        refreshActType();
    }
}