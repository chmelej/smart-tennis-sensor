package p000;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: pg */
/* JADX INFO: compiled from: ProfileLevelIndicationDescriptor.java */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2015pa(m11080a = {20})
public class C2021pg extends AbstractC2009ov {

    /* JADX INFO: renamed from: a */
    int f12183a;

    @Override // p000.AbstractC2009ov
    /* JADX INFO: renamed from: a */
    public void mo11059a(ByteBuffer byteBuffer) {
        this.f12183a = C1934nf.m10737d(byteBuffer);
    }

    @Override // p000.AbstractC2009ov
    public String toString() {
        return "ProfileLevelIndicationDescriptor{profileLevelIndicationIndex=" + Integer.toHexString(this.f12183a) + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f12183a == ((C2021pg) obj).f12183a;
    }

    public int hashCode() {
        return this.f12183a;
    }
}
