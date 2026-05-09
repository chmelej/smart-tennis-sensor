package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.umeng.message.MsgConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import p000.C2251xs;

/* JADX INFO: renamed from: xj */
/* JADX INFO: compiled from: Dispatcher.java */
/* JADX INFO: loaded from: classes.dex */
class C2242xj {

    /* JADX INFO: renamed from: a */
    final b f13496a = new b();

    /* JADX INFO: renamed from: b */
    final Context f13497b;

    /* JADX INFO: renamed from: c */
    final ExecutorService f13498c;

    /* JADX INFO: renamed from: d */
    final InterfaceC2243xk f13499d;

    /* JADX INFO: renamed from: e */
    final Map<String, RunnableC2236xd> f13500e;

    /* JADX INFO: renamed from: f */
    final Map<Object, AbstractC2234xb> f13501f;

    /* JADX INFO: renamed from: g */
    final Map<Object, AbstractC2234xb> f13502g;

    /* JADX INFO: renamed from: h */
    final Set<Object> f13503h;

    /* JADX INFO: renamed from: i */
    final Handler f13504i;

    /* JADX INFO: renamed from: j */
    final Handler f13505j;

    /* JADX INFO: renamed from: k */
    final InterfaceC2237xe f13506k;

    /* JADX INFO: renamed from: l */
    final C2261yb f13507l;

    /* JADX INFO: renamed from: m */
    final List<RunnableC2236xd> f13508m;

    /* JADX INFO: renamed from: n */
    final c f13509n;

    /* JADX INFO: renamed from: o */
    final boolean f13510o;

    /* JADX INFO: renamed from: p */
    boolean f13511p;

    C2242xj(Context context, ExecutorService executorService, Handler handler, InterfaceC2243xk interfaceC2243xk, InterfaceC2237xe interfaceC2237xe, C2261yb c2261yb) {
        this.f13496a.start();
        C2265yf.m12391a(this.f13496a.getLooper());
        this.f13497b = context;
        this.f13498c = executorService;
        this.f13500e = new LinkedHashMap();
        this.f13501f = new WeakHashMap();
        this.f13502g = new WeakHashMap();
        this.f13503h = new HashSet();
        this.f13504i = new a(this.f13496a.getLooper(), this);
        this.f13499d = interfaceC2243xk;
        this.f13505j = handler;
        this.f13506k = interfaceC2237xe;
        this.f13507l = c2261yb;
        this.f13508m = new ArrayList(4);
        this.f13511p = C2265yf.m12402d(this.f13497b);
        this.f13510o = C2265yf.m12398b(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE);
        this.f13509n = new c(this);
        this.f13509n.m12283a();
    }

    /* JADX INFO: renamed from: a */
    void m12268a(AbstractC2234xb abstractC2234xb) {
        this.f13504i.sendMessage(this.f13504i.obtainMessage(1, abstractC2234xb));
    }

    /* JADX INFO: renamed from: b */
    void m12275b(AbstractC2234xb abstractC2234xb) {
        this.f13504i.sendMessage(this.f13504i.obtainMessage(2, abstractC2234xb));
    }

    /* JADX INFO: renamed from: a */
    void m12270a(RunnableC2236xd runnableC2236xd) {
        this.f13504i.sendMessage(this.f13504i.obtainMessage(4, runnableC2236xd));
    }

    /* JADX INFO: renamed from: b */
    void m12276b(RunnableC2236xd runnableC2236xd) {
        this.f13504i.sendMessageDelayed(this.f13504i.obtainMessage(5, runnableC2236xd), 500L);
    }

    /* JADX INFO: renamed from: c */
    void m12279c(RunnableC2236xd runnableC2236xd) {
        this.f13504i.sendMessage(this.f13504i.obtainMessage(6, runnableC2236xd));
    }

    /* JADX INFO: renamed from: a */
    void m12266a(NetworkInfo networkInfo) {
        this.f13504i.sendMessage(this.f13504i.obtainMessage(9, networkInfo));
    }

    /* JADX INFO: renamed from: a */
    void m12272a(boolean z) {
        this.f13504i.sendMessage(this.f13504i.obtainMessage(10, z ? 1 : 0, 0));
    }

