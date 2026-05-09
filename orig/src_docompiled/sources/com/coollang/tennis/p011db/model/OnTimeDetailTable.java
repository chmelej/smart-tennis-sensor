package com.coollang.tennis.p011db.model;

import org.litepal.crud.DataSupport;

/* JADX INFO: loaded from: classes.dex */
public class OnTimeDetailTable extends DataSupport {
    private int actionType;
    private int handType;
    private int hitSpeed;
    private long shotTimeStemp;
    private int sweet;
    private int trainId;

    public OnTimeDetailTable() {
    }

    public OnTimeDetailTable(int i, int i2, long j, int i3, int i4, int i5) {
        this.actionType = i;
        this.handType = i2;
        this.shotTimeStemp = j;
        this.hitSpeed = i3;
        this.trainId = i4;
        this.sweet = i5;
    }

    public int getActionType() {
        return this.actionType;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public int getHandType() {
        return this.handType;
    }

    public void setHandType(int i) {
        this.handType = i;
    }

    public long getShotTimeStemp() {
        return this.shotTimeStemp;
    }

    public void setShotTimeStemp(long j) {
        this.shotTimeStemp = j;
    }

    public int getHitSpeed() {
        return this.hitSpeed;
    }

    public void setHitSpeed(int i) {
        this.hitSpeed = i;
    }

    public int getTrainId() {
        return this.trainId;
    }

    public void setTrainId(int i) {
        this.trainId = i;
    }

    public int getSweet() {
        return this.sweet;
    }

    public void setSweet(int i) {
        this.sweet = i;
    }
}
