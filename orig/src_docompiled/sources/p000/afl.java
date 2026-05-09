package p000;

import java.io.Serializable;

/* JADX INFO: compiled from: FieldValueMetaData.java */
/* JADX INFO: loaded from: classes.dex */
public class afl implements Serializable {

    /* JADX INFO: renamed from: a */
    public final byte f764a;

    /* JADX INFO: renamed from: b */
    private final boolean f765b;

    /* JADX INFO: renamed from: c */
    private final String f766c;

    /* JADX INFO: renamed from: d */
    private final boolean f767d;

    public afl(byte b, boolean z) {
        this.f764a = b;
        this.f765b = false;
        this.f766c = null;
        this.f767d = z;
    }

    public afl(byte b) {
        this(b, false);
    }
}
