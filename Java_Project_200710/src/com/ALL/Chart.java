package com.ALL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.DAO.MoneyDAO;
import com.VO.IncomeVO;
import com.VO.OutcomeVO;
import com.img.a;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;


public class Chart extends JFrame {

	private JPanel contentPane;
	private BufferedImage icon;
	private MoneyDAO mdao = null;
	private ArrayList<OutcomeVO> olist = null;
	private int year = 0; //�⵵
	private int mon = 0; // �� 
	private int day = 0; // �� 
	private int hour = 0; // �ð�
	private int min = 0; // ��
	private int sec = 0; // ��

	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chart frame = new Chart(id);
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
	public Chart(String id) {
		mdao = new MoneyDAO();
		olist = new ArrayList<OutcomeVO>();
		
		CalendarOutPut();//Ķ���� �޼ҵ� ����
		
		setUndecorated(true);//Ÿ��Ʋ�� ���ֱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// aŬ���� ��ġ
																	// ���������
					File fileInSamePackage = new File(path + "chartBackground.png");
					icon = ImageIO.read(fileInSamePackage);
					Dimension d = getSize();// ��üȭ��
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		contentPane.add(panel, "name_12986590708051");
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0,0,0,0));
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_4 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, 63, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 185, SpringLayout.WEST, panel_1);
		panel_1.add(panel_4);
		SpringLayout sl_panel_4 = new SpringLayout();
		panel_4.setLayout(sl_panel_4);
		
		JPanel panel_6 = new JPanel();
		sl_panel_4.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, panel_6, 0, SpringLayout.WEST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, panel_6, 53, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.EAST, panel_6, 38, SpringLayout.WEST, panel_4);
		panel_4.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		sl_panel_4.putConstraint(SpringLayout.NORTH, panel_7, 0, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, panel_7, -34, SpringLayout.EAST, panel_4);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, panel_7, 0, SpringLayout.SOUTH, panel_6);
		sl_panel_4.putConstraint(SpringLayout.EAST, panel_7, 0, SpringLayout.EAST, panel_4);
		panel_4.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		sl_panel_4.putConstraint(SpringLayout.NORTH, panel_8, 0, SpringLayout.NORTH, panel_4);
		sl_panel_4.putConstraint(SpringLayout.WEST, panel_8, 4, SpringLayout.EAST, panel_6);
		sl_panel_4.putConstraint(SpringLayout.SOUTH, panel_8, 0, SpringLayout.SOUTH, panel_6);
		panel_6.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\u25C0");
		lblNewLabel_2.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_2, "name_14836750609233");
		sl_panel_4.putConstraint(SpringLayout.EAST, panel_8, -6, SpringLayout.WEST, panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\u25B6");
		lblNewLabel_3.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_3, "name_14838850314481");
		panel_4.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uB144");
		lblNewLabel_1.setText(year+"��");
		lblNewLabel_1.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_1, "name_14824930828554");
		
		JPanel panel_12 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_12, 57, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_12, 0, SpringLayout.WEST, panel_4);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_12, -96, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_12, 510, SpringLayout.WEST, panel_1);
		panel_1.add(panel_12);
		panel_12.setLayout(new CardLayout(0, 0));
		chartExample_bar cbar = new chartExample_bar();
		panel_12.add(cbar.chartPanel, "chart");
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,0,0,0));
		panel.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0,0,0,0));
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, -80, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, 64, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, -10, SpringLayout.EAST, panel_2);
		panel_2.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		panel_3.add(lblNewLabel, "name_13902564625684");
		
		JPanel panel_5 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_5, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_5, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_5, 63, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_5, 185, SpringLayout.WEST, panel_2);
		panel_2.add(panel_5);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);
		
		JPanel panel_9 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel_9, 0, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel_9, 0, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel_9, 53, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_9, 39, SpringLayout.WEST, panel_5);
		panel_5.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel_10, 0, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel_10, -36, SpringLayout.EAST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel_10, 53, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_10, 0, SpringLayout.EAST, panel_5);
		panel_5.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel_11, 0, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel_11, 6, SpringLayout.EAST, panel_9);
		panel_9.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("\u25C0");
		lblNewLabel_4.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_4, "name_14841380498663");
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel_11, 53, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_11, -6, SpringLayout.WEST, panel_10);
		panel_10.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("\u25B6");
		lblNewLabel_6.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_6, "name_14848650437121");
		panel_5.add(panel_11);
		panel_11.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("\uC6D4");
		lblNewLabel_5.setText(mon+"��");
		lblNewLabel_5.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_5, "name_14843400286818");
		
		JPanel panel_13 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_13, 57, SpringLayout.SOUTH, panel_3);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_13, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_13, -95, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_13, 0, SpringLayout.EAST, panel_3);
		panel_2.add(panel_13);
		
		
		//ī�װ��� ��Ʈ �߰� ����
		//��� ���̵�, ī�װ�, ��, ���� ���� 
		//���� --> �ĺ�, �ְ�/���, ��Ȱ��ǰ, �Ǻ�/�̿�, ����/����, ��Ÿ
		String[] outCategory = {"�ĺ�","�ְ�/���","��Ȱ��ǰ","�Ǻ�/�̿�","����/����","��Ÿ"};
		String[] outCategory2 = {"food","communication","Household Goods","cloth/beauty","traffic fee","etc"};
		int[] outMoney = new int[outCategory.length];
		
		for (int i = 0; i < outCategory.length; i++) {//ī�װ��� ���� �հ� ����
			outMoney[i] = mdao.outMoneySelect(id, year, mon, outCategory[i] );
		}

		for (int i = 0; i < outMoney.length; i++) {
			System.out.println(outMoney[i]+"����...");
		}
		
		JFreeChart jFreeChart = getPieChart(outCategory2, outMoney);//��Ʈ�߰�
		//JFreeChart jFreeChart = getPieChart();
		ChartPanel chartPanel = new ChartPanel(jFreeChart);
		panel_13.add(chartPanel);
		
		
		
	}
	
	public void CalendarOutPut() {
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR); //�⵵
        mon = cal.get(Calendar.MONTH)+1; // �� 
        day = cal.get(Calendar.DAY_OF_MONTH); // �� 
        hour = cal.get(Calendar.HOUR_OF_DAY); // �ð�
        min = cal.get(Calendar.MINUTE); // ��
        sec = cal.get(Calendar.SECOND); // ��
	}
	
	public JFreeChart getPieChart(String[] outCategory, int[] outMoney) {
	    DefaultPieDataset dataset = new DefaultPieDataset();
	
        for(int i =0; i<outCategory.length; i++){
            int n = outMoney[i];
            System.out.println("��Ʈ..."+n);
            dataset.setValue(outCategory[i], n);
        }
		JFreeChart chart = ChartFactory.createPieChart3D("Expenditure", dataset, true,true, false);
		chart.setBackgroundPaint(Color.white);
		
		return chart;
	}
	public JFreeChart getPieChart() {
	    DefaultPieDataset dataset = new DefaultPieDataset();
	
        for(int i =0; i<10; i++){
            int n = i*5;
            dataset.setValue("Test"+(i+1), n);
        }
		JFreeChart chart = ChartFactory.createPieChart3D("Expenditure", dataset, true,true, false);
		chart.setBackgroundPaint(Color.white);
		
		return chart;
	}
}
