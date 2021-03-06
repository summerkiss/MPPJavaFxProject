package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;
import java.util.Hashtable;

import edu.mum.cs.mpp.libarysys.business.Authorization;
import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.business.Staff;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LibraryMemberSearchController {
	
	@FXML
	private TextField txtLibMemID;
	
	@FXML
	private Label lbLibMember;
	
	@FXML
	private Label lbAlert;
	
	@FXML
	private Button btnAdd;
	
	@FXML
	private Button btnEdit;
	
	@FXML
	private Button btnDelete;
	
	@FXML
	private Button btnCheckOut;
	
	@FXML
	private Button btnRecord;
	
	@FXML
	private Button btnSearch;
	
	@FXML
	private Button btnBack;
	
	
	@FXML
	private TableView<LibraryMember> tbMember;
	private Hashtable iniData;
	
	private LibMemberDataAccess lda = new LibMemberDataAccessFacade();
	private ObservableList<LibraryMember> data;
	private Staff staff;
	
	
	@FXML
    public void initialize() {
		lbAlert.visibleProperty().set(false);
		
		TableColumn idNameCol = new TableColumn("ID");
		idNameCol.setMinWidth(100);
		idNameCol.setStyle( "-fx-alignment: CENTER-RIGHT;");
		idNameCol.setCellValueFactory(
                new PropertyValueFactory<LibraryMember, String>("id"));
		
		TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<LibraryMember, String>("lastName"));
		
		TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<LibraryMember, String>("firstName"));
        
        TableColumn phoneNumberCol = new TableColumn("Phone Number");
        phoneNumberCol.setMinWidth(100);
        phoneNumberCol.setCellValueFactory(
                new PropertyValueFactory<LibraryMember, String>("phone"));
        
		
		
	      data =  FXCollections.observableArrayList(
	        		lda.readLibraryMember());
	     tbMember.setItems(data);
	     tbMember.getColumns().addAll(idNameCol,firstNameCol, lastNameCol, phoneNumberCol);
	}
	
	void setIniData(Hashtable iniData){
		this.iniData = iniData;
		
		if(iniData!=null&&iniData.size()>0){
			staff = (Staff)iniData.get("staff");
			if(staff != null)
				if(staff.getAu().equals(Authorization.ADMIN)){
					this.btnCheckOut.visibleProperty().setValue(false);
					this.btnRecord.visibleProperty().setValue(false);
				}
				if(staff.getAu().equals(Authorization.LIBRARIAN)){
					this.btnAdd.visibleProperty().setValue(false);
					this.btnEdit.visibleProperty().setValue(false);
					this.btnDelete.visibleProperty().setValue(false);
				}
			
		}else{
			System.out.println("member is null");
		}
	}
	
	@FXML
	public void search(ActionEvent event){
		if(txtLibMemID.getText()==null||txtLibMemID.getText().equals("")){
			ObservableList<LibraryMember> data =
			        FXCollections.observableArrayList(
			        		lda.readLibraryMember()
			        );
			     tbMember.setItems(data);
		}
		
		LibraryMember member = lda.readLibraryMember(txtLibMemID.getText());
		if(member!=null){
			 ObservableList<LibraryMember> data =
				        FXCollections.observableArrayList(
				        		member
				        );
			 tbMember.setItems(data);
		}else{
			lbAlert.visibleProperty().set(true);
			lbAlert.setText("User ID is not existed!");
			return;
		}
		
	}
	
	@FXML
	public void addNewMember(ActionEvent event){
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource(
					 "/edu/mum/cs/mpp/libarysys/view/LibraryMemberAdd.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void editNewMember(ActionEvent event){
		
		try {
			LibraryMember member  = tbMember.getSelectionModel().getSelectedItem();  
			
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibraryMemberAdd.fxml"));
			Parent root = loader.load();
			//Parent root = FXMLLoader.load(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibraryMemberAdd.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Hashtable iniData = new Hashtable();
			iniData.put("edit", member);
			LibraryMemberController libraryMemberController = loader.<LibraryMemberController>getController();
			libraryMemberController.setIniData(iniData);
			stage.setUserData(member);
			
			
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void showRecord(ActionEvent event) throws IOException{
		LibraryMember member  = tbMember.getSelectionModel().getSelectedItem();  
		if(member!=null){
			
		}
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibraryMemberCheckoutRecord.fxml"));
		Parent root = loader.load();
		// Parent root =
		// FXMLLoader.load(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibraryMemberAdd.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root, 600, 500);
		// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Hashtable iniData = new Hashtable();
		iniData.put("edit", member);
		LibraryMemberRecordController libraryMemberRecordController = loader.<LibraryMemberRecordController> getController();
		libraryMemberRecordController.setIniData(iniData);
		stage.setUserData(member);

		stage.setScene(scene);
		stage.show();
		
	}
	
	@FXML
	public void deleteNewMember(ActionEvent event){
			LibraryMember member  = tbMember.getSelectionModel().getSelectedItem(); 
			LibMemberDataAccess lda = new LibMemberDataAccessFacade();
			if(lda.deleteLibraryMember(member.getId())){
				data.remove(member);
			}
		
		
	}	
	
	@FXML
	public void back(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/LibraryMemberSearch.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		if(iniData!=null&&iniData.get("page")!=null){
			 loader = new FXMLLoader(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/".concat(iniData.get("page").toString())));
			 root = loader.load();
			 scene = new Scene(root);
			 stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			AdministratorNaviController administratorNaviController = loader.<AdministratorNaviController>getController();
			//administratorNaviController.initDate(staff);
			administratorNaviController.initDate((Staff)iniData.get("staff"));
		}else{
			LibraryMemberSearchController libraryMemberSearchController = loader.<LibraryMemberSearchController>getController();
		}
		stage.setScene(scene);
		stage.show();
		
	}
	
}
