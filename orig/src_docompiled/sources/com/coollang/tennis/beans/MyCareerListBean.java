package com.coollang.tennis.beans;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MyCareerListBean implements Serializable {

    @Expose
    public List<SettingHistoryItemBean> errDesc;

    @Expose
    public String ret;
}
