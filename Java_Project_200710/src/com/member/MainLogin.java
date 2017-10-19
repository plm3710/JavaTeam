package com.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.SpringLayout;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import com.img.a;

public class MainLogin extends JFrame {
	BufferedImage icon;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLogin frame = new MainLogin();
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
	public MainLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path + "background_main.png");
					icon = ImageIO.read(fileInSamePackage);
					Dimension d = getSize();// 전체화면
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		contentPane.add(panel, "name_31157266775152");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,0,0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, -275, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -23, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 1024, SpringLayout.WEST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 92, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 404, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 172, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, 652, SpringLayout.WEST, panel_1);
		panel_1.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,0,0,0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, -124, SpringLayout.WEST, panel_3);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -80, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.WEST, panel_3);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));
		
		textField = new JTextField();
		panel_6.add(textField, "name_32076350647672");
		textField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		textField_1 = new JTextField();
		panel_7.add(textField_1, "name_32078486510904");
		textField_1.setColumns(10);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("I D");
		lblNewLabel_1.setFont(new Font("Masque", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("PW");
		lblNewLabel.setFont(new Font("Masque", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0,0,0,0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_8, 6, SpringLayout.SOUTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_8, 448, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_8, 36, SpringLayout.SOUTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_8, -416, SpringLayout.EAST, panel_1);
		panel_1.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_2.setFont(new Font("서울남산체 EB", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_2, "name_32143514351492");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(192,192,192));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_9, 0, SpringLayout.NORTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_9, 6, SpringLayout.EAST, panel_3);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_9, 0, SpringLayout.SOUTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_9, 103, SpringLayout.EAST, panel_3);
		panel_1.add(panel_9);
		panel_9.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setFont(new Font("Masque", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_3, "name_33078453118316");
	}
}
