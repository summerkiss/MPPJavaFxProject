package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LibrarianNaviController {
	@FXML
	private Button search;
	@FXML
	private Button admistratorNavi;
	public void search(ActionEvent event) throws IOException {
		System.out.println("this search");
		
	}
	public void admistratorNavi(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/administratorNavi.fxml"));
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();	
		
	}
}
