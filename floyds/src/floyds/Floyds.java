package floyds;
import java.util.*;
public class Floyds {
    static int[][] cost;
    static int n;
    static void floyds(){
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    cost[i][j] = Math.min(cost[i][j],cost[i][k]+cost[k][j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nos of vertices");
        n = sc.nextInt();
        cost = new int[n+1][n+1];
        System.out.println("Enter the cost matrix");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        floyds();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
