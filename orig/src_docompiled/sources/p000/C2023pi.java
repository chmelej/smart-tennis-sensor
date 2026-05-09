package p000;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* JADX INFO: renamed from: pi */
/* JADX INFO: compiled from: UnknownDescriptor.java */
/* JADX INFO: loaded from: classes.dex */
public class C2023pi extends AbstractC2009ov {

    /* JADX INFO: renamed from: b */
    private static Logger f12185b = Logger.getLogger(C2023pi.class.getName());

    /* JADX INFO: renamed from: a */
    private ByteBuffer f12186a;

    @Override // p000.AbstractC2009ov
    /* JADX INFO: renamed from: a */
    public void mo11059a(ByteBuffer byteBuffer) {
        this.f12186a = (ByteBuffer) byteBuffer.slice().limit(m11066d());
    }

    @Override // p000.AbstractC2009ov
    public String toString() {
        return "UnknownDescriptor{tag=" + this.f12142U + ", sizeOfInstance=" + this.f12143V + ", data=" + this.f12186a + '}';
    }
}
