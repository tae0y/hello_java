package Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MusicRightNow {
    public void _test(){
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}).equals("HELLO"));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}).equals("FOO"));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}).equals("WORLD"));
    }

    final int HASHSIZE = 100357;
    HashMap<String, String> hm = new HashMap<>();
    {
        hm.put("C", "a");
        hm.put("C#", "b");
        hm.put("D", "c");
        hm.put("D#", "d");
        hm.put("E", "e");
        hm.put("E#", "m");
        hm.put("F", "f");
        hm.put("F#", "g");
        hm.put("G", "h");
        hm.put("G#", "i");
        hm.put("A", "j");
        hm.put("A#", "k");
        hm.put("B", "l");
    }

    public String solution(String m, String[] musicinfos) {
        ArrayList<Music> answer = new ArrayList<Music>();//beautify code string
        StringBuilder sb4m = new StringBuilder();
        for(int i=0; i<m.length(); ){
            if(i+1 < m.length() && m.charAt(i+1)=='#'){
                sb4m.append(hm.get(""+m.charAt(i)+m.charAt(i+1)));
                i+=2;
            }else{
                sb4m.append(hm.get(""+m.charAt(i)));
                i+=1;
            }
        }
        String key = sb4m.toString();

        for(int i=0; i<musicinfos.length; i++){
            String[] split = musicinfos[i].split(",");

            //get playtime
            String[] b = split[0].split(":");
            String[] e = split[1].split(":");
            int begin = Integer.parseInt(b[0]) * 60 + Integer.parseInt(b[1]);
            int end = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
            int playtime = end - begin;

            //get music code
            StringBuilder sbtmp = new StringBuilder();
            for(int j=0; j<split[3].length(); ){
                if(j+1 < split[3].length() && split[3].charAt(j+1)=='#'){
                    sbtmp.append(hm.get(""+split[3].charAt(j)+split[3].charAt(j+1)));
                    j+=2;
                }else{
                    sbtmp.append(hm.get(""+split[3].charAt(j)));
                    j+=1;
                }
            }
            String convertedCode = sbtmp.toString();
            StringBuilder code = new StringBuilder();
            if(convertedCode.length()!=0) for(int j=0; j<playtime; j++) code.append(convertedCode.charAt(j % convertedCode.length()));
            String repeatedCode = code.toString();

            if(repeatedCode.contains(key)){
                answer.add(new Music(i, playtime, repeatedCode, split[2]));
            }
        }

        //for(int i=0; i<answer.size(); i++) System.out.println(answer.get(i).title + " " + answer.get(i).code);
        Collections.sort(answer);
        //for(int i=0; i<answer.size(); i++) System.out.println(answer.get(i).title + " " + answer.get(i).code);

        if(answer.size()<1) return "(None)";
        else return answer.get(0).title;
    }

    class Music implements Comparable<Music> {
        int no;
        int playtime;
        String code;
        String title;

        Music(int no, int playtime, String code, String title){
            this.no = no;
            this.playtime = playtime;
            this.code = code;
            this.title = title;
        }

        @Override
        public int compareTo(Music o) {
            if(this.playtime > o.playtime) return -1;
            else if(this.playtime == o.playtime) {
                if(this.no < o.playtime) return 1;
                else return -1;
            }
            else return 1;
        }
    }
}
