package com.coollang.tennis.beans;

/* JADX INFO: loaded from: classes.dex */
public class MainMonthTable {
    private int MonthTotalHit;
    private int MonthTotalTime;
    private String month;

    public MainMonthTable() {
    }

    public MainMonthTable(String str, int i, int i2) {
        this.month = str;
        this.MonthTotalHit = i;
        this.MonthTotalTime = i2;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String str) {
        this.month = str;
    }

    public int getMonthTotalHit() {
        return this.MonthTotalHit;
    }

    public void setMonthTotalHit(int i) {
        this.MonthTotalHit = i;
    }

    public int getMonthTotalTime() {
        return this.MonthTotalTime;
    }

    public void setMonthTotalTime(int i) {
        this.MonthTotalTime = i;
    }
}
