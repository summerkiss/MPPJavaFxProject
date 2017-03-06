package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.mum.cs.mpp.libarysys.business.Staff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LibrarianNaviController implements Initializable {
	@FXML
	private Button search;
	@FXML
	private Button admistratorNavi;
	@FXML
	private TextField isbnText;
	private Staff staff;
	public void search(ActionEvent event) throws IOException {
		System.out.println("this search");
		
	}
	public void admistratorNavi(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/administratorNavi.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AdministratorNaviController administratorNaviController = loader.<AdministratorNaviController>getController();
		administratorNaviController.initDate(staff);		
		app_stage.setScene(scene);
		app_stage.show();	
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		admistratorNavi.setDisable(false);
	}
	public void initDate(Staff staff) {
		this.staff = staff;
		if (staff.isAdministrator()) {
			admistratorNavi.setDisable(true);
		}
		
	}
}
