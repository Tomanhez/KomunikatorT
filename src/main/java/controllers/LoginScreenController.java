package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginScreenController {

	private static String SLOGIN = "tom";
	private static String SPASS = "sut";
	
	@FXML
	MainScreenController mainScreenController;
	
    @FXML
    private Label emptyLoginPass;
	
    @FXML
    private Pane loginPane;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passTextField;

    @FXML
    void buttonLogin(ActionEvent event) {
    	System.out.println("buttonLogin - action - ok");
    	checkLog();
    }

	public void checkLog() {
		if(loginTextField.getText().length() != 0 | passTextField.getText().length() != 0) {
			if(loginTextField.getText().equals(SLOGIN) || passTextField.getText().equals(SPASS)) {
	    		loginSuccessful();
	    	}else loginFailed();
		}else {
			emptyLoginPass.setText("podaj has³o i login !");
		}
		
	}

	public void loginFailed() {
		System.out.println("logowanie nieudane");
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/LoginFailed.fxml"));
		Pane pane = null;
		
		try {
			pane = loader.load();
			System.out.println("za³adowano pane");
		} catch (IOException e) {
			System.out.println("nie uda³o sie za³adowaæ /fxml/LoginFailed");
			e.printStackTrace();
		}
		LoginFailedController loginFailedController = loader.getController();
		loginFailedController.setMainScreenController(mainScreenController);
		mainScreenController.setScreen(pane);
	}

	public void loginSuccessful() {
		System.out.println("pomyslnie zalogowany");
	}
	
	/*
	 * set main screen
	 */
    public void setMainScreenController(MainScreenController mainScreenController) {
		this.mainScreenController = mainScreenController;
	}


}
