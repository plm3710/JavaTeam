package com.ALL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.img.a;

import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
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

public class budgetRestart extends JFrame {

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
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 52, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 454, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JLabel Time = new JLabel("New label");
		Time.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_2.putConstraint(SpringLayout.NORTH, Time, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, Time, -10, SpringLayout.SOUTH, panel_2);
		panel_2.add(Time);
		//////////////////////////////////////////////////////////////////////
		
		year = c.get(Calendar.YEAR);
		mon = c.get(Calendar.MONTH) + 1;
		Time.setText(year + "년 " + mon + "월");
		//////////////////////////////////////////////////////////////////////

		JButton btnNewButton_1 = new JButton("\u25B6");
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

		JPanel panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_2);
		panel_1.add(panel_3);

		JPanel plus = new JPanel() { // panel_1 생성& 이미지넣기
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "plusButton.png");
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, plus, 406, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, plus, 0, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -6, SpringLayout.NORTH, plus);
		sl_panel_1.putConstraint(SpringLayout.WEST, plus, -90, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, plus, -10, SpringLayout.EAST, panel_1);
		panel_1.add(plus);

		JPanel end = new JPanel() { // panel_1 생성& 이미지넣기
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "endButton.png");
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, end, 6, SpringLayout.SOUTH, panel_3);
		panel_3.setLayout(new GridLayout(2, 2, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(5, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);

		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(5, 0, 0, 0));

		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);

		JPanel panel_14 = new JPanel();
		panel_5.add(panel_14);

		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);

		JPanel panel_16 = new JPanel();
		panel_5.add(panel_16);

		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(5, 0, 0, 0));

		JPanel panel_18 = new JPanel();
		panel_6.add(panel_18);

		JPanel panel_19 = new JPanel();
		panel_6.add(panel_19);

		JPanel panel_20 = new JPanel();
		panel_6.add(panel_20);

		JPanel panel_21 = new JPanel();
		panel_6.add(panel_21);

		JPanel panel_22 = new JPanel();
		panel_6.add(panel_22);

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(5, 0, 0, 0));

		JPanel panel_23 = new JPanel();
		panel_7.add(panel_23);

		JPanel panel_24 = new JPanel();
		panel_7.add(panel_24);

		JPanel panel_25 = new JPanel();
		panel_7.add(panel_25);

		JPanel panel_26 = new JPanel();
		panel_7.add(panel_26);

		JPanel panel_27 = new JPanel();
		panel_7.add(panel_27);
		sl_panel_1.putConstraint(SpringLayout.WEST, end, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, end, 0, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, end, -274, SpringLayout.WEST, plus);
		plus.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				budgeNewtInput bn = new budgeNewtInput();
				bn.main(null);
			}
		});
		plus.add(lblNewLabel_1, "name_13505501638477");
		panel_1.add(end);
		end.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		end.add(lblNewLabel_2, "name_13563578223707");
	}
}
