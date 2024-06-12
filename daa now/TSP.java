import java.util.Scanner;

public class TSP {
    int[][]d;
    int[] visited,finaltour;
    int n,cost;
    void read(){
        Scanner sc=new Scanner(System.in);
        int i,j;
        System.out.println("Enter the total cities: ");
        n=sc.nextInt()+1;
        d=new int[n][n];
        visited=new int[n];
        System.out.println("Enter the distance matrix(99 for no connectivity)");
        for(i=1;i<n;i++){
            for(j=1;j<n;j++){
                d[i][j]=sc.nextInt();
            }
            visited[i]=0;
        }
        finaltour=new int[n];
        for(i=1;i<n;i++){
            finaltour[i]=i;
        }
    }
    void tsp_dyn_prg(){
        cost=tsp_dp(finaltour,1);
        System.out.println("\nTraversal path using dyn. prgmm.:");
        for(int i=1;i<n;i++){
            System.out.print(finaltour[i]+">");
        }
        System.out.println("1");
        System.out.println("Minimum cost= "+cost);
    }
    int tsp_dp(int[]tour,int start){
        int i,j,k;
        int[] temp=new int[n];
        int[]mintour=new int[n];
        int mincost;
        int ccost;
        if(start==n-2){
            return d[tour[n-2]][tour[n-1]]+d[tour[n-1]][1];
        }
        mincost=99;
        for(i=start+1;i<n;i++){
            for(j=1;j<n;j++){
                temp[j]=tour[j];
            }
            temp[start+1]=tour[i];
            temp[i]=tour[start+1];
            if(d[tour[start]][tour[i]]+(ccost=tsp_dp(temp,start+1))<mincost){
                mincost=d[tour[start]][tour[i]]+ccost;
                for(k=1;k<n;k++){
                    mintour[k]=temp[k];
                }
            }
        }
        for(i=1;i<n;i++){
            tour[i]=mintour[i];
        }
        return mincost;
    }

    public static void main(String[] args) {
        TSP t=new TSP();
        t.read();
        t.tsp_dyn_prg();
    }
}
