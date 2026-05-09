package com.mob.commons.logcollector;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.MobLog;
import com.mob.tools.log.LogCollector;

/* JADX INFO: loaded from: classes.dex */
public abstract class LogsCollector implements LogCollector {

    /* JADX INFO: renamed from: a */
    private C1561c f9002a;

    /* JADX INFO: renamed from: b */
    private boolean f9003b;

    protected abstract String getAppkey();

    protected abstract String getSDKTag();

    protected abstract int getSDKVersion();

    public LogsCollector(Context context) {
        this.f9002a = C1561c.m8577a(context);
        this.f9002a.m8590a(getSDKVersion(), getSDKTag(), getAppkey());
        try {
            if (context.getPackageManager().getPackageInfo("cn.sharesdk.log", 64) != null) {
                this.f9003b = true;
            }
        } catch (Throwable unused) {
        }
        this.f9003b = false;
    }

    @Override // com.mob.tools.log.LogCollector
    public final void log(String str, int i, int i2, String str2, String str3) {
        m8571a(i, str3);
        if (str == null || !str.equals(getSDKTag())) {
            return;
        }
        if (!ShareSDK.SDK_TAG.equals(str) || (str3.contains("com.mob.") && str3.contains("cn.sharesdk."))) {
            if (i2 == 1) {
                this.f9002a.m8591b(getSDKVersion(), i2, str, getAppkey(), str3);
            } else if (i2 == 2) {
                this.f9002a.m8589a(getSDKVersion(), i2, str, getAppkey(), str3);
            } else if (i == 5) {
                this.f9002a.m8589a(getSDKVersion(), i2, str, getAppkey(), str3);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final int m8571a(int i, String str) {
        if (this.f9002a.m8588a() == null || !this.f9003b) {
            return 0;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("cn.sharesdk.log");
            intent.putExtra("package", this.f9002a.m8588a().getPackageName());
            intent.putExtra("priority", i);
            intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, str);
            this.f9002a.m8588a().sendBroadcast(intent);
            return 0;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return 0;
        }
    }
}
