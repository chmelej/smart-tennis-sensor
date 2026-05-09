package com.coollang.tennis.beans;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SportDayListBean implements Serializable {
    private int Caroline;
    private int Duration;
    private int MaxSpeed;
    private long date;
    private boolean isChecked;
    private int isUpToServer;
    private int totletimes;

    public SportDayListBean() {
    }

    public SportDayListBean(long j, int i, int i2, int i3, int i4, int i5) {
        this.date = j;
        this.Duration = i;
        this.totletimes = i2;
        this.MaxSpeed = i3;
        this.Caroline = i4;
        this.isUpToServer = i5;
        this.isChecked = false;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public int getDuration() {
        return this.Duration;
    }

    public void setDuration(int i) {
        this.Duration = i;
    }

    public int getTotletimes() {
        return this.totletimes;
    }

    public void setTotletimes(int i) {
        this.totletimes = i;
    }

    public int getMaxSpeed() {
        return this.MaxSpeed;
    }

    public void setMaxSpeed(int i) {
        this.MaxSpeed = i;
    }

    public int getCaroline() {
        return this.Caroline;
    }

    public void setCaroline(int i) {
        this.Caroline = i;
    }

    public boolean getIsChecked() {
        return this.isChecked;
    }

    public void setIsChecked(boolean z) {
        this.isChecked = z;
    }

    public int getIsUpToServer() {
        return this.isUpToServer;
    }

    public void setIsUpToServer(int i) {
        this.isUpToServer = i;
    }
}
