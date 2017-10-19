package com.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.VO.MemberVO;


public class MemberDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	MemberVO mvo = null;
	     
	private void getConn() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String id = "bigJava";
			String pw = "bigJava";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
		
		}catch (SQLException e) {
			System.out.print("db Driver 오류 : ");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.print("db연결 forName 오류 : ");
			e.printStackTrace();
		}
		
	}
	
	//회원가입
	public int insert(MemberVO mvo) {
		getConn();
		int cnt=0;
		try {
			String sql = "insert into member values(?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mvo.getId());
			psmt.setString(2, mvo.getPw());
			psmt.setString(3, mvo.getNickname());
			
			cnt = psmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("MemberDAO 회원가입 오류");
			e.printStackTrace();
		}finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}

	//회원삭제
	public int delete(MemberVO mvo) {
		getConn();
		int cnt=0;
		try {
			String sql = "delete from member where id=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, mvo.getId());
			cnt = psmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("MemberDAO 회원삭제 오류");
			e.printStackTrace();
		}finally {
			try {
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	//회원보기
	public ArrayList<MemberVO> select() {
		getConn();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			String sql = "select * from member";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String nickname = rs.getString(3);
				MemberVO mvo = new MemberVO(id, pw, nickname);
				list.add(mvo);
			}
		
		} catch (SQLException e) {
			System.out.println("MemberDAO 회원보기 오류");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if (psmt != null) psmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
		
}
