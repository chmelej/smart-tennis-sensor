package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Map;
import p000.ahb;
import p000.ahf;

/* JADX INFO: loaded from: classes.dex */
public class UmengNotificationClickHandler implements UHandler {

    /* JADX INFO: renamed from: a */
    private static final String f9250a = "com.umeng.message.UmengNotificationClickHandler";

    public void dealWithCustomAction(Context context, ahf ahfVar) {
    }

    public void dismissNotification(Context context, ahf ahfVar) {
    }

    @Override // com.umeng.message.UHandler
    public void handleMessage(Context context, ahf ahfVar) {
        try {
            if (!ahfVar.f998x) {
                dismissNotification(context, ahfVar);
                return;
            }
            if (TextUtils.equals("autoupdate", ahfVar.f978d) && PushAgent.getInstance(context).isIncludesUmengUpdateSDK()) {
                autoUpdate(context, ahfVar);
                return;
            }
            if (!TextUtils.isEmpty(ahfVar.f987m)) {
                if (TextUtils.equals("go_url", ahfVar.f987m)) {
                    openUrl(context, ahfVar);
                    return;
                }
                if (TextUtils.equals("go_activity", ahfVar.f987m)) {
                    openActivity(context, ahfVar);
                    return;
                } else if (TextUtils.equals("go_custom", ahfVar.f987m)) {
                    dealWithCustomAction(context, ahfVar);
                    return;
                } else if (TextUtils.equals("go_app", ahfVar.f987m)) {
                    launchApp(context, ahfVar);
                    return;
                }
            }
            if (ahfVar.f989o != null && !TextUtils.isEmpty(ahfVar.f989o.trim())) {
                openUrl(context, ahfVar);
                return;
            }
            if (ahfVar.f993s != null && !TextUtils.isEmpty(ahfVar.f993s.trim())) {
                openActivity(context, ahfVar);
            } else if (ahfVar.f988n != null && !TextUtils.isEmpty(ahfVar.f988n.trim())) {
                dealWithCustomAction(context, ahfVar);
            } else {
                launchApp(context, ahfVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autoUpdate(Context context, ahf ahfVar) {
        try {
            Object msgConfigInfo_UpdateResponse = MsgLogStore.getInstance(context).getMsgConfigInfo_UpdateResponse();
            Class<?> cls = Class.forName("ajd");
            Class<?> cls2 = Class.forName("ajg");
            Method method = cls.getMethod("showUpdateDialog", Context.class, cls2);
            if (msgConfigInfo_UpdateResponse != null) {
                method.invoke(cls, context, cls2.cast(msgConfigInfo_UpdateResponse));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openUrl(Context context, ahf ahfVar) {
        if (ahfVar.f989o == null || TextUtils.isEmpty(ahfVar.f989o.trim())) {
            return;
        }
        ahb.m1043c(f9250a, "handleMessage(): open url: " + ahfVar.f989o);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ahfVar.f989o));
        m8753a(intent, ahfVar);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void openActivity(Context context, ahf ahfVar) {
        if (ahfVar.f993s == null || TextUtils.isEmpty(ahfVar.f993s.trim())) {
            return;
        }
        Intent intent = new Intent();
        m8753a(intent, ahfVar);
        intent.setClassName(context, ahfVar.f993s);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void launchApp(Context context, ahf ahfVar) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            ahb.m1041b(f9250a, "handleMessage(): cannot find app: " + context.getPackageName());
            return;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(268435456);
        m8753a(launchIntentForPackage, ahfVar);
        context.startActivity(launchIntentForPackage);
        ahb.m1043c(f9250a, "handleMessage(): lunach app: " + context.getPackageName());
    }

    /* JADX INFO: renamed from: a */
    private Intent m8753a(Intent intent, ahf ahfVar) {
        if (intent == null || ahfVar == null || ahfVar.f995u == null) {
            return intent;
        }
        for (Map.Entry<String, String> entry : ahfVar.f995u.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                intent.putExtra(key, value);
            }
        }
        return intent;
    }
}
