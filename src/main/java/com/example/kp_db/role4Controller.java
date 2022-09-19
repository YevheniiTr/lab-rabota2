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
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Optional;
import java.util.function.Predicate;

public class role4Controller {
    private String login;
    private int role;
    public void setLogin(String login) {
        this.login = login;
    }
    public void setRole(int role) {
        this.role = role;
    }

    @FXML
    private DatePicker Pays_datePay;
    @FXML
    private final TableColumn<ClassBAZA, String> col_comment = new TableColumn<>("Коментар");
    @FXML
    private final TableColumn<ClassBAZA, Integer> col_salary = new TableColumn<>("Зарплата");
    @FXML
    private final TableColumn<ClassBAZA, Float> col_cost = new TableColumn<>("За останні пів року отримано ");
    @FXML
    private final TableColumn<ClassBAZA, String> col_orderType = new TableColumn<>("Тип замовлення");
    @FXML
    private final TableColumn<ClassBAZA, Float> col_sum = new TableColumn<>("Сума");
    @FXML
    private final TableColumn<ClassBAZA, Integer> col_IDorder = new TableColumn<>("ID замовлення");
    @FXML
    private final TableColumn<ClassBAZA, Integer> col_idOrType = new TableColumn<>("ID виду замовлення");
    @FXML
    private final TableColumn<ClassBAZA, String> col_nameOrder = new TableColumn<>(" Назва замовлення");
    @FXML
    private final TableColumn<ClassBAZA, String> col_name = new TableColumn<>("Ім'я");
    @FXML
    private final TableColumn<ClassBAZA, String> col_surname = new TableColumn<>("Прізвище");
    @FXML
    private final TableColumn<ClassBAZA, String> col_patr = new TableColumn<>("По-батькові");
    @FXML
    private final TableColumn<ClassBAZA, String> col_typeActv = new TableColumn<>("Вид діяльності");
    @FXML
    private Button addPayBtn;
    @FXML
    private TextField text_field_searchOrders;
    @FXML
    private Button biggerSalaryBtn;
    @FXML
    private Button refreshEmployeesBtn;

    @FXML
    private Button refreshSpecialistBtn;

    @FXML
    private Button refresuOrderBtn;
    @FXML
    private Button btnBack;
    @FXML
    private TabPane TabPane = new TabPane();
    @FXML
    private Button changePayBtn;

    @FXML
    private Button createPDF_MaxSalaryBtn;

    @FXML
    private Button createPDFmaxMinBtn;

    @FXML
    private Button deletePayBtn;

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
    private Button getMaxMinBtn;

    @FXML
    private Button getProfitBtn;

    @FXML
    private Button noPayBtn;

    @FXML
    private Button noSalaryBtn;

    @FXML
    private Button orderTypeMostMoneyBtn;

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
    private Button plusBonusBtn;

    @FXML
    private Button searchEmployBtn;

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
    private TextField tField_pays_amount;

    @FXML
    private TextField tField_pays_id;

    @FXML
    private TextField tField_pays_idOrder;

    @FXML
    private TextField tField_search_specialist;

    @FXML
    private Tab tabEmployees;

    @FXML
    private Tab tabOrders;

    @FXML
    private Tab tabPays;

    @FXML
    private Tab tabQuryes;

    @FXML
    private Tab tabSpecialists;

    @FXML
    private TableView<Pays> tbPays;

    @FXML
    private TableView<Employee> tb_Employees;

    @FXML
    private TableView<Orders> tb_Order;

    @FXML
    private TableView<Specialist> tb_Specialist;
    @FXML
    private TableView<ClassBAZA> tb_Quryes;

    @FXML
    private TextField text_field_searchEmployees;

    @FXML
    private TextField text_field_search_pays;
    @FXML
    private TableColumn<Pays, Integer> pays_col_ID;

    @FXML
    private TableColumn<Pays, Float> pays_col_amount;

    @FXML
    private TableColumn<Pays, String> pays_col_date;

    @FXML
    private TableColumn<Pays, Integer> pays_col_idOrder;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    User user = null;
    Employee employee = null;
    Orders order = null;
    Specialist specialist = null;
    Pays pay;
    ObservableList<ClassBAZA> bazaList = FXCollections.observableArrayList();
    ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    ObservableList<Orders> orderList = FXCollections.observableArrayList();
    ObservableList<Specialist> specialistsList = FXCollections.observableArrayList();
    ObservableList<Pays> paysList = FXCollections.observableArrayList();


    @FXML
    private TextField tField_order_idEmployee;

