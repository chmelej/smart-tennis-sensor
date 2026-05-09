package p000;

/* JADX INFO: renamed from: yi */
/* JADX INFO: compiled from: IntUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2268yi {
    /* JADX INFO: renamed from: a */
    public static byte[] m12422a(int i) {
        byte[] bArr = {(byte) ((i >> 8) % 256), (byte) (i % 256), (byte) (i % 256), (byte) (i % 256)};
        int i2 = i >> 8;
        int i3 = i2 >> 8;
        return bArr;
    }
}
