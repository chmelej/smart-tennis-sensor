package com.coollang.tennis.p011db.model;

import org.litepal.crud.DataSupport;

/* JADX INFO: loaded from: classes.dex */
public class MyActionTable extends DataSupport {
    private int UserID;
    private long date;
    private int faqiu;
    private int gaoya;
    private int jieji;
    private int pingji;
    private int sign1;
    private String sign2;
    private int xiaoqiu;
    private int xuanqiu;

    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int i) {
        this.UserID = i;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public int getFaqiu() {
        return this.faqiu;
    }

    public void setFaqiu(int i) {
        this.faqiu = i;
    }

    public int getGaoya() {
        return this.gaoya;
    }

    public void setGaoya(int i) {
        this.gaoya = i;
    }

    public int getJieji() {
        return this.jieji;
    }

    public void setJieji(int i) {
        this.jieji = i;
    }

    public int getXiaoqiu() {
        return this.xiaoqiu;
    }

    public void setXiaoqiu(int i) {
        this.xiaoqiu = i;
    }

    public int getXuanqiu() {
        return this.xuanqiu;
    }

    public void setXuanqiu(int i) {
        this.xuanqiu = i;
    }

    public int getPingji() {
        return this.pingji;
    }

    public void setPingji(int i) {
        this.pingji = i;
    }

    public int getSign1() {
        return this.sign1;
    }

    public void setSign1(int i) {
        this.sign1 = i;
    }

    public String getSign2() {
        return this.sign2;
    }

    public void setSign2(String str) {
        this.sign2 = str;
    }
}
