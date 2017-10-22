package com.ALL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.DAO.WriteDAO;
import com.DAO.budgetDAO;
import com.VO.BudgetVO;
import com.VO.OutcomeVO;
import com.img.a;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class budgeNewtInput extends JFrame {

	private JPanel contentPane;
	private JTextField textField_monthInput;
	private JTextField textField_name;
	private JTextField textField_money;
	private JTextField textField_yearInput;
	private int year = 0; //년도
	private int mon = 0; // 월 
	
	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budgeNewtInput frame = new budgeNewtInput(id);
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
	public budgeNewtInput(String id) {
		CalendarOutPut();
		
		setUndecorated(true);//타이틀바 없애기

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(690, 300, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		//this.setLocation(100, 100); // 띄울 위치 정하기
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, "name_26506827263520");
		panel.setLayout(new CardLayout(0, 0));

		JPanel panel_bg = new JPanel() { // 전체판때기 생성& 이미지 넣기
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "background_plus_budget.png");
					BufferedImage icon = ImageIO.read(fileInSamePackage);

					Dimension d = getSize();
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel_bg.setOpaque(false);
		panel.add(panel_bg, "name_26643882768915");
		SpringLayout sl_panel_bg = new SpringLayout();
		panel_bg.setLayout(sl_panel_bg);

		JPanel panel_forehead = new JPanel();
		panel_forehead.setBackground(new Color(0, 0, 0, 0));
		panel_forehead.setOpaque(false);
		sl_panel_bg.putConstraint(SpringLayout.NORTH, panel_forehead, 0, SpringLayout.NORTH, panel_bg);
		sl_panel_bg.putConstraint(SpringLayout.WEST, panel_forehead, 0, SpringLayout.WEST, panel_bg);
		sl_panel_bg.putConstraint(SpringLayout.SOUTH, panel_forehead, 50, SpringLayout.NORTH, panel_bg);
		sl_panel_bg.putConstraint(SpringLayout.EAST, panel_forehead, 474, SpringLayout.WEST, panel_bg);
		panel_bg.add(panel_forehead);

		JPanel panel_body = new JPanel();
		panel_body.setOpaque(false);
		sl_panel_bg.putConstraint(SpringLayout.NORTH, panel_body, 6, SpringLayout.SOUTH, panel_forehead);
		sl_panel_bg.putConstraint(SpringLayout.SOUTH, panel_body, -61, SpringLayout.SOUTH, panel_bg);
		panel_body.setBackground(new Color(0, 0, 0, 0));
		sl_panel_bg.putConstraint(SpringLayout.WEST, panel_body, 0, SpringLayout.WEST, panel_bg);
		sl_panel_bg.putConstraint(SpringLayout.EAST, panel_body, 0, SpringLayout.EAST, panel_forehead);
		panel_bg.add(panel_body);
		panel_body.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panel_foot = new JPanel();
		sl_panel_bg.putConstraint(SpringLayout.NORTH, panel_foot, -52, SpringLayout.SOUTH, panel_bg);
		sl_panel_bg.putConstraint(SpringLayout.SOUTH, panel_foot, 0, SpringLayout.SOUTH, panel_bg);
		panel_foot.setBackground(new Color(0, 0, 0, 0));

		JPanel panel_month = new JPanel();
		panel_month.setOpaque(false);
		panel_month.setBackground(new Color(0, 0, 0, 0));
		panel_body.add(panel_month);
		SpringLayout sl_panel_month = new SpringLayout();
		panel_month.setLayout(sl_panel_month);

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setBackground(new Color(0, 0, 0, 0));
		sl_panel_month.putConstraint(SpringLayout.NORTH, panel_8, 0, SpringLayout.NORTH, panel_month);
		sl_panel_month.putConstraint(SpringLayout.WEST, panel_8, 0, SpringLayout.WEST, panel_month);
		sl_panel_month.putConstraint(SpringLayout.SOUTH, panel_8, 83, SpringLayout.NORTH, panel_month);
		sl_panel_month.putConstraint(SpringLayout.EAST, panel_8, 150, SpringLayout.WEST, panel_month);
		panel_month.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setBackground(new Color(0, 0, 0, 0));
		sl_panel_month.putConstraint(SpringLayout.NORTH, panel_9, 0, SpringLayout.NORTH, panel_month);
		sl_panel_month.putConstraint(SpringLayout.WEST, panel_9, 6, SpringLayout.EAST, panel_8);
		panel_8.setLayout(new CardLayout(0, 0));

		JLabel lbl_month = new JLabel("\uAE30\uC900 \uB144\uC6D4");
		lbl_month.setOpaque(false);
		lbl_month.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lbl_month.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_8.add(lbl_month, "name_31923090134195");
		sl_panel_month.putConstraint(SpringLayout.SOUTH, panel_9, 83, SpringLayout.NORTH, panel_month);
		sl_panel_month.putConstraint(SpringLayout.EAST, panel_9, -10, SpringLayout.EAST, panel_month);
		panel_month.add(panel_9);
		SpringLayout sl_panel_9 = new SpringLayout();
		panel_9.setLayout(sl_panel_9);

		textField_monthInput = new JTextField();
		textField_monthInput.setText(mon+"");
		textField_monthInput.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_panel_9.putConstraint(SpringLayout.WEST, textField_monthInput, 153, SpringLayout.WEST, panel_9);
		textField_monthInput.setFont(new Font("서울남산 장체B", Font.PLAIN, 14));
		textField_monthInput.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_monthInput.setOpaque(false);
		textField_monthInput.setBounds(12, 24, 60, 21);
		panel_9.add(textField_monthInput);
		textField_monthInput.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uC6D4");
		sl_panel_9.putConstraint(SpringLayout.NORTH, lblNewLabel, 24, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.WEST, lblNewLabel, 225, SpringLayout.WEST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, lblNewLabel, -26, SpringLayout.SOUTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.NORTH, textField_monthInput, 12, SpringLayout.NORTH, lblNewLabel);
		sl_panel_9.putConstraint(SpringLayout.EAST, textField_monthInput, -6, SpringLayout.WEST, lblNewLabel);
		lblNewLabel.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_9.add(lblNewLabel);

		JPanel panel_name = new JPanel();
		panel_name.setOpaque(false);
		panel_name.setBackground(new Color(0, 0, 0, 0));
		panel_body.add(panel_name);
		SpringLayout sl_panel_name = new SpringLayout();
		panel_name.setLayout(sl_panel_name);

		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_10.setBackground(new Color(0, 0, 0, 0));
		sl_panel_name.putConstraint(SpringLayout.NORTH, panel_10, 0, SpringLayout.NORTH, panel_name);
		sl_panel_name.putConstraint(SpringLayout.WEST, panel_10, 0, SpringLayout.WEST, panel_name);
		sl_panel_name.putConstraint(SpringLayout.SOUTH, panel_10, 83, SpringLayout.NORTH, panel_name);
		sl_panel_name.putConstraint(SpringLayout.EAST, panel_10, 150, SpringLayout.WEST, panel_name);
		panel_name.add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setBackground(new Color(0, 0, 0, 0));
		sl_panel_name.putConstraint(SpringLayout.NORTH, panel_11, 0, SpringLayout.NORTH, panel_name);
		sl_panel_name.putConstraint(SpringLayout.WEST, panel_11, 5, SpringLayout.EAST, panel_10);
		sl_panel_name.putConstraint(SpringLayout.SOUTH, panel_11, 0, SpringLayout.SOUTH, panel_10);
		sl_panel_name.putConstraint(SpringLayout.EAST, panel_11, 314, SpringLayout.EAST, panel_10);
		panel_10.setLayout(new CardLayout(0, 0));

		JLabel lbl_name = new JLabel("\uC608\uC0B0 \uC774\uB984");
		lbl_name.setOpaque(false);
		lbl_name.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_10.add(lbl_name, "name_32018754577905");
		panel_name.add(panel_11);
		SpringLayout sl_panel_11 = new SpringLayout();
		panel_11.setLayout(sl_panel_11);

		textField_name = new JTextField();
		sl_panel_11.putConstraint(SpringLayout.NORTH, textField_name, 23, SpringLayout.NORTH, panel_11);
		sl_panel_11.putConstraint(SpringLayout.WEST, textField_name, 10, SpringLayout.WEST, panel_11);
		sl_panel_11.putConstraint(SpringLayout.SOUTH, textField_name, 60, SpringLayout.NORTH, panel_11);
		sl_panel_11.putConstraint(SpringLayout.EAST, textField_name, 235, SpringLayout.WEST, panel_11);
		panel_11.add(textField_name);
		textField_name.setColumns(10);
		textField_name.setFont(new Font("서울남산 장체B", Font.PLAIN, 14));
		textField_name.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_name.setOpaque(false);
		textField_name.setBounds(12, 24, 60, 21);
		textField_monthInput.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0, 0));
		panel_3.setOpaque(false);
		sl_panel_9.putConstraint(SpringLayout.NORTH, panel_3, -24, SpringLayout.NORTH, lblNewLabel);
		sl_panel_9.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, panel_3, 83, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, panel_3, -6, SpringLayout.WEST, textField_monthInput);
		panel_9.add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);

		textField_yearInput = new JTextField();
		textField_yearInput.setText(year+"");
		sl_panel_3.putConstraint(SpringLayout.WEST, textField_yearInput, 0, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, textField_yearInput, 88, SpringLayout.WEST, panel_3);
		textField_yearInput.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_yearInput.setFont(new Font("서울남산 장체B", Font.PLAIN, 14));
		panel_3.add(textField_yearInput);
		textField_yearInput.setOpaque(false);
		textField_yearInput.setBounds(12, 24, 60, 21);
		textField_yearInput.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_yearInput.setColumns(10);

		JLabel label_2 = new JLabel("\uB144");
		sl_panel_3.putConstraint(SpringLayout.NORTH, label_2, 32, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, label_2, 10, SpringLayout.EAST, textField_yearInput);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, label_2, -30, SpringLayout.SOUTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.EAST, label_2, -10, SpringLayout.EAST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.NORTH, textField_yearInput, 6, SpringLayout.NORTH, label_2);
		label_2.setBackground(new Color(0, 0, 0, 0));
		label_2.setOpaque(false);
		label_2.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_3.add(label_2);

		JPanel panel_category = new JPanel();
		panel_category.setOpaque(false);
		panel_category.setBackground(new Color(0, 0, 0, 0));
		panel_body.add(panel_category);
		SpringLayout sl_panel_category = new SpringLayout();
		panel_category.setLayout(sl_panel_category);

		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_12.setBackground(new Color(0, 0, 0, 0));
		sl_panel_category.putConstraint(SpringLayout.NORTH, panel_12, 0, SpringLayout.NORTH, panel_category);
		sl_panel_category.putConstraint(SpringLayout.WEST, panel_12, 0, SpringLayout.WEST, panel_category);
		sl_panel_category.putConstraint(SpringLayout.SOUTH, panel_12, 83, SpringLayout.NORTH, panel_category);
		sl_panel_category.putConstraint(SpringLayout.EAST, panel_12, 150, SpringLayout.WEST, panel_category);
		panel_category.add(panel_12);

		JPanel panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_13.setBackground(new Color(0, 0, 0, 0));
		sl_panel_category.putConstraint(SpringLayout.NORTH, panel_13, 0, SpringLayout.NORTH, panel_category);
		sl_panel_category.putConstraint(SpringLayout.WEST, panel_13, 6, SpringLayout.EAST, panel_12);
		sl_panel_category.putConstraint(SpringLayout.SOUTH, panel_13, 0, SpringLayout.SOUTH, panel_12);
		sl_panel_category.putConstraint(SpringLayout.EAST, panel_13, 314, SpringLayout.EAST, panel_12);
		panel_12.setLayout(new CardLayout(0, 0));

		JLabel lbl_category = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lbl_category.setOpaque(false);
		lbl_category.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lbl_category.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_12.add(lbl_category, "name_32043832429087");
		panel_category.add(panel_13);
		SpringLayout sl_panel_13 = new SpringLayout();
		panel_13.setLayout(sl_panel_13);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(0, 0, 0, 0));
		sl_panel_13.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel_13);
		sl_panel_13.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel_13);
		sl_panel_13.putConstraint(SpringLayout.SOUTH, panel_2, 73, SpringLayout.NORTH, panel_13);
		sl_panel_13.putConstraint(SpringLayout.EAST, panel_2, 171, SpringLayout.WEST, panel_13);
		panel_13.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JComboBox comboBox_category = new JComboBox();
		sl_panel_2.putConstraint(SpringLayout.NORTH, comboBox_category, 20, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, comboBox_category, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, comboBox_category, -23, SpringLayout.EAST, panel_2);
		comboBox_category.setFont(new Font("서울남산 장체B", Font.PLAIN, 15));
		comboBox_category.addItem("식비");
		comboBox_category.addItem("주거/통신");
		comboBox_category.addItem("생활용품");
		comboBox_category.addItem("의복/미용");
		comboBox_category.addItem("교통/차량");
		comboBox_category.addItem("기타");
		comboBox_category.setOpaque(false);
		panel_2.add(comboBox_category);

		JPanel panel_money = new JPanel();
		panel_money.setOpaque(false);
		panel_money.setBackground(new Color(0, 0, 0, 0));
		panel_body.add(panel_money);
		SpringLayout sl_panel_money = new SpringLayout();
		panel_money.setLayout(sl_panel_money);

		JPanel panel_14 = new JPanel();
		panel_14.setOpaque(false);
		panel_14.setBackground(new Color(0, 0, 0, 0));
		sl_panel_money.putConstraint(SpringLayout.NORTH, panel_14, 0, SpringLayout.NORTH, panel_money);
		sl_panel_money.putConstraint(SpringLayout.WEST, panel_14, 0, SpringLayout.WEST, panel_money);
		sl_panel_money.putConstraint(SpringLayout.SOUTH, panel_14, 83, SpringLayout.NORTH, panel_money);
		sl_panel_money.putConstraint(SpringLayout.EAST, panel_14, 150, SpringLayout.WEST, panel_money);
		panel_money.add(panel_14);

		JPanel panel_15 = new JPanel();
		panel_15.setOpaque(false);
		panel_15.setBackground(new Color(0, 0, 0, 0));
		sl_panel_money.putConstraint(SpringLayout.NORTH, panel_15, 0, SpringLayout.NORTH, panel_money);
		sl_panel_money.putConstraint(SpringLayout.WEST, panel_15, 6, SpringLayout.EAST, panel_14);
		sl_panel_money.putConstraint(SpringLayout.SOUTH, panel_15, 83, SpringLayout.NORTH, panel_money);
		sl_panel_money.putConstraint(SpringLayout.EAST, panel_15, 314, SpringLayout.EAST, panel_14);
		panel_14.setLayout(new CardLayout(0, 0));

		JLabel lbl_money = new JLabel("\uC608\uC0B0\uAE08\uC561");
		lbl_money.setOpaque(false);
		lbl_money.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lbl_money.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_14.add(lbl_money, "name_32088624769485");
		panel_money.add(panel_15);
		SpringLayout sl_panel_15 = new SpringLayout();
		panel_15.setLayout(sl_panel_15);

		textField_money = new JTextField();
		sl_panel_15.putConstraint(SpringLayout.NORTH, textField_money, 20, SpringLayout.NORTH, panel_15);
		sl_panel_15.putConstraint(SpringLayout.WEST, textField_money, 10, SpringLayout.WEST, panel_15);
		sl_panel_15.putConstraint(SpringLayout.SOUTH, textField_money, 59, SpringLayout.NORTH, panel_15);
		sl_panel_15.putConstraint(SpringLayout.EAST, textField_money, 162, SpringLayout.WEST, panel_15);
		textField_money.setOpaque(false);
		textField_money.setFont(new Font("서울남산 장체B", Font.PLAIN, 14));
		textField_money.setColumns(10);
		textField_money.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_15.add(textField_money);

		JLabel lbl_won = new JLabel("\uC6D0");
		lbl_won.setOpaque(false);
		sl_panel_15.putConstraint(SpringLayout.WEST, lbl_won, 15, SpringLayout.EAST, textField_money);
		sl_panel_15.putConstraint(SpringLayout.SOUTH, lbl_won, 0, SpringLayout.SOUTH, textField_money);
		lbl_won.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_15.add(lbl_won);
		sl_panel_bg.putConstraint(SpringLayout.WEST, panel_foot, 0, SpringLayout.WEST, panel_bg);
		sl_panel_bg.putConstraint(SpringLayout.EAST, panel_foot, 0, SpringLayout.EAST, panel_forehead);
		panel_forehead.setLayout(new CardLayout(0, 0));

		JLabel lbl_planning = new JLabel("\u25B6 \uC0C8 \uC608\uC0B0 \uB9CC\uB4E4\uAE30 \u25C0");
		lbl_planning.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_planning.setFont(new Font("서울남산 장체BL", Font.PLAIN, 21));
		panel_forehead.add(lbl_planning, "name_36833586585886");
		panel_bg.add(panel_foot);
		SpringLayout sl_panel_foot = new SpringLayout();
		panel_foot.setLayout(sl_panel_foot);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(0, 0, 0, 0));
		sl_panel_foot.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel_foot);
		sl_panel_foot.putConstraint(SpringLayout.WEST, panel_1, 120, SpringLayout.WEST, panel_foot);
		sl_panel_foot.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel_foot);
		sl_panel_foot.putConstraint(SpringLayout.EAST, panel_1, -109, SpringLayout.EAST, panel_foot);
		panel_foot.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		panel_1.add(label_1);

		JButton btn_cancel = new JButton("\uCDE8\uC18C") { // 취소 버튼
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "ButtonVoid.png");
					BufferedImage icon = ImageIO.read(fileInSamePackage);

					Dimension d = getSize();
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel_1.add(btn_cancel);
		btn_cancel.addActionListener(new ActionListener() { // 취소버튼 클릭시 걍 예산창으로
															// 돌아감
			public void actionPerformed(ActionEvent e) {

				budgetRestart ms = new budgetRestart(id,0,0);
				ms.main(id,0,0);
				dispose();
			}
		});
		btn_cancel.setBorderPainted(false);
		btn_cancel.setContentAreaFilled(false);
		btn_cancel.setOpaque(false);
		btn_cancel.setFocusPainted(false);
		btn_cancel.setFont(new Font("서울남산 장체BL", Font.PLAIN, 14));

		JButton btn_save = new JButton("\uC800\uC7A5") { // 취소 버튼
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "ButtonVoid.png");
					BufferedImage icon = ImageIO.read(fileInSamePackage);

					Dimension d = getSize();
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String category = null;
				int categoryIndex = comboBox_category.getSelectedIndex();
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

				int year = Integer.parseInt(textField_yearInput.getText());
				int month = Integer.parseInt(textField_monthInput.getText());
				System.out.println("예산 추가창 년="+year+" 월 ="+month);
				int money = Integer.parseInt(textField_money.getText());

				String memo = textField_name.getText();

				//System.out.println(id + "/" + money + "/" + month + "/" + category + "/" + year + "/" + memo);

				BudgetVO bvo = new BudgetVO(id, money, month, category, year, memo);
				budgetDAO bdao = new budgetDAO();
				int count = bdao.budgetInsert(bvo);
				
				if (count>0){
					JOptionPane.showMessageDialog(null, "저장 되었습니다.");
					budgetRestart br = new budgetRestart(id,0,0);
					br.main(id,0,0);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "등록실패");
				}

			}
		});

		panel_1.add(btn_save);

		btn_save.setBorderPainted(false);
		btn_save.setContentAreaFilled(false);
		btn_save.setOpaque(false);
		btn_save.setFocusPainted(false);
		btn_save.setFont(new Font("서울남산 장체BL", Font.PLAIN, 14));
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_save.setFont(new Font("서울남산 장체B", Font.PLAIN, 12));

		JLabel label = new JLabel("");
		label.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		panel_1.add(label);
	}
	
	public void CalendarOutPut() {
		 Calendar cal = Calendar.getInstance();
	     mon = cal.get(Calendar.MONTH)+1; // 월 
	     year = cal.get(Calendar.YEAR); //년도
	}
}
