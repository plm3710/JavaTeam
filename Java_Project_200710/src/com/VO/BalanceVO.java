package com.VO;

public class BalanceVO {
	private String id;
	private int balance;
	public BalanceVO() {
		
	}
	public BalanceVO(String id, int balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public int getBalance() {
		return balance;
	}
	
	
}
