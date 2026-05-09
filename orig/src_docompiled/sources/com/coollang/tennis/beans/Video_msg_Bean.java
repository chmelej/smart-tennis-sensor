package com.coollang.tennis.beans;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Video_msg_Bean implements Serializable {
    public List<C1216d2> errDesc;
    public String ret;

    /* JADX INFO: renamed from: com.coollang.tennis.beans.Video_msg_Bean$d2 */
    public class C1216d2 implements Serializable {
        public String CreateTime;
        public String Duration;

        /* JADX INFO: renamed from: ID */
        public String f7437ID;
        public String Icon;
        public String IsCollection;
        public String Thumb;
        public String Title;
        public String Url;
        public String UserID;
        public String UserName;
        public String Views;

        public C1216d2() {
        }

        public String getIsCollection() {
            return this.IsCollection;
        }
    }
}
