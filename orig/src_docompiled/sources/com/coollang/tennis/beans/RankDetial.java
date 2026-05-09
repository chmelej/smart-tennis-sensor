package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RankDetial {

    @Expose
    public ErrDesc errDesc;

    @Expose
    public String ret;

    public class ErrDesc {

        @Expose
        public String IsLiked;

        @Expose
        public String Likes;

        @Expose
        public List<String> Medals;

        @Expose
        public String ScoreMonthRank;

        @Expose
        public String ScoreWeekRank;

        @Expose
        public String SwingMonthRank;

        @Expose
        public String SwingWeekRank;

        @Expose
        public String TotalDuration;

        @Expose
        public String TotalSwings;

        @Expose
        public UserInfo UserInfo;

        public ErrDesc() {
        }

        public class UserInfo {

            @Expose
            public String Address;

            @Expose
            public String Icon;

            @Expose
            public String Name;

            public UserInfo() {
            }
        }
    }
}
