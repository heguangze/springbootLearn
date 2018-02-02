package com.luster.fistIdeaItem;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dell on 2018-2-2.
 */
public class AtomicTest {

    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static Integer a = 0;
    static CountDownLatch countDownLatch;
    static CountDownLatch endLatch;

    public static void main(String[] agrs) {
        long begin = System.currentTimeMillis();
        int threadCount = 10000;
        countDownLatch = new CountDownLatch(threadCount);
        endLatch=new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            Runnable runnable = new MyThread("线程"+i);
            new Thread(runnable).start();
            countDownLatch.countDown();
        }
        try {
            endLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终a的值：" +a);
//        System.out.println("最终atomicInteger的值：" +atomicInteger.get());
        System.out.println("耗时："+(System.currentTimeMillis() - begin));
    }

    public static class MyThread implements Runnable {
        private String name;

        MyThread(String name) {
            this.name=name;
        }

        @Override
        public void run() {
//            System.out.println(this.name+": "+a+" 等待执行");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            synchronized (String.class) {
            a++;
//            }
//            atomicInteger.incrementAndGet();
            endLatch.countDown();
//            System.out.println(this.name+": "+a);
        }
    }

}
