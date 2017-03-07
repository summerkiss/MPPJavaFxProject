package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book extends Publication implements Serializable {
	private int id;
	private String isbn;
	private boolean available;
	private List<LendableCopy> lendableCopyList;
	private int totalCopyCount;


	public Book(int id, String isbn, String title) {
		super(title);
		this.id = id;
		this.isbn = isbn;
		lendableCopyList = new ArrayList<LendableCopy>();
		totalCopyCount = 0;
	}
	public void isAvailable(boolean b) {
		available = b;
	}
	@Override
	public String toString() {
		return "id: " + id + ", isbn: " + isbn + ", available: " + available;
	}

	public void addCopy(){
		LendableCopy copy = new LendableCopy();
		copy.setPublication(this);
		copy.setCopyId(totalCopyCount);
		lendableCopyList.add(copy);
		totalCopyCount ++;
	}
}
