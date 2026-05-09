package p000;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* JADX INFO: renamed from: aa */
/* JADX INFO: compiled from: ImageMatrixProperty.java */
/* JADX INFO: loaded from: classes.dex */
public class C0001aa extends Property<ImageView, Matrix> {

    /* JADX INFO: renamed from: a */
    private final Matrix f5a;

    public C0001aa() {
        super(Matrix.class, "imageMatrixProperty");
        this.f5a = new Matrix();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.f5a.set(imageView.getImageMatrix());
        return this.f5a;
    }
}
