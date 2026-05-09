package p000;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: zc */
/* JADX INFO: loaded from: classes.dex */
public final class C2289zc {

    /* JADX INFO: renamed from: d */
    private static C2289zc f13776d;

    /* JADX INFO: renamed from: a */
    private Map<Integer, AbstractC2288zb> f13777a;

    /* JADX INFO: renamed from: b */
    private int f13778b = 0;

    /* JADX INFO: renamed from: c */
    private Context f13779c;

    private C2289zc(Context context) {
        this.f13777a = null;
        this.f13779c = null;
        this.f13779c = context.getApplicationContext();
        this.f13777a = new HashMap(3);
        this.f13777a.put(1, new C2287za(context));
        this.f13777a.put(2, new C2283yx(context));
        this.f13777a.put(4, new C2285yz(context));
    }

    /* JADX INFO: renamed from: a */
    private C2284yy m12529a(List<Integer> list) {
        C2284yy c2284yyM12528c;
        if (list != null && list.size() >= 0) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                AbstractC2288zb abstractC2288zb = this.f13777a.get(it.next());
                if (abstractC2288zb != null && (c2284yyM12528c = abstractC2288zb.m12528c()) != null && C2290zd.m12539b(c2284yyM12528c.f13771c)) {
                    return c2284yyM12528c;
                }
            }
        }
        return new C2284yy();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C2289zc m12530a(Context context) {
        if (f13776d == null) {
            f13776d = new C2289zc(context);
        }
        return f13776d;
    }

    /* JADX INFO: renamed from: a */
    public final C2284yy m12531a() {
        return m12529a(new ArrayList(Arrays.asList(1, 2, 4)));
    }

    /* JADX INFO: renamed from: a */
    public final void m12532a(String str) {
        C2284yy c2284yyM12531a = m12531a();
        c2284yyM12531a.f13771c = str;
        if (!C2290zd.m12537a(c2284yyM12531a.f13769a)) {
            c2284yyM12531a.f13769a = C2290zd.m12533a(this.f13779c);
        }
        if (!C2290zd.m12537a(c2284yyM12531a.f13770b)) {
            c2284yyM12531a.f13770b = C2290zd.m12538b(this.f13779c);
        }
        c2284yyM12531a.f13772d = System.currentTimeMillis();
        Iterator<Map.Entry<Integer, AbstractC2288zb>> it = this.f13777a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().m12527a(c2284yyM12531a);
        }
    }
}
