import java.util.Scanner;
public class PrimsMST {
    static int[][] wt, edges;
    static int n, cost;
    static void prims() {
        int[] u, lowcost, visited;
        int min, mincost = 0, i, j, v;
        u = new int[n + 1];
        lowcost = new int[n + 1];
        visited = new int[n + 1];
        edges = new int[n * n][3];
        visited[1] = 1;
        for (i = 2; i <= n; i++) {
            visited[i] = 0;
            u[i] = 1;
            lowcost[i] = wt[1][i];
        }
        for (i = 1; i <= n - 1; i++) {
            min = lowcost[2];
            v = 2;
            for (j = 3; j <= n; j++) {
                if (lowcost[j] < min) {
                    min = lowcost[j];
                    v = j;
                }
            }
            edges[i][1] = u[v];
            edges[i][2] = v;
            mincost += lowcost[v];
            visited[v] = 1;
            lowcost[v] = 99;
            for (j = 2; j <= n; j++) {
                if (wt[v][j] < lowcost[j] && visited[j] == 0) {
                    lowcost[j] = wt[v][j];
                    u[j] = v;
                }
            }
            System.out.print("\nIteration with i= " + i + "\nLowcost: ");
            for (int p = 1; p <= n; p++) {
                System.out.print(lowcost[p] + " ");
            }
            System.out.print("\n   u:");
            for (int p = 1; p <= n; p++) {
                System.out.print(u[p] + " ");
            }
        }
        System.out.println("\nEdges of min-cost spanning tree are");
        for (i = 1; i <= n - 1; i++) {
            System.out.print("(" + edges[i][1] + "," + edges[i][2] + ")");
        }
        System.out.println("\nCost of min-cost spanning tree= " + mincost);
    }
        
    public static void main(String[] args) {
        int i, j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        wt = new int[n + 1][n + 1];
        System.out.println("Enter the adjacency matrix of undirected graph as: ");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                wt[i][j] = sc.nextInt();
            }
        }
        prims();
    }
}
      