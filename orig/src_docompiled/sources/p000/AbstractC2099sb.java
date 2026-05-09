package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: sb */
/* JADX INFO: compiled from: ViewAware.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2099sb implements InterfaceC2095ry {

    /* JADX INFO: renamed from: a */
    protected Reference<View> f12638a;

    /* JADX INFO: renamed from: b */
    protected boolean f12639b;

    /* JADX INFO: renamed from: a */
    protected abstract void mo11502a(Bitmap bitmap, View view);

    /* JADX INFO: renamed from: a */
    protected abstract void mo11503a(Drawable drawable, View view);

    public AbstractC2099sb(View view) {
        this(view, true);
    }

    public AbstractC2099sb(View view, boolean z) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.f12638a = new WeakReference(view);
        this.f12639b = z;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: a */
    public int mo11493a() {
        View view = this.f12638a.get();
        int width = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f12639b && layoutParams != null && layoutParams.width != -2) {
            width = view.getWidth();
        }
        return (width > 0 || layoutParams == null) ? width : layoutParams.width;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: b */
    public int mo11496b() {
        View view = this.f12638a.get();
        int height = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f12639b && layoutParams != null && layoutParams.height != -2) {
            height = view.getHeight();
        }
        return (height > 0 || layoutParams == null) ? height : layoutParams.height;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: c */
    public EnumC2082rl mo11497c() {
        return EnumC2082rl.CROP;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: d */
    public View mo11498d() {
        return this.f12638a.get();
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: e */
    public boolean mo11499e() {
        return this.f12638a.get() == null;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: f */
    public int mo11500f() {
        View view = this.f12638a.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: a */
    public boolean mo11495a(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f12638a.get();
            if (view != null) {
                mo11503a(drawable, view);
                return true;
            }
        } else {
            C2106si.m11526c("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    @Override // p000.InterfaceC2095ry
    /* JADX INFO: renamed from: a */
    public boolean mo11494a(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f12638a.get();
            if (view != null) {
                mo11502a(bitmap, view);
                return true;
            }
        } else {
            C2106si.m11526c("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }
}
