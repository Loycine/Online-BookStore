package me.loycine.bookstore.entity;

import org.springframework.stereotype.Repository;

import java.util.Date;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private String userNickname;
    private String userTruename;
    private Integer userGender;

    private String userEmail;

    private Double balance;

    private Date createTime;

    private Integer status;
    public User(){

    }
    public User(String name, String password) {
        this.username = name;
        this.password = password;
        this.userNickname = name;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserTruename() {
        return userTruename;
    }

    public void setUserTruename(String userTruename) {
        this.userTruename = userTruename;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    @Override
    public String toString(){
        return "username :" + this.username + " userNickname :" + this.userNickname + " userTruename : " +this.userTruename;
    }
}
