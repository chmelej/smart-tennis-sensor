package p000;

import java.util.regex.Pattern;

/* JADX INFO: renamed from: mh */
/* JADX INFO: compiled from: TextCheckUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1909mh {

    /* JADX INFO: renamed from: a */
    private static String f11494a = "TextCheckUtils";

    /* JADX INFO: renamed from: a */
    public static boolean m10521a(String str) {
        return Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[6-8])|(18[0-9]))\\d{8}$").matcher(str).matches();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m10522b(String str) {
        return Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").matcher(str).matches();
    }
}
