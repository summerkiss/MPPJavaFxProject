package edu.mum.cs.mpp.libarysys.view;

import java.io.IOException;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Label lbInformation;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPwd;
	
	@FXML
	private Button btnLogin;
	
	public void Login(ActionEvent event) throws IOException {
//		DataAccess da = new DataAccessFacade();
//		Staff staff = (Staff)da.readStaff(txtUsername.getText());
//		if(staff==null){
//			
//		}if(staff.getPassword().equals(txtPwd)){
//			lbInformation.setText("You are fool");
			Parent root = FXMLLoader.load(getClass().getResource("/edu/mum/cs/mpp/libarysys/view/librarianNa.fxml"));
			Scene scene = new Scene(root);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(scene);
			app_stage.show();			
//		}
		
	}
}