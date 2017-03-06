package edu.mum.cs.mpp.libarysys.dataaccess;

import edu.mum.cs.mpp.libarysys.business.LibraryMember;
import edu.mum.cs.mpp.libarysys.business.Staff;

public interface DataAccess {
	public void saveLibraryMember(String name, LibraryMember member);
	public LibraryMember readLibraryMember(String name);
	public void saveStaff(Staff staff);
	public Staff readStaff(String staffId);
}
