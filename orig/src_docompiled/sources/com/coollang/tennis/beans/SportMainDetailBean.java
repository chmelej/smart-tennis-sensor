package com.coollang.tennis.beans;

/* JADX INFO: loaded from: classes.dex */
public class SportMainDetailBean {
    public String bestHit;
    public String date;
    public String hitCount;
    public int isUpToServer;
    public String order;
    public String sportTime;

    public SportMainDetailBean() {
    }

    public SportMainDetailBean(String str, String str2, String str3, String str4, String str5, int i) {
        this.order = str;
        this.date = str2;
        this.sportTime = str3;
        this.hitCount = str4;
        this.bestHit = str5;
        this.isUpToServer = i;
    }
}
