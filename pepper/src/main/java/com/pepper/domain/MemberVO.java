package com.pepper.domain;

import java.util.Date;

public class MemberVO {
//	CREATE TABLE `member` (
//			`userID` VARCHAR(30) NOT NULL,
//			`userPW` VARCHAR(50) NOT NULL,
//			`userName` VARCHAR(30) NOT NULL,
//			`userEmail` VARCHAR(30) NOT NULL,
//			`userNumber` VARCHAR(30) NOT NULL,
//			`regDate` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
//			PRIMARY KEY (`userID`),
//			UNIQUE INDEX `userName` (`userName`)
//		)
//		COLLATE='utf8_general_ci'
//		ENGINE=InnoDB
//		;

	private String userID;
	private String userPW;
	private String userName;
	private String userEmail;
	private String userNumber;
	private Date regDate;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
