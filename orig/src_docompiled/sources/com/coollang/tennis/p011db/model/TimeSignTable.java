package com.coollang.tennis.p011db.model;

import org.litepal.crud.DataSupport;

/* JADX INFO: loaded from: classes.dex */
public class TimeSignTable extends DataSupport {
    private int UserID;
    private long timesign;
    private long trainHandTime;
    private long trainSendTime;

    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int i) {
        this.UserID = i;
    }

    public long getTimesign() {
        return this.timesign;
    }

    public void setTimesign(long j) {
        this.timesign = j;
    }

    public long getTrainHandTime() {
        return this.trainHandTime;
    }

    public void setTrainHandTime(long j) {
        this.trainHandTime = j;
    }

    public long getTrainSendTime() {
        return this.trainSendTime;
    }

    public void setTrainSendTime(long j) {
        this.trainSendTime = j;
    }
}
