package komunikatorT;

import configuration.Conf;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Conf();//load configuration
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
		StackPane basicStackPane = loader.load(); 
		Scene scene = new Scene(basicStackPane,Conf.SWIDTH,Conf.SHEIGHT);
		primaryStage.setTitle("TKomunikator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
