/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribution2;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ASHISH JAIs
 */
public class Distribution2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    double norm,m,sd;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the mean for the distribution");
    m=read.nextDouble();
    System.out.println("Enter the standard deviation for the distribution");
    sd=read.nextDouble();
    rand=randoms();
    System.out.println("The Normal Distribution:");
    for(i=0;i<10;i++){
        norm=(1/(sd*(Math.sqrt(2*Math.PI))))*Math.exp(((-1)*(Math.pow((rand[i]-m),2)))/(2*Math.pow(sd,2)));
        System.out.println(norm);
    }
}
static void exponential()
{
    int i;
    int[] rand=new int[10];
    float expo,m;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the mean for the distribution");
    m=read.nextFloat();
    rand=randoms();
    System.out.println("The Exponential Distribution:");
    for(i=0;i<10;i++){
        expo=(float)(m*Math.exp(-(m*rand[i])));
        System.out.println(expo);
    }
}
static void uniform()
{
    int i;
    double a,b,pdf,cdf,mean,variance;
    int[] rand=new int[10];
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
        cdf=(rand[i]-a)/(b-a);
        System.out.println(cdf);}
    mean=(a+b)/2;
    System.out.println("Mean is "+mean);
    variance=1/12*Math.pow((b-a),2);
    System.out.println("Variance is "+variance);
    }
static void poisson()
{
    int i;
    int[] rand=new int[10];
    double poi,m,t;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the mean for the distribution");
    m=read.nextDouble();
    System.out.println("Enter the unit time for mean");
    t=read.nextDouble();
    rand=randoms();
    System.out.println("The Poisson Distribution:");
    for(i=0;i<10;i++){
        poi=(Math.exp(-(m*t))*Math.pow((m*t),rand[i]))/factorial(rand[i]);
        System.out.println(poi);
    }
}
static int factorial(int fact)
{
    if(fact==0)
        return 1;
    else
        return (fact*factorial(fact-1));
}
}