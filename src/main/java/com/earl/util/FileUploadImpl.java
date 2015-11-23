package com.earl.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * 实现文件上传功能  HTTP  FTP
 * */
@Component("fileUpload")
public class FileUploadImpl {

	private String filePath = "C:/";

	private String categoryfilePath = "C:/category/";

	private String userfilePath = "C:/user/";

	private String fishmanfilePath = "C:/fishman/";

	private String farmerfilePath = "C:/farmer/";

	@Value("#{public[basePath]}" + "#{public.filePath}")
	public void setFilePath(String filePath) {
		System.out.println("filePath=" + filePath);
		this.filePath = filePath;
	}

	@Value("#{public[basePath]}" + "#{public.userfilePath}")
	public void setUserFilePath(String filePath) {
		System.out.println("userfilePath=" + filePath);
		this.userfilePath = filePath;
	}

	@Value("#{public[basePath]}" + "#{public.categoryfilePath}")
	public void setCategoryFilePath(String filePath) {
		System.out.println("categoryfilePath=" + filePath);
		this.categoryfilePath = filePath;
	}

	@Value("#{public[basePath]}" + "#{public.fishmanfilePath}")
	public void setFishmanFilePath(String filePath) {
		System.out.println("fishmanfilePath=" + filePath);
		this.fishmanfilePath = filePath;
	}

	@Value("#{public[basePath]}" + "#{public.farmerfilePath}")
	public void setFarmerFilePath(String filePath) {
		System.out.println("farmerfilePath=" + filePath);
		this.farmerfilePath = filePath;
	}

	// 1: 获取文件后缀名
	private String getExt(String oldName) {
		return FilenameUtils.getExtension(oldName);
	}

	// 2: 通过UUID生成新文件名
	private String newName(String oldName) {
		String ext = this.getExt(oldName);
		return UUID.randomUUID().toString() + "." + ext;
	}

	// 3: 实现文件上传的功能
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.earl.shoponline.service.impl.FileUpLoad#uploadFile(java.io.File,
	 * java.lang.String)
	 */

	public String uploadCategoryFile(File file, String oldName) {
		String uploadFile = uploadFile(file, categoryfilePath, oldName);
		return uploadFile;
	}

	public List<String> uploadFishmanFile(List<File> file, List<String> oldName) {
		List<String> uploadFile = uploadFile(file, fishmanfilePath, oldName);
		return uploadFile;
	}

	public List<String> uploadFarmerFile(List<File> file, List<String> oldName) {
		List<String> uploadFile = uploadFile(file, farmerfilePath, oldName);
		return uploadFile;
	}

	public String uploadUserFile(File file, String oldName) {
		String uploadFile = uploadFile(file, userfilePath, oldName);
		return uploadFile;
	}

	private String uploadFile(File file, String filePath, String oldName) {
		String dir = getDir(filePath);
		String newName = this.newName(oldName);
		File destFile;
		try {
			destFile = new File(filePath, newName);
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			file.delete();
		}
		return dir + "/" + newName;
	}

	/**
	 * 多文件上传.
	 *@author 宋文光.
	 * @param file 多文件
	 * @param filePath 
	 * @param oldName
	 * @return
	 */
	private List<String> uploadFile(List<File> file, String filePath, List<String> oldName) {
		String dir = getDir(filePath);
//		List<String> name = nameArray(oldName);
		List<String> newNameList = new ArrayList<String>();
		for (int i = 0; i < file.size(); i++) {
			String newName = this.newName(oldName.get(i));
			File destFile;
			try {
				destFile = new File(filePath, newName);
				FileUtils.copyFile(file.get(i), destFile);
				newNameList.add(dir + "/" + newName);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				file.get(i).delete();
			}
		}
		return newNameList;
	}

	/**
	 * 将多文件名切割成单文件名.
	 *@author 宋文光.
	 * @param oldName
	 * @return
	 */
	private List<String> nameArray(String oldName) {
		List<String> newName = new ArrayList<String>();

		StringTokenizer stMsg = new StringTokenizer(oldName, ";");
		while (stMsg.hasMoreTokens()) {
			String name = stMsg.nextToken();
			newName.add(name);
			System.out.println(name);
		}
		return newName;
	}
	
	/**
	 * 将多个文件地址合并.
	 *@author 宋文光.
	 * @param file
	 * @param filePath
	 * @return
	 */
	private String contentName(List<File> file, String filePath) {
		String dir = getDir(filePath);
		String newName =dir + "/" +file.get(0);
		for (int i=1; i < file.size(); i++) {
			newName = newName + ";" + dir + "/" + file.get(i);
		}
		return newName;
	}

	private String getDir(String filePath2) {
		// TODO 未测试.
		String substring = filePath2.substring(filePath2.lastIndexOf("\\") + 2,
				filePath2.length());
		return substring;
	}
}
