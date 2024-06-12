package tsp;
import java.util.*;
public class Tsp {
    static int MAX=10;
    static Scanner in=new Scanner(System.in);
    public static void main(String args[])
    {
        int cst;
        int cost[][]=new int[MAX][MAX];
        int tour[]=new int[MAX];
        int n;
        System.out.println("Enter the number of Cities");
        n=in.nextInt();
        System.out.println("Enter the cost matrix");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cost[i][j]=in.nextInt();
        for(int i=0;i<n;i++)
            tour[i]=i;
        cst=tspdp(cost,tour,0,n);
        System.out.println("Cost is "+cst);
        System.out.println("Tour : ");
        for(int i=0;i<n;i++)
            System.out.print((tour[i]+1)+ "->");
        System.out.println(tour[0]+1);
        in.close();
    }
    public static int tspdp(int cost[][],int tour[],int start,int n)
    {
        int i,j,k;
        int tmp[]=new int[MAX];
        int mintour[]=new int[MAX];
        int mincost;
        int cst;
        if(start==n-2)
            return cost[tour[n-2]][tour[n-1]]+cost[tour[n-1]][0];
        mincost=999;
        for(i=start+1;i<n;i++)
        {
            for(j=0;j<n;j++)
                tmp[j]=tour[j];
            tmp[start+1]=tour[i];
            tmp[i]=tour[start+1];
            if(((cost[tour[start]][tour[i]])+(cst=tspdp(cost,tmp,start+1,n)))<mincost)
            {
                mincost=(cost[tour[start]][tour[i]])+cst;
                for(k=0;k<n;k++)
                    mintour[k]=tmp[k];
            }
        }
        for(i=0;i<n;i++)
            tour[i]=mintour[i];
        return mincost;
    }
}
