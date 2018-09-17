package clientservercomunication;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ClientBridge {
	
	Thread clientThreads;
	public Client client;
	ArrayList<String> talkList;
	
	public ArrayList<String> getTalkList() {
		return talkList;
	}

	public ClientBridge(){
		
		clientThreads = new Thread(client = new Client());
		System.out.println("try start");
		clientThreads.start();
		System.out.println("start ok");
		
	}
	
	public void sendMessage(String message) {
		try {
			System.out.println("try send message");
			client.sendMessage(message);
			System.out.println("wys³ano na serwer");
		} catch (UnknownHostException e){System.out.println("Unknovwn host"); e.printStackTrace();} 
		  catch (IOException e) {System.out.println("ie excepton");e.printStackTrace();}
	}
	
	public void stopClientConnection() {
		try {
			client.stopConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
