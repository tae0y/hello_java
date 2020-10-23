package BOJ;

import java.util.Scanner;

public class BOJ2482 {
    static int cnt = 0;
    static int n, k;

    public static void func(int i, int state, int depth){
        if(i >= n ) return;
        if(depth >= k){
            cnt++;
            return;
        }

        if(state==1){
            func(i+2, 1, depth+1);
            func(i+2, 0, depth+1);
        }
        else {
            func(i+1, 1, depth+1);
            func(i+1, 0, depth+1);
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

/*        //재귀로 모든 경우 세기, 중복제거가 안됨
        func(0, 1, 1);
        func(0, 0, 0);
        System.out.println("#1 "+cnt);

        //한칸씩 띄워서 모든 경우의 수 세기, k만족조건 검사가 안됨
        //dp[i] = dp[i-2, 1] + dp[i-1, 0]
        int[][] dp = new int[n][2];
        if(n>=2){
            dp[0][0] = 1;
            dp[0][1] = 1;
            dp[1][0] = 2;
            dp[1][1] = 1;
        }
        for(int i=2; i<n; i++){
            dp[i][1] = dp[i-2][1] + dp[i-1][0];
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
        }
        System.out.println("#2 "+(dp[n-1][0]+dp[n-1][1]));*/


        //참고 : https://akim9905.tistory.com/71
        //경우의수 구하기, dp[n][k] = (n을 칠하는경우)dp[n-2][k-1] + (안칠하는경우)dp[n-1][k]
        //정답 구하기, (n을 칠하는경우)dp[n-3][k-1] + (안칠하는경우)dp[n-1][k]
        //n을 칠한다면, n-1과 0번 자리도 칠하면 안되므로 n-3개중 k-1개를 칠하는 경우의 수와 같다
        //n을 안칠한다면, n-1개중 k개를 칠하는 경우의 수와 같다
        int[][] cheat = new int[n+1][n+1];
        for(int i=0; i<=n; i++){cheat[i][1]=i; cheat[i][0]=1;}
        for(int i=2; i<=n; i++){
            for(int j=2; j<=k; j++){
                cheat[i][j] = (cheat[i-2][j-1] + cheat[i-1][j]) % 1000000003;
            }
        }
        System.out.println((cheat[n-1][k] + cheat[n-3][k-1]) % 1000000003);

    }
}