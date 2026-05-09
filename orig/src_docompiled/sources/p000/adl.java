package p000;

import android.content.Context;

/* JADX INFO: compiled from: MacTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adl extends agz {

    /* JADX INFO: renamed from: a */
    private Context f436a;

    public adl(Context context) {
        super("mac");
        this.f436a = context;
    }

    @Override // p000.agz
    /* JADX INFO: renamed from: a */
    public String mo342a() {
        try {
            return aeu.m742n(this.f436a);
        } catch (Exception unused) {
            return null;
        }
    }
}
