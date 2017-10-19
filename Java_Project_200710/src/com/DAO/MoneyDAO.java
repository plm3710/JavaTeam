package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.IncomeVO;
import com.VO.MemberVO;

public class MoneyDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	private void getConn() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String id = "bigJava";
			String pw = "bigJava";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
		
		}catch (SQLException e) {
			System.out.print("db Driver ���� : ");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.print("db���� forName ���� : ");
			e.printStackTrace();
		}
	}

	public int incomeSelect(String id, String year, String month) {
		getConn();
		int moneyAll = 0;
		try {
			String sql = "select * from income where id=? and year=? and month=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setInt(2, Integer.parseInt(year));
			psmt.setInt(3, Integer.parseInt(month));
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//������ ��� �ݾ� ���
				int money = rs.getInt(2);
				System.out.println("inmoney : "+money);
				moneyAll += money;
			}
		
		} catch (SQLException e) {
			System.out.println("MemberDAO ȸ������ ����");
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
		
		return moneyAll;
	}

	public int outcomeSelect(String id, String year, String month) {
		getConn();
		int moneyAll = 0;
		try {
			String sql = "select * from outcome where id=? and year=? and  month=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setInt(2, Integer.parseInt(year));
			psmt.setInt(3, Integer.parseInt(month));
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//������ ��� �ݾ� ���
				int money = rs.getInt(2);
				System.out.println("outmoney : "+money);
				moneyAll += money;
			}
		
		} catch (SQLException e) {
			System.out.println("MemberDAO ȸ������ ����");
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
		
		return moneyAll;
	}
	
	
	
	
	
	
}
