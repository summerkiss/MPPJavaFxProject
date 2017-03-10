package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;

import application.Main;
import edu.mum.cs.mpp.libarysys.business.Authorization;
import edu.mum.cs.mpp.libarysys.business.Staff;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Label lbInformation;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPwd;

	@FXML
	private Button btnLogin;

	private Staff staff;

	public void Login(ActionEvent event) throws IOException {
		DataAccess da = new DataAccessFacade();
//		Application app = null;

//*********************below*************************************
		//Data storage function does not work yet, use the code below for test
		//Staff staff = (Staff)da.readStaff(txtUsername.getText());
		//Staff s = new Staff("YuYang","123456",Authorization.BOTH);
//		Staff s = new Staff("YiHong","123456",Authorization.ADMIN);
		Staff s = new Staff("Rowe","123456",Authorization.ADMIN);
		staff = s;
		Main.setStaff(s);
//********************above***********************************
		if(staff==null||
				!staff.getPassword().equals(txtPwd.getText())){
			lbInformation.setText("User name or password is not correct");
			lbInformation.visibleProperty().set(true);
		} else if(staff.getPassword().equals(txtPwd.getText())){
			this.staff = staff;
			if (staff.getAu() == Authorization.BOTH ||
				staff.getAu() == Authorization.LIBRARIAN) {
				startForLibrarian("/edu/mum/cs/mpp/libarysys/view/librarianNa.fxml", event);
			} else {
				startForAdministrator("/edu/mum/cs/mpp/libarysys/view/administratorNavi.fxml", event);
			}
		}

	}
	private void startForLibrarian(String url, ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		LibrarianNaviController librarianNaviController = loader.<LibrarianNaviController>getController();
		librarianNaviController.initDate(staff);
		app_stage.setScene(scene);
		app_stage.show();


	}
	private void startForAdministrator(String url, ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AdministratorNaviController administratorNaviController = loader.<AdministratorNaviController>getController();
		administratorNaviController.initDate(staff);
		app_stage.setScene(scene);
		app_stage.show();
	}
}
