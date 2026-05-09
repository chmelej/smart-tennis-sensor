package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.v4.graphics.drawable.IconCompat;
import p000.AbstractC1788hz;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC1788hz abstractC1788hz) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = abstractC1788hz.m9753b(iconCompat.mType, 1);
        iconCompat.mData = abstractC1788hz.m9759b(iconCompat.mData, 2);
        iconCompat.mParcelable = abstractC1788hz.m9754b(iconCompat.mParcelable, 3);
        iconCompat.mInt1 = abstractC1788hz.m9753b(iconCompat.mInt1, 4);
        iconCompat.mInt2 = abstractC1788hz.m9753b(iconCompat.mInt2, 5);
        iconCompat.mTintList = (ColorStateList) abstractC1788hz.m9754b(iconCompat.mTintList, 6);
        iconCompat.mTintModeStr = abstractC1788hz.m9756b(iconCompat.mTintModeStr, 7);
        iconCompat.onPostParceling();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC1788hz abstractC1788hz) {
        abstractC1788hz.m9749a(true, true);
        iconCompat.onPreParceling(abstractC1788hz.m9752a());
        abstractC1788hz.m9742a(iconCompat.mType, 1);
        abstractC1788hz.m9751a(iconCompat.mData, 2);
        abstractC1788hz.m9744a(iconCompat.mParcelable, 3);
        abstractC1788hz.m9742a(iconCompat.mInt1, 4);
        abstractC1788hz.m9742a(iconCompat.mInt2, 5);
        abstractC1788hz.m9744a(iconCompat.mTintList, 6);
        abstractC1788hz.m9748a(iconCompat.mTintModeStr, 7);
    }
}
