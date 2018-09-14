package controllers;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ConversationScreenController {

	ArrayList<String> listOfCalls = new ArrayList<String>();
	
	@FXML
	MainScreenController mainScreenController;
	
	@FXML
	private TextArea readScreen;

	@FXML
	private TextArea writeScreen;

	
	@FXML
	public void initialize(){
		readScreen.setEditable(false);
	}
	
	
	
	@FXML
	void sendMessage(ActionEvent event) {
		listOfCalls.add(writeScreen.getText()+"\n");
		readScreen.clear();
		for(String x:listOfCalls) {
		}
		for(int x= 0;x<listOfCalls.size();x++) {
			if(listOfCalls.size()==0) {
				readScreen.appendText(listOfCalls.get(0));
			}else {
			readScreen.appendText(listOfCalls.get((listOfCalls.size()-1)-x)); 
			System.out.println(listOfCalls.get(x));
			}
		}
		writeScreen.clear();
	}
	
    @FXML
    void clickClose(ActionEvent event) {
    	Platform.exit();
    }


	public void setMainScreenController(MainScreenController mainScreenController) {
		this.mainScreenController = mainScreenController;
	}
}
