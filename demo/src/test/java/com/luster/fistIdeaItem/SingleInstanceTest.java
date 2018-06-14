package com.luster.fistIdeaItem;

public class SingleInstanceTest {

    //类加载的方式，由jvm保证同步
//    private static final SingleInstanceTest singleInstance=new SingleInstanceTest();
//
//    public static SingleInstanceTest getInstance() {
//        return singleInstance;
//    }


    //volatile 禁止指令重排
//    private static volatile SingleInstanceTest singleInstance;
//    public static SingleInstanceTest getInstance() {
//        if (singleInstance == null) {
//            synchronized (SingleInstanceTest.class) {
//                if (singleInstance == null) {
//                    //1. 给 singleton 分配内存
//                    //2. 调用 Singleton 的构造函数来初始化成员变量，形成实例
//                    //3. 将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
//                    //new SingleInstanceTest()，无法保证操作的原子性，
//                    // 存在jvm指令重排的问题，可能的执行指令顺利为1 3 2 ，
//                    //解决方法，将singleInstance用volatile修饰
//                    singleInstance = new SingleInstanceTest();
//                }
//            }
//        }
//        return singleInstance;
//    }


    //内部饿汉式类加载,外部类被调用的时候触发内部类的类加载
//    private static class SingleInstanceHolder {
//        private static final SingleInstanceTest singleInstance = new SingleInstanceTest();
//    }
//    private static SingleInstanceTest getInstance() {
//        return SingleInstanceHolder.singleInstance;
//    }

    //创建枚举实例
    // Effective Java 第二版推荐写法
    public enum SingleInstance {

        INSTANCE;

        public void fun1() {

            // do something

        }

    }

    public static void main(String[] args) {
        SingleInstance.INSTANCE.fun1();
    }
}
