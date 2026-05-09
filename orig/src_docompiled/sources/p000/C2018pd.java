package p000;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: pd */
/* JADX INFO: compiled from: ExtensionProfileLevelDescriptor.java */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2015pa(m11080a = {19})
public class C2018pd extends AbstractC2009ov {

    /* JADX INFO: renamed from: a */
    byte[] f12180a;

    @Override // p000.AbstractC2009ov
    /* JADX INFO: renamed from: a */
    public void mo11059a(ByteBuffer byteBuffer) {
        if (m11065c() > 0) {
            this.f12180a = new byte[m11065c()];
            byteBuffer.get(this.f12180a);
        }
    }

    @Override // p000.AbstractC2009ov
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=");
        sb.append(this.f12180a == null ? "null" : C1932nd.m10729a(this.f12180a));
        sb.append('}');
        return sb.toString();
    }
}
