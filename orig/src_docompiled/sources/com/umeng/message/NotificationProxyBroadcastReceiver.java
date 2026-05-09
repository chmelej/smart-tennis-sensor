package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONException;
import org.json.JSONObject;
import p000.ahb;
import p000.ahf;

/* JADX INFO: loaded from: classes.dex */
public class NotificationProxyBroadcastReceiver extends BroadcastReceiver {
    public static final int EXTRA_ACTION_CLICK = 10;
    public static final int EXTRA_ACTION_DISMISS = 11;
    public static final int EXTRA_ACTION_NOT_EXIST = -1;
    public static final String EXTRA_KEY_ACTION = "ACTION";
    public static final String EXTRA_KEY_MESSAGE_ID = "MESSAGE_ID";
    public static final String EXTRA_KEY_MSG = "MSG";
    public static final String EXTRA_KEY_TASK_ID = "TASK_ID";
    public static final int LOCAL_ACTION_CLICK = 12;

    /* JADX INFO: renamed from: a */
    private static final String f9177a = "com.umeng.message.NotificationProxyBroadcastReceiver";

    /* JADX INFO: renamed from: b */
    private UHandler f9178b;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_KEY_MSG);
        try {
            int intExtra = intent.getIntExtra(EXTRA_KEY_ACTION, -1);
            ahb.m1043c(f9177a, String.format("onReceive[msg=%s, action=%d]", stringExtra, Integer.valueOf(intExtra)));
            if (intExtra == 12) {
                m8712a(context);
            }
            ahf ahfVar = new ahf(new JSONObject(stringExtra));
            ahfVar.f976b = intent.getStringExtra(EXTRA_KEY_MESSAGE_ID);
            ahfVar.f977c = intent.getStringExtra(EXTRA_KEY_TASK_ID);
            switch (intExtra) {
                case 10:
                    ahb.m1043c(f9177a, "click notification");
                    UTrack.getInstance(context).setClearPrevMessage(true);
                    UTrack.getInstance(context).trackMsgClick(ahfVar);
                    this.f9178b = PushAgent.getInstance(context).getNotificationClickHandler();
                    if (this.f9178b != null) {
                        ahfVar.f998x = true;
                        this.f9178b.handleMessage(context, ahfVar);
                    }
                    break;
                case 11:
                    ahb.m1043c(f9177a, "dismiss notification");
                    UTrack.getInstance(context).setClearPrevMessage(true);
                    UTrack.getInstance(context).trackMsgDismissed(ahfVar);
                    this.f9178b = PushAgent.getInstance(context).getNotificationClickHandler();
                    if (this.f9178b != null) {
                        ahfVar.f998x = false;
                        this.f9178b.handleMessage(context, ahfVar);
                    }
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8712a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            ahb.m1041b(f9177a, "handleMessage(): cannot find app: " + context.getPackageName());
            return;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(268435456);
        context.startActivity(launchIntentForPackage);
        ahb.m1043c(f9177a, "handleMessage(): lunach app: " + context.getPackageName());
    }
}
