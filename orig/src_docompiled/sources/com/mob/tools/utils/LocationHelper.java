package com.mob.tools.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class LocationHelper implements LocationListener, Handler.Callback {
    private boolean gpsRequesting;
    private int gpsTimeoutSec;
    private Handler handler;

    /* JADX INFO: renamed from: lm */
    private LocationManager f9022lm;
    private boolean networkRequesting;
    private int networkTimeoutSec;
    private Location res;

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public LocationHelper() {
        MobHandlerThread mobHandlerThread = new MobHandlerThread();
        mobHandlerThread.start();
        this.handler = new Handler(mobHandlerThread.getLooper(), this);
    }

    public Location getLocation(Context context) {
        return getLocation(context, 0);
    }

    public Location getLocation(Context context, int i) {
        return getLocation(context, i, 0);
    }

    public Location getLocation(Context context, int i, int i2) {
        return getLocation(context, i, i2, true);
    }

    public Location getLocation(Context context, int i, int i2, boolean z) {
        this.gpsTimeoutSec = i;
        this.networkTimeoutSec = i2;
        this.f9022lm = (LocationManager) context.getSystemService("location");
        if (this.f9022lm == null) {
            return null;
        }
        synchronized (this) {
            this.handler.sendEmptyMessageDelayed(0, 50L);
            wait();
        }
        if (this.res == null && z) {
            boolean z2 = i != 0;
            boolean z3 = i2 != 0;
            if (z2 && this.f9022lm.isProviderEnabled("gps")) {
                this.res = this.f9022lm.getLastKnownLocation("gps");
            } else if (z3 && this.f9022lm.isProviderEnabled("network")) {
                this.res = this.f9022lm.getLastKnownLocation("network");
            }
        }
        return this.res;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            onRequest();
            return false;
        }
        if (this.gpsRequesting) {
            onGPSTimeout();
            return false;
        }
        if (!this.networkRequesting) {
            return false;
        }
        this.f9022lm.removeUpdates(this);
        synchronized (this) {
            notifyAll();
        }
        this.handler.getLooper().quit();
        return false;
    }

    private void onRequest() {
        boolean z = this.gpsTimeoutSec != 0;
        boolean z2 = this.networkTimeoutSec != 0;
        if (z && this.f9022lm.isProviderEnabled("gps")) {
            this.gpsRequesting = true;
            this.f9022lm.requestLocationUpdates("gps", 1000L, 0.0f, this);
            if (this.gpsTimeoutSec > 0) {
                this.handler.sendEmptyMessageDelayed(1, this.gpsTimeoutSec * 1000);
                return;
            }
            return;
        }
        if (z2 && this.f9022lm.isProviderEnabled("network")) {
            this.networkRequesting = true;
            this.f9022lm.requestLocationUpdates("network", 1000L, 0.0f, this);
            if (this.networkTimeoutSec > 0) {
                this.handler.sendEmptyMessageDelayed(1, this.networkTimeoutSec * 1000);
                return;
            }
            return;
        }
        synchronized (this) {
            notifyAll();
        }
        this.handler.getLooper().quit();
    }

    private void onGPSTimeout() {
        this.f9022lm.removeUpdates(this);
        this.gpsRequesting = false;
        if ((this.networkTimeoutSec != 0) && this.f9022lm.isProviderEnabled("network")) {
            this.networkRequesting = true;
            this.f9022lm.requestLocationUpdates("network", 1000L, 0.0f, this);
            if (this.networkTimeoutSec > 0) {
                this.handler.sendEmptyMessageDelayed(1, this.networkTimeoutSec * 1000);
                return;
            }
            return;
        }
        synchronized (this) {
            notifyAll();
        }
        this.handler.getLooper().quit();
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        synchronized (this) {
            this.f9022lm.removeUpdates(this);
            this.res = location;
            notifyAll();
        }
        this.handler.getLooper().quit();
    }
}
