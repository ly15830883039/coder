package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            char a = chars[i];
            char b = chars[j];

            while ((!isMatch(a))) {
                i++;
                if (i >= chars.length) {
                    return true;
                } else {
                    a = chars[i];
                }
            }

            while ((!isMatch(b))) {
                if (j <= i) {
                    return true;
                }
                j--;
                b = chars[j];

            }
            if (a != b) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isMatch(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }
}
