package p000;

/* JADX INFO: compiled from: TMemoryInputTransport.java */
/* JADX INFO: loaded from: classes.dex */
public final class agh extends agi {

    /* JADX INFO: renamed from: a */
    private byte[] f817a;

    /* JADX INFO: renamed from: b */
    private int f818b;

    /* JADX INFO: renamed from: c */
    private int f819c;

    /* JADX INFO: renamed from: a */
    public void m918a(byte[] bArr) {
        m921c(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: c */
    public void m921c(byte[] bArr, int i, int i2) {
        this.f817a = bArr;
        this.f818b = i;
        this.f819c = i + i2;
    }

    /* JADX INFO: renamed from: a */
    public void m916a() {
        this.f817a = null;
    }

    @Override // p000.agi
    /* JADX INFO: renamed from: a */
    public int mo914a(byte[] bArr, int i, int i2) {
        int iMo922d = mo922d();
        if (i2 > iMo922d) {
            i2 = iMo922d;
        }
        if (i2 > 0) {
            System.arraycopy(this.f817a, this.f818b, bArr, i, i2);
            mo917a(i2);
        }
        return i2;
    }

    @Override // p000.agi
    /* JADX INFO: renamed from: b */
    public void mo915b(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // p000.agi
    /* JADX INFO: renamed from: b */
    public byte[] mo919b() {
        return this.f817a;
    }

    @Override // p000.agi
    /* JADX INFO: renamed from: c */
    public int mo920c() {
        return this.f818b;
    }

    @Override // p000.agi
    /* JADX INFO: renamed from: d */
    public int mo922d() {
        return this.f819c - this.f818b;
    }

    @Override // p000.agi
    /* JADX INFO: renamed from: a */
    public void mo917a(int i) {
        this.f818b += i;
    }
}
