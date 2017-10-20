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
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import com.ALL.MenuSelectPicto;
import com.DAO.MemberDAO;
import com.VO.MemberVO;
import com.img.a;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class MainLogin extends JFrame {
	BufferedImage icon;
	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<MemberVO> list = null;
	private MemberDAO mdao = null;
	private JPasswordField passwordField;

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
		setUndecorated(true);//타이틀바 없애기
		list = new ArrayList<MemberVO>();
		mdao = new MemberDAO();
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
		textField.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		panel_6.add(textField, "name_32076350647672");
		textField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		passwordField = new JPasswordField();
		panel_7.add(passwordField, "name_35360905343487");
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
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp su = new SignUp();
				su.main(null);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("서울남산 장체B", Font.PLAIN, 30));
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
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//로그인
				//textField
				list = mdao.select();//모든 회원정보를 담아온다.
				boolean boo = true;
				String pw = new String(passwordField.getPassword());
				for (int i = 0; i < list.size() ; i++) {
					if(list.get(i).getId().equals(textField.getText()) && list.get(i).getPw().equals(pw)) {
						MenuSelectPicto ms = new MenuSelectPicto(textField.getText());
						ms.main(textField.getText());
						//History h = new History(textField.getText());
						//h.main(textField.getText());
						boo = false;
						dispose();
					}
				}
				
				if(boo) {
					JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 일치하지 않습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		lblNewLabel_3.setFont(new Font("Masque", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_3, "name_33078453118316");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0,0,0,0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 996, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, 35, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel);
		panel.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Masque", Font.BOLD, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_4, "name_1289342470694");
		
		setResizable(false);
	}
}
