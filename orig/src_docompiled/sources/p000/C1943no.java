package p000;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: no */
/* JADX INFO: compiled from: DataReferenceBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1943no extends C1984on implements InterfaceC1949nq {

    /* JADX INFO: renamed from: a */
    private int f11728a;

    /* JADX INFO: renamed from: b */
    private int f11729b;

    public C1943no() {
        super("dref");
    }

    @Override // p000.C1984on, p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public void mo1639a(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(m10902i());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        C1935ng.m10753c(byteBufferAllocate, this.f11728a);
        C1935ng.m10745a(byteBufferAllocate, this.f11729b);
        C1935ng.m10750b(byteBufferAllocate, m10912j().size());
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        m10911b(writableByteChannel);
    }

    @Override // p000.C1984on, p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public long mo1637a() {
        long jK = m10913k() + 8;
        return jK + ((long) ((this.f11957e || jK + 8 >= 4294967296L) ? 16 : 8));
    }
}
