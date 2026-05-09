package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class UploadCareerResultBean implements Serializable {

    @Expose
    public ErrDescBean errDesc;

    @Expose
    public String ret;

    public static class ErrDescBean {

        /* JADX INFO: renamed from: ID */
        @Expose
        public String f7432ID;
    }
}
