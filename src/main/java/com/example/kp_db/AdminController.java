package com.example.kp_db;

import java.io.IOException;
import java.sql.*;
import java.time.ZoneId;
import java.util.Optional;
import java.util.function.Predicate;

import com.example.kp_db.Class.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController {

    private String login;

    @FXML
    private TextField tField_search_client;

    public void setLogin(String login) {
        this.login = login;
    }

    @FXML
    private ComboBox<String> tablesList = new ComboBox<>();
    @FXML
    private TableColumn<ActivityType, Integer> activType_col_id;

    @FXML
    private TableColumn<ActivityType, Integer> activType_col_salary;

    @FXML
    private TableColumn<ActivityType, String> activType_col_type;

    @FXML
    private Button addActTypeBtn;

    @FXML
    private Button addOrderTypeBtn;

    @FXML
    private Button addPayBtn;

    @FXML
    private Button addSpecialistBtn;

    @FXML
    private Button btnBack;

    @FXML
    private Button changeActTypeBtn;

    @FXML
    private Button changeBtn;

    @FXML
    private Button changeOrderTypeBtn;

    @FXML
    private Button changePayBtn;

    @FXML
    private Button changeSpecialistBtn;

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
    private TableColumn<User, Integer> columnID;

    @FXML
    private TableColumn<User, String> columnLogin;

    @FXML
    private TableColumn<User, String> columnPassword;

    @FXML
    private TableColumn<User, Integer> columnRole;

    @FXML
    private TableView<User> tableView = new TableView<>();
    @FXML
    private TableView<User> usersTable = new TableView<>();

    @FXML
    private TabPane tbTables = new TabPane();
    @FXML
    private Button deleteActTypeBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button deleteOrderType;

    @FXML
    private Button deletePayBtn;

    @FXML
    private Button deleteSpecialistBtn;
    @FXML
    private Button changeEmployeesBtn;
    @FXML
    private Button addEmployeesBtn;
    @FXML
    private Button deleteEmployeesBtn;
    @FXML
    private TextField tField_employees_addres;

    @FXML
    private TextField tField_employees_email;

    @FXML
    private TextField tField_employees_id;

    @FXML
    private TextField tField_employees_mobPhone;

    @FXML
    private TextField tField_employees_name;

    @FXML
    private TextField tField_employees_patron;

    @FXML
    private TextField tField_employees_surname;

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
    private TableColumn<Employee, String> employees_col_sName;
    @FXML
    private TableColumn<Employee, String> employees_col_dateWork;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField loginField;

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
    private Button openRol2Window;

    @FXML
    private Button openRol3Window;

    @FXML
    private TableColumn<OrderTypes, Integer> orderTypes_col_id;

    @FXML
    private TableColumn<OrderTypes, Integer> orderTypes_col_price;

    @FXML
    private TableColumn<OrderTypes, String> orderTypes_col_type;

    @FXML
    private TableColumn<Orders, Integer> order_col_cost;

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
    private TableColumn<Orders, String> order_col_name;

    @FXML
    private TextField passwField;

    @FXML
    private TableColumn<Pays, Integer> pays_col_ID;

    @FXML
    private TableColumn<Pays, Float> pays_col_amount;

    @FXML
    private TableColumn<Pays, String> pays_col_date;

    @FXML
    private TableColumn<Pays, Integer> pays_col_idOrder;

    @FXML
    private Button refreshBtn;

    @FXML
    private Button regUserBtn;

    @FXML
    private TextField roleField;

    @FXML
    private TextField searchUser;

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
    private TableColumn<Specialist, Integer> specialist_col_getOrders;


    @FXML
    private TextField tField_actType_id;

    @FXML
    private TextField tField_actType_salary;

    @FXML
    private TextField tField_actType_type;

    @FXML
    private TextField tField_makeOrder_date;
    @FXML
    private TableColumn<Journal, String> col_journal_date;

    @FXML
    private TableColumn<Journal, Integer> col_journal_id;

    @FXML
    private TableColumn<Journal, String> col_journal_login;

    @FXML
    private TableColumn<Journal, Integer> col_journal_role;

    @FXML
    private TableColumn<Journal, String> col_journal_text;
    @FXML
    private Tab tabJournal;
    @FXML
    private TableView<Journal> tb_Journal;
    @FXML
    private TextField tField_makeOrder_id;
    @FXML
    private TextField tField_order_cost;

    @FXML
    private TextField tField_order_id;

    @FXML
    private TextField tField_order_idClient;

    @FXML
    private TextField tField_order_idEmployee;
    @FXML
    private TextField tField_makeOrder_idEmployee;

    @FXML
    private TextField tField_makeOrder_idOrder;

    @FXML
    private TextField tField_makeOrder_pay;

    @FXML
    private TextField tField_makeOrder_stage;

    @FXML
    private TextField tField_orderTypes_id;

    @FXML
    private TextField tField_orderTypes_price;

    @FXML
    private TextField tField_orderTypes_type;

    @FXML
    private TextField tField_pays_amount;

    @FXML
    private TextField tField_pays_date;

    @FXML
    private TextField tField_pays_id;

    @FXML
    private TextField tField_pays_idOrder;

    @FXML
    private TextField tField_search_specialist;
    @FXML
    private TextField tField_order_name;

    @FXML
    private TextField tField_specialist_amountOrd;

    @FXML
    private TextField tField_specialist_bonus;

    @FXML
    private TextField tField_specialist_id;

    @FXML
    private TextField tField_specialist_idActType;

    @FXML
    private TextField tField_specialist_makeOrder;

    @FXML
    private TextField tField_specialist_salary;
    @FXML
    private TextField tField_search_actvType;
    @FXML
    private TextField tField_search_orderType;
    @FXML
    private Tab tabActType;
    @FXML
    private Tab tabOrdersType;
    @FXML
    private Tab tabClients;

    @FXML
    private Tab tabEmployees;

    @FXML
    private Tab tabMakeOrders;

    @FXML
    private Tab tabMetrics;

    @FXML
    private Tab tabOrders;

    @FXML
    private Tab tabPays;

    @FXML
    private Tab tabSpecialists;

    @FXML
    private Tab tabUsers;


    @FXML
    private TableView<Metrics> tbMetrics;

    @FXML
    private TableView<OrderTypes> tbOrderTypes;

    @FXML
    private TableView<Pays> tbPays;


    @FXML
    private TableView<Employee> tb_Employees;

    @FXML
    private TableView<Orders> tb_Order;

    @FXML
    private TableView<Specialist> tb_Specialist;

    @FXML
    private TableView<makeOrder> tb_madeOrder;
    @FXML
    private TableView<ActivityType> tbActType;
    @FXML
    private TableView<Client> tb_clients;
    @FXML
    private DatePicker makeOrder_date_stage;
    @FXML
    private DatePicker dateEndOrder;
    @FXML
    private DatePicker dateStartOrder;
    @FXML
    private DatePicker Pays_datePay;
    @FXML
    private DatePicker specialist_date_salary;
    @FXML
    private TextField text_field_searchEmployees;
    @FXML
    private DatePicker picker_start_Ework;
    @FXML
    private TextField text_field_searchOrders;

    @FXML
    private TextField text_field_search_actType;

    @FXML
    private TextField text_field_search_makeOrders;

    @FXML
    private TextField text_field_search_metrics;

    @FXML
    private TextField text_field_search_pays;
    @FXML
    private TextField tField_metrics_clicks;

    @FXML
    private TextField tField_metrics_idOrder;

    @FXML
    private TextField tField_metrics_unicUsers;
    @FXML
    private TextField tFIled_order_idOrderType;
    @FXML
    private TextField tField_metrics_views;
    @FXML
    private Button changeClientBtn;
    @FXML
    private Button addClientBtn;
    @FXML
    private Button searchEmploy;

    @FXML
    private Button deleteClientBtn;
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
    ObservableList<Journal> journalList = FXCollections.observableArrayList();
    FilteredList<User> filteredData;
    SortedList<User> sortedData;

    @FXML
    void refreshTable(ActionEvent event) {
        refresh();
    }

    @FXML
    void back(ActionEvent event) {
        btnBack.getScene().getWindow().hide();
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
    void initialize() {
        System.out.println(login);
        usersTable.setVisible(false);
        setTableBox();
        loadData();
        refresh();
        refreshEmployees();
        refreshMetrics();
        refreshOrderTypes();
        refreshActType();
        refreshClient();
        refreshOrder();
        refreshSpecialist();
        refreshPay();
        refreshMakeOrder();
        refreshJournal();
        usersTable.getColumns().clear();
        errorLabel.setVisible(false);


        // 2. Set the filter Predicate whenever the filter changes.
        searchUser.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getPassword().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (user.getLogin().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(user.getRole()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (String.valueOf(user.getId()).toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true; //
                else
                    return false;
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<User> sortedData = new SortedList<>(filteredData);
        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        tableView.setItems(sortedData);
        //tableView.setVisible(false);
        tb_madeOrder.setOnMouseClicked(event -> {
            makeOrder = tb_madeOrder.getSelectionModel().getSelectedItem();
            tField_makeOrder_id.setText(String.valueOf(makeOrder.getId_makeOrder()));
            tField_makeOrder_idEmployee.setText(String.valueOf(makeOrder.getIDEmployee()));
            tField_makeOrder_idOrder.setText(String.valueOf(makeOrder.getIDOrder()));
            tField_makeOrder_stage.setText(makeOrder.getStageType());
            ((TextField) makeOrder_date_stage.getEditor()).setText(String.valueOf(makeOrder.getStageDate()));

        });
        tbPays.setOnMouseClicked(event -> {
            pay = tbPays.getSelectionModel().getSelectedItem();
            tField_pays_id.setText(String.valueOf(pay.getIdPay()));
            tField_pays_idOrder.setText(String.valueOf(pay.getIdOrder()));
            tField_pays_amount.setText(String.valueOf(pay.getPay()));
            ((TextField) Pays_datePay.getEditor()).setText(String.valueOf(pay.getPayDate()));

        });
        tb_Specialist.setOnMouseClicked(event -> {
            specialist = tb_Specialist.getSelectionModel().getSelectedItem();
            tField_specialist_id.setText(String.valueOf(specialist.getIdEmployee()));
            tField_specialist_idActType.setText(String.valueOf(specialist.getIdAct()));
            tField_specialist_bonus.setText(String.valueOf(specialist.getBonus()));
            tField_specialist_makeOrder.setText(String.valueOf(specialist.getPrinesenoOrder()));
            tField_specialist_amountOrd.setText(String.valueOf(specialist.getOrdersDone()));
            ((TextField) specialist_date_salary.getEditor()).setText(String.valueOf(specialist.getSalaryDate()));
            tField_specialist_salary.setText(String.valueOf(specialist.getSalary()));
        });
        tb_Employees.setOnMouseClicked(event -> {
            employee = tb_Employees.getSelectionModel().getSelectedItem();
            tField_employees_id.setText(String.valueOf(employee.getId_Employee()));
            tField_employees_name.setText(employee.getName());
            tField_employees_surname.setText(employee.getSurname());
            tField_employees_patron.setText(employee.getPatronymic());
            tField_employees_mobPhone.setText(employee.getMobPhone());
            tField_employees_email.setText(employee.getEmail());
            tField_employees_addres.setText(employee.getAddres());
            ((TextField) picker_start_Ework.getEditor()).setText(String.valueOf(employee.getDate_start_work()));
        });
        tbMetrics.setOnMouseClicked(event -> {
            metrics = tbMetrics.getSelectionModel().getSelectedItem();
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
            tField_order_name.setText(order.getOrderName());
            ((TextField) dateStartOrder.getEditor()).setText(String.valueOf(order.getOrderDate()));
            ((TextField) dateEndOrder.getEditor()).setText(String.valueOf(order.getDelieveryDate()));
        });

        tbOrderTypes.setOnMouseClicked(event -> {
            orderType = tbOrderTypes.getSelectionModel().getSelectedItem();
            tField_orderTypes_id.setText(String.valueOf(orderType.getId_orTP()));
            tField_orderTypes_price.setText(String.valueOf(orderType.getCost()));
            tField_orderTypes_type.setText(orderType.getOrderType());
        });
        tbActType.setOnMouseClicked(event -> {
            activityType = tbActType.getSelectionModel().getSelectedItem();
            tField_actType_id.setText(String.valueOf(activityType.getId()));
            tField_actType_type.setText(activityType.getTypeAct());
            tField_actType_salary.setText(String.valueOf(activityType.getWorkingRate()));
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
        tablesList.setOnAction(event -> {
            if (tablesList.getValue().equals("Users")) {
                tbTables.getSelectionModel().select(tabUsers);
            } else if (tablesList.getValue().equals("clients")) {
                tbTables.getSelectionModel().select(tabClients);
            } else if (tablesList.getValue().equals("advmetrics")) {
                tbTables.getSelectionModel().select(tabMetrics);
            } else if (tablesList.getValue().equals("employees")) {
                tbTables.getSelectionModel().select(tabEmployees);
            } else if (tablesList.getValue().equals("activityType")) {
                tbTables.getSelectionModel().select(tabActType);
            } else if (tablesList.getValue().equals("makeorder")) {
                tbTables.getSelectionModel().select(tabMakeOrders);
            } else if (tablesList.getValue().equals("orders")) {
                tbTables.getSelectionModel().select(tabOrders);
            } else if (tablesList.getValue().equals("ordertype")) {
                tbTables.getSelectionModel().select(tabOrdersType);
            } else if (tablesList.getValue().equals("pays")) {
                tbTables.getSelectionModel().select(tabPays);
            } else if (tablesList.getValue().equals("specialist")) {
                tbTables.getSelectionModel().select(tabSpecialists);
            }
        });

    }

    private void setTableBox() {
        ObservableList<String> tables = FXCollections.observableArrayList("Users", "activityType", "advmetrics", "clients",
                "employees", "makeorder", "orders", "ordertype", "pays", "specialist");
        tablesList.setItems(tables);
        tablesList.setValue("Users");
    }

    private void loadData() {
        if (tablesList.getValue().equals("Users")) {
            try {
                connection = dbCon.getConnection();
                query = "SELECT * FROM USERS";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            columnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
            columnRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        }
    }

    @FXML
    void deleteUser(ActionEvent event) {
        user = tableView.getSelectionModel().getSelectedItem();
        query = "DELETE FROM users WHERE id=" + user.getId();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалення користувача:" + user.getLogin() + "')";
        try {
            int resSet;
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            PreparedStatement prST = null;
            refresh();
            prST = connection.prepareStatement(q2);
            prST.setString(1, login);
            resSet = prST.executeUpdate();

            refreshJournal();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void refreshJournal() {
        pays_col_ID.setCellValueFactory(new PropertyValueFactory<>("idPay"));
        col_journal_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_journal_date.setCellValueFactory(new PropertyValueFactory<>("time"));
        col_journal_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        col_journal_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        col_journal_text.setCellValueFactory(new PropertyValueFactory<>("text"));

        journalList.clear();
        query = "SELECT * FROM journal";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                journalList.add(new Journal(
                                resultSet.getInt("id"),
                                resultSet.getString("timeChange"),
                                resultSet.getString("userLogin"),
                                resultSet.getInt("userRole"),
                                resultSet.getString("changes")
                        )
                );
                tb_Journal.setItems(journalList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void refresh() {
        userList.clear();
        query = "SELECT * FROM USERS";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(new User(
                                resultSet.getInt("id"),
                                resultSet.getString("login"),
                                resultSet.getString("pass"),
                                resultSet.getInt("uRole")
                        )
                );
                tableView.setItems(userList);
            }
            filteredData = new FilteredList<>(userList, b -> true);
            sortedData = new SortedList<>(filteredData);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeUserData(ActionEvent event) {
        try {
            user = tableView.getSelectionModel().getSelectedItem();
            int resSet;
            connection = dbCon.getConnection();
            query = "UPDATE users SET login = ?, pass = ?, uRole = ?  WHERE ID = ?";
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Оновлення данних користувача з id:" + user.getId() + "')";
            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setString(1, loginField.getText());
            prST.setString(2, passwField.getText());
            prST.setInt(3, Integer.parseInt(roleField.getText()));
            prST.setInt(4, user.getId());
            resSet = prST.executeUpdate();
            refresh();
            prST = connection.prepareStatement(q2);
            prST.setString(1, login);
            resSet = prST.executeUpdate();
            refreshJournal();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void updateUser(ActionEvent event) {
        user = tableView.getSelectionModel().getSelectedItem();
        loginField.setText(user.getLogin());
        passwField.setText(user.getPassword());
        roleField.setText(String.valueOf(user.getRole()));
    }

    @FXML
    void regUser(ActionEvent event) {
        if (!(loginField.getText().equals("") || passwField.getText().equals("") || roleField.getText().equals(""))) {
            try {
                User user = tableView.getSelectionModel().getSelectedItem();
                int resSet;
                connection = dbCon.getConnection();
                String query = "INSERT INTO  USERS (login,pass,uRole)  VALUES (?,?,?)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1, 'Додано користувача:" + loginField.getText() + "')";
                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setString(1, loginField.getText());
                prST.setString(2, passwField.getText());
                prST.setInt(3, Integer.parseInt(roleField.getText()));
                prST.executeUpdate();
                refresh();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                resSet = prST.executeUpdate();
                refreshJournal();
                refresh();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            errorLabel.setText("Поля данных не заполнены");
            errorLabel.setVisible(true);
        }

    }


    @FXML
    void getUserTable(ActionEvent event) {
        if (tablesList.getValue().equals("Users")) {
            try {
                connection = dbCon.getConnection();
                PreparedStatement prepareStatement = connection.prepareStatement("select * from " + tablesList.getValue());
                ResultSet resultSet = prepareStatement.executeQuery();
                ResultSetMetaData rsmd = resultSet.getMetaData();

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (rsmd.getColumnType(i) == 4) {
                        TableColumn column = new TableColumn<User, Integer>(rsmd.getColumnName(i));
                        column.setCellValueFactory(new PropertyValueFactory<>(rsmd.getColumnName(i)));
                        usersTable.getColumns().add(column);
                        usersTable.setItems(userList);
                    } else if (rsmd.getColumnType(i) == 12) {
                        TableColumn column = new TableColumn<User, String>(rsmd.getColumnName(i));
                        column.setCellValueFactory(new PropertyValueFactory<>(rsmd.getColumnLabel(i)));
                        usersTable.getColumns().add(column);
                        usersTable.setItems(userList);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void refreshPay() {
        pays_col_ID.setCellValueFactory(new PropertyValueFactory<>("idPay"));
        pays_col_idOrder.setCellValueFactory(new PropertyValueFactory<>("idOrder"));
        pays_col_amount.setCellValueFactory(new PropertyValueFactory<>("pay"));
        pays_col_date.setCellValueFactory(new PropertyValueFactory<>("payDate"));
        paysList.clear();
        query = "SELECT * FROM pays";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                paysList.add(new Pays(
                                resultSet.getInt("ID_Pay"),
                                resultSet.getInt("idOrder"),
                                resultSet.getFloat("pay"),
                                resultSet.getDate("payDate")
                        )
                );
                tbPays.setItems(paysList);
            }
            FilteredList<Pays> filteredData = new FilteredList<Pays>(FXCollections.observableList(paysList));
            tbPays.setItems(filteredData);
            text_field_search_pays.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate9(newValue))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Predicate<Pays> createPredicate9(String searchText) {
        return pay -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchPay(pay, searchText);
        };
    }

    private boolean searchPay(Pays pay, String searchText) {
        return (Integer.valueOf(pay.getIdPay()).toString().equals(searchText.toLowerCase()) ||
                Integer.valueOf(pay.getIdOrder()).toString().equals(searchText.toLowerCase()) ||
                Float.valueOf(pay.getPay()).toString().equals(searchText.toLowerCase()));
    }

    public void changePay(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            pay = tbPays.getSelectionModel().getSelectedItem();
            query = "UPDATE pays SET ID_Pay = ?,  idOrder= ?, pay= ?, payDate =?   WHERE  ID_Pay =" + pay.getIdPay();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Оновлення данних оплати з id:" + pay.getIdPay() + "')";
            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_pays_id.getText()));
            prST.setInt(2, Integer.parseInt(tField_pays_idOrder.getText()));
            prST.setFloat(3, Float.parseFloat(tField_pays_amount.getText()));
            java.util.Date date = java.util.Date.from(Pays_datePay.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateEnd = new java.sql.Date((date.getTime()));
            prST.setDate(4, sqlDateEnd);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Зміна даних    оплати замовлення");
            alert.setContentText("Ви згодні?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                resSet = prST.executeUpdate();
                refreshPay();
                refreshJournal();
            } else {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addPay(ActionEvent actionEvent) {
        if (!(tField_pays_id.getText().equals("") || tField_pays_idOrder.getText().equals("")
                || tField_pays_amount.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String query = "INSERT INTO pays  (ID_Pay,idOrder,pay,payDate)  VALUES (?,?,?,?)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Додано оплату для замовлення id:" + tField_pays_idOrder.getText() + "')";
                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_pays_id.getText()));
                prST.setInt(2, Integer.parseInt(tField_pays_idOrder.getText()));
                prST.setFloat(3, Float.parseFloat(tField_pays_amount.getText()));
                java.util.Date date = java.util.Date.from(Pays_datePay.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDateEnd = new java.sql.Date((date.getTime()));
                prST.setDate(4, sqlDateEnd);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити нову оплату ?");
                alert.setContentText("Ви згодні?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST = dbCon.connect().prepareStatement(q2);
                    prST.setString(1, login);
                    prST.executeUpdate();
                    refreshPay();
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

    public void deletePay(ActionEvent actionEvent) {
        pay = tbPays.getSelectionModel().getSelectedItem();
        query = "DELETE FROM pays WHERE ID_Pay = " + pay.getIdPay();
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити оплату замовлення");
            alert.setContentText("Ви згодні?");
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалено оплату  для замовлення id:" + pay.getIdOrder() + "')";
            PreparedStatement prST = null;
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshPay();
                refreshJournal();
            } else {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
            for (int i = 0; i < activityTypeList.size(); i++) {
                main.activityTypesList.add(activityTypeList.get(i).getTypeAct());
            }
            FilteredList<ActivityType> filteredData = new FilteredList<ActivityType>(FXCollections.observableList(activityTypeList));
            tbActType.setItems(filteredData);
            tField_search_actvType.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate6(newValue))
            );
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

    public void addActType(ActionEvent actionEvent) {
        if (!(tField_actType_id.getText().equals("") || tField_actType_salary.getText().equals("")
                || tField_actType_type.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String query = "INSERT INTO activitytype  (id,typeActv,workingRate)  VALUES (?,?,?)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Додано тип  діяльності:" + tField_actType_type.getText() + "')";
                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_actType_id.getText()));
                prST.setString(2, tField_actType_type.getText());
                prST.setInt(3, Integer.parseInt(tField_actType_salary.getText()));
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити новий вид діяльності?");
                alert.setContentText("Ви згодні?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST = dbCon.connect().prepareStatement(q2);
                    prST.setString(1, login);
                    prST.executeUpdate();
                    refreshActType();
                    refreshJournal();
                    //System.out.println(activityTypeList.get(0).getId());
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

    public void changeActType(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            activityType = tbActType.getSelectionModel().getSelectedItem();
            query = "UPDATE activitytype SET id = ?, typeActv = ?, workingRate= ?   WHERE  id =" + activityType.getId();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'змінений вид діяльності :" + activityType.getTypeAct() + "')";
            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_actType_id.getText()));
            prST.setString(2, tField_actType_type.getText());
            prST.setInt(3, Integer.parseInt(tField_actType_salary.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Зміна даних   типу діяльності");
            alert.setContentText("Ви згодні?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshActType();
                refreshJournal();
            } else {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void deleteActTypeBtn(ActionEvent actionEvent) {
        activityType = tbActType.getSelectionModel().getSelectedItem();
        query = "DELETE FROM activitytype WHERE ID = " + activityType.getId();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалено тип  діяльності:" + tField_actType_type.getText() + "')";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити тип діяльності");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(q2);
                preparedStatement.setString(1, login);
                preparedStatement.executeUpdate();
                refreshActType();
                refreshJournal();
            } else {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeOrderType(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            orderType = tbOrderTypes.getSelectionModel().getSelectedItem();
            query = "UPDATE ordertype  SET id_OrTp = ?, cost = ?, OrderType = ?   WHERE  id_OrTp =" + orderType.getId_orTP();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Змінено  вид  замовлення:" + orderType.getOrderType() + "')";

            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_orderTypes_id.getText()));
            prST.setInt(2, Integer.parseInt(tField_orderTypes_price.getText()));
            prST.setString(3, tField_orderTypes_type.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Зміна даних   типу замовлення");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshOrderTypes();
                refreshJournal();
            } else {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addOrderType(ActionEvent actionEvent) {
        if (!(tField_orderTypes_id.getText().equals("") || tField_orderTypes_price.getText().equals("")
                || tField_orderTypes_type.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Додано вид  замовлення:" + tField_orderTypes_type.getText() + "')";
                String query = "INSERT INTO ordertype  (ID_OrTp, cost, OrderType)  VALUES (?,?,?)";
                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_orderTypes_id.getText()));
                prST.setInt(2, Integer.parseInt(tField_orderTypes_price.getText()));
                prST.setString(3, tField_orderTypes_type.getText());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити новий тип замовленнь?");
                alert.setContentText("Ви згодні?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST = dbCon.connect().prepareStatement(q2);
                    prST.setString(1, login);
                    prST.executeUpdate();
                    refreshOrderTypes();
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

    public void deleteOrderType(ActionEvent actionEvent) {
        orderType = tbOrderTypes.getSelectionModel().getSelectedItem();
        query = "DELETE FROM ordertype WHERE ID_OrTp = " + orderType.getId_orTP();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалено вид  замовлення:" + orderType.getOrderType() + "')";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити тип замовлення");
            alert.setContentText("Ви згодні?");
            int resSet;
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(q2);
                preparedStatement.setString(1, login);
                preparedStatement.executeUpdate();
                refreshOrderTypes();
                refreshJournal();
            } else {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public void changeSpecialist(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            specialist = tb_Specialist.getSelectionModel().getSelectedItem();
            query = "UPDATE specialist SET  idEmployee= ? , idAct = ?, bonus = ?, salary = ?, ordersDone = ? , getOrders=?, salaryDate=?  WHERE idEmployee = " + specialist.getIdEmployee();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Змінено спеціаліста з id:" + specialist.getIdEmployee() + "')";
            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_specialist_id.getText()));
            prST.setInt(2, Integer.parseInt(tField_specialist_idActType.getText()));
            prST.setInt(3, Integer.parseInt(tField_specialist_bonus.getText()));
            prST.setDouble(4, Double.parseDouble(tField_specialist_salary.getText()));
            prST.setInt(5, Integer.parseInt(tField_specialist_makeOrder.getText()));
            prST.setInt(6, Integer.parseInt(tField_specialist_amountOrd.getText()));
            java.util.Date date = java.util.Date.from(specialist_date_salary.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateEnd = new java.sql.Date((date.getTime()));
            prST.setDate(7, sqlDateEnd);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Зміна даних  cпеціаліста");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshSpecialist();
                refreshJournal();
            } else {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addSpecialist(ActionEvent actionEvent) {
        if (!(tField_specialist_id.getText().equals("") || tField_specialist_idActType.getText().equals("")
                || tField_specialist_bonus.equals("") || tField_specialist_salary.getText().equals("") || tField_specialist_amountOrd.getText().equals("")
                || tField_specialist_makeOrder.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String query = "INSERT INTO  specialist (idEmployee, idAct,bonus,salary,ordersDone,getOrders,salaryDate)" +
                        "  VALUES (?,?,?,?,?,?,?)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Додано  спеціаліста з id:" + tField_specialist_id.getText() + "')";
                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_specialist_id.getText()));
                prST.setInt(2, Integer.parseInt(tField_specialist_idActType.getText()));
                prST.setInt(3, Integer.parseInt(tField_specialist_bonus.getText()));
                prST.setDouble(4, Double.parseDouble(tField_specialist_salary.getText()));
                prST.setInt(5, Integer.parseInt(tField_specialist_makeOrder.getText()));
                prST.setInt(6, Integer.parseInt(tField_specialist_amountOrd.getText()));
                java.util.Date date = java.util.Date.from(specialist_date_salary.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDateEnd = new java.sql.Date((date.getTime()));
                prST.setDate(7, sqlDateEnd);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити спеціаліста");
                alert.setContentText("Ви згодні?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST = dbCon.connect().prepareStatement(q2);
                    prST.setString(1, login);
                    prST.executeUpdate();
                    refreshSpecialist();
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

    public void deleteSpecialist(ActionEvent actionEvent) {
        specialist = tb_Specialist.getSelectionModel().getSelectedItem();
        query = "DELETE FROM specialist WHERE idEmployee = " + specialist.getIdEmployee();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'видалено  спеціаліста з id:" + specialist.getIdEmployee() + "')";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити спеціаліста?");
            alert.setContentText("Ви згодні?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(q2);
                preparedStatement.setString(1, login);
                preparedStatement.executeUpdate();
                refreshSpecialist();
                refreshJournal();
            } else {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getRol2Window(ActionEvent actionEvent) throws IOException {
        Stage stageReg = (Stage) openRol2Window.getScene().getWindow();
        stageReg.close();
        Stage stage = (Stage) openRol2Window.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        managerController managerContrl = fxmlLoader.getController();
        managerContrl.setLogin(login);
        managerContrl.setRole(UsersRoles.ROLE1_ADMIN);
        stage = new Stage();
        stage.setTitle("userPanel");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void getRol3Window(ActionEvent actionEvent) throws IOException {
        Stage stageReg = (Stage) openRol3Window.getScene().getWindow();
        stageReg.close();
        Stage stage = (Stage) openRol3Window.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ROLE4.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        role4Controller role4Controller = fxmlLoader.getController();
        role4Controller.setLogin(login);
        role4Controller.setRole(UsersRoles.ROLE1_ADMIN);
        stage = new Stage();
        stage.setTitle("Role3Panel");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void addOrder(ActionEvent actionEvent) {
        if (!(tField_order_idEmployee.getText().equals("") || tField_order_id.getText().equals("")
                || tField_order_idClient.equals("") || tField_order_cost.getText().equals("") || tField_order_name.getText().equals("")
                || tFIled_order_idOrderType.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String query = "INSERT INTO  orders (ID_Order, IDClient, IDEmployee, orderDate,deliveryDate,cost,ID_order_type,nameOrder)" +
                        "  VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement prST = null;
                String query2 = "INSERT INTO advmetrics (ID_Order,impressions,clicks,unicUsers) VALUES (?,0,0,0)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Додане  замовлення з id:" + tField_order_id.getText() + "')";
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_order_id.getText()));
                prST.setInt(2, Integer.parseInt(tField_order_idClient.getText()));
                prST.setInt(3, Integer.parseInt(tField_order_idEmployee.getText()));

                PreparedStatement prST2;
                prST2 = dbCon.connect().prepareStatement(query2);

                prST2.setInt(1, Integer.parseInt(tField_order_id.getText()));
                java.util.Date date = java.util.Date.from(dateStartOrder.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDateStart = new java.sql.Date((date.getTime()));
                prST.setDate(4, sqlDateStart);
                date = java.util.Date.from(dateEndOrder.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
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
                    prST.setString(1, login);
                    prST.executeUpdate();
                    refreshOrder();
                    refreshMetrics();
                    refreshJournal();
                } else {
                    return;
                }

            } catch (SQLException | ClassNotFoundException e) {
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

    //ID_Order, IDClient, IDEmployee, orderDate,deliveryDate,cost,ID_order_type,nameOrder
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
            text_field_searchOrders.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredData.setPredicate(createPredicate(newValue))
            );
        } catch (SQLException | ClassNotFoundException e) {
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
    //ID_Order, IDClient, IDEmployee, orderDate,deliveryDate,cost,ID_order_type,nameOrder
    public void changeOrder(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            order = tb_Order.getSelectionModel().getSelectedItem();
            query = "UPDATE orders SET  ID_Order = ? , IDClient = ?, IDEmployee = ?, orderDate = ?, deliveryDate = ? , cost=?, ID_order_type=?, nameOrder= ? WHERE ID_Order = " + order.getID_order();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'змінене  замовлення з id:" + order.getID_order() + "')";
            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_order_id.getText()));
            prST.setInt(2, Integer.parseInt(tField_order_idClient.getText()));
            prST.setInt(3, Integer.parseInt(tField_order_idEmployee.getText()));
            java.util.Date date = java.util.Date.from(dateStartOrder.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateStart = new java.sql.Date((date.getTime()));
            prST.setDate(4, sqlDateStart);
            date = java.util.Date.from(dateEndOrder.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
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

    }

    public void deleteOrder(ActionEvent actionEvent) {
        order = tb_Order.getSelectionModel().getSelectedItem();
        query = "DELETE FROM orders WHERE ID_Order = " + order.getID_order();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалити  замовлення з id:" + order.getID_order() + "')";
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
                preparedStatement.setString(1, login);
                preparedStatement.executeUpdate();
                refreshOrder();
                refreshMetrics();
                refreshJournal();
            } else {
                return;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeEmployees(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            employee = tb_Employees.getSelectionModel().getSelectedItem();
            query = "UPDATE employees SET ID_Employee =?, Name1 = ? , Surname = ?, patronymic = ?, mobPhone= ?,addres = ? ,email=?,date_start_Work = ?   WHERE ID_Employee =" + employee.getId_Employee();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Змінено працівника з id:" + employee.getId_Employee() + "')";
            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_employees_id.getText()));
            prST.setString(2, tField_employees_name.getText());
            prST.setString(3, tField_employees_surname.getText());
            prST.setString(4, tField_employees_patron.getText());
            prST.setString(5, tField_employees_mobPhone.getText());
            prST.setString(6, tField_employees_addres.getText());
            prST.setString(7, tField_employees_email.getText());
            java.util.Date date = java.util.Date.from(picker_start_Ework.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateWork = new java.sql.Date((date.getTime()));
            prST.setDate(8, sqlDateWork);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Зміна даних  працівника");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshEmployees();
                refreshSpecialist();
                refreshJournal();

            } else {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addEmployees(ActionEvent actionEvent) {
        //tField_employees_id.getText().equals("")

        if (!(tField_employees_name.getText().equals("") || tField_employees_surname.getText().equals("")
                || tField_employees_patron.equals("") || tField_employees_mobPhone.getText().equals("") || tField_employees_addres.getText().equals("")
                || tField_employees_email.getText().equals("") || tField_employees_id.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String query = "INSERT INTO  employees (ID_Employee,Name1, Surname, patronymic, mobPhone,addres,email,date_start_Work)  VALUES (?,?,?,?,?,?,?,?)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Додано працівника з id:" + tField_employees_id.getText() + "')";
                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_employees_id.getText()));
                prST.setString(2, tField_employees_name.getText());
                prST.setString(3, tField_employees_surname.getText());
                prST.setString(4, tField_employees_patron.getText());
                prST.setString(5, tField_employees_mobPhone.getText());
                prST.setString(6, tField_employees_addres.getText());
                prST.setString(7, tField_employees_email.getText());
                java.util.Date date = java.util.Date.from(picker_start_Ework.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDateWork = new java.sql.Date((date.getTime()));
                prST.setDate(8, sqlDateWork);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити нового працівника");
                alert.setContentText("Ви згодні?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST = dbCon.connect().prepareStatement(q2);
                    prST.setString(1, login);
                    prST.executeUpdate();
                    refreshEmployees();
                    refreshSpecialist();
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

    public void deleteEmployees(ActionEvent actionEvent) {
        employee = tb_Employees.getSelectionModel().getSelectedItem();
        query = "DELETE FROM employees WHERE ID_Employee = " + employee.getId_Employee();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалено працівника з ПІБ:" + employee.getId_Employee() + "" + employee.getSurname() + "" + employee.getPatronymic() + "')";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити працівника");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(q2);
                preparedStatement.setString(1, login);
                preparedStatement.executeUpdate();
                refreshEmployees();
                refreshSpecialist();
                refreshJournal();
            } else {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
                tbMetrics.setItems(metricsList);
            }
            FilteredList<Metrics> filteredData = new FilteredList<Metrics>(FXCollections.observableList(metricsList));
            tbMetrics.setItems(filteredData);
            text_field_search_metrics.textProperty().addListener((observable, oldValue, newValue) ->
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

    public void deleteMetricks(ActionEvent actionEvent) {
        metrics = tbMetrics.getSelectionModel().getSelectedItem();
        query = "DELETE FROM advmetrics WHERE ID_order = " + metrics.getID_order();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалено характеристики замовлення з id:" + metrics.getID_order() + "')";
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
                preparedStatement.executeUpdate();
                refreshMetrics();
                refreshJournal();

            } else {
                return;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void changeMetics(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            metrics = tbMetrics.getSelectionModel().getSelectedItem();
            query = "UPDATE advmetrics SET   impressions = ? , clicks = ?, unicUsers = ?    WHERE ID_order =" + metrics.getID_order();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Зміна в  характеристиках замовлення з id:" + metrics.getID_order() + "')";
            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_metrics_views.getText()));
            prST.setInt(2, Integer.parseInt(tField_metrics_clicks.getText()));
            prST.setInt(3, Integer.parseInt(tField_metrics_unicUsers.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Оновити дані про клієнта?");
            alert.setContentText("Ви згодні?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshMetrics();
                refreshJournal();
            } else {
                return;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        } catch (SQLException | ClassNotFoundException e) {
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
        return (Integer.valueOf(client.getIdClient()).equals(searchText.toLowerCase()) ||
                (client.getName().toLowerCase().contains(searchText.toLowerCase())) ||
                (client.getSurname().toLowerCase().contains(searchText.toLowerCase())) ||
                (client.getPatronymic().toLowerCase().contains(searchText.toLowerCase())) ||
                (client.getMobPhone().toLowerCase().contains(searchText.toLowerCase())) ||
                (client.getEmail().toLowerCase().contains(searchText.toLowerCase())));
    }

    public void deleteClient(ActionEvent actionEvent) {
        client = tb_clients.getSelectionModel().getSelectedItem();
        query = "DELETE FROM clients WHERE ID_Client = " + client.getIdClient();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалено клієнта  з id:" + client.getIdClient() + "')";
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
                preparedStatement.executeUpdate();
                refreshClient();
                refreshJournal();
            } else {
                return;
            }

        } catch (SQLException | ClassNotFoundException e) {
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
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Зміна  даних клієнта  з id:" + client.getIdClient() + "')";
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
            alert.setHeaderText("Оновити дані про клієнта?");
            alert.setContentText("Ви згодні?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshClient();
                refreshJournal();
            } else {
                return;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addClient(ActionEvent actionEvent) {

        if (!(tField_clients_id.getText().equals("") || tField_clients_sName.getText().equals("")
                || tField_clients_name.equals("") || tField_clients_patron.getText().equals("") || tField_clients_mobPhone.getText().equals("")
                || tField_clients_email.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Додано клієнта  з id:" + tField_clients_id.getText() + "')";
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
                    prST.executeUpdate();
                    refreshClient();
                    refreshJournal();
                } else {
                    return;
                }

            } catch (SQLException | ClassNotFoundException e) {
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
        } catch (SQLException | ClassNotFoundException e) {
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

    @FXML
    public void changeMakeOrder(ActionEvent actionEvent) {
        try {
            int resSet;
            connection = dbCon.getConnection();
            makeOrder = tb_madeOrder.getSelectionModel().getSelectedItem();
            query = "UPDATE makeorder SET   ID_makeOrder = ? , stageDate = ?, stageType = ?, IDEmployee = ?, " +
                    "IDOrder= ?   WHERE ID_makeOrder = " + makeOrder.getId_makeOrder();
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Зміна даних в т. ВиконанняЗамовлення, id:" + makeOrder.getId_makeOrder() + "')";

            PreparedStatement prST = null;
            prST = dbCon.connect().prepareStatement(query);
            prST.setInt(1, Integer.parseInt(tField_makeOrder_id.getText()));
            java.util.Date date = java.util.Date.from(makeOrder_date_stage.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateWork = new java.sql.Date((date.getTime()));
            prST.setDate(2, sqlDateWork);
            prST.setString(3, tField_makeOrder_stage.getText());
            prST.setInt(4, Integer.parseInt(tField_makeOrder_idEmployee.getText()));
            prST.setInt(5, Integer.parseInt(tField_makeOrder_idOrder.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Оновити  дані?");
            alert.setContentText("Ви згодні?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resSet = prST.executeUpdate();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshMakeOrder();
                refreshJournal();
            } else {
                return;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addMakeOrder(ActionEvent actionEvent) {
        if (!(tField_makeOrder_id.getText().equals("") || tField_makeOrder_idOrder.getText().equals("")
                || tField_makeOrder_idEmployee.equals("") || tField_makeOrder_stage.getText().equals(""))) {
            try {
                connection = dbCon.getConnection();
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Додано у т. ВиконанняЗамовлення, id:" + tField_makeOrder_id.getText() + "')";
                String query = query = "INSERT INTO makeorder (ID_makeorder,stageDate,stageType,IDEmployee,IDOrder) VALUES (?,?,?,?,?)";
                PreparedStatement prST = null;
                prST = dbCon.connect().prepareStatement(query);
                prST.setInt(1, Integer.parseInt(tField_makeOrder_id.getText()));
                java.util.Date date = java.util.Date.from(makeOrder_date_stage.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                java.sql.Date sqlDateWork = new java.sql.Date((date.getTime()));
                prST.setDate(2, sqlDateWork);
                prST.setString(3, tField_makeOrder_stage.getText());
                prST.setInt(4, Integer.parseInt(tField_makeOrder_idEmployee.getText()));
                prST.setInt(5, Integer.parseInt(tField_makeOrder_idOrder.getText()));

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Добавити нові данні");
                alert.setContentText("Ви згодні?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    prST.executeUpdate();
                    prST = dbCon.connect().prepareStatement(q2);
                    prST.setString(1, login);
                    prST.executeUpdate();
                    refreshMakeOrder();
                    refreshJournal();
                } else {
                    return;
                }

            } catch (SQLException | ClassNotFoundException e) {
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

    @FXML
    public void deleteMakeOrder(ActionEvent actionEvent) {
        makeOrder = tb_madeOrder.getSelectionModel().getSelectedItem();
        query = "DELETE FROM makeorder WHERE ID_makeOrder = " + makeOrder.getId_makeOrder();
        String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,1,'Видалено з т. ВиконанняЗамовлення, id:" + makeOrder.getId_makeOrder() + "')";
        try {
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Видалити  данні?");
            alert.setContentText("Ви згодні?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(q2);
                preparedStatement.setString(1, login);
                preparedStatement.executeUpdate();
                refreshMakeOrder();
                refreshJournal();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void searchEmploy(ActionEvent actionEvent) {
    }

}

