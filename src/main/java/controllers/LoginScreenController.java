package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginScreenController {

	private static String SLOGIN = "tom";
	private static String SPASS = "sut";
	
    @FXML
    private Pane loginPane;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passTextField;

    @FXML
    void buttonLogin(ActionEvent event) {
    	System.out.println("Login");
    	//System.out.println(SLOGIN+"\n"+SPASS+"\n"+loginTextField.getText()+"\n"+passTextField.getText());
    	checkLog();
    }

	private void checkLog() {
		if(loginTextField.getText().equals(SLOGIN) || passTextField.getText().equals(SPASS)) {
    		loginSuccessful();
    	}else loginFailed();
	}

	private void loginFailed() {
		System.out.println("logowanie nieudane");
	}

	private void loginSuccessful() {
		System.out.println("pomyslnie zalogowany");
	}


}