    /* JADX INFO: renamed from: c */
    void m12278c(AbstractC2234xb abstractC2234xb) {
        m12269a(abstractC2234xb, true);
    }

    /* JADX INFO: renamed from: a */
    void m12269a(AbstractC2234xb abstractC2234xb, boolean z) {
        if (this.f13503h.contains(abstractC2234xb.m12221l())) {
            this.f13502g.put(abstractC2234xb.m12213d(), abstractC2234xb);
            if (abstractC2234xb.m12219j().f13566l) {
                C2265yf.m12394a("Dispatcher", "paused", abstractC2234xb.f13447b.m12330a(), "because tag '" + abstractC2234xb.m12221l() + "' is paused");
                return;
            }
            return;
        }
        RunnableC2236xd runnableC2236xd = this.f13500e.get(abstractC2234xb.m12214e());
        if (runnableC2236xd != null) {
            runnableC2236xd.m12233a(abstractC2234xb);
            return;
        }
        if (this.f13498c.isShutdown()) {
            if (abstractC2234xb.m12219j().f13566l) {
                C2265yf.m12394a("Dispatcher", "ignored", abstractC2234xb.f13447b.m12330a(), "because shut down");
                return;
            }
            return;
        }
        RunnableC2236xd runnableC2236xdM12228a = RunnableC2236xd.m12228a(abstractC2234xb.m12219j(), this, this.f13506k, this.f13507l, abstractC2234xb);
        runnableC2236xdM12228a.f13478n = this.f13498c.submit(runnableC2236xdM12228a);
        this.f13500e.put(abstractC2234xb.m12214e(), runnableC2236xdM12228a);
        if (z) {
            this.f13501f.remove(abstractC2234xb.m12213d());
        }
        if (abstractC2234xb.m12219j().f13566l) {
            C2265yf.m12393a("Dispatcher", "enqueued", abstractC2234xb.f13447b.m12330a());
        }
    }

    /* JADX INFO: renamed from: d */
    void m12280d(AbstractC2234xb abstractC2234xb) {
        String strM12214e = abstractC2234xb.m12214e();
        RunnableC2236xd runnableC2236xd = this.f13500e.get(strM12214e);
        if (runnableC2236xd != null) {
            runnableC2236xd.m12235b(abstractC2234xb);
            if (runnableC2236xd.m12236b()) {
                this.f13500e.remove(strM12214e);
                if (abstractC2234xb.m12219j().f13566l) {
                    C2265yf.m12393a("Dispatcher", "canceled", abstractC2234xb.m12212c().m12330a());
                }
            }
        }
        if (this.f13503h.contains(abstractC2234xb.m12221l())) {
            this.f13502g.remove(abstractC2234xb.m12213d());
            if (abstractC2234xb.m12219j().f13566l) {
                C2265yf.m12394a("Dispatcher", "canceled", abstractC2234xb.m12212c().m12330a(), "because paused request got canceled");
            }
        }
        AbstractC2234xb abstractC2234xbRemove = this.f13501f.remove(abstractC2234xb.m12213d());
        if (abstractC2234xbRemove == null || !abstractC2234xbRemove.m12219j().f13566l) {
            return;
        }
        C2265yf.m12394a("Dispatcher", "canceled", abstractC2234xbRemove.m12212c().m12330a(), "from replaying");
    }

