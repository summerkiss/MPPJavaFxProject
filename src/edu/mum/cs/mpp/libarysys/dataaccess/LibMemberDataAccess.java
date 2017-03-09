package edu.mum.cs.mpp.libarysys.dataaccess;

import java.util.List;

import edu.mum.cs.mpp.libarysys.business.LibraryMember;

public interface LibMemberDataAccess {
	public boolean saveLibraryMember(LibraryMember member);
	public LibraryMember readLibraryMember(String id);
	public List<LibraryMember> readLibraryMember();
	public boolean deleteLibraryMember(String id);
	//public boolean isLibraryMemberExist(String id);
}
