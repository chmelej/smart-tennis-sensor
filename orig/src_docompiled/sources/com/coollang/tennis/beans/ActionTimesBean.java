package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActionTimesBean {

    @Expose
    public List<ActionData> ActionTimesList;

    public static class ActionData {

        @Expose
        public long date;

        @Expose
        public int faqiu;

        @Expose
        public int gaoya;

        @Expose
        public int jieji;

        @Expose
        public int pingji;

        @Expose
        public int sign1;

        @Expose
        public String sign2;

        @Expose
        public int xiaoqiu;

        @Expose
        public int xuanqiu;
    }
}
