package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: hc */
/* JADX INFO: compiled from: TintResources.java */
/* JADX INFO: loaded from: classes.dex */
class C1765hc extends C1753gr {

    /* JADX INFO: renamed from: a */
    private final WeakReference<Context> f10142a;

    public C1765hc(Context context, Resources resources) {
        super(resources);
        this.f10142a = new WeakReference<>(context);
    }

    @Override // p000.C1753gr, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f10142a.get();
        if (drawable != null && context != null) {
            C1726fr.m9237a();
            C1726fr.m9243a(context, i, drawable);
        }
        return drawable;
    }
}
