package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UpdataBean {

    @Expose
    public String Caroline;

    @Expose
    public String DateTimestamp;

    @Expose
    public List<Detail> DetailData;

    @Expose
    public String Duration;

    @Expose
    public String MaxSpeed;

    @Expose
    public String State;

    @Expose
    public DayData TypeCount;

    public class DayData {

        @Expose
        public String FaQiu;

        @Expose
        public String GaoYa;

        @Expose
        public String JieJi;

        @Expose
        public String PingJi;

        @Expose
        public String XuanQiu;

        @Expose
        public String XueQiu;

        public DayData() {
        }
    }

    public class Detail {

        @Expose
        public String Force;

        /* JADX INFO: renamed from: H */
        @Expose
        public String f7431H;

        @Expose
        public String Radian;

        @Expose
        public String Speed;

        @Expose
        public String Sweet;

        @Expose
        public String Timestamp;

        @Expose
        public String Type;

        public Detail() {
        }
    }
}
