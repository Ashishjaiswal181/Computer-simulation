/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice_roll;

/**
 *
 * @author ASHISH JAIs
 */
public class Dice_roll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i,x,count1=0,count2=0,count3=0,count4=0,count5=0,count6=0;
        for(i=0;i<500;i++)
        {
            x=(int) (Math.random()*6+1);
            switch (x) {
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                default:
                    count6++;
                    break;
            }
        }
        int[] count=new int[]{count1,count2,count3,count4,count5,count6};
        System.out.println("Rolling of a 6 sided die:");
        System.out.print("Outcome:    ");
        for(i=1;i<=6;i++)
            System.out.print(i+"    ");
        System.out.print("\nFrequency: ");
        for(i=0;i<6;i++)
            System.out.print(count[i]+"   ");
        System.out.println("\n\nUsing Chi-square method for testing whether the system is biased or unbiased");
        System.out.println("\nThe null hypothesis in this case is that all the outcomes are independent of each "
                + "other and the system is unbiased");
        System.out.println("\nThe observed value is the frequency of the outcomes");
        float e=(float)500/6,alpha=0.05f;
        System.out.println("\nThe degree of freedom in this case is 6-1 = 5");
        float critical_value=11.07f;//For degree of freedom 6 and alpha 0.05
        System.out.println("\nAlpha-significance given is 0.05");
        System.out.println("\nExpected value for the given data is "+e);
        double[] calc1=new double[6];
        double[] calc2 = new double[6];
        double sum = 0.0;
        for(i=0;i<6;i++){
            calc1[i]=Math.pow((count[i]-e),2);
            calc2[i]=calc1[i]/e;
            sum=sum+calc2[i];}
        System.out.println("\nThe calculated chi value is "+sum+" where as the critical value is "
                +critical_value+" so the comparing this we can conclude ...");
        if(sum<=critical_value)
            System.out.println("\nThe system is unbiased");
        else
        System.out.println("\nThe system is biased");
    }
}
