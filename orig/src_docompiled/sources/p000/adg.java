package p000;

import android.content.Context;

/* JADX INFO: compiled from: IDFATracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adg extends agz {

    /* JADX INFO: renamed from: a */
    private Context f402a;

    public adg(Context context) {
        super("idfa");
        this.f402a = context;
    }

    @Override // p000.agz
    /* JADX INFO: renamed from: a */
    public String mo342a() {
        String strM696a = aer.m696a(this.f402a);
        return strM696a == null ? "" : strM696a;
    }
}
