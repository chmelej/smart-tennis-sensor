package p000;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class abj {

    /* JADX INFO: renamed from: a */
    private String f112a;

    /* JADX INFO: renamed from: b */
    private boolean f113b;

    /* JADX INFO: renamed from: c */
    private int f114c;

    public abj() {
        this.f112a = "default";
        this.f113b = true;
        this.f114c = 2;
    }

    public abj(String str) {
        this.f112a = "default";
        this.f113b = true;
        this.f114c = 2;
        this.f112a = str;
    }

    /* JADX INFO: renamed from: b */
    private String m49b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final void m50a() {
        this.f113b = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m51a(Object obj) {
        String string;
        if (!this.f113b || this.f114c > 4) {
            return;
        }
        String strM49b = m49b();
        if (strM49b == null) {
            string = obj.toString();
        } else {
            string = strM49b + " - " + obj;
        }
        Log.i(this.f112a, string);
        acb.m192w();
    }

    /* JADX INFO: renamed from: a */
    public final void m52a(Throwable th) {
        if (this.f114c <= 6) {
            Log.e(this.f112a, "", th);
            acb.m192w();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m53b(Object obj) {
        String string;
        if (this.f114c <= 5) {
            String strM49b = m49b();
            if (strM49b == null) {
                string = obj.toString();
            } else {
                string = strM49b + " - " + obj;
            }
            Log.w(this.f112a, string);
            acb.m192w();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m54b(Throwable th) {
        if (this.f113b) {
            m52a(th);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m55c(Object obj) {
        if (this.f113b) {
            m53b(obj);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m56d(Object obj) {
        String string;
        if (this.f114c <= 6) {
            String strM49b = m49b();
            if (strM49b == null) {
                string = obj.toString();
            } else {
                string = strM49b + " - " + obj;
            }
            Log.e(this.f112a, string);
            acb.m192w();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m57e(Object obj) {
        if (this.f113b) {
            m56d(obj);
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m58f(Object obj) {
        String string;
        if (this.f114c <= 3) {
            String strM49b = m49b();
            if (strM49b == null) {
                string = obj.toString();
            } else {
                string = strM49b + " - " + obj;
            }
            Log.d(this.f112a, string);
            acb.m192w();
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m59g(Object obj) {
        if (this.f113b) {
            m58f(obj);
        }
    }
}
