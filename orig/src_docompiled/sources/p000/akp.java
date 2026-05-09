package p000;

import android.content.res.Resources;
import android.util.Log;

/* JADX INFO: compiled from: ErrorDialogConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class akp {

    /* JADX INFO: renamed from: a */
    final Resources f1497a;

    /* JADX INFO: renamed from: b */
    final int f1498b;

    /* JADX INFO: renamed from: c */
    final int f1499c;

    /* JADX INFO: renamed from: d */
    final akr f1500d;

    /* JADX INFO: renamed from: e */
    akd f1501e;

    /* JADX INFO: renamed from: f */
    public boolean f1502f;

    /* JADX INFO: renamed from: g */
    public String f1503g;

    /* JADX INFO: renamed from: h */
    int f1504h;

    /* JADX INFO: renamed from: i */
    Class<?> f1505i;

    /* JADX INFO: renamed from: a */
    public int m1734a(Throwable th) {
        Integer numM1740a = this.f1500d.m1740a(th);
        if (numM1740a != null) {
            return numM1740a.intValue();
        }
        Log.d(akd.f1430a, "No specific message ressource ID found for " + th);
        return this.f1499c;
    }

    /* JADX INFO: renamed from: a */
    public akd m1735a() {
        return this.f1501e != null ? this.f1501e : akd.m1706a();
    }
}
