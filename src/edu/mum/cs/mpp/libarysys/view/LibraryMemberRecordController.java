package edu.mum.cs.mpp.libarysys.view;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecord;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecordEntry;
import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.business.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LibraryMemberRecordController {
	@FXML private Label lbLibMember;	
	@FXML private Button btnBack;	
	@FXML private TableView<CheckoutRecordEntry> tbCheckoutRecord;
	
	private Hashtable iniData;
	private Staff staff;
	private ObservableList<CheckoutRecordEntry> data;
	private LibraryMember member;
	
	@FXML
    public void initialize() {		
		TableColumn<CheckoutRecordEntry, String> titleCol 
			= new TableColumn<CheckoutRecordEntry, String>("Title");
		titleCol.setMinWidth(100);
		titleCol.setStyle("-fx-alignment: CENTER;");
		titleCol.setCellValueFactory(new PropertyValueFactory<CheckoutRecordEntry, String>("title"));
		
		TableColumn<CheckoutRecordEntry, String> outDateCol 
		
			= new TableColumn<CheckoutRecordEntry, String>("Checkout Date");
        outDateCol.setMinWidth(100);
        outDateCol.setCellValueFactory(
                new PropertyValueFactory<CheckoutRecordEntry, String>("checkoutDate"));
		
		TableColumn<CheckoutRecordEntry, String> dueDateCol 
			= new TableColumn<CheckoutRecordEntry, String>("Due Date");
        dueDateCol.setMinWidth(100);
        dueDateCol.setCellValueFactory(
                new PropertyValueFactory<CheckoutRecordEntry, String>("dueDate"));
        
        TableColumn<CheckoutRecordEntry, String> isbnCol 
        	= new TableColumn<CheckoutRecordEntry, String>("ISBN");
        isbnCol.setMinWidth(100);
        isbnCol.setCellValueFactory(
                new PropertyValueFactory<CheckoutRecordEntry, String>("isbn"));
        
        TableColumn<CheckoutRecordEntry, String> authorColumn 
        	= new TableColumn<CheckoutRecordEntry, String>("Author");
        authorColumn.setMinWidth(100);
        authorColumn.setCellValueFactory(
        		new PropertyValueFactory<CheckoutRecordEntry, String>("authorPrintList"));
        
        TableColumn<CheckoutRecordEntry, String> copyIdCol 
        	= new TableColumn<CheckoutRecordEntry, String>("Copy ID");
        copyIdCol.setMinWidth(100);
        copyIdCol.setCellValueFactory(
                new PropertyValueFactory<CheckoutRecordEntry, String>("copyID"));
        	     
        tbCheckoutRecord.getColumns().addAll(titleCol, outDateCol, dueDateCol,authorColumn,isbnCol,copyIdCol);
	}
	
	void setIniData(Hashtable iniData){
		this.iniData = iniData;
		
		if(iniData!=null&&iniData.size()>0){
			member = (LibraryMember)iniData.get("edit");
			if(member!=null){
				final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				Book book1 = new Book(5, "11-11", "ÆßÁúÖé", Arrays.asList("ÄñÉ½Ã÷"), true, null);	
				LocalDate checkDate = LocalDate.parse("24-12-2014", dtf);
				LocalDate dueDate = LocalDate.parse("31-12-2014", dtf);
				CheckoutRecordEntry entry1 = new CheckoutRecordEntry(2, checkDate, dueDate, book1);
				
				Book book2 = new Book(5, "22-11", "Thriller", Arrays.asList("Micheal Jackson"), true, null);	
				checkDate = LocalDate.parse("02-02-2017", dtf);
				dueDate = LocalDate.parse("23-02-2017", dtf);
				CheckoutRecordEntry entry2 = new CheckoutRecordEntry(2, checkDate, dueDate, book2);
				
				Book book3 = new Book(5, "33-11", "Thinking in Java (4th Edition)", Arrays.asList("Bruce Eckel"), true, null);	
				checkDate = LocalDate.parse("18-02-2017", dtf);
				dueDate = LocalDate.parse("25-02-2017", dtf);
				CheckoutRecordEntry entry3 = new CheckoutRecordEntry(2, checkDate, dueDate, book3);
				
				CheckoutRecord record = new CheckoutRecord();
				record.addEntry(entry1);
				record.addEntry(entry2);
				record.addEntry(entry3);
				 data =  FXCollections.observableArrayList(
						 record.getEntries());
				 tbCheckoutRecord.setItems(data);
			}
				
			
		}else{
			System.out.println("member is null");
		}
	}
	
}
