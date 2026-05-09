package p000;

import android.os.Bundle;

/* JADX INFO: renamed from: zv */
/* JADX INFO: loaded from: classes.dex */
public final class C2308zv {

    /* JADX INFO: renamed from: a */
    public int f13828a;

    /* JADX INFO: renamed from: b */
    public String f13829b;

    /* JADX INFO: renamed from: c */
    public String f13830c;

    /* JADX INFO: renamed from: d */
    public byte[] f13831d;

    /* JADX INFO: renamed from: e */
    public b f13832e;

    /* JADX INFO: renamed from: f */
    public String f13833f;

    /* JADX INFO: renamed from: g */
    public String f13834g;

    /* JADX INFO: renamed from: h */
    public String f13835h;

    /* JADX INFO: renamed from: zv$a */
    public static class a {
        /* JADX INFO: renamed from: a */
        private static String m12566a(String str) {
            if (str != null && str.length() != 0) {
                return str.replace("com.tencent.mm.sdk.openapi", "com.tencent.mm.sdk.modelmsg");
            }
            C2295zi.m12548a("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
            return str;
        }

        /* JADX INFO: renamed from: a */
        public static C2308zv m12567a(Bundle bundle) {
            C2308zv c2308zv = new C2308zv();
            c2308zv.f13828a = bundle.getInt("_wxobject_sdkVer");
            c2308zv.f13829b = bundle.getString("_wxobject_title");
            c2308zv.f13830c = bundle.getString("_wxobject_description");
            c2308zv.f13831d = bundle.getByteArray("_wxobject_thumbdata");
            c2308zv.f13833f = bundle.getString("_wxobject_mediatagname");
            c2308zv.f13834g = bundle.getString("_wxobject_message_action");
            c2308zv.f13835h = bundle.getString("_wxobject_message_ext");
            String strM12566a = m12566a(bundle.getString("_wxobject_identifier_"));
            if (strM12566a == null || strM12566a.length() <= 0) {
                return c2308zv;
            }
            try {
                c2308zv.f13832e = (b) Class.forName(strM12566a).newInstance();
                c2308zv.f13832e.m12568a(bundle);
                return c2308zv;
            } catch (Exception e) {
                e.printStackTrace();
                C2295zi.m12548a("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + strM12566a + ", ex = " + e.getMessage());
                return c2308zv;
            }
        }
    }

    /* JADX INFO: renamed from: zv$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void m12568a(Bundle bundle);
    }

    public C2308zv() {
        this(null);
    }

    public C2308zv(b bVar) {
        this.f13832e = bVar;
    }
}
