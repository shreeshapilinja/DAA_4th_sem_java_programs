package prim;
import java.util.Scanner;
public class Prim
{
    static int n,ne=1,min=999,mincost=0;
    static int visited[]=new int[11];
    static int cost[][]=new int[10][10];
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        n=in.nextInt();
        System.out.println("Enter the cost matrix");
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                cost[i][j]=in.nextInt();
        prim(cost);
    }
    public static void prim(int cost[][])
    {
        int i,j,u=1,v=1;
        while(ne<n)
        {
            min=999;
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
                {
                    if(cost[i][j]<min){
                        min=cost[i][j];
                        u=i;
                        v=j;
                    }
                }
            }
            if((visited[u]==0||visited[v]==0) && u!=v)
            {
                System.out.println("Edge "+u+" to "+v+" with cost "+cost[u][v]);
                mincost=mincost+cost[u][v];
                visited[v]=1;
                ne++;
            }
            cost[u][v]=cost[v][u]=999;
        }
        System.out.println("Total cost is = "+mincost);
    }
}