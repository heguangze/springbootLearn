package com.luster.fistIdeaItem;

public class StringbufferTest {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("a");
        StringBuffer b = new StringBuffer("b");
        appand(a, b);
        System.out.println("a:" + a + ",b:" + b);
    }

    public static void appand(StringBuffer a, StringBuffer b) {
        a.append(b);
        b = a;
    }
}
