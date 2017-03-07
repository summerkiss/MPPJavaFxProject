package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book extends Publication implements Serializable {
	private int id;
	private String isbn;
	private boolean available;
	public List<LendableCopy> lendableCopyList;
	public Book(int id, String isbn, String title) {
		super(title);
		this.id = id;
		this.isbn = isbn;
		lendableCopyList = new ArrayList<LendableCopy>();
	}
	public void isAvailable(boolean b) {
		available = b;
	}
	@Override
	public String toString() {
		return "id: " + id + ", isbn: " + isbn + ", available: " + available;
	}
}
