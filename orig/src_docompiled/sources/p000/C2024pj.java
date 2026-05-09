package p000;

import android.util.Log;

/* JADX INFO: renamed from: pj */
/* JADX INFO: compiled from: AndroidLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class C2024pj extends AbstractC2029po {

    /* JADX INFO: renamed from: a */
    String f12187a;

    public C2024pj(String str) {
        this.f12187a = str;
    }

    @Override // p000.AbstractC2029po
    /* JADX INFO: renamed from: a */
    public void mo11091a(String str) {
        Log.d("isoparser", String.valueOf(this.f12187a) + ":" + str);
    }

    @Override // p000.AbstractC2029po
    /* JADX INFO: renamed from: b */
    public void mo11092b(String str) {
        Log.e("isoparser", String.valueOf(this.f12187a) + ":" + str);
    }
}
