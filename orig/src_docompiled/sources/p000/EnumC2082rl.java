package p000;

import android.widget.ImageView;

/* JADX INFO: renamed from: rl */
/* JADX INFO: compiled from: ViewScaleType.java */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC2082rl {
    FIT_INSIDE,
    CROP;

    /* JADX INFO: renamed from: rl$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewScaleType.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f12584a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f12584a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12584a[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12584a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12584a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12584a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12584a[ImageView.ScaleType.MATRIX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12584a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12584a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static EnumC2082rl m11437a(ImageView imageView) {
        switch (AnonymousClass1.f12584a[imageView.getScaleType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return FIT_INSIDE;
            default:
                return CROP;
        }
    }
}
