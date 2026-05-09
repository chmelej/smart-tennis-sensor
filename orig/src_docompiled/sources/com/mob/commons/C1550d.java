package com.mob.commons;

import android.content.Context;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ResHelper;
import java.io.File;

/* JADX INFO: renamed from: com.mob.commons.d */
/* JADX INFO: compiled from: DeviceLevelTags.java */
/* JADX INFO: loaded from: classes.dex */
public class C1550d {
    /* JADX INFO: renamed from: a */
    public static synchronized boolean m8530a(Context context, String str) {
        try {
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return true;
        }
        return new File(ResHelper.getCacheRoot(context), str).exists();
    }

    /* JADX INFO: renamed from: b */
    public static synchronized void m8531b(Context context, String str) {
        try {
            File file = new File(ResHelper.getCacheRoot(context), str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    /* JADX INFO: renamed from: c */
    public static synchronized void m8532c(Context context, String str) {
        File file;
        try {
            file = new File(ResHelper.getCacheRoot(context), str);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        if (file.exists()) {
            file.delete();
        }
    }
}
