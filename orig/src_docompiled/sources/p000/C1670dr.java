package p000;

import android.os.IBinder;

/* JADX INFO: renamed from: dr */
/* JADX INFO: compiled from: WindowIdApi14.java */
/* JADX INFO: loaded from: classes.dex */
class C1670dr implements InterfaceC1672dt {

    /* JADX INFO: renamed from: a */
    private final IBinder f9420a;

    C1670dr(IBinder iBinder) {
        this.f9420a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1670dr) && ((C1670dr) obj).f9420a.equals(this.f9420a);
    }

    public int hashCode() {
        return this.f9420a.hashCode();
    }
}
