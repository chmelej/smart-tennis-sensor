package p000;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: renamed from: cr */
/* JADX INFO: compiled from: RectEvaluator.java */
/* JADX INFO: loaded from: classes.dex */
public class C1643cr implements TypeEvaluator<Rect> {

    /* JADX INFO: renamed from: a */
    private Rect f9327a;

    public C1643cr() {
    }

    public C1643cr(Rect rect) {
        this.f9327a = rect;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - rect.left) * f));
        int i2 = rect.top + ((int) ((rect2.top - rect.top) * f));
        int i3 = rect.right + ((int) ((rect2.right - rect.right) * f));
        int i4 = rect.bottom + ((int) ((rect2.bottom - rect.bottom) * f));
        if (this.f9327a == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.f9327a.set(i, i2, i3, i4);
        return this.f9327a;
    }
}
