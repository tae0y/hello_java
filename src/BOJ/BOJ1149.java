package BOJ;

import java.util.Scanner;

public class BOJ1149 {
    static int n;
    static int[][] cost;
    static int min;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        {
            n = sc.nextInt();
            cost = new int[n][3];
            min = Integer.MAX_VALUE;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){ //RGB COST
                cost[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][3];
        for(int i=0; i<3; i++) dp[0][i] = cost[0][i];
        for(int i=1; i<n; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + cost[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) min = Math.min(min, dp[n-1][i]);
        System.out.println(min);
    }
}
