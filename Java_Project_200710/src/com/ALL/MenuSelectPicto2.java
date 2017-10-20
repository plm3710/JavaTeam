package com.ALL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.img.a;

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

public class MenuSelectPicto2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSelectPicto2 frame = new MenuSelectPicto2();
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
	public MenuSelectPicto2() {
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
			
			
		});

		panel_3.add(typing);
		typing.setLayout(new CardLayout(0, 0));

		

		JPanel budget = new JPanel() { // panel_6& 이미지 넣기
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
		panel_3.add(budget);
		budget.setLayout(new CardLayout(0, 0));

		JPanel analysis = new JPanel() { // panel_7& 이미지 넣기
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
		panel_3.add(analysis);
		analysis.setLayout(new CardLayout(0, 0));

		JPanel calendar = new JPanel() { // panel_8& 이미지 넣기
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
		panel_3.add(calendar);
		calendar.setLayout(new CardLayout(0, 0));

		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		panel_1.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
	}
}
