package BOJ;

import java.util.Scanner;

public class BOJ1695 {
    //참고 : https://js1jj2sk3.tistory.com/45
    //주어진 수열의 앞이나 뒤에 숫자를 추가해가며 가장 숫자를 적게 추가하는 경우를 찾는다
    static int dp[][];
    static int nums[];

    static int func(int x, int y){
        if(x > y) return 0;
        if(dp[x][y] != -1) return dp[x][y];
        if(nums[x]==nums[y]) {
            dp[x][y] = func(x+1, y-1);
            return dp[x][y];
        }
        else {
            dp[x][y] = Math.min(func(x+1, y) + 1, func(x, y-1) + 1);
            return dp[x][y];
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        dp = new int[n][n]; //int dp[n][n];

        for(int i=0; i<n; i++) nums[i] = sc.nextInt();
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) dp[i][j] = -1;

        System.out.println(func(0, n-1));
    }
}
