package p000;

import android.content.Context;

/* JADX INFO: compiled from: CacheService.java */
/* JADX INFO: loaded from: classes.dex */
public final class adt implements adw {

    /* JADX INFO: renamed from: c */
    private static adt f477c;

    /* JADX INFO: renamed from: a */
    private adw f478a;

    /* JADX INFO: renamed from: b */
    private Context f479b;

    private adt(Context context) {
        this.f479b = context;
        this.f478a = new ads(this.f479b);
    }

    /* JADX INFO: renamed from: a */
    public synchronized ads m436a(Context context) {
        return (ads) this.f478a;
    }

    /* JADX INFO: renamed from: b */
    public static synchronized adt m435b(Context context) {
        if (f477c == null && context != null) {
            f477c = new adt(context);
        }
        return f477c;
    }

    @Override // p000.adw
    /* JADX INFO: renamed from: a */
    public void mo427a(final Object obj) {
        aey.m781b(new afa() { // from class: adt.1
            @Override // p000.afa
            /* JADX INFO: renamed from: a */
            public void mo314a() {
                adt.this.f478a.mo427a(obj);
            }
        });
    }

    @Override // p000.adw
    /* JADX INFO: renamed from: a */
    public void mo424a() {
        aey.m781b(new afa() { // from class: adt.2
            @Override // p000.afa
            /* JADX INFO: renamed from: a */
            public void mo314a() {
                adt.this.f478a.mo424a();
            }
        });
    }

    @Override // p000.adw
    /* JADX INFO: renamed from: b */
    public void mo429b() {
        aey.m782c(new afa() { // from class: adt.3
            @Override // p000.afa
            /* JADX INFO: renamed from: a */
            public void mo314a() {
                adt.this.f478a.mo429b();
            }
        });
    }
}
