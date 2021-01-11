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
        int[] today = new int[24 * 3600000 + 3000];

        //System.out.println("##########################");
        for(int i=0; i<lines.length; i++) {

            String s = lines[i].substring(11, 23);
            String t = lines[i].substring(24).replace("s", "");
            int snum = Integer.parseInt(s.substring(0,2)) * 3600000
                    + Integer.parseInt(s.substring(3,5)) * 60000
                    + Integer.parseInt(s.substring(6,8)) * 1000
                    + Integer.parseInt(s.substring(9,12));
            int tnum = (int) (Float.parseFloat(t) * 1000);
            //System.out.println(tnum);

            int front = (snum - tnum + 1) / 1000 * 1000;
            //if(front!=(snum-tnum+1)) front++;

            int rear = snum / 1000 * 1000;
            if(rear!=snum) rear += 999;

            for(int j = front; j <= rear && j < 86400000 ; j++){
                j+=3000;
                today[j]++; max = today[j] > max ? today[j] : max;
                j-=3000;
            }

            //System.out.println(front + " ( " + (snum-tnum+1) + " " + snum + " ) " + rear);
        }

        //System.out.print(max + " ");
        return max;
    }

}
