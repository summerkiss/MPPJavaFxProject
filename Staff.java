package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;

public class Staff implements Serializable{
	private String id;
	private String password;
	private Authorization au;
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
	
	
	
}
