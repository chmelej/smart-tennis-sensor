package com.qiniu.pili.droid.shortvideo.encode;

import java.nio.ByteBuffer;
import p000.AbstractC2197vs;
import p000.C2150tz;

/* JADX INFO: loaded from: classes.dex */
public class SWAudioEncoder extends AbstractC2197vs {

    /* JADX INFO: renamed from: f */
    private long f9038f = 0;

    /* JADX INFO: renamed from: g */
    private C2150tz f9039g;

    private native boolean nativeClose();

    private native boolean nativeEncode(ByteBuffer byteBuffer, byte[] bArr, int i, long j);

    private native boolean nativeInit();

    private native boolean nativeOpen();

    private native boolean nativeRelease();

    private native boolean nativeSetParam(int i, int i2);

    @Override // p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: b */
    protected String mo8629b() {
        return "SWAudioEncoder";
    }

    @Override // p000.AbstractC2193vo
    /* JADX INFO: renamed from: c */
    public long mo8630c() {
        return 0L;
    }

    public SWAudioEncoder(C2150tz c2150tz) {
        this.f9039g = c2150tz;
    }

    /* JADX INFO: renamed from: m */
    private boolean m8627m() {
        return nativeSetParam(1, this.f9039g.m11744b()) & true & nativeSetParam(2, this.f9039g.m11746c()) & nativeSetParam(3, this.f9039g.m11748d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.AbstractC2197vs
    /* JADX INFO: renamed from: d */
    protected boolean mo8631d() {
        return nativeInit() && m8627m();
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
        return nativeEncode(byteBuffer, bArr, i, j);
    }
}
