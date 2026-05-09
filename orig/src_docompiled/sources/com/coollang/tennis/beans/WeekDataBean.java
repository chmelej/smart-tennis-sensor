package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WeekDataBean implements Serializable {

    @Expose
    public List<DayData> dayData;

    @Expose
    public String duration;

    @Expose
    public int totalCalorie;

    @Expose
    public int totalNum;

    @Expose
    public int weekMaxSpeed;

    @Expose
    public int weekSportTime;

    @Expose
    public String year;
}
