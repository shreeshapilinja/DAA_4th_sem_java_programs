import java.util.Scanner;
import java.util.Arrays;
public class HamiltonianCycle {
    private int V, pathCount;
    private int[] path;
    private int[][] graph;
    public void findHamiltonianCycle(int[][] g){
        V = g.length;
        path = new int[V];
        Arrays.fill(path, -1);
        graph = g;
        try{
            path[0] = 0; pathCount = 1;
            solve(0);
            System.out.println("No solution");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            display();
        }
    }
    public void solve(int vertex) throws Exception{
        if (graph[vertex][0] == 1 && pathCount == V)
            throw new Exception("Solution found");
        if (pathCount == V)
            return;
        for (int v = 0; v < V; v++){
            if (graph[vertex][v] == 1 ){
                path[pathCount++] = v;
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;
                if (!isPresent(v))
                    solve(v);
                graph[vertex][v] = 1;
                graph[v][vertex] = 1;
                path[--pathCount] = -1;
            }
        }
    }
    public boolean isPresent(int v){
        for (int i = 0; i < pathCount - 1; i++)
            if (path[i] == v)
                return true;
        return false;
    }
    public void display(){
        System.out.print("\nPath : ");
        for (int i = 0; i <= V; i++)
            System.out.print(path[i % V] +" ");
        System.out.println();
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        HamiltonianCycle hc = new HamiltonianCycle();
        System.out.println("Enter number of vertices\n");
        int V = sc.nextInt();
        System.out.println("\nEnter matrix\n");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = sc.nextInt();
        hc.findHamiltonianCycle(graph);
    }
}