package org.android.agoo.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import p000.apr;
import p000.apw;
import p000.arh;

/* JADX INFO: loaded from: classes.dex */
public abstract class AgooService extends Service {
    private static final String TAG = "AgooService";
    private volatile apr pushService = null;
    private Context mContext = this;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        try {
            if (this.pushService != null) {
                return this.pushService.bind(intent);
            }
            Log.d(TAG, "onBind[pushService==null]");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        try {
            if (this.pushService != null) {
                return this.pushService.unbind(intent);
            }
            Log.d(TAG, "onBind[pushService==null]");
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        try {
            this.pushService = (apr) arh.m5265a(this, "org.android.agoo.impl.PushService");
            Log.d(TAG, "pushService==[" + this.pushService.getClass().getName() + "]");
            if (this.pushService != null) {
                this.pushService.create(this, new apw() { // from class: org.android.agoo.service.AgooService.1
                    @Override // p000.apw
                    public void stop() {
                        AgooService.this.stopSelf();
                    }
                });
            }
            if (Build.VERSION.SDK_INT < 18) {
                startForeground(-1469, new Notification());
            }
            new Handler(Looper.getMainLooper());
        } catch (Throwable th) {
            Log.e(TAG, "onCreate", th);
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
        } catch (Throwable th) {
            Log.e(TAG, "onStartCommand", th);
        }
        if (this.pushService != null) {
            return this.pushService.startCommand(intent, i, i2);
        }
        Log.d(TAG, "onStartCommand[pushService==null]");
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        try {
            if (this.pushService != null) {
                this.pushService.destroy(this.mContext);
            }
        } catch (Throwable unused) {
        }
    }
}
