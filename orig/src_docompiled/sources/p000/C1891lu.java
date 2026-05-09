package p000;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: renamed from: lu */
/* JADX INFO: compiled from: BlurTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1891lu implements InterfaceC2263yd {

    /* JADX INFO: renamed from: a */
    RenderScript f11439a;

    @Override // p000.InterfaceC2263yd
    /* JADX INFO: renamed from: a */
    public String mo10440a() {
        return "blur";
    }

    public C1891lu(Context context) {
        this.f11439a = RenderScript.create(context);
    }

    @Override // p000.InterfaceC2263yd
    /* JADX INFO: renamed from: a */
    public Bitmap mo10439a(Bitmap bitmap) {
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.f11439a, bitmapCopy, Allocation.MipmapControl.MIPMAP_FULL, 128);
        Allocation allocationCreateTyped = Allocation.createTyped(this.f11439a, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(this.f11439a, Element.U8_4(this.f11439a));
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(25.0f);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(bitmapCopy);
        bitmap.recycle();
        return bitmapCopy;
    }
}
