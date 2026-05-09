package com.umeng.message;

import android.content.Context;
import com.umeng.message.local.UmengLocalNotificationService;
import org.android.agoo.client.BaseBroadcastReceiver;
import p000.ahb;
import p000.ahj;
import p000.ail;

/* JADX INFO: loaded from: classes.dex */
public class MessageReceiver extends BaseBroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static final String f9147a = "com.umeng.message.MessageReceiver";

    @Override // org.android.agoo.client.BaseBroadcastReceiver
    /* JADX INFO: renamed from: a */
    protected String mo8685a(Context context) {
        ahb.m1043c(f9147a, "MessageReceiver");
        if (!ail.m1344a(context, UmengLocalNotificationService.class.getName())) {
            ahj.m1134a(context).m1142c();
        }
        return PushAgent.getInstance(context).getPushIntentServiceClass();
    }
}
