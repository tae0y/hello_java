package KAKAO2021;

import java.util.ArrayList;

public class NewID {
    public String solution(String new_id) {
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<new_id.length(); i++) list.add(new_id.charAt(i));

        //1단계
        for(int i=0; i<list.size(); i++){
            if(list.get(i)>=65 && list.get(i)<=90){
                list.set(i, (char)(list.get(i) + 32));
            }
        }

        //2단계
        for(int i=0; i<list.size(); i++){
            char cmp = list.get(i);
            if(cmp == 45 || cmp == 46 || cmp == 95 || cmp >= 48 && cmp <=57 || cmp >= 97 && cmp <=122) continue;
            else {
                list.remove(i);
                i--;
            }
        }

        //3단계
        boolean wasDot = false;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == 46){
                if(wasDot) {
                    list.remove(i);
                    i--;
                }
                wasDot = true;
            }else{
                wasDot = false;
            }
        }

        //4단계
        if(list.size()>0 && list.get(0) == 46) list.remove(0);
        if(list.size()>1 && list.get(list.size()-1) == 46) list.remove(list.size()-1);

        //5단계
        if(list.size()==0) list.add('a');

        //6단계
        if(list.size()>15){
            for(int i=15; i<list.size(); i++){
                list.remove(i);
                i--;
            }
            if(list.size()>1 && list.get(list.size()-1) == 46) list.remove(list.size()-1);
        }

        //7단계
        while(list.size()<3){
            list.add(list.get(list.size()-1));
        }

        //결과제출
        StringBuilder sb = new StringBuilder();
        for(char a : list) sb.append(a);
        return sb.toString();
    }

}
