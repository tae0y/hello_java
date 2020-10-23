package WEEK;

public class Task11_DP {
    /**
     * 20-07-23 written by solar-beam
     * https://programmers.co.kr/learn/courses/30/lessons/43104
     * */

    public void _test(){
        System.out.println(solution(new int[][]{
                {7},
                {3,8},
                {8,1,0},
                {2,7,4,4},
                {4,5,2,6,5}
        })==30);
    }

    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] path = new int[triangle.length][triangle.length];
        path[0][0]=triangle[0][0];
        int left=-1, right=-1;
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j>=triangle[i-1].length) right = -1;
                else right = path[i-1][j];
                if(j-1>=0) left = path[i-1][j-1];
                else left = -1;
                path[i][j] += (MAX(left, right)+triangle[i][j]);
            }
        }

        answer = Integer.MIN_VALUE;
        int b = triangle.length-1;
        for(int i =0 ; i<triangle[b].length; i++){
            answer = answer > path[b][i] ? answer : path[b][i];
        }

        System.out.println("answer is "+answer);
        return answer;
    }

    public int MAX(int x, int y){
        return x>=y ? x:y;
    }
}
