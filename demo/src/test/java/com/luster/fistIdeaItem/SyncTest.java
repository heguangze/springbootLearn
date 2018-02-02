package com.luster.fistIdeaItem;

/**
 * Created by dell on 2018-2-2.
 */
public class SyncTest {
    private static int count;

    public static void main(String[] args){
//        SyncThread syncThread = new SyncThread();
//        Thread thread1 = new Thread(syncThread, "SyncThread1");
//        Thread thread2 = new Thread(syncThread, "SyncThread2");

//        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
//        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");

//        Counter counter = new Counter();
//        Thread thread1 = new Thread(counter, "A");
//        Thread thread2 = new Thread(counter, "B");

//        Thread thread1 = new Thread(new SyncMethodThread(), "SyncThread1");
//        Thread thread2 = new Thread(new SyncMethodThread(), "SyncThread2");

        StaticCounter counter = new StaticCounter();
        Thread thread1 = new Thread(counter, "A");
        Thread thread2 = new Thread(counter, "B");


        thread1.start();
        thread2.start();
    }

    static class SyncThread implements Runnable {

        SyncThread() {
            count = 0;
        }

        public  void run() {
            synchronized(this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public int getCount() {
            return count;
        }
    }

    static class Counter implements Runnable{
        private int count;

        public Counter() {
            count = 0;
        }

        public void countAdd() {
            synchronized(this) {
                for (int i = 0; i < 5; i ++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
        public void printCount() {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " count:" + count);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            if (threadName.equals("A")) {
                countAdd();
            } else if (threadName.equals("B")) {
                printCount();
            }
        }
    }

    static class SyncMethodThread implements Runnable {
        private static int count;

        public SyncMethodThread() {
            count = 0;
        }

        public synchronized static void method() {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void run() {
            method();
        }
    }

    static class StaticCounter implements Runnable{
        private static int count;

        public StaticCounter() {
            count = 0;
        }

        public synchronized static void countAdd() {
                for (int i = 0; i < 5; i ++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }

        //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
        public  static void printCount() {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " count:" + count);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void run() {
            String threadName = Thread.currentThread().getName();
            if (threadName.equals("A")) {
                countAdd();
            } else if (threadName.equals("B")) {
                printCount();
            }
        }
    }
}
