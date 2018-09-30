package configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Static class which configure all application's permissions and load file:
 * config.txt from path: /configuration/config.txt
 */
public class Conf {

	/**
	 * width scene
	 */
	public static int SWIDTH = 400;
	/**
	 * height scene
	 */
	public static int SHEIGHT = 400;
	// ----- default login and pass initialization----
	/**
	 * user's login
	 */
	public static String LOGIN = "tom";
	/**
	 * user's password
	 */
	public static String PASS = "sut";
	// -----------------------------------------------
	/**
	 * after start program,get path: config.txt in PATHCONF
	 */
	public static String PATHCONF = Conf.class.getResource("/configuration/config.txt").toString().trim();

	static BufferedReader bufferReader;
	/**
	 * default server ip
	 */
	public static String SERVER_IP = "127.0.0.1";
	/**
	 * default number server port
	 */
	public static int NUMBER_SERVER_PORT = 5000;

	static {
		PATHCONF = PATHCONF.substring(6);
		File path = new File(PATHCONF);
		FileReader fileReader = null;

		try {
			fileReader = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println("you can't create fileReader,path: " + path);
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

	/**
	 * load new pass and new login from config.txt
	 */
	public static void startConfig() {
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

		System.out.println("pobrane login: " + tempLog + " pass: " + tempPass);
	}

}
