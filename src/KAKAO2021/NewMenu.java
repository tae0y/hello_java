package KAKAO2021;

import java.util.*;

public class NewMenu {
    HashMap<String, Integer> availableCourses;
    int[] maxCourses;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        availableCourses = new HashMap<>();
        maxCourses = course;

        //TODO 이건 순열이지 조합이 아니다..
        for(String o : orders) combination(o, "", 0, o.length());

        //TODO beautify this pasta
        //해시맵에 문자열 길이를 기준으로 나눠담는다
        HashMap<Integer, List<Map.Entry<String, Integer>>> list = new HashMap<>();
        for(int c: course) list.put(c, new ArrayList<>());
        for(Map.Entry<String, Integer> m : availableCourses.entrySet()){
            list.get(m.getKey().length()).add(m);
        }
        //나눠담은 다음에는 반복횟수를 기준으로 정렬한다
        for(int c: course) {
            Collections.sort(list.get(c), new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
        }
        //반복횟수가 최대인 값을 정답 리스트로 옮겨담는다
        for(Map.Entry<Integer, List<Map.Entry<String, Integer>>> m : list.entrySet()){
            List<Map.Entry<String, Integer>> l = m.getValue();
            int max = 0;
            for(Map.Entry<String, Integer> e : l){
                if(max==0) max = e.getValue();
                else if(e.getValue() < max) break;
                if(e.getValue() >= 2) answer.add(e.getKey()); //반복횟수가 두번이면 정답리스트로
            }
        }

        Collections.sort(answer);
        System.out.println(answer.toString());
        return answer.toArray(new String[]{});
    }

    private void combination(String origin, String dest, int depth, int max) {
        if(dest.length() >= max || depth >= origin.length()){
            for(int m : maxCourses) {
                if(dest.length() == m){
                    //순열을 조합으로 바꾸는 긴급복구 코드
                    char[] charArray = dest.toCharArray();
                    Arrays.sort(charArray);
                    StringBuilder sb = new StringBuilder();
                    for(char c : charArray) sb.append(c);
                    String sorted_dest = sb.toString();

                    if(availableCourses.containsKey(sorted_dest)) availableCourses.put(sorted_dest, availableCourses.get(sorted_dest) + 1);
                    else availableCourses.put(sorted_dest, 1);
                }
            }
            return;
        }
        combination(origin, dest+origin.charAt(depth), depth+1, max);
        combination(origin, dest, depth+1, max);
    }

}