package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class acj implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Context f286a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f287b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ ace f288c;

    acj(Context context, String str, ace aceVar) {
        this.f286a = context;
        this.f287b = str;
        this.f288c = aceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Long l;
        try {
            acd.m215e(this.f286a);
            synchronized (acd.f262o) {
                l = (Long) acd.f262o.remove(this.f287b);
            }
            if (l == null) {
                acd.f264q.m57e("Starttime for PageID:" + this.f287b + " not found, lost onResume()?");
                return;
            }
            Long lValueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
            if (lValueOf.longValue() <= 0) {
                lValueOf = 1L;
            }
            Long l2 = lValueOf;
            String str = acd.f261n;
            if (str != null && str.equals(this.f287b)) {
                str = "-";
            }
            aam aamVar = new aam(this.f286a, str, this.f287b, acd.m194a(this.f286a, false, this.f288c), l2, this.f288c);
            if (!this.f287b.equals(acd.f260m)) {
                acd.f264q.m53b("Invalid invocation since previous onResume on diff page.");
            }
            new aco(aamVar).m254a();
            String unused = acd.f261n = this.f287b;
        } catch (Throwable th) {
            acd.f264q.m54b(th);
            acd.m202a(this.f286a, th);
        }
    }
}
