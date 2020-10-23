package WEEK;

import java.util.ArrayList;

/**
 * 2020-06-30 written by solar-beam
 * BFS & DFS
 * */

public class MyGraph {
    int vnum;
    int[][] adj;
    ArrayList<Integer> list;

    MyGraph(int adj[][]){
        this.adj = adj;
        this.vnum = adj.length;
        this.list = new ArrayList<>();
    }

    public void _test(){
        int[][] testCase = {{0,1,0,0,1},{1,0,1,1,1},{0,1,0,1,0},{0,1,1,0,1},{1,1,0,1,0},};
        //int[][] testCase = {{0,1,0,0,1},{1,0,1,1,1},{0,1,0,1,0},{0,1,1,0,1},{1,1,0,1,0}};
        MyGraph m = new MyGraph(testCase);

        System.out.println("\n\n"+testCase.toString());
        System.out.println("\n\nBFS");
        m.bfs(0);
        for(int i=0; i<m.vnum; i++) System.out.print(" "+m.list.remove(0));

        System.out.println("\n\nDFS");
        m.dfs(0);
        for(int i=0; i<m.vnum; i++) System.out.print(" "+m.list.remove(0));
    }

    // STACK & DFS
    public void dfs(int s){
        int[] chk = new int[vnum];
        MyStack stk = new MyStack(vnum*vnum);
        list = new ArrayList<>();
        chk[s]++;
        stk.push(s);
        //for(int u=0; u<vnum; u++) if(adj[s][u]==1 && chk[u]==0) dfs(u);
        while(!stk.isEmpty()){
            int cur = stk.pop();
            list.add(cur);
            for(int i=vnum-1; i>0; i--){ //INDEX IS DECREASING
                if(adj[cur][i]==1 && chk[i]==0){
                    chk[i]++;
                    stk.push(i);
                }
            }
        }
    }

    // QUE & BFS
    public void bfs(int s) throws IndexOutOfBoundsException{
        int[] chk = new int[vnum];
        MyQue que = new MyQue(vnum*vnum);
        list = new ArrayList<>();
        chk[s]++;
        que.enque(s);
        while(!que.is_empty()){
            int t = que.deque();
            list.add(t);
            for(int i=0; i<vnum; i++){
                if(adj[t][i]==1 && chk[i]==0){
                    chk[i]++;
                    que.enque(i);
                }
            }
        }
    }
}

// 배열 환형큐
class MyQue{
    int[] arr;
    int rear; //in
    int front; //out

    MyQue(int SIZE){
        arr = new int[SIZE];
        rear = 0;
        front = 0;
    }

    public void enque(int o) throws IndexOutOfBoundsException{
        if(this.is_full()) throw new IndexOutOfBoundsException();
        rear = (rear+1) % arr.length;
        arr[rear] = o;
    }

    public int touchque() throws IndexOutOfBoundsException{
        if(this.is_empty()) throw new IndexOutOfBoundsException();
        return arr[front];
    }

    public int deque() throws IndexOutOfBoundsException{
        if(this.is_empty()) throw new IndexOutOfBoundsException();
        front = (front+1) % arr.length;
        return arr[front];
    }

    public boolean is_empty(){
        return (front == rear);
    }

    public boolean is_full(){
        return ((rear+1)%arr.length == front);
    }
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
}