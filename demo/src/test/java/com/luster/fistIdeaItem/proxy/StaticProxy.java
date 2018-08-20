package com.luster.fistIdeaItem.proxy;

/**
 * 可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 *因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 */
public class StaticProxy implements IUserService {

    IUserService iUserService;

    public StaticProxy(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Override
    public void save() {
        System.out.println("StaticProxy excute  before iUserSevcie save");
        iUserService.save();
        System.out.println("StaticProxy excute  after iUserSevcie save");
    }

    public static void main(String[] args) {
        IUserService iUserService = new UserServiceImpl();
        new StaticProxy(iUserService).save();
    }
}
