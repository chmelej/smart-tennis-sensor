package p000;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: bb */
/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class C0760bb {

    /* JADX INFO: renamed from: a */
    public float f5088a;

    /* JADX INFO: renamed from: b */
    public float f5089b;

    /* JADX INFO: renamed from: c */
    public float f5090c;

    /* JADX INFO: renamed from: d */
    public float f5091d;

    /* JADX INFO: renamed from: e */
    private final List<c> f5092e = new ArrayList();

    /* JADX INFO: renamed from: bb$c */
    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class c {

        /* JADX INFO: renamed from: g */
        protected final Matrix f5102g = new Matrix();

        /* JADX INFO: renamed from: a */
        public abstract void mo5499a(Matrix matrix, Path path);
    }

    public C0760bb() {
        m5495a(0.0f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public void m5495a(float f, float f2) {
        this.f5088a = f;
        this.f5089b = f2;
        this.f5090c = f;
        this.f5091d = f2;
        this.f5092e.clear();
    }

    /* JADX INFO: renamed from: b */
    public void m5498b(float f, float f2) {
        b bVar = new b();
        bVar.f5100a = f;
        bVar.f5101b = f2;
        this.f5092e.add(bVar);
        this.f5090c = f;
        this.f5091d = f2;
    }

    /* JADX INFO: renamed from: a */
    public void m5496a(float f, float f2, float f3, float f4, float f5, float f6) {
        a aVar = new a(f, f2, f3, f4);
        aVar.f5098e = f5;
        aVar.f5099f = f6;
        this.f5092e.add(aVar);
        double d = f5 + f6;
        this.f5090c = ((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d))));
        this.f5091d = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d))));
    }

    /* JADX INFO: renamed from: a */
    public void m5497a(Matrix matrix, Path path) {
        int size = this.f5092e.size();
        for (int i = 0; i < size; i++) {
            this.f5092e.get(i).mo5499a(matrix, path);
        }
    }

    /* JADX INFO: renamed from: bb$b */
    /* JADX INFO: compiled from: ShapePath.java */
    public static class b extends c {

        /* JADX INFO: renamed from: a */
        private float f5100a;

        /* JADX INFO: renamed from: b */
        private float f5101b;

        @Override // p000.C0760bb.c
        /* JADX INFO: renamed from: a */
        public void mo5499a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f5102g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f5100a, this.f5101b);
            path.transform(matrix);
        }
    }

    /* JADX INFO: renamed from: bb$a */
    /* JADX INFO: compiled from: ShapePath.java */
    public static class a extends c {

        /* JADX INFO: renamed from: h */
        private static final RectF f5093h = new RectF();

        /* JADX INFO: renamed from: a */
        public float f5094a;

        /* JADX INFO: renamed from: b */
        public float f5095b;

        /* JADX INFO: renamed from: c */
        public float f5096c;

        /* JADX INFO: renamed from: d */
        public float f5097d;

        /* JADX INFO: renamed from: e */
        public float f5098e;

        /* JADX INFO: renamed from: f */
        public float f5099f;

        public a(float f, float f2, float f3, float f4) {
            this.f5094a = f;
            this.f5095b = f2;
            this.f5096c = f3;
            this.f5097d = f4;
        }

        @Override // p000.C0760bb.c
        /* JADX INFO: renamed from: a */
        public void mo5499a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f5102g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f5093h.set(this.f5094a, this.f5095b, this.f5096c, this.f5097d);
            path.arcTo(f5093h, this.f5098e, this.f5099f, false);
            path.transform(matrix);
        }
    }
}
