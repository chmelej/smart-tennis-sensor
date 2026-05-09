package p000;

import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p000.AbstractC2112so;

/* JADX INFO: renamed from: sn */
/* JADX INFO: compiled from: AutoZone.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2111sn extends AbstractC2112so {

    /* JADX INFO: renamed from: a */
    public static final C2111sn f12661a = new C2111sn();

    /* JADX INFO: renamed from: b */
    private final String f12662b;

    /* JADX INFO: renamed from: c */
    private Map<a, C2113sp> f12663c;

    /* JADX INFO: renamed from: d */
    private C2115sr f12664d;

    public C2111sn() {
        this("https://uc.qbox.me");
    }

    C2111sn(String str) {
        this.f12663c = new ConcurrentHashMap();
        this.f12664d = new C2115sr();
        this.f12662b = str;
    }

    /* JADX INFO: renamed from: a */
    private void m11554a(a aVar, InterfaceC2116ss interfaceC2116ss) {
        this.f12664d.m11579a(this.f12662b + "/v2/query?ak=" + aVar.f12668a + "&bucket=" + aVar.f12669b, null, C2137tm.f12827a, interfaceC2116ss);
    }

    /* JADX INFO: renamed from: a */
    C2113sp m11557a(String str, String str2) {
        return this.f12663c.get(new a(str, str2));
    }

    /* JADX INFO: renamed from: a */
    C2113sp m11556a(String str) {
        try {
            String[] strArrSplit = str.split(":");
            return m11557a(strArrSplit[0], new JSONObject(new String(C2147tw.m11723b(strArrSplit[2]), "utf-8")).getString("scope").split(":")[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    void m11559a(final a aVar, final AbstractC2112so.a aVar2) {
        if (aVar == null) {
            aVar2.mo11565a(-5);
        } else if (this.f12663c.get(aVar) != null) {
            aVar2.mo11564a();
        } else {
            m11554a(aVar, new InterfaceC2116ss() { // from class: sn.1
                @Override // p000.InterfaceC2116ss
                /* JADX INFO: renamed from: a */
                public void mo11561a(C2125ta c2125ta, JSONObject jSONObject) {
                    if (c2125ta.m11620b() && jSONObject != null) {
                        try {
                            C2111sn.this.f12663c.put(aVar, C2113sp.m11566a(jSONObject));
                            aVar2.mo11564a();
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            aVar2.mo11565a(-1);
                            return;
                        }
                    }
                    aVar2.mo11565a(c2125ta.f12730a);
                }
            });
        }
    }

    @Override // p000.AbstractC2112so
    /* JADX INFO: renamed from: a */
    public synchronized String mo11555a(String str, boolean z, String str2) {
        C2113sp c2113spM11556a = m11556a(str);
        if (c2113spM11556a == null) {
            return null;
        }
        return super.m11563a(c2113spM11556a, z, str2);
    }

    @Override // p000.AbstractC2112so
    /* JADX INFO: renamed from: a */
    public void mo11558a(String str, AbstractC2112so.a aVar) {
        m11559a(a.m11562a(str), aVar);
    }

    @Override // p000.AbstractC2112so
    /* JADX INFO: renamed from: b */
    public synchronized void mo11560b(String str) {
        if (str != null) {
            String host = URI.create(str).getHost();
            C2113sp c2113sp = null;
            Iterator<Map.Entry<a, C2113sp>> it = this.f12663c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C2113sp value = it.next().getValue();
                if (value.f12671a.contains(host)) {
                    c2113sp = value;
                    break;
                }
            }
            if (c2113sp != null) {
                c2113sp.m11567a(host);
            }
        }
    }

    /* JADX INFO: renamed from: sn$a */
    /* JADX INFO: compiled from: AutoZone.java */
    static class a {

        /* JADX INFO: renamed from: a */
        final String f12668a;

        /* JADX INFO: renamed from: b */
        final String f12669b;

        a(String str, String str2) {
            this.f12668a = str;
            this.f12669b = str2;
        }

        /* JADX INFO: renamed from: a */
        static a m11562a(String str) {
            String[] strArrSplit = str.split(":");
            try {
                return new a(strArrSplit[0], new JSONObject(new String(C2147tw.m11723b(strArrSplit[2]), "utf-8")).getString("scope").split(":")[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int hashCode() {
            return (this.f12668a.hashCode() * 37) + this.f12669b.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (obj != null && (obj instanceof a)) {
                    a aVar = (a) obj;
                    if (!aVar.f12668a.equals(this.f12668a) || !aVar.f12669b.equals(this.f12669b)) {
                    }
                }
                return false;
            }
            return true;
        }
    }
}
