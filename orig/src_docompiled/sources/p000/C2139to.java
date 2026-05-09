package p000;

import android.os.Looper;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: to */
/* JADX INFO: compiled from: UploadOptions.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2139to {

    /* JADX INFO: renamed from: a */
    final Map<String, String> f12849a;

    /* JADX INFO: renamed from: b */
    final String f12850b;

    /* JADX INFO: renamed from: c */
    final boolean f12851c;

    /* JADX INFO: renamed from: d */
    final InterfaceC2136tl f12852d;

    /* JADX INFO: renamed from: e */
    final InterfaceC2134tj f12853e;

    /* JADX INFO: renamed from: f */
    final InterfaceC2131tg f12854f;

    public C2139to(Map<String, String> map, String str, boolean z, InterfaceC2136tl interfaceC2136tl, InterfaceC2134tj interfaceC2134tj) {
        this(map, str, z, interfaceC2136tl, interfaceC2134tj, null);
    }

    public C2139to(Map<String, String> map, String str, boolean z, InterfaceC2136tl interfaceC2136tl, InterfaceC2134tj interfaceC2134tj, InterfaceC2131tg interfaceC2131tg) {
        this.f12849a = m11702a(map);
        this.f12850b = m11701a(str);
        this.f12851c = z;
        this.f12852d = interfaceC2136tl == null ? new InterfaceC2136tl() { // from class: to.1
            @Override // p000.InterfaceC2136tl
            /* JADX INFO: renamed from: a */
            public void mo11691a(String str2, double d) {
                Log.d("Qiniu.UploadProgress", "" + d);
            }
        } : interfaceC2136tl;
        this.f12853e = interfaceC2134tj == null ? new InterfaceC2134tj() { // from class: to.2
            @Override // p000.InterfaceC2114sq
            /* JADX INFO: renamed from: a */
            public boolean mo11568a() {
                return false;
            }
        } : interfaceC2134tj;
        this.f12854f = interfaceC2131tg == null ? new InterfaceC2131tg() { // from class: to.3
            @Override // p000.InterfaceC2131tg
            /* JADX INFO: renamed from: a */
            public void mo11659a() {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    return;
                }
                for (int i = 0; i < 6; i++) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (C2141tq.m11706a()) {
                        return;
                    }
                }
            }
        } : interfaceC2131tg;
    }

    /* JADX INFO: renamed from: a */
    private static Map<String, String> m11702a(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("x:") && entry.getValue() != null && !entry.getValue().equals("")) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    /* JADX INFO: renamed from: a */
    static C2139to m11703a() {
        return new C2139to(null, null, false, null, null);
    }

    /* JADX INFO: renamed from: a */
    private static String m11701a(String str) {
        return (str == null || str.equals("")) ? "application/octet-stream" : str;
    }
}
