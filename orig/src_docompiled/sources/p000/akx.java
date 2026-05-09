package p000;

import android.graphics.Bitmap;
import android.support.v4.view.MotionEventCompat;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: StackBlur.java */
/* JADX INFO: loaded from: classes.dex */
public final class akx implements akt {

    /* JADX INFO: renamed from: a */
    private boolean f1534a;

    /* JADX INFO: renamed from: b */
    private int[] f1535b = new int[1];

    /* JADX INFO: renamed from: c */
    private int[] f1536c = new int[1];

    public akx(boolean z) {
        this.f1534a = z;
    }

    @Override // p000.akt
    /* JADX INFO: renamed from: a */
    public Bitmap mo1744a(Bitmap bitmap, float f) {
        int i = (int) f;
        Bitmap bitmapCopy = this.f1534a ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i2 = width * height;
        if (this.f1535b.length != i2) {
            this.f1535b = new int[i2];
        }
        bitmapCopy.getPixels(this.f1535b, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = i + i + 1;
        int[] iArr = new int[Math.max(width, height)];
        int i6 = (i5 + 1) >> 1;
        int i7 = i6 * i6;
        int i8 = i7 * 256;
        if (this.f1536c.length != i8) {
            this.f1536c = new int[i8];
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            this.f1536c[i10] = i10 / i7;
        }
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, i5, 3);
        int i11 = i + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            int i15 = -i;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i15 <= i) {
                Bitmap bitmap2 = bitmapCopy;
                int i25 = height;
                int i26 = this.f1535b[Math.min(i3, Math.max(i15, i9)) + i13];
                int[] iArr3 = iArr2[i15 + i];
                iArr3[i9] = (i26 & 16711680) >> 16;
                iArr3[1] = (i26 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr3[2] = i26 & 255;
                int iAbs = i11 - Math.abs(i15);
                i16 += iArr3[i9] * iAbs;
                i17 += iArr3[1] * iAbs;
                i18 += iArr3[2] * iAbs;
                if (i15 > 0) {
                    i19 += iArr3[i9];
                    i20 += iArr3[1];
                    i21 += iArr3[2];
                } else {
                    i22 += iArr3[i9];
                    i23 += iArr3[1];
                    i24 += iArr3[2];
                }
                i15++;
                bitmapCopy = bitmap2;
                height = i25;
            }
            Bitmap bitmap3 = bitmapCopy;
            int i27 = height;
            int i28 = i;
            int i29 = 0;
            while (i29 < width) {
                int i30 = i4;
                this.f1535b[i13] = (this.f1536c[i16] << 16) | (this.f1535b[i13] & (-16777216)) | (this.f1536c[i17] << 8) | this.f1536c[i18];
                int i31 = i16 - i22;
                int i32 = i17 - i23;
                int i33 = i18 - i24;
                int[] iArr4 = iArr2[((i28 - i) + i5) % i5];
                int i34 = i22 - iArr4[0];
                int i35 = i23 - iArr4[1];
                int i36 = i24 - iArr4[2];
                if (i12 == 0) {
                    iArr[i29] = Math.min(i29 + i + 1, i3);
                }
                int i37 = this.f1535b[iArr[i29] + i14];
                iArr4[0] = (i37 & 16711680) >> 16;
                iArr4[1] = (i37 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr4[2] = i37 & 255;
                int i38 = i19 + iArr4[0];
                int i39 = i20 + iArr4[1];
                int i40 = i21 + iArr4[2];
                i16 = i31 + i38;
                i17 = i32 + i39;
                i18 = i33 + i40;
                i28 = (i28 + 1) % i5;
                int[] iArr5 = iArr2[i28 % i5];
                i22 = i34 + iArr5[0];
                i23 = i35 + iArr5[1];
                i24 = i36 + iArr5[2];
                i19 = i38 - iArr5[0];
                i20 = i39 - iArr5[1];
                i21 = i40 - iArr5[2];
                i13++;
                i29++;
                i4 = i30;
            }
            i14 += width;
            i12++;
            bitmapCopy = bitmap3;
            height = i27;
            i9 = 0;
        }
        Bitmap bitmap4 = bitmapCopy;
        int i41 = i4;
        int i42 = height;
        int i43 = 0;
        while (i43 < width) {
            int i44 = -i;
            int i45 = i44 * width;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            while (i44 <= i) {
                int[] iArr6 = iArr;
                int iMax = Math.max(0, i45) + i43;
                int[] iArr7 = iArr2[i44 + i];
                int i55 = this.f1535b[iMax];
                iArr7[0] = (i55 & 16711680) >> 16;
                iArr7[1] = (i55 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr7[2] = i55 & 255;
                int iAbs2 = i11 - Math.abs(i44);
                i46 += iArr7[0] * iAbs2;
                i47 += iArr7[1] * iAbs2;
                i48 += iArr7[2] * iAbs2;
                if (i44 > 0) {
                    i49 += iArr7[0];
                    i50 += iArr7[1];
                    i51 += iArr7[2];
                } else {
                    i52 += iArr7[0];
                    i53 += iArr7[1];
                    i54 += iArr7[2];
                }
                int i56 = i41;
                if (i44 < i56) {
                    i45 += width;
                }
                i44++;
                i41 = i56;
                iArr = iArr6;
            }
            int[] iArr8 = iArr;
            int i57 = i41;
            int i58 = i50;
            int i59 = i51;
            int i60 = i42;
            int i61 = 0;
            int i62 = i;
            int i63 = i49;
            int i64 = i48;
            int i65 = i47;
            int i66 = i46;
            int i67 = i43;
            while (i61 < i60) {
                int i68 = i60;
                int i69 = i63;
                int i70 = width;
                this.f1535b[i67] = (this.f1536c[i66] << 16) | (this.f1535b[i67] & (-16777216)) | (this.f1536c[i65] << 8) | this.f1536c[i64];
                int i71 = i66 - i52;
                int i72 = i65 - i53;
                int i73 = i64 - i54;
                int[] iArr9 = iArr2[((i62 - i) + i5) % i5];
                int i74 = i52 - iArr9[0];
                int i75 = i53 - iArr9[1];
                int i76 = i54 - iArr9[2];
                if (i43 == 0) {
                    iArr8[i61] = Math.min(i61 + i11, i57) * i70;
                }
                int i77 = this.f1535b[iArr8[i61] + i43];
                iArr9[0] = (i77 & 16711680) >> 16;
                iArr9[1] = (i77 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i77 & 255;
                int i78 = i69 + iArr9[0];
                int i79 = i58 + iArr9[1];
                int i80 = i59 + iArr9[2];
                i66 = i71 + i78;
                i65 = i72 + i79;
                i64 = i73 + i80;
                i62 = (i62 + 1) % i5;
                int[] iArr10 = iArr2[i62];
                i52 = i74 + iArr10[0];
                i53 = i75 + iArr10[1];
                i54 = i76 + iArr10[2];
                i63 = i78 - iArr10[0];
                i58 = i79 - iArr10[1];
                i59 = i80 - iArr10[2];
                i67 += i70;
                i61++;
                i60 = i68;
                width = i70;
            }
            i43++;
            i41 = i57;
            iArr = iArr8;
            i42 = i60;
            width = width;
        }
        int i81 = width;
        bitmap4.setPixels(this.f1535b, 0, i81, 0, 0, i81, i42);
        return bitmap4;
    }

    @Override // p000.akt
    /* JADX INFO: renamed from: a */
    public void mo1745a() {
        this.f1535b = null;
        this.f1536c = null;
    }

    @Override // p000.akt
    /* JADX INFO: renamed from: b */
    public Bitmap.Config mo1746b() {
        return Bitmap.Config.RGB_565;
    }
}
