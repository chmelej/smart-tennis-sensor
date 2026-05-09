package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertController;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

/* JADX INFO: renamed from: dv */
/* JADX INFO: compiled from: AlertDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceC1674dv extends DialogC1677dy implements DialogInterface {

    /* JADX INFO: renamed from: a */
    final AlertController f9423a;

    protected DialogInterfaceC1674dv(Context context, int i) {
        super(context, m8895a(context, i));
        this.f9423a = new AlertController(getContext(), this, getWindow());
    }

    /* JADX INFO: renamed from: a */
    static int m8895a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // p000.DialogC1677dy, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f9423a.m3174a(charSequence);
    }

    @Override // p000.DialogC1677dy, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9423a.m3169a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f9423a.m3175a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f9423a.m3179b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: renamed from: dv$a */
    /* JADX INFO: compiled from: AlertDialog.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        private final AlertController.C0532a f9424a;

        /* JADX INFO: renamed from: b */
        private final int f9425b;

        public a(Context context) {
            this(context, DialogInterfaceC1674dv.m8895a(context, 0));
        }

        public a(Context context, int i) {
            this.f9424a = new AlertController.C0532a(new ContextThemeWrapper(context, DialogInterfaceC1674dv.m8895a(context, i)));
            this.f9425b = i;
        }

        /* JADX INFO: renamed from: a */
        public Context m8896a() {
            return this.f9424a.f3049a;
        }

        /* JADX INFO: renamed from: a */
        public a m8901a(CharSequence charSequence) {
            this.f9424a.f3054f = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m8899a(View view) {
            this.f9424a.f3055g = view;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m8904b(CharSequence charSequence) {
            this.f9424a.f3056h = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m8898a(Drawable drawable) {
            this.f9424a.f3052d = drawable;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m8902a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f9424a.f3057i = charSequence;
            this.f9424a.f3059k = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m8905b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f9424a.f3060l = charSequence;
            this.f9424a.f3062n = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m8903a(boolean z) {
            this.f9424a.f3066r = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m8897a(DialogInterface.OnKeyListener onKeyListener) {
            this.f9424a.f3069u = onKeyListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m8900a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f9424a.f3071w = listAdapter;
            this.f9424a.f3072x = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public DialogInterfaceC1674dv m8906b() {
            DialogInterfaceC1674dv dialogInterfaceC1674dv = new DialogInterfaceC1674dv(this.f9424a.f3049a, this.f9425b);
            this.f9424a.m3183a(dialogInterfaceC1674dv.f9423a);
            dialogInterfaceC1674dv.setCancelable(this.f9424a.f3066r);
            if (this.f9424a.f3066r) {
                dialogInterfaceC1674dv.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC1674dv.setOnCancelListener(this.f9424a.f3067s);
            dialogInterfaceC1674dv.setOnDismissListener(this.f9424a.f3068t);
            if (this.f9424a.f3069u != null) {
                dialogInterfaceC1674dv.setOnKeyListener(this.f9424a.f3069u);
            }
            return dialogInterfaceC1674dv;
        }

        /* JADX INFO: renamed from: c */
        public DialogInterfaceC1674dv m8907c() {
            DialogInterfaceC1674dv dialogInterfaceC1674dvM8906b = m8906b();
            dialogInterfaceC1674dvM8906b.show();
            return dialogInterfaceC1674dvM8906b;
        }
    }
}
