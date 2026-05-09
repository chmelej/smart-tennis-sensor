package p000;

import android.content.Context;
import com.qiniu.pili.droid.beauty.JNIControl;

/* JADX INFO: renamed from: ty */
/* JADX INFO: compiled from: ParakenRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2149ty {

    /* JADX INFO: renamed from: b */
    private int f12866b;

    /* JADX INFO: renamed from: a */
    private int f12865a = -1;

    /* JADX INFO: renamed from: c */
    private boolean f12867c = false;

    /* JADX INFO: renamed from: a */
    public void m11735a(Context context, int i, int i2) {
        this.f12867c = true;
        if (this.f12865a == -1) {
            if (i == 3) {
                JNIControl.setGLES(3);
            } else {
                JNIControl.setGLES(2);
            }
            JNIControl.onSurfaceCreated(context, i2);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11738b(Context context, int i, int i2) {
        JNIControl.onSurfaceChanged(i, i2);
        this.f12866b = JNIControl.getOutputTexture();
        JNIControl.setCurrentDirection(1);
    }

    /* JADX INFO: renamed from: a */
    public void m11732a() {
        if (this.f12867c) {
            JNIControl.reInit();
        }
        this.f12867c = false;
        this.f12865a = -1;
    }

    /* JADX INFO: renamed from: a */
    public void m11734a(int i, int i2, int i3, int i4) {
        JNIControl.setSurfaceTextureID(i);
        JNIControl.processThrough(0L, i3, i2, i3, i2, i4);
    }

    /* JADX INFO: renamed from: a */
    public void m11736a(boolean z) {
        JNIControl.setIsPortraitDisplay(z);
    }

    /* JADX INFO: renamed from: a */
    public void m11733a(float f) {
        JNIControl.setBeautify(f);
    }

    /* JADX INFO: renamed from: b */
    public void m11737b(float f) {
        JNIControl.setWhiten(f);
    }

    /* JADX INFO: renamed from: c */
    public void m11739c(float f) {
        JNIControl.setRedden(f);
    }
}
