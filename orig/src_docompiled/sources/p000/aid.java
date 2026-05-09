package p000;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: ServerUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class aid {
    /* JADX INFO: renamed from: a */
    public static final boolean m1306a(String str) {
        try {
            String lowerCase = str.toLowerCase();
            if (TextUtils.equals(lowerCase, "wjas")) {
                return true;
            }
            return TextUtils.equals(lowerCase, "nginx");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m1307a(Map<String, String> map, int i) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    String str = map.get("server");
                    if (TextUtils.isEmpty(str)) {
                        aiv.m1418c("ServerUtil", "chechHttp--->[serverName==null]");
                        return false;
                    }
                    if (!m1306a(str)) {
                        aiv.m1418c("ServerUtil", "chechHttp--->[serverName!=wjas]");
                        return false;
                    }
                    if (i != 302) {
                        return true;
                    }
                    aiv.m1420d("ServerUtil", "chechHttp---->[failed][" + i + "]");
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        aiv.m1418c("ServerUtil", "chechHttp--->[headers==null]");
        return false;
    }
}
