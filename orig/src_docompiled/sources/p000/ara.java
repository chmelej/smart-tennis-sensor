package p000;

import android.content.Context;

/* JADX INFO: compiled from: MtopAsyncClientV3.java */
/* JADX INFO: loaded from: classes.dex */
public class ara extends aqd implements aqy {

    /* JADX INFO: renamed from: a */
    private String f4831a;

    /* JADX INFO: renamed from: b */
    private String f4832b;

    /* JADX INFO: renamed from: c */
    private String f4833c;

    @Override // p000.aqy
    /* JADX INFO: renamed from: a */
    public final void mo5182a(String str) {
        this.f4831a = str;
    }

    @Override // p000.aqy
    /* JADX INFO: renamed from: b */
    public final void mo5183b(String str) {
        this.f4832b = str;
    }

    @Override // p000.aqy
    /* JADX INFO: renamed from: a */
    public final void mo5181a(Context context, arb arbVar, ard ardVar) {
        try {
            arc.m5250a(arbVar, this.f4831a, this.f4832b);
            m4994a(context, this.f4833c, arc.m5247a(context, arbVar), ardVar);
        } catch (Throwable th) {
            aiv.m1421d("MtopAsyncClientV3", "getV3", th);
            ardVar.onFailure(th, null, null);
        }
    }

    @Override // p000.aqy
    /* JADX INFO: renamed from: c */
    public final void mo5184c(String str) {
        this.f4833c = str;
    }
}
