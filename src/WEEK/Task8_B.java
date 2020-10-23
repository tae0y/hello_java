package WEEK;

public class Task8_B {

    /**
     * 2020-07-19 written by solar-beam
     * https://programmers.co.kr/learn/courses/30/lessons/43238
     * */

    public void _test(){
        System.out.println(solution(6, new int[]{7,10})==28);
        System.out.println(solution(6, new int[]{6,10})==24);
        System.out.println(solution(6, new int[]{8,10})==30);
        System.out.println(solution(6, new int[]{4,10})==20);
        System.out.println(solution(11, new int[]{3,4,10})==18);
        System.out.println(solution(1000, new int[]{1,1,1000})==500);
    }

    public long solution(int n, int[] times) {
        long MAX_TIME = Integer.MIN_VALUE;
        for(int time : times) if(MAX_TIME < time) MAX_TIME = time;
        MAX_TIME*=n;

        long answer = MAX_TIME;
        long low = 0, high = MAX_TIME, mid = 0;
        long sum = 0;
        while(low<=high){
            sum = 0;
            mid = (low+high)/2;
            for(int time : times){
                sum += mid/time;
            }
            System.out.println("low: "+low+", high: "+high+", mid: "+mid+", sum: "+sum);
            if(sum>=n){
                answer = MIN(answer, mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        System.out.println("answer is "+answer);
        return answer;
    }

    public long MIN(long x, long y){
        return x <= y ? x : y;
    }
}