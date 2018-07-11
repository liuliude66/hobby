package com.forum.base.model;

import java.util.Date;

/**
 * Created by DELL on 2018/7/10.
 */

public class AccountModel extends BaseModel {

    private String username;
    private String password;

    private String qqAccount;//QQ账号
    private String wxAccount;//微信账号
    private String aliAccount;//支付宝账号
    private Date registerTime;//注册时间
    private Date lastLoginTime;//上次的登录时间
    private Integer settleCount;//已经结算的次数
    private Integer isSettled;//是否结算
    private Integer sendTotalCount;//发送的总量
    private Integer isEnabled;//是否被禁用
    private String phoneImei;//注册的手机IMEI
    private String telephone;//手机号码

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

    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

    public String getWxAccount() {
        return wxAccount;
    }

    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    public String getAliAccount() {
        return aliAccount;
    }

    public void setAliAccount(String aliAccount) {
        this.aliAccount = aliAccount;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getSettleCount() {
        return settleCount;
    }

    public void setSettleCount(Integer settleCount) {
        this.settleCount = settleCount;
    }

    public Integer getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(Integer isSettled) {
        this.isSettled = isSettled;
    }

    public Integer getSendTotalCount() {
        return sendTotalCount;
    }

    public void setSendTotalCount(Integer sendTotalCount) {
        this.sendTotalCount = sendTotalCount;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getPhoneImei() {
        return phoneImei;
    }

    public void setPhoneImei(String phoneImei) {
        this.phoneImei = phoneImei;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "AccountModel{" + "password='" + password + '\'' + ", username='" + username + '\'' + '}';
    }
}
