package com.ALL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.DAO.MoneyDAO;
import com.DAO.budgetDAO;
import com.VO.BudgetVO;
import com.VO.OutcomeVO;
import com.img.a;

import oracle.net.aso.b;

import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class budgetRestart extends JFrame {
	MoneyDAO dao = null;
	ArrayList<BudgetVO> blist = null;
	private JPanel contentPane;
	Calendar c = Calendar.getInstance();
	private int todayYear;
	private int todayMon;
	private int todayDay;

	/**
	 * Launch the application.
	 */
	public static void main(String id,int yearTemp,int monTemp,String talk) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budgetRestart frame = new budgetRestart(id,yearTemp,monTemp,talk);
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
public budgetRestart(String id,int yearTemp,int monTemp,String talk) {
	dao = new MoneyDAO();
	blist = new ArrayList<BudgetVO>();
	
	setUndecorated(true);//Ÿ��Ʋ�� ���ֱ�
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(690, 176, 500, 700);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new GridLayout(0, 1, 0, 0));

	JPanel panel = new JPanel() { // panel_1 ����& �̹����ֱ�
		public void paintComponent(Graphics g) {

			try {
				String path = a.class.getResource("").getPath();
				File fileInSamePackage = new File(path + "background_write.jpg");
				BufferedImage icon = ImageIO.read(fileInSamePackage);

				Dimension d = getSize();// ��üȭ��
				g.drawImage(icon, 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};

	contentPane.add(panel);
	SpringLayout sl_panel = new SpringLayout();
	panel.setLayout(sl_panel);

	JPanel panel_1 = new JPanel();
	sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 188, SpringLayout.NORTH, panel);
	sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
	sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, panel);
	sl_panel.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
	panel_1.setBackground(new Color(255, 192, 0));
	panel.add(panel_1);
	panel_1.setLayout(null);

	JPanel panel_2 = new JPanel();
	panel_2.setBounds(0, 0, 454, 52);
	panel_1.add(panel_2);
	SpringLayout sl_panel_2 = new SpringLayout();
	panel_2.setLayout(sl_panel_2);

	JLabel Time = new JLabel("New label");
	Time.setFont(new Font("���ﳲ�� ��üBL", Font.BOLD, 20));
	Time.setHorizontalAlignment(SwingConstants.CENTER);
	panel_2.add(Time);
	//////////////////////////////////////////////////////////////////////
	if(yearTemp==0) {
	todayYear = c.get(Calendar.YEAR);
	}else {
		todayYear=yearTemp;
	}
	if(monTemp==0) {
		todayMon = c.get(Calendar.MONTH) + 1;
	}else {
		todayMon = monTemp;
	}
	
	todayDay = c.get(Calendar.DAY_OF_MONTH); // �� 
	Time.setText(todayYear + "�� " + todayMon + "��");
	//System.out.println(todayDay);
	//////////////////////////////////////////////////////////////////////

	JButton btnNewButton_1 = new JButton("\u25B6");
	sl_panel_2.putConstraint(SpringLayout.NORTH, Time, 0, SpringLayout.NORTH, btnNewButton_1);
	sl_panel_2.putConstraint(SpringLayout.SOUTH, Time, 0, SpringLayout.SOUTH, btnNewButton_1);
	btnNewButton_1.setBackground(new Color(255, 192, 0));

	btnNewButton_1.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			todayMon++;
			if (todayMon > 12) {
				todayMon=1;
				todayYear++;
			}
			Time.setText(todayYear + "�� " + (todayMon) + "��");
			
			budgetRestart br = new budgetRestart(id, todayYear, todayMon,talk);
			br.main(id, todayYear, todayMon,talk);
			dispose();
		}
	});
	sl_panel_2.putConstraint(SpringLayout.EAST, Time, -6, SpringLayout.WEST, btnNewButton_1);
	sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, panel_2);
	sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton_1, -57, SpringLayout.EAST, panel_2);
	sl_panel_2.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, panel_2);
	sl_panel_2.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, panel_2);
	panel_2.add(btnNewButton_1);

	JButton button = new JButton("\u25C0");
	button.setBackground(new Color(255, 192, 0));
	button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			todayMon--;
			if(todayMon<1) {
				todayMon=12;
				todayYear--;
			}
			Time.setText(todayYear + "�� " + (todayMon) + "��");
			budgetRestart br = new budgetRestart(id, todayYear, todayMon,talk);
			br.main(id, todayYear, todayMon,talk);
			dispose();
		}
	});
	sl_panel_2.putConstraint(SpringLayout.WEST, Time, 6, SpringLayout.EAST, button);
	sl_panel_2.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, panel_2);
	sl_panel_2.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, panel_2);
	sl_panel_2.putConstraint(SpringLayout.EAST, button, 57, SpringLayout.WEST, panel_2);
	sl_panel_2.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, panel_2);
	panel_2.add(button);

	JPanel cancel = new JPanel() { // panel_1 ����& �̹����ֱ�
		public void paintComponent(Graphics g) {

			try {
				String path = a.class.getResource("").getPath();
				File fileInSamePackage = new File(path + "ButtonVoid.png");
				BufferedImage icon = ImageIO.read(fileInSamePackage);
				Dimension d = getSize();// ��üȭ��
				g.drawImage(icon, 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	cancel.setBounds(378, 410, 64, 36);
	panel_1.add(cancel);
	cancel.setLayout(new GridLayout(0, 1, 0, 0));

	JLabel lblNewLabel_1 = new JLabel("\uCDE8\uC18C");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 20));
	cancel.add(lblNewLabel_1);
	lblNewLabel_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			dispose();
		
		}
	});

	JPanel plus = new JPanel() {
		public void paintComponent(Graphics g) {
		}
	};
	plus.setBounds(10, 410, 70, 37);
	panel_1.add(plus);
	plus.setLayout(new GridLayout(0, 1, 0, 0));

	JLabel lblNewLabel_2 = new JLabel("+"){ // panel_1 ����& �̹����ֱ�
		public void paintComponent(Graphics g) {

			try {
				String path = a.class.getResource("").getPath();
				File fileInSamePackage = new File(path + "ButtonVoid.png");
				BufferedImage icon = ImageIO.read(fileInSamePackage);
				Dimension d = getSize();// ��üȭ��
				g.drawImage(icon, 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 20));
	plus.add(lblNewLabel_2);
	
	JPanel panel_6 = new JPanel();
	panel_6.setBackground(new Color(0,0,0,0));
	sl_panel.putConstraint(SpringLayout.NORTH, panel_6, 47, SpringLayout.NORTH, panel);
	sl_panel.putConstraint(SpringLayout.WEST, panel_6, -287, SpringLayout.EAST, panel_1);
	sl_panel.putConstraint(SpringLayout.SOUTH, panel_6, -42, SpringLayout.NORTH, panel_1);
	sl_panel.putConstraint(SpringLayout.EAST, panel_6, -73, SpringLayout.EAST, panel);
	panel.add(panel_6);
	panel_6.setLayout(new CardLayout(0, 0));
	
	JTextArea textArea = new JTextArea();
	textArea.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	textArea.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
	textArea.setOpaque(false);
	textArea.setText(talk);
	panel_6.add(textArea, "name_5763803647688");
	lblNewLabel_2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			budgeNewtInput bn = new budgeNewtInput(id);
			bn.main(id);
			dispose();
		}
	});

	

	JScrollPane scrollPane = new JScrollPane(); // ��ũ�� ��
	JPanel area = new JPanel(); // �г�
	Dimension size = new Dimension(); // ������ ����
	size.setSize(400, 500);
	area.setPreferredSize(size);
	scrollPane.setViewportView(area);
	SpringLayout sl_area = new SpringLayout();
	area.setLayout(sl_area);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//�����ͺ��̽����� ���� �׸� ���������(���̵�, ��, ��)
	blist = dao.budgetNextSelect2(id,todayYear,todayMon);// ������ ī�װ� ������ ������´�.
	
	if(blist.size()==0) {
		
		JLabel lblNewLabel_3 = new JLabel("������ �����ϴ�. �߰����ּ���");
		lblNewLabel_3.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 17));
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		area.add(lblNewLabel_3);
		
		scrollPane.setBounds(5, 62, 445, 342);
		panel_1.add(scrollPane);
		
		Dimension size1 = new Dimension();
		size1.setSize(200, 100);
		area.setPreferredSize(size1);
	}
	
	//���� ���
	int temp=0;
	for(int i=0 ; i<blist.size() ;i++) {
		
		String ca = blist.get(i).getCategory();//ī�װ�
		int num1 = blist.get(i).getMoney();//����
		int num2 =0; //���� ���� ���� ���ݾ�
		if(todayMon==1||todayMon==3||todayMon==5||todayMon==7||todayMon==8||todayMon==10||todayMon==12) {
			num2 = num1/31*todayDay;
		}else if(todayMon==2) {
			num2 = num1/28*todayDay;
		}else {
			num2 = num1/30*todayDay;
		}
		
		int num3 = 0;//���� ���ݾ�
		//�������̺��� ���̵�,��,��,ī�װ� �� ����Ͽ� �������
		num3 = dao.outcomeSelect3(id,todayYear,todayMon,ca);
			
		int num4 = num1-num3;//�̹��� ���� ����
		int num5 = 0;//��� �Ϸ� ��� ���� �ݾ�
		if(todayMon==1||todayMon==3||todayMon==5||todayMon==7||todayMon==8||todayMon==10||todayMon==12) {
			num5 = num4/(31-todayDay);
		}else if(todayMon==2) {
			num5 = num4/(28-todayDay);
		}else {
			num5 = num4/(30-todayDay);
		}
		
		int dayTemp = 0;
		if(todayMon==1||todayMon==3||todayMon==5||todayMon==7||todayMon==8||todayMon==10||todayMon==12) {
			dayTemp = 31-todayDay;
		}else if(todayMon==2) {
			dayTemp = 28-todayDay;
		}else {
			dayTemp = 30-todayDay;
		}
		
	JPanel panel_3 = new JPanel();
	sl_area.putConstraint(SpringLayout.NORTH, panel_3, 10+(179*temp), SpringLayout.NORTH, area);
	sl_area.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, area);
	sl_area.putConstraint(SpringLayout.SOUTH, panel_3, 179+(179*temp), SpringLayout.NORTH, area);
	sl_area.putConstraint(SpringLayout.EAST, panel_3, 433, SpringLayout.WEST, area);
	area.add(panel_3);
	SpringLayout sl_panel_3 = new SpringLayout();
	panel_3.setLayout(sl_panel_3);
	
	JPanel panel_4 = new JPanel();
	sl_panel_3.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, panel_3);
	sl_panel_3.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_3);
	sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_4, 159, SpringLayout.NORTH, panel_3);
	sl_panel_3.putConstraint(SpringLayout.EAST, panel_4, 292, SpringLayout.WEST, panel_3);
	panel_3.add(panel_4);
	
	JPanel panel_5 = new JPanel();
	sl_panel_3.putConstraint(SpringLayout.NORTH, panel_5, 10, SpringLayout.NORTH, panel_3);
	sl_panel_3.putConstraint(SpringLayout.WEST, panel_5, 6, SpringLayout.EAST, panel_4);
	sl_panel_3.putConstraint(SpringLayout.SOUTH, panel_5, 159, SpringLayout.NORTH, panel_3);
	sl_panel_3.putConstraint(SpringLayout.EAST, panel_5, 121, SpringLayout.EAST, panel_4);
	panel_4.setLayout(new GridLayout(5, 0, 0, 0));
	
	JLabel lblNewLabel_3 = new JLabel("|"+ca+"| --����--");
	lblNewLabel_3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			//���̺� ����
			//System.out.println("�̺�Ʈ");
			budgetDAO bdao = new budgetDAO();
			
			int cnt = bdao.buddelete(id,ca,todayYear,todayMon);
			if(cnt>0) {
				JOptionPane.showMessageDialog(null, "������ �����Ǿ����ϴ�.");
				budgetRestart br = new budgetRestart(id,todayYear,todayMon,talk);
				br.main(id,todayYear,todayMon,talk);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "���� ����...");
			}
		
		}
	});
	lblNewLabel_3.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 17));
	panel_4.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("\uAE08\uC77C \uAE30\uC900 \uC801\uC815 \uC0AC\uC6A9\uAE08\uC561");
	lblNewLabel_4.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	panel_4.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("\uD604\uC7AC \uC0AC\uC6A9\uAE08\uC561(\uC608\uC815\uAE08\uC561 \uD3EC\uD568)");
	lblNewLabel_5.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	panel_4.add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("\uC774\uBC88 \uB2EC \uB0A8\uC740 \uC608\uC0B0(D-"+dayTemp+")");
	lblNewLabel_6.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	panel_4.add(lblNewLabel_6);
	
	JLabel lblNewLabel = new JLabel("\uD3C9\uADE0 \uD558\uB8E8 \uC0AC\uC6A9 \uAC00\uB2A5\uAE08\uC561");
	lblNewLabel.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	panel_4.add(lblNewLabel);
	panel_3.add(panel_5);
	panel_5.setLayout(new GridLayout(5, 0, 0, 0));
	
	JLabel lblNewLabel_8 = new JLabel("\\"+num1+""); //����
	lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_8.setFont(new Font("���ﳲ�� ��üBL", Font.PLAIN, 17));
	panel_5.add(lblNewLabel_8);
	
	JLabel lblNewLabel_9 = new JLabel("\\"+num2+"");//���� ���� ���� ���ݾ�
	lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_9.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	panel_5.add(lblNewLabel_9);
	
	JLabel lblNewLabel_7 = new JLabel("\\"+num3+"");//���� ���ݾ�(�����ݾ� ����)
	lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_7.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	panel_5.add(lblNewLabel_7);
	
	JLabel lblNewLabel_10 = new JLabel("\\"+num4+"");//�̹� �� ���� ����
	lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_10.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	if(num4<0) {
		lblNewLabel_10.setForeground(Color.red);
	}
	panel_5.add(lblNewLabel_10);
	
	JLabel label = new JLabel("\\"+num5+"");//��� �Ϸ� ��� ���ɱݾ�
	label.setHorizontalAlignment(SwingConstants.RIGHT);
	label.setFont(new Font("���ﳲ�� ��üB", Font.PLAIN, 17));
	if(num5<0) {
		label.setForeground(Color.red);
	}
	panel_5.add(label);
	
	scrollPane.setBounds(5, 62, 445, 342);
	panel_1.add(scrollPane);
	
	temp++;
	Dimension size1 = new Dimension();
	size1.setSize(420, (temp*179));
	area.setPreferredSize(size1);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	}
}
