package edu.mum.cs.mpp.libarysys.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.ResourceBundle;

import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecord;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecordEntry;
import edu.mum.cs.mpp.libarysys.business.LendableCopy;
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
	private TableColumn<CheckoutRecordEntry, Integer> copyIdColumn = new TableColumn("CopyId");

	@FXML
	private TableColumn<CheckoutRecordEntry, String> titleColumn = new TableColumn("Title");

	@FXML
	private TableColumn<CheckoutRecordEntry, LocalDate> checkoutDateColumn = new TableColumn("Checkout Date");
	
	@FXML
	private TableColumn<CheckoutRecordEntry, LocalDate> dueDateColumn = new TableColumn("Due Date");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		copyIdColumn.setMinWidth(20);
		copyIdColumn.setCellValueFactory(new PropertyValueFactory<>("copyId"));
		
		titleColumn.setMinWidth(200);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

		checkoutDateColumn.setMinWidth(200);
		checkoutDateColumn.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));

		dueDateColumn.setMinWidth(200);
		dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		
		
		tableID.setItems(getEntry());
		tableID.getColumns().addAll(copyIdColumn, titleColumn, checkoutDateColumn, dueDateColumn);
		
	}
	
	public ObservableList<CheckoutRecordEntry> getEntry() {
		ObservableList<CheckoutRecordEntry> checkoutRecordEntry = FXCollections.observableArrayList();
		Book book = new Book(1, "abc123", "caption", Arrays.asList("Yifeng Zhong", "Yang Yu", "Matthew"));
		checkoutRecordEntry.add(new CheckoutRecordEntry(new LendableCopy(null,1),LocalDate.now(),LocalDate.now(), book));
		checkoutRecordEntry.add(new CheckoutRecordEntry(new LendableCopy(null,1),LocalDate.now(),LocalDate.now(), book));
		checkoutRecordEntry.add(new CheckoutRecordEntry(new LendableCopy(null,1),LocalDate.now(),LocalDate.now(), book));
		checkoutRecordEntry.add(new CheckoutRecordEntry(new LendableCopy(null,1),LocalDate.now(),LocalDate.now(), book));
		return checkoutRecordEntry;
	}

}
