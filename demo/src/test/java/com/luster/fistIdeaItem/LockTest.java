package com.luster.fistIdeaItem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by luster on 2018-2-27.
 */
public class LockTest {
    private Lock lock = new ReentrantLock(true);  // 注意这个地方:lock被声明为成员变量,公平锁尽量保证等待时间长的线程优先获取锁
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();//读写锁

    public static void main(String[] args) {
        final LockTest test = new LockTest();

        new Thread("A") {
            public void run() {
//                test.testReentrantLock(Thread.currentThread());
                test.get(Thread.currentThread());
        }
        }.start();

        new Thread("B") {
            public void run() {
//                test.testReentrantLock(Thread.currentThread());
//                if(Thread.currentThread().getName().equals("B")){
//                    test.update(Thread.currentThread());
//                }else {
//                    test.get(Thread.currentThread());
//                }
                test.update(Thread.currentThread());
            }
        }.start();
    }
//    public void testReentrantLock(Thread thread){
//        lock.lock();
//        try {
//            System.out.println("线程" + thread.getName() + "得到了锁...");
//            Thread.sleep(100);
//        } catch (Exception e) {
//
//        } finally {
//            System.out.println("线程" + thread.getName() + "释放了锁...");
//            lock.unlock();
//        }
//    }

    public void testReentrantLock(Thread thread) {
        if (lock.tryLock()) {     // 使用 tryLock()
            try {
                System.out.println("线程" + thread.getName() + "得到了锁...");
                Thread.sleep(100);
            } catch (Exception e) {

            } finally {
                System.out.println("线程" + thread.getName() + "释放了锁...");
                lock.unlock();
            }
        } else {
            System.out.println("线程" + thread.getName() + "获取锁失败...");
        }
    }

    public void get(Thread thread) {
        rwl.readLock().lock(); // 在外面获取锁
        try {
            System.out.println("线程" + thread.getName() + "开始读操作...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + thread.getName() + "读操作完毕...");
        } finally {
            rwl.readLock().unlock();
        }
    }

    public void update(Thread thread) {
        rwl.writeLock().lock(); // 在外面获取锁
        try {
            System.out.println("线程" + thread.getName() + "开始写操作...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + thread.getName() + "写操作完毕...");
        } finally {
            rwl.writeLock().unlock();
        }
    }
}
