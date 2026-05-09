package p000;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: ei */
/* JADX INFO: compiled from: DrawerArrowDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1688ei extends Drawable {

    /* JADX INFO: renamed from: b */
    private static final float f9587b = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a */
    private final Paint f9588a;

    /* JADX INFO: renamed from: c */
    private float f9589c;

    /* JADX INFO: renamed from: d */
    private float f9590d;

    /* JADX INFO: renamed from: e */
    private float f9591e;

    /* JADX INFO: renamed from: f */
    private float f9592f;

    /* JADX INFO: renamed from: g */
    private boolean f9593g;

    /* JADX INFO: renamed from: h */
    private final Path f9594h;

    /* JADX INFO: renamed from: i */
    private final int f9595i;

    /* JADX INFO: renamed from: j */
    private boolean f9596j;

    /* JADX INFO: renamed from: k */
    private float f9597k;

    /* JADX INFO: renamed from: l */
    private float f9598l;

    /* JADX INFO: renamed from: m */
    private int f9599m;

    /* JADX INFO: renamed from: a */
    private static float m9042a(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: a */
    public void m9044a(boolean z) {
        if (this.f9596j != z) {
            this.f9596j = z;
            invalidateSelf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018 A[FALL_THROUGH] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r21) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1688ei.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f9588a.getAlpha()) {
            this.f9588a.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9588a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f9595i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f9595i;
    }

    /* JADX INFO: renamed from: a */
    public void m9043a(float f) {
        if (this.f9597k != f) {
            this.f9597k = f;
            invalidateSelf();
        }
    }
}
