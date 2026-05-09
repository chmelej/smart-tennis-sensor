package p000;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: ph */
/* JADX INFO: compiled from: SLConfigDescriptor.java */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2015pa(m11080a = {6})
public class C2022ph extends AbstractC2009ov {

    /* JADX INFO: renamed from: a */
    int f12184a;

    /* JADX INFO: renamed from: a */
    public int m11088a() {
        return 3;
    }

    /* JADX INFO: renamed from: a */
    public void m11089a(int i) {
        this.f12184a = i;
    }

    @Override // p000.AbstractC2009ov
    /* JADX INFO: renamed from: a */
    public void mo11059a(ByteBuffer byteBuffer) {
        this.f12184a = C1934nf.m10737d(byteBuffer);
    }

    /* JADX INFO: renamed from: b */
    public ByteBuffer m11090b() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        C1935ng.m10753c(byteBufferAllocate, 6);
        C1935ng.m10753c(byteBufferAllocate, 1);
        C1935ng.m10753c(byteBufferAllocate, this.f12184a);
        return byteBufferAllocate;
    }

    @Override // p000.AbstractC2009ov
    public String toString() {
        return "SLConfigDescriptor{predefined=" + this.f12184a + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f12184a == ((C2022ph) obj).f12184a;
    }

    public int hashCode() {
        return this.f12184a;
    }
}
