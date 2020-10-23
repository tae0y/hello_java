package BOJ;

import java.util.Scanner;

public class BOJ2661 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(args[0]);
        //Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //1..80, of 1/2/3
        String nums = searchGood("", N);
        System.out.println(nums);
    }

    private static String searchGood(String nums, int n) {
        int pos = nums.length();
        //System.out.println("#"+n+" "+nums);

        //chk repeated pair
        for(int i=1; i<=(pos/2); i++){ //token length
            for(int j=0; j<pos; j++){ //chk pos
                if(j+i <= nums.length() && j+2*i <= nums.length() &&
                        nums.substring(j, j+i).equals(nums.substring(j+i, j+2*i))){
                    return null;
                }
            }
        }

        if(n<=0) return nums;
        //chk next number
        String result = null;
        for(int i=1; i<=3 && result==null; i++){
            result = searchGood(nums+i, n-1);
        }
        return result;
    }

}