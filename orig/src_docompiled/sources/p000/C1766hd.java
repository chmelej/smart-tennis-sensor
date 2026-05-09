package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: renamed from: hd */
/* JADX INFO: compiled from: TintTypedArray.java */
/* JADX INFO: loaded from: classes.dex */
public class C1766hd {

    /* JADX INFO: renamed from: a */
    private final Context f10143a;

    /* JADX INFO: renamed from: b */
    private final TypedArray f10144b;

    /* JADX INFO: renamed from: c */
    private TypedValue f10145c;

    /* JADX INFO: renamed from: a */
    public static C1766hd m9600a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C1766hd(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* JADX INFO: renamed from: a */
    public static C1766hd m9601a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C1766hd(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* JADX INFO: renamed from: a */
    public static C1766hd m9599a(Context context, int i, int[] iArr) {
        return new C1766hd(context, context.obtainStyledAttributes(i, iArr));
    }

    private C1766hd(Context context, TypedArray typedArray) {
        this.f10143a = context;
        this.f10144b = typedArray;
    }

    /* JADX INFO: renamed from: a */
    public Drawable m9605a(int i) {
        int resourceId;
        if (this.f10144b.hasValue(i) && (resourceId = this.f10144b.getResourceId(i, 0)) != 0) {
            return C1684ee.m8975b(this.f10143a, resourceId);
        }
        return this.f10144b.getDrawable(i);
    }

    /* JADX INFO: renamed from: b */
    public Drawable m9610b(int i) {
        int resourceId;
        if (!this.f10144b.hasValue(i) || (resourceId = this.f10144b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C1726fr.m9237a().m9257a(this.f10143a, resourceId, true);
    }

    /* JADX INFO: renamed from: a */
    public Typeface m9604a(int i, int i2, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f10144b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f10145c == null) {
            this.f10145c = new TypedValue();
        }
        return ResourcesCompat.getFont(this.f10143a, resourceId, this.f10145c, i2, fontCallback);
    }

    /* JADX INFO: renamed from: c */
    public CharSequence m9612c(int i) {
        return this.f10144b.getText(i);
    }

    /* JADX INFO: renamed from: d */
    public String m9614d(int i) {
        return this.f10144b.getString(i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m9607a(int i, boolean z) {
        return this.f10144b.getBoolean(i, z);
    }

    /* JADX INFO: renamed from: a */
    public int m9603a(int i, int i2) {
        return this.f10144b.getInt(i, i2);
    }

    /* JADX INFO: renamed from: a */
    public float m9602a(int i, float f) {
        return this.f10144b.getFloat(i, f);
    }

    /* JADX INFO: renamed from: b */
    public int m9609b(int i, int i2) {
        return this.f10144b.getColor(i, i2);
    }

    /* JADX INFO: renamed from: e */
    public ColorStateList m9616e(int i) {
        int resourceId;
        ColorStateList colorStateListM8972a;
        return (!this.f10144b.hasValue(i) || (resourceId = this.f10144b.getResourceId(i, 0)) == 0 || (colorStateListM8972a = C1684ee.m8972a(this.f10143a, resourceId)) == null) ? this.f10144b.getColorStateList(i) : colorStateListM8972a;
    }

    /* JADX INFO: renamed from: c */
    public int m9611c(int i, int i2) {
        return this.f10144b.getInteger(i, i2);
    }

    /* JADX INFO: renamed from: b */
    public float m9608b(int i, float f) {
        return this.f10144b.getDimension(i, f);
    }

    /* JADX INFO: renamed from: d */
    public int m9613d(int i, int i2) {
        return this.f10144b.getDimensionPixelOffset(i, i2);
    }

    /* JADX INFO: renamed from: e */
    public int m9615e(int i, int i2) {
        return this.f10144b.getDimensionPixelSize(i, i2);
    }

    /* JADX INFO: renamed from: f */
    public int m9617f(int i, int i2) {
        return this.f10144b.getLayoutDimension(i, i2);
    }

    /* JADX INFO: renamed from: g */
    public int m9619g(int i, int i2) {
        return this.f10144b.getResourceId(i, i2);
    }

    /* JADX INFO: renamed from: f */
    public CharSequence[] m9618f(int i) {
        return this.f10144b.getTextArray(i);
    }

    /* JADX INFO: renamed from: g */
    public boolean m9620g(int i) {
        return this.f10144b.hasValue(i);
    }

    /* JADX INFO: renamed from: a */
    public void m9606a() {
        this.f10144b.recycle();
    }
}
