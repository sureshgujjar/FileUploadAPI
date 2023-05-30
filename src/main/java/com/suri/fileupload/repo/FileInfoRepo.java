package com.suri.fileupload.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.suri.fileupload.model.FileInfo;

public interface FileInfoRepo extends MongoRepository<FileInfo, String> {
	@Query("{ '_id' : ?0}")
	FileInfo findFirstById(String id);

}
