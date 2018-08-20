package com.luster.fistIdeaItem.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.代理对象,不需要实现接口
 *2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
 *3.动态代理也叫做:JDK代理,接口代理
 */
public class JDKInterfaceProxy {

    //维护目标对象
    private Object target;

    public JDKInterfaceProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("excute  before target method excute");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("excute  after target method excute");
                        return returnValue;
                    }
                }
        );
    }
    public static void main(String[] args){
        IUserService iUserService=new UserServiceImpl();
        //原始类型 class com.luster.fistIdeaItem.proxy.UserServiceImpl
        System.out.println(iUserService.getClass());
        IUserService proxy=(IUserService) new JDKInterfaceProxy(iUserService).getProxyInstance();
        //内存中动态生成的代理对象class com.sun.proxy.$Proxy0
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
