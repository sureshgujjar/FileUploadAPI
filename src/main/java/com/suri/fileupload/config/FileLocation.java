package com.suri.fileupload.config;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileLocation {
	
	protected static final String IMG_FILE_LOC="Files"+File.separator+"Images";
	protected static final String PROGRAM_FILE_LOC="Files"+File.separator+"Programs";
	protected static final String DOC_FILE_LOC="Files"+File.separator+"Documents";
	protected static final String MEDIA_FILE_LOC="Files"+File.separator+"Videos";
	protected static final String OTHER_FILE_LOC="Files"+File.separator+"Others";
	protected List<String> imageExtensions = Arrays.asList(".jpg", ".jpeg", ".png", ".gif", ".bmp");
	protected  List<String> windowsProgramExtensions =  Arrays.asList(".exe", ".msi", ".bat", ".cmd", ".com");
	protected  List<String> mediaExtensions =Arrays.asList(".mp3", ".wav", ".mp4", ".avi", ".mkv", ".mov", ".flv", ".wmv", ".ogg");
	protected  List<String> documentExtensions =Arrays.asList(".doc", ".docx", ".txt", ".pdf", ".rtf", ".csv", ".xlsx", ".pptx");
	
	
}
