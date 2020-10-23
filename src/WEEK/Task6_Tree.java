package WEEK;

import java.util.Stack;

public class Task6_Tree {
//https://programmers.co.kr/learn/courses/30/lessons/43163

    public void _test(){
        System.out.println(solution("hit", "cog", new String[]{"hot","dot","dog","lot","log","cog"}) == 4);
        System.out.println(solution("hit", "cog", new String[]{"hot","dot","dog","lot","log"}) == 0);
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        //wordSet with begin word
        String[] wordSet = new String[words.length+1];
        wordSet[0]=begin;
        for(int i=1; i<wordSet.length; i++){
            wordSet[i]=words[i-1];
        }

        //adj matrix
        int[][] adj = new int[wordSet.length][wordSet.length];
        int targetPos = -1;
        for(int i=0; i<wordSet.length; i++){
            if(wordSet[i].equals(target)) targetPos = i;
            for(int j=0; j<wordSet.length; j++){
                adj[i][j] = cmpString(wordSet[i], wordSet[j]);
            }
        }
        if(targetPos<0) return 0;

        //path searching
        int[] chk = new int[wordSet.length];
        chk[0]=1;
        int[] dist = new int[wordSet.length];
        for(int i=1; i<dist.length; i++) dist[i]=Integer.MAX_VALUE;
        Stack<Integer> m = new Stack<>();
        m.add(0);
        while(!m.isEmpty()){
            int cur = m.pop();
            chk[cur]=1;
            for(int i=0; i<wordSet.length; i++){
                if(adj[cur][i]==1 && chk[i]==0){
                    m.add(i);
                    if(dist[cur]+1<dist[i]){
                        dist[i]=dist[cur]+1;
                    }
                }
            }
        }

        return (dist[targetPos]==Integer.MAX_VALUE) ? 0 : dist[targetPos];
    }

    private int cmpString(String word, String word1) {
        int cnt = 0;
        for(int i=0; i<word.length() && cnt<2; i++){
            if(word.charAt(i)!=word1.charAt(i)) cnt++;
        }
        return (cnt == 1) ? 1 : 0;
    }
}