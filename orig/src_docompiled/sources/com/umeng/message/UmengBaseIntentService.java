package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.message.local.UmengLocalNotificationService;
import org.android.agoo.client.BaseIntentService;
import org.json.JSONObject;
import p000.ahb;
import p000.ahf;
import p000.ahj;
import p000.ail;

/* JADX INFO: loaded from: classes.dex */
public abstract class UmengBaseIntentService extends BaseIntentService {

    /* JADX INFO: renamed from: a */
    private static final String f9225a = "com.umeng.message.UmengBaseIntentService";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.android.agoo.client.BaseIntentService
    /* JADX INFO: renamed from: a */
    public void mo8735a(Context context, Intent intent) {
        if (Process.getElapsedCpuTime() < 3000) {
            ahb.m1039a(f9225a, "App is launched by push message");
            PushAgent.setAppLaunchByMessage();
        }
        String stringExtra = intent.getStringExtra("body");
        ahb.m1043c(f9225a, "onMessage():[" + stringExtra + "]");
        try {
            ahf ahfVar = new ahf(new JSONObject(stringExtra));
            ahfVar.f976b = intent.getStringExtra("id");
            ahfVar.f977c = intent.getStringExtra("task_id");
            UTrack.getInstance(getApplicationContext()).m8733a(ahfVar);
            MsgLogStore.getInstance(context).addLogIdType(ahfVar.f975a, ahfVar.f978d);
            MsgLogStore.getInstance(context).addLogIdTypeForAgoo(ahfVar.f976b, ahfVar.f977c, ahfVar.f978d);
            if (TextUtils.equals("autoupdate", ahfVar.f978d)) {
                String stringExtra2 = intent.getStringExtra("id");
                String stringExtra3 = intent.getStringExtra("task_id");
                Intent intent2 = new Intent();
                intent2.setPackage(context.getPackageName());
                intent2.setAction(MsgConstant.MESSAGE_AUTOUPDATE_HANDLER_ACTION);
                intent2.putExtra("body", stringExtra);
                intent2.putExtra("id", stringExtra2);
                intent2.putExtra("task_id", stringExtra3);
                context.startService(intent2);
            }
            if (ail.m1344a(this, UmengLocalNotificationService.class.getName())) {
                return;
            }
            ahj.m1134a(this).m1142c();
        } catch (Exception e) {
            e.printStackTrace();
            ahb.m1043c(f9225a, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.android.agoo.client.BaseIntentService
    /* JADX INFO: renamed from: a */
    public void mo8736a(Context context, String str) {
        ahb.m1043c(f9225a, "onError()[" + str + "]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.android.agoo.client.BaseIntentService
    /* JADX INFO: renamed from: b */
    public void mo8737b(Context context, String str) {
        ahb.m1043c(f9225a, "onRegistered()[" + str + "]");
        try {
            UTrack.getInstance(getApplicationContext()).trackRegister();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
        intent.putExtra(MsgConstant.KEY_REGISTRATION_ID, str);
        context.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.android.agoo.client.BaseIntentService
    /* JADX INFO: renamed from: c */
    public void mo8738c(Context context, String str) {
        ahb.m1043c(f9225a, "onUnregistered()[" + str + "]");
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction(MsgConstant.MESSAGE_UNREGISTER_CALLBACK_ACTION);
        intent.putExtra(MsgConstant.KEY_REGISTRATION_ID, str);
        context.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.android.agoo.client.BaseIntentService
    /* JADX INFO: renamed from: a */
    public final Class<?> mo8734a() {
        ahb.m1043c(f9225a, "getAgooService");
        return UmengService.class.getClass();
    }

    @Override // p000.apv
    public Class<?> callAgooElectionReceiver() {
        ahb.m1043c(f9225a, "callAgooElectionReceiver");
        return ElectionReceiver.class;
    }

    @Override // p000.apv
    public Class<?> callAgooMessageReceiver() {
        ahb.m1043c(f9225a, "callAgooMessageReceiver");
        return MessageReceiver.class;
    }

    @Override // p000.apv
    public Class<?> callAgooRegistrationReceiver() {
        ahb.m1043c(f9225a, "callAgooRegistrationReceiver");
        return RegistrationReceiver.class;
    }

    @Override // p000.apv
    public Class<?> callAgooSystemReceiver() {
        ahb.m1043c(f9225a, "callAgooSystemReceiver");
        return SystemReceiver.class;
    }
}
