package com.coollang.tennis.beans;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SettingHistoryItemBean implements Serializable {
    public String Career;

    /* JADX INFO: renamed from: ID */
    public String f7419ID;
    public String Year;
    public boolean isChecked;

    public SettingHistoryItemBean() {
    }

    public SettingHistoryItemBean(String str, String str2, boolean z) {
        this.Year = str;
        this.Career = str2;
        this.isChecked = z;
    }
}
