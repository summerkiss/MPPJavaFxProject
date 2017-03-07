package edu.mum.cs.mpp.libarysys.view;

import edu.mum.cs.mpp.libarysys.business.Staff;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private Label lbInformation;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPwd;
	
	@FXML
	private Button btnLogin;
	
	@FXML
	public void Login(ActionEvent event){
		DataAccess da = new DataAccessFacade();
		Application app = null;
		
		Staff staff = (Staff)da.readStaff(txtUsername.getText());
		if(staff==null||
				!staff.getPassword().equals(txtPwd.getText())){
//			System.out.println(staff.getId());
//			System.out.println(staff.getPassword());
//			System.out.println(txtPwd.getText());
			lbInformation.setText("User name or password is not correct");			
			lbInformation.visibleProperty().set(true);
		}if(staff.getPassword().equals(txtPwd.getText())){
			lbInformation.setText("You are fool");			
			lbInformation.visibleProperty().set(true);
		}
		
	}
}
