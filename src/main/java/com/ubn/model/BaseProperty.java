package com.ubn.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;


@MappedSuperclass
public class BaseProperty implements Serializable{
   
	
	private static final long serialVersionUID = 1L;
	
	private String creator;
	
	private Date creationDate;
	
	private String modifier;

	private Date modificationDate;

	private Date deletionDate;
	
	private long version;
	
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Date getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}

	
	 @PreUpdate
	 public void preUpdate() {
		 modificationDate = new Date();
	 }
	    
	 @PrePersist
	 public void prePersist() {
	     Date now = new Date();
	     creationDate = now;
	     modificationDate = now;
	 }
  
}
