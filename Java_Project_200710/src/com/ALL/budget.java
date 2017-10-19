package com.ALL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JButton;
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

public class budget {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budget window = new budget();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public budget() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, -357, SpringLayout.EAST, panel);
		panel_4.setToolTipText("pig face");
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, -10, SpringLayout.SOUTH, panel);
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_5, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_5, 113, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_5, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_5, -10, SpringLayout.EAST, panel);
		panel_5.setToolTipText("pig text");
		panel.add(panel_5);
		
		JPanel prerious = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, prerious);
		springLayout.putConstraint(SpringLayout.NORTH, prerious, 127, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, prerious, -496, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, prerious, 61, SpringLayout.WEST, frame.getContentPane());
		prerious.setToolTipText("<-");
		springLayout.putConstraint(SpringLayout.WEST, prerious, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(prerious);
		
		JPanel date = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, date, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, date, 6, SpringLayout.EAST, prerious);
		prerious.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton = new JButton("\u25C0");
		prerious.add(btnNewButton, "name_43209016542499");
		date.setToolTipText("ex 2017.01");
		frame.getContentPane().add(date);
		date.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, prerious);
		springLayout.putConstraint(SpringLayout.SOUTH, date, -6, SpringLayout.NORTH, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel budgetCategory1 = new JLabel("budgetcategory");
		budgetCategory1.setToolTipText("budgetCategory1");
		budgetCategory1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_8.add(budgetCategory1);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_9.add(lblNewLabel_2);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		panel_10.add(lblNewLabel_3);
		
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		panel_11.add(lblNewLabel_6);
		
		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		panel_12.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		panel_12.add(lblNewLabel_8);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_3.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel budgetCategory1Vo = new JLabel("New label");
		budgetCategory1Vo.setToolTipText("budgetCategory1Vo");
		budgetCategory1Vo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_13.add(budgetCategory1Vo);
		
		JPanel panel_15 = new JPanel();
		panel_3.add(panel_15);
		panel_15.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_15.add(lblNewLabel_4);
		
		JPanel panel_16 = new JPanel();
		panel_3.add(panel_16);
		panel_16.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_16.add(lblNewLabel_5);
		
		JPanel panel_14 = new JPanel();
		panel_3.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_14.add(lblNewLabel_7);
		
		JPanel panel_18 = new JPanel();
		panel_3.add(panel_18);
		panel_18.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_18.add(lblNewLabel_9);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_6.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("budgetcategory\r\n");
		lblNewLabel_10.setToolTipText("budgetCategory2");
		panel_19.add(lblNewLabel_10);
		
		JPanel panel_20 = new JPanel();
		panel_6.add(panel_20);
		panel_20.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		panel_20.add(lblNewLabel_12);
		
		JPanel panel_21 = new JPanel();
		panel_6.add(panel_21);
		panel_21.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		panel_21.add(lblNewLabel_14);
		
		JPanel panel_22 = new JPanel();
		panel_6.add(panel_22);
		panel_22.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		panel_22.add(lblNewLabel_15);
		
		JPanel panel_23 = new JPanel();
		panel_6.add(panel_23);
		panel_23.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		panel_23.add(lblNewLabel_16);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_24 = new JPanel();
		panel_7.add(panel_24);
		panel_24.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setToolTipText("budgetCategory2VO");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_24.add(lblNewLabel_11);
		
		JPanel panel_25 = new JPanel();
		panel_7.add(panel_25);
		panel_25.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_25.add(lblNewLabel_13);
		
		JPanel panel_26 = new JPanel();
		panel_7.add(panel_26);
		panel_26.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_26.add(lblNewLabel_17);
		
		JPanel panel_27 = new JPanel();
		panel_7.add(panel_27);
		panel_27.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_27.add(lblNewLabel_18);
		
		JPanel panel_28 = new JPanel();
		panel_7.add(panel_28);
		panel_28.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_28.add(lblNewLabel_19);
		
		JButton button = new JButton("\u00D7");
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, prerious);
		springLayout.putConstraint(SpringLayout.NORTH, button, 610, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, frame.getContentPane());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("±¼¸²", Font.BOLD, 21));
		button.setBackground(SystemColor.menu);
		frame.getContentPane().add(button);
		
		JButton btnNewButton_1 = new JButton("\u25B6");
		springLayout.putConstraint(SpringLayout.EAST, date, -6, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, prerious);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, panel);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("+");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 6, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 45, SpringLayout.WEST, btnNewButton_1);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("±¼¸²", Font.BOLD, 21));
	}
}
