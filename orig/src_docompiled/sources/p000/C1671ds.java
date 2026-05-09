package p000;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: renamed from: ds */
/* JADX INFO: compiled from: WindowIdApi18.java */
/* JADX INFO: loaded from: classes.dex */
class C1671ds implements InterfaceC1672dt {

    /* JADX INFO: renamed from: a */
    private final WindowId f9421a;

    C1671ds(View view) {
        this.f9421a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1671ds) && ((C1671ds) obj).f9421a.equals(this.f9421a);
    }

    public int hashCode() {
        return this.f9421a.hashCode();
    }
}
