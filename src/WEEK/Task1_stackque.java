package WEEK; /**
 * 2020-06-14 by solar-beam
 * https://programmers.co.kr/learn/courses/30/lessons/42588?language=java
 * 스택/큐 연습문제, 신호는 왼쪽으로만 보낼 수 있다
 * */

import java.util.Stack;

public class Task1_stackque {

    public static void _TEST() {
        int[] case1 = {6,9,5,7,4}; solution(case1);
        int[] case2 = {3,9,9,3,5,7,2}; solution(case2);
        int[] case3 = {1,5,3,6,7,6,5}; solution(case3);
    }

    public static int[] solution(int[] heights){
        int[] answer = new int[heights.length];

        //brute-force
        int bf_cnt1 = 0, bf_cnt2=0;
        for(int i=0; i<heights.length; i++){
            bf_cnt1++;
            for(int j=i; j>=0; j--){
                bf_cnt2++;
                if(heights[j]>heights[i]){
                    answer[i]=j+1;
                    break;
                }
            }
        }

        //스택에 담아놨다가 자신보다 큰 탑을 만나면 쏟아놓기
        // * 불변식 : 스택에는 연속하여 작아지는 값들만 입력한다.
        Stack<Integer> cheat = new Stack();
        int st_cnt1=0, st_cnt2=0, st_cnt3=0;
        for(int i = heights.length-1; i>0; i--){
            //스택이 비어있다
            //스택이 차있는데 PICK해보니 크거나 같다
            //스택이 차있는데 PICK해보니 작다
            st_cnt1++;
            while(!cheat.isEmpty()){
                st_cnt2++;
                if(heights[cheat.peek()]>=heights[i]) break;
                st_cnt3++;
                answer[cheat.peek()] = i+1;
                cheat.pop();
            }
            cheat.push(i);
        }

        //빠른스택 Deque : http://tcpschool.com/java/java_collectionFramework_stackQueue
        //직접구현 : https://donghoson.tistory.com/150
        MyStack cheat2 = new MyStack();
        int mst_cnt1=0, mst_cnt2=0, mst_cnt3=0;
        for(int i = heights.length-1; i>0; i--) {
            //스택이 비어있다
            //스택이 차있는데 PICK해보니 크거나 같다
            //스택이 차있는데 PICK해보니 작다
            mst_cnt1++;
            while (!cheat2.isEmpty()) {
                mst_cnt2++;
                if (heights[cheat2.peek()] >= heights[i]) break;
                mst_cnt3++;
                answer[cheat2.peek()] = i + 1;
                cheat2.pop();
            }
            cheat2.push(i);
        }
        //질문
        // 큐 검색시간(log M), 큐 구현시간(n log N), 정렬된 자료구조
        // 힙과 스택은 왜 다른가

        //print
        //for(int i=0; i<answer.length; i++) System.out.print(answer[i]+" ");
        //System.out.println();

        System.out.println("brute force : 외부for("+bf_cnt1+"), 내부for("+bf_cnt2+")");
        System.out.println("stack STL : for("+st_cnt1+"), while("+st_cnt2+"), while 內 if 이하("+st_cnt3+")");
        System.out.println("stack my own : for("+mst_cnt1+"), while("+mst_cnt2+"), while 內 if 이하("+mst_cnt3+")");

        return answer;
    }

    private static class MyStack {
        int[] data;
        int pos;
        int size;

        MyStack(){
            data = new int[1000];
            pos = -1;
            size = 1000;
        }
        MyStack(int stack_size){
            data = new int[stack_size];
            pos = -1;
            size = stack_size;
        }

        boolean isEmpty(){
            return pos<0;
        }

        int peek(){
            if(isEmpty()) return -1;
            return data[pos];
        }

        int pop(){
            if(isEmpty()) return -1;
            return data[pos--];
        }

        int push(int e){
            if(pos+1<size) data[++pos] = e;
            return e;
        }
    }
}
