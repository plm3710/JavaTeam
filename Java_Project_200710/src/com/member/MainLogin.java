package com.member;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ALL.History;
import com.ALL.MenuSelect;
import com.DAO.MemberDAO;
import com.VO.MemberVO;
import com.img.a;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

public class MainLogin extends JFrame {
	private JPanel contentPane;
	BufferedImage icon;
	private JTextField textField;
	private MemberDAO dao=null;
	private ArrayList<MemberVO> list = null;
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
	public MainLogin(){
		dao = new MemberDAO();
		list = new ArrayList<MemberVO>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();//a클래스 위치 가지고오기
					File fileInSamePackage = new File(path + "background.png");
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
		contentPane.add(panel, "name_39893284044696");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel(); 
		panel_1.setBackground(new Color(64,64,64,0));
		
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, -432, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -150, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 1014, SpringLayout.WEST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 0, 0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 128, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 1014, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uBCD1\uC6B0\uC640 \uC544\uC774\uB4E4");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, "name_43897985459147");
		
		JPanel panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel_2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 144, SpringLayout.SOUTH, panel_2);
		panel_3.setBackground(new Color(255, 0, 0, 0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, 1004, SpringLayout.WEST, panel_1);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBackground(new Color(255, 0, 0, 0));
		panel_3.add(panel_5);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		sl_panel_5.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_1, 353, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 36, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, lblNewLabel_1, -576, SpringLayout.EAST, panel_5);
		lblNewLabel_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_1);
		
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.YELLOW));
		textField.setOpaque(false);
		textField.setBorder(null);
		
		sl_panel_5.putConstraint(SpringLayout.NORTH, textField, 5, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_5.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, textField, 41, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, textField, 209, SpringLayout.EAST, lblNewLabel_1);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 0, 0, 0));
		panel_3.add(panel_6);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setForeground(Color.WHITE);
		sl_panel_6.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, lblNewLabel_2, 359, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 36, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, lblNewLabel_2, -578, SpringLayout.EAST, panel_6);
		lblNewLabel_2.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		sl_panel_6.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel_6.putConstraint(SpringLayout.WEST, passwordField, 6, SpringLayout.EAST, lblNewLabel_2);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, passwordField, 0, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_6.putConstraint(SpringLayout.EAST, passwordField, 205, SpringLayout.EAST, lblNewLabel_2);
		panel_6.add(passwordField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 0, 0, 0));
		panel_3.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//로그인
				//textField
				list = dao.select();//모든 회원정보를 담아온다.
				boolean boo = true;
				String pw = new String(passwordField.getPassword());
				for (int i = 0; i < list.size() ; i++) {
					if(list.get(i).getId().equals(textField.getText()) && list.get(i).getPw().equals(pw)) {
						MenuSelect ms = new MenuSelect(textField.getText());
						ms.main(textField.getText());
						//History h = new History(textField.getText());
						//h.main(textField.getText());
						boo = false;
					}
				}
				
				if(boo) {
					JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 일치하지 않습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		sl_panel_4.putConstraint(SpringLayout.NORTH, btnLogin, 10, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, btnLogin, 367, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, btnLogin, -10, SpringLayout.SOUTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, btnLogin, -504, SpringLayout.EAST, panel_4);
		btnLogin.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		panel_4.add(btnLogin);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//회원가입 클릭시 회원가입 창 뜨게
				SignUp su = new SignUp();
				su.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		sl_panel_4.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnLogin);
		sl_panel_4.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, btnLogin);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, btnLogin);
		sl_panel_4.putConstraint(SpringLayout.EAST, btnNewButton, 129, SpringLayout.EAST, btnLogin);
		panel_4.add(btnNewButton);
	}
	private Icon changeIcon(String imgPath) {
		//ImageIcon객체를 생성
		ImageIcon originIcon = new ImageIcon(imgPath);  
		//ImageIcon에서 Image를 추출
		Image originImg = originIcon.getImage(); 
		//추출된 Image의 크기를 조절하여 새로운 Image객체 생성
		Image changedImg= originImg.getScaledInstance(320, 300, Image.SCALE_SMOOTH );
		ImageIcon iicon = new ImageIcon(changedImg);
		return iicon;
	}
}
