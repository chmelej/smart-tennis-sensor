package p000;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/* JADX INFO: compiled from: PermissionHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class atg<T> {

    /* JADX INFO: renamed from: a */
    private T f5035a;

    /* JADX INFO: renamed from: a */
    public abstract void mo5400a(int i, String... strArr);

    /* JADX INFO: renamed from: a */
    public abstract void mo5404a(String str, String str2, String str3, int i, int i2, String... strArr);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo5401a(String str);

    /* JADX INFO: renamed from: b */
    public abstract Context mo5402b();

    /* JADX INFO: renamed from: a */
    public static atg<? extends Activity> m5405a(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return new atf(activity);
        }
        if (activity instanceof AppCompatActivity) {
            return new atb((AppCompatActivity) activity);
        }
        return new ata(activity);
    }

    /* JADX INFO: renamed from: a */
    public static atg<Fragment> m5407a(Fragment fragment) {
        if (Build.VERSION.SDK_INT < 23) {
            return new atf(fragment);
        }
        return new ath(fragment);
    }

    /* JADX INFO: renamed from: a */
    public static atg<android.app.Fragment> m5406a(android.app.Fragment fragment) {
        if (Build.VERSION.SDK_INT < 23) {
            return new atf(fragment);
        }
        return new ate(fragment);
    }

    public atg(T t) {
        this.f5035a = t;
    }

    /* JADX INFO: renamed from: a */
    private boolean m5408a(String... strArr) {
        for (String str : strArr) {
            if (mo5401a(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public void m5409b(String str, String str2, String str3, int i, int i2, String... strArr) {
        if (m5408a(strArr)) {
            mo5404a(str, str2, str3, i, i2, strArr);
        } else {
            mo5400a(i2, strArr);
        }
    }

    /* JADX INFO: renamed from: c */
    public T m5410c() {
        return this.f5035a;
    }
}
