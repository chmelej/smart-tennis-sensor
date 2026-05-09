package p000;

import android.support.v4.view.ViewCompat;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: ng */
/* JADX INFO: compiled from: IsoTypeWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1935ng {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f11725a = true;

    /* JADX INFO: renamed from: a */
    public static void m10746a(ByteBuffer byteBuffer, long j) {
        if (!f11725a && j < 0) {
            throw new AssertionError("The given long is negative");
        }
        byteBuffer.putLong(j);
    }

    /* JADX INFO: renamed from: b */
    public static void m10750b(ByteBuffer byteBuffer, long j) {
        if (f11725a || (j >= 0 && j <= 4294967296L)) {
            byteBuffer.putInt((int) j);
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + j + ")");
    }

    /* JADX INFO: renamed from: a */
    public static void m10745a(ByteBuffer byteBuffer, int i) {
        int i2 = i & ViewCompat.MEASURED_SIZE_MASK;
        m10749b(byteBuffer, i2 >> 8);
        m10753c(byteBuffer, i2);
    }

    /* JADX INFO: renamed from: b */
    public static void m10749b(ByteBuffer byteBuffer, int i) {
        int i2 = i & 65535;
        m10753c(byteBuffer, i2 >> 8);
        m10753c(byteBuffer, i2 & 255);
    }

    /* JADX INFO: renamed from: c */
    public static void m10753c(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) (i & 255));
    }

    /* JADX INFO: renamed from: a */
    public static void m10744a(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 65536.0d);
        byteBuffer.put((byte) (((-16777216) & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    /* JADX INFO: renamed from: b */
    public static void m10748b(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 1.073741824E9d);
        byteBuffer.put((byte) (((-16777216) & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    /* JADX INFO: renamed from: c */
    public static void m10752c(ByteBuffer byteBuffer, double d) {
        short s = (short) (d * 256.0d);
        byteBuffer.put((byte) ((65280 & s) >> 8));
        byteBuffer.put((byte) (s & 255));
    }

    /* JADX INFO: renamed from: a */
    public static void m10747a(ByteBuffer byteBuffer, String str) {
        if (str.getBytes().length != 3) {
            throw new IllegalArgumentException("\"" + str + "\" language string isn't exactly 3 characters long!");
        }
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            i += (str.getBytes()[i2] - 96) << ((2 - i2) * 5);
        }
        m10749b(byteBuffer, i);
    }

    /* JADX INFO: renamed from: b */
    public static void m10751b(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(C1936nh.m10755a(str));
        m10753c(byteBuffer, 0);
    }
}
