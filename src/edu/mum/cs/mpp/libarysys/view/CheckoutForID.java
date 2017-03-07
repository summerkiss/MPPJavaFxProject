package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CheckoutForID implements Initializable {
	@FXML
	private Button searchID;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void search(ActionEvent event) throws IOException {
		System.out.println("this in checkout.");
	}
	public void checkout(ActionEvent event) throws IOException {
		System.out.println("this search");
		startCheckoutCopyInfo("/edu/mum/cs/mpp/libarysys/view/CheckoutCopyInfo.fxml", event);
	}	
	public void startCheckoutCopyInfo(String url, ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		LibrarianNaviController librarianNaviController = loader.<LibrarianNaviController>getController();
//		librarianNaviController.initDate(staff);
		app_stage.setScene(scene);
		app_stage.show();
		
	}
}
