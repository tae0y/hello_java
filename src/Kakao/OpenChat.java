package Kakao;
//https://programmers.co.kr/learn/courses/30/lessons/42888

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChat {
    public void _test() {
        System.out.println(arrayCompare(solution(
                new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}),
                new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}));
    }

    public String[] solution(String[] record) {
        String[][] entities = new String[record.length][3];
        HashMap<String, String> hm = new HashMap<>();

        for(int i=0; i<record.length; i++){
            entities[i] = record[i].split(" ");
            if(entities[i][0].equals("Enter") || entities[i][0].equals("Change")) hm.put(entities[i][1], entities[i][2]);
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            if(entities[i][0].equals("Change")) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(hm.get(entities[i][1]));
            sb.append("님이 ");
            if(entities[i][0].equals("Enter")) sb.append("들어왔습니다.");
            else sb.append("나갔습니다.");
            list.add(sb.toString());
        }
        return list.toArray(new String[]{});
    }

    public boolean arrayCompare(String[] a, String[] b){
        if(a.length != b.length) return false;
        else for(int i=0; i<a.length; i++) if(!a[i].equals(b[i])) return false;
        return true;
    }
}
