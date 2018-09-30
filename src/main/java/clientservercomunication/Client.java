package clientservercomunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import configuration.Conf;
/**
 * Class which implements Runnable() and create,configure to connection with server
 */
public class Client implements Runnable {

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	ArrayList<String> talkList;

	public ArrayList<String> getTalkList() {
		return talkList;
	}

	public Client() {
		talkList = new ArrayList<>();
		try {
			System.out.println("try start connection");
			startConnection(Conf.SERVER_IP, Conf.NUMBER_SERVER_PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startConnection(String ip, int port) throws UnknownHostException, IOException {
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}

	public void sendMessage(String msg) throws IOException {
		out.println(msg);
	}

	public String getMessage() throws IOException {
		return in.readLine();
	}

	public void stopConnection() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
	}

	@Override
	public void run() {
		while(true) {
			try {
				talkList.add(getMessage() + "\n");
			} catch (IOException e) {
				System.out.println("run client - problem");
				StaticClient.getClientThreads().destroy();//????
			}
		}
	}
}