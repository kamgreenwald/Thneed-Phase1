package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			File file = new File("OrderList.txt");
			if (file.exists()) {
				try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                System.out.println(line);
		            }
				}
			
				catch(Exception e) {
					System.out.println("Error");
				}
			}
			else {

			primaryStage.setTitle("All Orders");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/OrderGUI.fxml"));
			AnchorPane mainLayout = (AnchorPane)loader.load();
			Scene scene = new Scene(mainLayout);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
			catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
