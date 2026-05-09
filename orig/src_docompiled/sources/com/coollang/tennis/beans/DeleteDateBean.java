package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DeleteDateBean {

    @Expose
    public List<DeleteDateItemBean> errDesc;

    public class DeleteDateItemBean {

        @Expose
        public String Date;

        @Expose
        public String DateTimestamp;

        public DeleteDateItemBean() {
        }
    }
}
