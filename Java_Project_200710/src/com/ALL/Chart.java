package com.ALL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.img.a;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;


public class Chart extends JFrame {

	private JPanel contentPane;
	private BufferedImage icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chart frame = new Chart();
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
	public Chart() {
		setUndecorated(true);//타이틀바 없애기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					String path = a.class.getResource("").getPath();// a클래스 위치
																	// 가지고오기
					File fileInSamePackage = new File(path + "chartBackground.png");
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
		lblNewLabel_2.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_2, "name_14836750609233");
		sl_panel_4.putConstraint(SpringLayout.EAST, panel_8, -6, SpringLayout.WEST, panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\u25B6");
		lblNewLabel_3.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_3, "name_14838850314481");
		panel_4.add(panel_8);
		panel_8.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uB144");
		lblNewLabel_1.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_1, "name_14824930828554");
		
		JPanel panel_12 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_12, -526, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_12, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_12, -52, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_12, 510, SpringLayout.WEST, panel_1);
		panel_1.add(panel_12);
		
		
		
		
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
		lblNewLabel_4.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_4, "name_14841380498663");
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel_11, 53, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_11, -6, SpringLayout.WEST, panel_10);
		panel_10.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("\u25B6");
		lblNewLabel_6.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_6, "name_14848650437121");
		panel_5.add(panel_11);
		panel_11.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("\uC6D4");
		lblNewLabel_5.setFont(new Font("서울남산 장체BL", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_5, "name_14843400286818");
		
		JPanel panel_13 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_13, -525, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_13, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_13, -51, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_13, 510, SpringLayout.WEST, panel_2);
		panel_2.add(panel_13);

		
		///==========================================================================================
		
//        // 데이터 생성
//        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();                // bar chart 1
//        DefaultCategoryDataset dataset12 = new DefaultCategoryDataset();         // bar chart 2
//        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();                // line chart 1
// 
//        // 데이터 입력 ( 값, 범례, 카테고리 )
//        // 그래프 1       
//        dataset1.addValue(1.0, "S1", "1월");
//        dataset1.addValue(4.0, "S1", "2월");
//        dataset1.addValue(3.0, "S1", "3월");
//        dataset1.addValue(5.0, "S1", "4월");
//        dataset1.addValue(5.0, "S1", "5월");
//        dataset1.addValue(7.0, "S1", "6월");
//        dataset1.addValue(7.0, "S1", "7월");
//        dataset1.addValue(8.0, "S1", "8월");
//        dataset1.addValue(0, "S1", "9월");
//        dataset1.addValue(0, "S1", "10월");
//        dataset1.addValue(0, "S1", "11월");
//        dataset1.addValue(0, "S1", "12월");
// 
//        // 그래프 2       
//        dataset12.addValue(0, "S2", "1월");
//        dataset12.addValue(0, "S2", "2월");
//        dataset12.addValue(0, "S2", "3월");
//        dataset12.addValue(0, "S2", "4월");
//        dataset12.addValue(0, "S2", "5월");
//        dataset12.addValue(0, "S2", "6월");
//        dataset12.addValue(0, "S2", "7월");
//        dataset12.addValue(0, "S2", "8월");
//        dataset12.addValue(6.0, "S2", "9월");
//        dataset12.addValue(0, "S2", "10월");
//        dataset12.addValue(0, "S2", "11월");
//        dataset12.addValue(0, "S2", "12월");
// 
//        // 그래프 3       
//        dataset2.addValue(9.0, "T1", "1월");
//        dataset2.addValue(7.0, "T1", "2월");
//        dataset2.addValue(2.0, "T1", "3월");
//        dataset2.addValue(6.0, "T1", "4월");
//        dataset2.addValue(6.0, "T1", "5월");
//        dataset2.addValue(9.0, "T1", "6월");
//        dataset2.addValue(5.0, "T1", "7월");
//        dataset2.addValue(4.0, "T1", "8월");
//        dataset2.addValue(8.0, "T1", "9월");
//        dataset2.addValue(8.0, "T1", "10월");
//        dataset2.addValue(8.0, "T1", "11월");
//        dataset2.addValue(8.0, "T1", "12월");
// 
//        // 렌더링 생성 및 세팅
//        // 렌더링 생성
//        final BarRenderer renderer = new BarRenderer();
//        final BarRenderer renderer12 = new BarRenderer();
//        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
//       
//        // 공통 옵션 정의
//        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
//        final ItemLabelPosition p_center = new ItemLabelPosition(
//                ItemLabelAnchor.CENTER, TextAnchor.CENTER
//            );
//        final ItemLabelPosition p_below = new ItemLabelPosition(
//                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT
//                     );
//        Font f = new Font("Gulim", Font.BOLD, 14);
//        Font axisF = new Font("Gulim", Font.PLAIN, 14);
//       
//        // 렌더링 세팅
//        // 그래프 1
//        renderer.setBaseItemLabelGenerator(generator);
//        renderer.setBaseItemLabelsVisible(true);
//        renderer.setBasePositiveItemLabelPosition(p_center);
//        renderer.setBaseItemLabelFont(f);
////        renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(
////                GradientPaintTransformType.VERTICAL));
////        renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f, 0.0f, Color.blue));
//        renderer.setSeriesPaint(0, new Color(0,162,255));

		
	}

}
