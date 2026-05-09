package pub.devrel.easypermissions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialogFragment;
import p000.asy;
import p000.asz;
import pub.devrel.easypermissions.EasyPermissions;

/* JADX INFO: loaded from: classes.dex */
public class RationaleDialogFragmentCompat extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: a */
    private EasyPermissions.PermissionCallbacks f12230a;

    /* JADX INFO: renamed from: b */
    private EasyPermissions.InterfaceC2037a f12231b;

    /* JADX INFO: renamed from: a */
    public static RationaleDialogFragmentCompat m11144a(String str, String str2, String str3, int i, int i2, String[] strArr) {
        RationaleDialogFragmentCompat rationaleDialogFragmentCompat = new RationaleDialogFragmentCompat();
        rationaleDialogFragmentCompat.setArguments(new asz(str2, str3, str, i, i2, strArr).m5387a());
        return rationaleDialogFragmentCompat;
    }

    /* JADX INFO: renamed from: a */
    public void m11145a(FragmentManager fragmentManager, String str) {
        if (fragmentManager.isStateSaved()) {
            return;
        }
        show(fragmentManager, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() != null) {
            if (getParentFragment() instanceof EasyPermissions.PermissionCallbacks) {
                this.f12230a = (EasyPermissions.PermissionCallbacks) getParentFragment();
            }
            if (getParentFragment() instanceof EasyPermissions.InterfaceC2037a) {
                this.f12231b = (EasyPermissions.InterfaceC2037a) getParentFragment();
            }
        }
        if (context instanceof EasyPermissions.PermissionCallbacks) {
            this.f12230a = (EasyPermissions.PermissionCallbacks) context;
        }
        if (context instanceof EasyPermissions.InterfaceC2037a) {
            this.f12231b = (EasyPermissions.InterfaceC2037a) context;
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12230a = null;
        this.f12231b = null;
    }

    @Override // android.support.v7.app.AppCompatDialogFragment, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        asz aszVar = new asz(getArguments());
        return aszVar.m5388a(getContext(), new asy(this, aszVar, this.f12230a, this.f12231b));
    }
}
