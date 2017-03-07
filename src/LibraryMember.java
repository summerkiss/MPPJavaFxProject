package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class LibraryMember implements Serializable {
	private CheckoutRecord record = new CheckoutRecord();
	public LibraryMember(String name) {
		this.name = name;
		this.id = LibraryMember.getRandomId();
	}
	
	
	public LibraryMember(String lastName, String firstName, String street, String city, String state, String zip,
			String phone) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.id = LibraryMember.getRandomId();
	}


	private String id;
	private String name;
	private String lastName;
	private String firstName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;
	
	public void checkout(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate) {
		CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry);
		
	}
	
	
	
	public String getId() {
		return id;
	}



	public CheckoutRecord getRecord() {
		return record;
	}



	public void setRecord(CheckoutRecord record) {
		this.record = record;
	}



	public String getName() {
		return this.lastName+this.firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

	 private static String getRandomId(){ 
	         String s = UUID.randomUUID().toString(); 
	         return s.replaceAll("-", "");  
	     } 

	

	public String toString() {
		return "Checkout record for library member " + name + ": " + record.getEntries();
	}
	
	private static final long serialVersionUID = -2226197306790714013L;
}
