import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by belobster on 16. 9. 9.
 */

class G{

    int vnum; // the number of vertex
    int[][] adj;
    int[][] rst; //result
    int src;
    int c;
    Que q;

    G(int input[][]){
        this.vnum = input.length;
        this.adj = input;
        this.rst = new int[vnum][vnum];
    }

    public void _test(int[][] testCase) throws Exception {
        G m = new G(testCase);

        System.out.println("\n\n"+testCase.toString());
        System.out.println("\n\nBFS");
        m.BFS();

        System.out.println("\n\nDFS");
        m.DFS();
    }

    public void print_Result(int s) throws Exception{

        // 매개변수에 따라 DFS, BFS 호출
        if(s==1){
            this.DFS();
        }
        else if(s==2){
            q = new Que(vnum); // BFS의 경우, 추가적으로 큐 자료구조 필요.
            this.BFS();
        }

        for(int i=0; i<vnum; i++){
            for(int j=0; j<vnum; j++){
                if(j!=0) System.out.print(" ");
                System.out.print(rst[i][j]);
            }
            System.out.println();
        }
    }

    /** 각 정점에 대하여 깊이 우선 탐색을 진행
     * src : 탐색을 시작한 정점
     */
    private void DFS() {
        for(int u=0; u<vnum; u++){
            src = u;
            c = 0;
            DFS_VISIT(u);
        }
    }

    // 깊이 우선 탐색 진행
    private void DFS_VISIT(int u) {
        rst[src][u]=check(u); //gray

        // 재귀 호출
        for(int v=0; v<vnum; v++){
            if(adj[u][v]==1){
                if(rst[src][v]==0) DFS_VISIT(v);
            }
        }
    }

    /** 이 알고리즘은 정점 순회 알고리즘이므로, 연결되어 있는지를 검사하는 데는 부적합..
     * 탐색을 시작한 정점은 무조건 방문했다고 표시되기 때문..
     * rst[src][u] = 1; 그래서 이 코드를 다음과 같이 바꿔줌.
     * 탐색을 시작한 정점 src는, 두 번 방문되어야만 방문되었다고 결과 배열에 표시함.
     */
    private int check(int u) {
        if(u==src) return c++;
        else return 1;
    }

    /**
     *
     * */
    private void BFS() throws Exception{
        int t;
        try{
            // 모든 정점에 대하여 넓이 우선 탐색 실시
            for(src=0; src<vnum; src++){
                q.enque(src);

                // 탐색을 시작한 정점에서, 더는 연결된 정점이 없을 때까지 반복
                while(!q.is_empty()){
                    t = q.deque();
                    for(int i=0; i<vnum; i++){
                        // 인접배열에서 연결된 정점이고, 아직 방문되지 않은 정점일 때
                        if(adj[t][i]==1 && rst[src][i]==0){
                            rst[src][i]=1; // 방문했다고 표시하고
                            q.enque(i); // 큐에 넣어 자식 노드를 탐색하는 기준점으로 삼음
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("QUE_ERR");
        }
    }

}

// 배열 환형큐
class Que{
    int[] arr;
    int rear; //in
    int front; //out

    Que(int n){
        arr = new int[2*n];
        rear = 0;
        front = 0;
    }

    public void enque(int o) throws Exception{
        if(this.is_full()) throw new Exception();
        rear = (rear+1) % arr.length;
        arr[rear] = o;
    }

    public int deque() throws Exception{
        if(this.is_empty()) throw new Exception();
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