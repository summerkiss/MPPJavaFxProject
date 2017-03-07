package edu.mum.cs.mpp.libarysys.dataaccess;

import java.util.List;

import edu.mum.cs.mpp.libarysys.business.LibraryMember;

public interface LibMemberDataAccess {
	public void saveLibraryMember(LibraryMember member);
	public LibraryMember readLibraryMember(String id);
	public List<LibraryMember> readLibraryMember();
}
