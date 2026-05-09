package com.mob.commons;

/* JADX INFO: loaded from: classes.dex */
public class SMSSDK implements MobProduct {
    private static String appKey;

    @Override // com.mob.commons.MobProduct
    public String getProductTag() {
        return "SMSSDK";
    }

    @Override // com.mob.commons.MobProduct
    public int getSdkver() {
        return 26;
    }

    public static void setAppKey(String str) {
        appKey = str;
    }

    @Override // com.mob.commons.MobProduct
    public String getProductAppkey() {
        return appKey;
    }
}
