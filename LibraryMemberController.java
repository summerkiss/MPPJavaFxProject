package edu.mum.cs.mpp.libarysys.view;

import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.dataaccess.LibMemberDataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.LibMemberDataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LibraryMemberController {
	@FXML
	private TextField txtLastName;
	
	@FXML
	private TextField txtFirstName;
	
	@FXML
	private TextField txtStreet;
	
	@FXML
	private TextField txtCity;
	
	@FXML
	private ComboBox<String> cbState;
	
	@FXML
	private TextField txtZip;
	
	@FXML
	private TextField txtPhoneNumber;
	
	@FXML
	private Button btnAddMember;
	@FXML
	private Label lbInformation;
	
	@FXML
    public void initialize() {
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Alabama",
			        "Alaska",
			        "Arizona"
			    );
		cbState.getItems().addAll(options);
	}
	
	@FXML
	public void AddMember(ActionEvent event){
		if(txtLastName.getText()==null||txtLastName.getText().equals("")
				||txtFirstName.getText()==null||txtFirstName.getText().equals("")){
			lbInformation.setText("Last name and first name can not be empty!");			
			lbInformation.visibleProperty().set(true);
			return;
		}
		
		
		if(txtStreet.getText()==null||txtStreet.getText().equals("")
				||txtCity.getText()==null||txtCity.getText().equals("")){
			lbInformation.setText("Street and City can not be empty!");			
			lbInformation.visibleProperty().set(true);
			return;
		}
		
		if(cbState.getValue()==null||cbState.getValue().equals("State")){
			lbInformation.setText("State must be selected!");			
			lbInformation.visibleProperty().set(true);
			return;
		}
		
		if(txtZip.getText()==null||txtZip.getText().equals("")){
			lbInformation.setText("Zip code can not be empty!");			
			lbInformation.visibleProperty().set(true);
			return;
		}
		
		if(txtPhoneNumber.getText()==null||txtPhoneNumber.getText().equals("")){
			lbInformation.setText("Phone Number must be provided!");			
			lbInformation.visibleProperty().set(true);
			return;
		}
		
		LibMemberDataAccess lda = new LibMemberDataAccessFacade();
		lda.saveLibraryMember(new LibraryMember(this.txtLastName.getText(),
				this.txtFirstName.getText(),"","","","",""));
	
	}
	
}
