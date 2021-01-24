package BOJ;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1916 {
    public static void _test(){
        main(new String[]{"5\n" +
                "8\n" +
                "1 2 2\n" +
                "1 3 3\n" +
                "1 4 1\n" +
                "1 5 10\n" +
                "2 4 2\n" +
                "3 4 1\n" +
                "3 5 1\n" +
                "4 5 3\n" +
                "1 5"});
        main(new String[]{"2\n" +
                   "2\n" +
                   "1 2 10\n" +
                   "1 2 20\n" +
                   "1 2"});
        main(new String[]{"2\n" +
                "1\n" +
                "1 2 0\n" +
                "1 2"});

    }
    public static void main(String[] args){
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1, m = sc.nextInt();
        int[][] adj = new int[n][n];
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) adj[i][j] = -1;
        for(int i=0; i<m; i++){
            int src = sc.nextInt(), dest = sc.nextInt(), cost = sc.nextInt();
            if(adj[src][dest] != -1) adj[src][dest] = adj[src][dest] < cost ? adj[src][dest] : cost;
            else adj[src][dest] = cost;
        }
        int src = sc.nextInt(), dest = sc.nextInt();*/

        String[] str = args[0].split(" |\n");
        int n = Integer.parseInt(str[0])+1, m = Integer.parseInt(str[1]);
        int[][] adj = new int[n][n];
        int k=2;
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) adj[i][j] = -1;
        for(int i=0; i<m; i++){
            int src = Integer.parseInt(str[k++]);
            int dest = Integer.parseInt(str[k++]) ;
            int cost = Integer.parseInt(str[k++]);
            if(adj[src][dest] != -1) adj[src][dest] = adj[src][dest] < cost ? adj[src][dest] : cost;
            else adj[src][dest] = cost;
        }
        int src = Integer.parseInt(str[k++]);
        int dest = Integer.parseInt(str[k++]);


        int[] dist = new int[n], chk = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        int cur = src;
        while(chk[dest]==0){
            for(int i=0; i<n; i++){
                if(chk[cur] == 0 && adj[cur][i]!=-1 && dist[i] > dist[cur]+adj[cur][i]) {
                    dist[i] = dist[cur] + adj[cur][i];
                }
            }
            chk[cur]++;
            int min = Integer.MAX_VALUE, idx = -1;
            for(int i=0; i<n; i++){
                if(cur == i || chk[i] != 0) continue;
                if(min > dist[i]){min = dist[i]; idx = i;}
            }
            cur = idx;
        }

        System.out.println(dist[dest]);
    }

}
