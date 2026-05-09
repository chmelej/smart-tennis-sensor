package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TrainSendResultBean implements Serializable {

    @Expose
    public List<ErrDescBean> errDesc;

    @Expose
    public String ret;

    public static class ErrDescBean {

        @Expose
        public String CreateTime;

        @Expose
        public String Date;

        @Expose
        public List<DetailBean> Detail;

        @Expose
        public long EndTime;

        /* JADX INFO: renamed from: ID */
        @Expose
        public String f7426ID;

        @Expose
        public long StartTime;

        @Expose
        public int TargetSpeed;

        @Expose
        public long UploadTime;

        @Expose
        public String UserID;

        public static class DetailBean {

            /* JADX INFO: renamed from: D */
            @Expose
            public long f7427D;

            /* JADX INFO: renamed from: S */
            @Expose
            public int f7428S;

            /* JADX INFO: renamed from: T */
            @Expose
            public int f7429T;
        }
    }
}
