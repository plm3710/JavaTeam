package com.VO;

public class BudgetVO {
	private String category;
	private int money;
	private String id;
	private int month;

	private BudgetVO() {

	}

	public BudgetVO(String category, int money, String id, int month) {
		super();
		this.category = category;
		this.money = money;
		this.id = id;
		this.month = month;
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
