package com.example.pruebafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;


    public void loginButtonOnAction(ActionEvent e) throws SQLException {


        if(usernameTextField.getText().isBlank() && passwordPasswordField.getText().isBlank()){
            loginMessageLabel.setText("usuario o contrasena estan en blanco");
        }else {
            validateLoggin();
        }
    }


    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }

    public void validateLoggin() throws SQLException {

        Connection cn = DataBaseConnection.getInstance();
        String verifyLogin = "SELECT count(1) FROM sesion where username ='"+usernameTextField.getText().trim()+"' and password = '"+passwordPasswordField.getText().trim()+"'";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(verifyLogin);

        while(rs.next()){
            if(rs.getInt(1)==1){
                loginMessageLabel.setText("Welcome");
            }else{
                loginMessageLabel.setText("Wrong information");
            }
        }

    }


}