package WEEK;

import java.util.Stack;
//https://programmers.co.kr/learn/courses/30/lessons/43162

public class Task5_Tree {

    public void _test(){
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}) == 2);
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}}) == 1);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] chk = new int[n];
        Stack<Integer> m = new Stack<>();
        for(int i=0; i<n; i++){
            if(chk[i]==1) continue;
            chk[i]=1;
            m.add(i);
            while(!m.isEmpty()){
                int cur = m.pop();
                for(int j=n-1; j>0; j--){ //INDEX IS DECREASING
                    if(computers[cur][j]==1 && chk[j]==0){
                        chk[j]++;
                        m.push(j);
                    }
                }
            }
            answer++;
        }

        return answer;
    }


}