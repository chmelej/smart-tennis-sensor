package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MyEquipBean implements Serializable {

    @Expose
    public ErrDescBean errDesc;

    @Expose
    public String ret;

    public static class ErrDescBean {

        @Expose
        public String Brand;

        @Expose
        public String BuyTime;

        @Expose
        public String Line;

        @Expose
        public String RacketUrl;

        @Expose
        public String ShoesBuyTime;

        @Expose
        public String ShoesName;

        @Expose
        public String ShoesUrl;

        @Expose
        public String UpdateTime;

        @Expose
        public String UserID;

        @Expose
        public String VerticalLine;
    }
}
