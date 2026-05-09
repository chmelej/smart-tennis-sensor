package p000;

import android.content.Context;
import java.util.zip.Adler32;

/* JADX INFO: renamed from: yr */
/* JADX INFO: compiled from: DeviceInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class C2277yr {

    /* JADX INFO: renamed from: a */
    static String f13752a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";

    /* JADX INFO: renamed from: b */
    static final Object f13753b = new Object();

    /* JADX INFO: renamed from: c */
    private static C2276yq f13754c;

    /* JADX INFO: renamed from: a */
    static long m12496a(C2276yq c2276yq) {
        if (c2276yq == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", c2276yq.m12495e(), c2276yq.m12493d(), Long.valueOf(c2276yq.m12485a()), c2276yq.m12491c(), c2276yq.m12488b());
        if (C2270yk.m12426a(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    /* JADX INFO: renamed from: b */
    private static C2276yq m12498b(Context context) {
        if (context == null) {
            return null;
        }
        new C2276yq();
        synchronized (f13753b) {
            String strM12511a = C2279yt.m12502a(context).m12511a();
            if (C2270yk.m12426a(strM12511a)) {
                return null;
            }
            if (strM12511a.endsWith("\n")) {
                strM12511a = strM12511a.substring(0, strM12511a.length() - 1);
            }
            C2276yq c2276yq = new C2276yq();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strM12424a = C2269yj.m12424a(context);
            String strM12425b = C2269yj.m12425b(context);
            c2276yq.m12492c(strM12424a);
            c2276yq.m12487a(strM12424a);
            c2276yq.m12489b(jCurrentTimeMillis);
            c2276yq.m12490b(strM12425b);
            c2276yq.m12494d(strM12511a);
            c2276yq.m12486a(m12496a(c2276yq));
            return c2276yq;
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C2276yq m12497a(Context context) {
        if (f13754c != null) {
            return f13754c;
        }
        if (context == null) {
            return null;
        }
        C2276yq c2276yqM12498b = m12498b(context);
        f13754c = c2276yqM12498b;
        return c2276yqM12498b;
    }
}
