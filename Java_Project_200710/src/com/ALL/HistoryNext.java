package com.ALL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.DAO.MoneyDAO;
import com.VO.IncomeVO;
import com.VO.OutcomeVO;

import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HistoryNext extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public static void main(String id,String dateTemp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryNext frame = new HistoryNext(id, dateTemp);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// public HistoryNext() {

	// }
	/**
	 * Create the frame.
	 */
	public HistoryNext(String id, String dateTemp) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, "name_27612527429372");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 57, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 764, SpringLayout.WEST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, panel_1);
		panel_1.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		JLabel lblDate = new JLabel("");
		lblDate.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblDate, "name_28325744992309");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, 282, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, -431, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -10, SpringLayout.SOUTH, panel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, -51, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1, -10, SpringLayout.EAST, panel_1);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);
		panel.add(scrollPane);

		Vector columnNames = new Vector<>();
		columnNames.add("카테고리");
		columnNames.add("수입");
		columnNames.add("지출");
		columnNames.add("내용");

		String[] dateYMS = dateTemp.split("-");
		
		Vector data = new Vector<>();

		MoneyDAO dao = new MoneyDAO();
		ArrayList<IncomeVO> ilist = dao.incomeNextSelect(id,dateYMS[0],dateYMS[1],dateYMS[2]);//수입의 정보를 가지고온다.
		ArrayList<OutcomeVO> olist = dao.outcomeNextSelect(id,dateYMS[0],dateYMS[1],dateYMS[2]);//지출의 정보를 가지고온다.
		lblDate.setText(dateTemp);
		
		for (int i = 0; i < ilist.size(); i++) {//수입 행 넣기

			IncomeVO m = ilist.get(i);
			
			Vector row1 = new Vector<>();
			row1.add(m.getCategory());
			row1.add(m.getMoney());
			row1.add(0);
			row1.add(m.getMemo());
			data.add(row1);
		}
		for (int i = 0; i < olist.size(); i++) {//지출 행 넣기

			OutcomeVO m = olist.get(i);
			
			Vector row1 = new Vector<>();
			row1.add(m.getCategory());
			row1.add(0);
			row1.add(m.getMoney());
			row1.add(m.getMemo());
			data.add(row1);
		}

	    table = new JTable(data,columnNames);
	    table.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
	    scrollPane.setViewportView(table);
	    setResizable(false);
	}
}
