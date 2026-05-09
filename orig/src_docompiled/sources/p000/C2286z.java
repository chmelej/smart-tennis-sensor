package p000;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: z */
/* JADX INFO: compiled from: DrawableAlphaProperty.java */
/* JADX INFO: loaded from: classes.dex */
public class C2286z extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: a */
    public static final Property<Drawable, Integer> f13773a = new C2286z();

    /* JADX INFO: renamed from: b */
    private final WeakHashMap<Drawable, Integer> f13774b;

    private C2286z() {
        super(Integer.class, "drawableAlphaCompat");
        this.f13774b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f13774b.containsKey(drawable)) {
            return this.f13774b.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f13774b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
