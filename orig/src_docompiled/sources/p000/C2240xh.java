package p000;

import android.content.Context;
import java.io.InputStream;
import p000.AbstractC2258xz;
import p000.C2253xu;

/* JADX INFO: renamed from: xh */
/* JADX INFO: compiled from: ContentStreamRequestHandler.java */
/* JADX INFO: loaded from: classes.dex */
class C2240xh extends AbstractC2258xz {

    /* JADX INFO: renamed from: a */
    final Context f13492a;

    C2240xh(Context context) {
        this.f13492a = context;
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public boolean mo12224a(C2256xx c2256xx) {
        return "content".equals(c2256xx.f13609d.getScheme());
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public AbstractC2258xz.a mo12223a(C2256xx c2256xx, int i) {
        return new AbstractC2258xz.a(m12258b(c2256xx), C2253xu.d.DISK);
    }

    /* JADX INFO: renamed from: b */
    InputStream m12258b(C2256xx c2256xx) {
        return this.f13492a.getContentResolver().openInputStream(c2256xx.f13609d);
    }
}
