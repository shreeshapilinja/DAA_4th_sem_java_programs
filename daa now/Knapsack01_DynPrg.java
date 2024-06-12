import java.util.Scanner;
public class Knapsack01_DynPrg {
    static int[] p,wt;
    static int C,n;
    static void knapsack01_DP(){
        int i,j,w;
        int[][] K = new int[n+1][C+1];
        for(i=0;i<=n;i++){
            for(w=0;w<=C;w++){
                if(i==0||w==0){
                    K[i][w]=0;
                }
                else if(wt[i]<=w){
                    K[i][w]=max(p[i]+K[i-1][w-wt[i]],K[i-1][w]);
                }
                else{
                    K[i][w]=K[i-1][w];
                }
            }
        }
        System.out.println("The selected items are: ");
        int c = C;
        int m = n;
        while (m>0) {
            if (K[m][c]!=K[m-1][c]) {
                System.out.println("Item"+ m+ " ( weight: "+wt[m]+"  profit: "+p[m]+" )");
                c=c-wt[m];
            }
            m--;
        }
        System.out.println("Total profit of the items added to knapsack="+K[n][C]);
    }
        static int max(int a,int b){
            return (a>b)?a:b;
        }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nos of items: ");
        n = sc.nextInt();
        System.out.println("Enter the item profits: ");
        p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println("Enter the weights: ");
        wt = new int[n+1];
        for (int i = 1; i <= n; i++) {
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter the max capacity: ");
        C = sc.nextInt();
        System.out.println("\n0/1 Knapsack using Dynamic programmming");
        knapsack01_DP();
    }
}
