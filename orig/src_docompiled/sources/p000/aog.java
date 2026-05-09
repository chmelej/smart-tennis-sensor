package p000;

import java.util.List;
import p000.amz;

/* JADX INFO: compiled from: RealInterceptorChain.java */
/* JADX INFO: loaded from: classes.dex */
public final class aog implements amz.InterfaceC0211a {

    /* JADX INFO: renamed from: a */
    private final List<amz> f4329a;

    /* JADX INFO: renamed from: b */
    private final anz f4330b;

    /* JADX INFO: renamed from: c */
    private final aoc f4331c;

    /* JADX INFO: renamed from: d */
    private final anv f4332d;

    /* JADX INFO: renamed from: e */
    private final int f4333e;

    /* JADX INFO: renamed from: f */
    private final ane f4334f;

    /* JADX INFO: renamed from: g */
    private final amj f4335g;

    /* JADX INFO: renamed from: h */
    private final amv f4336h;

    /* JADX INFO: renamed from: i */
    private final int f4337i;

    /* JADX INFO: renamed from: j */
    private final int f4338j;

    /* JADX INFO: renamed from: k */
    private final int f4339k;

    /* JADX INFO: renamed from: l */
    private int f4340l;

    public aog(List<amz> list, anz anzVar, aoc aocVar, anv anvVar, int i, ane aneVar, amj amjVar, amv amvVar, int i2, int i3, int i4) {
        this.f4329a = list;
        this.f4332d = anvVar;
        this.f4330b = anzVar;
        this.f4331c = aocVar;
        this.f4333e = i;
        this.f4334f = aneVar;
        this.f4335g = amjVar;
        this.f4336h = amvVar;
        this.f4337i = i2;
        this.f4338j = i3;
        this.f4339k = i4;
    }

    @Override // p000.amz.InterfaceC0211a
    /* JADX INFO: renamed from: b */
    public amn mo2117b() {
        return this.f4332d;
    }

    @Override // p000.amz.InterfaceC0211a
    /* JADX INFO: renamed from: c */
    public int mo2118c() {
        return this.f4337i;
    }

    @Override // p000.amz.InterfaceC0211a
    /* JADX INFO: renamed from: d */
    public int mo2119d() {
        return this.f4338j;
    }

    @Override // p000.amz.InterfaceC0211a
    /* JADX INFO: renamed from: e */
    public int mo2120e() {
        return this.f4339k;
    }

    /* JADX INFO: renamed from: f */
    public anz m4632f() {
        return this.f4330b;
    }

    /* JADX INFO: renamed from: g */
    public aoc m4633g() {
        return this.f4331c;
    }

    /* JADX INFO: renamed from: h */
    public amj m4634h() {
        return this.f4335g;
    }

    /* JADX INFO: renamed from: i */
    public amv m4635i() {
        return this.f4336h;
    }

    @Override // p000.amz.InterfaceC0211a
    /* JADX INFO: renamed from: a */
    public ane mo2115a() {
        return this.f4334f;
    }

    @Override // p000.amz.InterfaceC0211a
    /* JADX INFO: renamed from: a */
    public ang mo2116a(ane aneVar) {
        return m4631a(aneVar, this.f4330b, this.f4331c, this.f4332d);
    }

    /* JADX INFO: renamed from: a */
    public ang m4631a(ane aneVar, anz anzVar, aoc aocVar, anv anvVar) {
        if (this.f4333e >= this.f4329a.size()) {
            throw new AssertionError();
        }
        this.f4340l++;
        if (this.f4331c != null && !this.f4332d.m4569a(aneVar.m4419a())) {
            throw new IllegalStateException("network interceptor " + this.f4329a.get(this.f4333e - 1) + " must retain the same host and port");
        }
        if (this.f4331c != null && this.f4340l > 1) {
            throw new IllegalStateException("network interceptor " + this.f4329a.get(this.f4333e - 1) + " must call proceed() exactly once");
        }
        aog aogVar = new aog(this.f4329a, anzVar, aocVar, anvVar, this.f4333e + 1, aneVar, this.f4335g, this.f4336h, this.f4337i, this.f4338j, this.f4339k);
        amz amzVar = this.f4329a.get(this.f4333e);
        ang angVarMo2114a = amzVar.mo2114a(aogVar);
        if (aocVar != null && this.f4333e + 1 < this.f4329a.size() && aogVar.f4340l != 1) {
            throw new IllegalStateException("network interceptor " + amzVar + " must call proceed() exactly once");
        }
        if (angVarMo2114a == null) {
            throw new NullPointerException("interceptor " + amzVar + " returned null");
        }
        if (angVarMo2114a.m4455f() != null) {
            return angVarMo2114a;
        }
        throw new IllegalStateException("interceptor " + amzVar + " returned a response with no body");
    }
}
