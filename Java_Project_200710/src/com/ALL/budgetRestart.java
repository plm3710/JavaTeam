package com.ALL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.DAO.MoneyDAO;
import com.VO.BudgetVO;
import com.VO.OutcomeVO;
import com.img.a;

import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class budgetRestart extends JFrame {
//	String id = null;
//	String money = null;
//	String month = null;
//	String category = null;
//
//	MoneyDAO dao = new MoneyDAO();
//	ArrayList<BudgetVO> blist = dao.budgetNextSelect(id, money, month, category);// 예산의 카테고리 정보를 가지고온다.
//	}

	private JPanel contentPane;
Calendar c = Calendar.getInstance();
	private int year;
	private int mon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budgetRestart frame = new budgetRestart();
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
public budgetRestart() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 500, 700);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new GridLayout(0, 1, 0, 0));

	JPanel panel = new JPanel() { // panel_1 생성& 이미지넣기
		public void paintComponent(Graphics g) {

			try {
				String path = a.class.getResource("").getPath();
				File fileInSamePackage = new File(path + "background_write.jpg");
				BufferedImage icon = ImageIO.read(fileInSamePackage);

				Dimension d = getSize();// 전체화면
				g.drawImage(icon, 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};

	contentPane.add(panel);
	SpringLayout sl_panel = new SpringLayout();
	panel.setLayout(sl_panel);

	JPanel panel_1 = new JPanel();
	sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 188, SpringLayout.NORTH, panel);
	sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
	sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, panel);
	sl_panel.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
	panel_1.setBackground(new Color(255, 192, 0));
	panel.add(panel_1);
	panel_1.setLayout(null);

	JPanel panel_2 = new JPanel();
	panel_2.setBounds(0, 0, 454, 52);
	panel_1.add(panel_2);
	SpringLayout sl_panel_2 = new SpringLayout();
	panel_2.setLayout(sl_panel_2);

	JLabel Time = new JLabel("New label");
	Time.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 12));
	Time.setHorizontalAlignment(SwingConstants.CENTER);
	panel_2.add(Time);
	//////////////////////////////////////////////////////////////////////

	year = c.get(Calendar.YEAR);
	mon = c.get(Calendar.MONTH) + 1;
	Time.setText(year + "년 " + mon + "월");
	//////////////////////////////////////////////////////////////////////

	JButton btnNewButton_1 = new JButton("\u25B6");
	sl_panel_2.putConstraint(SpringLayout.NORTH, Time, 0, SpringLayout.NORTH, btnNewButton_1);
	sl_panel_2.putConstraint(SpringLayout.SOUTH, Time, 0, SpringLayout.SOUTH, btnNewButton_1);
	btnNewButton_1.setBackground(new Color(255, 192, 0));

	btnNewButton_1.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			if (mon < 12) {
				mon += 1;
				Time.setText(year + "년 " + (mon) + "월");
			} else if(mon==12){
				year++;
				mon = 0;
				Time.setText(year + "년 " + (mon+1) + "월");
			}

		}
	});
	sl_panel_2.putConstraint(SpringLayout.EAST, Time, -6, SpringLayout.WEST, btnNewButton_1);
	sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, panel_2);
	sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_1, -57, SpringLayout.EAST, panel_2);
	sl_panel_2.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, panel_2);
	sl_panel_2.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, panel_2);
	panel_2.add(btnNewButton_1);

	JButton button = new JButton("\u25C0");
	button.setBackground(new Color(255, 192, 0));
	button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			if (mon >0) {
				mon -= 1;
				Time.setText(year + "년 " + (mon) + "월");
			} else if(mon==0){
				year--;
				mon = 11;
				Time.setText(year + "년 " + (mon+1) + "월");
			}
		}
	});
	sl_panel_2.putConstraint(SpringLayout.WEST, Time, 6, SpringLayout.EAST, button);
	sl_panel_2.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, panel_2);
	sl_panel_2.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, panel_2);
	sl_panel_2.putConstraint(SpringLayout.EAST, button, 57, SpringLayout.WEST, panel_2);
	sl_panel_2.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, panel_2);
	panel_2.add(button);

	JPanel cancel = new JPanel() { // panel_1 생성& 이미지넣기
		public void paintComponent(Graphics g) {

			try {
				String path = a.class.getResource("").getPath();
				File fileInSamePackage = new File(path + "buttonCancel.png");
				BufferedImage icon = ImageIO.read(fileInSamePackage);
				Dimension d = getSize();// 전체화면
				g.drawImage(icon, 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	cancel.setBounds(378, 410, 64, 36);
	panel_1.add(cancel);
	cancel.setLayout(new GridLayout(0, 1, 0, 0));

	JLabel lblNewLabel_1 = new JLabel("");
	cancel.add(lblNewLabel_1);
	lblNewLabel_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		
		}
	});

	JPanel plus = new JPanel() {
		public void paintComponent(Graphics g) {
		}
	};
	plus.setBounds(10, 410, 70, 37);
	panel_1.add(plus);
	plus.setLayout(new GridLayout(0, 1, 0, 0));

	JLabel lblNewLabel_2 = new JLabel(""){ // panel_1 생성& 이미지넣기
		public void paintComponent(Graphics g) {

			try {
				String path = a.class.getResource("").getPath();
				File fileInSamePackage = new File(path + "buttonCancel.png");
				BufferedImage icon = ImageIO.read(fileInSamePackage);
				Dimension d = getSize();// 전체화면
				g.drawImage(icon, 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	plus.add(lblNewLabel_2);
	lblNewLabel_2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			budgeNewtInput bn = new budgeNewtInput();
			bn.main(null);
		}
	});

	

	JScrollPane scrollPane = new JScrollPane(); // 스크롤 팬
	JPanel area = new JPanel(); // 패널
	Dimension size = new Dimension(); // 사이즈 지정
	size.setSize(400, 500);
	area.setPreferredSize(size);
	scrollPane.setViewportView(area);
	SpringLayout sl_area = new SpringLayout();
	area.setLayout(sl_area);
	
	JPanel panel_3 = new JPanel();
	sl_area.putConstraint(SpringLayout.NORTH, panel_3, 10, SpringLayout.NORTH, area);
	sl_area.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.SOUTH, area);
	area.add(panel_3);
	
	JPanel panel_4 = new JPanel();
	sl_area.putConstraint(SpringLayout.SOUTH, panel_4, 283, SpringLayout.NORTH, area);
	sl_area.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, area);
	sl_area.putConstraint(SpringLayout.EAST, panel_4, -10, SpringLayout.EAST, area);
	area.add(panel_4);
	panel_4.setLayout(new GridLayout(5, 0, 0, 0));
	
	JPanel panel_10 = new JPanel();
	panel_4.add(panel_10);
	
	JPanel panel_11 = new JPanel();
	panel_4.add(panel_11);
	
	JPanel panel_12 = new JPanel();
	panel_4.add(panel_12);
	
	JPanel panel_13 = new JPanel();
	panel_4.add(panel_13);
	
	JPanel panel_14 = new JPanel();
	panel_4.add(panel_14);
	
	JPanel panel_5 = new JPanel();
	sl_area.putConstraint(SpringLayout.WEST, panel_3, 6, SpringLayout.EAST, panel_5);
	sl_area.putConstraint(SpringLayout.SOUTH, panel_5, 283, SpringLayout.NORTH, area);
	sl_area.putConstraint(SpringLayout.NORTH, panel_5, 10, SpringLayout.NORTH, area);
	sl_area.putConstraint(SpringLayout.WEST, panel_5, 10, SpringLayout.WEST, area);
	sl_area.putConstraint(SpringLayout.EAST, panel_5, 88, SpringLayout.WEST, area);
	area.add(panel_5);
	panel_5.setLayout(new GridLayout(5, 0, 0, 0));
	
	JPanel panel_7 = new JPanel();
	
	panel_5.add(panel_7);
	
	JPanel panel_19 = new JPanel();
	panel_5.add(panel_19);
	
	JPanel panel_20 = new JPanel();
	panel_5.add(panel_20);
	
	JPanel panel_21 = new JPanel();
	panel_5.add(panel_21);
	
	JPanel panel_22 = new JPanel();
	panel_5.add(panel_22);
	panel_3.setLayout(new GridLayout(5, 0, 0, 0));
	
	JPanel panel_9 = new JPanel();
	panel_3.add(panel_9);
	
	JPanel panel_15 = new JPanel();
	panel_3.add(panel_15);
	
	JPanel panel_16 = new JPanel();
	panel_3.add(panel_16);
	
	JPanel panel_17 = new JPanel();
	panel_3.add(panel_17);
	
	JPanel panel_18 = new JPanel();
	panel_3.add(panel_18);
	
	JPanel panel_6 = new JPanel();
	sl_area.putConstraint(SpringLayout.EAST, panel_3, -6, SpringLayout.WEST, panel_6);
	sl_area.putConstraint(SpringLayout.WEST, panel_4, 6, SpringLayout.EAST, panel_6);
	sl_area.putConstraint(SpringLayout.NORTH, panel_6, 10, SpringLayout.NORTH, area);
	sl_area.putConstraint(SpringLayout.SOUTH, panel_6, -10, SpringLayout.SOUTH, area);
	sl_area.putConstraint(SpringLayout.WEST, panel_6, 282, SpringLayout.WEST, area);
	sl_area.putConstraint(SpringLayout.EAST, panel_6, -72, SpringLayout.EAST, area);
	area.add(panel_6);
	panel_6.setLayout(new GridLayout(5, 0, 0, 0));
	
	JPanel panel_8 = new JPanel();
	panel_6.add(panel_8);
	
	JPanel panel_23 = new JPanel();
	panel_6.add(panel_23);
	
	JPanel panel_24 = new JPanel();
	panel_6.add(panel_24);
	
	JPanel panel_25 = new JPanel();
	panel_6.add(panel_25);
	
	JPanel panel_26 = new JPanel();
	panel_6.add(panel_26);
	
	scrollPane.setBounds(5, 109, 445, 295);
	panel_1.add(scrollPane);
	
	JPanel panel_27 = new JPanel();
	panel_27.setBounds(10, 62, 432, 37);
	panel_1.add(panel_27);
	SpringLayout sl_panel_27 = new SpringLayout();
	panel_27.setLayout(sl_panel_27);
	
	JPanel panel_31 = new JPanel();
	sl_panel_27.putConstraint(SpringLayout.NORTH, panel_31, 0, SpringLayout.NORTH, panel_27);
	sl_panel_27.putConstraint(SpringLayout.WEST, panel_31, 10, SpringLayout.WEST, panel_27);
	sl_panel_27.putConstraint(SpringLayout.SOUTH, panel_31, 37, SpringLayout.NORTH, panel_27);
	sl_panel_27.putConstraint(SpringLayout.EAST, panel_31, 85, SpringLayout.WEST, panel_27);
	panel_27.add(panel_31);
	
	JPanel panel_30 = new JPanel();
	sl_panel_27.putConstraint(SpringLayout.NORTH, panel_30, 0, SpringLayout.NORTH, panel_31);
	sl_panel_27.putConstraint(SpringLayout.WEST, panel_30, 6, SpringLayout.EAST, panel_31);
	sl_panel_27.putConstraint(SpringLayout.SOUTH, panel_30, 37, SpringLayout.NORTH, panel_27);
	sl_panel_27.putConstraint(SpringLayout.EAST, panel_30, 273, SpringLayout.WEST, panel_27);
	panel_27.add(panel_30);
	
	JPanel panel_32 = new JPanel();
	sl_panel_27.putConstraint(SpringLayout.NORTH, panel_32, 0, SpringLayout.NORTH, panel_31);
	sl_panel_27.putConstraint(SpringLayout.WEST, panel_32, 6, SpringLayout.EAST, panel_30);
	sl_panel_27.putConstraint(SpringLayout.SOUTH, panel_32, 0, SpringLayout.SOUTH, panel_31);
	sl_panel_27.putConstraint(SpringLayout.EAST, panel_32, 96, SpringLayout.EAST, panel_30);
	panel_30.setLayout(new GridLayout(1, 0, 0, 0));
	
	JLabel lblNewLabel_4 = new JLabel("\uAE08\uC561");
	lblNewLabel_4.setFont(new Font("서울남산 장체B", Font.PLAIN, 12));
	lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
	panel_30.add(lblNewLabel_4);
	panel_27.add(panel_32);
	
	JPanel panel_33 = new JPanel();
	sl_panel_27.putConstraint(SpringLayout.NORTH, panel_33, 0, SpringLayout.NORTH, panel_31);
	sl_panel_27.putConstraint(SpringLayout.WEST, panel_33, 10, SpringLayout.EAST, panel_32);
	sl_panel_27.putConstraint(SpringLayout.SOUTH, panel_33, 0, SpringLayout.SOUTH, panel_31);
	panel_31.setLayout(new GridLayout(1, 0, 0, 0));
	
	JLabel lblNewLabel_3 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
	lblNewLabel_3.setFont(new Font("서울남산 장체B", Font.PLAIN, 12));
	lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	panel_31.add(lblNewLabel_3);
	sl_panel_27.putConstraint(SpringLayout.EAST, panel_33, 53, SpringLayout.EAST, panel_32);
	panel_32.setLayout(new GridLayout(1, 0, 0, 0));
	
	JLabel lblNewLabel_5 = new JLabel("\uBA54\uBAA8");
	lblNewLabel_5.setFont(new Font("서울남산 장체B", Font.PLAIN, 12));
	lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
	panel_32.add(lblNewLabel_5);
	panel_27.add(panel_33);
	panel_33.setLayout(new GridLayout(1, 0, 0, 0));
	
	JLabel lblNewLabel_6 = new JLabel("\uC0AD\uC81C");
	lblNewLabel_6.setFont(new Font("서울남산 장체B", Font.PLAIN, 12));
	lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	panel_33.add(lblNewLabel_6);


//	for (int i = 0; i < blist.size(); i++) {// 지출 행 넣기
//		Dimension size = new Dimension();
//		size.setSize(700, 100+(temp*42));
//		panel_2.setPreferredSize(size);
//
//		OutcomeVO m = olist.get(i);
//
//		String ca = m.getCategory();
//		String in = "+0";
//		String out = "-"+m.getMoney()+"";
//		String me = m.getMemo();

	}
}
