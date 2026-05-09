package p000;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: HandlerPoster.java */
/* JADX INFO: loaded from: classes.dex */
final class asg extends Handler {

    /* JADX INFO: renamed from: a */
    private final asj f4952a;

    /* JADX INFO: renamed from: b */
    private final int f4953b;

    /* JADX INFO: renamed from: c */
    private final asd f4954c;

    /* JADX INFO: renamed from: d */
    private boolean f4955d;

    asg(asd asdVar, Looper looper, int i) {
        super(looper);
        this.f4954c = asdVar;
        this.f4953b = i;
        this.f4952a = new asj();
    }

    /* JADX INFO: renamed from: a */
    void m5340a(aso asoVar, Object obj) {
        asi asiVarM5341a = asi.m5341a(asoVar, obj);
        synchronized (this) {
            this.f4952a.m5345a(asiVarM5341a);
            if (!this.f4955d) {
                this.f4955d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new asf("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                asi asiVarM5343a = this.f4952a.m5343a();
                if (asiVarM5343a == null) {
                    synchronized (this) {
                        asiVarM5343a = this.f4952a.m5343a();
                        if (asiVarM5343a == null) {
                            this.f4955d = false;
                            return;
                        }
                    }
                }
                this.f4954c.m5333a(asiVarM5343a);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f4953b);
            if (!sendMessage(obtainMessage())) {
                throw new asf("Could not send handler message");
            }
            this.f4955d = true;
        } finally {
            this.f4955d = false;
        }
    }
}
