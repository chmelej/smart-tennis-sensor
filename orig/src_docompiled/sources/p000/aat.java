package p000;

import android.content.Context;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
public class aat {

    /* JADX INFO: renamed from: b */
    private static volatile aat f72b;

    /* JADX INFO: renamed from: a */
    private Timer f73a;

    /* JADX INFO: renamed from: c */
    private Context f74c;

    private aat(Context context) {
        this.f73a = null;
        this.f74c = null;
        this.f74c = context.getApplicationContext();
        this.f73a = new Timer(false);
    }

    /* JADX INFO: renamed from: a */
    public static aat m33a(Context context) {
        if (f72b == null) {
            synchronized (aat.class) {
                if (f72b == null) {
                    f72b = new aat(context);
                }
            }
        }
        return f72b;
    }

    /* JADX INFO: renamed from: a */
    public final void m35a() {
        if (acb.m151a() == acc.PERIOD) {
            long jM181l = acb.m181l() * 60 * 1000;
            if (acb.m166b()) {
                abt.m89c().m51a("setupPeriodTimer delay:" + jM181l);
            }
            aau aauVar = new aau(this);
            if (this.f73a == null) {
                if (acb.m166b()) {
                    abt.m89c().m55c("setupPeriodTimer schedule timer == null");
                }
            } else {
                if (acb.m166b()) {
                    abt.m89c().m51a("setupPeriodTimer schedule delay:" + jM181l);
                }
                this.f73a.schedule(aauVar, jM181l);
            }
        }
    }
}
