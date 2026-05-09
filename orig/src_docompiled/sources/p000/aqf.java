package p000;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: RequestParams.java */
/* JADX INFO: loaded from: classes.dex */
public final class aqf {

    /* JADX INFO: renamed from: a */
    protected ConcurrentHashMap<String, String> f4636a;

    public aqf() {
        m5010b();
    }

    /* JADX INFO: renamed from: a */
    public final void m5012a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f4636a.put(str, str2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f4636a.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    private void m5010b() {
        this.f4636a = new ConcurrentHashMap<>();
    }

    /* JADX INFO: renamed from: a */
    public final String m5011a() {
        return m5009a(this.f4636a);
    }

    /* JADX INFO: renamed from: a */
    public static final String m5009a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strM5008a = m5008a(entry.getKey());
            String value = entry.getValue();
            String strM5008a2 = value != null ? m5008a(value) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strM5008a);
            sb.append("=");
            sb.append(strM5008a2);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private static String m5008a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
