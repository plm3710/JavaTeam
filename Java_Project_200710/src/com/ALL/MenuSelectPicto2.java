package com.ALL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.img.a;
import com.member.MainLogin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuSelectPicto2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSelectPicto2 frame = new MenuSelectPicto2(id);
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
	public MenuSelectPicto2(String id) {
		setUndecorated(true);// 타이틀바 없애기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, "name_6749714554420");
		panel.setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel() { // 전체판때기 생성& 이미지 넣기
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "backgroundI_yellow.jpg");
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

		panel.add(panel_1, "name_6911964470425");
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0, 0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 219, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 1024, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(1, 1, 1, 0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 1, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 263, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_2);
		panel_1.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0, 0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 0, SpringLayout.SOUTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, 170, SpringLayout.SOUTH, panel_3);
		panel_3.setLayout(new GridLayout(1, 4, 0, 0));

		JPanel typing = new JPanel(); // typing 생성
		typing.setLayout(new CardLayout(0, 0));

		JPanel panel_9 = new JPanel() { // panel_9& 이미지 넣기
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "pen2_262_nobgi.jpg");
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

		panel_9.setBackground(new Color(0, 0, 0));
		typing.add(panel_9, "name_13458552785714");
		panel_9.setLayout(new CardLayout(0, 0));

		JPanel panel_10 = new JPanel(); // panel_10
		panel_10.setBackground(new Color(0, 0, 0, 0.6f));
		typing.add(panel_10, "name_13472309223731");
		panel_10.setLayout(new CardLayout(0, 0));

		JLabel lbl_typing = new JLabel(" "); // lbl_typing
		lbl_typing.setForeground(Color.WHITE);
		panel_10.add(lbl_typing, "name_13493404554887");
		lbl_typing.setFont(new Font("서울남산 장체BL", Font.PLAIN, 40));
		lbl_typing.setHorizontalAlignment(SwingConstants.CENTER);

		typing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_typing.setText("입력" + "\n");
				((CardLayout) typing.getLayout()).previous(typing);

			}

			@Override
			public void mouseExited(MouseEvent e) { // 커서 나갔을 때
				lbl_typing.setText("");
				((CardLayout) typing.getLayout()).next(typing);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				Write w = new Write(id);
				w.main(id);

			}
		});

		panel_3.add(typing);
		typing.setLayout(new CardLayout(0, 0));

		JPanel calendar2 = new JPanel(); // calendar 생성
		calendar2.setLayout(new CardLayout(0, 0));

		JPanel panel_11 = new JPanel() { // panel_11& 이미지 넣기
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "calendar1_262_nobgi.jpg");
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

		panel_11.setBackground(new Color(0, 0, 0));
		calendar2.add(panel_11, "name_13458552785714");
		panel_11.setLayout(new CardLayout(0, 0));

		JPanel panel_12 = new JPanel(); // panel_12
		panel_12.setBackground(new Color(0, 0, 0, 0.6f));
		calendar2.add(panel_12, "name_13472309223731");
		panel_12.setLayout(new CardLayout(0, 0));

		JLabel lbl_calendar2 = new JLabel(" "); // lbl_budget
		lbl_calendar2.setForeground(Color.WHITE);
		panel_12.add(lbl_calendar2, "name_13493404554887");
		lbl_calendar2.setFont(new Font("서울남산 장체BL", Font.PLAIN, 40));
		lbl_calendar2.setHorizontalAlignment(SwingConstants.CENTER);

		calendar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_calendar2.setText("내역조회" + "\n");
				((CardLayout) calendar2.getLayout()).previous(calendar2);

			}

			@Override
			public void mouseExited(MouseEvent e) { // 커서 나갔을 때
				lbl_calendar2.setText("");
				((CardLayout) calendar2.getLayout()).next(calendar2);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				History ht = new History(id);
				ht.main(id);
			}
		});

		panel_3.add(calendar2);
		calendar2.setLayout(new CardLayout(0, 0));

		JPanel plan = new JPanel(); // plan 생성
		plan.setLayout(new CardLayout(0, 0));

		JPanel panel_13 = new JPanel() { // panel_13& 이미지 넣기
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "planning2_262_nobgi.jpg");
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

		panel_13.setBackground(new Color(0, 0, 0));
		plan.add(panel_13, "name_13458552785714");
		panel_13.setLayout(new CardLayout(0, 0));

		JPanel panel_14 = new JPanel(); // panel_14
		panel_14.setBackground(new Color(0, 0, 0, 0.6f));
		plan.add(panel_14, "name_13472309223731");
		panel_14.setLayout(new CardLayout(0, 0));

		JLabel lbl_plan = new JLabel(" "); // lbl_plan
		lbl_plan.setForeground(Color.WHITE);
		panel_14.add(lbl_plan, "name_13493404554887");
		lbl_plan.setFont(new Font("서울남산 장체BL", Font.PLAIN, 40));
		lbl_plan.setHorizontalAlignment(SwingConstants.CENTER);

		plan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_plan.setText("예산관리" + "\n");
				((CardLayout) plan.getLayout()).previous(plan);

			}

			@Override
			public void mouseExited(MouseEvent e) { // 커서 나갔을 때
				lbl_plan.setText("");
				((CardLayout) plan.getLayout()).next(plan);

			}

		});

		panel_3.add(plan);
		plan.setLayout(new CardLayout(0, 0));

		JPanel analysis = new JPanel(); // analysis 생성
		analysis.setLayout(new CardLayout(0, 0));

		JPanel panel_15 = new JPanel() { // panel_13& 이미지 넣기
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "analysis2_262_nobgi.jpg");
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

		panel_15.setBackground(new Color(0, 0, 0));
		analysis.add(panel_15, "name_13458552785714");
		panel_15.setLayout(new CardLayout(0, 0));

		JPanel panel_16 = new JPanel(); // panel_16
		panel_16.setBackground(new Color(0, 0, 0, 0.6f));
		analysis.add(panel_16, "name_13472309223731");
		panel_16.setLayout(new CardLayout(0, 0));

		JLabel lbl_analysis = new JLabel(" "); // lbl_analysis
		lbl_analysis.setForeground(Color.WHITE);
		panel_16.add(lbl_analysis, "name_13493404554887");
		lbl_analysis.setFont(new Font("서울남산 장체BL", Font.PLAIN, 40));
		lbl_analysis.setHorizontalAlignment(SwingConstants.CENTER);

		analysis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_analysis.setText("통계" + "\n");
				((CardLayout) analysis.getLayout()).previous(analysis);

			}

			@Override
			public void mouseExited(MouseEvent e) { // 커서 나갔을 때
				lbl_analysis.setText("");
				((CardLayout) analysis.getLayout()).next(analysis);

			}

		});

		panel_3.add(analysis);
		analysis.setLayout(new CardLayout(0, 0));

		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0, 0));

		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_5, 0, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_5, 219, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_5, 1024, SpringLayout.WEST, panel_2);
		panel_2.add(panel_5);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);

		JButton btn_logout = new JButton("Log Out") {
			public void paintComponent(Graphics g) {

				try {
					String path = a.class.getResource("").getPath();
					File fileInSamePackage = new File(path + "btn_logout.png");
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
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainLogin ms = new MainLogin();
				ms.main(null);
				
				
			}
		});
		sl_panel_5.putConstraint(SpringLayout.NORTH, btn_logout, 10, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, btn_logout, -201, SpringLayout.EAST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, btn_logout, 53, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, btn_logout, 0, SpringLayout.EAST, panel_5);
		btn_logout.setFont(new Font("Masque", Font.PLAIN, 20));
		btn_logout.setBorderPainted(false);
		btn_logout.setContentAreaFilled(false);
		btn_logout.setOpaque(false);
		btn_logout.setFocusPainted(false);
		panel_5.add(btn_logout);
		panel_1.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
	}
}
