package p000;

import android.content.Context;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: renamed from: ww */
/* JADX INFO: compiled from: VideoFilterManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C2228ww {

    /* JADX INFO: renamed from: a */
    private Context f13386a;

    /* JADX INFO: renamed from: d */
    private int f13389d;

    /* JADX INFO: renamed from: e */
    private int f13390e;

    /* JADX INFO: renamed from: f */
    private String f13391f;

    /* JADX INFO: renamed from: g */
    private String f13392g;

    /* JADX INFO: renamed from: h */
    private String f13393h;

    /* JADX INFO: renamed from: i */
    private C2173uv f13394i;

    /* JADX INFO: renamed from: j */
    private C2190vl f13395j;

    /* JADX INFO: renamed from: k */
    private C2216wk f13396k;

    /* JADX INFO: renamed from: l */
    private C2217wl f13397l;

    /* JADX INFO: renamed from: b */
    private boolean f13387b = false;

    /* JADX INFO: renamed from: c */
    private boolean f13388c = true;

    /* JADX INFO: renamed from: m */
    private Hashtable<String, Runnable> f13398m = new Hashtable<>();

    public C2228ww(Context context) {
        this.f13386a = context;
    }

    /* JADX INFO: renamed from: a */
    public int m12178a(int i) {
        if (!this.f13398m.isEmpty()) {
            for (Map.Entry<String, Runnable> entry : this.f13398m.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().run();
                }
            }
            this.f13398m.clear();
        }
        if (this.f13395j != null) {
            i = this.f13395j.m12148b(i);
        }
        if (this.f13396k != null) {
            i = this.f13396k.m12128a(i);
        }
        return this.f13397l != null ? this.f13397l.m12130b(i) : i;
    }

    /* JADX INFO: renamed from: a */
    public boolean m12180a() {
        return this.f13387b;
    }

    /* JADX INFO: renamed from: a */
    public void m12179a(int i, int i2) {
        this.f13389d = i;
        this.f13390e = i2;
        this.f13387b = true;
    }

    /* JADX INFO: renamed from: b */
    public void m12181b() {
        m12175c();
        m12176d();
        m12177e();
        this.f13389d = 0;
        this.f13390e = 0;
        this.f13387b = false;
    }

    /* JADX INFO: renamed from: c */
    private void m12175c() {
        if (this.f13395j != null) {
            this.f13395j.mo11992f();
            this.f13395j = null;
        }
        this.f13391f = null;
    }

    /* JADX INFO: renamed from: d */
    private void m12176d() {
        if (this.f13396k != null) {
            this.f13396k.mo11992f();
            this.f13396k = null;
        }
        this.f13392g = null;
        this.f13393h = null;
    }

    /* JADX INFO: renamed from: e */
    private void m12177e() {
        if (this.f13397l != null) {
            this.f13397l.mo11992f();
            this.f13397l = null;
        }
        this.f13394i = null;
    }
}
