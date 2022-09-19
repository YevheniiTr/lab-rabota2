package com.example.kp_db;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.example.kp_db.Class.User;
import com.example.kp_db.Class.UsersRoles;
import com.example.kp_db.Class.dbCon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class mainController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private Label errorLabel;
    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button regButton;

    @FXML
    private Button signUpButton;

    @FXML
    void registration(ActionEvent event) {
        try {
            Stage stage = (Stage) regButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registration");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ArrayList <User> arrayList = new ArrayList<User>();
    @FXML
    void  signUp(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
            String loginText = loginField.getText().trim();
            String passwordText = passwordField.getText().trim();
            if(!(loginText.isBlank() || passwordText.isBlank())) {
                String query = "SELECT * FROM users WHERE login = ? and pass = ?";

                Connection connection = dbCon.getConnection();
                ResultSet resultSet;
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, loginText);
                preparedStatement.setString(2, passwordText);
                resultSet = preparedStatement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    user = new User(resultSet.getInt("ID"),
                            resultSet.getString("login"),
                            resultSet.getString("pass"),
                            resultSet.getInt("uRole"));

                }
                if(user == null){
                    errorLabel.setText("Неправильний логін або пароль");
                    errorLabel.setVisible(true);
                }
                else if (user.getRole() == UsersRoles.ROLE1_ADMIN) {
                    Stage stageReg = (Stage) signUpButton.getScene().getWindow();
                    stageReg.close();
                    Stage stage = (Stage) regButton.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrator.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    stage = new Stage();
                    stage.setTitle("AdminPanel");
                    stage.setScene(new Scene(root));
                    stage.show();
                    AdminController admContrl  = fxmlLoader.getController();
                    admContrl.setLogin(loginField.getText());
                } else if (user.getRole() == UsersRoles.ROLE2_MANAGER){
                    Stage stageReg = (Stage) signUpButton.getScene().getWindow();
                    stageReg.close();
                    Stage stage = (Stage) regButton.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Manager.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    managerController managerContrl = fxmlLoader.getController();
                    managerContrl.setLogin(loginField.getText());
                    managerContrl.setRole(UsersRoles.ROLE2_MANAGER);
                    stage = new Stage();
                    stage.setTitle("userPanel");
                    stage.setScene(new Scene(root));
                    stage.show();
                }
                else if(user.getRole() == UsersRoles.ROLE3_ACCOUNTANT){
                    Stage stageReg = (Stage) signUpButton.getScene().getWindow();
                    stageReg.close();
                    Stage stage = (Stage) regButton.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ROLE4.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    role4Controller role4Controller = fxmlLoader.getController();
                    role4Controller.setLogin(loginField.getText());
                    role4Controller.setRole(UsersRoles.ROLE3_ACCOUNTANT);
                    stage = new Stage();
                    stage.setTitle("Role3Panel");
                    stage.setScene(new Scene(root));
                    stage.show();

                }
                    try {
                        connection = dbCon.getConnection();
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
            }
            else {
                errorLabel.setText("Введите логин или пароль");
                errorLabel.setVisible(true);
            }

    }
    @FXML
    void initialize() {
        errorLabel.setVisible(false);
    }

}
