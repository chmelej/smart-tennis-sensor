package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import p000.C2253xu;

/* JADX INFO: renamed from: xm */
/* JADX INFO: compiled from: ImageViewAction.java */
/* JADX INFO: loaded from: classes.dex */
class C2245xm extends AbstractC2234xb<ImageView> {

    /* JADX INFO: renamed from: m */
    InterfaceC2238xf f13522m;

    C2245xm(C2253xu c2253xu, ImageView imageView, C2256xx c2256xx, int i, int i2, int i3, Drawable drawable, String str, Object obj, InterfaceC2238xf interfaceC2238xf, boolean z) {
        super(c2253xu, imageView, c2256xx, i, i2, i3, drawable, str, obj, z);
        this.f13522m = interfaceC2238xf;
    }

    @Override // p000.AbstractC2234xb
    /* JADX INFO: renamed from: a */
    public void mo12210a(Bitmap bitmap, C2253xu.d dVar) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.f13448c.get();
        if (imageView == null) {
            return;
        }
        C2254xv.m12325a(imageView, this.f13446a.f13557c, bitmap, dVar, this.f13449d, this.f13446a.f13565k);
        if (this.f13522m != null) {
            this.f13522m.m12254a();
        }
    }

    @Override // p000.AbstractC2234xb
    /* JADX INFO: renamed from: a */
    public void mo12209a() {
        ImageView imageView = (ImageView) this.f13448c.get();
        if (imageView == null) {
            return;
        }
        if (this.f13452g != 0) {
            imageView.setImageResource(this.f13452g);
        } else if (this.f13453h != null) {
            imageView.setImageDrawable(this.f13453h);
        }
        if (this.f13522m != null) {
            this.f13522m.m12255b();
        }
    }

    @Override // p000.AbstractC2234xb
    /* JADX INFO: renamed from: b */
    void mo12211b() {
        super.mo12211b();
        if (this.f13522m != null) {
            this.f13522m = null;
        }
    }
}
