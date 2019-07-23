package com.qdu.diaisheng.entity;

/**
 * @Autor wangxi
 * @Description 用户的实体类
 * @Date 2019/7/22
 *
 */
public class User {
    private Integer userId;//用户id
    private String userName;//用户名
    private String phoneNum;//电话号码
    private String password;//密码


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
