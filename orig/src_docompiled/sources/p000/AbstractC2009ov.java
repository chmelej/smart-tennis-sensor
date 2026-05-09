package p000;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: ov */
/* JADX INFO: compiled from: BaseDescriptor.java */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2015pa(m11080a = {0})
public abstract class AbstractC2009ov {

    /* JADX INFO: renamed from: X */
    static final /* synthetic */ boolean f12141X = true;

    /* JADX INFO: renamed from: U */
    int f12142U;

    /* JADX INFO: renamed from: V */
    int f12143V;

    /* JADX INFO: renamed from: W */
    int f12144W;

    /* JADX INFO: renamed from: a */
    public abstract void mo11059a(ByteBuffer byteBuffer);

    /* JADX INFO: renamed from: c */
    public int m11065c() {
        return this.f12143V + 1 + this.f12144W;
    }

    /* JADX INFO: renamed from: d */
    public int m11066d() {
        return this.f12143V;
    }

    /* JADX INFO: renamed from: e */
    public int m11067e() {
        return this.f12144W;
    }

    /* JADX INFO: renamed from: a */
    public final void m11064a(int i, ByteBuffer byteBuffer) {
        this.f12142U = i;
        int iM10737d = C1934nf.m10737d(byteBuffer);
        this.f12143V = iM10737d & 127;
        int i2 = 1;
        while ((iM10737d >>> 7) == 1) {
            iM10737d = C1934nf.m10737d(byteBuffer);
            i2++;
            this.f12143V = (this.f12143V << 7) | (iM10737d & 127);
        }
        this.f12144W = i2;
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit(this.f12143V);
        mo11059a(byteBufferSlice);
        if (f12141X || byteBufferSlice.remaining() == 0) {
            byteBuffer.position(byteBuffer.position() + this.f12143V);
        } else {
            throw new AssertionError(String.valueOf(getClass().getSimpleName()) + " has not been fully parsed");
        }
    }

    public String toString() {
        return "BaseDescriptor{tag=" + this.f12142U + ", sizeOfInstance=" + this.f12143V + '}';
    }
}
