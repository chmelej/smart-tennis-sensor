package com.umeng.message;

import android.content.Context;
import org.android.agoo.client.MessageReceiverService;

/* JADX INFO: loaded from: classes.dex */
public class UmengMessageIntentReceiverService extends MessageReceiverService {
    @Override // org.android.agoo.client.MessageReceiverService
    public String getIntentServiceClassName(Context context) {
        return PushAgent.getInstance(context).getPushIntentServiceClass();
    }
}
