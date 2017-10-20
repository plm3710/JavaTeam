package com.ALL;

import java.awt.Color;

import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.plot.*;

public class chartExample_pie {

	public static void main(String arg[]){
		chartExample_pie bcb = new chartExample_pie();
		JFreeChart chart = bcb.getPieChart();
		ChartFrame frame1=new ChartFrame("Pie Chart",chart);
		frame1.setSize(800,450);  
		frame1.setVisible(true);
	}

	public JFreeChart getPieChart() {
	    DefaultPieDataset dataset = new DefaultPieDataset();
	
        for(int i =0; i<10; i++){
            //int n = (int) (Math.random() * 10) + 1;
        	int n = i+10;
            dataset.setValue("value"+(i+1), n);
        }
		JFreeChart chart = ChartFactory.createPieChart3D("파이차트", dataset, true,true, false);
		chart.setBackgroundPaint(Color.white);
		
		return chart;
	}
}


