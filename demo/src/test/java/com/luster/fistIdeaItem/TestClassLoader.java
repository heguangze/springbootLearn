package com.luster.fistIdeaItem;

public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader c = ClassLoader.getSystemClassLoader();
        System.out.println(c);
        while ((c = c.getParent()) != null) {
            System.out.println(c);
        }
    }

}
