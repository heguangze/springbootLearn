package com.luster.fistIdeaItem;

public class VisiblleTest extends Thread {
    private volatile boolean quit = false;

    @Override
    public void run() {
        while (!quit) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(quit);
        }
        System.out.println("done!");
    }

    public void shutdown() {
        quit = true;
    }

    public static void main(String[] args){
        VisiblleTest runner=new VisiblleTest();
        runner.start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runner.shutdown();

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
