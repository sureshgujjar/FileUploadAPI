package com.suri.fileupload.model;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;
public class RequestModel {
	private String fileName;
	private Date uploadDate;
	private MultipartFile fileData;
	
	public RequestModel(String fileName, Date uploadDate, MultipartFile fileData) {
		super();
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.fileData = fileData;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public MultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}
	
	

}
