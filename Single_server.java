/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single_server;
import java.io.*;
import java.util.*;
import java.lang.*;

/**
 *
 * @author ASHISH JAIs
 */
public class Single_server {
//int max=100;
    /**
     * @param args the command line arguments
     */
    //@SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        int n,sum_time_spent=0,sum_waiting=0,max_time,i,j,sum_idle=0;
        float avg_waiting,avg_time_spent;
        System.out.println("Enter the number of customers");
        Scanner read=new Scanner(System.in);
        n=read.nextInt();
        int[][] sssq=new int[n+1][9];
        for(i=1;i<=9;i++)
            sssq[0][i-1]=i;
        for(i=1;i<=n;i++)
            sssq[i][0]=i;
        System.out.println("Enter the Inter-arrival time of each customer");
        for(i=1;i<=n;i++)
            sssq[i][1]=read.nextInt();
        System.out.println("Enter the service time of each customer");
        for(i=1;i<=n;i++)
            sssq[i][2]=read.nextInt();
        System.out.println("Enter the arrival time of the first customer");
        sssq[1][3]=sssq[1][7]=sssq[1][4]=read.nextInt();
        for(i=1;i<=n;i++){
            if(i>=2){
                sssq[i][3]=sssq[i-1][3]+sssq[i][1];//Arrrival time
            if(sssq[i-1][5]<=sssq[i][3])
                sssq[i][4]=sssq[i][3];//Service begin time
            else
                sssq[i][4]=sssq[i-1][5];
            sssq[i][7]=sssq[i][4]-sssq[i-1][5];}//Idle time for server}
            sssq[i][5]=sssq[i][4]+sssq[i][2];//Service end time
            
            sssq[i][6]=sssq[i][4]-sssq[i][3];//Waiting time of customer
            sum_waiting=sum_waiting+sssq[i][6];
            sum_idle=sum_idle+sssq[i][7];
            sssq[i][8]=sssq[i][6]+sssq[i][2];//Time spent by customer in server
            sum_time_spent=sum_time_spent+sssq[i][8];
        }
        System.out.println("1. Customer \n2. Inter-arrival time");
        System.out.println("3. Service time \n4. Arrival time");
        System.out.println("5. Service Start time \n6. Service end time");
        System.out.println("7. Waiting time of customer \n8. Idle time for server");
        System.out.println("9. Time spent by customer in server");
        System.out.println("The following table shows the data according to the column number mentioned above");
        for(i=0;i<=n;i++){
           for(j=0;j<9;j++)
               System.out.print(sssq[i][j]+" ");
           System.out.println();}
        avg_time_spent=(float)sum_time_spent/n;
        avg_waiting=(float)sum_waiting/n;
        System.out.println("Average time spent by customer in server is "+avg_time_spent);
        System.out.println("Average time spent by customer in queue waiting is "+avg_waiting);
        System.out.println("Total idle time of the server is "+sum_idle);
        max_time=sssq[1][8];
        for(i=1;i<=n;i++)
            if(max_time<sssq[i][8])
                max_time=sssq[i][8];
        System.out.println("Maximum time spent in server is "+max_time);
    }
}
