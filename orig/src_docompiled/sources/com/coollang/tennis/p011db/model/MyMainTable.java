package com.coollang.tennis.p011db.model;

import java.util.ArrayList;
import java.util.List;
import org.litepal.crud.DataSupport;

/* JADX INFO: loaded from: classes.dex */
public class MyMainTable extends DataSupport {
    private int Caroline;
    private int Duration;
    private int MaxSpeed;
    private int UserID;
    private MyActionTable actionTable;
    private long date;
    private List<MyDetailTable> detailTable = new ArrayList();
    private int isDeleted;
    private int sign1;
    private String sign2;
    private String signDate;
    private int totletimes;

    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int i) {
        this.UserID = i;
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

    public int getTotletimes() {
        return this.totletimes;
    }

    public void setTotletimes(int i) {
        this.totletimes = i;
    }

    public int getSign1() {
        return this.sign1;
    }

    public void setSign1(int i) {
        this.sign1 = i;
    }

    public String getSign2() {
        return this.sign2;
    }

    public void setSign2(String str) {
        this.sign2 = str;
    }

    public MyActionTable getActionTable() {
        return this.actionTable;
    }

    public void setActionTable(MyActionTable myActionTable) {
        this.actionTable = myActionTable;
    }

    public List<MyDetailTable> getDetailTable() {
        return this.detailTable;
    }

    public void setDetailTable(List<MyDetailTable> list) {
        this.detailTable = list;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public String getSignDate() {
        return this.signDate;
    }

    public void setSignDate(String str) {
        this.signDate = str;
    }
}
