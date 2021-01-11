package Kakao;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/17681

public class SecretMap {
    public void _test(){
        System.out.println("#1 " + Arrays.equals(solution(5, new int[]{9,20,28,18,11}, new int[]{30,1,21,17,28})
                                        , new String[]{"#####","# # #", "### #", "#  ##", "#####"}));
        System.out.println("#2 " + Arrays.equals(solution(6, new int[]{46,33,33,22,31,50}, new int[]{27,56,19,14,14,10})
                                        , new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "}));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            //십진수를 이진수 문자열로 바꾸는 함수를 이용
            //앞쪽 빈 자리에 0을 채우고, 서로 비교하여 원래지도를 구한다.
            String a = getBinary(arr1[i], n);
            String b = getBinary(arr2[i], n);
            StringBuilder sb = new StringBuilder();

            //OR연산
            for(int j=0; j<n; j++){
                if(a.charAt(j)=='1' || b.charAt(j)=='1') sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        /*for(int i=0; i<n; i++){
            //OR연산
            int bitResult = arr1[i] | arr2[i];

            //십진수를 이진수로 직접 바꾸고
            StringBuffer sb = new StringBuffer();
            while(bitResult>1){
                int digit = bitResult%2;
                if(digit==1) sb.append("#");
                else sb.append(" ");
                bitResult = bitResult >> 1;
            }
            if(bitResult==1) sb.append("#");
            else sb.append(" ");

            //빈 앞자리에 공백을 채워넣는다
            sb = sb.reverse();
            int m = n-sb.length();
            for(int j=0; m>0 && j<m; j++) sb.insert(0, " ");

            answer[i] = sb.toString();
        }*/

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private String getBinary(int in, int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(in));
        int m = n - sb.length();
        for(int i=0; m>0 && i<m; i++) sb.insert(0, "0");
        return sb.toString();
    }

}
