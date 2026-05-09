package com.qiniu.pili.droid.shortvideo.encode;

import java.nio.ByteBuffer;
import p000.AbstractC2197vs;
import p000.C2169ur;

/* JADX INFO: loaded from: classes.dex */
public class SWVideoEncoder extends AbstractC2197vs {

    /* JADX INFO: renamed from: f */
    private long f9040f = 0;

    /* JADX INFO: renamed from: g */
    private C2169ur f9041g;

    private native boolean nativeClose();

    private native boolean nativeEncode(ByteBuffer byteBuffer, byte[] bArr, int i, long j);

    private native boolean nativeInit();

    private native boolean nativeOpen();

    private native boolean nativeRelease();

    private native boolean nativeSetParam(int i, int i2);

    @Override // p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: b */
    protected String mo8629b() {
        return "SWVideoEncoder";
    }

    public SWVideoEncoder(C2169ur c2169ur) {
        this.f9041g = c2169ur;
    }

    /* JADX INFO: renamed from: m */
    private boolean m8635m() {
        return nativeSetParam(1, this.f9041g.m11822a()) & true & nativeSetParam(2, this.f9041g.m11828b()) & nativeSetParam(3, (int) (((double) this.f9041g.m11832d()) * this.f13169a)) & nativeSetParam(5, (int) (((double) this.f9041g.m11830c()) * this.f13169a)) & nativeSetParam(4, (int) (((double) this.f9041g.m11834f()) * this.f13169a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.AbstractC2197vs
    /* JADX INFO: renamed from: d */
    protected boolean mo8631d() {
        return nativeInit() && m8635m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.AbstractC2197vs
    /* JADX INFO: renamed from: e */
    protected boolean mo8632e() {
        return nativeRelease();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.AbstractC2197vs
    /* JADX INFO: renamed from: f */
    protected boolean mo8633f() {
        return nativeOpen();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.AbstractC2197vs
    /* JADX INFO: renamed from: g */
    protected boolean mo8634g() {
        return nativeClose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.AbstractC2197vs
    /* JADX INFO: renamed from: a */
    protected boolean mo8628a(ByteBuffer byteBuffer, byte[] bArr, int i, long j) {
        return nativeEncode(byteBuffer, bArr, i, j / 1000);
    }
}
