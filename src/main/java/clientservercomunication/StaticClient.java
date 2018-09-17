package clientservercomunication;

import java.util.ArrayList;

public class StaticClient {
	
	public static ClientBridge clientB;
	
	public static void sendMessage(String message) {
		clientB.sendMessage(message);
	}
	
	public static void stopClient() {
		clientB.stopClientConnection();
	}
	
	public static ArrayList<String> getListFromServer() {
		return clientB.getTalkList();
	}
	
}
