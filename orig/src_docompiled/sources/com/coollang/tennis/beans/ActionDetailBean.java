package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActionDetailBean {

    @Expose
    public List<ActionDetailData> ActionTimesList;

    public static class ActionDetailData {

        @Expose
        public int Force;

        @Expose
        public int Radian;

        @Expose
        public int Speed;

        @Expose
        public int Sweet;

        @Expose
        public long Timestamp;

        @Expose
        public int Type;

        @Expose
        public int sign1;

        @Expose
        public String sign2;

        @Expose
        public int whichnum;
    }
}
