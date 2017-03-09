package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;

public class CheckoutRecordEntry implements Serializable {
	private Book book;
	private LendableCopy copy;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	public CheckoutRecordEntry(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate, Book book){ 
		this.copy = copy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.book = book;
	}
	public String toString() {
		return "[" + "checkoutdate:" + 
	        checkoutDate.format(DateTimeFormatter.ofPattern(DataAccessFacade.DATE_PATTERN)) +
	        ", dueDate: " + dueDate.format(DateTimeFormatter.ofPattern(DataAccessFacade.DATE_PATTERN)) +
	        ", publication: " + copy + "]";
	}
	public Integer getCopyId() {
		return copy.getCopyId();
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
