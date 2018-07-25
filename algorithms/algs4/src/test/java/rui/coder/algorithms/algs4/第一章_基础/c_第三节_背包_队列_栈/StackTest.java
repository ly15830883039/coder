package rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈.Stack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈.Stack<String> stack;


    @Test
    @DisplayName(" 通过new() 实例化")
    void isInstantiatedWithNew() {
        new rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈.Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            stack = new rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈.Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(NoSuchElementException.class, () -> stack.pop());
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(NoSuchElementException.class, () -> stack.peek());
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {

            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("已经不在空了")
            void isNotEmpty() {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }

    @Test
    void toStringMethod(){
        stack=new java.util.Stack<>();
        List<String> stringList=Stream.generate(() -> "")
                .limit(3)
                .collect(Collectors.toList());


        int j=2;
        for (int i = 0; i < 3; i++) {
            String random=UUID.randomUUID().toString();
            stringList.remove(j);
            stringList.add(j,random);
            stack.push(random);
            j--;
        }

        assertEquals(stringList.toString(),stack.toString());
    }
}