package com.suri.fileupload.ctrl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suri.fileupload.model.FileInfo;
import com.suri.fileupload.service.FileService;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/file")
public class FileCtrl 
{
	
	@Autowired
	private FileService fileService;
 
  @PostMapping("/upload")
  ResponseEntity<String> saveFile(@ModelAttribute FileInfo fileInfo) throws IOException
  {    

	  int status=this.fileService.saveFile(fileInfo);
	  switch(status)
	  {
	  case 1:
		  return new ResponseEntity<>("File Uploaded at "+fileInfo.getFileLocation(),HttpStatus.OK);
	   
	  case 0:
		  return new  ResponseEntity<>("File Not Uploaded",HttpStatus.BAD_REQUEST);
	  case -1:
		  return new  ResponseEntity<>("File Already Exist",HttpStatus.CONFLICT);
	  default:
		  return new  ResponseEntity<>("Opration Failure",HttpStatus.BAD_REQUEST);
	  }
	
 }
  @GetMapping("/files")
	 ResponseEntity<List<FileInfo>> getFiles()
	 {
		 return new ResponseEntity<>(this.fileService.getFiles(),HttpStatus.OK);
	 }
	 
 @DeleteMapping("/delete/{id}")
    ResponseEntity<String>deleteFile(@PathVariable String id)
    {
	    if(this.fileService.removeFile(id))
	    	return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	    else
	    	return new ResponseEntity<>("File Not Found",HttpStatus.BAD_REQUEST);
    }
  

}
