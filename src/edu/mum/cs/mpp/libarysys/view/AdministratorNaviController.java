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

public class AdministratorNaviController {
	@FXML
	private Button addUser;
	@FXML
	private Button updateUser;
	@FXML
	private Button addBook;
	@FXML
	private Button libraryNavi;
	@FXML
	private Button addCopies;
	
	public void addUser(ActionEvent event) throws IOException {
		System.out.println("this in add user.");
	}
	public void updateUser(ActionEvent event) throws IOException {
		System.out.println("this in update user.");
		
	}

	public void addBook(ActionEvent event) throws IOException {
		System.out.println("this in add book.");
		
	}

	public void libraryNavi(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/librarianNa.fxml"));
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();	
		
	}
	public void addCopies(ActionEvent event) throws IOException {
		System.out.println("this in add copies.");
		
	}
}
