package com.suri.fileupload.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suri.fileupload.model.FileInfo;
import com.suri.fileupload.model.RequestModel;
import com.suri.fileupload.repo.FileInfoRepo;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/file")
public class FileCtrl 
{
	@Autowired
	 private FileInfoRepo repo;
	@Autowired
	 private FileInfo fileInfo;
 
  @PostMapping("/upload")
  void getFile(@ModelAttribute RequestModel request) throws IOException
  {    
	 String fileName=request.getFileData().getOriginalFilename();
	 String filePath=System.getProperty("user.dir")+File.separator+fileName;
	 File fileData=new File(filePath);
	 System.out.println(request.getFileData().getContentType());
	 String fileType=request.getFileData().getOriginalFilename().substring(request.getFileData().getOriginalFilename().lastIndexOf('.')+1);
	 System.out.println(fileType);
	 if(fileData.createNewFile())
	 {
		 byte fileContent[]=request.getFileData().getBytes();
		 FileOutputStream fout=new FileOutputStream(fileData);
		 fout.write(fileContent);
		 fout.close();
	 }
	
	 
	 this.repo.save(fileInfo);
	 
  }
  

}