    /* JADX INFO: renamed from: a */
    void m12267a(Object obj) {
        if (this.f13503h.add(obj)) {
            Iterator<RunnableC2236xd> it = this.f13500e.values().iterator();
            while (it.hasNext()) {
                RunnableC2236xd next = it.next();
                boolean z = next.m12244j().f13566l;
                AbstractC2234xb abstractC2234xbM12243i = next.m12243i();
                List<AbstractC2234xb> listM12245k = next.m12245k();
                boolean z2 = (listM12245k == null || listM12245k.isEmpty()) ? false : true;
                if (abstractC2234xbM12243i != null || z2) {
                    if (abstractC2234xbM12243i != null && abstractC2234xbM12243i.m12221l().equals(obj)) {
                        next.m12235b(abstractC2234xbM12243i);
                        this.f13502g.put(abstractC2234xbM12243i.m12213d(), abstractC2234xbM12243i);
                        if (z) {
                            C2265yf.m12394a("Dispatcher", "paused", abstractC2234xbM12243i.f13447b.m12330a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = listM12245k.size() - 1; size >= 0; size--) {
                            AbstractC2234xb abstractC2234xb = listM12245k.get(size);
                            if (abstractC2234xb.m12221l().equals(obj)) {
                                next.m12235b(abstractC2234xb);
                                this.f13502g.put(abstractC2234xb.m12213d(), abstractC2234xb);
                                if (z) {
                                    C2265yf.m12394a("Dispatcher", "paused", abstractC2234xb.f13447b.m12330a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.m12236b()) {
                        it.remove();
                        if (z) {
                            C2265yf.m12394a("Dispatcher", "canceled", C2265yf.m12385a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m12274b(Object obj) {
        if (this.f13503h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<AbstractC2234xb> it = this.f13502g.values().iterator();
            while (it.hasNext()) {
                AbstractC2234xb next = it.next();
                if (next.m12221l().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                this.f13505j.sendMessage(this.f13505j.obtainMessage(13, arrayList));
            }
        }
    }

    /* JADX INFO: renamed from: d */
    void m12281d(RunnableC2236xd runnableC2236xd) {
        if (runnableC2236xd.m12237c()) {
            return;
        }
        boolean z = false;
        if (this.f13498c.isShutdown()) {
            m12271a(runnableC2236xd, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.f13510o ? ((ConnectivityManager) C2265yf.m12383a(this.f13497b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean zM12234a = runnableC2236xd.m12234a(this.f13511p, activeNetworkInfo);
        boolean zM12238d = runnableC2236xd.m12238d();
        if (!zM12234a) {
            if (this.f13510o && zM12238d) {
                z = true;
            }
            m12271a(runnableC2236xd, z);
            if (z) {
                m12263f(runnableC2236xd);
                return;
            }
            return;
        }
        if (!this.f13510o || z2) {
            if (runnableC2236xd.m12244j().f13566l) {
                C2265yf.m12393a("Dispatcher", "retrying", C2265yf.m12385a(runnableC2236xd));
            }
            if (runnableC2236xd.m12246l() instanceof C2251xs.a) {
                runnableC2236xd.f13473i |= EnumC2250xr.NO_CACHE.f13551d;
            }
            runnableC2236xd.f13478n = this.f13498c.submit(runnableC2236xd);
            return;
        }
        m12271a(runnableC2236xd, zM12238d);
        if (zM12238d) {
            m12263f(runnableC2236xd);
        }
    }

    /* JADX INFO: renamed from: e */
    void m12282e(RunnableC2236xd runnableC2236xd) {
        if (EnumC2249xq.m12297b(runnableC2236xd.m12241g())) {
            this.f13506k.mo12252a(runnableC2236xd.m12240f(), runnableC2236xd.m12239e());
        }
        this.f13500e.remove(runnableC2236xd.m12240f());
        m12264g(runnableC2236xd);
        if (runnableC2236xd.m12244j().f13566l) {
            C2265yf.m12394a("Dispatcher", "batched", C2265yf.m12385a(runnableC2236xd), "for completion");
        }
    }

    /* JADX INFO: renamed from: a */
    void m12265a() {
        ArrayList arrayList = new ArrayList(this.f13508m);
        this.f13508m.clear();
        this.f13505j.sendMessage(this.f13505j.obtainMessage(8, arrayList));
        m12260a((List<RunnableC2236xd>) arrayList);
    }

    /* JADX INFO: renamed from: a */
    void m12271a(RunnableC2236xd runnableC2236xd, boolean z) {
        if (runnableC2236xd.m12244j().f13566l) {
            String strM12385a = C2265yf.m12385a(runnableC2236xd);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            C2265yf.m12394a("Dispatcher", "batched", strM12385a, sb.toString());
        }
        this.f13500e.remove(runnableC2236xd.m12240f());
        m12264g(runnableC2236xd);
    }

    /* JADX INFO: renamed from: b */
    void m12277b(boolean z) {
        this.f13511p = z;
    }

    /* JADX INFO: renamed from: b */
    void m12273b(NetworkInfo networkInfo) {
        if (this.f13498c instanceof C2255xw) {
            ((C2255xw) this.f13498c).m12328a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        m12261b();
    }

    /* JADX INFO: renamed from: b */
    private void m12261b() {
        if (this.f13501f.isEmpty()) {
            return;
        }
        Iterator<AbstractC2234xb> it = this.f13501f.values().iterator();
        while (it.hasNext()) {
            AbstractC2234xb next = it.next();
            it.remove();
            if (next.m12219j().f13566l) {
                C2265yf.m12393a("Dispatcher", "replaying", next.m12212c().m12330a());
            }
            m12269a(next, false);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m12263f(RunnableC2236xd runnableC2236xd) {
        AbstractC2234xb abstractC2234xbM12243i = runnableC2236xd.m12243i();
        if (abstractC2234xbM12243i != null) {
            m12262e(abstractC2234xbM12243i);
        }
        List<AbstractC2234xb> listM12245k = runnableC2236xd.m12245k();
        if (listM12245k != null) {
            int size = listM12245k.size();
            for (int i = 0; i < size; i++) {
                m12262e(listM12245k.get(i));
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m12262e(AbstractC2234xb abstractC2234xb) {
        Object objM12213d = abstractC2234xb.m12213d();
        if (objM12213d != null) {
            abstractC2234xb.f13456k = true;
            this.f13501f.put(objM12213d, abstractC2234xb);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m12264g(RunnableC2236xd runnableC2236xd) {
        if (runnableC2236xd.m12237c()) {
            return;
        }
        this.f13508m.add(runnableC2236xd);
        if (this.f13504i.hasMessages(7)) {
            return;
        }
        this.f13504i.sendEmptyMessageDelayed(7, 200L);
    }

    /* JADX INFO: renamed from: a */
    private void m12260a(List<RunnableC2236xd> list) {
        if (list == null || list.isEmpty() || !list.get(0).m12244j().f13566l) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (RunnableC2236xd runnableC2236xd : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(C2265yf.m12385a(runnableC2236xd));
        }
        C2265yf.m12393a("Dispatcher", "delivered", sb.toString());
    }

    /* JADX INFO: renamed from: xj$a */
    /* JADX INFO: compiled from: Dispatcher.java */
    static class a extends Handler {

        /* JADX INFO: renamed from: a */
        private final C2242xj f13512a;

        public a(Looper looper, C2242xj c2242xj) {
            super(looper);
            this.f13512a = c2242xj;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 1:
                    this.f13512a.m12278c((AbstractC2234xb) message.obj);
                    break;
                case 2:
                    this.f13512a.m12280d((AbstractC2234xb) message.obj);
                    break;
                case 3:
                case 8:
                default:
                    C2253xu.f13555a.post(new Runnable() { // from class: xj.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    break;
                case 4:
                    this.f13512a.m12282e((RunnableC2236xd) message.obj);
                    break;
                case 5:
                    this.f13512a.m12281d((RunnableC2236xd) message.obj);
                    break;
                case 6:
                    this.f13512a.m12271a((RunnableC2236xd) message.obj, false);
                    break;
                case 7:
                    this.f13512a.m12265a();
                    break;
                case 9:
                    this.f13512a.m12273b((NetworkInfo) message.obj);
                    break;
                case 10:
                    this.f13512a.m12277b(message.arg1 == 1);
                    break;
                case 11:
                    this.f13512a.m12267a(message.obj);
                    break;
                case 12:
                    this.f13512a.m12274b(message.obj);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: xj$b */
    /* JADX INFO: compiled from: Dispatcher.java */
    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* JADX INFO: renamed from: xj$c */
    /* JADX INFO: compiled from: Dispatcher.java */
    static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        private final C2242xj f13515a;

        c(C2242xj c2242xj) {
            this.f13515a = c2242xj;
        }

        /* JADX INFO: renamed from: a */
        void m12283a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f13515a.f13510o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f13515a.f13497b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.f13515a.m12272a(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.f13515a.m12266a(((ConnectivityManager) C2265yf.m12383a(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }
}
