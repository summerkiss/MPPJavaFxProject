package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.LendableCopy;
import edu.mum.cs.mpp.libarysys.business.Staff;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewBookController {


	@FXML
	private Label pageTitle;

	@FXML
	private Label wrongInput;

	@FXML
	private TextField bookTitle;

	@FXML
	private TextArea author;

	@FXML
	private TextField bookID;

	@FXML
	private TextField ISBNnum;

	@FXML
	private TextField numOfCopies;

	@FXML
	private Button newBookBtn;

	@FXML
	private Button backBtn;

	private Staff staff;
	public void initData(Staff staff) {
		this.staff = staff;
	}


	public void newBook(ActionEvent event){
		boolean authentication = true;
		List<String> authors = new ArrayList<String>();
		if(author.getText() != null|| author.getText().indexOf(",") > 0){
			for(String s: author.getText().split(",")){
				authors.add(s);
			}
		}else if(author.getText().length() != 0){
			authors.add(author.getText());
		}else{
			wrongInput.setText("The book must have at least one author");
			wrongInput.setVisible(true);
			authentication = false;

		}
		try{
			Integer.parseInt(bookID.getText());
			Integer.parseInt(numOfCopies.getText());
		}catch(NumberFormatException e){
			wrongInput.setText("bookID and the number of copies must be numbers");
			wrongInput.setVisible(true);
			authentication = false;
		}finally{
			if(!(ISBNnum.getText().matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$"))){
				wrongInput.setText("Invalid ISBN number");
				wrongInput.setVisible(true);
				authentication = false;
			}
		}

		if(authentication){
			Book newBook = new Book(Integer.parseInt(bookID.getText()), ISBNnum.getText(), bookTitle.getText(), authors, true, new ArrayList<LendableCopy>());

			for(int n=0; n<Integer.parseInt(numOfCopies.getText()); n++){
				newBook.addCopy();
				}

			DataAccess da = new DataAccessFacade();
			da.saveBook(newBook);
			wrongInput.setVisible(false);
			}
		}



	public void backBtn(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/administratorNavi.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AdministratorNaviController administratorNaviController = loader.<AdministratorNaviController>getController();
		administratorNaviController.initDate(staff);
		app_stage.setScene(scene);
		app_stage.show();

	}
}
