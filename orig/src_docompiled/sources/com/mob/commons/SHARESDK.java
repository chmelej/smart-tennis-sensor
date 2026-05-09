package com.mob.commons;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.mob.commons.authorize.DeviceAuthorizer;

/* JADX INFO: loaded from: classes.dex */
public class SHARESDK implements MobProduct {
    private static String appKey;

    @Override // com.mob.commons.MobProduct
    public String getProductTag() {
        return ShareSDK.SDK_TAG;
    }

    @Override // com.mob.commons.MobProduct
    public int getSdkver() {
        return 60069;
    }

    public static void setAppKey(String str) {
        appKey = str;
    }

    @Override // com.mob.commons.MobProduct
    public String getProductAppkey() {
        return appKey;
    }

    public String getDuid(Context context) {
        return DeviceAuthorizer.authorize(context, this);
    }
}
