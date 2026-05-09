package org.greenrobot.eventbus.util;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ErrorDialogFragments {

    /* JADX INFO: renamed from: a */
    public static int f12048a;

    /* JADX INFO: renamed from: b */
    public static Class<?> f12049b;

    /* JADX INFO: renamed from: a */
    public static Dialog m11037a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        if (f12048a != 0) {
            builder.setIcon(f12048a);
        }
        builder.setPositiveButton(R.string.ok, onClickListener);
        return builder.create();
    }

    /* JADX INFO: renamed from: a */
    public static void m11038a(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) {
        if (f12049b != null) {
            try {
                ErrorDialogManager.f12050a.f5004a.m5367a().m5338c(f12049b.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (!bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) || activity == null) {
            return;
        }
        activity.finish();
    }

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.m11037a(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.m11038a(dialogInterface, i, getActivity(), getArguments());
        }
    }

    public static class Support extends android.support.v4.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.support.v4.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.m11037a(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.m11038a(dialogInterface, i, getActivity(), getArguments());
        }
    }
}
