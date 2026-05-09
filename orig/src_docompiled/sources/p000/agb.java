package p000;

import java.util.BitSet;

/* JADX INFO: compiled from: TTupleProtocol.java */
/* JADX INFO: loaded from: classes.dex */
public final class agb extends afq {
    @Override // p000.afv
    /* JADX INFO: renamed from: y */
    public Class<? extends agc> mo907y() {
        return agf.class;
    }

    /* JADX INFO: renamed from: a */
    public void m912a(BitSet bitSet, int i) {
        for (byte b : m911b(bitSet, i)) {
            m900a(b);
        }
    }

    /* JADX INFO: renamed from: b */
    public BitSet m913b(int i) {
        int iCeil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[iCeil];
        for (int i2 = 0; i2 < iCeil; i2++) {
            bArr[i2] = mo874q();
        }
        return m910a(bArr);
    }

    /* JADX INFO: renamed from: a */
    public static BitSet m910a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m911b(BitSet bitSet, int i) {
        byte[] bArr = new byte[(int) Math.ceil(((double) i) / 8.0d)];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) ((1 << (i2 % 8)) | bArr[length]);
            }
        }
        return bArr;
    }
}
