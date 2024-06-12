import java.util.Scanner;

public class DijkstraSP {
    static int[][]wt;
    static int[]prev,visit,dist;
    static int s,n;
    static void dijkstra(){
        int i,j,step,u;
        dist=new int[n+1];
        prev=new int[n+1];
        visit=new int[n+1];
        for(i=1;i<=n;i++){
            dist[i]=0;
            prev[i]=0;
            visit[i]=0;
        }
        for(i=1;i<=n;i++){
            dist[i]=wt[s][i];
            if(dist[i]==99){
                prev[i]=0;
            }
            else{
                prev[i]=s;
            }
        }
        visit[s]=1;
        dist[s]=0;
        for(step=2;step<=n;step++){
            u=MinVertex();
            visit[u]=1;
            for(j=1;j<=n;j++){
                if(((dist[u]+wt[u][j])<dist[j])&&visit[j]==0){
                    dist[j]=dist[u]+wt[u][j];
                    prev[j]=u;
                }
            }
        }
        printpath();
    }
    static int MinVertex(){
        int min=99;
        int u=0,i;
        for(i=1;i<=n;i++){
            if((dist[i]<min)&&(visit[i]==0)){
                min=dist[i];
                u=i;
            }
        }
        return u;
    }
    static void printpath(){
        int i,t;
        for(i=1;i<=n;i++){
            if(visit[i]==1&&i!=s){
                System.out.print(s+" to "+i+" :distance= "+ dist[i]+" path: ");
                t=prev[i];
                System.out.print(i);
                while(t!=s){
                    System.out.print("<<--"+t);
                    t=prev[t];
                }
                System.out.println("<<--"+s);
            }
        }
    }
    
    public static void main(String[] args) {
        int i,j;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices in a graph: ");
        n=sc.nextInt();
        wt=new int[n+1][n+1];
        System.out.println("Enter the weight matrix(99 for no edges): ");
        for(i=1;i<=n;i++){
            for(j=1;j<=n;j++){
                wt[i][j]=sc.nextInt();
            }
        }
        System.out.print("Enter the source vertex: ");
        s=sc.nextInt();
        System.out.println("Shortest paths are ");
        dijkstra(); 
        
    }
    
}
