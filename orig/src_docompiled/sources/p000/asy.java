package p000;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.app.Fragment;
import java.util.Arrays;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.RationaleDialogFragment;
import pub.devrel.easypermissions.RationaleDialogFragmentCompat;

/* JADX INFO: compiled from: RationaleDialogClickListener.java */
/* JADX INFO: loaded from: classes.dex */
public class asy implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    private Object f5023a;

    /* JADX INFO: renamed from: b */
    private asz f5024b;

    /* JADX INFO: renamed from: c */
    private EasyPermissions.PermissionCallbacks f5025c;

    /* JADX INFO: renamed from: d */
    private EasyPermissions.InterfaceC2037a f5026d;

    public asy(RationaleDialogFragmentCompat rationaleDialogFragmentCompat, asz aszVar, EasyPermissions.PermissionCallbacks permissionCallbacks, EasyPermissions.InterfaceC2037a interfaceC2037a) {
        Object activity;
        if (rationaleDialogFragmentCompat.getParentFragment() != null) {
            activity = rationaleDialogFragmentCompat.getParentFragment();
        } else {
            activity = rationaleDialogFragmentCompat.getActivity();
        }
        this.f5023a = activity;
        this.f5024b = aszVar;
        this.f5025c = permissionCallbacks;
        this.f5026d = interfaceC2037a;
    }

    public asy(RationaleDialogFragment rationaleDialogFragment, asz aszVar, EasyPermissions.PermissionCallbacks permissionCallbacks, EasyPermissions.InterfaceC2037a interfaceC2037a) {
        Object activity;
        if (Build.VERSION.SDK_INT >= 17) {
            if (rationaleDialogFragment.getParentFragment() != null) {
                activity = rationaleDialogFragment.getParentFragment();
            } else {
                activity = rationaleDialogFragment.getActivity();
            }
            this.f5023a = activity;
        } else {
            this.f5023a = rationaleDialogFragment.getActivity();
        }
        this.f5024b = aszVar;
        this.f5025c = permissionCallbacks;
        this.f5026d = interfaceC2037a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.f5024b.f5030d;
        if (i == -1) {
            String[] strArr = this.f5024b.f5032f;
            if (this.f5026d != null) {
                this.f5026d.m11140a(i2);
            }
            if (this.f5023a instanceof Fragment) {
                atg.m5407a((Fragment) this.f5023a).mo5400a(i2, strArr);
                return;
            } else if (this.f5023a instanceof android.app.Fragment) {
                atg.m5406a((android.app.Fragment) this.f5023a).mo5400a(i2, strArr);
                return;
            } else {
                if (this.f5023a instanceof Activity) {
                    atg.m5405a((Activity) this.f5023a).mo5400a(i2, strArr);
                    return;
                }
                throw new RuntimeException("Host must be an Activity or Fragment!");
            }
        }
        if (this.f5026d != null) {
            this.f5026d.m11141b(i2);
        }
        m5386a();
    }

    /* JADX INFO: renamed from: a */
    private void m5386a() {
        if (this.f5025c != null) {
            this.f5025c.mo7924b(this.f5024b.f5030d, Arrays.asList(this.f5024b.f5032f));
        }
    }
}
