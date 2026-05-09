package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DetailDataBean {

    @Expose
    public List<Data> Data;

    @Expose
    public String Date;

    public class Data {

        @Expose
        public String Force;

        @Expose
        public String Speed;

        @Expose
        public String Time;

        @Expose
        public String Type;

        @Expose
        public String hittime;

        @Expose
        public String swipetime;

        public Data() {
        }
    }
}
