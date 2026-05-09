package com.umeng.message.local;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import p000.ahh;
import p000.ahi;
import p000.ahj;
import p000.ahk;

/* JADX INFO: loaded from: classes.dex */
public class UmengLocalNotificationService extends IntentService {

    /* JADX INFO: renamed from: a */
    private static final String f9254a = "com.umeng.message.local.UmengLocalNotificationService";

    /* JADX INFO: renamed from: b */
    private Context f9255b;

    public UmengLocalNotificationService() {
        super("UmengLocalNotificationService");
    }

    public UmengLocalNotificationService(String str) {
        super(str);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        Log.d(f9254a, "onCreate");
        super.onCreate();
    }

    @Override // android.app.IntentService, android.app.Service
    @SuppressLint({"NewApi"})
    public int onStartCommand(Intent intent, int i, int i2) {
        this.f9255b = this;
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("local_notification_id");
        String stringExtra2 = intent.getStringExtra("local_notification_type");
        if (TextUtils.equals(stringExtra2, "add_local_notification")) {
            m8756a(stringExtra, "display_local_notification");
            return;
        }
        if (TextUtils.equals(stringExtra2, "update_local_notification")) {
            m8757b(stringExtra, "display_local_notification");
            m8756a(stringExtra, "display_local_notification");
            return;
        }
        if (TextUtils.equals(stringExtra2, "delete_local_notification")) {
            m8757b(stringExtra, "display_local_notification");
            return;
        }
        if (TextUtils.equals(stringExtra2, "clear_local_notification")) {
            m8758c(stringExtra, "display_local_notification");
        } else if (TextUtils.equals(stringExtra2, "display_local_notification")) {
            m8755a(stringExtra);
            m8757b(stringExtra, "display_local_notification");
            m8756a(stringExtra, "display_local_notification");
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        Log.d(f9254a, "onDestory");
        super.onDestroy();
    }

    /* JADX INFO: renamed from: a */
    private void m8755a(String str) {
        try {
            Log.d(f9254a, "displayLocalNotification");
            ahh ahhVarM1145a = ahk.m1144a(this.f9255b).m1145a(str);
            if (ahhVarM1145a != null && ahhVarM1145a.m1118h() != 0) {
                ahhVarM1145a.m1125o().m1161a(this.f9255b, ahhVarM1145a.m1125o().m1159a(this.f9255b, ahhVarM1145a.m1122l(), ahhVarM1145a.m1123m(), ahhVarM1145a.m1124n()));
            }
        } catch (Exception e) {
            Log.d(f9254a, e.toString());
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8756a(String str, String str2) {
        try {
            ahh ahhVarM1145a = ahk.m1144a(this.f9255b).m1145a(str);
            if (ahhVarM1145a == null) {
                return;
            }
            long jM1130a = ahi.m1130a(this.f9255b, ahhVarM1145a);
            Log.d(f9254a, "time=" + ahi.m1133a(jM1130a));
            if (ahhVarM1145a.m1118h() == 0) {
                try {
                    ahj.m1134a(this.f9255b).m1143c(str);
                    m8757b(str, str2);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(f9254a, e.toString());
                    return;
                }
            }
            ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, jM1130a, m8759d(str, str2));
        } catch (Exception e2) {
            Log.d(f9254a, e2.toString());
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8757b(String str, String str2) {
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(m8759d(str, str2));
    }

    /* JADX INFO: renamed from: c */
    private void m8758c(String str, String str2) {
        for (String str3 : str.split(";")) {
            m8757b(str3, str2);
        }
    }

    /* JADX INFO: renamed from: d */
    private PendingIntent m8759d(String str, String str2) {
        int iHashCode = str.hashCode();
        Intent intent = new Intent(this.f9255b, (Class<?>) UmengLocalNotificationService.class);
        intent.putExtra("local_notification_id", str);
        intent.putExtra("local_notification_type", str2);
        return PendingIntent.getService(this.f9255b, iHashCode, intent, 134217728);
    }
}
