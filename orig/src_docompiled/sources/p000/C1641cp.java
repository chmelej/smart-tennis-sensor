package p000;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: renamed from: cp */
/* JADX INFO: compiled from: PathProperty.java */
/* JADX INFO: loaded from: classes.dex */
class C1641cp<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a */
    private final Property<T, PointF> f9321a;

    /* JADX INFO: renamed from: b */
    private final PathMeasure f9322b;

    /* JADX INFO: renamed from: c */
    private final float f9323c;

    /* JADX INFO: renamed from: d */
    private final float[] f9324d;

    /* JADX INFO: renamed from: e */
    private final PointF f9325e;

    /* JADX INFO: renamed from: f */
    private float f9326f;

    C1641cp(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f9324d = new float[2];
        this.f9325e = new PointF();
        this.f9321a = property;
        this.f9322b = new PathMeasure(path, false);
        this.f9323c = this.f9322b.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f9326f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f) {
        this.f9326f = f.floatValue();
        this.f9322b.getPosTan(this.f9323c * f.floatValue(), this.f9324d, null);
        this.f9325e.x = this.f9324d[0];
        this.f9325e.y = this.f9324d[1];
        this.f9321a.set(t, this.f9325e);
    }
}
