package p000;

import android.content.Context;
import java.io.File;
import org.json.JSONObject;
import p000.C2128td;

/* JADX INFO: renamed from: un */
/* JADX INFO: compiled from: PLShortVideoUploader.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2165un {

    /* JADX INFO: renamed from: a */
    private C2138tn f12915a;

    /* JADX INFO: renamed from: b */
    private C2139to f12916b;

    /* JADX INFO: renamed from: d */
    private InterfaceC2166uo f12918d;

    /* JADX INFO: renamed from: e */
    private InterfaceC2167up f12919e;

    /* JADX INFO: renamed from: f */
    private InterfaceC2132th f12920f;

    /* JADX INFO: renamed from: g */
    private C2183ve f12921g;

    /* JADX INFO: renamed from: c */
    private volatile boolean f12917c = false;

    /* JADX INFO: renamed from: h */
    private InterfaceC2134tj f12922h = new InterfaceC2134tj() { // from class: un.2
        @Override // p000.InterfaceC2114sq
        /* JADX INFO: renamed from: a */
        public boolean mo11568a() {
            return C2165un.this.f12917c;
        }
    };

    /* JADX INFO: renamed from: i */
    private InterfaceC2136tl f12923i = new InterfaceC2136tl() { // from class: un.3
        @Override // p000.InterfaceC2136tl
        /* JADX INFO: renamed from: a */
        public void mo11691a(String str, double d) {
            C2165un.this.f12918d.mo7078a(str, d);
        }
    };

    /* JADX INFO: renamed from: j */
    private InterfaceC2135tk f12924j = new InterfaceC2135tk() { // from class: un.4
        @Override // p000.InterfaceC2135tk
        /* JADX INFO: renamed from: a */
        public void mo11690a(String str, C2125ta c2125ta, JSONObject jSONObject) {
            if (c2125ta.m11620b()) {
                C2165un.this.f12919e.mo7079a(jSONObject);
            } else {
                C2165un.this.f12919e.mo7077a(c2125ta.f12730a, c2125ta.f12734e);
            }
        }
    };

    public C2165un(Context context, C2168uq c2168uq) {
        this.f12920f = null;
        this.f12921g = C2183ve.m11912a(context.getApplicationContext());
        this.f12921g.m11924a("upload");
        this.f12921g.m11922a();
        try {
            this.f12920f = new C2140tp(context.getCacheDir().getPath());
        } catch (Exception e) {
            C2201vw.f13226o.m12055e("PLShortVideoUploader", e.getMessage());
        }
        InterfaceC2130tf interfaceC2130tf = new InterfaceC2130tf() { // from class: un.1
            @Override // p000.InterfaceC2130tf
            /* JADX INFO: renamed from: a */
            public String mo11636a(String str, File file) {
                return str + "_._" + ((Object) new StringBuffer(file.getAbsolutePath()).reverse());
            }
        };
        if (this.f12915a == null) {
            this.f12915a = new C2138tn(new C2128td.a().m11649a(c2168uq.m11814a()).m11654b(c2168uq.m11815b()).m11655c(c2168uq.m11816c()).m11656d(c2168uq.m11817d()).m11651a(this.f12920f, interfaceC2130tf).m11650a(c2168uq.m11818e()).m11652a(c2168uq.m11820g()).m11653a());
        }
        this.f12916b = new C2139to(c2168uq.m11819f(), null, false, this.f12923i, this.f12922h);
    }

    /* JADX INFO: renamed from: a */
    public void m11811a(String str, String str2, String str3) {
        C2201vw.f13226o.m12053c("PLShortVideoUploader", "start upload");
        this.f12917c = false;
        this.f12915a.m11700a(str, str2, str3, this.f12924j, this.f12916b);
    }

    /* JADX INFO: renamed from: a */
    public void m11813a(InterfaceC2167up interfaceC2167up) {
        this.f12919e = interfaceC2167up;
    }

    /* JADX INFO: renamed from: a */
    public void m11812a(InterfaceC2166uo interfaceC2166uo) {
        this.f12918d = interfaceC2166uo;
    }
}
