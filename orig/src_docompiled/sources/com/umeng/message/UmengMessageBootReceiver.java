package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.MsgLogStore;
import com.umeng.message.local.UmengLocalNotificationService;
import p000.ahb;
import p000.ahj;
import p000.ail;

/* JADX INFO: loaded from: classes.dex */
public class UmengMessageBootReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b */
    private static final String f9237b = "com.umeng.message.UmengMessageBootReceiver";

    /* JADX INFO: renamed from: a */
    Runnable f9238a = new Runnable() { // from class: com.umeng.message.UmengMessageBootReceiver.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                for (MsgLogStore.MsgLogIdType msgLogIdType : MsgLogStore.getInstance(UmengMessageBootReceiver.this.f9239c).getMsgLogIdTypes()) {
                    if (MsgLogStore.getInstance(UmengMessageBootReceiver.this.f9239c).getMsgLog(msgLogIdType.msgId) == null && msgLogIdType.msgType.equals("notification")) {
                        MsgLogStore.getInstance(UmengMessageBootReceiver.this.f9239c).addLog(msgLogIdType.msgId, 2, System.currentTimeMillis());
                    }
                }
                for (MsgLogStore.MsgLogIdTypeForAgoo msgLogIdTypeForAgoo : MsgLogStore.getInstance(UmengMessageBootReceiver.this.f9239c).getMsgLogIdTypesForAgoo()) {
                    if (MsgLogStore.getInstance(UmengMessageBootReceiver.this.f9239c).getMsgLogForAgoo(msgLogIdTypeForAgoo.msgId) == null && msgLogIdTypeForAgoo.msgStatus.equals("notification")) {
                        MsgLogStore.getInstance(UmengMessageBootReceiver.this.f9239c).addLogForAgoo(msgLogIdTypeForAgoo.msgId, msgLogIdTypeForAgoo.taskId, MsgConstant.MESSAGE_NOTIFY_DISMISS, System.currentTimeMillis());
                    }
                }
                if (ail.m1344a(UmengMessageBootReceiver.this.f9239c, UmengLocalNotificationService.class.getName())) {
                    return;
                }
                ahj.m1134a(UmengMessageBootReceiver.this.f9239c).m1142c();
            } catch (Exception e) {
                e.printStackTrace();
                ahb.m1043c(UmengMessageBootReceiver.f9237b, e.toString());
            }
        }
    };

    /* JADX INFO: renamed from: c */
    private Context f9239c;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ahb.m1043c(f9237b, "Boot this system , UmengMessageBootReceiver onReceive()");
            String action = intent.getAction();
            if (action != null && !action.equals("")) {
                ahb.m1043c(f9237b, "action=" + intent.getAction());
                if (TextUtils.equals(intent.getAction(), "android.intent.action.BOOT_COMPLETED")) {
                    this.f9239c = context;
                    new Thread(this.f9238a).start();
                }
            }
        } catch (Exception e) {
            ahb.m1043c(f9237b, e.toString());
        }
    }
}
