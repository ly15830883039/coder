package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeTest {


    private String s;

    private boolean result;

    private IsPalindrome isPalindrome=new IsPalindrome();


    @Test
    void case1() {
        s="A man, a plan, a canal: Panama";
        result=true;
    }

    @Test
    void case2() {
        s="race a car";
        result=false;
    }

    @Test
    void case3() {
        s="   ";
        result=true;
    }

    @Test
    void case4() {
        s=".,";
        result=true;
    }

    @Test
    void case5() {
        s="a.";
        result=true;
    }


    @Test
    void case6() {
        s="\"Sue,\" Tom smiles, \"Selim smote us.\"";
        result=true;
    }

    @AfterEach
    void tearDown() {
        assertSame(result,isPalindrome.isPalindrome(s));
    }
}