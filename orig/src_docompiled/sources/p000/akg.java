package p000;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: HandlerPoster.java */
/* JADX INFO: loaded from: classes.dex */
final class akg extends Handler {

    /* JADX INFO: renamed from: a */
    private final akj f1466a;

    /* JADX INFO: renamed from: b */
    private final int f1467b;

    /* JADX INFO: renamed from: c */
    private final akd f1468c;

    /* JADX INFO: renamed from: d */
    private boolean f1469d;

    akg(akd akdVar, Looper looper, int i) {
        super(looper);
        this.f1468c = akdVar;
        this.f1467b = i;
        this.f1466a = new akj();
    }

    /* JADX INFO: renamed from: a */
    void m1724a(akn aknVar, Object obj) {
        aki akiVarM1725a = aki.m1725a(aknVar, obj);
        synchronized (this) {
            this.f1466a.m1729a(akiVarM1725a);
            if (!this.f1469d) {
                this.f1469d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new akf("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                aki akiVarM1727a = this.f1466a.m1727a();
                if (akiVarM1727a == null) {
                    synchronized (this) {
                        akiVarM1727a = this.f1466a.m1727a();
                        if (akiVarM1727a == null) {
                            this.f1469d = false;
                            return;
                        }
                    }
                }
                this.f1468c.m1717a(akiVarM1727a);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f1467b);
            if (!sendMessage(obtainMessage())) {
                throw new akf("Could not send handler message");
            }
            this.f1469d = true;
        } finally {
            this.f1469d = false;
        }
    }
}
