package edu.mum.cs.mpp.libarysys.business;

import java.util.List;

public class Author {

	private String firstName;
	private String lastName;
	private String address;
	private List<String> credentials;
	private List<Book> bookList;

	public void addBook(Book book){
		bookList.add(book);
		credentials.add("Authored " + book.getTitle() + ".");
	}

}
