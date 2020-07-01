package com.main.restAPI;

public class Test {
    private final String loginMsg;
    private final String uid;

    public Test(String token) {
        //check if given ID Token is valid
        AuthUser user=new AuthUser(token);
        uid=user.authorize();
        if(uid==null) {
            loginMsg="failed login";
        }
        else {
            loginMsg="login successful";
        }
    }

    public String getLoginMsg() {
        return loginMsg;
    }

    public String getUid() {
        return uid;
    }

}
