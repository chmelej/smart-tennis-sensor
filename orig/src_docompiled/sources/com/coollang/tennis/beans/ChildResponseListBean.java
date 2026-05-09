package com.coollang.tennis.beans;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ChildResponseListBean implements Serializable {
    public String Content;
    public String CreateTime;
    public String Icon;
    public String IsLiked;
    public String LikeCount;
    public String MainRID;
    public String ParentID;
    public ChildResponseListBean Quote;
    public String ResponseID;
    public String UserID;
    public String UserName;

    public String toString() {
        return "ChildResponseListBean{ResponseID='" + this.ResponseID + "', ParentID='" + this.ParentID + "', Content='" + this.Content + "', CreateTime='" + this.CreateTime + "', UserName='" + this.UserName + "', Icon='" + this.Icon + "', UserID='" + this.UserID + "', IsLiked='" + this.IsLiked + "', MainRID='" + this.MainRID + "', Quote=" + this.Quote + ", LikeCount='" + this.LikeCount + "'}";
    }
}
