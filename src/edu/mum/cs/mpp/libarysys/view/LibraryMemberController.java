package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.util.Hashtable;

import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.dataaccess.LibMemberDataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.LibMemberDataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

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
	private Button btnBack;
	
	@FXML
	private Label lbInformation;
	
	private Hashtable iniData;
	private LibraryMember member;
	
	
	void setIniData(Hashtable iniData){
		this.iniData = iniData;
		
		if(iniData!=null&&iniData.size()>0){
			member = (LibraryMember)iniData.get("edit");
			if(member!=null){
				txtLastName.setText(member.getLastName());
				txtFirstName.setText(member.getFirstName());
				txtStreet.setText(member.getStreet());
				txtCity.setText(member.getCity());
				cbState.setValue(member.getState());
				txtZip.setText(member.getZip());
				txtPhoneNumber.setText(member.getPhone());
				
				btnAddMember.setText("Edit Memeber");
				
			}
		}else{
			System.out.println("member is null");
		}
	}
	
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
	public void addMember(ActionEvent event){
		if(iniData!=null&&iniData.size()>0){
			System.out.println(((LibraryMember)iniData.get("edit")).getId());
		}
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
		
		if(member!=null&&member.getId()!=null){//edit a member
			member.setLastName(txtLastName.getText());
			member.setFirstName(txtFirstName.getText());
			member.setCity(txtCity.getText());
			member.setStreet(txtStreet.getText());
			member.setState(cbState.getValue());
			member.setZip(txtZip.getText());
			member.setPhone(txtPhoneNumber.getText());
			//delete the old version first
			if(lda.deleteLibraryMember(member.getId())&&lda.saveLibraryMember(member)){
				this.lbInformation.setText("The user :"+this.txtLastName.getText()+" "+ this.txtFirstName.getText()+" saved!");
				this.lbInformation.setTextFill( Paint.valueOf("Green"));
			}
		}else{// add a member			
			if(lda.saveLibraryMember(new LibraryMember(this.txtLastName.getText(),
					this.txtFirstName.getText(),
					this.txtStreet.getText(),
					this.txtCity.getText(),
					this.cbState.getValue(),
					this.txtZip.getText(),
					this.txtPhoneNumber.getText()))){
				this.lbInformation.setText("The user :"+this.txtLastName.getText()+" "+ this.txtFirstName.getText()+" added");
				this.lbInformation.setTextFill( Paint.valueOf("Green"));							
				
			}
		}	
	}
	
	@FXML
	public void back(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibraryMemberSearch.fxml"));
		Parent root = loader.load();
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root,600,450);
		LibraryMemberSearchController libraryMemberSearchController = loader.<LibraryMemberSearchController>getController();
		stage.setScene(scene);
		stage.show();
		
	}
	
}
