package p000;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import com.coollang.tennis.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* JADX INFO: renamed from: ke */
/* JADX INFO: compiled from: ImageDisplayer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1848ke {

    /* JADX INFO: renamed from: c */
    private static C1848ke f10883c;

    /* JADX INFO: renamed from: d */
    private Context f10886d;

    /* JADX INFO: renamed from: e */
    private int f10887e;

    /* JADX INFO: renamed from: f */
    private int f10888f;

    /* JADX INFO: renamed from: a */
    public Handler f10884a = new Handler();

    /* JADX INFO: renamed from: b */
    public final String f10885b = getClass().getSimpleName();

    /* JADX INFO: renamed from: g */
    private HashMap<String, SoftReference<Bitmap>> f10889g = new HashMap<>();

    /* JADX INFO: renamed from: a */
    public static C1848ke m10084a(Context context) {
        if (f10883c == null) {
            synchronized (C1848ke.class) {
                f10883c = new C1848ke(context);
            }
        }
        return f10883c;
    }

    public C1848ke(Context context) {
        if (context.getApplicationContext() != null) {
            this.f10886d = context.getApplicationContext();
        } else {
            this.f10886d = context;
        }
        new DisplayMetrics();
        DisplayMetrics displayMetrics = this.f10886d.getResources().getDisplayMetrics();
        this.f10887e = displayMetrics.widthPixels;
        this.f10888f = displayMetrics.heightPixels;
    }

    /* JADX INFO: renamed from: a */
    public void m10091a(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        this.f10889g.put(str, new SoftReference<>(bitmap));
    }

    /* JADX INFO: renamed from: a */
    public void m10089a(ImageView imageView, String str, String str2) {
        m10090a(imageView, str, str2, true);
    }

    /* JADX INFO: renamed from: a */
    public void m10090a(ImageView imageView, String str, String str2, boolean z) {
        String str3;
        String str4;
        String str5;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            Log.e(this.f10885b, "no paths pass in");
            return;
        }
        if (imageView.getTag() == null || !imageView.getTag().equals(str2)) {
            m10085a(imageView);
            if (!TextUtils.isEmpty(str) && z) {
                str3 = str;
            } else if (TextUtils.isEmpty(str2)) {
                return;
            } else {
                str3 = str2;
            }
            imageView.setTag(str3);
            HashMap<String, SoftReference<Bitmap>> map = this.f10889g;
            if (z) {
                str4 = str3 + "256256";
            } else {
                str4 = str3;
            }
            if (map.containsKey(str4)) {
                HashMap<String, SoftReference<Bitmap>> map2 = this.f10889g;
                if (z) {
                    str5 = str3 + "256256";
                } else {
                    str5 = str3;
                }
                Bitmap bitmap = map2.get(str5).get();
                if (bitmap != null) {
                    m10086a(imageView, bitmap, str3);
                    return;
                }
            }
            imageView.setImageBitmap(null);
            new AnonymousClass1(str3, str, str2, z, imageView).start();
        }
    }

    /* JADX INFO: renamed from: ke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageDisplayer.java */
    class AnonymousClass1 extends Thread {

        /* JADX INFO: renamed from: a */
        Bitmap f10890a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f10891b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ String f10892c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ String f10893d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ boolean f10894e;

        /* JADX INFO: renamed from: f */
        final /* synthetic */ ImageView f10895f;

        AnonymousClass1(String str, String str2, String str3, boolean z, ImageView imageView) {
            this.f10891b = str;
            this.f10892c = str2;
            this.f10893d = str3;
            this.f10894e = z;
            this.f10895f = imageView;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            try {
                if (this.f10891b != null && this.f10891b.equals(this.f10892c)) {
                    this.f10890a = BitmapFactory.decodeFile(this.f10891b);
                }
                if (this.f10890a == null) {
                    this.f10890a = C1848ke.this.m10088a(this.f10893d, this.f10894e);
                }
            } catch (Exception unused) {
            }
            if (this.f10890a != null) {
                C1848ke c1848ke = C1848ke.this;
                if (this.f10894e) {
                    str = this.f10891b + "256256";
                } else {
                    str = this.f10891b;
                }
                c1848ke.m10091a(str, this.f10890a);
            }
            C1848ke.this.f10884a.post(new Runnable() { // from class: ke.1.1
                @Override // java.lang.Runnable
                public void run() {
                    C1848ke.this.m10086a(AnonymousClass1.this.f10895f, AnonymousClass1.this.f10890a, AnonymousClass1.this.f10891b);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10086a(ImageView imageView, Bitmap bitmap, String str) {
        if (imageView == null || bitmap == null || str == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        imageView.setTag(str);
    }

    /* JADX INFO: renamed from: a */
    private void m10085a(ImageView imageView) {
        imageView.setBackgroundResource(R.drawable.bg_img);
    }

    /* JADX INFO: renamed from: a */
    public Bitmap m10088a(String str, boolean z) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(bufferedInputStream, null, options);
        bufferedInputStream.close();
        if (z) {
            int i = 0;
            while (true) {
                if ((options.outWidth >> i) <= 256 && (options.outHeight >> i) <= 256) {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(str)));
                    options.inSampleSize = (int) Math.pow(2.0d, i);
                    options.inJustDecodeBounds = false;
                    return BitmapFactory.decodeStream(bufferedInputStream2, null, options);
                }
                i++;
            }
        } else {
            int i2 = 0;
            while (true) {
                if ((options.outWidth >> i2) <= this.f10887e && (options.outHeight >> i2) <= this.f10888f) {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(new File(str)));
                    options.inSampleSize = (int) Math.pow(2.0d, i2);
                    options.inJustDecodeBounds = false;
                    return BitmapFactory.decodeStream(bufferedInputStream3, null, options);
                }
                i2++;
            }
        }
    }
}
