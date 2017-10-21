package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VO.BudgetVO;
import com.VO.IncomeVO;
import com.VO.OutcomeVO;

public class budgetDAO {
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

		} catch (SQLException e) {
			System.out.print("db Driver 오류 : ");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.print("db연결 forName 오류 : ");
			e.printStackTrace();
		}
	}

	public int buddelete(String category, int money, String id, int month, int year, String memo) {
		getConn();
		int cnt = -1;
		String sql = "";
		try {
			if (memo == null) {
				sql = "delete from budget where id=? and money=? and year=? and month=? and category=? and memo is null";
				psmt = con.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setInt(2, money);
				psmt.setInt(3, year);
				psmt.setInt(4, month);
				psmt.setString(5, category);
				cnt = psmt.executeUpdate();

			} else {
				sql = "delete from outcome where id=? and money=? and year=? and month=? and category=? and memo=?";
				psmt = con.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setInt(2, money);
				psmt.setInt(3, year);
				psmt.setInt(4, month);
				psmt.setString(5, category);
				psmt.setString(6, memo);
				cnt = psmt.executeUpdate();
			}

		} catch (SQLException e) {
			System.out.println("budgetDAO - delete 오류");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;

	}

	public ArrayList<BudgetVO> budgetNextSelect(String id, String money, String month, String category) {
		getConn();

		ArrayList<BudgetVO> list = new ArrayList<>();

		try {
			String sql = "select * from Budget";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String id1 = rs.getString(1);
				int money1 = rs.getInt(2);
				int month1 = rs.getInt(3);
				String category1 = rs.getString(4);
				int year = rs.getInt(5);
				String memo = rs.getString(6);
				BudgetVO budget = new BudgetVO(id1, money1, month1, category1, year, memo);
				list.add(budget);

			}

		} catch (SQLException e) {
			System.out.println("BudgetDAO - select 오류");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public int budgetInsert(BudgetVO bvo) {
		getConn();
		int count = 0;
		try {
			String sql = "INSERT INTO budget VALUES (?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, bvo.getId());
			psmt.setInt(2, bvo.getMoney());
			psmt.setInt(3, bvo.getMonth());
			psmt.setString(4, bvo.getCategory());
			psmt.setInt(5, bvo.getYear());
			psmt.setString(6, bvo.getMemo());

			count = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("budgetDAO-insert 오류");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

}
