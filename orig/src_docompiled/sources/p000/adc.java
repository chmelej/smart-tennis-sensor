package p000;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.umeng.message.MsgConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: InternalAgent.java */
/* JADX INFO: loaded from: classes.dex */
public class adc implements adz {

    /* JADX INFO: renamed from: a */
    private Context f368a;

    /* JADX INFO: renamed from: b */
    private aew f369b;

    /* JADX INFO: renamed from: c */
    private adu f370c;

    /* JADX INFO: renamed from: d */
    private aeg f371d;

    /* JADX INFO: renamed from: e */
    private aee f372e;

    /* JADX INFO: renamed from: f */
    private adv f373f;

    /* JADX INFO: renamed from: g */
    private Object f374g;

    /* JADX INFO: renamed from: h */
    private adt f375h;

    /* JADX INFO: renamed from: i */
    private adr f376i;

    /* JADX INFO: renamed from: j */
    private boolean f377j;

    /* JADX INFO: renamed from: k */
    private JSONObject f378k;

    /* JADX INFO: renamed from: l */
    private boolean f379l;

    private adc() {
        this.f368a = null;
        this.f370c = new adu();
        this.f371d = new aeg();
        this.f372e = new aee();
        this.f373f = null;
        this.f374g = new Object();
        this.f375h = null;
        this.f376i = null;
        this.f377j = false;
        this.f378k = null;
        this.f379l = false;
        this.f370c.m438a(this);
    }

    /* JADX INFO: renamed from: adc$a */
    /* JADX INFO: compiled from: InternalAgent.java */
    static class C0011a {

        /* JADX INFO: renamed from: a */
        private static final adc f386a = new adc();
    }

    /* JADX INFO: renamed from: a */
    public static adc m304a() {
        return C0011a.f386a;
    }

    /* JADX INFO: renamed from: c */
    private synchronized void m308c(final Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT > 13 && !this.f379l) {
                this.f379l = true;
                aey.m781b(new afa() { // from class: adc.1
                    @Override // p000.afa
                    /* JADX INFO: renamed from: a */
                    public void mo314a() {
                        if (context instanceof Activity) {
                            adc.this.f376i = new adr((Activity) context);
                        }
                    }
                });
            }
            if (!this.f377j) {
                this.f368a = context.getApplicationContext();
                this.f377j = true;
                if (this.f373f == null) {
                    synchronized (this.f374g) {
                        this.f373f = new adv(this.f368a);
                    }
                }
                this.f375h = adt.m435b(this.f368a);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    void m311a(final Context context) {
        try {
            if (context == null) {
                aex.m776c("unexpected null context in onResume");
                return;
            }
            if (acz.f341e && this.f371d != null) {
                this.f371d.m497a(context.getClass().getName());
            }
            if (!this.f377j || !this.f379l) {
                m308c(context);
            }
            aey.m779a(new afa() { // from class: adc.2
                @Override // p000.afa
                /* JADX INFO: renamed from: a */
                public void mo314a() {
                    adc.this.m309d(context.getApplicationContext());
                }
            });
        } catch (Throwable th) {
            aex.m770a("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    /* JADX INFO: renamed from: b */
    void m313b(final Context context) {
        try {
            if (context == null) {
                aex.m776c("unexpected null context in onPause");
                return;
            }
            if (acz.f341e && this.f371d != null) {
                this.f371d.m498b(context.getClass().getName());
            }
            if (!this.f377j || !this.f379l) {
                m308c(context);
            }
            aey.m779a(new afa() { // from class: adc.3
                @Override // p000.afa
                /* JADX INFO: renamed from: a */
                public void mo314a() {
                    adc.this.m310e(context.getApplicationContext());
                }
            });
        } catch (Throwable th) {
            if (aex.f711a) {
                aex.m770a("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m309d(Context context) {
        try {
            if (this.f368a == null && context != null) {
                this.f368a = context.getApplicationContext();
            }
            if (this.f372e != null) {
                this.f372e.m482c(this.f368a == null ? context.getApplicationContext() : this.f368a);
            }
            if (this.f369b != null) {
                this.f369b.m765a();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m310e(Context context) {
        try {
            if (this.f368a == null && context != null) {
                this.f368a = context.getApplicationContext();
            }
            if (this.f368a != null) {
                if (this.f372e != null) {
                    this.f372e.m483d(this.f368a);
                }
                aeg.m495a(this.f368a);
                adr.m400a(this.f368a);
                if (this.f375h != null) {
                    this.f375h.m436a(this.f368a).m426a(this.f368a);
                }
            }
            if (this.f369b != null) {
                this.f369b.m766b();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.adz
    /* JADX INFO: renamed from: a */
    public void mo312a(Throwable th) throws Throwable {
        try {
            if (this.f371d != null) {
                this.f371d.m496a();
            }
            if (this.f376i != null) {
                this.f376i.m405b();
            }
            if (this.f368a != null) {
                if (th != null && this.f375h != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MsgConstant.KEY_TS, System.currentTimeMillis());
                    jSONObject.put("error_source", 1);
                    jSONObject.put("context", aes.m704a(th));
                    agy.m991a(this.f368a).m1001a(aee.m475a(), jSONObject.toString(), 1);
                }
                m310e(this.f368a);
                aeb.m454a(this.f368a).edit().commit();
            }
            aey.m778a();
        } catch (Throwable th2) {
            if (aex.f711a) {
                aex.m770a("Exception in onAppCrash", th2);
            }
        }
    }
}
