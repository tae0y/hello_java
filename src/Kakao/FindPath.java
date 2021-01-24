package Kakao;
//https://programmers.co.kr/learn/courses/30/lessons/42892

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class FindPath {
    int[][] answer;
    int pre = 0;
    int last = 0;

    public void _test() {
        System.out.println(arrayCompare(
           solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}}),
           new int[][]{{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}}
        ));
        //solution(new int[10000][10000]);
    }

    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++){
            list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        //comparable을 implement한 객체는 그렇지 않은 객체보다 메모리를 많이 잡아먹나보다
        //아래와 같이 콜백함수 형태로 바꿔서 정렬하니 통과함
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y > o2.y) return -1;
                else if(o1.y == o2.y){
                    if(o1.x > o2.x) return -1;
                    else return 1;
                }else return 1;
            }
        });
        //for(int i=0; i<list.size(); i++) System.out.print(list.get(i).x + ", " + list.get(i).y + " / ");

        Tree tree = new Tree(list.get(0));
        for(int i=1; i<list.size(); i++) tree.insert(list.get(i));

        answer = new int[2][nodeinfo.length];
        tree.preOrder(tree.root);
        tree.postOrder(tree.root);
        return answer;
    }

    public boolean arrayCompare(int[][] a, int[][] b){
        if(a.length != b.length) return false;
        else {
            for(int i=0; i<a.length; i++) {
                for(int j=0; j<a[0].length; j++){
                    if(a[i][j] != b[i][j]) return false;
                }
            }
        }
        return true;
    }

    class Tree{
        Node root;

        Tree(Node r){
            root = r;
            answer = null;
        }

        void insert(Node n){
            int key = n.x;
            Node cur = root, prev = cur;
            while(cur!=null){
                prev = cur;
                if(n.x > cur.x) cur = cur.right;
                else cur = cur.left;
            }
            if(n.x > prev.x) prev.right = n;
            else prev.left = n;
        }

        void traverse(int n){
            answer = new int[2][n];
            Stack<Node> stk = new Stack<>();

            //pre-order
            pre = 0;
            stk.push(root);
            while(!stk.isEmpty()){
                Node cur = stk.pop();
                answer[0][pre++] = cur.no;
                if(cur.right!=null) stk.push(cur.right);
                if(cur.left!=null) stk.push(cur.left);
            }

            //post-order
            //with 1 stack : https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
            //with 2 stack : https://www.geeksforgeeks.org/iterative-postorder-traversal/
            last = n - 1;
            stk.empty();
            Stack<Node> sub = new Stack<>();
            stk.push(root);
            while(!stk.isEmpty()){
                Node cur = stk.pop();
                answer[1][last--] = cur.no;
                if(cur.left!=null) stk.push(cur.left);
                if(cur.right!=null) stk.push(cur.right);
            }
        }

        void preOrder(Node node){
            if(node==null) return;
            answer[0][pre++] = node.no;
            if(node.left!=null) preOrder(node.left);
            if(node.right!=null) preOrder(node.right);
        }

        void postOrder(Node node){
            if(node==null) return;
            if(node.left!=null) postOrder(node.left);
            if(node.right!=null) postOrder(node.right);
            answer[1][last++] = node.no;
        }

    }

    static class Node {
        int no;
        int x;
        int y;
        Node left;
        Node right;

        Node(int no, int x, int y){
            this.no = no;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }

    }
}
