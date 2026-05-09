package p000;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: on */
/* JADX INFO: compiled from: AbstractContainerBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1984on extends C1986op implements InterfaceC1938nj {

    /* JADX INFO: renamed from: c */
    InterfaceC1940nl f11955c;

    /* JADX INFO: renamed from: d */
    protected String f11956d;

    /* JADX INFO: renamed from: e */
    protected boolean f11957e;

    public C1984on(String str) {
        this.f11956d = str;
    }

    @Override // p000.InterfaceC1938nj
    /* JADX INFO: renamed from: a */
    public void mo1640a(InterfaceC1940nl interfaceC1940nl) {
        this.f11955c = interfaceC1940nl;
    }

    /* JADX INFO: renamed from: a */
    public long mo1637a() {
        long jK = m10913k();
        return jK + ((long) ((this.f11957e || jK + 8 >= 4294967296L) ? 16 : 8));
    }

    /* JADX INFO: renamed from: i */
    protected ByteBuffer m10902i() {
        ByteBuffer byteBufferWrap;
        if (this.f11957e || mo1637a() >= 4294967296L) {
            byte[] bArr = new byte[16];
            bArr[3] = 1;
            bArr[4] = this.f11956d.getBytes()[0];
            bArr[5] = this.f11956d.getBytes()[1];
            bArr[6] = this.f11956d.getBytes()[2];
            bArr[7] = this.f11956d.getBytes()[3];
            byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.position(8);
            C1935ng.m10746a(byteBufferWrap, mo1637a());
        } else {
            byteBufferWrap = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, this.f11956d.getBytes()[0], this.f11956d.getBytes()[1], this.f11956d.getBytes()[2], this.f11956d.getBytes()[3]});
            C1935ng.m10750b(byteBufferWrap, mo1637a());
        }
        byteBufferWrap.rewind();
        return byteBufferWrap;
    }

    /* JADX INFO: renamed from: a */
    public void mo1639a(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(m10902i());
        m10911b(writableByteChannel);
    }
}
