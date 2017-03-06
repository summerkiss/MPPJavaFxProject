package edu.mum.cs.mpp.libarysys.view;

import edu.mum.cs.mpp.libarysys.business.Staff;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;
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
	
	public void Login(ActionEvent event){
		DataAccess da = new DataAccessFacade();
		Staff staff = (Staff)da.readStaff(txtUsername.getText());
		if(staff==null){
			
		}if(staff.getPassword().equals(txtPwd)){
			lbInformation.setText("You are fool");
			
		}
		
	}
}
