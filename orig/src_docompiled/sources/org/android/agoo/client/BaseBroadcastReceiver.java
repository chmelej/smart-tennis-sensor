package org.android.agoo.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {
    /* JADX INFO: renamed from: a */
    protected abstract String mo8685a(Context context);

    /* JADX INFO: renamed from: a */
    protected void m10922a(Context context, Intent intent) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            m10922a(context, intent);
            BaseIntentService.m10924a(context, intent, mo8685a(context));
        } catch (Throwable unused) {
        }
    }
}
