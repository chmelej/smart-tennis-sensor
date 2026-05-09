package p000;

/* JADX INFO: compiled from: TTransport.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class agi {
    /* JADX INFO: renamed from: a */
    public abstract int mo914a(byte[] bArr, int i, int i2);

    /* JADX INFO: renamed from: a */
    public void mo917a(int i) {
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo915b(byte[] bArr, int i, int i2);

    /* JADX INFO: renamed from: b */
    public byte[] mo919b() {
        return null;
    }

    /* JADX INFO: renamed from: c */
    public int mo920c() {
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public int mo922d() {
        return -1;
    }

    /* JADX INFO: renamed from: d */
    public int m924d(byte[] bArr, int i, int i2) throws agj {
        int i3 = 0;
        while (i3 < i2) {
            int iMo914a = mo914a(bArr, i + i3, i2 - i3);
            if (iMo914a <= 0) {
                throw new agj("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += iMo914a;
        }
        return i3;
    }

    /* JADX INFO: renamed from: b */
    public void m923b(byte[] bArr) {
        mo915b(bArr, 0, bArr.length);
    }
}
