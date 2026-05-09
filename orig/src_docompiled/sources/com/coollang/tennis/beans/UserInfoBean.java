package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class UserInfoBean {

    @Expose
    public errDesc errDesc;

    @Expose
    public String ret;

    public class errDesc {

        @Expose
        public String Address;

        @Expose
        public String Birthday;

        @Expose
        public String Brand;

        @Expose
        public String Hand;

        @Expose
        public String Height;

        @Expose
        public String Icon;

        @Expose
        public String Level;

        @Expose
        public String Sex;

        @Expose
        public String Signature;

        @Expose
        public String SportAge;

        @Expose
        public String StartTennisYear;

        @Expose
        public String UserID;

        @Expose
        public String UserName;

        @Expose
        public String Weight;

        public errDesc() {
        }
    }
}
