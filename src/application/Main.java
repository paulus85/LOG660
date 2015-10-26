package application;

import org.hibernate.Session;

import db.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	private static Session sessionHome = HibernateUtil.getSession();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/WebFlixApp.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("WebFlix Application");
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		sessionHome.close();
	}
}
