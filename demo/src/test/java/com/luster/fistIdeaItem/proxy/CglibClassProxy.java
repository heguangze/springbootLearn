package com.luster.fistIdeaItem.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.
 * JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现.
 * Cglib包的底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类.不鼓励直接使用ASM,
 * 因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉.
 */
public class CglibClassProxy implements MethodInterceptor {
    //维护目标对象
    private Object target;

    public CglibClassProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        //1、工具类
        Enhancer en = new Enhancer();
        //2、设置父类
        en.setSuperclass(target.getClass());
        //3、设置回调函数
        en.setCallback(this);
        //4、创建子类（代理对象）
        return en.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("excute  before target method excute");
        //执行目标对象方法
        Object returnValue = method.invoke(target, args);
        System.out.println("excute  after target method excute");
        return returnValue;
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceImpl proxyInstance = (UserServiceImpl) new CglibClassProxy(userService).getProxyInstance();
        proxyInstance.save();
    }
}
