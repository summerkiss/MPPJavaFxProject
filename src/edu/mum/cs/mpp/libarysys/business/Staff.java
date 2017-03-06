package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;

import application.Authorization;

public class Staff implements Serializable{
	private String id;
	private String password;
	private Authorization au;
	private boolean isLibrarian;
	private boolean isAdmistrator;
	public Staff(String id, String password, Authorization au) {
		super();
		this.id = id;
		this.password = password;
		this.au = au;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public Authorization getAu() {
		return au;
	}
	public boolean isLibrarian() {
		return isLibrarian;
	}
	public boolean isAdministrator() {
		return isAdmistrator;
	}
	
	
	
}
