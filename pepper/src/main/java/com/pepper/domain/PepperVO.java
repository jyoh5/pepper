package com.pepper.domain;

public class PepperVO {
//	CREATE TABLE pepper (
//			userID VARCHAR(30) NOT NULL,
//			analDate TIMESTAMP DEFAULT NOW(),
//			grade INT NOT NULL, // 1 특상, 2 보통, 3 폐기
//		)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
	
	private String userID;
	private String analDate;
	private int grade;

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAnalDate() {
		return analDate;
	}
	public void setAnalDate(String analDate) {
		this.analDate = analDate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	
	
}
