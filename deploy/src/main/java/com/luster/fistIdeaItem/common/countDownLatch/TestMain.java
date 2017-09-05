package com.luster.fistIdeaItem.common.countDownLatch;

/**
 * Created by dell on 2017-7-12.
 * 测试类
 */
public class TestMain {
    public static void main(String[] args)
    {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);
    }
}
