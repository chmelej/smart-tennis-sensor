package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import p000.C1646cu;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* JADX INFO: renamed from: a */
    private Path f2877a;

    /* JADX INFO: renamed from: b */
    private final Path f2878b = new Path();

    /* JADX INFO: renamed from: c */
    private final Matrix f2879c = new Matrix();

    public PatternPathMotion() {
        this.f2878b.lineTo(1.0f, 0.0f);
        this.f2877a = this.f2878b;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9342k);
        try {
            String namedString = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (namedString == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            m3043a(PathParser.createPathFromPathData(namedString));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3043a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f2879c.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fM3042a = 1.0f / m3042a(f5, f6);
        this.f2879c.postScale(fM3042a, fM3042a);
        this.f2879c.postRotate((float) Math.toDegrees(-Math.atan2(f6, f5)));
        path.transform(this.f2879c, this.f2878b);
        this.f2877a = path;
    }

    @Override // android.support.transition.PathMotion
    /* JADX INFO: renamed from: a */
    public Path mo2973a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float fM3042a = m3042a(f5, f6);
        double dAtan2 = Math.atan2(f6, f5);
        this.f2879c.setScale(fM3042a, fM3042a);
        this.f2879c.postRotate((float) Math.toDegrees(dAtan2));
        this.f2879c.postTranslate(f, f2);
        Path path = new Path();
        this.f2878b.transform(this.f2879c, path);
        return path;
    }

    /* JADX INFO: renamed from: a */
    private static float m3042a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }
}
