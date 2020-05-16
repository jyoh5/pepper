package com.pepper.domain;

import java.util.List;

public class PepperCntResultVO {
	
	private List<PepperCntVO> today;
	private List<PepperCntVO> total;
	private List<PepperCntVO> year;
	private List<PepperCntVO> week;
	private String[] price;
	
	public List<PepperCntVO> getToday() {
		return today;
	}
	public void setToday(List<PepperCntVO> today) {
		this.today = today;
	}
	public List<PepperCntVO> getTotal() {
		return total;
	}
	public void setTotal(List<PepperCntVO> total) {
		this.total = total;
	}
	public List<PepperCntVO> getYear() {
		return year;
	}
	public void setYear(List<PepperCntVO> year) {
		this.year = year;
	}
	public List<PepperCntVO> getWeek() {
		return week;
	}
	public void setWeek(List<PepperCntVO> week) {
		this.week = week;
	}
	public String[] getPrice() {
		return price;
	}
	public void setPrice(String[] price) {
		this.price = price;
	}
	
	
}
