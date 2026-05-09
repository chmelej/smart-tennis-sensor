package p000;

import android.view.View;

/* JADX INFO: renamed from: qf */
/* JADX INFO: compiled from: ViewHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2049qf {
    /* JADX INFO: renamed from: a */
    public static void m11183a(View view, float f) {
        if (C2050qg.f12319a) {
            C2050qg.m11192a(view).m11198a(f);
        } else {
            a.m11188a(view, f);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m11184b(View view, float f) {
        if (C2050qg.f12319a) {
            C2050qg.m11192a(view).m11199b(f);
        } else {
            a.m11189b(view, f);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m11185c(View view, float f) {
        if (C2050qg.f12319a) {
            C2050qg.m11192a(view).m11200c(f);
        } else {
            a.m11190c(view, f);
        }
    }

    /* JADX INFO: renamed from: a */
    public static float m11182a(View view) {
        return C2050qg.f12319a ? C2050qg.m11192a(view).m11197a() : a.m11187a(view);
    }

    /* JADX INFO: renamed from: d */
    public static void m11186d(View view, float f) {
        if (C2050qg.f12319a) {
            C2050qg.m11192a(view).m11201d(f);
        } else {
            a.m11191d(view, f);
        }
    }

    /* JADX INFO: renamed from: qf$a */
    /* JADX INFO: compiled from: ViewHelper.java */
    static final class a {
        /* JADX INFO: renamed from: a */
        static void m11188a(View view, float f) {
            view.setAlpha(f);
        }

        /* JADX INFO: renamed from: b */
        static void m11189b(View view, float f) {
            view.setScaleX(f);
        }

        /* JADX INFO: renamed from: c */
        static void m11190c(View view, float f) {
            view.setScaleY(f);
        }

        /* JADX INFO: renamed from: a */
        static float m11187a(View view) {
            return view.getTranslationY();
        }

        /* JADX INFO: renamed from: d */
        static void m11191d(View view, float f) {
            view.setTranslationY(f);
        }
    }
}
