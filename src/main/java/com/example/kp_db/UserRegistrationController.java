package com.example.kp_db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.kp_db.Class.UsersRoles;
import com.example.kp_db.Class.dbCon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UserRegistrationController {
    @FXML
    private TextField userPatronymicTextField;

    @FXML
    private TextField userEmailTextField;

    @FXML
    private TextField userLoginTextField;

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField userPasswordTextField;

    @FXML
    private TextField userPhoneTextField;

    @FXML
    private RadioButton role2ManagerRadioButton;

    @FXML
    private RadioButton role3AccountantRadioButton;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField userSurnameTextField;

    @FXML
    private TextField userAddressTextField;


    final String insertEmployerQuery = "INSERT INTO  employees (Name1, Surname, patronymic, mobPhone,addres,email)  VALUES (?,?,?,?,?,?)";
    final String insertUserQuery = "INSERT INTO  USERS (login,pass,uRole)  VALUES (?,?,?)";

    private boolean testEmptyTextFields() {
        return !userLoginTextField.getText().isBlank() && !userPasswordTextField.getText().isBlank()
                && !userNameTextField.getText().isBlank() && !userSurnameTextField.getText().isBlank()
                && !userPatronymicTextField.getText().isBlank() && !userEmailTextField.getText().isBlank()
                && !userAddressTextField.getText().isBlank() && !userPhoneTextField.getText().isBlank();
    }


    private void employerRegistration() {
        try {
            PreparedStatement preparedStatement = dbCon.connect().prepareStatement(insertEmployerQuery);
            preparedStatement.setString(1, userNameTextField.getText());
            preparedStatement.setString(2, userSurnameTextField.getText());
            preparedStatement.setString(3, userPatronymicTextField.getText());
            preparedStatement.setString(4, userPhoneTextField.getText());
            preparedStatement.setString(5, userAddressTextField.getText());
            preparedStatement.setString(6, userEmailTextField.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void userRegistration() {
        if (testEmptyTextFields()) {
            try {
                PreparedStatement preparedStatement = dbCon.connect().prepareStatement(insertUserQuery);
                preparedStatement.setString(1, userLoginTextField.getText());
                preparedStatement.setString(2, userPasswordTextField.getText());
                if (role3AccountantRadioButton.isSelected()) {
                    preparedStatement.setInt(3, UsersRoles.ROLE3_ACCOUNTANT);
                    preparedStatement.executeUpdate();
                    closeWindow();
                } else if (role2ManagerRadioButton.isSelected()) {
                    preparedStatement.setInt(3, UsersRoles.ROLE2_MANAGER);
                    preparedStatement.executeUpdate();
                    closeWindow();
                } else {
                    getAllert("Посада не була вибрана");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            getAllert("Введено неповні данні");
        }
    }

    private void getAllert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message);
        alert.setContentText("Ooops, there was an error!");
        alert.showAndWait();
    }
    private void closeWindow(){
        Stage stageReg = (Stage) registrationButton.getScene().getWindow();
        stageReg.close();
    }
    @FXML
    public void userRegistrationButton(ActionEvent event) {
            employerRegistration();
            userRegistration();
    }

    @FXML
    void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();
        role2ManagerRadioButton.setToggleGroup(toggleGroup);
        role3AccountantRadioButton.setToggleGroup(toggleGroup);
    }
}
