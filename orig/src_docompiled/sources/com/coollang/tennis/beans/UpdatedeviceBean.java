package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class UpdatedeviceBean {

    @Expose
    public errDesc errDesc;

    @Expose
    public String ret;

    public class errDesc {

        @Expose
        public String ForceUpdate;

        @Expose
        public String Path;

        @Expose
        public String Remark;

        @Expose
        public String Version;

        @Expose
        public String VersionDateTime;

        public errDesc() {
        }
    }
}
