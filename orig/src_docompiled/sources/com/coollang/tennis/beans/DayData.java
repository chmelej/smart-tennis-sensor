package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DayData implements Serializable {

    @Expose
    public int attackNum;

    @Expose
    public int calorieNum;

    @Expose
    public List<ChangCiBean> changciList;

    @Expose
    public int cuoiuNum;

    @Expose
    public String date;

    @Expose
    public int dayInWeek;

    @Expose
    public int defendNum;

    @Expose
    public int gaoQiuNum;

    @Expose
    public int maxSpeed;

    @Expose
    public int pingChouNum;

    @Expose
    public int pingDangNum;

    @Expose
    public int shaQiuNum;
    public int sportTime;
    public int sportType;

    @Expose
    public int tiaoQiuNum;
}
