package p000;

import java.util.TimeZone;

/* JADX INFO: renamed from: zm */
/* JADX INFO: loaded from: classes.dex */
public final class C2299zm {

    /* JADX INFO: renamed from: a */
    private static final long[] f13799a = {300, 200, 300, 200};

    /* JADX INFO: renamed from: b */
    private static final long[] f13800b = {300, 50, 300, 50};

    /* JADX INFO: renamed from: c */
    private static final TimeZone f13801c = TimeZone.getTimeZone("GMT");

    /* JADX INFO: renamed from: d */
    private static final char[] f13802d = {'<', '>', '\"', '\'', '&', '\r', '\n', ' ', '\t'};

    /* JADX INFO: renamed from: e */
    private static final String[] f13803e = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};

    /* JADX INFO: renamed from: a */
    public static boolean m12563a(String str) {
        return str == null || str.length() <= 0;
    }
}
