/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distribution1;
import java.util.*;
/**
 *
 * @author ASHISH JAIs
 */
public class Distribution1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ch;
        Scanner read=new Scanner(System.in);
        for(;;){
        System.out.println("Enter 1. for Binomial distribution ");
        System.out.println("Enter 2. for Geometrical distribution ");
        System.out.println("Enter 3. for Negative binomial distribution" );
        System.out.println("Enter 4. for exit");
        ch=read.nextInt();
        switch(ch)
        {
            case 1:binomial();
                   break;
            case 2:geo();
                   break;
            case 3:negative_binomial();
                   break;
            case 4:System.exit(0);
            default:System.out.println("Wrong choice");
        }}
}
static int negative_binomial()
{
    int i=1,x,count1=0,r,ch,n;
    double p1=0.0,p0,prob,mean,variance;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the number of success");
    r=read.nextInt();
    System.out.println("Enter 1 to find the number of trials then the probability of success");
    System.out.println("Enter 2 if you want to provide probability of success and the number of trials");
    ch=read.nextInt();
    if(ch==2){
        System.out.println("Enter the probability of success");
        p1=read.nextDouble();
        System.out.println("Enter the number of trials in which the probability of success is to be found");
        n=read.nextInt();
    }
    else if(ch==1){
        for(i=1;;i++)
            {Random rand=new Random();
            x=rand.nextInt(2);
            System.out.println(x);
            if(x==1){
                count1++;
                if(count1==r)
                    break;}}
        p1=(double)count1/i;
        System.out.println("The number of trials required to get "+r+"th success is "+i);
    }
    else{
        System.out.println("Wrong choice");
        return (0);
    }
    p0=(double)1.0-p1;
    System.out.println("Probability of success ="+p1+" and failure ="+p0);
    prob=(double)(factorial(i-1)/(factorial(r-1)*factorial(i-r)))*Math.pow(p1,r)*Math.pow(p0,(i-r));
    System.out.println("Negative binomial distribution is "+prob);
    mean=(double)r/p1;
    variance=(double)(r*p0)/Math.pow(p1,2);
    System.out.println("The mean is "+mean+" and variance is "+variance);
    return 0;
}
static void geo()
{
    int i,n,x,count1=0,fs=0;
    double p1,p0,prob,mean,variance;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the number of trials");
    n=read.nextInt();
    for(i=0;i<n;i++){
        Random rand=new Random();
        x=rand.nextInt(2);
        if(x==1)
            count1++;
        System.out.println(x);
        if(count1==1)
            fs=i+1;}
    p1=(double)count1/n;
    p0=(double)1.0-p1;
    prob=(double)p1*Math.pow(p0,(count1-1));
    System.out.println("First success comes at "+fs+"th trial");
    System.out.println("Probability of success ="+p1+" and failure ="+p0);
    System.out.println("Geometrical distribution of 1st success is"+prob);
    mean=1/p1;
    variance=p0/Math.pow(p1,2);
    System.out.println("The mean is "+mean+" and variance is "+variance);
}
static void binomial()
{
    int i,n,x,count1=0;
    double p1,p0,prob,mean,variance;
    Scanner read=new Scanner(System.in);
    System.out.println("Enter the number of trials");
    n=read.nextInt();
    for(i=0;i<n;i++){
        x=(int)(Math.random()*2+0);
        if(x==1)
            count1++;
        System.out.println(x);}
    p1=(double)count1/n;
    p0=(double)1.0-p1;
    System.out.println("The number of success in "+n+" trials is "+count1);
    System.out.println("Probability of success ="+p1+" and failure ="+p0);
    prob=(double)(factorial(n)/(factorial(n-count1)*factorial(count1)))*Math.pow(p1,count1)*Math.pow(p0,(n-count1));
    System.out.println("Binomial distribution of "+count1+" success is "+prob);
    mean=p1*n;
    variance=n*p1*p0;
    System.out.println("The mean is "+mean+" and variance is "+variance);
}
static int factorial(int x)
{
    int fact=1;
    if(x==0)
        return 1;
    else{
        for(int i=1;i<=x;i++)
            fact=fact*i;}
    return fact;
}
}
