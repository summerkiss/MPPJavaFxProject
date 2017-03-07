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

import edu.mum.cs.mpp.libarysys.business.LibraryMember;

public class LibMemberDataAccessFacade implements LibMemberDataAccess {
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "/src/edu/mum/cs/mpp/libarysys/dataaccess/storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	public static final String DATA_MEMBER = "member";

	@Override
	public void saveLibraryMember(LibraryMember member) {
		ObjectOutputStream out = null;
		try {
			if(member!=null&&!member.getId().equals("")){
				Path path = FileSystems.getDefault().
						getPath(OUTPUT_DIR.concat("/").concat(DATA_MEMBER), 
								member.getId().concat(member.getLastName().concat(member.getFirstName())));
				out = new ObjectOutputStream(Files.newOutputStream(path));
				out.writeObject(member);			
			}
			
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

	@Override
	public LibraryMember readLibraryMember(String id) {
		List<LibraryMember> mList  = this.readLibraryMember();
		for(LibraryMember m : mList){
			if(m.getId().equals(id)){
				return m;
			}
		}		
		return null;
	}

	@Override
	public List<LibraryMember> readLibraryMember() {
		ObjectInputStream in = null;
		LibraryMember member = null;
		List<LibraryMember> mList = new ArrayList<>();
		File staffFolder = new File(OUTPUT_DIR.concat("/").concat(DATA_MEMBER));		
		File sFiles[] = staffFolder.listFiles();
		
		
		try {
			for(File f:sFiles){
				Path path = FileSystems.getDefault().getPath(OUTPUT_DIR.concat("/").concat(DATA_MEMBER), f.getName());
				in = new ObjectInputStream(Files.newInputStream(path));
				member = (LibraryMember)in.readObject();
				mList.add(member);
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
		return mList;
	}

}
