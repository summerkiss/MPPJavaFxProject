package edu.mum.cs.mpp.libarysys.dataaccess;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.mpp.libarysys.business.Book;
import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.business.Staff;

public class DataAccessFacade implements DataAccess {

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "/src/edu/mum/cs/mpp/libarysys/dataaccess/storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	public static final String DATA_STAFF = "staff";
	public static final String DATA_BOOKS = "Books";


	public void saveStaff(Staff staff) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR.concat("/").concat(DATA_STAFF), staff.getId());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(staff);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}

	public Staff readStaff(String staffId) {
		ObjectInputStream in = null;
		Staff staff = null;
		Path path = null;
		try {
			File staffFolder = new File(OUTPUT_DIR.concat("/").concat(DATA_STAFF));

			File sFiles[] = staffFolder.listFiles();
			for(File f:sFiles){
				path = FileSystems.getDefault().getPath(OUTPUT_DIR.concat("/").concat(DATA_STAFF), f.getName());
				in = new ObjectInputStream(Files.newInputStream(path));
				staff = (Staff)in.readObject();
				if(staff !=null&&staff.getId().equals(staffId)){
					return staff;
				}
			}


		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return null;
	}


	public void saveLibraryMember(String name, LibraryMember member) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(member);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	public LibraryMember readLibraryMember(String name) {
		ObjectInputStream in = null;
		LibraryMember member = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, name);
			in = new ObjectInputStream(Files.newInputStream(path));
			member = (LibraryMember)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return member;
	}

	public void saveBook(Book book){
		ObjectOutputStream out = null;
		try{
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR.concat("/").concat(DATA_STAFF), book.getTitle() );
			
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

}
