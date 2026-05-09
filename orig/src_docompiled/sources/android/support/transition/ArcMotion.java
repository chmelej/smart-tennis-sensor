package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import p000.C1646cu;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* JADX INFO: renamed from: a */
    private static final float f2774a = (float) Math.tan(Math.toRadians(35.0d));

    /* JADX INFO: renamed from: b */
    private float f2775b;

    /* JADX INFO: renamed from: c */
    private float f2776c;

    /* JADX INFO: renamed from: d */
    private float f2777d;

    /* JADX INFO: renamed from: e */
    private float f2778e;

    /* JADX INFO: renamed from: f */
    private float f2779f;

    /* JADX INFO: renamed from: g */
    private float f2780g;

    public ArcMotion() {
        this.f2775b = 0.0f;
        this.f2776c = 0.0f;
        this.f2777d = 70.0f;
        this.f2778e = 0.0f;
        this.f2779f = 0.0f;
        this.f2780g = f2774a;
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2775b = 0.0f;
        this.f2776c = 0.0f;
        this.f2777d = 70.0f;
        this.f2778e = 0.0f;
        this.f2779f = 0.0f;
        this.f2780g = f2774a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9341j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        m2975b(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        m2974a(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        m2976c(TypedArrayUtils.getNamedFloat(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public void m2974a(float f) {
        this.f2775b = f;
        this.f2778e = m2972d(f);
    }

    /* JADX INFO: renamed from: b */
    public void m2975b(float f) {
        this.f2776c = f;
        this.f2779f = m2972d(f);
    }

    /* JADX INFO: renamed from: c */
    public void m2976c(float f) {
        this.f2777d = f;
        this.f2780g = m2972d(f);
    }

    /* JADX INFO: renamed from: d */
    private static float m2972d(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f / 2.0f));
    }

    @Override // android.support.transition.PathMotion
    /* JADX INFO: renamed from: a */
    public Path mo2973a(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        Path path = new Path();
        path.moveTo(f, f2);
        float f8 = f3 - f;
        float f9 = f4 - f2;
        float f10 = (f8 * f8) + (f9 * f9);
        float f11 = (f + f3) / 2.0f;
        float f12 = (f2 + f4) / 2.0f;
        float f13 = 0.25f * f10;
        boolean z = f2 > f4;
        if (Math.abs(f8) < Math.abs(f9)) {
            float fAbs = Math.abs(f10 / (f9 * 2.0f));
            if (z) {
                f6 = fAbs + f4;
                f5 = f3;
            } else {
                f6 = fAbs + f2;
                f5 = f;
            }
            f7 = this.f2779f * f13 * this.f2779f;
        } else {
            float f14 = f10 / (f8 * 2.0f);
            if (z) {
                f6 = f2;
                f5 = f14 + f;
            } else {
                f5 = f3 - f14;
                f6 = f4;
            }
            f7 = this.f2778e * f13 * this.f2778e;
        }
        float f15 = f11 - f5;
        float f16 = f12 - f6;
        float f17 = (f15 * f15) + (f16 * f16);
        float f18 = f13 * this.f2780g * this.f2780g;
        if (f17 >= f7) {
            f7 = f17 > f18 ? f18 : 0.0f;
        }
        if (f7 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f7 / f17);
            f5 = ((f5 - f11) * fSqrt) + f11;
            f6 = f12 + (fSqrt * (f6 - f12));
        }
        path.cubicTo((f + f5) / 2.0f, (f2 + f6) / 2.0f, (f5 + f3) / 2.0f, (f6 + f4) / 2.0f, f3, f4);
        return path;
    }
}
