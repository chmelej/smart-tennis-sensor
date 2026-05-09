package p000;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: StatTracer.java */
/* JADX INFO: loaded from: classes.dex */
public class aef implements adx {

    /* JADX INFO: renamed from: a */
    public int f521a;

    /* JADX INFO: renamed from: b */
    public int f522b;

    /* JADX INFO: renamed from: c */
    public long f523c;

    /* JADX INFO: renamed from: e */
    private int f525e;

    /* JADX INFO: renamed from: h */
    private Context f528h;

    /* JADX INFO: renamed from: d */
    private final int f524d = 3600000;

    /* JADX INFO: renamed from: f */
    private long f526f = 0;

    /* JADX INFO: renamed from: g */
    private long f527g = 0;

    public aef(Context context) {
        m486a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m486a(Context context) {
        this.f528h = context.getApplicationContext();
        SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
        this.f521a = sharedPreferencesM454a.getInt("successful_request", 0);
        this.f522b = sharedPreferencesM454a.getInt("failed_requests ", 0);
        this.f525e = sharedPreferencesM454a.getInt("last_request_spent_ms", 0);
        this.f523c = sharedPreferencesM454a.getLong("last_request_time", 0L);
        this.f526f = sharedPreferencesM454a.getLong("last_req", 0L);
    }

    /* JADX INFO: renamed from: e */
    public boolean m487e() {
        return ((this.f523c > 0L ? 1 : (this.f523c == 0L ? 0 : -1)) == 0) && (afc.m806a(this.f528h).m817f() ^ true);
    }

    /* JADX INFO: renamed from: f */
    public void m488f() {
        this.f521a++;
        this.f523c = this.f526f;
    }

    /* JADX INFO: renamed from: g */
    public void m489g() {
        this.f522b++;
    }

    /* JADX INFO: renamed from: h */
    public void m490h() {
        this.f526f = System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: i */
    public void m491i() {
        this.f525e = (int) (System.currentTimeMillis() - this.f526f);
    }

    /* JADX INFO: renamed from: j */
    public void m492j() {
        aeb.m454a(this.f528h).edit().putInt("successful_request", this.f521a).putInt("failed_requests ", this.f522b).putInt("last_request_spent_ms", this.f525e).putLong("last_request_time", this.f523c).putLong("last_req", this.f526f).commit();
    }

    /* JADX INFO: renamed from: k */
    public long m493k() {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(this.f528h);
        this.f527g = aeb.m454a(this.f528h).getLong("first_activate_time", 0L);
        if (this.f527g == 0) {
            this.f527g = System.currentTimeMillis();
            sharedPreferencesM454a.edit().putLong("first_activate_time", this.f527g).commit();
        }
        return this.f527g;
    }

    /* JADX INFO: renamed from: l */
    public long m494l() {
        return this.f526f;
    }

    @Override // p000.adx
    /* JADX INFO: renamed from: a */
    public void mo444a() {
        m490h();
    }

    @Override // p000.adx
    /* JADX INFO: renamed from: b */
    public void mo445b() {
        m491i();
    }

    @Override // p000.adx
    /* JADX INFO: renamed from: c */
    public void mo446c() {
        m488f();
    }

    @Override // p000.adx
    /* JADX INFO: renamed from: d */
    public void mo447d() {
        m489g();
    }
}
