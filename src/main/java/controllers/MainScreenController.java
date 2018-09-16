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
	public void loadMainScreen() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/LoginScreen.fxml"));
		Pane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			System.out.println("nie uda³o sie za³adowaæ LoginScreen");
			e.printStackTrace();
		}
		LoginScreenController loginController = loader.getController();
		loginController.setMainScreenController(this);
		System.out.println("dalej");
		setScreen(pane);
	}
	/*
	 * set screen
	 */
	public void setScreen(Pane pane) {
		mainStackPane.getChildren().clear();
		mainStackPane.getChildren().add(pane);
	}
}
