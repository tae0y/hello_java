package WEEK;

import java.util.*;

/**
 * 20202-06-27 written by solar-beam
 * https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
 * */

public class Task3_BestAlbum {

    public void _test() {
        System.out.println("TEST RESULT");

        String[] c1_g = {"classic", "pop", "classic", "classic", "pop"};
        int[] c1_num = {500, 600, 150, 800, 2500};
        int[] r1 = solution(c1_g, c1_num);
        System.out.println(AlgoUtil.array_comp(r1, new int[]{4,1,3,0}));
        AlgoUtil.print_array(r1);

        String[] c2_g = {"classic", "pop", "classic", "podo", "pop", "orange"};
        int[] c2_num = {500, 600, 150, 800, 2500, 5000};
        int[] r2 = solution(c2_g, c2_num);
        System.out.println(AlgoUtil.array_comp(r2, new int[]{5,4,1,3,0,2}));
        AlgoUtil.print_array(r2);
    }

    public int[] solution(String[] genres, int[] plays) {
        Hashtable<String, SongBucket> ht = new Hashtable<>();
        for(int i=0; i<genres.length; i++){
            if(ht.containsKey(genres[i])) ht.replace(genres[i], ht.get(genres[i]).addSong(new Song(i, plays[i])));
            else ht.put(genres[i], new SongBucket().addSong(new Song(i, plays[i])));
        }
        LinkedList<Map.Entry<String, SongBucket>> list = new LinkedList<>(ht.entrySet());
        list.sort(new Comparator<Map.Entry<String, SongBucket>>() {
            @Override
            public int compare(Map.Entry<String, SongBucket> o1, Map.Entry<String, SongBucket> o2) {
                return o1.getValue().sum >= o2.getValue().sum ? -1 : 1;
            }
        });
        ArrayList<Integer> tmp_answer = new ArrayList<>();
        while(!list.isEmpty()){
            Map.Entry<String, SongBucket> tmp = list.get(0); list.remove(0);
            int cnt = 0;
            while(!tmp.getValue().list.isEmpty() && cnt < 2){
                tmp_answer.add(tmp.getValue().list.poll().id);
                cnt++;
            }
        }
        int[] answer = new int[tmp_answer.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = tmp_answer.remove(0);
        }
        return answer;
    }

    public class SongBucket{
        int sum;
        PriorityQueue<Song> list;
        SongBucket(){
            this.sum = 0;
            list = new PriorityQueue<>();
        }
        public SongBucket addSong(Song s){
            list.add(s);
            sum += s.num;
            return this;
        }
    }

    public class Song implements Comparable<Song>{
        int id;
        int num;
        Song(int id, int num){
            this.id=id;
            this.num=num;
        }
        @Override
        public int compareTo(Song o) {
            if(this.num - o.num == 0) return (this.id > o.id) ? -1 : 1;
            else return (this.num - o.num > 0) ? -1 : 1;
        }
    }
}