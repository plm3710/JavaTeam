package com.VO;

public class OutcomeVO {
	private String id;
	private int money;
	private int year;
	private int month;
	private int day;
	private String category;//ī�װ�
	private String memo;
	
	public OutcomeVO() {
		
	}
	public OutcomeVO(String id, int money, int year, int month, int day, String category, String memo) {
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
