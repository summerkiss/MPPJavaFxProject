package edu.mum.cs.mpp.libarysys.view;

import java.util.Hashtable;

import edu.mum.cs.mpp.libarysys.business.Authorization;
import edu.mum.cs.mpp.libarysys.business.CheckoutRecordEntry;
import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.business.Staff;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class LibraryMemberRecordController {
	@FXML private Label lbLibMember;	
	@FXML private Button btnBack;	
	@FXML private TableView<LibraryMember> tbMember;
	
	private Hashtable iniData;
	private Staff staff;
	private ObservableList<CheckoutRecordEntry> record;
	
	
	void setIniData(Hashtable iniData){
		this.iniData = iniData;
		
		if(iniData!=null&&iniData.size()>0){
			
			
		}else{
			System.out.println("member is null");
		}
	}
	
}
