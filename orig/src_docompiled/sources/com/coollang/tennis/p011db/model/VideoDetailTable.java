package com.coollang.tennis.p011db.model;

import org.litepal.crud.DataSupport;

/* JADX INFO: loaded from: classes.dex */
public class VideoDetailTable extends DataSupport {
    private int UserID;
    private int actionType;
    private String day;
    private int force;
    private int handType;
    private int istarget;
    private int radian;
    private int speed;
    private long timestamp;
    private int whichnum;

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

    public String getDay() {
        return this.day;
    }

    public void setDay(String str) {
        this.day = str;
    }

    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int i) {
        this.UserID = i;
    }

    public int getHandType() {
        return this.handType;
    }

    public void setHandType(int i) {
        this.handType = i;
    }
}
