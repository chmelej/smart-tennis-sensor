package com.mob.commons;

import android.content.Context;
import com.mob.tools.utils.SharePrefrenceHelper;

/* JADX INFO: renamed from: com.mob.commons.f */
/* JADX INFO: compiled from: ProcessLevelSPDB.java */
/* JADX INFO: loaded from: classes.dex */
public class C1558f {

    /* JADX INFO: renamed from: a */
    private static SharePrefrenceHelper f9001a;

    /* JADX INFO: renamed from: h */
    private static synchronized void m8570h(Context context) {
        if (f9001a == null) {
            f9001a = new SharePrefrenceHelper(context.getApplicationContext());
            f9001a.open("mob_commons", 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized String m8555a(Context context) {
        m8570h(context);
        return f9001a.getString("key_ext_info");
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m8557a(Context context, String str) {
        m8570h(context);
        f9001a.putString("key_ext_info", str);
    }

    /* JADX INFO: renamed from: b */
    public static synchronized long m8558b(Context context) {
        m8570h(context);
        return f9001a.getLong("wifi_last_time");
    }

    /* JADX INFO: renamed from: a */
    public static synchronized void m8556a(Context context, long j) {
        m8570h(context);
        f9001a.putLong("wifi_last_time", Long.valueOf(j));
    }

    /* JADX INFO: renamed from: c */
    public static synchronized String m8561c(Context context) {
        m8570h(context);
        return f9001a.getString("wifi_last_info");
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m8560b(Context context, String str) {
        m8570h(context);
        f9001a.putString("wifi_last_info", str);
    }

    /* JADX INFO: renamed from: c */
    public static synchronized void m8562c(Context context, String str) {
        m8570h(context);
        f9001a.putString("key_cellinfo", str);
    }

    /* JADX INFO: renamed from: d */
    public static synchronized String m8563d(Context context) {
        m8570h(context);
        return f9001a.getString("key_cellinfo");
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m8559b(Context context, long j) {
        m8570h(context);
        f9001a.putLong("key_cellinfo_next_total", Long.valueOf(j));
    }

    /* JADX INFO: renamed from: d */
    public static synchronized void m8564d(Context context, String str) {
        m8570h(context);
        f9001a.putString("key_switches", str);
    }

    /* JADX INFO: renamed from: e */
    public static synchronized String m8565e(Context context) {
        m8570h(context);
        return f9001a.getString("key_switches");
    }

    /* JADX INFO: renamed from: e */
    public static synchronized void m8566e(Context context, String str) {
        m8570h(context);
        if (str == null) {
            f9001a.remove("key_data_url");
        } else {
            f9001a.putString("key_data_url", str);
        }
    }

    /* JADX INFO: renamed from: f */
    public static synchronized String m8567f(Context context) {
        m8570h(context);
        return f9001a.getString("key_data_url");
    }

    /* JADX INFO: renamed from: f */
    public static synchronized void m8568f(Context context, String str) {
        m8570h(context);
        if (str == null) {
            f9001a.remove("key_conf_url");
        } else {
            f9001a.putString("key_conf_url", str);
        }
    }

    /* JADX INFO: renamed from: g */
    public static synchronized String m8569g(Context context) {
        m8570h(context);
        return f9001a.getString("key_conf_url");
    }
}
