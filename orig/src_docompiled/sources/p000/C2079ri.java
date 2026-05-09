package p000;

/* JADX INFO: renamed from: ri */
/* JADX INFO: compiled from: ImageSize.java */
/* JADX INFO: loaded from: classes.dex */
public class C2079ri {

    /* JADX INFO: renamed from: a */
    private final int f12572a;

    /* JADX INFO: renamed from: b */
    private final int f12573b;

    public C2079ri(int i, int i2) {
        this.f12572a = i;
        this.f12573b = i2;
    }

    public C2079ri(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.f12572a = i;
            this.f12573b = i2;
        } else {
            this.f12572a = i2;
            this.f12573b = i;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m11433a() {
        return this.f12572a;
    }

    /* JADX INFO: renamed from: b */
    public int m11436b() {
        return this.f12573b;
    }

    /* JADX INFO: renamed from: a */
    public C2079ri m11435a(int i) {
        return new C2079ri(this.f12572a / i, this.f12573b / i);
    }

    /* JADX INFO: renamed from: a */
    public C2079ri m11434a(float f) {
        return new C2079ri((int) (this.f12572a * f), (int) (this.f12573b * f));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.f12572a);
        sb.append("x");
        sb.append(this.f12573b);
        return sb.toString();
    }
}
