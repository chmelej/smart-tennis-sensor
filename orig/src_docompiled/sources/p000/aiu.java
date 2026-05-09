package p000;

import android.annotation.SuppressLint;
import android.net.LocalServerSocket;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: LocalSocketDistributedLock.java */
/* JADX INFO: loaded from: classes.dex */
public class aiu extends ait {

    /* JADX INFO: renamed from: b */
    private String f1200b;

    /* JADX INFO: renamed from: c */
    private LocalServerSocket f1201c = null;

    @SuppressLint({"SimpleDateFormat"})
    /* JADX INFO: renamed from: e */
    private static final String m1410e() {
        try {
            return new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
        } catch (Throwable unused) {
            return "none";
        }
    }

    public aiu(String str, int i) {
        if (str == null || "".equals(str)) {
            this.f1200b = String.format("%s_%s", "local_socket_lock_", m1410e());
        } else {
            this.f1200b = String.format("%s_%s", str, m1410e());
        }
    }

    @Override // p000.ait
    /* JADX INFO: renamed from: a */
    protected void mo1405a() {
        mo1406a(2147483647L, TimeUnit.SECONDS);
    }

    @Override // p000.ait
    /* JADX INFO: renamed from: d */
    protected void mo1409d() {
        mo1406a(2147483647L, TimeUnit.SECONDS);
    }

    @Override // p000.ait
    /* JADX INFO: renamed from: c */
    protected boolean mo1408c() {
        return mo1406a(0L, TimeUnit.SECONDS);
    }

    @Override // p000.ait
    /* JADX INFO: renamed from: a */
    protected boolean mo1406a(long j, TimeUnit timeUnit) {
        try {
            if (this.f1201c != null) {
                return false;
            }
            this.f1201c = new LocalServerSocket(this.f1200b);
            return true;
        } catch (Throwable th) {
            Log.e("LocalSocket2DistributedLock", "doTryLock", th);
            return false;
        }
    }

    @Override // p000.ait
    /* JADX INFO: renamed from: b */
    protected void mo1407b() {
        try {
            if (this.f1201c != null) {
                this.f1201c.close();
            }
        } catch (Throwable unused) {
        }
    }
}
