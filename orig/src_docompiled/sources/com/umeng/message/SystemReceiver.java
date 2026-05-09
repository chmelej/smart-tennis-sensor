package com.umeng.message;

import android.content.Context;
import org.android.agoo.client.BaseBroadcastReceiver;
import p000.ahb;

/* JADX INFO: loaded from: classes.dex */
public class SystemReceiver extends BaseBroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static final String f9194a = "com.umeng.message.SystemReceiver";

    @Override // org.android.agoo.client.BaseBroadcastReceiver
    /* JADX INFO: renamed from: a */
    protected String mo8685a(Context context) {
        ahb.m1043c(f9194a, "SystemReceiver");
        return PushAgent.getInstance(context).getPushIntentServiceClass();
    }
}
