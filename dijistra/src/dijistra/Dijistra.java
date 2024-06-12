package dijistra;
import java.util.*;
public class Dijistra {
    static int n;
    static int v[]=new int[10];
    static int d[]=new int[10];
    static int a[][]=new int[10][10];
    public static void dk(int src)
    {
        for(int i=1;i<=n;i++)
        {
            v[i]=0;
            d[i]=a[src][i];
        }
        v[src]=1;
        int x=2,m;
        while(x<=n)
        {
                m=min();
                v[m]=1;
                for(int j=1;j<=n;j++)
                {
                    if((d[m]+a[m][j]<d[j])&&(v[j]==0)&& m!=-1)
                        d[j]=d[m]+a[m][j];
                }
                x++;
        }
        }
        public static int min()
        {
            int min=999,j=-1;
            for(int i=1;i<=n;i++)
                if(d[i]<min&&v[i]==0)
                {
                    min=d[i];
                    j=i;
                }
            return j;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        System.out.println("Enter the cost matrix");
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                a[i][j]=sc.nextInt();
        System.out.println("Enter source node");
        int src=sc.nextInt();
        dk(src);
        for(int j=1;j<=n;j++)
        {
            if(j!=src)
                System.out.println("Cost from "+src+" to "+j+" is  "+d[j]);
        }
    }   
}
