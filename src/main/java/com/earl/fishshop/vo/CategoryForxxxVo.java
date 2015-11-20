package com.earl.fishshop.vo;


public class CategoryForxxxVo{


	private Long categoryId ;
	
	private String categorySimpleName ;
	
	private String categoryAcademicName ;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategorySimpleName() {
		return categorySimpleName;
	}

	public void setCategorySimpleName(String categorySimpleName) {
		this.categorySimpleName = categorySimpleName;
	}

	public String getCategoryAcademicName() {
		return categoryAcademicName;
	}

	public void setCategoryAcademicName(String categoryAcademicName) {
		this.categoryAcademicName = categoryAcademicName;
	}

	@Override
	public String toString() {
		return "CategoryVo [categoryId=" + categoryId + ", categorySimpleName="
				+ categorySimpleName + ", categoryAcademicName="
				+ categoryAcademicName + "]";
	}
	
	
}
