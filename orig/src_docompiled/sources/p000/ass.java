package p000;

import android.content.res.Resources;
import android.util.Log;

/* JADX INFO: compiled from: ErrorDialogConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class ass {

    /* JADX INFO: renamed from: a */
    final Resources f4995a;

    /* JADX INFO: renamed from: b */
    final int f4996b;

    /* JADX INFO: renamed from: c */
    final int f4997c;

    /* JADX INFO: renamed from: d */
    final asu f4998d;

    /* JADX INFO: renamed from: e */
    asd f4999e;

    /* JADX INFO: renamed from: f */
    public boolean f5000f;

    /* JADX INFO: renamed from: g */
    public String f5001g;

    /* JADX INFO: renamed from: h */
    int f5002h;

    /* JADX INFO: renamed from: i */
    Class<?> f5003i;

    /* JADX INFO: renamed from: a */
    public int m5366a(Throwable th) {
        Integer numM5372a = this.f4998d.m5372a(th);
        if (numM5372a != null) {
            return numM5372a.intValue();
        }
        Log.d(asd.f4913a, "No specific message ressource ID found for " + th);
        return this.f4997c;
    }

    /* JADX INFO: renamed from: a */
    public asd m5367a() {
        return this.f4999e != null ? this.f4999e : asd.m5323a();
    }
}
