package application;

import edu.mum.cs.mpp.libarysys.business.Staff;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	static private Staff staff;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(
					 "/edu/mum/cs/mpp/libarysys/view/Login.fxml"));
			Scene scene = new Scene(root,400,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			AquaFx.style();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    public static Staff getStaff() {
    	return staff;
    }
    public static void setStaff(Staff staff) {
    	Main.staff = staff;
    }
	public static void main(String[] args) {
		launch(args);
	}
}
