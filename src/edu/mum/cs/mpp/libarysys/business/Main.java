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
import edu.mum.cs.mpp.libarysys.dataaccess.LibMemberDataAccess;
import edu.mum.cs.mpp.libarysys.dataaccess.LibMemberDataAccessFacade;



public class Main {
	
	public static void main(String[] args) {
		Staff s1 = new Staff("YuYang","123456",Authorization.BOTH);
		Staff s2 = new Staff("YiHong","123456",Authorization.ADMIN);
		Staff s3 = new Staff("Rowe","123456",Authorization.LIBRARIAN);
//		
		DataAccess da = new DataAccessFacade();
//		da.saveStaff(s1);
//		da.saveStaff(s2);
//		da.saveStaff(s3);
		LibMemberDataAccess lda = new LibMemberDataAccessFacade();
		
		LibraryMember member1 = new LibraryMember("M","J","","","","","");
		LibraryMember member2 = new LibraryMember("D","J","","","","","");
		LibraryMember member3 = new LibraryMember("Q","J","","","","","");
//		lda.saveLibraryMember(member1);
//		lda.saveLibraryMember(member2);
//		lda.saveLibraryMember(member3);
		System.out.println(lda.readLibraryMember("8c3afac8b1e0407ea8da85dcd6f6a86b").getId());
		
		
		//System.out.println(da.readStaff("YuYang").getId());
		
		
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