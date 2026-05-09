package p000;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import p000.DialogInterfaceC1674dv;

/* JADX INFO: compiled from: RationaleDialogConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class asz {

    /* JADX INFO: renamed from: a */
    String f5027a;

    /* JADX INFO: renamed from: b */
    String f5028b;

    /* JADX INFO: renamed from: c */
    int f5029c;

    /* JADX INFO: renamed from: d */
    int f5030d;

    /* JADX INFO: renamed from: e */
    String f5031e;

    /* JADX INFO: renamed from: f */
    String[] f5032f;

    public asz(String str, String str2, String str3, int i, int i2, String[] strArr) {
        this.f5027a = str;
        this.f5028b = str2;
        this.f5031e = str3;
        this.f5029c = i;
        this.f5030d = i2;
        this.f5032f = strArr;
    }

    public asz(Bundle bundle) {
        this.f5027a = bundle.getString("positiveButton");
        this.f5028b = bundle.getString("negativeButton");
        this.f5031e = bundle.getString("rationaleMsg");
        this.f5029c = bundle.getInt("theme");
        this.f5030d = bundle.getInt("requestCode");
        this.f5032f = bundle.getStringArray("permissions");
    }

    /* JADX INFO: renamed from: a */
    public Bundle m5387a() {
        Bundle bundle = new Bundle();
        bundle.putString("positiveButton", this.f5027a);
        bundle.putString("negativeButton", this.f5028b);
        bundle.putString("rationaleMsg", this.f5031e);
        bundle.putInt("theme", this.f5029c);
        bundle.putInt("requestCode", this.f5030d);
        bundle.putStringArray("permissions", this.f5032f);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public DialogInterfaceC1674dv m5388a(Context context, DialogInterface.OnClickListener onClickListener) {
        DialogInterfaceC1674dv.a aVar;
        if (this.f5029c > 0) {
            aVar = new DialogInterfaceC1674dv.a(context, this.f5029c);
        } else {
            aVar = new DialogInterfaceC1674dv.a(context);
        }
        return aVar.m8903a(false).m8902a(this.f5027a, onClickListener).m8905b(this.f5028b, onClickListener).m8904b(this.f5031e).m8906b();
    }

    /* JADX INFO: renamed from: b */
    public AlertDialog m5389b(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder;
        if (this.f5029c > 0) {
            builder = new AlertDialog.Builder(context, this.f5029c);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        return builder.setCancelable(false).setPositiveButton(this.f5027a, onClickListener).setNegativeButton(this.f5028b, onClickListener).setMessage(this.f5031e).create();
    }
}
