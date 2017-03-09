package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.business.Staff;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;
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
import javafx.stage.Stage;

public class CheckoutForID implements Initializable {
	@FXML
	private Button searchID;
	@FXML
	private Label dueDate;
	@FXML
	private Label isbn;
	@FXML
	private Label title;
	@FXML
	private Label authors;
	@FXML
	private TextField idText;
	@FXML
	private Label errorInfo;
	
	private Book book;
	LibraryMember member;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	public boolean search() {
		errorInfo.setVisible(false);
		DataAccess da = new DataAccessFacade();
		if(idText.getLength() == 0) {
			errorInfo.setText("Please input the member ID");
			errorInfo.setVisible(true);
			return false;
		}
		LibraryMember member = da.readLibraryMember(idText.getText());
		if (member == null) {
			errorInfo.setText("No member ID existed");
			return false;
		}
		this.member = member;
		return true;
	}
	public void checkout(ActionEvent event) throws IOException {
		if (!search()) {
			return;
		}
		startCheckoutCopyInfo("/edu/mum/cs/mpp/libarysys/view/CheckoutCopyInfo.fxml", event);
	}	
	public void startCheckoutCopyInfo(String url, ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		CheckoutCopyInfoControl checkoutCopyInfoControl = loader.<CheckoutCopyInfoControl>getController();
		checkoutCopyInfoControl.initDate(book, member.getId());
		app_stage.setScene(scene);
		app_stage.show();
		
	}
	public void initDate(Book book) {
		this.book = book;
		isbn.setText(book.getIsbn());
		title.setText(book.getTitle());
		StringBuilder strbld = new StringBuilder();
		for(String author:book.getAuthorList()) {
			strbld.append(author);
			strbld.append(";");
		}
		authors.setText(strbld.toString());
		LocalDate dueDate = LocalDate.now();
		this.dueDate.setText(dueDate.plusDays(20).toString());
	}	
}
