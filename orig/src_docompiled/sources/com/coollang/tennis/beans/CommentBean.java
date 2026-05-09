package com.coollang.tennis.beans;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommentBean {
    public Cont errDesc;
    public String ret;

    public static class Cont {

        /* JADX INFO: renamed from: AD */
        public C1207D1 f7413AD;
        public List<C1209D3> ResponseList;
        public C1208D2 VideoInfo;

        /* JADX INFO: renamed from: com.coollang.tennis.beans.CommentBean$Cont$D1 */
        public static class C1207D1 {
            public String Banner;
            public String CreateTime;

            /* JADX INFO: renamed from: ID */
            public String f7414ID;
            public String Type;
            public String Url;
        }

        /* JADX INFO: renamed from: com.coollang.tennis.beans.CommentBean$Cont$D2 */
        public static class C1208D2 {
            public String CreateTime;
            public String Duration;

            /* JADX INFO: renamed from: ID */
            public String f7415ID;
            public String Icon;
            public String IsCollection;
            public String IsLiked;
            public String LikeCount;
            public String Thumb;
            public String Title;
            public String Url;
            public String UserID;
            public String UserName;
            public String Views;
        }

        /* JADX INFO: renamed from: com.coollang.tennis.beans.CommentBean$Cont$D3 */
        public static class C1209D3 implements Serializable {
            public List<ChildResponseListBean> ChildResponseList;
            public String Content;
            public String CreateTime;
            public String Icon;
            public String IsLiked;
            public String LikeCount;
            public String MainRID;
            public String ParentID;
            public ChildResponseListBean Quote;
            public String ResponseID;
            public String UserID;
            public String UserName;
        }
    }
}
