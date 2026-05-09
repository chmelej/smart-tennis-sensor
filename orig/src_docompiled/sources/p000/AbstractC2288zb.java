package p000;

import android.content.Context;

/* JADX INFO: renamed from: zb */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2288zb {

    /* JADX INFO: renamed from: a */
    protected Context f13775a;

    protected AbstractC2288zb(Context context) {
        this.f13775a = null;
        this.f13775a = context;
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo12519a(String str);

    /* JADX INFO: renamed from: a */
    public final void m12527a(C2284yy c2284yy) {
        if (c2284yy == null) {
            return;
        }
        String string = c2284yy.toString();
        if (mo12520a()) {
            mo12519a(C2290zd.m12541d(string));
        }
    }

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo12520a();

    /* JADX INFO: renamed from: b */
    protected abstract String mo12521b();

    /* JADX INFO: renamed from: c */
    public final C2284yy m12528c() {
        String strM12540c = mo12520a() ? C2290zd.m12540c(mo12521b()) : null;
        if (strM12540c != null) {
            return C2284yy.m12522a(strM12540c);
        }
        return null;
    }
}
