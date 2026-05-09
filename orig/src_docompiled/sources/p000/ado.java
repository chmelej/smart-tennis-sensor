package p000;

import android.os.Build;

/* JADX INFO: compiled from: SerialTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class ado extends agz {
    public ado() {
        super("serial");
    }

    @Override // p000.agz
    /* JADX INFO: renamed from: a */
    public String mo342a() {
        if (Build.VERSION.SDK_INT >= 9) {
            return Build.SERIAL;
        }
        return null;
    }
}
