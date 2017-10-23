package com.ALL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import com.DAO.MoneyDAO;
import com.VO.IncomeVO;
import com.VO.OutcomeVO;

/**
 * A simple demonstration application showing how to create a bar chart.
 *
 */
public class chartExample_bar{

    public ChartPanel chartPanel;
    private ArrayList<IncomeVO> ilist = null;
    private ArrayList<OutcomeVO> olist = null;
    private int[] ilistMoney = null;
    private int[] olistMoney = null;
    private MoneyDAO mdao = null;

	/**
     * Creates a new demo instance.
	 * @param year 
	 * @param id 
     *
     * @param title  the frame title.
     */
    public chartExample_bar(String id, int year) {
        final CategoryDataset dataset = createDataset(id,year);
        final JFreeChart chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));

    }

    /**
     * Returns a sample dataset.
     * @param year 
     * @param id 
     * 
     * @return The dataset.
     */
    private CategoryDataset createDataset(String id, int year) {
        ilist = new ArrayList<IncomeVO>();
        olist = new ArrayList<OutcomeVO>();
        ilistMoney = new int[12];
        olistMoney = new int[12];
        mdao = new MoneyDAO();
        
        
    	//수입 지출 아이디,년,월 을 이용하여 money합계를 구한다.
        ilist = mdao.inMoneySelectChart(id, year);
    	for (int i = 1; i <= 12; i++) {
    		int moneySum=0;
			for (int j = 0; j < ilist.size(); j++) {
				if(ilist.get(j).getMonth()==i) {//지출에서 월이 1~12와 같으면 돈의 합계를 구함
					moneySum+=ilist.get(j).getMoney();
				}
			}
			ilistMoney[i-1]=moneySum;
    	}
    	olist = mdao.outMoneySelectChart(id, year);
    	for (int i = 1; i <= 12; i++) {
    		int moneySum=0;
			for (int j = 0; j < olist.size(); j++) {
				if(olist.get(j).getMonth()==i) {//지출에서 월이 1~12와 같으면 돈의 합계를 구함
					moneySum+=olist.get(j).getMoney();
				}
			}
			olistMoney[i-1]=moneySum;
    	}
    	
        // row keys
        final String income = "Income"; //수입 파란색
        //final String series2 = "Second";
        final String expenditure = "Expenditure"; //지출 빨간색

        // 카테고리 입력
        
        final String category1 = "1";
        final String category2 = "2";
        final String category3 = "3";
        final String category4 = "4";
        final String category5 = "5";
        final String category6 = "6";
        final String category7 = "7";
        final String category8 = "8";
        final String category9 = "9";
        final String category10 = "10";
        final String category11 = "11";
        final String category12 = "12";

        // 값 입력
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(ilistMoney[0], income, category1);
        dataset.addValue(ilistMoney[1], income, category2);
        dataset.addValue(ilistMoney[2], income, category3);
        dataset.addValue(ilistMoney[3], income, category4);
        dataset.addValue(ilistMoney[4], income, category5);
        dataset.addValue(ilistMoney[5], income, category6);
        dataset.addValue(ilistMoney[6], income, category7);
        dataset.addValue(ilistMoney[7], income, category8);
        dataset.addValue(ilistMoney[8], income, category9);
        dataset.addValue(ilistMoney[9], income, category10);
        dataset.addValue(ilistMoney[10], income, category11);
        dataset.addValue(ilistMoney[11], income, category12);
        
        dataset.addValue(olistMoney[0], expenditure, category1);
        dataset.addValue(olistMoney[1], expenditure, category2);
        dataset.addValue(olistMoney[2], expenditure, category3);
        dataset.addValue(olistMoney[3], expenditure, category4);
        dataset.addValue(olistMoney[4], expenditure, category5);
        dataset.addValue(olistMoney[5], expenditure, category6);
        dataset.addValue(olistMoney[6], expenditure, category7);
        dataset.addValue(olistMoney[7], expenditure, category8);
        dataset.addValue(olistMoney[8], expenditure, category9);
        dataset.addValue(olistMoney[9], expenditure, category10);
        dataset.addValue(olistMoney[10], expenditure, category11);
        dataset.addValue(olistMoney[11], expenditure, category12);
        
        return dataset;
        
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Income & Expenditure",         // 차트이름
            "Month",               // 
            "Money",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */


}