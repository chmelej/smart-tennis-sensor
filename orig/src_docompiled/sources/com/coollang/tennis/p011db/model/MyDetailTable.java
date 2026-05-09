package com.coollang.tennis.p011db.model;

import org.litepal.crud.DataSupport;

/* JADX INFO: loaded from: classes.dex */
public class MyDetailTable extends DataSupport {
    private int UserID;
    private int actionType;
    private int force;
    private int handType;
    private int istarget;
    private int radian;
    private int sign1;
    private String sign2;
    private int speed;
    private long timestamp;
    private int whichnum;

    public MyDetailTable() {
    }

    public MyDetailTable(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, int i9) {
        this.timestamp = j;
        this.actionType = i;
        this.speed = i2;
        this.radian = i3;
        this.force = i4;
        this.istarget = i5;
        this.whichnum = i6;
        this.sign1 = i7;
        this.sign2 = str;
        this.UserID = i8;
        this.handType = i9;
    }

    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int i) {
        this.UserID = i;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public int getActionType() {
        return this.actionType;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int i) {
        this.speed = i;
    }

    public int getRadian() {
        return this.radian;
    }

    public void setRadian(int i) {
        this.radian = i;
    }

    public int getForce() {
        return this.force;
    }

    public void setForce(int i) {
        this.force = i;
    }

    public int getIstarget() {
        return this.istarget;
    }

    public void setIstarget(int i) {
        this.istarget = i;
    }

    public int getWhichnum() {
        return this.whichnum;
    }

    public void setWhichnum(int i) {
        this.whichnum = i;
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

    public int getHandType() {
        return this.handType;
    }

    public void setHandType(int i) {
        this.handType = i;
    }
}
