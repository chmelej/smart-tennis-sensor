package p000;

import java.io.IOException;

/* JADX INFO: compiled from: RouteException.java */
/* JADX INFO: loaded from: classes.dex */
public final class anx extends RuntimeException {

    /* JADX INFO: renamed from: a */
    private IOException f4294a;

    /* JADX INFO: renamed from: b */
    private IOException f4295b;

    public anx(IOException iOException) {
        super(iOException);
        this.f4294a = iOException;
        this.f4295b = iOException;
    }

    /* JADX INFO: renamed from: a */
    public IOException m4577a() {
        return this.f4294a;
    }

    /* JADX INFO: renamed from: b */
    public IOException m4579b() {
        return this.f4295b;
    }

    /* JADX INFO: renamed from: a */
    public void m4578a(IOException iOException) {
        anm.m4507a((Throwable) this.f4294a, (Throwable) iOException);
        this.f4295b = iOException;
    }
}
