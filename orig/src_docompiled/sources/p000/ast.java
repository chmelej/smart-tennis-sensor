package p000;

import android.os.Bundle;

/* JADX INFO: compiled from: ErrorDialogFragmentFactory.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ast<T> {

    /* JADX INFO: renamed from: a */
    public final ass f5004a;

    /* JADX INFO: renamed from: a */
    protected abstract T m5368a(asv asvVar, Bundle bundle);

    /* JADX INFO: renamed from: a */
    public T m5369a(asv asvVar, boolean z, Bundle bundle) {
        Bundle bundle2;
        if (asvVar.m5374a()) {
            return null;
        }
        if (bundle != null) {
            bundle2 = (Bundle) bundle.clone();
        } else {
            bundle2 = new Bundle();
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.title")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.title", m5370b(asvVar, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.message")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.message", m5371c(asvVar, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
            bundle2.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", z);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && this.f5004a.f5003i != null) {
            bundle2.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.f5004a.f5003i);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.icon_id") && this.f5004a.f5002h != 0) {
            bundle2.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.f5004a.f5002h);
        }
        return m5368a(asvVar, bundle2);
    }

    /* JADX INFO: renamed from: b */
    protected String m5370b(asv asvVar, Bundle bundle) {
        return this.f5004a.f4995a.getString(this.f5004a.f4996b);
    }

    /* JADX INFO: renamed from: c */
    protected String m5371c(asv asvVar, Bundle bundle) {
        return this.f5004a.f4995a.getString(this.f5004a.m5366a(asvVar.f5006a));
    }
}
