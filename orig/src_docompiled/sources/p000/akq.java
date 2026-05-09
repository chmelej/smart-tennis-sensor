package p000;

import android.os.Bundle;

/* JADX INFO: compiled from: ErrorDialogFragmentFactory.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class akq<T> {

    /* JADX INFO: renamed from: a */
    public final akp f1506a;

    /* JADX INFO: renamed from: a */
    protected abstract T m1736a(aks aksVar, Bundle bundle);

    /* JADX INFO: renamed from: a */
    public T m1737a(aks aksVar, boolean z, Bundle bundle) {
        Bundle bundle2;
        if (aksVar.m1742a()) {
            return null;
        }
        if (bundle != null) {
            bundle2 = (Bundle) bundle.clone();
        } else {
            bundle2 = new Bundle();
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.title")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.title", m1738b(aksVar, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.message")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.message", m1739c(aksVar, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
            bundle2.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", z);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && this.f1506a.f1505i != null) {
            bundle2.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.f1506a.f1505i);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.icon_id") && this.f1506a.f1504h != 0) {
            bundle2.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.f1506a.f1504h);
        }
        return m1736a(aksVar, bundle2);
    }

    /* JADX INFO: renamed from: b */
    protected String m1738b(aks aksVar, Bundle bundle) {
        return this.f1506a.f1497a.getString(this.f1506a.f1498b);
    }

    /* JADX INFO: renamed from: c */
    protected String m1739c(aks aksVar, Bundle bundle) {
        return this.f1506a.f1497a.getString(this.f1506a.m1734a(aksVar.f1508a));
    }
}
