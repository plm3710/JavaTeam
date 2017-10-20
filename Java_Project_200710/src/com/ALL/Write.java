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
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_1_1;
	private JTextField textField_2;
	private JTextField textField_2_1;
	private JTextField textField_3;
	private JTextField textField_4;

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

		panel_1.setBackground(new Color(191, 192, 192));
		
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
		tabbedPane.setForeground(new Color(0,0,0));
		UIManager.put("TabbedPane.highlight", Color.GRAY);  //테두리
		UIManager.put("TabbedPane.focus", Color.GRAY);
		UIManager.put("TabbedPane.selectHighlight", Color.GRAY);
		UIManager.put("TabbedPane.foreground", Color.GRAY);
		tabbedPane.setFont( new Font( "서울남산체 L", Font.BOLD, 24 ) );
		
		tabbedPane.setBackground(new Color(191,192,192));
		UIManager.put("TabbedPane.selected", new Color(255,192,0));  //탭 색깔 (눌렀을때)
		
		
		tabbedPane.setUI(new BasicTabbedPaneUI() { // 탭 사이즈 변경 / 주석 풀면 디자인 화면
					// 안됨

					@Override
					protected int calculateTabHeight(int tabPlacement,
							int tabIndex, int fontHeight) {
						// TODO Auto-generated method stub
						return 40;
					}

					@Override
					protected int calculateTabWidth(int tabPlacement,
							int tabIndex, FontMetrics metrics) {
						// TODO Auto-generated method stub
						return 223;
					}

				});
		panel_1.add(tabbedPane, "name_39837979284068");

		JPanel panel_16 = new JPanel();
		tabbedPane.addTab("지출", null, panel_16);
		SpringLayout sl_panel_16 = new SpringLayout();
		panel_16.setLayout(sl_panel_16);
		panel_16.setBackground(new Color(255, 192, 0));
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 192, 0));
		sl_panel_16.putConstraint(SpringLayout.NORTH, panel_4, 10,
				SpringLayout.NORTH, panel_16);
		sl_panel_16.putConstraint(SpringLayout.WEST, panel_4, 10,
				SpringLayout.WEST, panel_16);
		sl_panel_16.putConstraint(SpringLayout.SOUTH, panel_4, 282,
				SpringLayout.NORTH, panel_16);
		sl_panel_16.putConstraint(SpringLayout.EAST, panel_4, 159,
				SpringLayout.WEST, panel_16);
		panel_16.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 192, 0));
		sl_panel_16.putConstraint(SpringLayout.NORTH, panel_5, 10,
				SpringLayout.NORTH, panel_16);

		sl_panel_16.putConstraint(SpringLayout.WEST, panel_5, 6,
				SpringLayout.EAST, panel_4);
		sl_panel_16.putConstraint(SpringLayout.SOUTH, panel_5, 282,
				SpringLayout.NORTH, panel_16);
		sl_panel_16.putConstraint(SpringLayout.EAST, panel_5, 280,
				SpringLayout.EAST, panel_4);
		panel_16.add(panel_5);

		JPanel panel_6 = new JPanel();
		sl_panel_16.putConstraint(SpringLayout.WEST, panel_6, 0,
				SpringLayout.WEST, panel_4);
		sl_panel_16.putConstraint(SpringLayout.SOUTH, panel_6, 98,
				SpringLayout.SOUTH, panel_4);
		panel_6.setBackground(new Color(255, 192, 0));

		sl_panel_16.putConstraint(SpringLayout.NORTH, panel_6, 6,
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
		sl_panel_16.putConstraint(SpringLayout.EAST, panel_6, 159,
				SpringLayout.WEST, panel_16);
		panel_16.add(panel_6);

		JPanel panel_7 = new JPanel();
		sl_panel_16.putConstraint(SpringLayout.WEST, panel_7, 6, SpringLayout.EAST, panel_6);
		sl_panel_16.putConstraint(SpringLayout.SOUTH, panel_7, 98,
				SpringLayout.SOUTH, panel_5);
		sl_panel_16.putConstraint(SpringLayout.EAST, panel_7, -10, SpringLayout.EAST, panel_16);
		panel_7.setBackground(new Color(255, 192, 0));
		sl_panel_16.putConstraint(SpringLayout.NORTH, panel_7, 6,
				SpringLayout.SOUTH, panel_5);
		panel_5.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 192, 0));
		panel_5.add(panel_9);
		panel_9.setLayout(null);

		textField = new JTextField();
		textField.setBounds(12, 23, 60, 21);
		panel_9.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\uB144");
		label.setBounds(78, 26, 17, 20);
		label.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		panel_9.add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(101, 23, 18, 21);
		panel_9.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("\uC6D4");
		label_1.setBounds(125, 26, 17, 20);
		label_1.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		panel_9.add(label_1);

		textField_2 = new JTextField();
		textField_2.setBounds(148, 23, 18, 21);
		textField_2.setColumns(10);
		panel_9.add(textField_2);

		JLabel label_2 = new JLabel("\uC77C");
		label_2.setBounds(172, 26, 17, 20);
		label_2.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
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
		textField_3.setBounds(12, 21, 154, 25);
		panel_11.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_3 = new JLabel("\uC6D0");
		label_3.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		label_3.setBounds(178, 10, 67, 48);
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
		rdbtnNewRadioButton_1.setBackground(new Color(255,192,0));
		rdbtnNewRadioButton_1.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		sl_panel_13.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_1,
				10, SpringLayout.NORTH, panel_13);
		sl_panel_13.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_1, 27,
				SpringLayout.WEST, panel_13);
		panel_13.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uCE74\uB4DC");
		rdbtnNewRadioButton.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBackground(new Color(255,192,0));
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
		panel_16.add(panel_7);
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
		panel_10.setBackground(new Color(255, 192, 0));
		panel_11.setBackground(new Color(255, 192, 0));
		panel_13.setBackground(new Color(255, 192, 0));
		
		JPanel panel_14 = new JPanel();
		panel_16.add(panel_14);
		
		JPanel panel_button_ok = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path
							+ "buttonOk.png");
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
		sl_panel_16.putConstraint(SpringLayout.NORTH, panel_button_ok, 6, SpringLayout.SOUTH, panel_6);
		sl_panel_16.putConstraint(SpringLayout.WEST, panel_button_ok, 145, SpringLayout.WEST, panel_16);
		sl_panel_16.putConstraint(SpringLayout.SOUTH, panel_button_ok, -10, SpringLayout.SOUTH, panel_16);
		panel_16.add(panel_button_ok);
		
		JPanel panel_button_cancel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path
							+ "buttonCancel.png");
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
		sl_panel_16.putConstraint(SpringLayout.EAST, panel_button_ok, -6, SpringLayout.WEST, panel_button_cancel);
		sl_panel_16.putConstraint(SpringLayout.NORTH, panel_button_cancel, 6, SpringLayout.SOUTH, panel_7);
		sl_panel_16.putConstraint(SpringLayout.WEST, panel_button_cancel, 236, SpringLayout.WEST, panel_16);
		sl_panel_16.putConstraint(SpringLayout.EAST, panel_button_cancel, -128, SpringLayout.EAST, panel_16);
		sl_panel_16.putConstraint(SpringLayout.SOUTH, panel_button_cancel, -10, SpringLayout.SOUTH, panel_16);
		panel_16.add(panel_button_cancel);
		//////////////////////////////////////////////////////////////////////////
		JPanel panel_163 = new JPanel();
		tabbedPane.addTab("수입", null, panel_163);
		SpringLayout sl_panel_163 = new SpringLayout();
		panel_163.setLayout(sl_panel_163);
		panel_163.setBackground(new Color(255, 192, 0));
		
		
		
		JPanel panel_44 = new JPanel();
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_44, -290, SpringLayout.EAST, panel_163);
		panel_44.setBackground(new Color(255, 192, 0));
		panel_163.add(panel_44);

		JPanel panel_55 = new JPanel();
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_55, 6, SpringLayout.EAST, panel_44);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_55, -10, SpringLayout.EAST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_44, 0, SpringLayout.SOUTH, panel_55);
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_44, 0, SpringLayout.NORTH, panel_55);
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_55, 10, SpringLayout.NORTH, panel_163);
		panel_55.setBackground(new Color(255,192,0));
		panel_55.setBackground(new Color(255, 192, 0));
		panel_163.add(panel_55);

		JPanel panel_66 = new JPanel();
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_44, 0, SpringLayout.WEST, panel_66);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_66, 10, SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_66, -122, SpringLayout.SOUTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_66, 229, SpringLayout.NORTH, panel_163);
		panel_66.setBackground(new Color(255, 192, 0));
		panel_44.setLayout(new GridLayout(3, 0, 0, 0));

		JLabel lblNewLabel_111 = new JLabel("\uC218\uC785\uC77C\uC2DC");

		lblNewLabel_111.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		lblNewLabel_111.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_44.add(lblNewLabel_111);

		JLabel lblNewLabell = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabell.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		lblNewLabell.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_44.add(lblNewLabell);

		JLabel lblNewLabel_222 = new JLabel("\uACB0\uC81C\uAE08\uC561");
		lblNewLabel_222.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		lblNewLabel_222.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_44.add(lblNewLabel_222);
		panel_163.add(panel_66);

		JPanel panel_77 = new JPanel();
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_66, -6, SpringLayout.WEST, panel_77);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_55, -13, SpringLayout.NORTH, panel_77);
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_77, 229, SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_77, 0, SpringLayout.SOUTH, panel_66);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_77, -10, SpringLayout.EAST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_77, 165, SpringLayout.WEST, panel_163);
		panel_77.setBackground(new Color(255, 192, 0));
		panel_55.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_99 = new JPanel();
		panel_99.setBackground(new Color(255, 192, 0));
		panel_55.add(panel_99);
		panel_99.setLayout(null);

		textField_5 = new JTextField();
		textField_5.setBounds(12, 24, 60, 21);
		panel_99.add(textField_5);
		textField_5.setColumns(10);

		JLabel label111 = new JLabel("\uB144");
		label111.setBounds(78, 27, 17, 20);
		label111.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		panel_99.add(label111);

		textField_1_1 = new JTextField();
		textField_1_1.setBounds(101, 24, 18, 21);
		panel_99.add(textField_1_1);
		textField_1_1.setColumns(10);

		JLabel label_134 = new JLabel("\uC6D4");
		label_134.setBounds(125, 27, 17, 20);
		label_134.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		panel_99.add(label_134);

		textField_2_1 = new JTextField();
		textField_2_1.setBounds(148, 24, 18, 21);
		textField_2_1.setColumns(10);
		panel_99.add(textField_2_1);

		JLabel label_221 = new JLabel("\uC77C");
		label_221.setBounds(172, 27, 17, 20);
		label_221.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		panel_99.add(label_221);

		JPanel panel_101 = new JPanel();
		panel_101.setBackground(new Color(255,192,0));
		panel_55.add(panel_101);
		panel_101.setLayout(null);

		JPanel panel_120 = new JPanel();
		panel_120.setBounds(12, 23, 170, 21);
		panel_101.add(panel_120);
		panel_120.setLayout(new CardLayout(0, 0));

		JComboBox comboBox3 = new JComboBox();
		comboBox3.setFont(new Font("서울남산체 EB", Font.PLAIN, 15));
		comboBox3.addItem("식비");
		comboBox3.addItem("주거/통신");
		comboBox3.addItem("생활용품");
		comboBox3.addItem("의복/미용");
		comboBox3.addItem("교통/차량");
		comboBox3.addItem("기타");
		panel_120.add(comboBox3, "name_40869687610195");

		JPanel panel_181 = new JPanel();
		panel_181.setBackground(new Color(255,192,0));
		panel_55.add(panel_181);
		panel_181.setLayout(null);

		textField_3 = new JTextField();
		textField_3.setBounds(12, 21, 154, 25);
		panel_181.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_315 = new JLabel("\uC6D0");
		label_315.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		label_315.setBounds(178, 10, 67, 48);
		panel_181.add(label_315);
		panel_66.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_41 = new JLabel("\uACB0\uC81C\uB0B4\uC6A9");
		lblNewLabel_41.setFont(new Font("서울남산체 EB", Font.PLAIN, 20));
		lblNewLabel_41.setToolTipText("");
		lblNewLabel_41.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_66.add(lblNewLabel_41, "name_41211262029104");
		panel_163.add(panel_77);
		SpringLayout sl_panel_77 = new SpringLayout();
		panel_77.setLayout(sl_panel_77);

		textField_4 = new JTextField();
		sl_panel_77.putConstraint(SpringLayout.NORTH, textField_4, 10,
				SpringLayout.NORTH, panel_77);
		sl_panel_77.putConstraint(SpringLayout.WEST, textField_4, 10,
				SpringLayout.WEST, panel_77);
		sl_panel_77.putConstraint(SpringLayout.SOUTH, textField_4, 92,
				SpringLayout.NORTH, panel_77);
		sl_panel_77.putConstraint(SpringLayout.EAST, textField_4, 217,
				SpringLayout.WEST, panel_77);
		panel_77.add(textField_4);
		textField_4.setColumns(10);

		JPanel panel_150 = new JPanel() {
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
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_150, 396, SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_150, 228, SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_150, -10, SpringLayout.SOUTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_150, -305, SpringLayout.EAST, panel_163);
		panel_163.add(panel_150);
		
		JPanel panel_3 = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path
							+ "buttonOk.png");
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
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_3, -10, SpringLayout.NORTH, panel_150);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_3, 145, SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_150);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_3, -219, SpringLayout.EAST, panel_163);
		panel_163.add(panel_3);
		
		JPanel panel_15 = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path
							+ "buttonCancel.png");
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
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_15, 0, SpringLayout.NORTH, panel_3);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_15, 7, SpringLayout.EAST, panel_3);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_15, 0, SpringLayout.SOUTH, panel_150);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_15, -127, SpringLayout.EAST, panel_163);
		panel_163.add(panel_15);
		
		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 51, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, -268, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -34, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel_1);
		panel_2.setBackground(new Color(0,0,0,0));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lbl_talking1 = new JLabel("\uB300\uD654\uC785\uB825 1");
		panel_2.add(lbl_talking1);
		
		JLabel lbl_talking2 = new JLabel("\uB300\uD654\uC785\uB825 2");
		panel_2.add(lbl_talking2);
		
		JLabel lbl_talking3 = new JLabel("\uB300\uD654\uC785\uB825 3");
		panel_2.add(lbl_talking3);
	}
}
