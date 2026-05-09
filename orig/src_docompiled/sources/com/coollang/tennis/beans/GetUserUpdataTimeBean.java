package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class GetUserUpdataTimeBean {

    @Expose
    public TimeUnix errDesc;

    @Expose
    public String ret;

    public class TimeUnix {

        @Expose
        public String LastUploadTime;

        public TimeUnix() {
        }
    }
}
