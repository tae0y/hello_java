package BOJ;

import java.util.Scanner;

public class BOJ2629 {
    static int[] weight = null;

    public static void main(String args[]) {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(args[0]);
        int weightNum = sc.nextInt();
        weight = new int[weightNum]; //..30
        for(int i=0; i<weightNum; i++) weight[i] = sc.nextInt(); //..500
        int tamaNum = sc.nextInt();
        int[] tama = new int[tamaNum]; //..7
        for(int i=0; i<tamaNum; i++) tama[i] = sc.nextInt(); //..40000

        for(int tc=0; tc<tamaNum; tc++){
            int target = tama[tc];

            if(tc!=0) System.out.print(" ");
            if(isPossible(target,0, 0)==target){
                System.out.print("Y");
            }else System.out.print("N");
        }

    }

    private static int isPossible(int target, int sum, int pos) {
        //if sum = target, stop
        if(sum==target) return sum;
        else if(pos>=weight.length) return -1;
        int result = -1, cnt = 0;

        //add or subtract given(weight) numbers to make target(tama) number
        //each weight has 3 possibility : 0, +, -
        while(cnt<3 && result<0){
            switch (cnt++){
                case 0:
                    result = isPossible(target, sum, pos+1);
                    break;
                case 1:
                    result = isPossible(target, sum+weight[pos], pos+1);
                    break;
                case 2:
                    result = isPossible(target, sum-weight[pos], pos+1);
                    break;
            }
        }
        return result;
    }
}
