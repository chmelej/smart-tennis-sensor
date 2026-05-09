package p000;

import java.util.Arrays;

/* JADX INFO: compiled from: Settings.java */
/* JADX INFO: loaded from: classes.dex */
public final class aoz {

    /* JADX INFO: renamed from: a */
    private int f4556a;

    /* JADX INFO: renamed from: b */
    private final int[] f4557b = new int[10];

    /* JADX INFO: renamed from: a */
    void m4805a() {
        this.f4556a = 0;
        Arrays.fill(this.f4557b, 0);
    }

    /* JADX INFO: renamed from: a */
    aoz m4804a(int i, int i2) {
        if (i < 0 || i >= this.f4557b.length) {
            return this;
        }
        this.f4556a = (1 << i) | this.f4556a;
        this.f4557b[i] = i2;
        return this;
    }

    /* JADX INFO: renamed from: a */
    boolean m4807a(int i) {
        return ((1 << i) & this.f4556a) != 0;
    }

    /* JADX INFO: renamed from: b */
    int m4809b(int i) {
        return this.f4557b[i];
    }

    /* JADX INFO: renamed from: b */
    int m4808b() {
        return Integer.bitCount(this.f4556a);
    }

    /* JADX INFO: renamed from: c */
    int m4810c() {
        if ((this.f4556a & 2) != 0) {
            return this.f4557b[1];
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    int m4811c(int i) {
        return (this.f4556a & 16) != 0 ? this.f4557b[4] : i;
    }

    /* JADX INFO: renamed from: d */
    int m4813d(int i) {
        return (this.f4556a & 32) != 0 ? this.f4557b[5] : i;
    }

    /* JADX INFO: renamed from: d */
    int m4812d() {
        if ((this.f4556a & 128) != 0) {
            return this.f4557b[7];
        }
        return 65535;
    }

    /* JADX INFO: renamed from: a */
    void m4806a(aoz aozVar) {
        for (int i = 0; i < 10; i++) {
            if (aozVar.m4807a(i)) {
                m4804a(i, aozVar.m4809b(i));
            }
        }
    }
}
