package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

import java.util.Arrays;

/**
 * 有效的字母异位词
 */
public class IsAnagram {

    /**
     * <strong>失败思路1</strong>只是位置变化，思路为 找到char，直接排序，然后比较？
     * <p>
     * 直接算特征扰动值，但是问题是，会有去掉位数然后不同的，这个可以通过绝对干扰来操作，没法解决，干扰的频率没法处理了
     **/


    public boolean isAnagram(String s, String t) {
        if(reNew(s).equals(reNew(t))){
            return true;
        }
        return false;
    }

    private String reNew(String s){
        char[] sC=s.toCharArray();
        Arrays.sort(sC);
        return new String(sC);
    }


}
