package p000;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.lidroid.xutils.util.CharsetUtils;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: renamed from: tc */
/* JADX INFO: compiled from: UserAgent.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2127tc {

    /* JADX INFO: renamed from: c */
    private static C2127tc f12756c = new C2127tc();

    /* JADX INFO: renamed from: a */
    public final String f12757a = m11631b();

    /* JADX INFO: renamed from: b */
    public final String f12758b = m11628a(this.f12757a);

    private C2127tc() {
    }

    /* JADX INFO: renamed from: a */
    public static C2127tc m11630a() {
        return f12756c;
    }

    /* JADX INFO: renamed from: b */
    private static String m11631b() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    /* JADX INFO: renamed from: a */
    static String m11628a(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.15", m11632c(), m11633d(), str);
    }

    /* JADX INFO: renamed from: c */
    private static String m11632c() {
        try {
            String str = Build.VERSION.RELEASE;
            return str == null ? "-" : C2146tv.m11720b(str.trim());
        } catch (Throwable unused) {
            return "-";
        }
    }

    /* JADX INFO: renamed from: d */
    private static String m11633d() {
        try {
            String strTrim = Build.MODEL.trim();
            String strM11629a = m11629a(Build.MANUFACTURER.trim(), strTrim);
            if (TextUtils.isEmpty(strM11629a)) {
                strM11629a = m11629a(Build.BRAND.trim(), strTrim);
            }
            StringBuilder sb = new StringBuilder();
            if (strM11629a == null) {
                strM11629a = "-";
            }
            sb.append(strM11629a);
            sb.append("-");
            sb.append(strTrim);
            return C2146tv.m11720b(sb.toString());
        } catch (Throwable unused) {
            return "-";
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m11629a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: renamed from: b */
    public String m11634b(String str) {
        String strTrim = ("" + str).trim();
        return new String((this.f12758b + "; " + strTrim.substring(0, Math.min(16, strTrim.length())) + ")").getBytes(Charset.forName(CharsetUtils.DEFAULT_ENCODING_CHARSET)));
    }
}
