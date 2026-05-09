package pub.devrel.easypermissions;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import p000.asy;
import p000.asz;
import pub.devrel.easypermissions.EasyPermissions;

/* JADX INFO: loaded from: classes.dex */
public class RationaleDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    private EasyPermissions.PermissionCallbacks f12227a;

    /* JADX INFO: renamed from: b */
    private EasyPermissions.InterfaceC2037a f12228b;

    /* JADX INFO: renamed from: c */
    private boolean f12229c = false;

    /* JADX INFO: renamed from: a */
    public static RationaleDialogFragment m11142a(String str, String str2, String str3, int i, int i2, String[] strArr) {
        RationaleDialogFragment rationaleDialogFragment = new RationaleDialogFragment();
        rationaleDialogFragment.setArguments(new asz(str, str2, str3, i, i2, strArr).m5387a());
        return rationaleDialogFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (Build.VERSION.SDK_INT >= 17 && getParentFragment() != null) {
            if (getParentFragment() instanceof EasyPermissions.PermissionCallbacks) {
                this.f12227a = (EasyPermissions.PermissionCallbacks) getParentFragment();
            }
            if (getParentFragment() instanceof EasyPermissions.InterfaceC2037a) {
                this.f12228b = (EasyPermissions.InterfaceC2037a) getParentFragment();
            }
        }
        if (context instanceof EasyPermissions.PermissionCallbacks) {
            this.f12227a = (EasyPermissions.PermissionCallbacks) context;
        }
        if (context instanceof EasyPermissions.InterfaceC2037a) {
            this.f12228b = (EasyPermissions.InterfaceC2037a) context;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        this.f12229c = true;
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: renamed from: a */
    public void m11143a(FragmentManager fragmentManager, String str) {
        if ((Build.VERSION.SDK_INT < 26 || !fragmentManager.isStateSaved()) && !this.f12229c) {
            show(fragmentManager, str);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12227a = null;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        asz aszVar = new asz(getArguments());
        return aszVar.m5389b(getActivity(), new asy(this, aszVar, this.f12227a, this.f12228b));
    }
}
