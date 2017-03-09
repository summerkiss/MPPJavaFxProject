package edu.mum.cs.mpp.libarysys.business;

import java.io.Serializable;

public class LendableCopy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Publication publication;
	private int copyId; 
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}
	public String toString() {
		return publication.toString();
	}
	public LendableCopy(Publication publication, int copyId) {
		this.publication = publication;
		this.copyId = copyId;
	}
	
}
