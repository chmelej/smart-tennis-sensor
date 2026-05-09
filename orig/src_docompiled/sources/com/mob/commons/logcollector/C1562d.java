package com.mob.commons.logcollector;

import android.content.Context;
import com.mob.tools.utils.SharePrefrenceHelper;

/* JADX INFO: renamed from: com.mob.commons.logcollector.d */
/* JADX INFO: compiled from: LogsSharePrefrence.java */
/* JADX INFO: loaded from: classes.dex */
public class C1562d {

    /* JADX INFO: renamed from: a */
    private static C1562d f9015a;

    /* JADX INFO: renamed from: b */
    private SharePrefrenceHelper f9016b;

    private C1562d(Context context) {
        this.f9016b = new SharePrefrenceHelper(context.getApplicationContext());
        this.f9016b.open("mob_sdk_exception", 1);
    }

    /* JADX INFO: renamed from: a */
    public static C1562d m8592a(Context context) {
        if (f9015a == null) {
            f9015a = new C1562d(context);
        }
        return f9015a;
    }

    /* JADX INFO: renamed from: a */
    public void m8595a(long j) {
        this.f9016b.putLong("service_time", Long.valueOf(j));
    }

    /* JADX INFO: renamed from: a */
    public long m8593a() {
        return this.f9016b.getLong("service_time");
    }

    /* JADX INFO: renamed from: a */
    public void m8597a(boolean z) {
        this.f9016b.putInt("is_upload_err_log", Integer.valueOf(!z ? 1 : 0));
    }

    /* JADX INFO: renamed from: b */
    public boolean m8599b() {
        return this.f9016b.getInt("is_upload_err_log") == 0;
    }

    /* JADX INFO: renamed from: a */
    public void m8594a(int i) {
        this.f9016b.putInt("is_upload_crash", Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: c */
    public int m8600c() {
        return this.f9016b.getInt("is_upload_crash");
    }

    /* JADX INFO: renamed from: b */
    public void m8598b(int i) {
        this.f9016b.putInt("is_upload_sdkerr", Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: d */
    public int m8602d() {
        return this.f9016b.getInt("is_upload_sdkerr");
    }

    /* JADX INFO: renamed from: c */
    public void m8601c(int i) {
        this.f9016b.putInt("is_upload_apperr", Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: e */
    public int m8603e() {
        return this.f9016b.getInt("is_upload_apperr");
    }

    /* JADX INFO: renamed from: f */
    public String m8604f() {
        return this.f9016b.getString("err_log_filter");
    }

    /* JADX INFO: renamed from: a */
    public void m8596a(String str) {
        this.f9016b.putString("err_log_filter", str);
    }
}
