package edu.mum.cs.mpp.libarysys.dataaccess;

import edu.mum.cs.mpp.libarysys.business.Book;

public interface BookDataAccess {
	
	public void saveBook(Book book);
	public Book readBook(String isbn);
}
