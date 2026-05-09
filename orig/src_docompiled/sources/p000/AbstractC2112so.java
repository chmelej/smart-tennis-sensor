package p000;

import java.net.URI;
import java.util.Iterator;

/* JADX INFO: renamed from: so */
/* JADX INFO: compiled from: Zone.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2112so {

    /* JADX INFO: renamed from: so$a */
    /* JADX INFO: compiled from: Zone.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo11564a();

        /* JADX INFO: renamed from: a */
        void mo11565a(int i);
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo11555a(String str, boolean z, String str2);

    /* JADX INFO: renamed from: a */
    public abstract void mo11558a(String str, a aVar);

    /* JADX INFO: renamed from: b */
    public abstract void mo11560b(String str);

    /* JADX INFO: renamed from: a */
    protected synchronized String m11563a(C2113sp c2113sp, boolean z, String str) {
        String str2;
        String str3;
        if (str != null) {
            try {
                c2113sp.m11567a(URI.create(str).getHost());
            } catch (Throwable th) {
                throw th;
            }
        }
        int i = 0;
        while (true) {
            str2 = null;
            if (i >= c2113sp.f12671a.size()) {
                str3 = null;
                break;
            }
            str3 = c2113sp.f12671a.get(i);
            long jLongValue = c2113sp.f12672b.get(str3).longValue();
            if (jLongValue == 0 || jLongValue <= System.currentTimeMillis() / 1000) {
                break;
            }
            i++;
        }
        if (str3 != null) {
            c2113sp.f12672b.put(str3, 0L);
        } else {
            Iterator<String> it = c2113sp.f12671a.iterator();
            while (it.hasNext()) {
                c2113sp.f12672b.put(it.next(), 0L);
            }
            if (c2113sp.f12671a.size() > 0) {
                str3 = c2113sp.f12671a.get(0);
            }
        }
        if (str3 != null) {
            if (z) {
                str2 = String.format("https://%s", str3);
            } else {
                str2 = String.format("http://%s", str3);
            }
        }
        return str2;
    }
}
