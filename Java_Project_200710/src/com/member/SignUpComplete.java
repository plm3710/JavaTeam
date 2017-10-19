package com.member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ALL.MenuSelect;
import com.img.a;

import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SignUpComplete extends JFrame {

	private JPanel contentPane;
	private BufferedImage icon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpComplete frame = new SignUpComplete();
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
	public SignUpComplete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();//a클래스 위치 가지고오기
					File fileInSamePackage = new File(path + "SignUpCompletBackground.jpg");
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
		contentPane.add(panel, "name_34205202785462");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(120,120,120));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 139, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 340, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 1024, SpringLayout.WEST, panel);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785\uC774");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("서울남산 장체B", Font.PLAIN, 50));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("서울남산 장체B", Font.PLAIN, 50));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,0,0,0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 89, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 370, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -60, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 655, SpringLayout.WEST, panel);
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainLogin ml = new MainLogin();
				ml.main(null);
				dispose();
			}
		});
		panel_2.add(lblNewLabel_2, "name_35919784710385");
	}
}
