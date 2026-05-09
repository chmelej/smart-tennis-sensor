package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMCCAggregatedManager.java */
/* JADX INFO: loaded from: classes.dex */
public class agp {

    /* JADX INFO: renamed from: i */
    private static Context f835i;

    /* JADX INFO: renamed from: a */
    private agm f836a;

    /* JADX INFO: renamed from: b */
    private agr f837b;

    /* JADX INFO: renamed from: c */
    private ags f838c;

    /* JADX INFO: renamed from: d */
    private boolean f839d;

    /* JADX INFO: renamed from: e */
    private boolean f840e;

    /* JADX INFO: renamed from: f */
    private long f841f;

    /* JADX INFO: renamed from: g */
    private final String f842g;

    /* JADX INFO: renamed from: h */
    private final String f843h;

    /* JADX INFO: renamed from: j */
    private List<String> f844j;

    /* JADX INFO: renamed from: k */
    private HandlerC0098a f845k;

    /* JADX INFO: renamed from: l */
    private final Thread f846l;

    /* JADX INFO: renamed from: agp$b */
    /* JADX INFO: compiled from: UMCCAggregatedManager.java */
    static class C0099b {

        /* JADX INFO: renamed from: a */
        private static final agp f856a = new agp();
    }

    /* JADX INFO: renamed from: agp$a */
    /* JADX INFO: compiled from: UMCCAggregatedManager.java */
    static class HandlerC0098a extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<agp> f855a;

        public HandlerC0098a(agp agpVar) {
            this.f855a = new WeakReference<>(agpVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (this.f855a != null) {
                switch (message.what) {
                    case 48:
                        sendEmptyMessageDelayed(48, agt.m972a(System.currentTimeMillis()));
                        agp.m938a(agp.f835i).m951i();
                        break;
                    case 49:
                        sendEmptyMessageDelayed(49, agt.m975b(System.currentTimeMillis()));
                        agp.m938a(agp.f835i).m950h();
                        break;
                }
            }
        }
    }

