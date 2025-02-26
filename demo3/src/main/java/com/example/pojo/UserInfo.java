package com.example.pojo;

public class UserInfo {
    private int id;
    private String loginname;
    private String realname;
    private String pass;
    private String gender;
    private String icon;

    //Getter and Setter 用于访问和修改对象私有属性的方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    //toString 是用于返回对象字符串表示的方法
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", realname='" + realname + '\'' +
                ", pass='" + pass + '\'' +
                ", gender='" + gender + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

}
