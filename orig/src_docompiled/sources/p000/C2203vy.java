package p000;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: renamed from: vy */
/* JADX INFO: compiled from: SimpleBufferPool.java */
/* JADX INFO: loaded from: classes.dex */
public class C2203vy {

    /* JADX INFO: renamed from: a */
    private ArrayList<Boolean> f13248a = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    private ArrayList<ByteBuffer> f13249b = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    public void m12064a(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.f13248a.add(false);
            this.f13249b.add(ByteBuffer.allocate(i));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12063a() {
        this.f13248a.clear();
        this.f13249b.clear();
    }

    /* JADX INFO: renamed from: a */
    public ByteBuffer m12062a(int i) {
        if (i < 0 || i >= this.f13248a.size()) {
            return null;
        }
        return this.f13249b.get(i);
    }

    /* JADX INFO: renamed from: b */
    public int m12065b() {
        for (int i = 0; i < this.f13248a.size(); i++) {
            if (!this.f13248a.get(i).booleanValue()) {
                this.f13248a.set(i, true);
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public void m12066b(int i) {
        if (i < 0 || i >= this.f13248a.size()) {
            return;
        }
        this.f13248a.set(i, false);
        this.f13249b.get(i).clear();
    }
}
