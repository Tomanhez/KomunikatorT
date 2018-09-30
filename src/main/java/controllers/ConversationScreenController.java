package controllers;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import clientservercomunication.Client;
import clientservercomunication.ClientBridge;
import clientservercomunication.StaticClient;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ConversationScreenController {

	ArrayList<String> listOfCalls = new ArrayList<String>();
	
	@FXML
	MainScreenController mainScreenController;
	/**
	 *  It is an area which set text from listOfCalls
	 */
	@FXML
	private TextArea readScreen;

	/**
	 *  It is an area from which we get text and call to readScreen
	 */
	@FXML
	private TextArea writeScreen;

	
	@FXML
	public void initialize(){
		readScreen.setEditable(false);
	}
	
	
	@FXML
	void sendMessage(ActionEvent event) {
		//sending
		StaticClient.sendMessage(writeScreen.getText());//client
		System.out.println("sendMessageOk ok");
		listOfCalls = StaticClient.getListFromServer();
		
		//display
		readScreen.clear();
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
