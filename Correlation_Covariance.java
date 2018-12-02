/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correlation_covariance;
import java.util.*;
/**
 *
 * @author ASHISH JAIs
 */
public class Correlation_Covariance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n,i,sumx=0,sumy=0;
        float meanx,meany,sdx,sdy,coveriance,correlation;
        float sumdx=0f,sumdy=0f,sumdxy=0f;
        System.out.println("Enter the number of data values");
        Scanner read=new Scanner(System.in);
        n=read.nextInt();
        int[] x=new int[n];
        int[] y=new int[n];
        System.out.println("Enter the values of x");
        for(i=0;i<n;i++){
            x[i]=read.nextInt();
            sumx=sumx+x[i];
        }
        meanx=(float)sumx/n;
        System.out.println("Enter the values of y");
        for(i=0;i<n;i++){
            y[i]=read.nextInt();
            sumy+=y[i];
        }
        meany=(float)sumy/n;
        for(i=0;i<n;i++)
        {
            sumdx+=(float)Math.pow((x[i]-meanx),2);
            sumdy+=(float)Math.pow((y[i]-meany),2);
            sumdxy+=(float)(x[i]-meanx)*(y[i]-meany);
        }
        sdx=(float)Math.sqrt(sumdx/(n-1));
        sdy=(float)Math.sqrt(sumdy/(n-1));
        coveriance=sumdxy/(n-1);
        correlation=coveriance/(sdx*sdy);
        System.out.println("The coveriance is "+coveriance+" and correlation is "+correlation);
        
    }
    
}
