package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VO.BudgetVO;
import com.VO.IncomeVO;
import com.VO.OutcomeVO;

public class BudgetDAO_2 {
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

   public int buddelete(String id, String money, String month, String category,String memo) {
      getConn();
      int cnt=-1;
      String sql = "";
      try {
         if(memo==null) {
            sql = "delete from budget where id=? and money=? and year=? and month=? and day=? and category=? and memo is null";
            psmt = con.prepareStatement(sql);
            psmt.setString(1,id);
            psmt.setInt(2, Integer.parseInt(money));
            psmt.setInt(3, Integer.parseInt(month));
            psmt.setString(4, category);
            cnt = psmt.executeUpdate();
         }else {
            sql = "delete from outcome where id=? and money=? and year=? and month=? and day=? and category=? and memo=?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1,id);
            psmt.setInt(2, Integer.parseInt(money));
            psmt.setInt(3, Integer.parseInt(month));
            psmt.setString(4, category);
            psmt.setString(5, memo);
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

   public int budgetNextSelect(String id, String money, String month, String category) {
      getConn();
      int moneyAll = 0;
      try {
         String sql = "select * from budget where id=? and money=? and month=? and categorys";
         psmt = con.prepareStatement(sql);
         psmt.setString(1,id);
         psmt.setInt(2, Integer.parseInt(money));
         psmt.setInt(3, Integer.parseInt(month));
         psmt.setString(4, category);
         rs = psmt.executeQuery();

         //         while(rs.next()) {
         //            //예산의 모든 내역 출력
         //            int money = rs.getInt(2);
         //            System.out.println("budget : "+money);
         //            moneyAll += money;
         //         }

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

   public int budgetInsert(BudgetVO bvo) {
      getConn();
      int moneyAll = 0;
      try {
         String sql = "INSERT INTO budget VALUES (?,?,?,?)";
         psmt = con.prepareStatement(sql);
         psmt.setString(1, bvo.getId());
         psmt.setInt(2, bvo.getMoney());
         psmt.setInt(3, bvo.getMonth());
         psmt.setString(4, bvo.getCategory());

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