package com.VO;

public class MemberVO {
	private String id;
	private String pw;
	private String nickname;
	
	public MemberVO() {
		
	}
	public MemberVO(String id, String pw, String nickname) {
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
	}
	
	public MemberVO(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getNickname() {
		return nickname;
	}
}
