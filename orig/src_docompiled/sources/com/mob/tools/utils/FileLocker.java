package com.mob.tools.utils;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes.dex */
public class FileLocker {
    private FileOutputStream fos;
    private FileLock lock;

    public synchronized void setLockFile(String str) {
        try {
            this.fos = new FileOutputStream(str);
        } catch (Throwable unused) {
            if (this.fos != null) {
                try {
                    this.fos.close();
                } catch (Throwable unused2) {
                }
                this.fos = null;
            }
        }
    }

    public synchronized boolean lock(boolean z) {
        if (this.fos == null) {
            return false;
        }
        try {
            if (z) {
                this.lock = this.fos.getChannel().lock();
            } else {
                this.lock = this.fos.getChannel().tryLock();
            }
        } catch (Throwable unused) {
            if (this.lock != null) {
                try {
                    this.lock.release();
                } catch (Throwable unused2) {
                }
                this.lock = null;
            }
        }
        return this.lock != null;
    }

    public synchronized void lock(Runnable runnable, boolean z) {
        if (lock(z) && runnable != null) {
            runnable.run();
        }
    }

    public synchronized void unlock() {
        if (this.lock == null) {
            return;
        }
        try {
            this.lock.release();
            this.lock = null;
        } catch (Throwable unused) {
        }
    }

    public synchronized void release() {
        if (this.fos == null) {
            return;
        }
        unlock();
        try {
            this.fos.close();
            this.fos = null;
        } catch (Throwable unused) {
        }
    }
}
