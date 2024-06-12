package knapsackgreedy;
import java.util.*;
public class Knapsackgreedy {
    static int[] wt,pr,item;
    static double[] ratio;
    static int knapsack(int n,int C)
    {
        for (int i = 1; i <n; i++) {
            for (int j = i+1; j < n; j++) {
                if(ratio[i]<ratio[j]){
                    int temp = item[i];
                    item[i] = item[j];
                    item[j] = temp;
                    double temp1 = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp1;
                    int temp2 = pr[i];
                    pr[i] = pr[j];
                    pr[j] = temp2;
                    int temp3 = wt[i];
                    wt[i] =  wt[j];
                    wt[j] = temp3;
                }
            }
        }
        int profit=0;int c =C;
        for(int i=1;i<=n;i++) {
            if(c>=wt[i]){
                System.out.println("item "+ item[i]+" profit "+pr[i]+" weight "+wt[i]);
                profit = profit+pr[i];
                c = c - wt[i];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nos of items: ");
        int n = sc.nextInt();
        wt = new int[n+1];
        pr = new int[n+1];
        item = new int[n+1];
        ratio = new double[n+1];
        System.out.println("enter the weights");
        for (int i=1;i<= n;i++) {
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter the profit");
        for (int i=1;i <=n;i++) {
            pr[i] = sc.nextInt();
        }
        System.out.println("Enter the max capacity");
        int C = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            item[i] = i;
            ratio[i] = pr[i]/wt[i];
        }
        int profit = knapsack(n,C);
        System.out.println("The max profit is "+profit);
    }
    
}
