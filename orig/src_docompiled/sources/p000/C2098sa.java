package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

/* JADX INFO: renamed from: sa */
/* JADX INFO: compiled from: NonViewAware.java */
/* JADX INFO: loaded from: classes.dex */
public class C2098sa implements InterfaceC2095ry {

    /* JADX INFO: renamed from: a */
    protected final String f12635a;

    /* JADX INFO: renamed from: b */
    protected final C2079ri f12636b;

    /* JADX INFO: renamed from: c */
    protected final EnumC2082rl f12637c;

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: a */
    public boolean mo11494a(Bitmap bitmap) {
        return true;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: a */
    public boolean mo11495a(Drawable drawable) {
        return true;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: d */
    public View mo11498d() {
        return null;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: e */
    public boolean mo11499e() {
        return false;
    }

    public C2098sa(String str, C2079ri c2079ri, EnumC2082rl enumC2082rl) {
        if (c2079ri == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (enumC2082rl == null) {
            throw new IllegalArgumentException("scaleType must not be null");
        }
        this.f12635a = str;
        this.f12636b = c2079ri;
        this.f12637c = enumC2082rl;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: a */
    public int mo11493a() {
        return this.f12636b.m11433a();
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: b */
    public int mo11496b() {
        return this.f12636b.m11436b();
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: c */
    public EnumC2082rl mo11497c() {
        return this.f12637c;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: f */
    public int mo11500f() {
        return TextUtils.isEmpty(this.f12635a) ? super.hashCode() : this.f12635a.hashCode();
    }
}
