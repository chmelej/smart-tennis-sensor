package p000;

/* JADX INFO: compiled from: ShortStack.java */
/* JADX INFO: loaded from: classes.dex */
public class afe {

    /* JADX INFO: renamed from: a */
    private short[] f752a;

    /* JADX INFO: renamed from: b */
    private int f753b = -1;

    public afe(int i) {
        this.f752a = new short[i];
    }

    /* JADX INFO: renamed from: a */
    public short m829a() {
        short[] sArr = this.f752a;
        int i = this.f753b;
        this.f753b = i - 1;
        return sArr[i];
    }

    /* JADX INFO: renamed from: a */
    public void m830a(short s) {
        if (this.f752a.length == this.f753b + 1) {
            m828c();
        }
        short[] sArr = this.f752a;
        int i = this.f753b + 1;
        this.f753b = i;
        sArr[i] = s;
    }

    /* JADX INFO: renamed from: c */
    private void m828c() {
        short[] sArr = new short[this.f752a.length * 2];
        System.arraycopy(this.f752a, 0, sArr, 0, this.f752a.length);
        this.f752a = sArr;
    }

    /* JADX INFO: renamed from: b */
    public void m831b() {
        this.f753b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f752a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.f753b) {
                sb.append(">>");
            }
            sb.append((int) this.f752a[i]);
            if (i == this.f753b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}
