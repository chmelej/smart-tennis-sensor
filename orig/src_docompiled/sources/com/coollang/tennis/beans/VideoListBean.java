package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class VideoListBean {

    @Expose
    public List<VideoInfo> errDesc;

    public class VideoInfo {

        @Expose
        public String CreateTime;

        /* JADX INFO: renamed from: ID */
        @Expose
        public String f7433ID;

        @Expose
        public String Name;

        @Expose
        public String PlayTimes;

        @Expose
        public String Thumbnail;

        @Expose
        public String Url;

        public VideoInfo() {
        }
    }
}
