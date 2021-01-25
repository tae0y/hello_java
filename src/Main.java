import BOJ.*;
import Kakao.*;
import PRO.PRO42897;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //PRO42897 p = new PRO42897(); System.out.println(p.solution(new int[]{1,2,3,1})==4);
        //BOJ1695 b1 = new BOJ1695(); b1.main(new String[]{});
        //BOJ2482 b = new BOJ2482(); b.main(new String[]{});

        //BOJ1788.main(new String[]{});
        //BOJ1149.main(new String[]{});
        //BOJ11726.main(new String[]{});

        //new ChuseokTraffic()._test();
        /*
        new SecretMap()._test();
        //#1
        System.out.println(Integer.toBinaryString(9|30));
        System.out.println(Integer.toBinaryString(20|1));
        System.out.println(Integer.toBinaryString(28|21));
        System.out.println(Integer.toBinaryString(18|17));
        System.out.println(Integer.toBinaryString(11|28));
        //#2
        System.out.println(Integer.toBinaryString(46|27));
        System.out.println(Integer.toBinaryString(33|56));
        System.out.println(Integer.toBinaryString(33|19));
        System.out.println(Integer.toBinaryString(22|14));
        System.out.println(Integer.toBinaryString(31|14));
        System.out.println(Integer.toBinaryString(50|10));*/

        //new MusicRightNow()._test();
        //new AutoComplete()._test();
        //BOJ14502._test();
        //BOJ1916._test();
        //new OpenChat()._test();

        /*int[] a = new int[]{1,2,3};
        foo(a);
        System.out.println(a[0]);*/
        /*int[][] t = new int[10000][10000];
        int[][] t1 = new int[10000][10000];
        int[][] t2 = new int[10000][10000];
        int[][] t3 = new int[10000][10000];
        int[][] t4 = new int[10000][10000];*/
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space at Main.main(Main.java:45)
        //new FindPath()._test();
        /*long startTime = System.nanoTime();
        //System.gc();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + "ns");*/

        try {
            MetaspaceTest.main(new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void foo(int[] t) {
        t[0] = 100;
    }

}