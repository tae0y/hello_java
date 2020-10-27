package BOJ;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ1788 {

    public static void main(String args[]) {
        //N을 중간값으로 하는 일차원배열
        //HASH MAP
        //N*2, N/2-1 +1 -1

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0){
            System.out.println(0);
            System.out.println(0);
            return;
        }

        int sign = n/Math.abs(n);
        //HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
        //dp.put(0, 0);
        //dp.put(1, 1);
        //dp.put(-1, 1);
        int[] dp = new int[Math.abs(n)+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=Math.abs(n); i++){
            //dp.put(i, (sign*dp.get(i-1) + dp.get(i-2)) % 1000000000);
            dp[i] = ((sign*dp[i-1]) + dp[i-2]) % 1000000000;
        }

        //int a = dp.get(n);
        int a = dp[Math.abs(n)];
        System.out.println(a/Math.abs(a));
        System.out.println(Math.abs(a) % 1000000000);
    }
}

