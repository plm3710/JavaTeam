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
import javax.swing.JOptionPane;
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
import java.awt.GridLayout;

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
	public static void main(String id, String dateTemp) {
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
		setUndecorated(true);//타이틀바 없애기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		this.setLocation(240,265);
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
		lblNewLabel_1.setFont(new Font("서울남산 장체BL", Font.PLAIN, 25));
		panel_1.add(lblNewLabel_1);
		panel.add(scrollPane);

		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JPanel panel_4 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, 45, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, 637, SpringLayout.WEST, panel_2);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 4, 0, 0));

		JLabel lblNewLabel = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\uC218 \uC785");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC9C0 \uCD9C");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uBA54 \uBAA8");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_4);
		
		JPanel p_remove = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, p_remove, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, p_remove, 6, SpringLayout.EAST, panel_4);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, p_remove, 45, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, p_remove, -10, SpringLayout.EAST, panel_2);
		panel_2.add(p_remove);
		p_remove.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		p_remove.add(lblNewLabel_5, "name_5455100935527");

		String[] dateYMS = dateTemp.split("-");

		MoneyDAO dao = new MoneyDAO();
		ArrayList<IncomeVO> ilist = dao.incomeNextSelect(id, dateYMS[0], dateYMS[1], dateYMS[2]);// 수입의 정보를 가지고온다.
		ArrayList<OutcomeVO> olist = dao.outcomeNextSelect(id, dateYMS[0], dateYMS[1], dateYMS[2]);// 지출의 정보를 가지고온다.
		lblDate.setText(dateTemp);//상단 날짜 표시

		int temp = 0;
		for (int i = 0; i < ilist.size(); i++) {// 수입 행 넣기

			IncomeVO m = ilist.get(i);
			String ca = m.getCategory();//카테고리
			String in = "+"+m.getMoney()+"";//수입 돈
			String out = "-0";
			String me = m.getMemo();//메모
			
			JPanel panel_5 = new JPanel();
			sl_panel_2.putConstraint(SpringLayout.NORTH, panel_5, 6+(41*temp), SpringLayout.SOUTH, panel_4);
			sl_panel_2.putConstraint(SpringLayout.WEST, panel_5, 10, SpringLayout.WEST, panel_2);
			sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_5, 41+(41*temp), SpringLayout.SOUTH, panel_4);
			sl_panel_2.putConstraint(SpringLayout.EAST, panel_5, 637, SpringLayout.WEST, panel_2);
			panel_2.add(panel_5);
			temp++;
			panel_5.setLayout(new GridLayout(0, 4, 0, 0));

			JLabel lbl1 = new JLabel(ca);
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			panel_5.add(lbl1);

			JLabel lbl2 = new JLabel(in);
			lbl2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			panel_5.add(lbl2);

			JLabel lbl3 = new JLabel(out);
			lbl3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			panel_5.add(lbl3);

			JLabel lbl4 = new JLabel(me);
			lbl4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl4.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			panel_5.add(lbl4);
			//////////////////////취소버튼
			JPanel p_remove_1 = new JPanel();
			sl_panel_2.putConstraint(SpringLayout.NORTH, p_remove_1, 0+(41*temp), SpringLayout.NORTH, p_remove);
			sl_panel_2.putConstraint(SpringLayout.WEST, p_remove_1, 6, SpringLayout.EAST, panel_5);
			sl_panel_2.putConstraint(SpringLayout.SOUTH, p_remove_1, 35+(41*temp), SpringLayout.NORTH, p_remove);
			sl_panel_2.putConstraint(SpringLayout.EAST, p_remove_1, -10, SpringLayout.EAST, panel_2);
			panel_2.add(p_remove_1);
			p_remove_1.setLayout(new CardLayout(0, 0));
			
			JLabel lblNewLabel_51 = new JLabel("삭제");
			lblNewLabel_51.setForeground(Color.RED);
			lblNewLabel_51.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			lblNewLabel_51.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//삭제
					//아이디, 수입, 년, 월, 일, 카테고리, 메모
					int cnt = dao.indelete(id, in, dateYMS[0], dateYMS[1], dateYMS[2],ca,me);
					if(cnt>0) {
						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
						dispose();
						main(id, dateTemp);
					}
				}
			});
			p_remove_1.add(lblNewLabel_51, "name_5455100935527");
			
		}
		for (int i = 0; i < olist.size(); i++) {// 지출 행 넣기

			OutcomeVO m = olist.get(i);

			String ca = m.getCategory();
			String in = "+0";
			String out = "-"+m.getMoney()+"";
			String me = m.getMemo();
			
			JPanel panel_5 = new JPanel();
			sl_panel_2.putConstraint(SpringLayout.NORTH, panel_5, 6+(41*temp), SpringLayout.SOUTH, panel_4);
			sl_panel_2.putConstraint(SpringLayout.WEST, panel_5, 10, SpringLayout.WEST, panel_2);
			sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_5, 41+(41*temp), SpringLayout.SOUTH, panel_4);
			sl_panel_2.putConstraint(SpringLayout.EAST, panel_5, 637, SpringLayout.WEST, panel_2);
			panel_2.add(panel_5);
			temp++;
			panel_5.setLayout(new GridLayout(0, 4, 0, 0));

			JLabel lbl1 = new JLabel(ca);
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			panel_5.add(lbl1);

			JLabel lbl2 = new JLabel(in);
			lbl2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			panel_5.add(lbl2);

			JLabel lbl3 = new JLabel(out);
			lbl3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			panel_5.add(lbl3);

			JLabel lbl4 = new JLabel(me);
			lbl4.setHorizontalAlignment(SwingConstants.CENTER);
			lbl4.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			panel_5.add(lbl4);
		
			//////////////////////취소버튼
			JPanel p_remove_1 = new JPanel();
			sl_panel_2.putConstraint(SpringLayout.NORTH, p_remove_1, 0+(41*temp), SpringLayout.NORTH, p_remove);
			sl_panel_2.putConstraint(SpringLayout.WEST, p_remove_1, 6, SpringLayout.EAST, panel_5);
			sl_panel_2.putConstraint(SpringLayout.SOUTH, p_remove_1, 35+(41*temp), SpringLayout.NORTH, p_remove);
			sl_panel_2.putConstraint(SpringLayout.EAST, p_remove_1, -10, SpringLayout.EAST, panel_2);
			panel_2.add(p_remove_1);
			p_remove_1.setLayout(new CardLayout(0, 0));
			
			JLabel lblNewLabel_51 = new JLabel("삭제");
			lblNewLabel_51.setForeground(Color.RED);
			lblNewLabel_51.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
			lblNewLabel_51.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//삭제
					//아이디, 수입, 년, 월, 일, 카테고리, 메모
					
					int cnt = dao.outdelete(id, m.getMoney(), dateYMS[0], dateYMS[1], dateYMS[2],ca,me);
					if(cnt>0) {
						JOptionPane.showMessageDialog(null, "삭제되었습니다.");
						dispose();
						main(id, dateTemp);
					}else {
						System.out.println("삭제 실패");
					}
				}	
			});	
			p_remove_1.add(lblNewLabel_51, "name_5455100935527");
		}

		// table = new JTable(data,columnNames);
		// table.setFont(new Font("서울남산 장체B", Font.PLAIN, 20));
		// scrollPane.setViewportView(table);
		setResizable(false);// 창 못움직이게
	}
}
