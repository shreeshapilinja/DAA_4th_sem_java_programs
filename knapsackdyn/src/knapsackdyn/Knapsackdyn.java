package knapsackdyn;
import java.util.*;
public class Knapsackdyn {
    static int[] wt,pr;
    static int knapsack(int n,int m)
    {
        if(n==0||m==0)
            return 0;
        else if(wt[n]>m)
            return knapsack(n-1,m);
        else
            return Math.max(knapsack(n-1,m),pr[n]+knapsack(n-1,m-wt[n]));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nos of items: ");
        int n = sc.nextInt();
        wt = new int[n+1];
        pr = new int[n+1];
        System.out.println("enter the weights");
        for (int i=1;i<= n;i++) {
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter the profit");
        for (int i=1;i <=n;i++) {
            pr[i] = sc.nextInt();
        }
        System.out.println("Enter the max capacity");
        int m = sc.nextInt();
        int profit = knapsack(n,m);
        System.out.println("The max profit is "+profit);
    }
    
}
