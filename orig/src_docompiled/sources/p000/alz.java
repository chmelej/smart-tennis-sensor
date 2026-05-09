package p000;

import android.os.Build;

/* JADX INFO: compiled from: BootloaderScannerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class alz {
    /* JADX INFO: renamed from: a */
    public static aly m1911a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new amb();
        }
        return new ama();
    }
}