    private agp() {
        this.f836a = null;
        this.f837b = null;
        this.f838c = null;
        this.f839d = false;
        this.f840e = false;
        this.f841f = 0L;
        this.f842g = "main_fest_mode";
        this.f843h = "main_fest_timestamp";
        this.f844j = new ArrayList();
        this.f845k = null;
        this.f846l = new Thread(new Runnable() { // from class: agp.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                if (agp.this.f845k == null) {
                    agp.this.f845k = new HandlerC0098a(agp.this);
                }
                agp.this.m942d();
            }
        });
        if (f835i != null) {
            if (this.f836a == null) {
                this.f836a = new agm();
            }
            if (this.f837b == null) {
                this.f837b = agr.m960a(f835i);
            }
            if (this.f838c == null) {
                this.f838c = new ags();
            }
        }
        this.f846l.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m942d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f845k.sendEmptyMessageDelayed(48, agt.m972a(jCurrentTimeMillis));
        this.f845k.sendEmptyMessageDelayed(49, agt.m975b(jCurrentTimeMillis));
    }

    /* JADX INFO: renamed from: a */
    public static final agp m938a(Context context) {
        f835i = context;
        return C0099b.f856a;
    }

    /* JADX INFO: renamed from: e */
    private void m945e() {
        SharedPreferences.Editor editorEdit = aeb.m454a(f835i).edit();
        editorEdit.putBoolean("main_fest_mode", false);
        editorEdit.putLong("main_fest_timestamp", 0L);
        editorEdit.commit();
        this.f840e = false;
    }

    /* JADX INFO: renamed from: f */
    private void m947f() {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(f835i);
        this.f840e = sharedPreferencesM454a.getBoolean("main_fest_mode", false);
        this.f841f = sharedPreferencesM454a.getLong("main_fest_timestamp", 0L);
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m952a() {
        JSONObject jSONObjectM961a = this.f837b.m961a();
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectM961a == null || jSONObjectM961a.length() <= 0) {
            return null;
        }
        for (String str : this.f844j) {
            if (jSONObjectM961a.has(str)) {
                try {
                    jSONObject.put(str, jSONObjectM961a.opt(str));
                } catch (Exception unused) {
                }
            }
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: b */
    public JSONObject m955b() {
        if (this.f838c.m970a().size() > 0) {
            this.f837b.m967b(new agl() { // from class: agp.2
                @Override // p000.agl
                /* JADX INFO: renamed from: a */
                public void mo819a(Object obj, boolean z) {
                    if (obj instanceof String) {
                        agp.this.f838c.m971b();
                    }
                }
            }, this.f838c.m970a());
        }
        return this.f837b.m962a(new agl());
    }

    /* JADX INFO: renamed from: a */
    public void m954a(agl aglVar) {
        boolean zM974a;
        if (this.f840e) {
            if (this.f841f == 0) {
                m947f();
            }
            zM974a = agt.m974a(System.currentTimeMillis(), this.f841f);
        } else {
            zM974a = false;
        }
        if (!zM974a) {
            m945e();
            this.f844j.clear();
        }
        this.f838c.m971b();
        this.f837b.m966a(new agl() { // from class: agp.3
            @Override // p000.agl
            /* JADX INFO: renamed from: a */
            public void mo819a(Object obj, boolean z) {
                if (obj.equals("success")) {
                    agp.this.m948g();
                }
            }
        }, zM974a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m948g() {
        Iterator<Map.Entry<List<String>, agn>> it = this.f836a.m925a().entrySet().iterator();
        while (it.hasNext()) {
            List<String> key = it.next().getKey();
            if (!this.f844j.contains(key)) {
                this.f844j.add(aft.m905a(key));
            }
        }
        if (this.f844j.size() > 0) {
            this.f837b.m964a(new agl(), this.f844j);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m953a(long j, long j2, String str) {
        this.f837b.m963a(new agl() { // from class: agp.4
            @Override // p000.agl
            /* JADX INFO: renamed from: a */
            public void mo819a(Object obj, boolean z) {
                obj.equals("success");
            }
        }, str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m950h() throws Throwable {
        try {
            if (this.f836a.m925a().size() > 0) {
                this.f837b.m968c(new agl() { // from class: agp.5
                    @Override // p000.agl
                    /* JADX INFO: renamed from: a */
                    public void mo819a(Object obj, boolean z) {
                        if (obj instanceof String) {
                            agp.this.f836a.m926b();
                        }
                    }
                }, this.f836a.m925a());
            }
            if (this.f838c.m970a().size() > 0) {
                this.f837b.m967b(new agl() { // from class: agp.6
                    @Override // p000.agl
                    /* JADX INFO: renamed from: a */
                    public void mo819a(Object obj, boolean z) {
                        if (obj instanceof String) {
                            agp.this.f838c.m971b();
                        }
                    }
                }, this.f838c.m970a());
            }
            if (this.f844j.size() > 0) {
                this.f837b.m964a(new agl(), this.f844j);
            }
        } catch (Throwable th) {
            aex.m768a("converyMemoryToDataTable happen error: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m951i() throws Throwable {
        try {
            if (this.f836a.m925a().size() > 0) {
                this.f837b.m965a(new agl() { // from class: agp.7
                    @Override // p000.agl
                    /* JADX INFO: renamed from: a */
                    public void mo819a(Object obj, boolean z) {
                    }
                }, this.f836a.m925a());
            }
            if (this.f838c.m970a().size() > 0) {
                this.f837b.m967b(new agl() { // from class: agp.8
                    @Override // p000.agl
                    /* JADX INFO: renamed from: a */
                    public void mo819a(Object obj, boolean z) {
                        if (obj instanceof String) {
                            agp.this.f838c.m971b();
                        }
                    }
                }, this.f838c.m970a());
            }
            if (this.f844j.size() > 0) {
                this.f837b.m964a(new agl(), this.f844j);
            }
        } catch (Throwable th) {
            aex.m768a("convertMemoryToCacheTable happen error: " + th.toString());
        }
    }
}
