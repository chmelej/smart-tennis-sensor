package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class abg implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ String f102a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ Context f103b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ ace f104c;

    abg(String str, Context context, ace aceVar) {
        this.f102a = str;
        this.f103b = context;
        this.f104c = aceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            synchronized (acd.f262o) {
                if (acd.f262o.size() >= acb.m182m()) {
                    acd.f264q.m56d("The number of page events exceeds the maximum value " + Integer.toString(acb.m182m()));
                    return;
                }
                String unused = acd.f260m = this.f102a;
                if (!acd.f262o.containsKey(acd.f260m)) {
                    acd.f262o.put(acd.f260m, Long.valueOf(System.currentTimeMillis()));
                    acd.m194a(this.f103b, true, this.f104c);
                    return;
                }
                acd.f264q.m57e("Duplicate PageID : " + acd.f260m + ", onResume() repeated?");
            }
        } catch (Throwable th) {
            acd.f264q.m54b(th);
            acd.m202a(this.f103b, th);
        }
    }
}
