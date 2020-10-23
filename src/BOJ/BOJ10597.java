package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10597 {

    public static void main(String args[]){
        Scanner sc = new Scanner(args[0]);
        //Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); //1..N까지의 수인데 공백없어짐

        /*int sum=0;
        for(int i=1; i<=50; i++){
            if(i>9){
                sum+=2;
                System.out.println("#"+i+", "+sum);
                System.out.println(((sum-9)/2+9)==i);
            }
            else {
                sum+=1;
                System.out.println("#"+i+", "+sum);
                System.out.println(sum==i);
            }
        }*/

        int N = 0;
        if(input.length()>9) N = (input.length()-9)/2 + 9;
        else N = input.length();
        int[] nums = new int[N];
        int[] chk = new int[input.length()];

        int[] answer = findN(input, N, chk);
        for(int i=0; i<input.length(); i++){
            if(i==0) System.out.print(input.charAt(i));
            else if(answer[i]==2) System.out.print(input.charAt(i));
            else System.out.print(" "+input.charAt(i));
        }
    }

    private static int[] findN(String input, int n, int[] chk) {
        if(n<=0) return chk;

        Stack<Integer> stk = new Stack<>();
        String pattern = ""+n;
        for(int j=0; j<input.length(); j++){
            if(chk[j]!=0) continue;
            if(input.charAt(j)==pattern.charAt(0)){
                if(n>=10){
                    if(j+1<input.length() && chk[j+1]==0 &&
                            input.charAt(j+1)==pattern.charAt(1))
                        stk.push(j);
                }else{
                    stk.push(j);
                }
            }
        }

        int[] result = null;
        while(!stk.isEmpty() && result==null){
            int[] tmp = new int[chk.length];
            System.arraycopy(chk, 0, tmp, 0, chk.length);
            if(n>=10){
                tmp[stk.peek()]=1;
                tmp[stk.peek()+1]=2;
                //System.out.println(n+" @"+stk.peek());
                stk.pop();
            }else{
                tmp[stk.peek()]=1;
                //System.out.println(n+" @"+stk.peek());
                stk.pop();
            }
            result = findN(input, n-1, tmp);
        }
        return result;
    }

}