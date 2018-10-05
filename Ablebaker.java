/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablebaker;
import java.util.Scanner;

/**
 *
 * @author ASHISH JAIs
 */
public class Ablebaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n,sum_time_spent=0,sum_waiting=0,max_time,i,j,sum_idle_first=0,sum_idle_second=0;
        float avg_waiting,avg_time_spent,avg_idle_first,avg_idle_second;
        System.out.println("Enter the number of customers");
        Scanner read=new Scanner(System.in);
        n=read.nextInt();
        int[][] sssq=new int[n+1][12];
        System.out.println("Enter the Inter-arrival time of each customer");
        for(i=1;i<=n;i++)
            sssq[i][1]=read.nextInt();
        System.out.println("Enter the service time of each customer");
        for(i=1;i<=n;i++)
            sssq[i][2]=read.nextInt();
        System.out.println("Enter the arrival time of the first customer");
        //Service idle for first request for the first server is arrival time for first customer
        sssq[1][3]=sssq[1][4]=sssq[1][8]=read.nextInt();
        sssq[1][6]=sssq[1][7]=0;//Service begin and end time for the second server on first request is 0.
        for(i=1;i<=12;i++)
            sssq[0][i-1]=i;//Numbering the row
        for(i=1;i<=n;i++){                
            sssq[i][0]=i;//Numbering the column
            //Service end time of the first server for the first request depends only on arrival time
            sssq[1][5]=sssq[1][4]+sssq[1][2];
            if(i>=2){//Because many parameters depends on the value of the previous iteration
                sssq[i][3]=sssq[i-1][3]+sssq[i][1];//Arrrival time
                if(sssq[i-1][5]>sssq[i][3]&&sssq[i-1][7]<sssq[i][3]){
                    sssq[i][6]=sssq[i][3];//Service start time for second server
                    sssq[i][7]=sssq[i][6]+sssq[i][2];//Service end time for second server
                    sssq[i][4]=sssq[i-1][4];sssq[i][5]=sssq[i-1][5];
                    sssq[i][10]=sssq[i][6]-sssq[i][3];//Waiting time for the customer
                    sssq[i][8]=0;sssq[i][9]=sssq[i][6]-sssq[i-1][7];//Server idle time
                }
                else if(sssq[i-1][5]>sssq[i][3]&&sssq[i-1][7]>sssq[i][3]){
                    if(sssq[i-1][5]<sssq[i][7]){
                        sssq[i][4]=sssq[i][3];//Service Begin time for first server
                        sssq[i][5]=sssq[i][4]+sssq[i][2];//Service end time for first server
                        sssq[i][7]=sssq[i-1][7];sssq[i][6]=sssq[i-1][6];
                        sssq[i][10]=sssq[i][4]-sssq[i][3];//Waiting time for the customer
                        sssq[i][9]=0;sssq[i][8]=sssq[i][4]-sssq[i-1][5];}//Server idle time
                    else{
                        sssq[i][6]=sssq[i][3];//Service start time for second server
                        sssq[i][7]=sssq[i][6]+sssq[i][2];//Service end time for second server
                        sssq[i][4]=sssq[i-1][4];sssq[i][5]=sssq[i-1][5];
                        sssq[i][10]=sssq[i][6]-sssq[i][3];//Waiting time for the customer
                        sssq[i][8]=0;sssq[i][9]=sssq[i][6]-sssq[i-1][7];}}//Server idle time
                else{
                    sssq[i][4]=sssq[i][3];//Service Begin time for first server
                    sssq[i][5]=sssq[i][4]+sssq[i][2];//Service end time for first server
                    sssq[i][7]=sssq[i-1][7];sssq[i][6]=sssq[i-1][6];
                    sssq[i][10]=sssq[i][4]-sssq[i][3];//Waiting time for the customer
                    sssq[i][9]=0;sssq[i][8]=sssq[i][4]-sssq[i-1][5];//Server idle time
                }}
            sssq[1][9]=0;//Idle time for second server for first request is considered 0
            sssq[i][11]=sssq[i][10]+sssq[i][2];//Time spent by customer in server
        }
    for(i=1;i<=n;i++){
            sum_waiting=sum_waiting+sssq[i][10];
            sum_time_spent=sum_time_spent+sssq[i][11];
            sum_idle_first=sum_idle_first+sssq[i][8];
            sum_idle_second=sum_idle_second+sssq[i][9];}
        System.out.println("1. Customer \n2. Inter-arrival time");
        System.out.println("3. Service time \n4. Arrival time");
        System.out.println("5. Service Start time for first server \n6. Service end time for first server");
        System.out.println("7. Service Start time for second server \n8. Service end time for second server");
        System.out.println("9. Idle time for first server \n10. Idle time for second server");
        System.out.println("11. Waiting time customer");
        System.out.println("12. Time spent by customer in server");
        System.out.println("The following table shows the data according to the column number mentioned above");
        for(i=0;i<=n;i++){
           for(j=0;j<12;j++)
               System.out.print(sssq[i][j]+" ");
           System.out.println();}
        avg_time_spent=(float)sum_time_spent/n;
        avg_waiting=(float)sum_waiting/n;
        avg_idle_first=(float)sum_idle_first/n;
        avg_idle_second=(float)sum_idle_second/n;
        System.out.println("Average time spent by customer in server is "+avg_time_spent);
        System.out.println("Average time spent by customer in queue waiting is "+avg_waiting);
        System.out.println("Average idle time spent by first server is "+avg_idle_first);
        System.out.println("Average idle time spent by second server is "+avg_idle_second);
        max_time=sssq[1][8];
        for(i=1;i<=n;i++)
            if(max_time<sssq[i][11])
                max_time=sssq[i][11];
        System.out.println("Maximum time spent in server is "+max_time);
    }
    
}
