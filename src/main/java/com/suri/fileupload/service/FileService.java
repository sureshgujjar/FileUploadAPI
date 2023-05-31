package com.suri.fileupload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suri.fileupload.config.FileLocation;
import com.suri.fileupload.model.FileInfo;
import com.suri.fileupload.repo.FileInfoRepo;
@Service
public class FileService extends FileLocation{
	 @Autowired
	 private FileInfoRepo repo;
	
	public FileService() throws IOException {
		
//			Files.createDirectory(Paths.get(IMG_FILE_LOC));
//			Files.createDirectory(Paths.get(PROGRAM_FILE_LOC));
//			Files.createDirectory(Paths.get(MEDIA_FILE_LOC));
//			Files.createDirectory(Paths.get(DOC_FILE_LOC));
//			Files.createDirectory(Paths.get(OTHER_FILE_LOC));
			if(Files.notExists(Paths.get(IMG_FILE_LOC)))
			{
				Files.createDirectories(Paths.get(IMG_FILE_LOC));
			}
			if(Files.notExists(Paths.get(PROGRAM_FILE_LOC)))
			{
				Files.createDirectories(Paths.get(PROGRAM_FILE_LOC));
			}
			if(Files.notExists(Paths.get(MEDIA_FILE_LOC)))
			{
				Files.createDirectories(Paths.get(MEDIA_FILE_LOC));
			}
			if(Files.notExists(Paths.get(DOC_FILE_LOC)))
			{
				Files.createDirectories(Paths.get(DOC_FILE_LOC));
			}
			if(Files.notExists(Paths.get(OTHER_FILE_LOC)))
			{
				Files.createDirectories(Paths.get(OTHER_FILE_LOC));
			}
		
		
	}

	public int  saveFile(FileInfo fileInfo) throws IOException
	{
		MultipartFile file=fileInfo.getFileData();
		String fileName=fileInfo.getfileName();
		String fileExtenstion=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String fileLoc="";

		if(imageExtensions.contains(fileExtenstion))
		{
			fileLoc=FileLocation.IMG_FILE_LOC;
		}
		else if(windowsProgramExtensions.contains(fileExtenstion))
		{
			fileLoc=FileLocation.PROGRAM_FILE_LOC;
			
		}
		else if(mediaExtensions.contains(fileExtenstion))
		{
			fileLoc=FileLocation.MEDIA_FILE_LOC;
		}
		else if(documentExtensions.contains(fileExtenstion))
		{
			fileLoc=FileLocation.DOC_FILE_LOC;
		}
		else
		{
			fileLoc=FileLocation.OTHER_FILE_LOC;
		}
		String filePath=fileLoc+File.separator+fileName+fileExtenstion;
	    File fileData=new File(filePath);
	    if(fileData.exists())
	    {
	    	return -1;
	    }
	    else if(fileData.createNewFile())
	    {
	    	 byte fileContent[]=file.getBytes();
	    	 FileOutputStream fout=new FileOutputStream(fileData);
	    	 fout.write(fileContent);
	    	 fout.close();
	    	 fileInfo.setFileLocation(filePath);
	    	  this.repo.save(fileInfo);
	    	 return 1;
	    }
	    else {
			return 0;
		}
	  
	}
	public List<FileInfo> getFiles()
	{
		return this.repo.findAll(Sort.by(Sort.Direction.ASC,"_id"));
	}
	public boolean removeFile(String id) throws IOException
	{
	   
		
		 boolean flag=false;
		if(this.repo.existsById(id));
		{
			FileInfo fileInfo=this.repo.findFirstById(id);
	        String fileLoc=fileInfo.getFileLocation();
	        Path path = Paths.get(fileLoc);
	        if(path.toFile().delete())
	        {
	        	this.repo.deleteById(id);
				flag=true;
	        	
	        }
		}
		
			return flag;
	}
	public Resource getFile(String id) throws MalformedURLException
	{
		FileInfo fileInfo=this.repo.findFirstById(id);
		String fileLoc=fileInfo.getFileLocation();
		Resource resource=new UrlResource(Paths.get(fileLoc).toAbsolutePath().toUri());
//		System.out.println(resource);
		return resource;
	}
}
