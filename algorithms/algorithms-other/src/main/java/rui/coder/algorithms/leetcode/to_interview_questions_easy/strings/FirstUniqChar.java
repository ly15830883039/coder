package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public int firstUniqChar(String s) {

        Map<Character,Integer> map=new HashMap<>(s.length());

        char[] chars=s.toCharArray();

        int i=0;

        while(i<s.length()){
            char c=chars[i];
            Integer integer=map.get(c);
            if(integer==null){
                if(s.indexOf(c,i+1)==-1){
                    return i;
                }else {
                    map.put(c,1);
                }
            }else{
                map.put(c,++integer);
            }
            i++;
        }
        return -1;
    }
}
