package WEEK;

public class Task4_Tree {

    /**
     * 2020-07-07 written by solar-beam
     * https://programmers.co.kr/learn/courses/30/lessons/43165
     * */

    public void _test(){
        System.out.println(solution(new int[]{1,1,1,1,1},3)==5);
        System.out.println(solution(new int[]{1,2},3)==1);
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        int[] tmp = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            copyArr(tmp, numbers);
            MyStack m = getSign(tmp.length, i);
            if(getArrSum(tmp, m)==target) answer++;
        }
        return answer;
    }

    private MyStack getSign(int idxMax, int i) {
        MyStack m = new MyStack(idxMax);
        if(i==0) return m;
        /* 배열인덱스 중 i개를 골라서 반환 */
        return m;
    }

    private void copyArr(int[] tmp, int[] numbers) {
        for(int i=0; i<tmp.length; i++) tmp[i]=numbers[i];
    }

    private int getArrSum(int[] tmp, MyStack m) {
        int sum=0;
        while(!m.isEmpty()){
            tmp[m.pop()]*=-1;
        }
        for(int a : tmp) sum+=a;
        return sum;
    }

    //배열 스택
    class MyStack{
        int[] arr;
        int pos;

        MyStack(int SIZE){
            this.arr = new int[SIZE];
            pos = -1;
        }

        public boolean isEmpty(){
            return (pos < 0);
        }

        public boolean isFull(){
            return (pos >= arr.length);
        }

        public void push(int x) throws IndexOutOfBoundsException{
            if(isFull()) throw new IndexOutOfBoundsException();
            arr[++pos] = x;
        }

        public int peek() throws IndexOutOfBoundsException{
            if(isEmpty()) throw new IndexOutOfBoundsException();
            return arr[pos];
        }

        public int pop() throws IndexOutOfBoundsException{
            if(isEmpty()) throw new IndexOutOfBoundsException();
            return arr[pos--];
        }

        public void removeAll(){
            pos = -1;
        }
    }
}