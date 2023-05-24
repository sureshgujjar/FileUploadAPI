package com.suri.fileupload.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.suri.fileupload.model.FileInfo;

public interface FileInfoRepo extends MongoRepository<FileInfo, ObjectId> {

}
