package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

/**
 * 反转字符串
 */
class ReverseString {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。
     */
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        char[] chars2 = new char[chars.length];

        int i = 0;
        int j = length - 1;
        while (i < length) {
            chars2[j--] = chars[i++];
        }
        return new String(chars2);
    }
}
