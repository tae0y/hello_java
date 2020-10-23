package PRO;

public class PRO42861 {
    public void _test(){
        solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
    }

    public int solution(int n, int[][] cost) {
        int[] dist = new int[n];
        int[] visit = new int[n];

        int[][] adj = new int[n][n];
        for(int i=0; i<cost.length; i++){
            adj[cost[i][0]][cost[i][1]] = cost[i][2];
        }

        for(int i=0; i<n; i++){

        }

        int answer = 0;
        return answer;
    }
}
