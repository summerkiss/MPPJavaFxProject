package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book extends Publication implements Serializable {
	private int id;
	private String isbn;
	private boolean available;
//	public Book(int id, String isbn, String title) {
	private List<LendableCopy> lendableCopyList;
	private int totalCopyCount;
	private List<String> authorList;
	private String authorPrintList;




	
	public Book(int id, String isbn, String title, List<String> authors, boolean available, List<LendableCopy> lendableCopyList) {
		super(title);
		this.id = id;
		this.isbn = isbn;
		this.lendableCopyList = lendableCopyList;
		totalCopyCount = 0;
		authorList = authors;
		this.available = available;
	}
	public List<LendableCopy> getLendableCopyList() {
		return lendableCopyList;
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
	
	public void decreaseLendableCopy(LendableCopy lendableCopy) {
		int index = lendableCopyList.indexOf(lendableCopy);
		lendableCopyList.remove(index);
		if (lendableCopyList.isEmpty()) {
			available = false;
		}
		
	}
	
	public String getAuthorPrintList() {
		 authorPrintList = authorList.stream().collect(Collectors.joining("\n"));	
		 System.out.println("authorPrintList====="+authorPrintList);
		 return authorPrintList;
	}
	
	public String getIsbn() {
		return isbn;
	}
}
