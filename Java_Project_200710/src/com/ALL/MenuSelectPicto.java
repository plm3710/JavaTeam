package com.ALL;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.img.a;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.SpringLayout;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuSelectPicto extends JFrame {

	BufferedImage icon;

	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSelectPicto frame = new MenuSelectPicto(id);
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
	public MenuSelectPicto(String id) {
    getContentPane().setBackground(Color.DARK_GRAY);
    getContentPane().setForeground(Color.WHITE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1050, 700);
    getContentPane().setLayout(new CardLayout(0, 0));

    JPanel panel = new JPanel();
    panel.setBackground(Color.BLACK);
    panel.setForeground(Color.WHITE);
    getContentPane().add(panel, "name_6747847414636");
    SpringLayout sl_panel = new SpringLayout();
    panel.setLayout(sl_panel);

    JPanel typing = new JPanel(); // typing생성-----------------------------------
    typing.setLayout(new CardLayout(0, 0));

    JPanel panel_1 = new JPanel() { // panel_1 생성& 이미지넣기
       public void paintComponent(Graphics g) {

          try {
             String path = a.class.getResource("").getPath();
             File fileInSamePackage = new File(path + "pen2.png");
             BufferedImage icon = ImageIO.read(fileInSamePackage);

             Dimension d = getSize();// 전체화면
             g.drawImage(icon, 0, 0, d.width, d.height, null);
             setOpaque(false);
             super.paintComponent(g);
          } catch (IOException e) {
             e.printStackTrace();
          }
       }
    };
    panel_1.setBackground(Color.BLACK);
    typing.add(panel_1, "name_41897559476950");
    panel_1.setLayout(new CardLayout(0, 0));

    JPanel panel_2 = new JPanel(); // panel_2
    panel_2.setBackground(new Color(0, 0, 0, 0.6f));
    typing.add(panel_2, "name_44585398618422");
    panel_2.setLayout(new CardLayout(0, 0));

    JLabel lbl_typing = new JLabel(""); // lbl_typing
    lbl_typing.setForeground(Color.WHITE);
    panel_2.add(lbl_typing, "name_7862052529663");
    lbl_typing.setFont(new Font("서울남산 장체BL", Font.PLAIN, 40));
    lbl_typing.setHorizontalAlignment(SwingConstants.CENTER);

    typing.addMouseListener(new MouseAdapter() { // typing 창 마우스 엔터드/엑시티드
                                        // 이벤트 시작
       @Override
       public void mouseEntered(MouseEvent e) { // 커서 들어왔을 때
          lbl_typing.setText("입력" + "\n");
          ((CardLayout) typing.getLayout()).previous(typing);
       }

       @Override
       public void mouseExited(MouseEvent e) { // 커서 나갔을 때
          lbl_typing.setText("");
          ((CardLayout) typing.getLayout()).next(typing);

       }
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		JOptionPane.showMessageDialog(null, "미구현", "미구현", JOptionPane.WARNING_MESSAGE);
    		
    	}
    });
    sl_panel.putConstraint(SpringLayout.SOUTH, typing, 350, SpringLayout.NORTH, panel);
    sl_panel.putConstraint(SpringLayout.EAST, typing, -684, SpringLayout.EAST, panel);
    panel.add(typing); // typing 끝.

    ///// --------------------------------------------------

    JPanel budget = new JPanel(); // budget 생성.
    budget.setLayout(new CardLayout(0, 0));

    JPanel panel_3 = new JPanel() { // panel_3 생성& 이미지넣기
       public void paintComponent(Graphics g) {

          try {
             String path = a.class.getResource("").getPath();
             File fileInSamePackage = new File(path + "planning1.png");
             BufferedImage icon = ImageIO.read(fileInSamePackage);
             
             Dimension d = getSize();// 전체화면
             g.drawImage(icon, 0, 0, d.width, d.height, null);
             setOpaque(false);
             super.paintComponent(g);
          } catch (IOException e) {
             e.printStackTrace();
          }
       }
    };
    panel_3.setBackground(Color.BLACK);
    budget.add(panel_3, "name_41897559476950");
    panel_3.setLayout(new CardLayout(0, 0));

    JPanel panel_4 = new JPanel(); // panel_4
    panel_4.setBackground(new Color(0, 0, 0, 0.6f));
    budget.add(panel_4, "name_44585398618422");
    panel_4.setLayout(new CardLayout(0, 0));

    JLabel lbl_budget = new JLabel(""); // lbl_budget
    lbl_budget.setForeground(Color.WHITE);
    panel_4.add(lbl_budget, "name_7862052529663");
    lbl_budget.setFont(new Font("서울남산 장체BL", Font.PLAIN, 40));
    lbl_budget.setHorizontalAlignment(SwingConstants.CENTER);

    budget.addMouseListener(new MouseAdapter() {// budget 마우스 엔터드, 엑시티드 이벤트
                                     // 시작
       @Override
       public void mouseEntered(MouseEvent e) {
          lbl_budget.setText("예산계획" + "\n");
          ((CardLayout) budget.getLayout()).previous(budget);
       }

       @Override
       public void mouseExited(MouseEvent e) {

          lbl_budget.setText("");
          ((CardLayout) budget.getLayout()).next(budget);
       }
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		JOptionPane.showMessageDialog(null, "미구현", "미구현", JOptionPane.WARNING_MESSAGE);
    		
    	}
    });
    sl_panel.putConstraint(SpringLayout.NORTH, budget, 2, SpringLayout.SOUTH, typing);
    sl_panel.putConstraint(SpringLayout.SOUTH, budget, 0, SpringLayout.SOUTH, panel);
    sl_panel.putConstraint(SpringLayout.WEST, typing, 0, SpringLayout.WEST, budget);
    sl_panel.putConstraint(SpringLayout.WEST, budget, 0, SpringLayout.WEST, panel);
    panel.add(budget);
    budget.setLayout(new CardLayout(0, 0));

    // ----------------------------------------------------------

    JPanel calendar = new JPanel(); // calendar 생성
    calendar.setLayout(new CardLayout(0, 0));

    JPanel panel_5 = new JPanel() { // panel_5 생성& 이미지넣기
       public void paintComponent(Graphics g) {

          try {
             String path = a.class.getResource("").getPath();
             File fileInSamePackage = new File(path + "calendar1.png");
             BufferedImage icon = ImageIO.read(fileInSamePackage);

             Dimension d = getSize();// 전체화면
             g.drawImage(icon, 0, 0, d.width, d.height, null);
             setOpaque(false);
             super.paintComponent(g);
          } catch (IOException e) {
             e.printStackTrace();
          }
       }
    };
    panel_5.setBackground(Color.BLACK);
    calendar.add(panel_5, "name_41897559476950");
    panel_5.setLayout(new CardLayout(0, 0));

    JPanel panel_6 = new JPanel(); // panel_6
    panel_6.setBackground(new Color(0, 0, 0, 0.6f));
    calendar.add(panel_6, "name_44585398618422");
    panel_6.setLayout(new CardLayout(0, 0));

    JLabel lbl_calendar = new JLabel(""); // lbl_calendar
    lbl_calendar.setForeground(Color.WHITE);
    panel_6.add(lbl_calendar, "name_7862052529663");
    lbl_calendar.setFont(new Font("서울남산 장체BL", Font.PLAIN, 40));
    lbl_calendar.setHorizontalAlignment(SwingConstants.CENTER);

    calendar.addMouseListener(new MouseAdapter() {// budget 마우스 엔터드, 엑시티드
                                        // 이벤트
                                        // 시작
       @Override
       public void mouseEntered(MouseEvent e) {
          lbl_calendar.setText("내역조회" + "\n");
          ((CardLayout) calendar.getLayout()).previous(calendar);

       }

       @Override
       public void mouseExited(MouseEvent e) {

          lbl_calendar.setText("");
          ((CardLayout) calendar.getLayout()).next(calendar);

       }
    	@Override
    	public void mouseClicked(MouseEvent arg0) {
    		History h = new History(id);
    		h.main(id);
    	}
    });

    sl_panel.putConstraint(SpringLayout.NORTH, typing, 0, SpringLayout.NORTH, calendar);

    JLabel lbl_typing_text = new JLabel("\uC785\uB825");
    lbl_typing_text.setHorizontalAlignment(SwingConstants.TRAILING);
    lbl_typing_text.setVerticalAlignment(SwingConstants.BOTTOM);
    lbl_typing_text.setForeground(new Color(255, 255, 255));
    lbl_typing_text.setFont(new Font("배달의민족 주아", Font.PLAIN, 58));

    JPanel analysis = new JPanel();// analysis 생성
                            // ----------------------------------------------------
    analysis.setLayout(new CardLayout(0, 0));

    JPanel panel_7 = new JPanel() { // panel_7 생성& 이미지넣기
       public void paintComponent(Graphics g) {

          try {
             String path = a.class.getResource("").getPath();
             File fileInSamePackage = new File(path + "analysis2.png");
             BufferedImage icon = ImageIO.read(fileInSamePackage);

             Dimension d = getSize();// 전체화면
             g.drawImage(icon, 0, 0, d.width, d.height, null);
             setOpaque(false);
             super.paintComponent(g);
          } catch (IOException e) {
             e.printStackTrace();
          }
       }
    };
    panel_7.setBackground(Color.BLACK);
    analysis.add(panel_7, "name_41897559476950");
    panel_7.setLayout(new CardLayout(0, 0));

    JPanel panel_8 = new JPanel(); // panel_8
    panel_8.setBackground(new Color(0, 0, 0, 0.6f));
    analysis.add(panel_8, "name_44585398618422");
    panel_8.setLayout(new CardLayout(0, 0));

    JLabel lbl_analysis = new JLabel(""); // lbl_analysis
    lbl_analysis.setForeground(Color.WHITE);
    panel_8.add(lbl_analysis, "name_7862052529663");
    lbl_analysis.setFont(new Font("서울남산 장체BL", Font.PLAIN, 40));
    lbl_analysis.setHorizontalAlignment(SwingConstants.CENTER);

    analysis.addMouseListener(new MouseAdapter() {// budget 마우스 엔터드, 엑시티드
                                        // 이벤트
                                        // 시작
       @Override
       public void mouseEntered(MouseEvent e) {
          lbl_analysis.setText("분석" + "\n");
          ((CardLayout) analysis.getLayout()).previous(analysis);

       }

       @Override
       public void mouseExited(MouseEvent e) {

          lbl_analysis.setText("");
          ((CardLayout) analysis.getLayout()).next(analysis);

       }
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		JOptionPane.showMessageDialog(null, "미구현", "미구현", JOptionPane.WARNING_MESSAGE);
    		
    	}
    });

    sl_panel.putConstraint(SpringLayout.EAST, budget, -2, SpringLayout.WEST, analysis);
    sl_panel.putConstraint(SpringLayout.NORTH, analysis, 2, SpringLayout.SOUTH, calendar);
    sl_panel.putConstraint(SpringLayout.WEST, analysis, 702, SpringLayout.WEST, panel);
    sl_panel.putConstraint(SpringLayout.SOUTH, analysis, 0, SpringLayout.SOUTH, panel);
    sl_panel.putConstraint(SpringLayout.EAST, analysis, 0, SpringLayout.EAST, panel);

    panel.add(analysis);
    analysis.setLayout(new CardLayout(0, 0));
    sl_panel.putConstraint(SpringLayout.WEST, calendar, 351, SpringLayout.WEST, panel);
    sl_panel.putConstraint(SpringLayout.NORTH, calendar, 0, SpringLayout.NORTH, panel);
    sl_panel.putConstraint(SpringLayout.SOUTH, calendar, -312, SpringLayout.SOUTH, panel);
    sl_panel.putConstraint(SpringLayout.EAST, calendar, 0, SpringLayout.EAST, panel);
    panel.add(calendar);
    calendar.setLayout(new CardLayout(0, 0));
    setResizable(false);
 }
}