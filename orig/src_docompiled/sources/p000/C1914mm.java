package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coollang.tennis.base.MyApplication;

/* JADX INFO: renamed from: mm */
/* JADX INFO: compiled from: UIUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1914mm {
    /* JADX INFO: renamed from: a */
    public static Context m10554a() {
        return MyApplication.m7738a();
    }

    /* JADX INFO: renamed from: a */
    public static View m10555a(int i) {
        return LayoutInflater.from(m10554a()).inflate(i, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: b */
    public static Resources m10556b() {
        return m10554a().getResources();
    }

    /* JADX INFO: renamed from: b */
    public static String m10557b(int i) {
        return m10556b().getString(i);
    }

    /* JADX INFO: renamed from: c */
    public static Drawable m10558c(int i) {
        return m10556b().getDrawable(i);
    }

    /* JADX INFO: renamed from: d */
    public static int m10559d(int i) {
        return m10556b().getColor(i);
    }
}
