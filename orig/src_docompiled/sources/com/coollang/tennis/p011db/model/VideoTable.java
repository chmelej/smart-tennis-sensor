package com.coollang.tennis.p011db.model;

import org.litepal.crud.DataSupport;

/* JADX INFO: loaded from: classes.dex */
public class VideoTable extends DataSupport {
    private String createTime;
    private long endTime;

    /* JADX INFO: renamed from: id */
    private int f7485id;
    private boolean isSynchroData = false;
    private String name;
    private String picture;
    private long startTime;
    private String url;
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public boolean isSynchroData() {
        return this.isSynchroData;
    }

    public void setSynchroData(boolean z) {
        this.isSynchroData = z;
    }

    public int getId() {
        return this.f7485id;
    }

    public void setId(int i) {
        this.f7485id = i;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String str) {
        this.picture = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }
}
