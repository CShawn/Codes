package com.cshawn.codes.leetcodes.sword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class Sword_9Test {
    private Sword_9.CQueue test = new Sword_9().new CQueue();

    @Test
    @DisplayName("空时抛出异常")
    public void test_empty() {
        assertThrows(EmptyStackException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                test.deleteHead();
            }
        });
    }

    @Test
    @DisplayName("添加并删除正常，空时抛出异常")
    public void test_add_delete_empty() {
        test.appendTail(1);
        test.appendTail(2);
        assertEquals(1, test.deleteHead());
        assertEquals(2, test.deleteHead());
        assertThrows(EmptyStackException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                test.deleteHead();
            }
        });
    }

    @Test
    @DisplayName("添加并删除正常，空时抛出异常")
    public void test_add_delete() {
        test.appendTail(1);
        test.appendTail(2);
        assertEquals(1, test.deleteHead());
        test.appendTail(3);
        assertEquals(2, test.deleteHead());
        test.appendTail(4);
        assertEquals(3, test.deleteHead());
        assertEquals(4, test.deleteHead());
        assertThrows(EmptyStackException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                test.deleteHead();
            }
        });
    }
}
