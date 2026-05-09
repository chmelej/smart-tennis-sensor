package p000;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegateImpl;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: dx */
/* JADX INFO: compiled from: AppCompatDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1676dx {

    /* JADX INFO: renamed from: a */
    private static int f9426a = -1;

    /* JADX INFO: renamed from: a */
    public abstract ActionBar mo3218a();

    /* JADX INFO: renamed from: a */
    public abstract <T extends View> T mo3221a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo3225a(Configuration configuration);

    /* JADX INFO: renamed from: a */
    public abstract void mo3226a(Bundle bundle);

    /* JADX INFO: renamed from: a */
    public abstract void mo3228a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo3229a(View view, ViewGroup.LayoutParams layoutParams);

    /* JADX INFO: renamed from: a */
    public abstract void mo3231a(CharSequence charSequence);

    /* JADX INFO: renamed from: b */
    public abstract MenuInflater mo3234b();

    /* JADX INFO: renamed from: b */
    public abstract void mo3236b(int i);

    /* JADX INFO: renamed from: b */
    public abstract void mo3237b(Bundle bundle);

    /* JADX INFO: renamed from: b */
    public abstract void mo3239b(View view, ViewGroup.LayoutParams layoutParams);

    /* JADX INFO: renamed from: c */
    public abstract void mo3241c();

    /* JADX INFO: renamed from: c */
    public abstract void mo3242c(Bundle bundle);

    /* JADX INFO: renamed from: c */
    public abstract boolean mo3243c(int i);

    /* JADX INFO: renamed from: d */
    public abstract void mo3245d();

    /* JADX INFO: renamed from: e */
    public abstract void mo3247e();

    /* JADX INFO: renamed from: f */
    public abstract void mo3249f();

    /* JADX INFO: renamed from: g */
    public abstract void mo3251g();

    /* JADX INFO: renamed from: h */
    public abstract void mo3254h();

    /* JADX INFO: renamed from: i */
    public abstract boolean mo3256i();

    /* JADX INFO: renamed from: a */
    public static AbstractC1676dx m8908a(Activity activity, InterfaceC1675dw interfaceC1675dw) {
        return new AppCompatDelegateImpl(activity, activity.getWindow(), interfaceC1675dw);
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC1676dx m8909a(Dialog dialog, InterfaceC1675dw interfaceC1675dw) {
        return new AppCompatDelegateImpl(dialog.getContext(), dialog.getWindow(), interfaceC1675dw);
    }

    protected AbstractC1676dx() {
    }

    /* JADX INFO: renamed from: j */
    public static int m8910j() {
        return f9426a;
    }
}
