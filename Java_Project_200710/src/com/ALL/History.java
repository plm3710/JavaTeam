package com.ALL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

import com.DAO.MoneyDAO;
import com.VO.IncomeVO;
import com.VO.OutcomeVO;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;

import java.awt.event.ActionListener;
import java.awt.font.TransformAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class History extends JFrame {

	private JPanel contentPane;
	private MoneyDAO mdao = null;
	private ArrayList<IncomeVO> ilist = null;
	private ArrayList<OutcomeVO> olist = null;
	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public History(String id) {
		
		mdao = new MoneyDAO();
		ilist = new ArrayList<IncomeVO>();
		olist = new ArrayList<OutcomeVO>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(150,150,150));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -495, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 1024, SpringLayout.WEST, contentPane);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 1, SpringLayout.SOUTH, panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(150,150,150));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, 96, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 136, SpringLayout.WEST, panel_1);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(200,200,200));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_5, 0, SpringLayout.NORTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_5, 6, SpringLayout.EAST, panel_4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_5, 0, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_5, 878, SpringLayout.EAST, panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("\uC6D4");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\uC18C\uBE44\uD328\uD134");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		panel_4.add(lblNewLabel);
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblIncome = new JLabel("\uC218 \uC785");
		lblIncome.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblIncome.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblIncome);
		
		JLabel lblOutcome = new JLabel("\uC9C0 \uCD9C");
		lblOutcome.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblOutcome.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblOutcome);
		
		JLabel lblBalance = new JLabel("\uC794 \uC561");
		lblBalance.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblBalance);
		
		JLabel lblIncomeMoney = new JLabel("-");
		lblIncomeMoney.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblIncomeMoney.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblIncomeMoney);
		
		JLabel lblOutcomeMoney = new JLabel("-");
		lblOutcomeMoney.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblOutcomeMoney.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblOutcomeMoney);
		
		JLabel lblBalanceMoney = new JLabel("-");
		lblBalanceMoney.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblBalanceMoney.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblBalanceMoney);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 1024, SpringLayout.WEST, contentPane);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_3, 607, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -6, SpringLayout.NORTH, panel_3);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JCalendar calendar = new JCalendar();
		
		calendar.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		calendar.setBackground(new Color(255,255,255));
		calendar.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		calendar.getDayChooser().setWeekOfYearVisible(false);
		calendar.getDayChooser().setDecorationBackgroundColor(Color.WHITE);
		calendar.getDayChooser().setDecorationBackgroundVisible(false);
		calendar.getDayChooser().setDayBordersVisible(true);
		calendar.getYearChooser().setBackground(Color.WHITE);
		calendar.getMonthChooser().getSpinner().setBackground(Color.WHITE);
		calendar.getYearChooser().getSpinner().setBackground(Color.WHITE);
		calendar.setForeground(Color.BLACK);
		calendar.setBackground(Color.WHITE);
		calendar.setDecorationBackgroundColor(Color.WHITE);
		calendar.setDecorationBordersVisible(true);
		panel_2.add(calendar, "name_13122622979416");
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_3, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, contentPane);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnNewButton = new JButton("\uB0B4\uC5ED \uC870\uD68C");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, 39, SpringLayout.NORTH, panel);
		panel.add(btnNewButton);
		contentPane.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JPanel panel_6 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_6, 425, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_6, 39, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_6, 598, SpringLayout.WEST, panel_3);
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton_1 = new JButton("\u25C0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		       Date d = calendar.getDate();
		       SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		       System.out.println(format.format(d));
		       int mon = d.getMonth();
		       mon--;
		       if(mon<0) {
		    	   mon=11;
		       }
		       d.setMonth(mon);
		       calendar.setDate(d);
		       
				///////////////////////////////////////
			     String[] ymd = format.format(d).split("-");
			     for (int i = 0; i < ymd.length; i++) {
					System.out.print(ymd[i]+"-");//0,년    1,월    2,일
				}
			    lblNewLabel_1.setText((d.getMonth()+1)+"월"); 
			    int inMoney=0;
				inMoney = mdao.incomeSelect(id,ymd[0],ymd[1]);//아이디와 월을 넘겨서 그달의 수익을 리스트에 담는다.
				lblIncomeMoney.setText(inMoney+"원");
				int outMoney=0;
				outMoney = mdao.outcomeSelect(id,ymd[0],ymd[1]);
				lblOutcomeMoney.setText(outMoney+"원");
				int balance = inMoney-outMoney;
				lblBalanceMoney.setText(balance+"원");
				///////////////////////////////////////
			}
		});
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel_6.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u25B6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//월 올리기
				 Date d = calendar.getDate();
			       SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
			       System.out.println(format.format(d));
			       int mon = d.getMonth();
			       mon++;
			       if(mon==12) {
			    	   mon=0;
			       }
			       d.setMonth(mon);
			       calendar.setDate(d);
				
					///////////////////////////////////////
				     String[] ymd = format.format(d).split("-");
				     for (int i = 0; i < ymd.length; i++) {
						System.out.print(ymd[i]+"-");//0,년    1,월    2,일
					}
				     lblNewLabel_1.setText((d.getMonth()+1)+"월"); 
				    int inMoney=0;
					inMoney = mdao.incomeSelect(id,ymd[0],ymd[1]);//아이디와 월을 넘겨서 그달의 수익을 리스트에 담는다.
					lblIncomeMoney.setText(inMoney+"원");
					int outMoney=0;
					outMoney = mdao.outcomeSelect(id,ymd[0],ymd[1]);
					lblOutcomeMoney.setText(outMoney+"원");
					int balance = inMoney-outMoney;
					lblBalanceMoney.setText(balance+"원");
					///////////////////////////////////////
			}
		});
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel_6.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uB2EB\uAE30");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		sl_panel_3.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, panel_6);
		sl_panel_3.putConstraint(SpringLayout.WEST, btnNewButton_3, -104, SpringLayout.EAST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 0, SpringLayout.SOUTH, panel_6);
		sl_panel_3.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, panel_3);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uC77C\uBCC4 \uB0B4\uC5ED");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//일별내역
				Date d = calendar.getDate();
				SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
			    String dateTemp = format.format(d);
				HistoryNext hn = new HistoryNext(id,dateTemp);
			    hn.main(id,dateTemp);
			}
		});
		sl_panel_3.putConstraint(SpringLayout.NORTH, btnNewButton_4, 0, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, btnNewButton_4, -132, SpringLayout.WEST, btnNewButton_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 0, SpringLayout.SOUTH, panel_6);
		sl_panel_3.putConstraint(SpringLayout.EAST, btnNewButton_4, -6, SpringLayout.WEST, btnNewButton_3);
		btnNewButton_4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel_3.add(btnNewButton_4);
		
		
		//회원에 맞는 지출 출력
		//월에 맞는 내용들만 가지고온다.
		//회원에 맞는 수입 출력
		///////////////////////////////////////
		 Date d = calendar.getDate();
	     SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	     String[] ymd = format.format(d).split("-");
	     for (int i = 0; i < ymd.length; i++) {
			System.out.print(ymd[i]+"-");//0,년    1,월    2,일
		}
	     
	     lblNewLabel_1.setText((d.getMonth()+1)+"월"); 
	    int inMoney=0;
		inMoney = mdao.incomeSelect(id,ymd[0],ymd[1]);//아이디와 월을 넘겨서 그달의 수익을 리스트에 담는다.
		lblIncomeMoney.setText(inMoney+"원");
		int outMoney=0;
		outMoney = mdao.outcomeSelect(id,ymd[0],ymd[1]);
		lblOutcomeMoney.setText(outMoney+"원");
		int balance = inMoney-outMoney;
		lblBalanceMoney.setText(balance+"원");
		///////////////////////////////////////
		
	}
}
