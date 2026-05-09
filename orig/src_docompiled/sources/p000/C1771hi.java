package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: hi */
/* JADX INFO: compiled from: VectorEnabledTintResources.java */
/* JADX INFO: loaded from: classes.dex */
public class C1771hi extends Resources {

    /* JADX INFO: renamed from: a */
    private static boolean f10188a = false;

    /* JADX INFO: renamed from: b */
    private final WeakReference<Context> f10189b;

    /* JADX INFO: renamed from: a */
    public static boolean m9648a() {
        return m9649b() && Build.VERSION.SDK_INT <= 20;
    }

    public C1771hi(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f10189b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.f10189b.get();
        if (context != null) {
            return C1726fr.m9237a().m9258a(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* JADX INFO: renamed from: a */
    final Drawable m9650a(int i) {
        return super.getDrawable(i);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m9649b() {
        return f10188a;
    }
}
