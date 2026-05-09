package p000;

import javax.annotation.Nullable;
import okio.BufferedSource;

/* JADX INFO: compiled from: RealResponseBody.java */
/* JADX INFO: loaded from: classes.dex */
public final class aoh extends anh {

    /* JADX INFO: renamed from: a */
    @Nullable
    private final String f4341a;

    /* JADX INFO: renamed from: b */
    private final long f4342b;

    /* JADX INFO: renamed from: c */
    private final BufferedSource f4343c;

    public aoh(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.f4341a = str;
        this.f4342b = j;
        this.f4343c = bufferedSource;
    }

    @Override // p000.anh
    /* JADX INFO: renamed from: a */
    public ana mo4479a() {
        if (this.f4341a != null) {
            return ana.m2123b(this.f4341a);
        }
        return null;
    }

    @Override // p000.anh
    /* JADX INFO: renamed from: b */
    public long mo4480b() {
        return this.f4342b;
    }

    @Override // p000.anh
    /* JADX INFO: renamed from: c */
    public BufferedSource mo4481c() {
        return this.f4343c;
    }
}
