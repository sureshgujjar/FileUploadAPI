package com.suri.fileupload.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
@Document(collection = "FileInfo")
public class FileInfo {
	@Id
	String id;
    String fileName;
    Date uploadDate;
    String fileLocation;
    @Transient
    @Nullable
    private MultipartFile fileData;
    
      public FileInfo(String id, String fileName, Date uploadDate, String fileLocation, MultipartFile fileData) {
		this.id = id;
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.fileLocation = fileLocation;
		this.fileData = fileData;
	}
	public FileInfo() {
		
		this.fileName ="";
		this.uploadDate = new Date();
		this.fileLocation="";
		this.fileData=null;
	    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfileName() {
		return fileName;
	}
	public void setfileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public MultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}
    
}
