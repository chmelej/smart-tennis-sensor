package android.support.v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import p000.DialogC1677dy;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new DialogC1677dy(getContext(), getTheme());
    }

    @Override // android.support.v4.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof DialogC1677dy) {
            DialogC1677dy dialogC1677dy = (DialogC1677dy) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    return;
            }
            dialogC1677dy.m8912a(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
