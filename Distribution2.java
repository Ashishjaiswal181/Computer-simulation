/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribution2;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author ASHISH JAIs
 */
public class Distribution2 extends ApplicationFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        // TODO code application logic here       
        int ch;
        Scanner read=new Scanner(System.in);
        for(;;){
        System.out.println("Enter 1. for Normal distribution ");
        System.out.println("Enter 2. for Exponential distribution ");
        System.out.println("Enter 3. for Uniform distribution" );
        System.out.println("Enter 4. for Poisson distribution" );
        System.out.println("Enter 5. for exit");
        ch=read.nextInt();
        switch(ch)
        {
            case 1:normal();
                   break;
            case 2:exponential();
                   break;
            case 3:uniform();
                   break;
            case 4:poisson();
                   break;
            case 5:System.exit(0);
            default:System.out.println("Wrong choice");
        }}
}
static int[] randoms(){
    int i;
    int[] x=new int[10];
    System.out.println("The random numbers are:");
    for(i=0;i<10;i++){
        x[i]=(int)(Math.random()*10+1);
        System.out.println(x[i]);}
    return x;
}
static void normal()
{
    int i;
    int[] rand=new int[10];
    double[] norm=new double[10];
    double m,sd;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the mean for the distribution");
    m=read.nextDouble();
    System.out.println("Enter the standard deviation for the distribution");
    sd=read.nextDouble();
    rand=randoms();
    System.out.println("The Normal Distribution:");
    for(i=0;i<10;i++){
        norm[i]=(1/(sd*(Math.sqrt(2*Math.PI))))*Math.exp(((-1)*(Math.pow((rand[i]-m),2)))/(2*Math.pow(sd,2)));
        System.out.println(norm[i]);
    }
    final Distribution2 demo = new Distribution2("Normal Distribution graph",rand,norm);
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);
}
static void exponential()
{
    int i;
    int[] rand=new int[10];
    double[] expo=new double[10];
    float m;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the mean for the distribution");
    m=read.nextFloat();
    rand=randoms();
    System.out.println("The Exponential Distribution:");
    for(i=0;i<10;i++){
        expo[i]=(float)(m*Math.exp(-(m*rand[i])));
        System.out.println(expo[i]);
    }
    final Distribution2 demo = new Distribution2("Exponential Distribution graph",rand,expo);
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);
}
static void uniform()
{
    int i;
    double a,b,pdf,mean,variance;
    int[] rand=new int[10];
    double[] cdf=new double[10];
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the minimum value of the range");
    a=read.nextDouble();
    System.out.println("Enter the maximum value of the range");
    b=read.nextDouble();
    System.out.println("The Uniform Probability Distribution Function:");
    pdf=1/(b-a);
    System.out.println(pdf);
    rand=randoms();
    System.out.println("The Uniform Cumulative Distribution:");
    for(i=0;i<10;i++){
        cdf[i]=(rand[i]-a)/(b-a);
        System.out.println(cdf[i]);}
    mean=(a+b)/2;
    System.out.println("Mean is "+mean);
    variance=1/12*Math.pow((b-a),2);
    System.out.println("Variance is "+variance);
    final Distribution2 demo = new Distribution2("Uniform Distribution graph",rand,cdf);
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);
    }
static void poisson()
{
    int i;
    int[] rand=new int[10];
    double[] poi=new double[10];
    double m,t;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the mean for the distribution");
    m=read.nextDouble();
    System.out.println("Enter the unit time for mean");
    t=read.nextDouble();
    rand=randoms();
    System.out.println("The Poisson Distribution:");
    for(i=0;i<10;i++){
        poi[i]=(Math.exp(-(m*t))*Math.pow((m*t),rand[i]))/factorial(rand[i]);
        System.out.println(poi[i]);
    }
    final Distribution2 demo = new Distribution2("Poisson Distribution graph",rand,poi);
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);
}
static int factorial(int fact)
{
    if(fact==0)
        return 1;
    else
        return (fact*factorial(fact-1));
}
public Distribution2(final String title,int x[],double y[]) 
{
    super(title);
    final XYSeries series = new XYSeries("Distribution plot");
    int i;
    for(i=0;i<10;i++){
    series.add(x[i],y[i]);
    }
    final XYSeriesCollection data = new XYSeriesCollection(series);
    final JFreeChart chart = ChartFactory.createXYLineChart(
        "Distribution Graph","X","Y",data,
        PlotOrientation.VERTICAL,true,true,false);
    final ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
    setContentPane(chartPanel);
}
}