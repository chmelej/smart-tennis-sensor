package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class TrainHistoryDetailUpBean implements Serializable {

    /* JADX INFO: renamed from: D */
    @Expose
    public long f7422D;

    /* JADX INFO: renamed from: F */
    @Expose
    public int f7423F;

    /* JADX INFO: renamed from: S */
    @Expose
    public int f7424S;

    /* JADX INFO: renamed from: T */
    @Expose
    public int f7425T;

    public TrainHistoryDetailUpBean() {
    }

    public TrainHistoryDetailUpBean(int i, int i2, int i3, long j) {
        this.f7425T = i;
        this.f7423F = i2;
        this.f7424S = i3;
        this.f7422D = j;
    }
}
