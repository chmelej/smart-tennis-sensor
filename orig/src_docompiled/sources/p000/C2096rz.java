package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: rz */
/* JADX INFO: compiled from: ImageViewAware.java */
/* JADX INFO: loaded from: classes.dex */
public class C2096rz extends AbstractC2099sb {
    public C2096rz(ImageView imageView) {
        super(imageView);
    }

    @Override // p000.AbstractC2099sb, p000.InterfaceC2095ry
    /* JADX INFO: renamed from: a */
    public int mo11493a() {
        ImageView imageView;
        int iMo11493a = super.mo11493a();
        return (iMo11493a > 0 || (imageView = (ImageView) this.f12638a.get()) == null) ? iMo11493a : m11501a(imageView, "mMaxWidth");
    }

    @Override // p000.AbstractC2099sb, p000.InterfaceC2095ry
    /* JADX INFO: renamed from: b */
    public int mo11496b() {
        ImageView imageView;
        int iMo11496b = super.mo11496b();
        return (iMo11496b > 0 || (imageView = (ImageView) this.f12638a.get()) == null) ? iMo11496b : m11501a(imageView, "mMaxHeight");
    }

    @Override // p000.AbstractC2099sb, p000.InterfaceC2095ry
    /* JADX INFO: renamed from: c */
    public EnumC2082rl mo11497c() {
        ImageView imageView = (ImageView) this.f12638a.get();
        if (imageView != null) {
            return EnumC2082rl.m11437a(imageView);
        }
        return super.mo11497c();
    }

    @Override // p000.AbstractC2099sb, p000.InterfaceC2095ry
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ImageView mo11498d() {
        return (ImageView) super.mo11498d();
    }

    @Override // p000.AbstractC2099sb
    /* JADX INFO: renamed from: a */
    protected void mo11503a(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // p000.AbstractC2099sb
    /* JADX INFO: renamed from: a */
    protected void mo11502a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    /* JADX INFO: renamed from: a */
    private static int m11501a(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int iIntValue = ((Integer) declaredField.get(obj)).intValue();
            if (iIntValue <= 0 || iIntValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return iIntValue;
        } catch (Exception e) {
            C2106si.m11523a(e);
            return 0;
        }
    }
}
