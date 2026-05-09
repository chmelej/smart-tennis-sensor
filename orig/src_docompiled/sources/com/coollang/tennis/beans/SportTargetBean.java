package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class SportTargetBean {

    @Expose
    public errDesc errDesc;

    public class errDesc {

        @Expose
        public String Avg;

        @Expose
        public String Count;

        @Expose
        public String Recommend;

        public errDesc() {
        }
    }
}
