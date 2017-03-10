package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;

public class CheckoutRecordEntry implements Serializable {
	private Book book;
	private int copyID;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	public CheckoutRecordEntry(int copyID, LocalDate checkoutDate, LocalDate dueDate, Book book){ 
		this.copyID = copyID;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.book = book;
	}
	public String toString() {
		return "[" + "checkoutdate:" + 
	        checkoutDate.format(DateTimeFormatter.ofPattern(DataAccessFacade.DATE_PATTERN)) +
	        ", dueDate: " + dueDate.format(DateTimeFormatter.ofPattern(DataAccessFacade.DATE_PATTERN)) +
	        ", publication: " + copyID + "]";
	}
	public String getIsbn() {
		return book.getIsbn();
	}
	public Integer getCopyId() {
		return copyID;
	}
	public String getTitle() {
		return book.getTitle();
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
}
