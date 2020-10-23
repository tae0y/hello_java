package WEEK;

import java.util.Scanner;

public class Task12_Seoul {

    /**
     * 20-07-23 written by solar-beam
     * https://programmers.co.kr/learn/courses/30/lessons/43104
     */

    public void _test() {
        // array length is 3..100
        // array element is 1..1000000
        System.out.println(solution("3 1650\n" +
                "500 200 200 100\n" +
                "800 370 300 120\n" +
                "700 250 300 90") == 660);
        System.out.println(solution("4 3000\n" +
                "1000 2000 300 700\n" +
                "1100 1900 400 900\n" +
                "900 1800 400 700\n" +
                "1200 2300 500 1200") == 5900);
        System.out.println(solution("3 600\n" +
                "500 150 200 1000\n" +
                "100 835 200 324\n" +
                "200 125 300 900") == 2735);
        System.out.println(solution("3 100\n" +
                "1 1 1 1\n" +
                "99 1000 1 1\n" +
                "1 1 1 1") == 3);
    }

    public int solution(String userInput) {
        int answer = 0;
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(userInput);
        int num = sc.nextInt();
        int K = sc.nextInt();
        int[][] cost = new int[num][4];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 4; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[num][K + 1];
        dp[0][cost[0][0]] = cost[0][1];
        dp[0][cost[0][2]] = cost[0][3];
        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[i][j] == 0) continue;
                if (j + cost[i + 1][0] <= K) {
                    dp[i + 1][j + cost[i + 1][0]] = MAX(dp[i + 1][j + cost[i + 1][0]], dp[i][j] + cost[i + 1][1]);
                    System.out.println((i + 1) + ", " + (j + cost[i + 1][0]) + " = " + dp[i + 1][j + cost[i + 1][0]]);
                }
                if (j + cost[i + 1][2] <= K) {
                    dp[i + 1][j + cost[i + 1][2]] = MAX(dp[i + 1][j + cost[i + 1][2]], dp[i][j] + cost[i + 1][3]);
                    System.out.println((i + 1) + ", " + (j + cost[i + 1][2]) + " = " + dp[i + 1][j + cost[i + 1][2]]);
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= K; j++) {
                if (dp[i][j] == 0) continue;
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        answer = Integer.MIN_VALUE;
        for (int i = K; i >= 0; i--) {
            //if(answer < dp[i]) answer = dp[i];
        }

        System.out.println(answer);
        return answer;
    }

    public int MAX(int x, int y) {
        return x > y ? x : y;
    }

    /*public int solution(String userInput) {
        int answer = 0;
        Scanner sc = new Scanner(userInput);
        int num = sc.nextInt();
        int K = sc.nextInt();
        int[][] cost = new int[num][4];
        for(int i=0; i<num; i++){
            for(int j=0; j<4; j++){
                cost[i][j] = sc.nextInt();
            }
        }

        int[] dp = new int[K+1];
        Stack<Integer> idx = new Stack<>();
        Stack<Integer> buff = new Stack<>();
        idx.push(0);
        for(int i=0; i<num; i++){
            while(!idx.isEmpty()){
                int prevT = idx.pop();
                if((prevT+cost[i][0])<=K && dp[prevT+cost[i][0]] < dp[prevT] + cost[i][1]){
                    dp[prevT+cost[i][0]] = dp[prevT] + cost[i][1];
                    buff.push(prevT+cost[i][0]);
                }
                if((prevT+cost[i][2])<=K && dp[prevT+cost[i][2]] < dp[prevT] + cost[i][3]){
                    dp[prevT+cost[i][2]] = dp[prevT] + cost[i][3];
                    buff.push(prevT+cost[i][2]);
                }
            }
            while(!buff.isEmpty()) idx.push(buff.pop());
        }

        for(int i=0; i<num; i++){
            for(int j=0; j<=K; j++){
                if(dp[i][j]==0) continue;
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=K; i>=0; i--){
            if(dp[i]!=0){
                answer=dp[i];
                break;
            }
        }
        System.out.print(answer);
    }*/
}

