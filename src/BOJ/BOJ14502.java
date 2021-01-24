package BOJ;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ14502 {
    public static void _test(){
        main(new String[]{"7 7\n" +"2 0 0 0 1 1 0\n" +"0 0 1 0 1 2 0\n" +"0 1 1 0 1 0 0\n" +"0 1 0 0 0 0 0\n" +"0 0 0 0 0 1 1\n" +"0 1 0 0 0 0 0\n" +"0 1 0 0 0 0 0"});
        main(new String[]{"4 6\n" +"0 0 0 0 0 0\n" +"1 0 0 0 0 2\n" +"1 1 1 0 0 2\n" +"0 0 0 0 0 2"});
        main(new String[]{"8 8\n" +"2 0 0 0 0 0 0 2\n" +"2 0 0 0 0 0 0 2\n" +"2 0 0 0 0 0 0 2\n" +"2 0 0 0 0 0 0 2\n" +"2 0 0 0 0 0 0 2\n" +"0 0 0 0 0 0 0 0\n" +"0 0 0 0 0 0 0 0\n" +"0 0 0 0 0 0 0 0"});
    }

    public static void main(String[] args){
        //사용자입력
        //System.out.println("###################################");
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] map = new int[n][m];
        int wallcnt = 0;
        ArrayList<Coordi> viruspos = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==2) viruspos.add(new Coordi(i, j));
                if(map[i][j]==1) wallcnt++;
            }
        }*/
        String[] str = args[0].split(" |\n");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
        int[][] map = new int[n][m];
        int wallcnt = 0;
        ArrayList<Coordi> viruspos = new ArrayList<>();
        for(int i=0, k=2; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[k++]);
                if(map[i][j]==2) viruspos.add(new Coordi(i, j));
                if(map[i][j]==1) wallcnt++;
            }
        }

        //새로운벽을 세우는 경우의 수
        //brute-force, 24 C 3(대략 1만2천) * 24
        ArrayList<Wrapper> combi = new ArrayList<>();
        for(int i=0; i<n*m; i++){
            if(map[i/m][i%m]!=0) continue;
            for(int j=i+1; j<n*m; j++){
                if(map[j/m][j%m]!=0) continue;
                for(int k=j+1; k<n*m; k++){
                    if(map[k/m][k%m]!=0) continue;
                    combi.add(new Wrapper(new Coordi(i/m, i%m), new Coordi(j/m, j%m), new Coordi(k/m, k%m)));
                }
            }
        }

        //각각 경우에서 BFS로 바이러스감염확산
        int min = Integer.MAX_VALUE;
        for(int i=0; i<combi.size(); i++){
            int[][] step = new int[n][m];
            for(int r=0; r<n; r++) for(int c=0; c<m; c++) step[r][c] = map[r][c];
            Wrapper w = combi.get(i);
            step[w.first.row][w.first.col] = 1;
            step[w.second.row][w.second.col] = 1;
            step[w.third.row][w.third.col] = 1;

            int count = viruspos.size();
            for(int j=0; j<viruspos.size(); j++){
                Stack<Coordi> stk = new Stack<Coordi>();
                stk.push(viruspos.get(j));
                while(!stk.isEmpty()){
                    Coordi cur = stk.pop();
                    int row = cur.row, col = cur.col;
                    if(chk(row-1, col, n, m) && step[row-1][col]==0) {
                        step[row-1][col]=2;
                        count++;
                        stk.push(new Coordi(row-1, col));
                    }
                    if(chk(row+1, col, n, m) && step[row+1][col]==0) {
                        step[row+1][col]=2;
                        count++;
                        stk.push(new Coordi(row+1, col));
                    }
                    if(chk(row, col-1, n, m) && step[row][col-1]==0) {
                        step[row][col-1]=2;
                        count++;
                        stk.push(new Coordi(row, col-1));
                    }
                    if(chk(row, col+1, n, m) && step[row][col+1]==0) {
                        step[row][col+1]=2;
                        count++;
                        stk.push(new Coordi(row, col+1));
                    }
                }
            }

            int p = min;
            min = min < count ? min : count;
            /*if(p!=min)
            {
                System.out.print("#"+ min + " : ");
                System.out.print(w.first.row+" "+w.first.col+", ");
                System.out.print(w.second.row+" "+w.second.col+", ");
                System.out.print(w.third.row+" "+w.third.col+"\n");

                for(int r=0; r<n; r++){
                    for(int c=0; c<m; c++){
                        System.out.print(step[r][c]+ " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }*/

        }

        //출력
        //System.out.println((n*m) + " " + (wallcnt+3) + " " + min + " = " + (n*m - wallcnt - 3 - min)+"\n");
        System.out.println((n*m - wallcnt - 3 - min));
    }

    private static boolean chk(int row, int col, int n, int m) {
        return !(row < 0 || row >=n || col < 0 || col >=m);
    }

    static class Wrapper{
        Coordi first;
        Coordi second;
        Coordi third;
        Wrapper(Coordi f, Coordi s, Coordi t){
            first = f;
            second = s;
            third = t;
        }
    }

    static class Coordi{
        int row;
        int col;
        Coordi(int r, int c){
            row = r;
            col = c;
        }
    }
}
