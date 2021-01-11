package Kakao;

//https://programmers.co.kr/learn/courses/30/lessons/17676

public class ChuseokTraffic {

    public void _test(){
        System.out.println(solution(new String[]{"2016-09-15 00:00:00.000 3s"})==1);
        System.out.println(solution(new String[]{"2016-09-15 23:59:59.999 0.001s"})==1);
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"})==1);
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"})==2);
        System.out.println(solution(new String[]{"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
                                                "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
                                                "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
                                                "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
                                                "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"})==7);
        System.out.println(solution(new String[]{"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"})==1);

    }

    public int solution(String[] lines) {
        int[][] milis = new int[lines.length][2];
        int max = Integer.MIN_VALUE;

        //밀리세컨드로 바꿔풀기
        //잘못된 접근 : floor, ceiling해서 초당 처리횟수를 구하자
        //올바른 접근
        // - task1이 1.001초에 끝나고 task2가 2.001초에 시작하면 초당 1개 수행
        // - task1이 1.002초에 끝나고 task2가 2.001초에 시작하면 초당 2개 수행
        for(int i=0; i<lines.length; i++) {
            String s = lines[i].substring(11, 23);
            String t = lines[i].substring(24).replace("s", "");
            int snum = Integer.parseInt(s.substring(0,2)) * 3600000
                    + Integer.parseInt(s.substring(3,5)) * 60000
                    + Integer.parseInt(s.substring(6,8)) * 1000
                    + Integer.parseInt(s.substring(9,12));
            int tnum = (int) (Float.parseFloat(t) * 1000);

            milis[i][0] = snum - tnum + 1;
            milis[i][1] = snum;
            //System.out.println(milis[i][0] +" "+milis[i][1]);
        }

        //https://medium.com/@dltkddud4403/2018-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EB%B8%94%EB%9D%BC%EC%9D%B8%EB%93%9C-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B6%94%EC%84%9D-%ED%8A%B8%EB%9E%98%ED%94%BD-450067ce84a8
        for(int i=0; i<milis.length; i++){
            int begin = milis[i][1];
            int end = begin + 999;
            int tmp = 0;
            for(int j=i; j<milis.length; j++){
                if(milis[j][1]>=begin && milis[j][0]<=end) tmp++;
            }
            max = max > tmp ? max : tmp;
        }

        /*
        //초단위로 풀기, damn double
        int[][] milis = new int[lines.length][2];
        int max = Integer.MIN_VALUE;
        int[] today = new int[24 * 3600 + 3 + 1];

        System.out.println("##########################");
        for(int i=0; i<lines.length; i++) {
            String s = lines[i].substring(11, 23);
            String t = lines[i].substring(24).replace("s", "");
            double snum = Integer.parseInt(s.substring(0,2)) * 3600
                    + Integer.parseInt(s.substring(3,5)) * 60
                    + Integer.parseInt(s.substring(6,8))
                    + (double)Integer.parseInt(s.substring(9,12)) / 1000;
            double tnum = Float.parseFloat(t);
            //System.out.println(tnum);

            double left = Math.floor(snum-tnum+0.001);
            double right = Math.ceil(snum);
            if(right!=snum) right-=0.001;
            for(int j=(int)left; j<=right; j++){
                j+=3;
                today[j]++; max = today[j] > max ? today[j] : max;
                j-=3;
            }
            System.out.println(left + " ( " + (snum-tnum+0.001) + " " + snum + " ) " + right);
        }
        */

        //System.out.print(max + " ");
        return max;
    }

}
