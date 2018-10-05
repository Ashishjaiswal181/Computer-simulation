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
            if(x==1)
                count1++;
            else if(x==2)
                count2++;
            else if(x==3)
                count3++;
            else if(x==4)
                count4++;
            else if(x==5)
                count5++;
            else
                count6++;
        }
        int[] count=new int[]{count1,count2,count3,count4,count5,count6};
        System.out.println("6 sided die outcomes:");
        for(i=1;i<=6;i++)
            System.out.println(i+" -> "+count[i-1]);
    }
}
