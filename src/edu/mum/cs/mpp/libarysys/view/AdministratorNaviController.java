package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import edu.mum.cs.mpp.libarysys.business.Authorization;
import edu.mum.cs.mpp.libarysys.business.Staff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdministratorNaviController implements Initializable {
	@FXML
	private Button addUser;
	@FXML
	private Button btnSearchUser;
	@FXML
	private Button addBook;
	@FXML
	private Button libraryNavi;
	@FXML
	private Button addCopies;

	private Staff staff;


	public void addUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibraryMemberAdd.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		LibraryMemberController libraryMemberController = loader.<LibraryMemberController>getController();
		Hashtable iniData = new Hashtable();
		iniData.put("page", "administratorNavi.fxml");
		iniData.put("staff", staff);
		libraryMemberController.setIniData(iniData);
		app_stage.setScene(scene);
		app_stage.show();
	}
	public void searchUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibraryMemberSearch.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		LibraryMemberSearchController ibraryMemberSearchController = loader.<LibraryMemberSearchController>getController();
		Hashtable iniData = new Hashtable();
		iniData.put("page", "administratorNavi.fxml");
		iniData.put("staff", staff);
		ibraryMemberSearchController.setIniData(iniData);
		app_stage.setScene(scene);
		app_stage.show();

	}

	public void addBook(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/NewBook.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.setScene(scene);
		app_stage.show();

	}

	public void libraryNavi(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/librarianNa.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		LibrarianNaviController librarianNaviController = loader.<LibrarianNaviController>getController();
		librarianNaviController.initDate(staff);
		app_stage.setScene(scene);
		app_stage.show();

	}
	public void addCopies(ActionEvent event) throws IOException {
		System.out.println("this in add copies.");

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		libraryNavi.setDisable(true);
	}
	public void initDate(Staff staff) {
		this.staff = staff;
		if (staff.getAu() == Authorization.BOTH ||
			staff.getAu() == Authorization.LIBRARIAN) {
			libraryNavi.setDisable(false);
		}
	}
}
