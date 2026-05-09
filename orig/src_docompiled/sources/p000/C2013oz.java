package p000;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: oz */
/* JADX INFO: compiled from: DecoderSpecificInfo.java */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2015pa(m11080a = {5})
public class C2013oz extends AbstractC2009ov {

    /* JADX INFO: renamed from: a */
    byte[] f12163a;

    @Override // p000.AbstractC2009ov
    /* JADX INFO: renamed from: a */
    public void mo11059a(ByteBuffer byteBuffer) {
        if (this.f12143V > 0) {
            this.f12163a = new byte[this.f12143V];
            byteBuffer.get(this.f12163a);
        }
    }

    @Override // p000.AbstractC2009ov
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderSpecificInfo");
        sb.append("{bytes=");
        sb.append(this.f12163a == null ? "null" : C1932nd.m10729a(this.f12163a));
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.f12163a, ((C2013oz) obj).f12163a);
    }

    public int hashCode() {
        if (this.f12163a != null) {
            return Arrays.hashCode(this.f12163a);
        }
        return 0;
    }
}
