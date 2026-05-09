package com.mob.tools;

import android.os.Looper;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class MobHandlerThread extends Thread {
    private Looper looper;
    private int priority;
    private int tid;

    protected void onLooperPrepared() {
    }

    public MobHandlerThread() {
        this.tid = -1;
        this.priority = 0;
    }

    public MobHandlerThread(int i) {
        this.tid = -1;
        this.priority = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.tid = Process.myTid();
        Looper.prepare();
        synchronized (this) {
            this.looper = Looper.myLooper();
            notifyAll();
        }
        Process.setThreadPriority(this.priority);
        onLooperPrepared();
        Looper.loop();
        this.tid = -1;
    }

    public Looper getLooper() {
        if (!isAlive()) {
            return null;
        }
        synchronized (this) {
            while (isAlive() && this.looper == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        return this.looper;
    }

    public boolean quit() {
        Looper looper = getLooper();
        if (looper == null) {
            return false;
        }
        looper.quit();
        return true;
    }

    public int getThreadId() {
        return this.tid;
    }
}
