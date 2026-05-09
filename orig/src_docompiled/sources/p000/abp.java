package p000;

/* JADX INFO: loaded from: classes.dex */
public class abp {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f147a = true;

    private abp() {
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m72a(byte[] bArr) {
        int length = bArr.length;
        abr abrVar = new abr(new byte[(length * 3) / 4]);
        if (!abrVar.m74a(bArr, length)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (abrVar.f149b == abrVar.f148a.length) {
            return abrVar.f148a;
        }
        byte[] bArr2 = new byte[abrVar.f149b];
        System.arraycopy(abrVar.f148a, 0, bArr2, 0, abrVar.f149b);
        return bArr2;
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m73b(byte[] bArr) {
        int length = bArr.length;
        abs absVar = new abs();
        int i = (length / 3) * 4;
        if (!absVar.f159d) {
            switch (length % 3) {
                case 1:
                    i += 2;
                    break;
                case 2:
                    i += 3;
                    break;
            }
        } else if (length % 3 > 0) {
            i += 4;
        }
        if (absVar.f160e && length > 0) {
            i += (((length - 1) / 57) + 1) * (absVar.f161f ? 2 : 1);
        }
        absVar.f148a = new byte[i];
        absVar.m75a(bArr, length);
        if (f147a || absVar.f149b == i) {
            return absVar.f148a;
        }
        throw new AssertionError();
    }
}
