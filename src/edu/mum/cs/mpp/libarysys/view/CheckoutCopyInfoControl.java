package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.Main;
import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.dataaccess.LibMemberDataAccess;
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
import javafx.stage.Stage;

public class CheckoutCopyInfoControl implements Initializable  {
	@FXML
	private Label dueDate;
	@FXML
	private Label isbn;
	@FXML
	private Label title;
	@FXML
	private Label authors;
	@FXML
	private Label id;
	@FXML
	private Label copyId;
	@FXML
	private Button checkout;

	private Book book;
	LibraryMember member;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void initDate(Book book, LibraryMember member) {
		this.member = member;
		this.book = book;
		this.isbn.setText(book.getIsbn());
		this.title.setText(book.getTitle());
		this.id.setText(member.getId());
		this.copyId.setText(String.valueOf(book.getLendableCopyList().get(0).getCopyId()));
		StringBuilder strbld = new StringBuilder();
		for(String author:book.getAuthorList()) {
			strbld.append(author);
			strbld.append(";");
		}
		authors.setText(strbld.toString());
		LocalDate dueDate = LocalDate.now();
		this.dueDate.setText(dueDate.plusDays(20).toString());

	}
	
	public void onCheckout(ActionEvent event) throws IOException {
		if(checkout.getText().equals("Back")) {
			startForLibrarian("/edu/mum/cs/mpp/libarysys/view/librarianNa.fxml", event);
		} else {
			book.decreaseLendableCopy(book.getLendableCopyList().get(0));
			member.updateRecord(book,copyId.getText());
			LibMemberDataAccess da = new LibMemberDataAccessFacade();
			if(da.saveLibraryMember(member)) {
				checkout.setText("Back");
			}
		}
		
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
