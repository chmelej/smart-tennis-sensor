package p000;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: renamed from: df */
/* JADX INFO: compiled from: ViewGroupUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1658df {
    /* JADX INFO: renamed from: a */
    public static InterfaceC1657de m8846a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new C1656dd(viewGroup);
        }
        return C1655dc.m8836a(viewGroup);
    }

    /* JADX INFO: renamed from: a */
    public static void m8847a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            C1660dh.m8851a(viewGroup, z);
        } else {
            C1659dg.m8849a(viewGroup, z);
        }
    }
}
