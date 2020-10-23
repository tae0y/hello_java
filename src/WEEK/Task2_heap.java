package WEEK;

import java.util.PriorityQueue;

/**
 * 2020-06-18 by solar-beam
 * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
 * 섞인 음식은 사라진다.
 * */

public class Task2_heap {

    public static void _TEST(){
        int[] case1 = {1,2,3,9,10,12};
        System.out.println(solution(case1, 7));
        int[] case2 = {5,3,9,10,12};
        System.out.println(solution(case2, 7));
        int[] case3 = {13,9,10,12};
        System.out.println(solution(case3, 7));
        int[] case4 = {5,3,9,10,12,100,1000,10000,100000,1000000,1000000};
        System.out.println(solution(case4, 1000000000));

    }

    //@scoville : 길이 2이상 1,000,000 이하, 값은 0이상 1,000,000이하
    //@K : 0이상 1,000,000,000이하
    //@fail : -1
    //cheatsheet : https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
    public static int solution(int[] scoville, int K){
        PriorityQueue<Integer> cheat = new PriorityQueue<>();
        int cnt = 0;

        for(int i=0; i<scoville.length; i++){
            cheat.add(scoville[i]);
        }

        int cmp1=-1, cmp2=-1;
        while(cheat.size()>=2){
            cmp1 = cheat.remove();
            cmp2 = cheat.remove();
            if(cmp1>=K && cmp2>=K){
                cheat.add(cmp1);
                cheat.add(cmp2);
                break;
            }
            cnt++;
            cheat.add(cmp1+cmp2*2);
        }

        return (cheat.peek()>=K) ? cnt : -1;
    }

}