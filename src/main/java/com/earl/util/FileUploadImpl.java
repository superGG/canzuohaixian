package com.earl.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.earl.fishshop.helper.JsonHelper;

/*
 * 实现文件上传功能  HTTP  FTP
 * */
@Component("fileUpload")
public class FileUploadImpl {

	@SuppressWarnings("unused")
	private String filePath = "C:/";

//	private String categoryfilePath = "category/";
	private String categoryfilePath;
	
//	private String goodsfilePath = "goods/";
	private String goodsfilePath;

//	private String userfilePath = "user/";
	private String userfilePath ;

	private String fishmanfilePath ;
//	private String fishmanfilePath = "fishman/";

//	private String farmerfilePath = "farmer/";
	private String farmerfilePath ;

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
	
	@Value("#{public[basePath]}" + "#{public.goodsfilePath}")
	public void setGoodsFilePath(String filePath) {
		System.out.println("farmerfilePath=" + filePath);
		this.goodsfilePath = filePath;
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
	
	public String uploadGoodsFile(File file, String oldName) {
		String uploadFile = uploadFile(file, goodsfilePath, oldName);
		return uploadFile;
	}
	
	public String uploadMulitCategoryFile(File[] file, String oldName[]) {
		ArrayList<String> filename = new ArrayList<String>();
		for(int i=0;i<file.length;i++){
			String uploadFile = uploadFile(file[i], categoryfilePath, oldName[i]);
			filename.add(uploadFile);
		}
		String jsonFileName = JsonHelper.toJson(filename);
		return jsonFileName;
	}
	public String uploadMulitCategoryFile(List<File> file, List<String> oldName) {
		ArrayList<String> filename = new ArrayList<String>();
		for(int i=0;i<file.size();i++){
			String uploadFile = uploadFile(file.get(i), categoryfilePath, oldName.get(i));
			filename.add(uploadFile);
		}
		String jsonFileName = JsonHelper.toJson(filename);
		return jsonFileName;
	}

//	public String uploadFishmanFile(File file, String oldName) {
//		String uploadFile = uploadFile(file, fishmanfilePath, oldName);
	
	public List<String> uploadFishmanFile(List<File> file, List<String> oldName) {
		List<String> uploadFile = uploadFile(file, fishmanfilePath, oldName);
		return uploadFile;
	}

	public List<String> uploadFarmerFile(List<File> file, List<String> oldName) {
		List<String> uploadFile = uploadFile(file, farmerfilePath, oldName);
		return uploadFile;
	}

	public List<String> uploadUserFile(List<File> file, List<String> oldName) {
		List<String> uploadFile = uploadFile(file, userfilePath, oldName);
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
		return dir + newName;
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
		List<String> newNameList = new ArrayList<String>();
		for (int i = 0; i < file.size(); i++) {
			String newName = this.newName(oldName.get(i));
			File destFile;
			try {
				destFile = new File(filePath, newName);
				FileUtils.copyFile(file.get(i), destFile);
				newNameList.add(dir + newName);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				file.get(i).delete();
			}
		}
		return newNameList;
	}

	private String getDir(String filePath2) {
		String substring = filePath2.substring(filePath2.indexOf("/") + 1,
				filePath2.length());
		return substring;
	}
}
