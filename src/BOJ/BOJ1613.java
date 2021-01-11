package BOJ;
//TODO

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1613 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        ArrayList<Node> tree = new ArrayList<>();

        for(int i=1; i<=n; i++) tree.add(new Node(i));
        for(int i=0; i<k; i++){
            int a = sc.nextInt(), b = sc.nextInt();
            tree.get(a).childIdx.add(b);
            tree.get(b).parentIdx = a;
        }

        int s = sc.nextInt();
        for(int i=0; i<s; i++){
            int src = sc.nextInt(), dest = sc.nextInt();
            Node sNode = tree.get(src);
            Stack<Integer> stk = new Stack<>();

        }
    }

    static class Node{
        int d;
        //int depth;
        ArrayList<Integer> childIdx;
        int parentIdx;

        Node(int d){
            this.d = d;
            childIdx = new ArrayList<>();
        }
    }
}
