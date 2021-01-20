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
    }
    public static void main(String[] args){
        /*String[] str = args[0].split(" |\n");
        int n = Integer.parseInt(str[0])+1, m = Integer.parseInt(str[1]);
        int[][] adj = new int[n][n];
        int k=2;
        for(int i=0; i<m; i++){
            int src = Integer.parseInt(str[k++]);
            int dest = Integer.parseInt(str[k++]) ;
            int cost = Integer.parseInt(str[k++]);
            adj[src][dest] = cost;
            adj[dest][src] = cost;
        }
        int src = Integer.parseInt(str[k++]);
        int dest = Integer.parseInt(str[k++]);*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1, m = sc.nextInt();
        int[][] adj = new int[n][n];
        for(int i=0; i<m; i++){
            int src = sc.nextInt(), dest = sc.nextInt(), cost = sc.nextInt();
            adj[src][dest] = cost;
            //adj[dest][src] = cost;
        }
        int src = sc.nextInt(), dest = sc.nextInt();
        int[] dist = new int[n], chk = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(src);
        while(!stk.isEmpty()){
            int cur = stk.pop();
            for(int i=0; i<n; i++){
                if(chk[cur] == 0 && adj[cur][i]!=0 && dist[i] > dist[cur]+adj[cur][i]) {
                    dist[i] = dist[cur] + adj[cur][i];
                    stk.push(i);
                }
            }
            chk[cur]++;
        }

        System.out.println(dist[dest]);
    }

}
