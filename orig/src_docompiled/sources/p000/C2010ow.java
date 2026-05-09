package p000;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: ow */
/* JADX INFO: compiled from: BitReaderBuffer.java */
/* JADX INFO: loaded from: classes.dex */
public class C2010ow {

    /* JADX INFO: renamed from: a */
    int f12145a;

    /* JADX INFO: renamed from: b */
    int f12146b;

    /* JADX INFO: renamed from: c */
    private ByteBuffer f12147c;

    public C2010ow(ByteBuffer byteBuffer) {
        this.f12147c = byteBuffer;
        this.f12145a = byteBuffer.position();
    }

    /* JADX INFO: renamed from: a */
    public boolean m11069a() {
        return m11068a(1) == 1;
    }

    /* JADX INFO: renamed from: a */
    public int m11068a(int i) {
        int iM11068a;
        int i2 = this.f12147c.get(this.f12145a + (this.f12146b / 8));
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = 8 - (this.f12146b % 8);
        if (i <= i3) {
            iM11068a = ((i2 << (this.f12146b % 8)) & 255) >> ((this.f12146b % 8) + (i3 - i));
            this.f12146b += i;
        } else {
            int i4 = i - i3;
            iM11068a = (m11068a(i3) << i4) + m11068a(i4);
        }
        this.f12147c.position(this.f12145a + ((int) Math.ceil(((double) this.f12146b) / 8.0d)));
        return iM11068a;
    }

    /* JADX INFO: renamed from: b */
    public int m11070b() {
        return (this.f12147c.limit() * 8) - this.f12146b;
    }
}
