package p000;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import p000.C2253xu;

/* JADX INFO: renamed from: xb */
/* JADX INFO: compiled from: Action.java */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC2234xb<T> {

    /* JADX INFO: renamed from: a */
    final C2253xu f13446a;

    /* JADX INFO: renamed from: b */
    final C2256xx f13447b;

    /* JADX INFO: renamed from: c */
    final WeakReference<T> f13448c;

    /* JADX INFO: renamed from: d */
    final boolean f13449d;

    /* JADX INFO: renamed from: e */
    final int f13450e;

    /* JADX INFO: renamed from: f */
    final int f13451f;

    /* JADX INFO: renamed from: g */
    final int f13452g;

    /* JADX INFO: renamed from: h */
    final Drawable f13453h;

    /* JADX INFO: renamed from: i */
    final String f13454i;

    /* JADX INFO: renamed from: j */
    final Object f13455j;

    /* JADX INFO: renamed from: k */
    boolean f13456k;

    /* JADX INFO: renamed from: l */
    boolean f13457l;

    /* JADX INFO: renamed from: a */
    abstract void mo12209a();

    /* JADX INFO: renamed from: a */
    abstract void mo12210a(Bitmap bitmap, C2253xu.d dVar);

    /* JADX INFO: renamed from: xb$a */
    /* JADX INFO: compiled from: Action.java */
    static class a<M> extends WeakReference<M> {

        /* JADX INFO: renamed from: a */
        final AbstractC2234xb f13458a;

        public a(AbstractC2234xb abstractC2234xb, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f13458a = abstractC2234xb;
        }
    }

    AbstractC2234xb(C2253xu c2253xu, T t, C2256xx c2256xx, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f13446a = c2253xu;
        this.f13447b = c2256xx;
        this.f13448c = t == null ? null : new a(this, t, c2253xu.f13563i);
        this.f13450e = i;
        this.f13451f = i2;
        this.f13449d = z;
        this.f13452g = i3;
        this.f13453h = drawable;
        this.f13454i = str;
        this.f13455j = obj == null ? this : obj;
    }

    /* JADX INFO: renamed from: b */
    void mo12211b() {
        this.f13457l = true;
    }

    /* JADX INFO: renamed from: c */
    C2256xx m12212c() {
        return this.f13447b;
    }

    /* JADX INFO: renamed from: d */
    T m12213d() {
        if (this.f13448c == null) {
            return null;
        }
        return this.f13448c.get();
    }

    /* JADX INFO: renamed from: e */
    String m12214e() {
        return this.f13454i;
    }

    /* JADX INFO: renamed from: f */
    boolean m12215f() {
        return this.f13457l;
    }

    /* JADX INFO: renamed from: g */
    boolean m12216g() {
        return this.f13456k;
    }

    /* JADX INFO: renamed from: h */
    int m12217h() {
        return this.f13450e;
    }

    /* JADX INFO: renamed from: i */
    int m12218i() {
        return this.f13451f;
    }

    /* JADX INFO: renamed from: j */
    C2253xu m12219j() {
        return this.f13446a;
    }

    /* JADX INFO: renamed from: k */
    C2253xu.e m12220k() {
        return this.f13447b.f13623r;
    }

    /* JADX INFO: renamed from: l */
    Object m12221l() {
        return this.f13455j;
    }
}
