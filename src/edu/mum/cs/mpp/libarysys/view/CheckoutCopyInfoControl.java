package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import edu.mum.cs.mpp.libarysys.business.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
	private Book book;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void initDate(Book book, String memberID) {
		this.book = book;
		this.isbn.setText(book.getIsbn());
		this.title.setText(book.getTitle());
		this.id.setText(memberID);
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
		book.decreaseLendableCopy(book.getLendableCopyList().get(0));
	}	
	

}
