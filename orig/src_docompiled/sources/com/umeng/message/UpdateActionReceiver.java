package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import p000.ahb;
import p000.ahf;

/* JADX INFO: loaded from: classes.dex */
public class UpdateActionReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private static final String f9252a = "com.umeng.message.UpdateActionReceiver";

    /* JADX INFO: renamed from: b */
    private ahf f9253b;

    public UpdateActionReceiver(ahf ahfVar) {
        this.f9253b = ahfVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (PushAgent.getInstance(context).isIncludesUmengUpdateSDK()) {
                Bundle bundleExtra = intent.getBundleExtra("UpdateListener");
                if (bundleExtra.getInt("UpdateStatus") == 0) {
                    MsgLogStore.getInstance(context).setMsgConfigInfo_UpdateResponse(bundleExtra.getSerializable(MsgLogStore.UpdateResponse));
                    UmengMessageHandler umengMessageHandler = (UmengMessageHandler) PushAgent.getInstance(context).getMessageHandler();
                    if (umengMessageHandler != null) {
                        umengMessageHandler.dealWithNotificationMessage(context, this.f9253b);
                    }
                } else {
                    UTrack.getInstance(context).setClearPrevMessage(false);
                    UTrack.getInstance(context).trackMsgDismissed(this.f9253b);
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            }
        } catch (Exception e) {
            ahb.m1043c(f9252a, e.toString());
        }
    }
}
