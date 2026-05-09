package p000;

import android.support.v4.view.InputDeviceCompat;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: ox */
/* JADX INFO: compiled from: BitWriterBuffer.java */
/* JADX INFO: loaded from: classes.dex */
public class C2011ox {

    /* JADX INFO: renamed from: c */
    static final /* synthetic */ boolean f12148c = true;

    /* JADX INFO: renamed from: a */
    int f12149a;

    /* JADX INFO: renamed from: b */
    int f12150b = 0;

    /* JADX INFO: renamed from: d */
    private ByteBuffer f12151d;

    public C2011ox(ByteBuffer byteBuffer) {
        this.f12151d = byteBuffer;
        this.f12149a = byteBuffer.position();
    }

    /* JADX INFO: renamed from: a */
    public void m11071a(int i, int i2) {
        int i3;
        if (!f12148c && i > (i3 = (1 << i2) - 1)) {
            throw new AssertionError(String.format("Trying to write a value bigger (%s) than the number bits (%s) allows. Please mask the value before writing it and make your code is really working as intended.", Integer.valueOf(i), Integer.valueOf(i3)));
        }
        int i4 = 8 - (this.f12150b % 8);
        if (i2 <= i4) {
            int i5 = this.f12151d.get(this.f12149a + (this.f12150b / 8));
            if (i5 < 0) {
                i5 += 256;
            }
            int i6 = i5 + (i << (i4 - i2));
            ByteBuffer byteBuffer = this.f12151d;
            int i7 = this.f12149a + (this.f12150b / 8);
            if (i6 > 127) {
                i6 += InputDeviceCompat.SOURCE_ANY;
            }
            byteBuffer.put(i7, (byte) i6);
            this.f12150b += i2;
        } else {
            int i8 = i2 - i4;
            m11071a(i >> i8, i4);
            m11071a(i & ((1 << i8) - 1), i8);
        }
        this.f12151d.position(this.f12149a + (this.f12150b / 8) + (this.f12150b % 8 > 0 ? 1 : 0));
    }
}