    @FXML
    void initialize() {
        System.out.println(login);
        refreshPay();
        refreshEmployees();
        refreshOrder();
        refreshSpecialist();
        tb_Specialist.setOnMouseClicked(event -> {
            specialist = tb_Specialist.getSelectionModel().getSelectedItem();
        });
        tb_Employees.setOnMouseClicked(event -> {
            employee = tb_Employees.getSelectionModel().getSelectedItem();
        });
        tbPays.setOnMouseClicked(event -> {
            pay = tbPays.getSelectionModel().getSelectedItem();
            tField_pays_id.setText(String.valueOf(pay.getIdPay()));
            tField_pays_idOrder.setText(String.valueOf(pay.getIdOrder()));
            tField_pays_amount.setText(String.valueOf(pay.getPay()));
            Pays_datePay.getEditor().setText(String.valueOf(pay.getPayDate()));

        });
        tb_Order.setOnMouseClicked(event -> {
            order = tb_Order.getSelectionModel().getSelectedItem();
        });
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
        } catch (SQLException | ClassNotFoundException e) {
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
            text_field_searchOrders.textProperty().addListener((observable, oldValue, newValue) ->
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
        } catch (SQLException | ClassNotFoundException e) {
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
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Оновлення данних оплати з id:" + pay.getIdPay() + "')";
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
                prST.setInt(2, role);
                prST.setString(1, login);
                resSet = prST.executeUpdate();
                refreshPay();
                refreshJournal();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void refreshJournal() {
    }

    public void addPay(ActionEvent actionEvent) {
        if (!(tField_pays_id.getText().isBlank() || tField_pays_idOrder.getText().isBlank()
                || tField_pays_amount.getText().isBlank())) {
            try {
                connection = dbCon.getConnection();
                String query = "INSERT INTO pays  (ID_Pay,idOrder,pay,payDate)  VALUES (?,?,?,?)";
                String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,?,'Додано оплату для замовлення id:" + tField_pays_idOrder.getText() + "')";
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
                    prST.setInt(2, role);
                    prST.executeUpdate();
                    refreshJournal();
                    refreshPay();
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
            String q2 = "INSERT INTO journal (timeChange, userLogin,userRole ,changes) VALUES (NOW(),?,3,'Видалено оплату  для замовлення id:" + pay.getIdOrder() + "')";
            PreparedStatement prST = null;
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                preparedStatement.execute();
                prST = dbCon.connect().prepareStatement(q2);
                prST.setString(1, login);
                prST.executeUpdate();
                refreshJournal();
                refreshPay();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
    void biggerSalaryBtn(ActionEvent event) {

        try {
            bazaList.clear();
            TabPane.getSelectionModel().select(tabQuryes);
            tb_Quryes.getColumns().clear();
            tb_Quryes.getColumns().addAll(col_name, col_surname, col_patr, col_salary, col_typeActv);
            connection = dbCon.getConnection();
            String query = "SELECT  Name1,Surname,patronymic, salary, typeActv from  employees E join activitytype A join specialist S\n" +
                    "        ON  E.ID_Employee = S.idEmployee and S.idAct = A.ID\n" +
                    "        WHERE S.salary > (SELECT avg(S2.salary)\n" +
                    "        FROM specialist S2\n" +
                    "        WHERE S.idAct = S2.idAct);";
            PreparedStatement prST = null;
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
            col_patr.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
            col_salary.setCellValueFactory(new PropertyValueFactory<>("getOrders"));
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
                                resultSet.getInt(4),
                                resultSet.getString(5)
                        )
                );
                tb_Quryes.setItems(bazaList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    @FXML
    void createPDF_MaxSalary(ActionEvent event) {
        try {
            bazaList.clear();
            String file_name = "C:\\Users\\Yevhenii\\IdeaProjects\\kp_db\\PDF_Files\\FileMaxSalary.pdf";
            Document FileLateOrder = new Document();
            PdfWriter.getInstance(FileLateOrder, new FileOutputStream(file_name));
            PdfPTable pTabl = new PdfPTable(5);
            PdfPCell c1 = new PdfPCell(new Phrase(new Chunk("Ім'я", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Прізвише", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("По-батькові", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Зарплата", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Вид діяльності", PDFfont.getFont())));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);
            connection = dbCon.getConnection();
            query = "SELECT DISTINCT Name1,Surname,patronymic, salary, typeActv from  employees E join activitytype A join specialist S\n" +
                    "ON  E.ID_Employee = S.idEmployee and S.idAct = A.ID\n" +
                    "WHERE S.salary > (SELECT avg(S2.salary) FROM specialist S2 \n" +
                    "WHERE S.idAct = S2.idAct);";
            PreparedStatement prSt;
            FileLateOrder.open();
            Paragraph paragraph = new Paragraph("має вищу  ЗП  за середню між  однаковим  видом діяльності", PDFfont.getFont());
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
                                resultSet.getFloat(4),
                                resultSet.getString(5)
                        )
                );
            }
            for (int i = 0; i < bazaList.size(); i++) {
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getName(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getSurname(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getPatronymic(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(Float.toString(bazaList.get(i).getSalary()), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(bazaList.get(i).getTypeActv(), PDFfont.getFont())));
                pTabl.addCell(c1);
            }
            pTabl.addCell(c1);
            FileLateOrder.add(pTabl);
            FileLateOrder.close();
            JOptionPane.showMessageDialog(null, "File has been created");
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "File error");
        }
    }

    @FXML
    void createPDFmaxMin(ActionEvent event) {
        try {
            bazaList.clear();
            String file_name = "C:\\Users\\Yevhenii\\IdeaProjects\\kp_db\\PDF_Files\\FileMaxMinSalary.pdf";
            Document FileLateOrder = new Document();
            PdfWriter.getInstance(FileLateOrder, new FileOutputStream(file_name));
            PdfPTable pTabl = new PdfPTable(5);
            PdfPCell c1 = new PdfPCell(new Phrase("Ім'я"));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Прізвише", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("По-батькові", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("По-батькові", PDFfont.getFont())));
            pTabl.addCell(c1);
            c1 = new PdfPCell(new Phrase(new Chunk("Коментар", PDFfont.getFont())));
            pTabl.addCell(c1);
            pTabl.setHeaderRows(1);
            connection = dbCon.getConnection();
            query = "SELECT Name1,Surname,patronymic,salary,'Має найбільшу ЗП' as 'Коментар' FROM employees E join specialist S\n" +
                    "ON  E.ID_Employee = S.idEmployee\n" +
                    "WHERE salary >=ALL (SELECT salary from specialist)\n" +
                    "UNION \n" +
                    "SELECT Name1,Surname,patronymic,salary,'Має найменшу ЗП' FROM employees E join specialist S\n" +
                    "ON  E.ID_Employee = S.idEmployee\n" +
                    "WHERE salary <=ALL (SELECT salary from specialist);";

            PreparedStatement prSt;
            prSt = connection.prepareStatement(query);
            FileLateOrder.open();
            Paragraph paragraph = new Paragraph("Отримують найбільше/найменше грошей", PDFfont.getFont());
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
                                resultSet.getInt(4),
                                resultSet.getString(5)
                        )
                );

            }
            for (ClassBAZA classBAZA : bazaList) {
                c1 = new PdfPCell(new Phrase(new Chunk(classBAZA.getName(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(classBAZA.getSurname(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(classBAZA.getPatronymic(), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(Integer.toString(classBAZA.getGetOrders()), PDFfont.getFont())));
                pTabl.addCell(c1);
                c1 = new PdfPCell(new Phrase(new Chunk(classBAZA.getComment(), PDFfont.getFont())));
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


    @FXML
    void getMaxMin(ActionEvent event) {
        try {
            bazaList.clear();
            TabPane.getSelectionModel().select(tabQuryes);
            tb_Quryes.getColumns().clear();
            tb_Quryes.getColumns().addAll(col_name, col_surname, col_patr, col_salary, col_comment);
            connection = dbCon.getConnection();
            String query = "SELECT Name1,Surname,patronymic,salary,'Має найбільшу ЗП' as 'Коментар'  \n" +
                    "FROM employees E join specialist S\n" +
                    "ON  E.ID_Employee = S.idEmployee\n" +
                    "WHERE salary >=ALL (SELECT salary from specialist)\n" +
                    "UNION \n" +
                    "SELECT Name1,Surname,patronymic,salary,'Має найменшу ЗП' \n" +
                    "FROM employees E join specialist S\n" +
                    "ON  E.ID_Employee = S.idEmployee\n" +
                    "WHERE salary <=ALL (SELECT salary from specialist);\n";
            PreparedStatement prST = null;
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
            col_patr.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
            col_salary.setCellValueFactory(new PropertyValueFactory<>("getOrders"));
            col_comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
            bazaList.clear();
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
                tb_Quryes.setItems(bazaList);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void getProfit(ActionEvent event) {
        try {
            bazaList.clear();
            TabPane.getSelectionModel().select(tabQuryes);
            tb_Quryes.getColumns().clear();
            tb_Quryes.getColumns().addAll(col_cost);
            connection = dbCon.getConnection();
            String query = "SELECT sum(cost) FROM orders\n" +
                    "        WHERE orderDate >=curdate()-  INTERVAL 6 MONTH";
            PreparedStatement prST = null;
            col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
            bazaList.clear();
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getInt(1)
                        )
                );
                tb_Quryes.setItems(bazaList);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void noPay(ActionEvent event) {
        try {
            bazaList.clear();
            TabPane.getSelectionModel().select(tabQuryes);
            tb_Quryes.getColumns().clear();
            tb_Quryes.getColumns().addAll(col_IDorder, col_nameOrder, col_idOrType);
            connection = dbCon.getConnection();
            String query = "SELECT ID_Order,nameOrder,ID_order_type \n" +
                    "FROM orders  o left join(\n" +
                    "SELECT * FROM  pays p WHERE p.pay  is not null ) p\n" +
                    "ON o.ID_Order = p.idOrder\n" +
                    "WHERE p.pay is null;\n";
            PreparedStatement prST = null;
            col_nameOrder.setCellValueFactory(new PropertyValueFactory<>("orderName"));
            col_IDorder.setCellValueFactory(new PropertyValueFactory<>("ID_order"));
            col_idOrType.setCellValueFactory(new PropertyValueFactory<>("ID_order_type"));
            bazaList.clear();
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getInt(3)
                        )
                );
                tb_Quryes.setItems(bazaList);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void noSalary(ActionEvent event) {
        try {
            bazaList.clear();
            TabPane.getSelectionModel().select(tabQuryes);
            tb_Quryes.getColumns().clear();
            tb_Quryes.getColumns().addAll(col_name, col_surname, col_patr);
            connection = dbCon.getConnection();
            String query = "SELECT Name1,Surname,patronymic  \n" +
                    "FROM employees E  LEFT JOIN (\n" +
                    "SELECT * FROM specialist WHERE  salaryDate is not null \n" +
                    "and salaryDate>CURDATE()  - INTERVAL 1 MONTH ) S\n" +
                    "ON  E.ID_Employee = S.idEmployee\n" +
                    "WHERE S.salaryDate is null;\n";
            PreparedStatement prST = null;
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
            col_patr.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
            bazaList.clear();
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
                tb_Quryes.setItems(bazaList);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void orderTypeMostMoney(ActionEvent event) {
        try {
            bazaList.clear();
            TabPane.getSelectionModel().select(tabQuryes);
            tb_Quryes.getColumns().clear();
            tb_Quryes.getColumns().addAll(col_orderType, col_sum);
            connection = dbCon.getConnection();
            String query = "SELECT OrderType, sum(o.cost) FROM orders o join ordertype ot\n" +
                    "ON o.ID_order_type = ot.ID_OrTp\n" +
                    "GROUP by OrderType\n" +
                    "HAVING sum(o.cost)>=ALL(SELECT  sum(cost) from orders \n" +
                    "group by ID_Order);";
            PreparedStatement prST = null;
            col_sum.setCellValueFactory(new PropertyValueFactory<>("sumDays"));
            col_orderType.setCellValueFactory(new PropertyValueFactory<>("orderType"));
            bazaList.clear();
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bazaList.add(new ClassBAZA(
                                resultSet.getString("OrderType"),
                                resultSet.getInt(2)
                        )
                );
                bazaList.get(0).getOrderType();
                tb_Quryes.setItems(bazaList);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void plusBonus(ActionEvent event) {
        try {
            bazaList.clear();
            connection = dbCon.getConnection();
            String query = "UPDATE specialist  as sp \n" +
                    "join specialist as sp2 ON sp.idEmployee = sp2.idEmployee\n" +
                    "SET sp.salary = sp.salary+ (sp.bonus*sp.getOrders)  \n" +
                    "WHERE  sp.getOrders > 5  ;\n";
            PreparedStatement prST = null;
            bazaList.clear();
            connection = dbCon.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            refreshSpecialist();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dialog");
            alert.setHeaderText("Виконано");
            alert.setContentText("Збільшено зарплату ");
            alert.showAndWait();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchEmploy(ActionEvent event) {

    }

    @FXML
    public void refreshEmployeesBtn(ActionEvent actionEvent) {
        refreshEmployees();
    }

    @FXML
    public void refreshOrderB(ActionEvent actionEvent) {
        refreshOrder();
    }

    public void refreshSpecialistB(ActionEvent actionEvent) {
        refreshSpecialist();
    }
}
