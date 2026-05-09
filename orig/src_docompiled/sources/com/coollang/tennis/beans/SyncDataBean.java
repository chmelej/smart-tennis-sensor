package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SyncDataBean {

    @Expose
    public Alldata errDesc;

    @Expose
    public String ret;

    public class Alldata {

        @Expose
        public List<SyncData> Data;

        @Expose
        public String LastUploadTime;

        public Alldata() {
        }

        public class SyncData {

            @Expose
            public String Caroline;

            @Expose
            public String Date;

            @Expose
            public String DateTimestamp;

            @Expose
            public List<DetailAd> DetailData;

            @Expose
            public String Duration;

            @Expose
            public String MaxSpeed;

            @Expose
            public String Month;

            @Expose
            public int State;

            @Expose
            public String TotalCount;

            @Expose
            public TypeCountData TypeCount;

            @Expose
            public String UpdateTime;

            @Expose
            public String UserID;

            @Expose
            public String Week;

            @Expose
            public String Year;

            @Expose
            public String YearWeek;

            public SyncData() {
            }

            public class TypeCountData {

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

                public TypeCountData() {
                }
            }

            public class DetailAd {

                @Expose
                public String Force;

                /* JADX INFO: renamed from: H */
                @Expose
                public String f7420H;

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

                public DetailAd() {
                }
            }
        }
    }
}
