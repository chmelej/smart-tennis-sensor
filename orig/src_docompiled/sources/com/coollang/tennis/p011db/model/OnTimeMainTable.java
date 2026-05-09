package com.coollang.tennis.p011db.model;

import org.litepal.crud.DataSupport;

/* JADX INFO: loaded from: classes.dex */
public class OnTimeMainTable extends DataSupport {
    private int backTargetSpeed;
    private String date;
    private long endTimeStemp;
    private int foreTargetSpeed;
    private int hitRate;

    /* JADX INFO: renamed from: id */
    private int f7484id;
    private int maxProgress;
    private String serverId;
    private long startTimeStemp;
    private int type;
    private int upServer;
    private int userId;

    public OnTimeMainTable() {
    }

    public OnTimeMainTable(long j, long j2, int i, int i2, String str, int i3, int i4, int i5) {
        this.startTimeStemp = j;
        this.endTimeStemp = j2;
        this.type = i;
        this.userId = i2;
        this.date = str;
        this.foreTargetSpeed = i3;
        this.backTargetSpeed = i4;
        this.upServer = i5;
    }

    public OnTimeMainTable(long j, long j2, int i, int i2, String str, int i3, int i4, int i5, String str2) {
        this.startTimeStemp = j;
        this.endTimeStemp = j2;
        this.type = i;
        this.userId = i2;
        this.date = str;
        this.foreTargetSpeed = i3;
        this.backTargetSpeed = i4;
        this.upServer = i5;
        this.serverId = str2;
    }

    public int getMaxProgress() {
        return this.maxProgress;
    }

    public void setMaxProgress(int i) {
        this.maxProgress = i;
    }

    public int getHitRate() {
        return this.hitRate;
    }

    public void setHitRate(int i) {
        this.hitRate = i;
    }

    public int getId() {
        return this.f7484id;
    }

    public void setId(int i) {
        this.f7484id = i;
    }

    public int getForeTargetSpeed() {
        return this.foreTargetSpeed;
    }

    public void setForeTargetSpeed(int i) {
        this.foreTargetSpeed = i;
    }

    public int getBackTargetSpeed() {
        return this.backTargetSpeed;
    }

    public void setBackTargetSpeed(int i) {
        this.backTargetSpeed = i;
    }

    public int getUpServer() {
        return this.upServer;
    }

    public void setUpServer(int i) {
        this.upServer = i;
    }

    public long getStartTimeStemp() {
        return this.startTimeStemp;
    }

    public void setStartTimeStemp(long j) {
        this.startTimeStemp = j;
    }

    public long getEndTimeStemp() {
        return this.endTimeStemp;
    }

    public void setEndTimeStemp(long j) {
        this.endTimeStemp = j;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getServerId() {
        return this.serverId;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }
}
