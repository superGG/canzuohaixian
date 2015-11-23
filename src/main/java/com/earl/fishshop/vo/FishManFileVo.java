package com.earl.fishshop.vo;

import java.io.File;
import java.util.List;


public class FishmanFileVo{
	private List<File> file;
	
	private List<String> contentType;

	private List<String> fileName;

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileContentType() {
		return contentType;
	}

	public void setFileContentType(List<String> contentType) {
		this.contentType = contentType;
	}

	public List<String> getFileFileName() {
		return fileName;
	}

	public void setFileFileName(List<String> fileName) {
		this.fileName = fileName;
	}
}
