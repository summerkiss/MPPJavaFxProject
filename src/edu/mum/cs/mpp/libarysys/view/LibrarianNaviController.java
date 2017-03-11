package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.mum.cs.mpp.libarysys.business.Authorization;
import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.business.Staff;
import edu.mum.cs.mpp.libarysys.dataaccess.BookDataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.BookDataAccessFacade;
import edu.mum.cs.mpp.libarysys.dataaccess.LibMemberDataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LibrarianNaviController implements Initializable {
	@FXML
	private Button search;
	@FXML
	private Button admistratorNavi;
	@FXML
	private TextField isbnText;
	@FXML
	private Button searchRecord;
	@FXML
	private TextField idText;
	@FXML
	private Label errInfo;

	@FXML
	private Label idLabel;
	@FXML
	private Label forLibrarian;

	private Staff staff;
	public void search(ActionEvent event) throws IOException {
		BookDataAccess da = new BookDataAccessFacade();
		Book book = da.readBook(isbnText.getText());
		if (book == null) {
			errInfo.setVisible(true);
			errInfo.setText("Can not find the book");
			return;
		}
		startSearchResult("/edu/mum/cs/mpp/libarysys/view/BookInformation.fxml", event, book);
	}

	public void searchRecord(ActionEvent event) throws IOException {
		LibMemberDataAccessFacade da = new LibMemberDataAccessFacade();
		LibraryMember member = da.readLibraryMember(idText.getText());
		if (member == null) {
			errInfo.setVisible(true);
			errInfo.setText("Can not find the member ID.");
			return;
		}

		startSearchRecord("/edu/mum/cs/mpp/libarysys/view/RecordInfo.fxml", event, member);
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
		admistratorNavi.setDisable(true);
		errInfo.setVisible(false);
	}


	public void initDate(Staff staff) {
		this.staff = staff;
		if (staff.getAu() == Authorization.ADMIN ||
			staff.getAu() == Authorization.BOTH) {
			admistratorNavi.setDisable(false);
		}


		if (staff.getAu() == Authorization.ADMIN){

			forLibrarian.setVisible(false);
			idLabel.setVisible(false);
			idText.setVisible(false);
			searchRecord.setVisible(false);
		}

	}
	private void startSearchResult(String url, ActionEvent event, Book book) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		BookInformationController bookInformationController = loader.<BookInformationController>getController();
		bookInformationController.initDate(staff, book);
		app_stage.setScene(scene);
		app_stage.show();
	}
	private void startSearchRecord(String url, ActionEvent event, LibraryMember member) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		RecordInfoController recordInfoController = loader.<RecordInfoController>getController();
		recordInfoController.initDate(member);
		app_stage.setScene(scene);
		app_stage.show();
	}

}
