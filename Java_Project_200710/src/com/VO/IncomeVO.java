package com.VO;

public class IncomeVO {
	private String id;
	private int money;
	private int year;
	private int month;
	private int day;
	private String category;//카테고리
	private String memo;
	
	public IncomeVO() {
		
	}
	
	public IncomeVO(String id, int money, int year, int month, int day, String category, String memo) {
		super();
		this.id = id;
		this.money = money;
		this.year = year;
		this.month = month;
		this.day = day;
		this.category = category;
		this.memo = memo;
	}
	public String getId() {
		return id;
	}
	public int getMoney() {
		return money;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public String getCategory() {
		return category;
	}
	public String getMemo() {
		return memo;
	}
	
	
}
