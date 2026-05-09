package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MyDataBean implements Serializable {

    @Expose
    public ErrorBean errDesc;

    @Expose
    public String ret;

    public static class ErrorBean {

        @Expose
        public AvgBean AvgList;

        @Expose
        public HashMap<String, List<BestBean>> BestList;

        @Expose
        public List<Medal> Medals;

        @Expose
        public String TotalCount;

        @Expose
        public String TotalDuration;

        @Expose
        public UserInfo UserInfo;

        @Expose
        public HashMap<String, HashMap<String, String>> YearMonthList;

        public static class BestBean {

            @Expose
            public String Duration;

            @Expose
            public String MaxServeSpeed;

            @Expose
            public String TotalCount;

            @Expose
            public String TotalScore;
        }

        public class AvgBean {

            @Expose
            public String BackSpeed;

            @Expose
            public String Duration;

            @Expose
            public String ForceSpeed;

            @Expose
            public String Score;

            @Expose
            public String ServeSpeed;

            @Expose
            public String WeekSport;

            public AvgBean() {
            }
        }

        public class UserInfo {

            @Expose
            public String Address;

            @Expose
            public String Icon;

            @Expose
            public String UserName;

            public UserInfo() {
            }
        }

        public class Medal {

            @Expose
            public String CreateTime;

            @Expose
            public int Medal;

            @Expose
            public String State;

            public Medal() {
            }
        }
    }
}
