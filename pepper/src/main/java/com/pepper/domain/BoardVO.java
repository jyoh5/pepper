package com.pepper.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
//	CREATE TABLE board (
//			bno INT NOT NULL AUTO_INCREMENT,
//			title VARCHAR(50) NOT NULL,
//			userID VARCHAR(30) NOT NULL,
//			writer VARCHAR(30) NOT NULL,
//			content TEXT NOT NULL,
//			regDate TIMESTAMP DEFAULT NOW(),
//			viewCnt INT DEFAULT 0,
//			PRIMARY KEY (bno)
//		)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

	private int bno;
	private String title;
	private String userID;
	private String writer;
	private String content;
	private Date regDate;
	private int viewCnt;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(regDate);
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
}
