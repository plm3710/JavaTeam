package com.member;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.DAO.MemberDAO;
import com.VO.MemberVO;
import com.img.a;

import java.awt.CardLayout;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class SignUp extends JFrame {

   private JPanel contentPane;
   BufferedImage icon;
   private JTextField txtId;
   private JTextField txtNickname;
   private MemberDAO dao;
   private JPasswordField passwordField;
   private JPasswordField passwordField_1;
   private MemberVO mvo;
   private ArrayList<MemberVO> list;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               SignUp frame = new SignUp();
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
	public SignUp() {
		setUndecorated(true);//타이틀바 없애기
		dao = new MemberDAO();
		mvo = new MemberVO();
		list = new ArrayList<MemberVO>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();//a클래스 위치 가지고오기
					File fileInSamePackage = new File(path + "SignUpBackground.png");
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
		contentPane.add(panel, "name_1166981971428");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255,192,0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 249, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 651, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 775, SpringLayout.WEST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255,0,0,0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, 196, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 516, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255,0,0,0));
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 364, SpringLayout.SOUTH, panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.PLAIN, 50));
		panel_2.add(lblNewLabel, "name_9376056257557");
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, 516, SpringLayout.WEST, panel_1);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255,0,0,0));
		panel_3.add(panel_5);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("서울남산 장체BL", Font.PLAIN, 25));
		sl_panel_5.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 61, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, lblNewLabel_1, 95, SpringLayout.WEST, panel_5);
		panel_5.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtId.setOpaque(false);
		txtId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txtId.getText().equals("email")) {
					txtId.setText("");
				}
			}
		});
		txtId.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		txtId.setText("email");
		sl_panel_5.putConstraint(SpringLayout.NORTH, txtId, 10, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, txtId, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, txtId, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_5.putConstraint(SpringLayout.EAST, txtId, 286, SpringLayout.EAST, lblNewLabel_1);
		panel_5.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC911\uBCF5\uD655\uC778");
		lblNewLabel_2.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//아이디 중복확인
				list = dao.select();
				boolean boo = true;
				for (int i = 0; i < list.size() ; i++) {
					if(list.get(i).getId().equals(txtId.getText())) {
						JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.", "아이디 중복", JOptionPane.WARNING_MESSAGE);
						boo = false;
					}
				}
				
				if(boo) {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다.");
				}
			}
		});
		sl_panel_5.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_5.putConstraint(SpringLayout.WEST, lblNewLabel_2, 6, SpringLayout.EAST, txtId);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_5.putConstraint(SpringLayout.EAST, lblNewLabel_2, 103, SpringLayout.EAST, txtId);
		panel_5.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255,192,0));
		panel_3.add(panel_6);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setForeground(Color.BLACK);
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("서울남산 장체BL", Font.PLAIN, 25));
		sl_panel_6.putConstraint(SpringLayout.NORTH, lblPw, 10, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, lblPw, 10, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, lblPw, -10, SpringLayout.SOUTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, lblPw, 95, SpringLayout.WEST, panel_6);
		panel_6.add(lblPw);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField.setOpaque(false);
		sl_panel_6.putConstraint(SpringLayout.NORTH, passwordField, 10, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, passwordField, 6, SpringLayout.EAST, lblPw);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, passwordField, 61, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, passwordField, 286, SpringLayout.EAST, lblPw);
		panel_6.add(passwordField);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255,192,0));
		panel_3.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordField_1.setOpaque(false);
		sl_panel_7.putConstraint(SpringLayout.NORTH, passwordField_1, 10, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, passwordField_1, 101, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, passwordField_1, 61, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, passwordField_1, 381, SpringLayout.WEST, panel_7);
		panel_7.add(passwordField_1);
		
		JLabel lblPw2 = new JLabel("PW\uD655\uC778");
		sl_panel_7.putConstraint(SpringLayout.NORTH, lblPw2, 5, SpringLayout.NORTH, passwordField_1);
		sl_panel_7.putConstraint(SpringLayout.WEST, lblPw2, 10, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, lblPw2, 0, SpringLayout.SOUTH, passwordField_1);
		sl_panel_7.putConstraint(SpringLayout.EAST, lblPw2, -6, SpringLayout.WEST, passwordField_1);
		lblPw2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw2.setForeground(Color.BLACK);
		lblPw2.setFont(new Font("서울남산 장체BL", Font.PLAIN, 25));
		panel_7.add(lblPw2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255,192,0));
		panel_3.add(panel_8);
		SpringLayout sl_panel_8 = new SpringLayout();
		panel_8.setLayout(sl_panel_8);
		
		JLabel label_1 = new JLabel("\uB2C9\uB124\uC784");
		label_1.setForeground(Color.BLACK);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("서울남산 장체BL", Font.PLAIN, 25));
		sl_panel_8.putConstraint(SpringLayout.NORTH, label_1, 10, SpringLayout.NORTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.WEST, label_1, 10, SpringLayout.WEST, panel_8);
		sl_panel_8.putConstraint(SpringLayout.SOUTH, label_1, -10, SpringLayout.SOUTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.EAST, label_1, 95, SpringLayout.WEST, panel_8);
		panel_8.add(label_1);
		
		txtNickname = new JTextField();
		txtNickname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNickname.setOpaque(false);
		txtNickname.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		sl_panel_8.putConstraint(SpringLayout.NORTH, txtNickname, 0, SpringLayout.NORTH, label_1);
		sl_panel_8.putConstraint(SpringLayout.WEST, txtNickname, 6, SpringLayout.EAST, label_1);
		sl_panel_8.putConstraint(SpringLayout.SOUTH, txtNickname, 0, SpringLayout.SOUTH, label_1);
		sl_panel_8.putConstraint(SpringLayout.EAST, txtNickname, 286, SpringLayout.EAST, label_1);
		panel_8.add(txtNickname);
		txtNickname.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255,0,0,0));
		panel_3.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("\uCDE8\uC18C");
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_3, 92, SpringLayout.WEST, panel_4);
		lblNewLabel_3.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//취소누르면 메인문 호출과 동시에 끄기
				MainLogin mm = new MainLogin();
				mm.main(null);
				dispose();
			}
		});
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -10, SpringLayout.SOUTH, panel_4);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uD655\uC778");
		sl_panel_4.putConstraint(SpringLayout.WEST, lblNewLabel_4, 243, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, lblNewLabel_4, -133, SpringLayout.EAST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, lblNewLabel_3, -6, SpringLayout.WEST, lblNewLabel_4);
		sl_panel_4.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 10, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -10, SpringLayout.SOUTH, panel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//passwordField
				//passwordField_1
				//비밀번호확인 후에 회원가입 작업
				String pw1 = new String(passwordField.getPassword());
				String pw2 = new String(passwordField_1.getPassword());

				if(pw1.equals(pw2)) {
					String id = txtId.getText();
					String pw = pw1;
					String nickname = txtNickname.getText();
					mvo = new MemberVO(id, pw, nickname);
					int cnt = dao.insert(mvo);
					if(cnt>0) {
						SignUpComplete scome = new SignUpComplete();
						scome.main(null);
						dispose();
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "비밀번호 불일치", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel_4.add(lblNewLabel_4);
		
		setResizable(false);
	}
}
