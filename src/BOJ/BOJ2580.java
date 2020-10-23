package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ2580 {

    public static void main(String args[]) {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(args[0]);
        int[][] input = new int[9][9];
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                input[i][j] = sc.nextInt();
                if(input[i][j]==0) stk.push(i*10+j);
            }
        }
        input = getAnswer(input, stk);
        if(input!=null){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    if(j>0) System.out.print(" ");
                    System.out.print(input[i][j]);
                }
                if(i<8) System.out.println();
            }
            System.out.println(isRight(input));
        }
    }

    public static boolean isRight(int[][] input){
        //chk rowLine
        //chk colLine
        for(int i=0; i<9; i++){
            int[] rowLine = new int[9];
            for(int j=0; j<9; j++){
                if(input[i][j]>0){
                    rowLine[input[i][j]-1] ++;
                }
            }
            for(int c=0; c<9; c++){
                if(rowLine[c]!=1){
                    System.out.println("\nROW ERR "+i);
                    return false;
                }
            }
        }
        for(int j=0; j<9; j++){
            int[] colLine = new int[9];
            for(int i=0; i<9; i++){
                if(input[i][j]>0){
                    colLine[input[i][j]-1] ++;
                }
            }
            for(int c=0; c<9; c++){
                if(colLine[c]!=1) {
                    System.out.println("\nCOL ERR "+j);
                    return false;
                }
            }
        }
        //chk box
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int[] box = new int[9];
                for(int k=i*3; k<i*3+3; k++){
                    for(int t=j*3;t<j*3+3; t++){
                        if(input[k][t]>0) {
                            box[input[k][t] - 1]++;
                        }
                    }
                }
                for(int c=0; c<9; c++){
                    if(box[c]!=1){
                        System.out.println("\nBOX ERR "+i+", "+j);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isPossible(int[][] input, int pos) {
        int row = pos/10, col = pos%10;
        int boxRow = row/3*3, boxCol = col/3*3;

        //chk rowLine
        //chk colLine
        int[] rowLine = new int[9];
        int[] colLine = new int[9];
        for(int i=0; i<9; i++){
            if(input[row][i]>0) rowLine[input[row][i]-1] ++;
            if(input[i][col]>0) colLine[input[i][col]-1] ++;
        }
        //chk box
        int[] box = new int[9];
        for(int i=boxRow; i<boxRow+3; i++){
            for(int j=boxCol; j<boxCol+3; j++){
                if(input[i][j]>0) box[input[i][j] - 1]++;
            }
        }

        for(int i=0; i<9; i++){
            if(rowLine[i]!=1) return false;
            if(colLine[i]!=1) return false;
            if(box[i]!=1) return false;
        }

        return true;
    }

    private static Stack<Integer> getPossible(int[][] input, int pos) {
        Stack<Integer> possible = new Stack<Integer>();
        int row = pos/10, col = pos%10;
        int boxRow = row/3*3, boxCol = col/3*3;

        //chk rowLine
        //chk colLine
        int[] rowLine = new int[9];
        int[] colLine = new int[9];
        for(int i=0; i<9; i++){
            if(input[row][i]>0){
                rowLine[input[row][i]-1] ++;
                if(rowLine[input[row][i]-1] > 1) {
                    return null;
                }
            }
            if(input[i][col]>0){
                colLine[input[i][col]-1] ++;
                if(colLine[input[i][col]-1] > 1) {
                    return null;
                }
            }
        }
        //chk box
        int[] box = new int[9];
        for(int i=boxRow; i<boxRow+3; i++){
            for(int j=boxCol; j<boxCol+3; j++){
                if(input[i][j]>0) {
                    box[input[i][j] - 1]++;
                    if(box[input[i][j]-1] > 1){
                        return null;
                    }
                }
            }
        }

        //chk cross
        for(int i=0; i<9; i++){
            if(rowLine[i]!=0) continue;
            if(colLine[i]!=0) continue;
            if(box[i]!=0) continue;
            possible.push(i+1);
        }
        return possible;
    }

    private static int[][] getAnswer(final int[][] input, Stack<Integer> stk) {
        int[][] result = new int[10][10];
        for(int i=0; i<9; i++){
            System.arraycopy(input[i], 0, result[i], 0, 9);
        }
        int pos = -1;
        while(!stk.isEmpty() && result[9][9]!=1){
            pos = stk.pop();
            int row = pos/10, col = pos%10;
            Stack<Integer> possible;
            possible = getPossible(result, pos);
            if(possible==null){
                //System.out.println("NO POSSIBLE NUMS FOR "+pos);
                stk.push(pos);
                return null;
            }
            while(!possible.isEmpty() && result[9][9]!=1){
                result[row][col] = possible.pop();
                //System.out.println("#"+stk.size()+" @"+pos+" "+result[row][col]);
                int[][] tmp = getAnswer(result, stk);
                if(tmp!=null) result = tmp;

            }
            if(possible.isEmpty() && result[9][9]==0){
                //System.out.println("HAVE DONE POSSIBLE NUMS FOR "+pos);
                stk.push(pos);
                return null;
            }
        }
        result[9][9] = 1;
        //System.out.println("#"+stk.size()+"DONE"); //done
        return result;
    }
}
