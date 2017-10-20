package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VO.IncomeVO;
import com.VO.OutcomeVO;

public class WriteDAO {
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

	public int incomeInsert(IncomeVO ivo) {
		getConn();
		int moneyAll = 0;
		try {
			String sql = "INSERT INTO income VALUES (?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, ivo.getId());
			psmt.setInt(2, ivo.getMoney());
			psmt.setInt(3, ivo.getYear());
			psmt.setInt(4, ivo.getMonth());
			psmt.setInt(5, ivo.getDay());
			psmt.setString(6, ivo.getCategory());
			psmt.setString(7, ivo.getMemo());

			rs = psmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("MoneyDAO 오류");
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

		return moneyAll;
	}public int outcomeInsert(OutcomeVO ovo) {
		getConn();
		int moneyAll = 0;
		try {
			String sql = "INSERT INTO outcome VALUES (?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, ovo.getId());
			psmt.setInt(2, ovo.getMoney());
			psmt.setInt(3, ovo.getYear());
			psmt.setInt(4, ovo.getMonth());
			psmt.setInt(5, ovo.getDay());
			psmt.setString(6, ovo.getCategory());
			psmt.setString(7, ovo.getMemo());
			rs = psmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("MoneyDAO 오류");
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

		return moneyAll;
	}
}
