package edu.mum.cs.mpp.libarysys.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecord;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecordEntry;
import edu.mum.cs.mpp.libarysys.business.LendableCopy;
import edu.mum.cs.mpp.libarysys.business.Publication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecordInfoController implements Initializable {
	
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
		
		
		tableID.setItems(getEntry());
		tableID.getColumns().addAll(isbnColumn, copyIdColumn, titleColumn, checkoutDateColumn, dueDateColumn);
		
	}
	
	public ObservableList<CheckoutRecordEntry> getEntry() {
		ObservableList<CheckoutRecordEntry> checkoutRecordEntry = FXCollections.observableArrayList();
		//TODO *************below for test************
		List<LendableCopy> lendablecopyList = new ArrayList<LendableCopy>(); 
		lendablecopyList.add(new LendableCopy(new Publication("first one"),1));
		lendablecopyList.add(new LendableCopy(new Publication("second"),2));
		//************above for test******************
				
		Book book = new Book(1, "123-34522-111235", "caption", Arrays.asList("Yifeng Zhong", "Yang Yu", "Matthew"),true,lendablecopyList);
		checkoutRecordEntry.add(new CheckoutRecordEntry(new LendableCopy(null,1),LocalDate.now(),LocalDate.now(), book));
		checkoutRecordEntry.add(new CheckoutRecordEntry(new LendableCopy(null,1),LocalDate.now(),LocalDate.now(), book));
		checkoutRecordEntry.add(new CheckoutRecordEntry(new LendableCopy(null,1),LocalDate.now(),LocalDate.now(), book));
		checkoutRecordEntry.add(new CheckoutRecordEntry(new LendableCopy(null,1),LocalDate.now(),LocalDate.now(), book));
		return checkoutRecordEntry;
	}

}
