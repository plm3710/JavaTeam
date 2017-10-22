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
import com.DAO.WriteDAO;
import com.DAO.budgetDAO;
import com.VO.IncomeVO;
import com.VO.OutcomeVO;
import com.img.a;

import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Write extends JFrame {
	BufferedImage icon;
	private JPanel contentPane;
	private JTextField tf_outcome_year;
	private JTextField tf_income_year;
	private JTextField tf_outcome_month;
	private JTextField tf_income_month;
	private JTextField tf_outcome_day;
	private JTextField tf_income_day;
	private JTextField tf_income_money;
	private JTextField tf_outcome_money;
	private JTextField tf_outcome_memo;
	private JTextField tf_income_memo;
	private IncomeVO ivo = null;
	private OutcomeVO ovo = null;
	private int year = 0;
	private int mon = 0;
	private int day = 0;
	private int hour = 0;
	private int min = 0;
	private int sec = 0;
	private String talk = "입력창이에요 바부얌";

	/**
	 * Launch the application.
	 * 
	 * @param temp
	 */
	public static void main(String id, String temp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Write frame = new Write(id, temp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void CalendarOutPut() {
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR); // 년도
		mon = cal.get(Calendar.MONTH) + 1; // 월
		day = cal.get(Calendar.DAY_OF_MONTH); // 일
		hour = cal.get(Calendar.HOUR_OF_DAY); // 시간
		min = cal.get(Calendar.MINUTE); // 분
		sec = cal.get(Calendar.SECOND); // 초
	}

	/**
	 * Create the frame.
	 */

	public Write(String id, String temp) {
		talk = temp;
		MoneyDAO mdao = new MoneyDAO();
		budgetDAO bdao = new budgetDAO();
		Random rd = new Random();
		ArrayList<String> dialog_exceed = new ArrayList<String>();

		ArrayList<String> dialog_income = new ArrayList<String>();
		dialog_income.add("입금감사");
		dialog_income.add("땡큐감사");
		dialog_income.add("베리감사");

		ArrayList<String> dialog_outcome = new ArrayList<String>();
		dialog_outcome.add("돈썼네?");
		dialog_outcome.add("그만좀 쓰지?");
		dialog_outcome.add("그만좀 하세요!");

		CalendarOutPut();
		setUndecorated(true);// 타이틀바 없애기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(690, 176, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JLabel lbl_talking2 = new JLabel(talk);

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
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 480,
				SpringLayout.WEST, panel);

		panel_1.setBackground(new Color(191, 192, 192));

		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, -482,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10,
				SpringLayout.SOUTH, panel);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		UIManager.put("TabbedPane.highlight", Color.GRAY); // 테두리
		UIManager.put("TabbedPane.focus", Color.GRAY);
		UIManager.put("TabbedPane.selectHighlight", Color.GRAY);
		UIManager.put("TabbedPane.foreground", Color.GRAY);
		tabbedPane.setFont(new Font("서울남산 장체B", Font.BOLD, 24));

		tabbedPane.setBackground(new Color(191, 192, 192));
		UIManager.put("TabbedPane.selected", new Color(255, 192, 0)); // 탭 색깔
																		// (눌렀을때)

		// tabbedPane.setUI(new BasicTabbedPaneUI() { // 탭 사이즈 변경 / 주석 풀면 디자인 화면
		// // 안됨
		//
		// @Override
		// protected int calculateTabHeight(int tabPlacement,
		// int tabIndex, int fontHeight) {
		// // TODO Auto-generated method stub
		// return 40;
		// }
		//
		// @Override
		// protected int calculateTabWidth(int tabPlacement,
		// int tabIndex, FontMetrics metrics) {
		// // TODO Auto-generated method stub
		// return 231;
		// }
		//
		// });
		panel_1.add(tabbedPane, "name_39837979284068");

		JPanel panel_16 = new JPanel();
		tabbedPane.addTab("지출", null, panel_16);
		panel_16.setBackground(new Color(255, 192, 0));
		panel_16.setLayout(null);
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 10, 149, 249);
		panel_4.setBackground(new Color(255, 192, 0));
		panel_16.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(165, 10, 274, 249);
		panel_5.setBackground(new Color(255, 192, 0));
		panel_16.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 275, 149, 80);
		panel_6.setBackground(new Color(255, 192, 0));
		panel_4.setLayout(new GridLayout(4, 0, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("\uC9C0\uBD88\uC77C\uC2DC");

		lblNewLabel_1.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\uACB0\uC81C\uAE08\uC561");
		lblNewLabel_2.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uACB0\uC81C\uC218\uB2E8");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_3);
		panel_16.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(165, 265, 274, 92);
		panel_7.setBackground(new Color(255, 192, 0));
		panel_5.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 192, 0));
		panel_5.add(panel_9);
		panel_9.setLayout(null);

		tf_outcome_year = new JTextField();
		tf_outcome_year.setFont(new Font("서울남산 장체B", Font.PLAIN, 16));

		tf_outcome_year.setBorder(new MatteBorder(0, 0, 1, 0,
				(Color) new Color(0, 0, 0)));
		tf_outcome_year.setOpaque(false);
		// textField.setBorder(null);
		tf_outcome_year.setBounds(12, 20, 60, 21);
		panel_9.add(tf_outcome_year);
		tf_outcome_year.setColumns(10);

		JLabel label = new JLabel("\uB144");
		label.setBounds(78, 20, 17, 20);
		label.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_9.add(label);

		tf_outcome_month = new JTextField();
		tf_outcome_month.setFont(new Font("서울남산 장체B", Font.PLAIN, 16));
		tf_outcome_month.setBorder(new MatteBorder(0, 0, 1, 0,
				(Color) new Color(0, 0, 0)));
		tf_outcome_month.setOpaque(false);
		tf_outcome_month.setBounds(101, 20, 18, 21);
		panel_9.add(tf_outcome_month);
		tf_outcome_month.setColumns(10);

		JLabel label_1 = new JLabel("\uC6D4");
		label_1.setBounds(125, 20, 17, 20);
		label_1.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_9.add(label_1);

		tf_outcome_day = new JTextField();
		tf_outcome_day.setFont(new Font("서울남산 장체B", Font.PLAIN, 16));
		tf_outcome_day.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(
				0, 0, 0)));
		tf_outcome_day.setOpaque(false);
		tf_outcome_day.setBounds(148, 20, 18, 21);
		tf_outcome_day.setColumns(10);
		panel_9.add(tf_outcome_day);

		JLabel label_2 = new JLabel("\uC77C");
		label_2.setBounds(172, 20, 17, 20);
		label_2.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_9.add(label_2);

		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		panel_10.setLayout(null);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(12, 23, 170, 21);
		panel_10.add(panel_12);
		panel_12.setLayout(new CardLayout(0, 0));

		JComboBox comboBox_outcome = new JComboBox();
		comboBox_outcome.setFont(new Font("서울남산 장체B", Font.PLAIN, 15));
		comboBox_outcome.addItem("식비");
		comboBox_outcome.addItem("주거/통신");
		comboBox_outcome.addItem("생활용품");
		comboBox_outcome.addItem("의복/미용");
		comboBox_outcome.addItem("교통/차량");
		comboBox_outcome.addItem("기타");
		panel_12.add(comboBox_outcome, "name_40869687610195");

		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		panel_11.setLayout(null);

		tf_outcome_money = new JTextField();
		tf_outcome_money.setFont(new Font("서울남산 장체B", Font.PLAIN, 14));
		tf_outcome_money.setBorder(new MatteBorder(0, 0, 1, 0,
				(Color) new Color(0, 0, 0)));
		tf_outcome_money.setOpaque(false);
		tf_outcome_money.setBounds(12, 21, 154, 25);
		panel_11.add(tf_outcome_money);
		tf_outcome_money.setColumns(10);

		JLabel label_3 = new JLabel("\uC6D0");
		label_3.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
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

		JRadioButton radioButton_Cash = new JRadioButton("\uD604\uAE08");
		radioButton_Cash.setBackground(new Color(255, 192, 0));
		radioButton_Cash.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		sl_panel_13.putConstraint(SpringLayout.NORTH, radioButton_Cash, 10,
				SpringLayout.NORTH, panel_13);
		sl_panel_13.putConstraint(SpringLayout.WEST, radioButton_Cash, 27,
				SpringLayout.WEST, panel_13);
		panel_13.add(radioButton_Cash);

		JRadioButton radioButton_Card = new JRadioButton("\uCE74\uB4DC");
		radioButton_Card.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		radioButton_Card.setBackground(new Color(255, 192, 0));
		sl_panel_13.putConstraint(SpringLayout.NORTH, radioButton_Card, 0,
				SpringLayout.NORTH, radioButton_Cash);
		sl_panel_13.putConstraint(SpringLayout.EAST, radioButton_Card, -41,
				SpringLayout.EAST, panel_13);
		panel_13.add(radioButton_Card);
		panel_6.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("\uACB0\uC81C\uB0B4\uC6A9");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblNewLabel_4.setToolTipText("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblNewLabel_4, "name_41211262029104");
		panel_16.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);

		tf_outcome_memo = new JTextField();
		tf_outcome_memo.setFont(new Font("서울남산 장체B", Font.PLAIN, 14));
		tf_outcome_memo.setBorder(new MatteBorder(1, 1, 1, 1,
				(Color) new Color(0, 0, 0)));
		tf_outcome_memo.setOpaque(false);
		sl_panel_7.putConstraint(SpringLayout.NORTH, tf_outcome_memo, 10,
				SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, tf_outcome_memo, 10,
				SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, tf_outcome_memo, 92,
				SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, tf_outcome_memo, 217,
				SpringLayout.WEST, panel_7);
		panel_7.add(tf_outcome_memo);
		tf_outcome_memo.setColumns(10);
		panel_10.setBackground(new Color(255, 192, 0));
		panel_11.setBackground(new Color(255, 192, 0));
		panel_13.setBackground(new Color(255, 192, 0));

		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 0, 10, 10);
		panel_16.add(panel_14);

		JPanel panel_button_ok = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path + "buttonVoid.png");
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

		panel_button_ok.setBounds(245, 373, 70, 37);
		panel_16.add(panel_button_ok);
		panel_button_ok.setLayout(new CardLayout(0, 0));

		JLabel label_4 = new JLabel("\uC800\uC7A5");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String category = null;
				int categoryIndex = comboBox_outcome.getSelectedIndex();
				switch (categoryIndex) {
				case 0:
					category = "식비";
					break;
				case 1:
					category = "주거/통신";
					break;
				case 2:
					category = "생활용품";
					break;
				case 3:
					category = "의복/미용";
					break;
				case 4:
					category = "교통/차량";
					break;
				case 5:
					category = "기타";
					break;
				default:
					break;
				}
				int year = Integer.parseInt(tf_outcome_year.getText());
				int month = Integer.parseInt(tf_outcome_month.getText());
				int day = Integer.parseInt(tf_outcome_day.getText());
				int money = Integer.parseInt(tf_outcome_money.getText());

				String memo = tf_outcome_memo.getText();
				ovo = new OutcomeVO(id, money, year, month, day, category, memo);
				WriteDAO wdao = new WriteDAO();
				wdao.outcomeInsert(ovo);

				// 예산 초과시 다른 대화문 출력
				int monthlyOutcome = mdao.outcCategorySel(id, year, month,
						category);
				int monthlyBudget = bdao.monthelybudgetSel(id, year, month,
						category);

				if (monthlyOutcome > monthlyBudget) {
					if (category.equals("식비")) {
						talk = "식비 넘마니 썼음";
					} else if (category.equals("주거/통신")) {
						talk = "주거/통신 마니썼음";
					} else if (category.equals("생활용품")) {
						talk = "생활용품 마니썼음";
					} else if (category.equals("의복/미용")) {
						talk = "의복/미용 마니썻음";
					} else if (category.equals("교통/차량")) {
						talk = "교통/차량 마니썼음";
					} else if (category.equals("기타")) {
						talk = "기타 마니썼음";
					}
					Write w = new Write(id, talk);
					w.main(id, talk);
				} else {
					talk = dialog_outcome.get(rd.nextInt(dialog_outcome.size()));
					Write w = new Write(id, talk);
					w.main(id, talk);
				}
				JOptionPane.showMessageDialog(null, "저장 되었습니다.");
				dispose();

			}
		});
		label_4.setFont(new Font("서울남산 장체BL", Font.PLAIN, 14));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_button_ok.add(label_4, "name_21353759973774");

		JPanel panel_button_cancel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path + "buttonVoid.png");
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
		panel_button_cancel.setBounds(165, 373, 70, 37);
		panel_16.add(panel_button_cancel);
		panel_button_cancel.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("\uCDE8\uC18C");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_5.setFont(new Font("서울남산 장체BL", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_button_cancel.add(lblNewLabel_5, "name_21373295288555");
		JPanel panel_163 = new JPanel();
		tabbedPane.addTab("수입", null, panel_163);
		panel_163.setBackground(new Color(255, 192, 0));
		SpringLayout sl_panel_163 = new SpringLayout();
		panel_163.setLayout(sl_panel_163);

		JPanel panel_44 = new JPanel();
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_44, 10,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_44, 10,
				SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_44, 198,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_44, 159,
				SpringLayout.WEST, panel_163);
		panel_44.setBackground(new Color(255, 192, 0));
		panel_163.add(panel_44);

		JPanel panel_55 = new JPanel();
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_55, 10,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_55, 165,
				SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_55, 198,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_55, 439,
				SpringLayout.WEST, panel_163);
		panel_55.setBackground(new Color(255, 192, 0));
		panel_55.setBackground(new Color(255, 192, 0));
		panel_163.add(panel_55);

		JPanel panel_66 = new JPanel();
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_66, 217,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_66, 10,
				SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_66, 299,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_66, 159,
				SpringLayout.WEST, panel_163);
		panel_66.setBackground(new Color(255, 192, 0));
		panel_44.setLayout(new GridLayout(3, 0, 0, 0));

		JLabel lblNewLabel_111 = new JLabel("\uC218\uC785\uC77C\uC2DC");

		lblNewLabel_111.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblNewLabel_111.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_44.add(lblNewLabel_111);

		JLabel lblNewLabell = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabell.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblNewLabell.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_44.add(lblNewLabell);

		JLabel lblNewLabel_222 = new JLabel("\uC218\uC785\uAE08\uC561");
		lblNewLabel_222.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblNewLabel_222.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_44.add(lblNewLabel_222);
		panel_163.add(panel_66);

		JPanel panel_77 = new JPanel();
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_77, 204,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_77, 165,
				SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_77, 309,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_77, 439,
				SpringLayout.WEST, panel_163);
		panel_77.setBackground(new Color(255, 192, 0));
		panel_55.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_99 = new JPanel();
		panel_99.setBackground(new Color(255, 192, 0));
		panel_55.add(panel_99);
		panel_99.setLayout(null);

		tf_income_year = new JTextField();
		tf_income_year.setBounds(12, 24, 60, 21);
		tf_income_year.setText("year");
		tf_income_year.setFont(new Font("서울남산 장체B", Font.PLAIN, 16));
		tf_income_year.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(
				0, 0, 0)));
		tf_income_year.setOpaque(false);
		panel_99.add(tf_income_year);
		tf_income_year.setColumns(10);

		JLabel label111 = new JLabel("\uB144");
		label111.setBounds(72, 25, 17, 20);
		label111.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_99.add(label111);

		tf_income_month = new JTextField();
		tf_income_month.setBounds(101, 24, 18, 21);
		tf_income_month.setText("month");
		tf_income_month.setFont(new Font("서울남산 장체B", Font.PLAIN, 16));
		tf_income_month.setBorder(new MatteBorder(0, 0, 1, 0,
				(Color) new Color(0, 0, 0)));
		tf_income_month.setOpaque(false);
		panel_99.add(tf_income_month);
		tf_income_month.setColumns(10);

		JLabel label_134 = new JLabel("\uC6D4");
		label_134.setBounds(119, 25, 17, 20);
		label_134.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_99.add(label_134);

		tf_income_day = new JTextField();
		tf_income_day.setBounds(148, 24, 18, 21);
		tf_income_day.setFont(new Font("서울남산 장체B", Font.PLAIN, 16));
		tf_income_day.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(
				0, 0, 0)));
		tf_income_day.setOpaque(false);
		tf_income_day.setColumns(10);
		panel_99.add(tf_income_day);

		JLabel label_221 = new JLabel("\uC77C");
		label_221.setBounds(167, 25, 17, 20);
		label_221.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_99.add(label_221);

		JPanel panel_101 = new JPanel();
		panel_101.setBackground(new Color(255, 192, 0));
		panel_55.add(panel_101);
		panel_101.setLayout(null);

		JPanel panel_120 = new JPanel();
		panel_120.setBounds(12, 23, 170, 21);
		panel_101.add(panel_120);
		panel_120.setLayout(new CardLayout(0, 0));

		JComboBox comboBox_income = new JComboBox();
		comboBox_income.setFont(new Font("서울남산 장체B", Font.PLAIN, 15));
		panel_button_ok.addMouseListener(new MouseAdapter() { // 지출 저장
					@Override
					public void mouseClicked(MouseEvent e) {
						String category = null;
						int categoryIndex = comboBox_outcome.getSelectedIndex();

						switch (categoryIndex) {
						case 0:
							category = "식비";
							break;
						case 1:
							category = "주거/통신";
							break;
						case 2:
							category = "생활용품";
							break;
						case 3:
							category = "의복/미용";
							break;
						case 4:
							category = "교통/차량";
							break;
						case 5:
							category = "기타";
							break;
						default:
							break;
						}
						int year = Integer.parseInt(tf_outcome_year.getText());
						int month = Integer.parseInt(tf_outcome_month.getText());
						int day = Integer.parseInt(tf_outcome_day.getText());
						int money = Integer.parseInt(tf_outcome_money.getText());

						String memo = tf_outcome_memo.getText();
						ovo = new OutcomeVO(id, money, year, month, day,
								category, memo);
						WriteDAO wdao = new WriteDAO();

						JOptionPane.showMessageDialog(null, "저장 되었습니다.");
						wdao.outcomeInsert(ovo);
						dispose();

						talk = dialog_income.get(rd.nextInt(dialog_income
								.size()));
						Write w = new Write(id, talk);
						w.main(id, talk);

					}
				});
		comboBox_income.addItem("월급");
		comboBox_income.addItem("보너스");
		comboBox_income.addItem("수당");
		comboBox_income.addItem("용돈");
		comboBox_income.addItem("이자");
		comboBox_income.addItem("기타");
		panel_120.add(comboBox_income, "name_40869687610195");

		JPanel panel_181 = new JPanel();
		panel_181.setBackground(new Color(255, 192, 0));
		panel_55.add(panel_181);
		panel_181.setLayout(null);

		tf_income_money = new JTextField();
		tf_income_money.setFont(new Font("서울남산 장체B", Font.PLAIN, 14));
		tf_income_money.setBorder(new MatteBorder(0, 0, 1, 0,
				(Color) new Color(0, 0, 0)));
		tf_income_money.setOpaque(false);
		tf_income_money.setBounds(12, 21, 154, 25);
		panel_181.add(tf_income_money);
		tf_income_money.setColumns(10);

		JLabel label_315 = new JLabel("\uC6D0");
		label_315.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		label_315.setBounds(178, 10, 67, 48);
		panel_181.add(label_315);
		panel_66.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_41 = new JLabel("\uC218\uC785\uB0B4\uC6A9");
		lblNewLabel_41.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_41.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblNewLabel_41.setToolTipText("");
		lblNewLabel_41.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_66.add(lblNewLabel_41, "name_41211262029104");
		panel_163.add(panel_77);
		panel_77.setLayout(null);

		tf_income_memo = new JTextField();
		tf_income_memo.setHorizontalAlignment(SwingConstants.LEFT);
		tf_income_memo.setFont(new Font("서울남산 장체B", Font.PLAIN, 14));
		tf_income_memo.setBounds(10, 10, 207, 85);

		tf_income_memo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(
				0, 0, 0)));
		tf_income_memo.setOpaque(false);
		panel_77.add(tf_income_memo);
		tf_income_memo.setColumns(10);

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
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_150, 396,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_150, 228,
				SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_150, 423,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_150, 144,
				SpringLayout.WEST, panel_163);
		panel_163.add(panel_150);

		JPanel panel_3 = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path + "buttonVoid.png");
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
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_3, 377,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_3, 242,
				SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_3, 414,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_3, 312,
				SpringLayout.WEST, panel_163);
		panel_163.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		JLabel label_5 = new JLabel("\uC800\uC7A5");

		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("서울남산 장체BL", Font.PLAIN, 14));
		panel_3.add(label_5, "name_21516161530420");

		JPanel panel_15 = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path + "buttonVoid.png");
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
		sl_panel_163.putConstraint(SpringLayout.NORTH, panel_15, 377,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.WEST, panel_15, 160,
				SpringLayout.WEST, panel_163);
		sl_panel_163.putConstraint(SpringLayout.SOUTH, panel_15, 414,
				SpringLayout.NORTH, panel_163);
		sl_panel_163.putConstraint(SpringLayout.EAST, panel_15, 230,
				SpringLayout.WEST, panel_163);
		panel_163.add(panel_15);
		panel_15.setLayout(new CardLayout(0, 0));

		JLabel label_6 = new JLabel("\uCDE8\uC18C");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("서울남산 장체BL", Font.PLAIN, 14));
		panel_15.add(label_6, "name_21523545996197");

		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 51,
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 222,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -34,
				SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -26,
				SpringLayout.EAST, panel);
		panel_2.setBackground(new Color(0, 0, 0, 0));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));

		JLabel lbl_talking1 = new JLabel("");
		panel_2.add(lbl_talking1);

		panel_2.add(lbl_talking2);

		JLabel lbl_talking3 = new JLabel("");
		panel_2.add(lbl_talking3);

		ivo = new IncomeVO();

		label_5.addMouseListener(new MouseAdapter() {// 수입 저장
			@Override
			public void mouseClicked(MouseEvent e) {

				String category = null;
				int categoryIndex = comboBox_income.getSelectedIndex();

				switch (categoryIndex) {
				case 0:
					category = "월급";
					break;
				case 1:
					category = "보너스";
					break;
				case 2:
					category = "수당";
					break;
				case 3:
					category = "용돈";
					break;
				case 4:
					category = "이자";
					break;
				case 5:
					category = "기타";
					break;
				default:
					break;
				}
				int year = Integer.parseInt(tf_income_year.getText());
				int month = Integer.parseInt(tf_income_month.getText());
				int day = Integer.parseInt(tf_income_day.getText());
				int money = Integer.parseInt(tf_income_money.getText());

				String memo = tf_income_memo.getText();
				ivo = new IncomeVO(id, money, year, month, day, category, memo);
				WriteDAO wdao = new WriteDAO();

				JOptionPane.showMessageDialog(null, "저장 되었습니다.");
				wdao.incomeInsert(ivo);
				dispose();

				talk = dialog_income.get(rd.nextInt(dialog_income.size()));
				Write w = new Write(id, talk);
				w.main(id, talk);
			}
		});
		// / 입력창에 오늘날짜 넣기
		tf_outcome_year.setText(Integer.toString(year));
		tf_outcome_month.setText(Integer.toString(mon));
		tf_outcome_day.setText(Integer.toString(day));
		tf_income_year.setText(Integer.toString(year));
		tf_income_month.setText(Integer.toString(mon));
		tf_income_day.setText(Integer.toString(day));

		lbl_talking2.setText(talk);

	}
}
