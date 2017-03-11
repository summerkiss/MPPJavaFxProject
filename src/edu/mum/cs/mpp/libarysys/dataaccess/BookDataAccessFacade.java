package edu.mum.cs.mpp.libarysys.dataaccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import edu.mum.cs.mpp.libarysys.business.Book;

public class BookDataAccessFacade implements BookDataAccess {
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "/src/edu/mum/cs/mpp/libarysys/dataaccess/storage";
	public static final String DATA_BOOKS = "Books";
	
	@Override
	public void saveBook(Book book) {
		ObjectOutputStream out = null;
		try{
		
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR.concat("/").concat(DATA_BOOKS), book.getIsbn());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(book);
		}catch(IOException e){
			e.printStackTrace();

			}finally{
				if(out != null){
					try{
						out.close();
					}catch(Exception e){}
				}

		}
	}

	@Override
	public Book readBook(String isbn) {
		ObjectInputStream in = null;
		Book book = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR.concat("/").concat(DATA_BOOKS), isbn);
			in = new ObjectInputStream(Files.newInputStream(path));
			book = (Book)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return book;
	}

}
