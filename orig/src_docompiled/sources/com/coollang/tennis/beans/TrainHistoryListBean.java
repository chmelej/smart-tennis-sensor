package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class TrainHistoryListBean {

    @Expose
    public int detailId;

    @Expose
    public int duration;

    @Expose
    public int mainId;

    @Expose
    public String time;

    @Expose
    public int totalCount;

    @Expose
    public int trainType;

    public TrainHistoryListBean() {
    }

    public TrainHistoryListBean(int i, String str, int i2, int i3, int i4) {
        this.mainId = i;
        this.time = str;
        this.trainType = i2;
        this.duration = i3;
        this.totalCount = i4;
    }
}
