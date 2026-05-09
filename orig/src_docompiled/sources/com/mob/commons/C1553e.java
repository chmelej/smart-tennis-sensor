package com.mob.commons;

import com.mob.tools.MobLog;
import com.mob.tools.utils.FileLocker;
import java.io.File;

/* JADX INFO: renamed from: com.mob.commons.e */
/* JADX INFO: compiled from: Locks.java */
/* JADX INFO: loaded from: classes.dex */
public class C1553e {
    /* JADX INFO: renamed from: a */
    public static final void m8546a(File file, Runnable runnable) {
        m8547a(file, true, runnable);
    }

    /* JADX INFO: renamed from: a */
    public static final void m8547a(File file, boolean z, Runnable runnable) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileLocker fileLocker = new FileLocker();
            fileLocker.setLockFile(file.getAbsolutePath());
            if (fileLocker.lock(z)) {
                runnable.run();
                fileLocker.release();
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }
}
