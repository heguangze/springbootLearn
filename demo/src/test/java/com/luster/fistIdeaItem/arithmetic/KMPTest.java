package com.luster.fistIdeaItem.arithmetic;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Created by dell on 2018-1-18.
 * KMP字符串匹配算法
 */
public class KMPTest {
    public static int kmp(String str, String dest, int[] next) {//str文本串  dest 模式串
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return 0;
    }

    public static int[] kmpnext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String a = "abcfabceabc";
        String b = "ssdfgasdbababa";
        int[] next = kmpnext(a);
        int res = kmp(b, a, next);
        System.out.println("match:" + res);
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + "  ");
        }
        System.out.println("\nnext'length:" + next.length);
        System.out.println(ansi().eraseScreen()
                .fg(Ansi.Color.RED).a("RED")
                .fg(Ansi.Color.BLACK).a(" BLACK")
                .fg(Ansi.Color.BLUE).a(" BLUE")
                .fg(Ansi.Color.CYAN).a(" CYAN")
                .fg(Ansi.Color.MAGENTA).a(" MAGENTA")
                .fg(Ansi.Color.WHITE).a(" WHITE")
                .fg(Ansi.Color.YELLOW).a(" YELLOW")
                .fg(Ansi.Color.GREEN).a(" GREEN")
                .fg(Ansi.Color.DEFAULT).a(" DEFAULT")
                .reset());
    }
}
