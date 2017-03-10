package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecord;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecordEntry;
import edu.mum.cs.mpp.libarysys.business.LendableCopy;
import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.business.Publication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RecordInfoController implements Initializable {
	

	@FXML
	private Label idName;
	
	@FXML
	private TableView<CheckoutRecordEntry> tableID;
	@FXML
	private TableColumn<CheckoutRecordEntry, Integer> memberId;
	
	@FXML
	private TableColumn<CheckoutRecordEntry, String> isbnColumn = new TableColumn("ISBN");

	@FXML
	private TableColumn<CheckoutRecordEntry, Integer> copyIdColumn = new TableColumn("CopyId");

	@FXML
	private TableColumn<CheckoutRecordEntry, String> titleColumn = new TableColumn("Title");

	@FXML
	private TableColumn<CheckoutRecordEntry, LocalDate> checkoutDateColumn = new TableColumn("Checkout Date");
	
	@FXML
	private TableColumn<CheckoutRecordEntry, LocalDate> dueDateColumn = new TableColumn("Due Date");
	
	@FXML
	private Button back;
	
	private LibraryMember member;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		isbnColumn.setMinWidth(20);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		
		copyIdColumn.setMinWidth(20);
		copyIdColumn.setCellValueFactory(new PropertyValueFactory<>("copyId"));
		
		titleColumn.setMinWidth(200);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

		checkoutDateColumn.setMinWidth(200);
		checkoutDateColumn.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));

		dueDateColumn.setMinWidth(200);
		dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		
		
		tableID.getColumns().addAll(isbnColumn, copyIdColumn, titleColumn, checkoutDateColumn, dueDateColumn);
		
	}
	
	public ObservableList<CheckoutRecordEntry> getEntry() {
		ObservableList<CheckoutRecordEntry> checkoutRecordEntry = FXCollections.observableArrayList();
		CheckoutRecord checkoutRecord = member.getRecord();
		for(CheckoutRecordEntry entry:checkoutRecord.getEntries()){
			checkoutRecordEntry.add(entry);
		}
		return checkoutRecordEntry;
	}

	public void initDate(LibraryMember member) {
		
		this.member = member;
		idName.setText(member.getId());
		tableID.setItems(getEntry());

	}
	public void onBack(ActionEvent event) throws IOException {
		startForLibrarian("/edu/mum/cs/mpp/libarysys/view/librarianNa.fxml", event);
	}
	
	private void startForLibrarian(String url, ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		LibrarianNaviController librarianNaviController = loader.<LibrarianNaviController>getController();
		librarianNaviController.initDate(Main.getStaff());
		app_stage.setScene(scene);
		app_stage.show();	
	}	


}
