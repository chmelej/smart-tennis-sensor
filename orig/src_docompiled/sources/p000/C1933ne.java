package p000;

import java.io.Closeable;

/* JADX INFO: renamed from: ne */
/* JADX INFO: compiled from: IsoFile.java */
/* JADX INFO: loaded from: classes.dex */
public class C1933ne extends C1986op implements Closeable {

    /* JADX INFO: renamed from: a */
    private static AbstractC2029po f11724a = AbstractC2029po.m11097a(C1933ne.class);

    /* JADX INFO: renamed from: a */
    public static byte[] m10731a(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i = 0; i < Math.min(4, str.length()); i++) {
                bArr[i] = (byte) str.charAt(i);
            }
        }
        return bArr;
    }

    @Override // p000.C1986op, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11966g.close();
    }

    @Override // p000.C1986op
    public String toString() {
        return "model(" + this.f11966g.toString() + ")";
    }
}
