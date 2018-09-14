package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainScreenController {
	
	@FXML
	private StackPane mainStackPane;
	
	@FXML
	public void initialize() {
		loadMainScreen();
	}
	
	@FXML
	private void loadMainScreen() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/LoginScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LoginScreenController loginController = loader.getController();
		
		
		mainStackPane.getChildren().clear();
		mainStackPane.getChildren().add(pane);
	}
}
