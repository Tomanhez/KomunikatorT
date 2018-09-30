package clientservercomunication;

import java.util.ArrayList;

/**
 * StaticClient is a class which have instance of ClientBridge and ClientBridge have and operate with instance of Client
 * We need instance Client in order to operate in IO/OUT
 */
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
	
	public static Thread getClientThreads() {
		return clientB.getClientThreads();
	}
	
}
