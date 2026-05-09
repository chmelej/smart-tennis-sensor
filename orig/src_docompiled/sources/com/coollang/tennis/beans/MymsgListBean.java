package com.coollang.tennis.beans;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MymsgListBean implements Serializable {
    public List<My_video_msgBean> errDesc;
    public String ret;

    public class My_video_msgBean implements Serializable {
        public String CreateTime;
        public String Duration;
        public String FromUserID;

        /* JADX INFO: renamed from: ID */
        public String f7416ID;
        public String Icon;
        public String Thumb;
        public String Type;
        public String UserName;
        public String VideoID;

        public My_video_msgBean() {
        }
    }
}
