package com.shengrendan.mysweetdemo.libs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class Rotate3dAnimation extends Animation {

    /* JADX INFO: renamed from: a */
    private int f9082a;

    /* JADX INFO: renamed from: b */
    private int f9083b;

    /* JADX INFO: renamed from: c */
    private float f9084c;

    /* JADX INFO: renamed from: d */
    private float f9085d;

    /* JADX INFO: renamed from: e */
    private float f9086e;

    /* JADX INFO: renamed from: f */
    private float f9087f;

    /* JADX INFO: renamed from: g */
    private float f9088g;

    /* JADX INFO: renamed from: h */
    private float f9089h;

    /* JADX INFO: renamed from: i */
    private Camera f9090i;

    /* JADX INFO: renamed from: j */
    private int f9091j;

    /* JADX INFO: renamed from: com.shengrendan.mysweetdemo.libs.Rotate3dAnimation$a */
    public static class C1592a {

        /* JADX INFO: renamed from: a */
        public int f9092a;

        /* JADX INFO: renamed from: b */
        public float f9093b;

        protected C1592a() {
        }
    }

    /* JADX INFO: renamed from: a */
    C1592a m8658a(TypedValue typedValue) {
        C1592a c1592a = new C1592a();
        if (typedValue == null) {
            c1592a.f9092a = 0;
            c1592a.f9093b = 0.0f;
        } else {
            if (typedValue.type == 6) {
                c1592a.f9092a = (typedValue.data & 15) == 1 ? 2 : 1;
                c1592a.f9093b = TypedValue.complexToFloat(typedValue.data);
                return c1592a;
            }
            if (typedValue.type == 4) {
                c1592a.f9092a = 0;
                c1592a.f9093b = typedValue.getFloat();
                return c1592a;
            }
            if (typedValue.type >= 16 && typedValue.type <= 31) {
                c1592a.f9092a = 0;
                c1592a.f9093b = typedValue.data;
                return c1592a;
            }
        }
        c1592a.f9092a = 0;
        c1592a.f9093b = 0.0f;
        return c1592a;
    }

    public Rotate3dAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9082a = 0;
        this.f9083b = 0;
        this.f9084c = 0.0f;
        this.f9085d = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Rotate3dAnimation);
        this.f9086e = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
        this.f9087f = typedArrayObtainStyledAttributes.getFloat(4, 0.0f);
        this.f9091j = typedArrayObtainStyledAttributes.getInt(3, 0);
        C1592a c1592aM8658a = m8658a(typedArrayObtainStyledAttributes.peekValue(1));
        this.f9082a = c1592aM8658a.f9092a;
        this.f9084c = c1592aM8658a.f9093b;
        C1592a c1592aM8658a2 = m8658a(typedArrayObtainStyledAttributes.peekValue(2));
        this.f9083b = c1592aM8658a2.f9092a;
        this.f9085d = c1592aM8658a2.f9093b;
        typedArrayObtainStyledAttributes.recycle();
        m8657a();
    }

    /* JADX INFO: renamed from: a */
    private void m8657a() {
        if (this.f9082a == 0) {
            this.f9088g = this.f9084c;
        }
        if (this.f9083b == 0) {
            this.f9089h = this.f9085d;
        }
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f9090i = new Camera();
        this.f9088g = resolveSize(this.f9082a, this.f9084c, i, i3);
        this.f9089h = resolveSize(this.f9083b, this.f9085d, i2, i4);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f9086e;
        float f3 = f2 + ((this.f9087f - f2) * f);
        Matrix matrix = transformation.getMatrix();
        this.f9090i.save();
        switch (this.f9091j) {
            case 0:
                this.f9090i.rotateX(f3);
                break;
            case 1:
                this.f9090i.rotateY(f3);
                break;
            case 2:
                this.f9090i.rotateZ(f3);
                break;
        }
        this.f9090i.getMatrix(matrix);
        this.f9090i.restore();
        matrix.preTranslate(-this.f9088g, -this.f9089h);
        matrix.postTranslate(this.f9088g, this.f9089h);
    }
}
