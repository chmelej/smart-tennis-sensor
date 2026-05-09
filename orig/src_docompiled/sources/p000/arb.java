package p000;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MtopRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class arb {

    /* JADX INFO: renamed from: a */
    private volatile String f4834a;

    /* JADX INFO: renamed from: b */
    private volatile String f4835b;

    /* JADX INFO: renamed from: c */
    private volatile String f4836c;

    /* JADX INFO: renamed from: d */
    private volatile String f4837d;

    /* JADX INFO: renamed from: e */
    private volatile String f4838e;

    /* JADX INFO: renamed from: f */
    private volatile String f4839f;

    /* JADX INFO: renamed from: g */
    private volatile String f4840g;

    /* JADX INFO: renamed from: h */
    private volatile long f4841h = -1;

    /* JADX INFO: renamed from: i */
    private volatile boolean f4842i = true;

    /* JADX INFO: renamed from: j */
    private String f4843j;

    /* JADX INFO: renamed from: k */
    private Map<String, Object> f4844k;

    /* JADX INFO: renamed from: l */
    private Map<String, String> f4845l;

    /* JADX INFO: renamed from: a */
    public final boolean m5227a() {
        return this.f4842i;
    }

    /* JADX INFO: renamed from: b */
    public final long m5228b() {
        return this.f4841h;
    }

    /* JADX INFO: renamed from: c */
    public final String m5231c() {
        return this.f4840g;
    }

    /* JADX INFO: renamed from: a */
    public final void m5224a(String str) {
        this.f4840g = str;
    }

    public arb() {
        this.f4844k = null;
        this.f4845l = null;
        this.f4844k = new HashMap();
        this.f4845l = new HashMap();
    }

    /* JADX INFO: renamed from: d */
    public final Map<String, String> m5233d() {
        return this.f4845l;
    }

    /* JADX INFO: renamed from: a */
    public final void m5226a(Map<String, String> map) {
        this.f4845l.putAll(map);
    }

    /* JADX INFO: renamed from: a */
    public final void m5225a(String str, Object obj) {
        this.f4844k.put(str, obj);
    }

    /* JADX INFO: renamed from: b */
    public final void m5230b(Map<String, Object> map) {
        this.f4844k.putAll(map);
    }

    /* JADX INFO: renamed from: e */
    public final String m5235e() {
        return this.f4836c;
    }

    /* JADX INFO: renamed from: b */
    public final void m5229b(String str) {
        this.f4836c = str;
    }

    /* JADX INFO: renamed from: f */
    public final String m5237f() {
        return this.f4834a;
    }

    /* JADX INFO: renamed from: c */
    public final void m5232c(String str) {
        this.f4834a = str;
    }

    /* JADX INFO: renamed from: g */
    public final String m5239g() {
        return this.f4835b;
    }

    /* JADX INFO: renamed from: d */
    public final void m5234d(String str) {
        this.f4835b = str;
    }

    /* JADX INFO: renamed from: h */
    public final String m5241h() {
        return this.f4837d;
    }

    /* JADX INFO: renamed from: e */
    public final void m5236e(String str) {
        this.f4837d = str;
    }

    /* JADX INFO: renamed from: i */
    public final String m5242i() {
        return this.f4838e;
    }

    /* JADX INFO: renamed from: j */
    public final Map<String, Object> m5243j() {
        return this.f4844k;
    }

    /* JADX INFO: renamed from: k */
    public final String m5244k() {
        return this.f4839f;
    }

    /* JADX INFO: renamed from: f */
    public final void m5238f(String str) {
        this.f4839f = str;
    }

    /* JADX INFO: renamed from: l */
    public final String m5245l() {
        return this.f4843j;
    }

    /* JADX INFO: renamed from: g */
    public final void m5240g(String str) {
        this.f4843j = str;
    }
}
