package com.luster.fistIdeaItem;

import java.util.concurrent.CountDownLatch;

public class SynchronizedTest {

    CountDownLatch countDownLatch;
    int unsafeNum = 0;


    private SynchronizedTest(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) {
        int countThread = 3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SynchronizedTest synchronizedTest = new SynchronizedTest(countDownLatch);

        new Thread(() -> {
            synchronizedTest.methodA("runnableA");
        }).start();
        new Thread(() -> {
            synchronizedTest.methodB("runnableB");
        }).start();
        new Thread(() -> {
            synchronizedTest.methodC("runnableC");
        }).start();


//        for (int i = 0; i < countThread; i++) {
//            final int order = i;
//            new Thread(() -> {
//                synchronizedTest.methodB("runnable" + order);
//            }).start();
//        }

        countDownLatch.countDown();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总数：" + synchronizedTest.unsafeNum);
    }

    public  void methodA(String threadName) {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i = 0; i < 1000000; i++) {
            unsafeNum++;
        }
        System.out.println(threadName);
    }

    public synchronized void methodB(String threadName) {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000000; i++) {
            unsafeNum++;
        }
        System.out.println(threadName);
    }

    public synchronized void methodC(String threadName) {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000000; i++) {
            unsafeNum++;
        }
        System.out.println(threadName);
    }

}
