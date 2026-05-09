package p000;

import android.graphics.Outline;

/* JADX INFO: renamed from: bg */
/* JADX INFO: compiled from: CircularBorderDrawableLollipop.java */
/* JADX INFO: loaded from: classes.dex */
public class C0765bg extends C0764bf {
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.f5123b);
        outline.setOval(this.f5123b);
    }
}
