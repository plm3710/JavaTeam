package com.ALL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;

public class budgetInput {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budgetInput window = new budgetInput();
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
	public budgetInput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 67, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 374, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 385, SpringLayout.SOUTH, panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("\uC608\uC0B0 \uCD94\uAC00");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 47, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 354, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 374, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, -50, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 354, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_5, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_5, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -6, SpringLayout.NORTH, panel_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, panel_2);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		panel_2.add(btnNewButton);
		
		JButton button = new JButton("\uD655\uC778");
		panel_2.add(button);
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);
		
		JLabel lblNewLabel_3 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		sl_panel_7.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 22, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, lblNewLabel_3, 344, SpringLayout.WEST, panel_7);
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(4, 1, 0, 0));
		
		Choice choice = new Choice();
		panel_6.add(choice);
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		SpringLayout sl_panel_8 = new SpringLayout();
		panel_8.setLayout(sl_panel_8);
		
		JLabel lblNewLabel_4 = new JLabel("\uC608\uC0B0 \uC774\uB984");
		sl_panel_8.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 23, SpringLayout.NORTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, panel_8);
		sl_panel_8.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.EAST, lblNewLabel_4, 344, SpringLayout.WEST, panel_8);
		panel_8.add(lblNewLabel_4);
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField_1 = new JTextField();
		panel_9.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		SpringLayout sl_panel_10 = new SpringLayout();
		panel_10.setLayout(sl_panel_10);
		
		JLabel lblNewLabel_5 = new JLabel("\uAE08\uC561");
		sl_panel_10.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 27, SpringLayout.NORTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, panel_10);
		sl_panel_10.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -10, SpringLayout.SOUTH, panel_10);
		sl_panel_10.putConstraint(SpringLayout.EAST, lblNewLabel_5, 344, SpringLayout.WEST, panel_10);
		panel_10.add(lblNewLabel_5);
		
		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField_2 = new JTextField();
		panel_11.add(textField_2);
		textField_2.setColumns(10);
	}
}
