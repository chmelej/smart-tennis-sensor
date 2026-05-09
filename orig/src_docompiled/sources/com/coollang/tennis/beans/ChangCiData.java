package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ChangCiData implements Serializable {

    @Expose
    public int battingTimes;

    @Expose
    public int calorie;

    @Expose
    public int confrontationGoal;

    @Expose
    public long duration;

    @Expose
    public long endTime;

    @Expose
    public int enduranceGoal;

    @Expose
    public int explosiveGoal;

    @Expose
    public int goal;

    @Expose
    public int maxSpeed;

    @Expose
    public int reactionGoal;

    @Expose
    public long startTime;

    @Expose
    public List<Long> timeList;

    @Expose
    public int gaoyuanNum = 0;

    @Expose
    public int koushaNum = 0;

    @Expose
    public int pingdangNum = 0;

    @Expose
    public int pingchouNum = 0;

    @Expose
    public int tiaoqiuNum = 0;

    @Expose
    public int cuoqiuNum = 0;
}
