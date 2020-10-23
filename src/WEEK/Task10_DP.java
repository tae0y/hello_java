package WEEK;

public class Task10_DP {
    /**
     * 20-07-23 written by solar-beam
     * https://programmers.co.kr/learn/courses/30/lessons/43104
     * */

    public void _test(){
        //정확도
        System.out.println(solution(5)==26);
        System.out.println(solution(6)==42);
        //시간
        System.out.println(solution(10));
        System.out.println(solution(20));
        System.out.println(solution(40));
        System.out.println(solution(60));
        System.out.println(solution(80));
    }

    public long solution(int N) {
        if(N==1) return 4;

        long startTime = System.nanoTime();
        long x=1, y=1, tmp=0;
        for(int i=0; i<N-2; i++) {
            tmp = x;
            x = x + y;
            y = tmp;
        }

        long endtTime = System.nanoTime();
        System.out.println("T="+(endtTime-startTime));
        return (2*x + y)*2;
    }
}