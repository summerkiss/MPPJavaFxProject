package edu.mum.cs.mpp.libarysys.view;

import java.util.ArrayList;
import java.util.List;
import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

	public void newBook(ActionEvent event){



		List<String> authors = new ArrayList<String>();
		if(author.getText() != null|| author.getText().indexOf(",") > 0){
			for(String s: author.getText().split(",")){
				authors.add(s);
			}
		}
		try{
			Integer.parseInt(bookID.getText());
			Integer.parseInt(numOfCopies.getText());
		}catch(NumberFormatException e){
			wrongInput.setText("bookID and the number of copies must be numbers");
		}finally{
			if(!(ISBNnum.getText().matches("^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$"))){
				wrongInput.setText("Invalid ISBN number");
			}
		}

		Book newBook = new Book(Integer.parseInt(bookID.getText()), ISBNnum.getText(), bookTitle.getText(), authors,true);

		for(int n=0; n<Integer.parseInt(numOfCopies.getText()); n++){
			newBook.addCopy();
			}

		DataAccess da = new DataAccessFacade();
		da.saveBook(newBook);
	}
}
