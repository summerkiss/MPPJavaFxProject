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
	private List<String> authorList;


	public Book(int id, String isbn, String title, List<String> authors, boolean available) {
		super(title);
		this.id = id;
		this.isbn = isbn;
		lendableCopyList = new ArrayList<LendableCopy>();
		totalCopyCount = 0;
		authorList = authors;
		this.available = available;
	}
	public List<String> getAuthorList() {
		return authorList;
	}
	public boolean isAvailable() {
		return available;
	}
	@Override
	public String toString() {
		return "id: " + id + ", isbn: " + isbn + ", available: " + available;
	}

	public void addCopy(){
		LendableCopy copy = new LendableCopy(this,3);
		copy.setPublication(this);
		copy.setCopyId(totalCopyCount);
		lendableCopyList.add(copy);
		totalCopyCount ++;
	}
	
	public String getIsbn() {
		return isbn;
	}
}
