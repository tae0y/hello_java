package WEEK;

public class Task13_Card {

    /**
     * 20-07-23 written by solar-beam
     * https://programmers.co.kr/learn/courses/30/lessons/42896
     * */

    public void _test(){
        System.out.println(solution(new int[]{3,2,5}, new int[]{2,4,1})==7);
        System.out.println(solution(new int[]{1,1,1,1,3}, new int[]{2,3,1,1,1})==3);
        System.out.println(solution(new int[]{3,3,1}, new int[]{7,7,1})==0);
    }

    int[][] score;
    public int solution(int[] left, int[] right) {
        score = new int[left.length+1][left.length+1];
        for(int i=0; i<score.length; i++){
            for(int j=0; j<score.length; j++){
                score[i][j]=-1;
            }
        }

        score[0][0]=0;
        for(int j=0; j<left.length; j++){
            for(int i=0; i<left.length; i++){
                if(score[i][j]<0) continue;
                if(left[i]>right[j]){
                    editScore(i, j+1, score[i][j]+right[j]);
                }else{
                    editScore(i, j+1, -1);
                    editScore(i+1,j,score[i][j]);
                    editScore(i+1,j+1,score[i][j]);
                }
            }
        }

        int answer = -1, b = left.length;
        for(int i=0; i<=left.length; i++){
            answer = answer > score[i][b] ? answer : score[i][b];
        }
        System.out.println("answer is "+answer);
        return answer >= 0 ? answer : 0;
    }
    //F(i, j) = max{ F(i-1,j-1), F(i-1,j), F(i,j-1)+right[j-1] }

    private void editScore(int i, int j, int n) {
        score[i][j] = score[i][j] > n ? score[i][j] : n;
    }

}