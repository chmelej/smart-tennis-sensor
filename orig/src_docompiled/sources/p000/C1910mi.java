package p000;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

/* JADX INFO: renamed from: mi */
/* JADX INFO: compiled from: TextStyleUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1910mi {
    /* JADX INFO: renamed from: a */
    public static SpannableString m10523a(String str, String str2, int i) {
        SpannableString spannableString = new SpannableString(str2);
        if (str == null) {
            return spannableString;
        }
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), str2.indexOf(str), str2.indexOf(str) + str.length(), 17);
        return spannableString;
    }

    /* JADX INFO: renamed from: b */
    public static SpannableString m10525b(String str, String str2, int i) {
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(i), str2.indexOf(str), str2.indexOf(str) + str.length(), 17);
        return spannableString;
    }

    /* JADX INFO: renamed from: a */
    public static SpannableString m10524a(String str, String str2, int i, int i2) {
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new AbsoluteSizeSpan(i, true), str2.indexOf(str), str2.indexOf(str) + str.length(), 17);
        spannableString.setSpan(new ForegroundColorSpan(i2), str2.indexOf(str), str2.indexOf(str) + str.length(), 17);
        return spannableString;
    }
}
