package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import edu.mum.cs.mpp.libarysys.business.Authorization;
import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.LendableCopy;
import edu.mum.cs.mpp.libarysys.business.Publication;
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
import javafx.stage.Stage;

public class BookInformationController implements Initializable {

	@FXML
	private Button checkout;

	@FXML
	private Label isbn;
	@FXML
	private Label title;
	@FXML
	private Label authors;
	@FXML
	private Label number;

	@FXML
	private Button addCopy;

	private Staff staff;

	private Book book;

	public void checkout(ActionEvent event) throws IOException {
		startCheckoutProcedure("/edu/mum/cs/mpp/libarysys/view/CheckoutForID.fxml", event);
	}

	public void back(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibrarianNa.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		LibrarianNaviController librarianNaviController = loader.<LibrarianNaviController>getController();
		librarianNaviController.initDate(staff);
		DataAccess da = new DataAccessFacade();
		da.saveBook(book);
		app_stage.setScene(scene);
		app_stage.show();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//TODO *************below for test************
		List<LendableCopy> lendablecopyList = new ArrayList<LendableCopy>();
		lendablecopyList.add(new LendableCopy(new Publication("first one"),1));
		lendablecopyList.add(new LendableCopy(new Publication("second"),2));
		//************above for test******************
		Book book = new Book(123,"9780553418026", "The Martian",Arrays.asList("Andy Weir"),true,lendablecopyList);
		this.book = book;
		isbn.setText(book.getIsbn());
		title.setText(book.getTitle());
		if(book.isAvailable()) {
			number.setText("Available");
			checkout.setDisable(false);
		} else {
			number.setText("Not Available");
			checkout.setDisable(true);
		}
		StringBuilder strbld = new StringBuilder();
		for(String author:book.getAuthorList()) {
			strbld.append(author);
			strbld.append(";");
		}
		authors.setText(strbld.toString());

	}
	public void initDate(Staff staff) {
		this.staff = staff;

		if(staff.getAu() == Authorization.ADMIN){
			checkout.setDisable(true);
		}

	}

	private void startCheckoutProcedure(String url, ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		CheckoutForID checkoutForID = loader.<CheckoutForID>getController();
		checkoutForID.initDate(book);
		app_stage.setScene(scene);
		app_stage.show();
	}

	public void addCopy(ActionEvent event){
		book.addCopy();
	}

}
