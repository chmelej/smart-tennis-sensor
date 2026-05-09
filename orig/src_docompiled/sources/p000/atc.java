package p000;

import android.app.FragmentManager;
import android.util.Log;
import pub.devrel.easypermissions.RationaleDialogFragment;

/* JADX INFO: compiled from: BaseFrameworkPermissionsHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class atc<T> extends atg<T> {
    /* JADX INFO: renamed from: a */
    public abstract FragmentManager mo5399a();

    public atc(T t) {
        super(t);
    }

    @Override // p000.atg
    /* JADX INFO: renamed from: a */
    public void mo5404a(String str, String str2, String str3, int i, int i2, String... strArr) {
        FragmentManager fragmentManagerMo5399a = mo5399a();
        if (fragmentManagerMo5399a.findFragmentByTag("RationaleDialogFragment") instanceof RationaleDialogFragment) {
            Log.d("BFPermissionsHelper", "Found existing fragment, not showing rationale.");
        } else {
            RationaleDialogFragment.m11142a(str2, str3, str, i, i2, strArr).m11143a(fragmentManagerMo5399a, "RationaleDialogFragment");
        }
    }
}
