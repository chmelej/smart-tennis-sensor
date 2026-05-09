package p000;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: renamed from: ha */
/* JADX INFO: compiled from: TintContextWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1763ha extends ContextWrapper {

    /* JADX INFO: renamed from: a */
    private static final Object f10134a = new Object();

    /* JADX INFO: renamed from: b */
    private static ArrayList<WeakReference<C1763ha>> f10135b;

    /* JADX INFO: renamed from: c */
    private final Resources f10136c;

    /* JADX INFO: renamed from: d */
    private final Resources.Theme f10137d;

    /* JADX INFO: renamed from: a */
    public static Context m9596a(Context context) {
        if (!m9597b(context)) {
            return context;
        }
        synchronized (f10134a) {
            if (f10135b == null) {
                f10135b = new ArrayList<>();
            } else {
                for (int size = f10135b.size() - 1; size >= 0; size--) {
                    WeakReference<C1763ha> weakReference = f10135b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f10135b.remove(size);
                    }
                }
                for (int size2 = f10135b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<C1763ha> weakReference2 = f10135b.get(size2);
                    C1763ha c1763ha = weakReference2 != null ? weakReference2.get() : null;
                    if (c1763ha != null && c1763ha.getBaseContext() == context) {
                        return c1763ha;
                    }
                }
            }
            C1763ha c1763ha2 = new C1763ha(context);
            f10135b.add(new WeakReference<>(c1763ha2));
            return c1763ha2;
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m9597b(Context context) {
        if ((context instanceof C1763ha) || (context.getResources() instanceof C1765hc) || (context.getResources() instanceof C1771hi)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || C1771hi.m9648a();
    }

    private C1763ha(Context context) {
        super(context);
        if (C1771hi.m9648a()) {
            this.f10136c = new C1771hi(this, context.getResources());
            this.f10137d = this.f10136c.newTheme();
            this.f10137d.setTo(context.getTheme());
        } else {
            this.f10136c = new C1765hc(this, context.getResources());
            this.f10137d = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.f10137d == null ? super.getTheme() : this.f10137d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f10137d == null) {
            super.setTheme(i);
        } else {
            this.f10137d.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f10136c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f10136c.getAssets();
    }
}
