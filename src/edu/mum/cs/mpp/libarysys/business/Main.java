package edu.mum.cs.mpp.libarysys.business;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import application.Authorization;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.DataAccessFacade;



public class Main {
	
	public static void main(String[] args) {
		Staff s1 = new Staff("YuYang","123456",Authorization.BOTH);
		Staff s2 = new Staff("Yifeng","123456",Authorization.ADMIN);
		Staff s3 = new Staff("Rowe","123456",Authorization.LIBRARIAN);
//		
		DataAccess da = new DataAccessFacade();
//		da.saveStaff(s1);
//		da.saveStaff(s2);
//		da.saveStaff(s3);
		
		System.out.println(da.readStaff("YuYang").getId());
		
		
//		LibraryMember member = new LibraryMember("John");
//		Publication p = new Book(1, "1234","Gone with the Wind");
//		LendableCopy c = new LendableCopy();
//		c.setPublication(p);
//		c.setCopyId(1);
//		member.checkout(c, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
//		System.out.println("Location of 'user.dir':\n  "+DataAccessFacade.OUTPUT_DIR);
//		
//		da.saveLibraryMember("John", member);
//		System.out.println("Reading record for John:\n"+"  "+da.readLibraryMember("John").toString());
		
		

	}
	

}