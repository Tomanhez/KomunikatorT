package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginScreenController {

    @FXML
    private Pane loginPane;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passTextField;

    @FXML
    void buttonLogin(ActionEvent event) {
    	System.out.println("Login");
    }

}
