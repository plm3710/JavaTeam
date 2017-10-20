package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.BudgetVO;
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

	public int indelete(String id, String in, String year, String month, String day, String ca, String me) {
		getConn();
		int cnt=-1;
		String sql="";
		try {
			if(me==null) {
				sql = "delete from income where id=? and money=? and year=? and month=? and day=? and category=? and memo is null";
				psmt = con.prepareStatement(sql);
				psmt.setString(1,id);
				psmt.setInt(2, Integer.parseInt(in));
				psmt.setInt(3, Integer.parseInt(year));
				psmt.setInt(4, Integer.parseInt(month));
				psmt.setInt(5, Integer.parseInt(day));
				psmt.setString(6, ca);
				cnt = psmt.executeUpdate();
			}else {
				sql = "delete from income where id=? and money=? and year=? and month=? and day=? and category=? and memo=?";
				psmt = con.prepareStatement(sql);
				psmt.setString(1,id);
				psmt.setInt(2, Integer.parseInt(in));
				psmt.setInt(3, Integer.parseInt(year));
				psmt.setInt(4, Integer.parseInt(month));
				psmt.setInt(5, Integer.parseInt(day));
				psmt.setString(6, ca);
				psmt.setString(7, me);
				cnt = psmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			System.out.println("MoneyDAO 오류");
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
	public int outdelete(String id, int in, String year, String month, String day, String ca, String me) {
		getConn();
		int cnt=-1;
		String sql = "";
		try {
			if(me==null) {
				sql = "delete from outcome where id=? and money=? and year=? and month=? and day=? and category=? and memo is null";
				psmt = con.prepareStatement(sql);
				psmt.setString(1,id);
				psmt.setInt(2, in);
				psmt.setInt(3, Integer.parseInt(year));
				psmt.setInt(4, Integer.parseInt(month));
				psmt.setInt(5, Integer.parseInt(day));
				psmt.setString(6, ca);
				cnt = psmt.executeUpdate();
			}else {
				sql = "delete from outcome where id=? and money=? and year=? and month=? and day=? and category=? and memo=?";
				psmt = con.prepareStatement(sql);
				psmt.setString(1,id);
				psmt.setInt(2, in);
				psmt.setInt(3, Integer.parseInt(year));
				psmt.setInt(4, Integer.parseInt(month));
				psmt.setInt(5, Integer.parseInt(day));
				psmt.setString(6, ca);
				psmt.setString(7, me);
				cnt = psmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			System.out.println("MoneyDAO 오류");
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
	

	public int outMoneySelect(String id, int year, int mon, String category) {//아이디, 년, 월, 카테고리
		getConn();
		int moneySum = 0;
		try {
			String sql = "select * from outcome where id=? and year=? and  month=? and category =?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1,id);
			psmt.setInt(2, year);
			psmt.setInt(3, mon);
			psmt.setString(4,category);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//모든 수입 컬럼 list에
				moneySum += rs.getInt(2);
				
			}
			System.out.println("지출 차트 -- 카테고리 : "+category+" 지출 총합 : "+moneySum);
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
		return moneySum;
	}

	
	
	
	
}
