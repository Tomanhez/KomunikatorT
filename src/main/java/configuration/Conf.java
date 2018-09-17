package configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Conf {
	/*
	 * width and height scene
	 */
	public static int SWIDTH = 600;
	public static int SHEIGHT = 600;
	/*
	 * default login and pass
	 */
	public static String LOGIN = "tom";
	public static String PASS = "sut";
	/*
	 * load new pass and login from path
	 */
	public static String PATHCONF = Conf.class.getResource("/configuration/config.txt").toString().trim();//path of the acces file
	
	BufferedReader bufferReader;
	/*
	 * default server initialize
	 */
	public static String SERVER_IP = "127.0.0.1";
	public static int NUMBER_SERVER_PORT = 5000;
	
	public Conf() {
		PATHCONF = PATHCONF.substring(6);
		File path = new File(PATHCONF);
		FileReader fileReader = null;
		
		try {
			fileReader = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println("you can't create fileReader,path: "+path);
			e.printStackTrace();
		}
		bufferReader = new BufferedReader(fileReader);
		startConfig();
		try {
			fileReader.close();
			bufferReader.close();
		} catch (IOException e) {
			System.out.println("you can't close streams");
			e.printStackTrace();
		}
	}
	

	public void startConfig() {
		String tempLog = "";
		String tempPass = "";
		try {
			tempLog = bufferReader.readLine().substring(6);
			tempPass = bufferReader.readLine().substring(5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGIN = tempLog;
		PASS = tempPass;
		
		System.out.println("pobrane login: "+tempLog+" pass: "+tempPass);
	}

	
	
}
