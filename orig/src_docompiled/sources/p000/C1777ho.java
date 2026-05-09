package p000;

import android.renderscript.BaseObj;
import android.support.p002v8.renderscript.RenderScript;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: renamed from: ho */
/* JADX INFO: compiled from: BaseObj.java */
/* JADX INFO: loaded from: classes.dex */
public class C1777ho {

    /* JADX INFO: renamed from: a */
    private long f10227a;

    /* JADX INFO: renamed from: b */
    private boolean f10228b;

    /* JADX INFO: renamed from: r */
    RenderScript f10229r;

    /* JADX INFO: renamed from: c */
    BaseObj m9699c() {
        return null;
    }

    C1777ho(long j, RenderScript renderScript) {
        renderScript.m4413f();
        this.f10229r = renderScript;
        this.f10227a = j;
        this.f10228b = false;
    }

    /* JADX INFO: renamed from: a */
    long m9698a(RenderScript renderScript) {
        this.f10229r.m4413f();
        if (this.f10228b) {
            throw new C1782ht("using a destroyed object.");
        }
        if (this.f10227a == 0) {
            throw new C1783hu("Internal error: Object id 0.");
        }
        if (renderScript != null && renderScript != this.f10229r) {
            throw new C1782ht("using object with mismatched context.");
        }
        return this.f10227a;
    }

    /* JADX INFO: renamed from: d */
    void m9700d() {
        if (this.f10227a == 0 && m9699c() == null) {
            throw new C1781hs("Invalid object.");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9697a() {
        boolean z;
        synchronized (this) {
            z = true;
            if (this.f10228b) {
                z = false;
            } else {
                this.f10228b = true;
            }
        }
        if (z) {
            ReentrantReadWriteLock.ReadLock lock = this.f10229r.f4122l.readLock();
            lock.lock();
            if (this.f10229r.m4416i()) {
                this.f10229r.m4398a(this.f10227a);
            }
            lock.unlock();
            this.f10229r = null;
            this.f10227a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        m9697a();
        super.finalize();
    }

    /* JADX INFO: renamed from: b */
    public void mo9696b() {
        if (this.f10228b) {
            throw new C1782ht("Object already destroyed.");
        }
        m9697a();
    }

    public int hashCode() {
        return (int) ((this.f10227a & 268435455) ^ (this.f10227a >> 32));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f10227a == ((C1777ho) obj).f10227a;
    }
}
