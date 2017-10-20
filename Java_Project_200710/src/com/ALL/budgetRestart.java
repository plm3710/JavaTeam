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
	String id = null;
	String money =null;
	String month = null;
	String category = null;
	
	MoneyDAO dao = new MoneyDAO();
	ArrayList<BudgetVO> blist = dao.budgetNextSelect(id, money, month, category);// 예산의 카테고리 정보를 가지고온다.
}

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
				cancel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				JLabel lblNewLabel_1 = new JLabel("");
				cancel.add(lblNewLabel_1);
				lblNewLabel_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						budgeNewtInput bn = new budgeNewtInput();
						bn.main(null);
					}
				});
		
		JPanel panel_28 = new JPanel() {
			public void paintComponent(Graphics g) {
			}
		};
		panel_28.setBounds(10, 410, 70, 37);
		panel_1.add(panel_28);
				panel_28.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
				JLabel lblNewLabel_2 = new JLabel("");
				panel_28.add(lblNewLabel_2);
				lblNewLabel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
		
		JPanel panel_29 = new JPanel() {
			public void paintComponent(Graphics g) {
			}
		};
		panel_29.setBounds(192, 419, 70, 28);
		panel_1.add(panel_29);
		panel_29.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("");
		panel_29.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 57, 445, 347);
		panel_1.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		for (int i = 0; i < blist.size(); i++) {// 지출 행 넣기
			Dimension size = new Dimension();
			size.setSize(700, 100+(temp*42));
			panel_2.setPreferredSize(size);
			
			OutcomeVO m = olist.get(i);

			String ca = m.getCategory();
			String in = "+0";
			String out = "-"+m.getMoney()+"";
			String me = m.getMemo();
		
		JPanel panel_4 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_4, 4, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_4, 6, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_4, 39, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_4, -4, SpringLayout.EAST, panel_3);
		panel_3.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_5, 1, SpringLayout.SOUTH, panel_4);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_5, 6, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_5, 34, SpringLayout.SOUTH, panel_4);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_5, -4, SpringLayout.EAST, panel_3);
		panel_3.add(panel_5);
	}
}
