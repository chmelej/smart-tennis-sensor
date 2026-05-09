package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TrainHandResultBean implements Serializable {
    public List<ErrDescBean> errDesc;
    public String ret;

    public static class ErrDescBean {

        @Expose
        public int BackTargetTimes;

        @Expose
        public String CreateTime;

        @Expose
        public String Date;

        @Expose
        public List<TrainHistoryDetailUpBean> Detail;

        @Expose
        public long EndTime;

        @Expose
        public int ForceTargetTimes;

        @Expose
        public float Frequency;

        /* JADX INFO: renamed from: ID */
        @Expose
        public String f7421ID;

        @Expose
        public long StartTime;

        @Expose
        public long UploadTime;

        @Expose
        public String UserID;
    }
}
