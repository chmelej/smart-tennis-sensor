package p000;

import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: compiled from: Credentials.java */
/* JADX INFO: loaded from: classes.dex */
public final class ams {
    /* JADX INFO: renamed from: a */
    public static String m2014a(String str, String str2) {
        return m2015a(str, str2, anm.f4212f);
    }

    /* JADX INFO: renamed from: a */
    public static String m2015a(String str, String str2, Charset charset) {
        return "Basic " + ByteString.encodeString(str + ":" + str2, charset).base64();
    }
}
