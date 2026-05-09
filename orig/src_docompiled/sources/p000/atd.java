package p000;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import pub.devrel.easypermissions.RationaleDialogFragmentCompat;

/* JADX INFO: compiled from: BaseSupportPermissionsHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class atd<T> extends atg<T> {
    /* JADX INFO: renamed from: a */
    public abstract FragmentManager mo5403a();

    public atd(T t) {
        super(t);
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public void mo5404a(String str, String str2, String str3, int i, int i2, String... strArr) {
        FragmentManager fragmentManagerMo5403a = mo5403a();
        if (fragmentManagerMo5403a.findFragmentByTag("RationaleDialogFragmentCompat") instanceof RationaleDialogFragmentCompat) {
            Log.d("BSPermissionsHelper", "Found existing fragment, not showing rationale.");
        } else {
            RationaleDialogFragmentCompat.m11144a(str, str2, str3, i, i2, strArr).m11145a(fragmentManagerMo5403a, "RationaleDialogFragmentCompat");
        }
    }
}
