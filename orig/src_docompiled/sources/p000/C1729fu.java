package p000;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.WrappedDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: renamed from: fu */
/* JADX INFO: compiled from: AppCompatProgressBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1729fu {

    /* JADX INFO: renamed from: a */
    private static final int[] f9873a = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: b */
    private final ProgressBar f9874b;

    /* JADX INFO: renamed from: c */
    private Bitmap f9875c;

    public C1729fu(ProgressBar progressBar) {
        this.f9874b = progressBar;
    }

    /* JADX INFO: renamed from: a */
    public void mo9280a(AttributeSet attributeSet, int i) {
        C1766hd c1766hdM9601a = C1766hd.m9601a(this.f9874b.getContext(), attributeSet, f9873a, i, 0);
        Drawable drawableM9610b = c1766hdM9601a.m9610b(0);
        if (drawableM9610b != null) {
            this.f9874b.setIndeterminateDrawable(m9276a(drawableM9610b));
        }
        Drawable drawableM9610b2 = c1766hdM9601a.m9610b(1);
        if (drawableM9610b2 != null) {
            this.f9874b.setProgressDrawable(m9277a(drawableM9610b2, false));
        }
        c1766hdM9601a.m9606a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private Drawable m9277a(Drawable drawable, boolean z) {
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable) drawable;
            Drawable wrappedDrawable2 = wrappedDrawable.getWrappedDrawable();
            if (wrappedDrawable2 != null) {
                wrappedDrawable.setWrappedDrawable(m9277a(wrappedDrawable2, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = m9277a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f9875c == null) {
                    this.f9875c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(m9278b());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m9276a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableM9277a = m9277a(animationDrawable.getFrame(i), true);
            drawableM9277a.setLevel(10000);
            animationDrawable2.addFrame(drawableM9277a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* JADX INFO: renamed from: b */
    private Shape m9278b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* JADX INFO: renamed from: a */
    public Bitmap m9279a() {
        return this.f9875c;
    }
}
