package BOJ;

import java.util.Scanner;

public class BOJ14502 {
    public static void _test(){
        main(new String[]{"7 7\n" +
                "2 0 0 0 1 1 0\n" +
                "0 0 1 0 1 2 0\n" +
                "0 1 1 0 1 0 0\n" +
                "0 1 0 0 0 0 0\n" +
                "0 0 0 0 0 1 1\n" +
                "0 1 0 0 0 0 0\n" +
                "0 1 0 0 0 0 0"});
        main(new String[]{"4 6\n" +
                "0 0 0 0 0 0\n" +
                "1 0 0 0 0 2\n" +
                "1 1 1 0 0 2\n" +
                "0 0 0 0 0 2"});
        main(new String[]{"8 8\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "2 0 0 0 0 0 0 2\n" +
                "0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0\n" +
                "0 0 0 0 0 0 0 0"});

    }
    public static void main(String[] args){
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }*/
        String[] str = args[0].split(" |\n");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
        int[][] map = new int[n][m];
        for(int i=0, k=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[k++]);
            }
        }

        //새로운 벽은 3개, 0은 빈칸, 1은 벽, 2는 바이러스, 안전영역의 최대값을 구하라 = 감염영역의 최소를 구하라
        //가로세로가 연결된 그래프, 3개 간선만 제거해서, 바이러스가 존재하는 사이클을 최소한으로 만들어라

        //brute-force, 24 C 3(대략 1만2천) * 24 ??
        //minimum-sapnning-tree, graph 24*4, ????????????????????????????



    }
}
