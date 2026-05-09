package android.support.design.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import p000.DialogC0763be;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    @Override // android.support.v7.app.AppCompatDialogFragment, android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new DialogC0763be(getContext(), getTheme());
    }
}
