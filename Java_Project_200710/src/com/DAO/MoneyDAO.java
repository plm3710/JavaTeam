package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.IncomeVO;
import com.VO.MemberVO;
import com.VO.OutcomeVO;

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
			System.out.print("db Driver 오류 : ");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.print("db연결 forName 오류 : ");
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
				//수입의 모든 금액 출력
				int money = rs.getInt(2);
				System.out.println("inmoney : "+money);
				moneyAll += money;
			}
		
		} catch (SQLException e) {
			System.out.println("MoneyDAO 오류");
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
				//수입의 모든 금액 출력
				int money = rs.getInt(2);
				System.out.println("outmoney : "+money);
				moneyAll += money;
			}
		
		} catch (SQLException e) {
			System.out.println("MoneyDAO 오류");
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

	public ArrayList<IncomeVO> incomeNextSelect(String id, String year, String month, String day) {
		
		getConn();
		ArrayList<IncomeVO> ilist = new ArrayList<IncomeVO>();
		try {
			String sql = "select * from income where id=? and year=? and  month=? and day=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setInt(2, Integer.parseInt(year));
			psmt.setInt(3, Integer.parseInt(month));
			psmt.setInt(4, Integer.parseInt(day));
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//모든 수입 컬럼 list에
				int dbMoney = rs.getInt(2);
				String dbCategory = rs.getString(6);
				String dbMemo = rs.getString(7);
				IncomeVO ivo = new IncomeVO(id, dbMoney, Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), dbCategory, dbMemo);
				ilist.add(ivo);
			}
		
		} catch (SQLException e) {
			System.out.println("MoneyDAO 오류");
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
		
		return ilist;
	}

	public ArrayList<OutcomeVO> outcomeNextSelect(String id, String year, String month, String day) {
		getConn();
		ArrayList<OutcomeVO> olist = new ArrayList<OutcomeVO>();
		try {
			String sql = "select * from outcome where id=? and year=? and  month=? and day=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setInt(2, Integer.parseInt(year));
			psmt.setInt(3, Integer.parseInt(month));
			psmt.setInt(4, Integer.parseInt(day));
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//모든 수입 컬럼 list에
				int dbMoney = rs.getInt(2);
				String dbCategory = rs.getString(6);
				String dbMemo = rs.getString(7);
				OutcomeVO ivo = new OutcomeVO(id, dbMoney, Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), dbCategory, dbMemo);
				olist.add(ivo);
			}
		
		} catch (SQLException e) {
			System.out.println("MoneyDAO 오류");
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
		
		return olist;
	}
	
	
	
	
	
	
}
