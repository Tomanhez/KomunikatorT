package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class LoginFailedController {
	
	@FXML
	MainScreenController mainScreenController;
	
    @FXML
    private Pane loginFailedPane;
    
	
    public void setMainScreenController(MainScreenController mainScreenController) {
		this.mainScreenController = mainScreenController;
	}

	@FXML
    void tryAgainButton(ActionEvent event) {
    	System.out.println("try again");
    	mainScreenController.loadMainScreen();
    }

}