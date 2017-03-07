package edu.mum.cs.mpp.libarysys.view;

import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.LendableCopy;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewBookController {


	@FXML
	private Label pageTitle;

	@FXML
	private TextField bookTitle;

	@FXML
	private TextField author;

	@FXML
	private TextField bookID;

	@FXML
	private TextField ISBNnum;

	@FXML
	private TextField numOfCopies;

	@FXML
	private Button newBookBtn;

	public void newBook(ActionEvent event){
		Book newBook = new Book(Integer.parseInt(bookID.getText()), ISBNnum.getText(), bookTitle.getText());
		for(int n=0; n<Integer.parseInt(numOfCopies.getText()); n++){
			newBook.addCopy();
			}

		DataAccess da = new DataAccessFacade();
		da.saveBook(newBook);
	}
}
