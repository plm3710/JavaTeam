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

import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.FontMetrics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.UIManager;

import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Write extends JFrame {
	BufferedImage icon;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Write frame = new Write();
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
	public Write() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path
							+ "background_write.jpg");
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
		contentPane.add(panel, "name_39561877537572");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, -482,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 464,
				SpringLayout.WEST, panel);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.ORANGE);
//		tabbedPane.setUI(new BasicTabbedPaneUI() { // 탭 사이즈 변경 / 주석 풀면 디자인 화면
//					// 안됨
//
//					@Override
//					protected int calculateTabHeight(int tabPlacement,
//							int tabIndex, int fontHeight) {
//						// TODO Auto-generated method stub
//						return 40;
//					}
//
//					@Override
//					protected int calculateTabWidth(int tabPlacement,
//							int tabIndex, FontMetrics metrics) {
//						// TODO Auto-generated method stub
//						return 223;
//					}
//
//				});
		panel_1.add(tabbedPane, "name_39837979284068");

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("수입", null, panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		panel_2.setBackground(new Color(255, 192, 0));
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 192, 0));
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 10,
				SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 10,
				SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, 282,
				SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, 159,
				SpringLayout.WEST, panel_2);
		panel_2.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 192, 0));
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_5, 10,
				SpringLayout.NORTH, panel_2);

		sl_panel_2.putConstraint(SpringLayout.WEST, panel_5, 6,
				SpringLayout.EAST, panel_4);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_5, 282,
				SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_5, 280,
				SpringLayout.EAST, panel_4);
		panel_2.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 192, 0));

		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_6, 6,
				SpringLayout.SOUTH, panel_4);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_6, 10,
				SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_6, 108,
				SpringLayout.SOUTH, panel_4);
		panel_4.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("\uC9C0\uBD88\uC77C\uC2DC");

		lblNewLabel_1.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\uACB0\uC81C\uAE08\uC561");
		lblNewLabel_2.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uACB0\uC81C\uC218\uB2E8");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_3);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_6, 159,
				SpringLayout.WEST, panel_2);
		panel_2.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 192, 0));
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_7, 6,
				SpringLayout.SOUTH, panel_5);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_7, 6,
				SpringLayout.EAST, panel_6);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_7, 108,
				SpringLayout.SOUTH, panel_5);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_7, -10,
				SpringLayout.EAST, panel_2);
		panel_5.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 192, 0));
		panel_5.add(panel_9);
		SpringLayout sl_panel_9 = new SpringLayout();
		panel_9.setLayout(sl_panel_9);

		textField = new JTextField();
		sl_panel_9.putConstraint(SpringLayout.NORTH, textField, -44,
				SpringLayout.SOUTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.WEST, textField, 10,
				SpringLayout.WEST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, textField, -23,
				SpringLayout.SOUTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, textField, 70,
				SpringLayout.WEST, panel_9);
		panel_9.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\uB144");
		label.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_9.putConstraint(SpringLayout.NORTH, label, 3,
				SpringLayout.NORTH, textField);
		sl_panel_9.putConstraint(SpringLayout.WEST, label, 6,
				SpringLayout.EAST, textField);
		panel_9.add(label);

		textField_1 = new JTextField();
		sl_panel_9.putConstraint(SpringLayout.NORTH, textField_1, 0,
				SpringLayout.NORTH, textField);
		sl_panel_9.putConstraint(SpringLayout.WEST, textField_1, 6,
				SpringLayout.EAST, label);
		sl_panel_9.putConstraint(SpringLayout.EAST, textField_1, -157,
				SpringLayout.EAST, panel_9);
		panel_9.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("\uC6D4");
		label_1.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_9.putConstraint(SpringLayout.NORTH, label_1, 3,
				SpringLayout.NORTH, textField);
		sl_panel_9.putConstraint(SpringLayout.WEST, label_1, 6,
				SpringLayout.EAST, textField_1);
		panel_9.add(label_1);

		textField_2 = new JTextField();
		sl_panel_9.putConstraint(SpringLayout.NORTH, textField_2, 0,
				SpringLayout.NORTH, textField);
		sl_panel_9.putConstraint(SpringLayout.WEST, textField_2, 6,
				SpringLayout.EAST, label_1);
		sl_panel_9.putConstraint(SpringLayout.EAST, textField_2, -110,
				SpringLayout.EAST, panel_9);
		textField_2.setColumns(10);
		panel_9.add(textField_2);

		JLabel label_2 = new JLabel("\uC77C");
		label_2.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_9.putConstraint(SpringLayout.NORTH, label_2, 3,
				SpringLayout.NORTH, textField);
		sl_panel_9.putConstraint(SpringLayout.WEST, label_2, 6,
				SpringLayout.EAST, textField_2);
		panel_9.add(label_2);

		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		panel_10.setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(12, 23, 170, 21);
		panel_10.add(panel_12);
		panel_12.setLayout(new CardLayout(0, 0));

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("서울남산체 EB", Font.PLAIN, 15));
		comboBox.addItem("식비");
		comboBox.addItem("주거/통신");
		comboBox.addItem("생활용품");
		comboBox.addItem("의복/미용");
		comboBox.addItem("교통/차량");
		comboBox.addItem("기타");
		panel_12.add(comboBox, "name_40869687610195");

		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		panel_11.setLayout(null);

		textField_3 = new JTextField();
		textField_3.setBounds(12, 17, 154, 25);
		panel_11.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_3 = new JLabel("\uC6D0");
		label_3.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		label_3.setBounds(179, 17, 57, 31);
		panel_11.add(label_3);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 192, 0));
		panel_5.add(panel_8);
		panel_8.setLayout(null);

		JPanel panel_13 = new JPanel();
		panel_13.setBounds(12, 10, 209, 48);
		panel_8.add(panel_13);
		SpringLayout sl_panel_13 = new SpringLayout();
		panel_13.setLayout(sl_panel_13);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uD604\uAE08");
		rdbtnNewRadioButton_1.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_13.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_1,
				10, SpringLayout.NORTH, panel_13);
		sl_panel_13.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_1, 27,
				SpringLayout.WEST, panel_13);
		panel_13.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uCE74\uB4DC");
		rdbtnNewRadioButton.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_13.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 0,
				SpringLayout.NORTH, rdbtnNewRadioButton_1);
		sl_panel_13.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton, -41,
				SpringLayout.EAST, panel_13);
		panel_13.add(rdbtnNewRadioButton);
		panel_6.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("\uACB0\uC81C\uB0B4\uC6A9");
		lblNewLabel_4.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		lblNewLabel_4.setToolTipText("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblNewLabel_4, "name_41211262029104");
		panel_2.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);

		textField_4 = new JTextField();
		sl_panel_7.putConstraint(SpringLayout.NORTH, textField_4, 10,
				SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, textField_4, 10,
				SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, textField_4, 92,
				SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, textField_4, 217,
				SpringLayout.WEST, panel_7);
		panel_7.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("New label");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 16,
				SpringLayout.SOUTH, panel_7);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_6, 227,
				SpringLayout.WEST, panel_2);
		panel_2.add(lblNewLabel_6);

		JPanel panel_15 = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path + "buttonOk.jpg");
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
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_15, 6,
				SpringLayout.SOUTH, panel_6);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_15, 1,
				SpringLayout.WEST, lblNewLabel_6);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_15, -10,
				SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_15, -83,
				SpringLayout.WEST, lblNewLabel_6);
		panel_2.add(panel_15);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 192, 0));
		tabbedPane.addTab("New tab", null, panel_3, null);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);

		JPanel panel_14 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_14, 10,
				SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_14, 10,
				SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_14, 161,
				SpringLayout.WEST, panel_3);
		panel_3.add(panel_14);
		panel_14.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_17 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_14, -5,
				SpringLayout.NORTH, panel_17);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_17, -174,
				SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_17, 0,
				SpringLayout.EAST, panel_14);
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_17, 156,
				SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_17, 10,
				SpringLayout.WEST, panel_3);
		panel_3.add(panel_17);

		JPanel panel_18 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_18, 0,
				SpringLayout.NORTH, panel_14);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_18, 6,
				SpringLayout.EAST, panel_14);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_18, 0,
				SpringLayout.SOUTH, panel_14);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_18, 278,
				SpringLayout.EAST, panel_14);

		JLabel lblNewLabel_8 = new JLabel("\uC77C\uC2DC");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));

		panel_14.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\uAE08\uC561");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		panel_14.add(lblNewLabel_9);
		panel_3.add(panel_18);

		JPanel panel_19 = new JPanel();
		sl_panel_3.putConstraint(SpringLayout.NORTH, panel_19, 5,
				SpringLayout.SOUTH, panel_18);
		sl_panel_3.putConstraint(SpringLayout.WEST, panel_19, 6,
				SpringLayout.EAST, panel_17);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_19, 118,
				SpringLayout.SOUTH, panel_18);
		panel_18.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(255, 192, 0));
		panel_18.add(panel_20);
		SpringLayout sl_panel_20 = new SpringLayout();
		panel_20.setLayout(sl_panel_20);

		textField_6 = new JTextField();
		sl_panel_20.putConstraint(SpringLayout.NORTH, textField_6, 24,
				SpringLayout.NORTH, panel_20);
		sl_panel_20.putConstraint(SpringLayout.WEST, textField_6, 10,
				SpringLayout.WEST, panel_20);
		sl_panel_20.putConstraint(SpringLayout.EAST, textField_6, 70,
				SpringLayout.WEST, panel_20);
		textField_6.setColumns(10);
		panel_20.add(textField_6);

		JLabel label_4 = new JLabel("\uB144");
		label_4.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_20.putConstraint(SpringLayout.WEST, label_4, 11,
				SpringLayout.EAST, textField_6);
		sl_panel_20.putConstraint(SpringLayout.SOUTH, label_4, 0,
				SpringLayout.SOUTH, textField_6);
		panel_20.add(label_4);

		textField_7 = new JTextField();
		sl_panel_20.putConstraint(SpringLayout.NORTH, textField_7, 0,
				SpringLayout.NORTH, textField_6);
		sl_panel_20.putConstraint(SpringLayout.WEST, textField_7, 5,
				SpringLayout.EAST, label_4);
		sl_panel_20.putConstraint(SpringLayout.EAST, textField_7, 27,
				SpringLayout.EAST, label_4);
		textField_7.setColumns(10);
		panel_20.add(textField_7);

		JLabel label_5 = new JLabel("\uC6D4");
		label_5.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_20.putConstraint(SpringLayout.WEST, label_5, 6,
				SpringLayout.EAST, textField_7);
		sl_panel_20.putConstraint(SpringLayout.SOUTH, label_5, 0,
				SpringLayout.SOUTH, textField_6);
		panel_20.add(label_5);

		textField_8 = new JTextField();
		sl_panel_20.putConstraint(SpringLayout.NORTH, textField_8, 0,
				SpringLayout.NORTH, textField_6);
		sl_panel_20.putConstraint(SpringLayout.WEST, textField_8, 6,
				SpringLayout.EAST, label_5);
		sl_panel_20.putConstraint(SpringLayout.EAST, textField_8, 28,
				SpringLayout.EAST, label_5);
		textField_8.setColumns(10);
		panel_20.add(textField_8);

		JLabel label_6 = new JLabel("\uC77C");
		label_6.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_20.putConstraint(SpringLayout.WEST, label_6, 10,
				SpringLayout.EAST, textField_8);
		sl_panel_20.putConstraint(SpringLayout.SOUTH, label_6, 0,
				SpringLayout.SOUTH, textField_6);
		panel_20.add(label_6);

		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(255, 192, 0));
		panel_18.add(panel_21);
		SpringLayout sl_panel_21 = new SpringLayout();
		panel_21.setLayout(sl_panel_21);

		textField_9 = new JTextField();
		sl_panel_21.putConstraint(SpringLayout.WEST, textField_9, 10,
				SpringLayout.WEST, panel_21);
		sl_panel_21.putConstraint(SpringLayout.SOUTH, textField_9, -25,
				SpringLayout.SOUTH, panel_21);
		textField_9.setColumns(10);
		panel_21.add(textField_9);

		JLabel label_7 = new JLabel("\uC6D0");
		label_7.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_21.putConstraint(SpringLayout.NORTH, label_7, 3,
				SpringLayout.NORTH, textField_9);
		sl_panel_21.putConstraint(SpringLayout.WEST, label_7, 6,
				SpringLayout.EAST, textField_9);
		panel_21.add(label_7);
		sl_panel_3.putConstraint(SpringLayout.EAST, panel_19, 278,
				SpringLayout.EAST, panel_17);
		panel_17.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("\uBA54\uBAA8");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		panel_17.add(lblNewLabel_7, "name_42034667513366");
		panel_3.add(panel_19);
		SpringLayout sl_panel_19 = new SpringLayout();
		panel_19.setLayout(sl_panel_19);

		textField_5 = new JTextField();
		sl_panel_19.putConstraint(SpringLayout.NORTH, textField_5, 10,
				SpringLayout.NORTH, panel_19);
		sl_panel_19.putConstraint(SpringLayout.WEST, textField_5, 10,
				SpringLayout.WEST, panel_19);
		sl_panel_19.putConstraint(SpringLayout.SOUTH, textField_5, 103,
				SpringLayout.NORTH, panel_19);
		sl_panel_19.putConstraint(SpringLayout.EAST, textField_5, 209,
				SpringLayout.WEST, panel_19);
		panel_19.add(textField_5);
		textField_5.setColumns(10);

		panel_14.setBackground(new Color(255, 192, 0));
		panel_17.setBackground(new Color(255, 192, 0));
		panel_18.setBackground(new Color(255, 192, 0));
		panel_19.setBackground(new Color(255, 192, 0));
		panel_10.setBackground(new Color(255, 192, 0));
		panel_11.setBackground(new Color(255, 192, 0));
		panel_13.setBackground(new Color(255, 192, 0));
	}
}
