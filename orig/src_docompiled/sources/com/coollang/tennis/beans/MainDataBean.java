package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MainDataBean {

    @Expose
    public List<MainData> MianList;

    public static class MainData {

        @Expose
        public int Caroline;

        @Expose
        public int Duration;

        @Expose
        public int MaxSpeed;

        @Expose
        public long date;

        @Expose
        public int sign1;

        @Expose
        public String sign2;

        @Expose
        public int totletimes;
    }
}
