package com.lbj.mvp_demo;

public class UserService implements IUserService{

    @Override
    public String search(int code){
        return "User: " + code;
    }
}
