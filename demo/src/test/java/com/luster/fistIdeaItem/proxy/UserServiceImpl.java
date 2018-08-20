package com.luster.fistIdeaItem.proxy;

public class UserServiceImpl implements  IUserService {
    @Override
    public void save() {
        System.out.println("UserServiceImpl excute save");
    }
}
