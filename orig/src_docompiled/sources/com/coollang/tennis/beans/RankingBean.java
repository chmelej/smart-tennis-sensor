package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RankingBean {

    @Expose
    public errDesc errDesc;

    @Expose
    public String ret;

    public class errDesc {

        @Expose
        public MyRankInfo MyRankInfo;

        @Expose
        public List<Rank> RankList;

        public errDesc() {
        }

        public class Rank {

            @Expose
            public String Address;

            @Expose
            public String Duration;

            @Expose
            public String Icon;

            @Expose
            public String IsLiked;

            @Expose
            public String Likes;

            @Expose
            public String MaxSpeed;

            @Expose
            public String Score;

            @Expose
            public String Signature;

            @Expose
            public String TotalCount;

            @Expose
            public String UserID;

            @Expose
            public String UserName;

            public Rank() {
            }
        }

        public class MyRankInfo {

            @Expose
            public String Address;

            @Expose
            public String Change;

            @Expose
            public String Duration;

            @Expose
            public String Icon;

            @Expose
            public List<String> LikeUserList;

            @Expose
            public String Likes;

            @Expose
            public String MaxSpeed;

            @Expose
            public String Number;

            @Expose
            public String Score;

            @Expose
            public String Signature;

            @Expose
            public String TotalCount;

            @Expose
            public String UserID;

            @Expose
            public String UserName;

            public MyRankInfo() {
            }
        }
    }
}
