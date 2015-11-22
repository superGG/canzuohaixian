package com.earl.fishshop.vo;

import java.io.File;


public class UserFileVo{

private File file;
	
	private String contentType;
	
	private String fileName;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return contentType;
	}

	public void setFileContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileFileName() {
		return fileName;
	}

	public void setFileFileName(String fileName) {
		this.fileName = fileName;
	}

}
