package controllers;

import java.io.IOException;

import configuration.Conf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginScreenController {

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
		if(loginTextField.getText().length() != 0 & passTextField.getText().length() != 0) {
			if(loginTextField.getText().equals(Conf.LOGIN) & passTextField.getText().equals(Conf.PASS)) {
	    		loginSuccessful();
	    	}else loginFailed();
		}else {
			emptyLoginPass.setText("podaj has³o i login !");
		}
		
	}

	public void loginFailed() {
		System.out.println("logowanie nieudane");
		String path = "/fxml/LoginFailed.fxml";
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
		Pane pane = null;
		
		try {
			pane = loader.load();
			System.out.println("za³adowano pane");
		} catch (IOException e) {
			System.out.println("nie uda³o sie za³adowaæ "+path);
			e.printStackTrace();
		}
		LoginFailedController loginFailedController = loader.getController();
		loginFailedController.setMainScreenController(mainScreenController);
		mainScreenController.setScreen(pane);
	}

	public void loginSuccessful() {
		System.out.println("pomyslnie zalogowany");
		String path = "/fxml/ConversationScreen.fxml";
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
		Pane pane = null;
		try {
			pane = loader.load();
			System.out.println("Za³adowano "+path);
		} catch (IOException e) {
			System.out.println("nie uda³o sie za³adowaæ "+path);
			e.printStackTrace();
		}
		ConversationScreenController conversationScreeenController = loader.getController();
		conversationScreeenController.setMainScreenController(mainScreenController);
		mainScreenController.setScreen(pane);
	}
	
    public void setMainScreenController(MainScreenController mainScreenController) {
		this.mainScreenController = mainScreenController;
	}


}
