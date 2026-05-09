package com.coollang.tennis.beans;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BallStartListBean {
    private List<BallStarVideoBean> errDesc;
    private String ret;

    public String getRet() {
        return this.ret;
    }

    public void setRet(String str) {
        this.ret = str;
    }

    public List<BallStarVideoBean> getErrDesc() {
        return this.errDesc;
    }

    public void setErrDesc(List<BallStarVideoBean> list) {
        this.errDesc = list;
    }

    public static class BallStarVideoBean {
        private String CreateTime;
        private String EnName;
        private String EnStarName;

        /* JADX INFO: renamed from: ID */
        private String f7412ID;
        private String Name;
        private String PicUrl;
        private String Size;
        private String StarName;
        private String Time;
        private String Url;
        private String ViewTimes;

        public String getPicUrl() {
            return this.PicUrl;
        }

        public void setPicUrl(String str) {
            this.PicUrl = str;
        }

        public String getID() {
            return this.f7412ID;
        }

        public void setID(String str) {
            this.f7412ID = str;
        }

        public String getName() {
            return this.Name;
        }

        public void setName(String str) {
            this.Name = str;
        }

        public String getUrl() {
            return this.Url;
        }

        public void setUrl(String str) {
            this.Url = str;
        }

        public String getTime() {
            return this.Time;
        }

        public void setTime(String str) {
            this.Time = str;
        }

        public String getSize() {
            return this.Size;
        }

        public void setSize(String str) {
            this.Size = str;
        }

        public String getViewTimes() {
            return this.ViewTimes;
        }

        public void setViewTimes(String str) {
            this.ViewTimes = str;
        }

        public String getStarName() {
            return this.StarName;
        }

        public void setStarName(String str) {
            this.StarName = str;
        }

        public String getCreateTime() {
            return this.CreateTime;
        }

        public void setCreateTime(String str) {
            this.CreateTime = str;
        }

        public String getEnName() {
            return this.EnName;
        }

        public void setEnName(String str) {
            this.EnName = str;
        }

        public String getEnStarName() {
            return this.EnStarName;
        }

        public void setEnStarName(String str) {
            this.EnStarName = str;
        }
    }
}
