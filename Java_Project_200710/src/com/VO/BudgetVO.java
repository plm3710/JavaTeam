package com.VO;

public class BudgetVO {
	private String category;
	private int money;
	private String id;
	private int month;
	private int year;
	private String memo;


	

	public BudgetVO(String id, int money, int month, String category, int year, String memo) {
		super();
		this.category = category;
		this.money = money;
		this.id = id;
		this.month = month;
		this.memo = memo;
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public String getMemo() {
		return memo;
	}


	public String getCategory() {
		return category;
	}

	public int getMoney() {
		return money;
	}

	public String getId() {
		return id;
	}

	public int getMonth() {
		return month;
	}

}
