package com.suri.fileupload.model;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;
@Component
@Document(collection = "FileInfo")
public class FileInfo {
	@Field(name="_id")
	ObjectId id;
    String filename;
    Date uploadDate;
    String fileLocation;
      public FileInfo() {
		
		this.filename ="xyz";
		this.uploadDate = new Date();
		this.fileLocation="fileLoc";
	    }
	public FileInfo(String filename, Date uploadDate,String fileLocation) {
		
		this.filename = filename;
		this.uploadDate = uploadDate;
		this.fileLocation=fileLocation;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
    
}
