import java.util.Scanner;
public class Knapsack01_Greedy {
    static int[] p,wt;
    static int C,n;
    static void knapsack01_Gdy(){
        int i,j;
        int[] itemNo = new int[n+1];
        double[] ratio = new double[n+1];
        for (i = 1; i <= n; i++) {
            itemNo[i] = i;
            ratio[i] = p[i]/wt[i];
        }
        for (i = 1; i < n; i++) {
            for (j = i+1; j < n; j++) {
                if (ratio[i]<ratio[j]) {
                    int temp3 = itemNo[j];
                    itemNo[j]=itemNo[i];
                    itemNo[i]=temp3;
                    double temp = ratio[j];
                    ratio[j]=ratio[i];
                    ratio[i]=temp;
                    int temp1 = p[j];
                    p[j]=p[i];
                    p[i]=temp1;
                    int temp2 = wt[j];
                    wt[j]=wt[i];
                    wt[i]=temp2;
                }
            }
        }
        int c = C,profit=0;
        for (i = 1; i <= n; i++) {
            if (c>=wt[i]) {
                System.out.println("Item"+ itemNo[i] + " ( weight: "+ wt[i]+"  profit: "+p[i]+" is added to knapsack )");
                profit = profit + p[i];
                c = c - wt[i];
            }
        }
        System.out.println("total profit of the item added to knapsack= "+profit);
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
        System.out.println("\n0/1 Knapsack using Greedy method");
        knapsack01_Gdy();
    }
}
