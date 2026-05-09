package p000;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: Mp4Movie.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
public class aju {

    /* JADX INFO: renamed from: a */
    private C2030pp f1369a = C2030pp.f12194j;

    /* JADX INFO: renamed from: b */
    private ArrayList<ajy> f1370b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    private File f1371c;

    /* JADX INFO: renamed from: d */
    private int f1372d;

    /* JADX INFO: renamed from: e */
    private int f1373e;

    /* JADX INFO: renamed from: a */
    public C2030pp m1645a() {
        return this.f1369a;
    }

    /* JADX INFO: renamed from: a */
    public void m1649a(File file) {
        this.f1371c = file;
    }

    /* JADX INFO: renamed from: a */
    public void m1646a(int i) {
        if (i == 0) {
            this.f1369a = C2030pp.f12194j;
            return;
        }
        if (i == 90) {
            this.f1369a = C2030pp.f12195k;
        } else if (i == 180) {
            this.f1369a = C2030pp.f12196l;
        } else if (i == 270) {
            this.f1369a = C2030pp.f12197m;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1647a(int i, int i2) {
        this.f1372d = i;
        this.f1373e = i2;
    }

    /* JADX INFO: renamed from: b */
    public ArrayList<ajy> m1650b() {
        return this.f1370b;
    }

    /* JADX INFO: renamed from: c */
    public File m1651c() {
        return this.f1371c;
    }

    /* JADX INFO: renamed from: a */
    public void m1648a(int i, long j, MediaCodec.BufferInfo bufferInfo) {
        if (i < 0 || i >= this.f1370b.size()) {
            return;
        }
        this.f1370b.get(i).m1670a(j, bufferInfo);
    }

    /* JADX INFO: renamed from: a */
    public int m1644a(MediaFormat mediaFormat, boolean z) {
        this.f1370b.add(new ajy(this.f1370b.size(), mediaFormat, z));
        return this.f1370b.size() - 1;
    }
}
