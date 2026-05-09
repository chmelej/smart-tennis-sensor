package p000;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.internal.view.SupportMenu;
import android.widget.ImageView;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import p000.AbstractC2234xb;

/* JADX INFO: renamed from: xu */
/* JADX INFO: compiled from: Picasso.java */
/* JADX INFO: loaded from: classes.dex */
public class C2253xu {

    /* JADX INFO: renamed from: a */
    static final Handler f13555a = new Handler(Looper.getMainLooper()) { // from class: xu.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                AbstractC2234xb abstractC2234xb = (AbstractC2234xb) message.obj;
                if (abstractC2234xb.m12219j().f13566l) {
                    C2265yf.m12394a("Main", "canceled", abstractC2234xb.f13447b.m12330a(), "target got garbage collected");
                }
                abstractC2234xb.f13446a.m12307a(abstractC2234xb.m12213d());
                return;
            }
            int i2 = 0;
            if (i == 8) {
                List list = (List) message.obj;
                int size = list.size();
                while (i2 < size) {
                    RunnableC2236xd runnableC2236xd = (RunnableC2236xd) list.get(i2);
                    runnableC2236xd.f13466b.m12316a(runnableC2236xd);
                    i2++;
                }
                return;
            }
            if (i == 13) {
                List list2 = (List) message.obj;
                int size2 = list2.size();
                while (i2 < size2) {
                    AbstractC2234xb abstractC2234xb2 = (AbstractC2234xb) list2.get(i2);
                    abstractC2234xb2.f13446a.m12319c(abstractC2234xb2);
                    i2++;
                }
                return;
            }
            throw new AssertionError("Unknown handler message received: " + message.what);
        }
    };

    /* JADX INFO: renamed from: b */
    static volatile C2253xu f13556b;

    /* JADX INFO: renamed from: c */
    final Context f13557c;

    /* JADX INFO: renamed from: d */
    final C2242xj f13558d;

    /* JADX INFO: renamed from: e */
    final InterfaceC2237xe f13559e;

    /* JADX INFO: renamed from: f */
    final C2261yb f13560f;

    /* JADX INFO: renamed from: g */
    final Map<Object, AbstractC2234xb> f13561g;

    /* JADX INFO: renamed from: h */
    final Map<ImageView, ViewTreeObserverOnPreDrawListenerC2241xi> f13562h;

    /* JADX INFO: renamed from: i */
    final ReferenceQueue<Object> f13563i;

    /* JADX INFO: renamed from: j */
    final Bitmap.Config f13564j;

    /* JADX INFO: renamed from: k */
    boolean f13565k;

    /* JADX INFO: renamed from: l */
    volatile boolean f13566l;

    /* JADX INFO: renamed from: m */
    boolean f13567m;

    /* JADX INFO: renamed from: n */
    private final c f13568n;

    /* JADX INFO: renamed from: o */
    private final f f13569o;

    /* JADX INFO: renamed from: p */
    private final b f13570p;

    /* JADX INFO: renamed from: q */
    private final List<AbstractC2258xz> f13571q;

    /* JADX INFO: renamed from: xu$c */
    /* JADX INFO: compiled from: Picasso.java */
    public interface c {
        /* JADX INFO: renamed from: a */
        void m12321a(C2253xu c2253xu, Uri uri, Exception exc);
    }

    /* JADX INFO: renamed from: xu$e */
    /* JADX INFO: compiled from: Picasso.java */
    public enum e {
        LOW,
        NORMAL,
        HIGH
    }

    /* JADX INFO: renamed from: xu$f */
    /* JADX INFO: compiled from: Picasso.java */
    public interface f {

        /* JADX INFO: renamed from: a */
        public static final f f13595a = new f() { // from class: xu.f.1
            @Override // p000.C2253xu.f
            /* JADX INFO: renamed from: a */
            public C2256xx mo12322a(C2256xx c2256xx) {
                return c2256xx;
            }
        };

        /* JADX INFO: renamed from: a */
        C2256xx mo12322a(C2256xx c2256xx);
    }

    C2253xu(Context context, C2242xj c2242xj, InterfaceC2237xe interfaceC2237xe, c cVar, f fVar, List<AbstractC2258xz> list, C2261yb c2261yb, Bitmap.Config config, boolean z, boolean z2) {
        this.f13557c = context;
        this.f13558d = c2242xj;
        this.f13559e = interfaceC2237xe;
        this.f13568n = cVar;
        this.f13569o = fVar;
        this.f13564j = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new C2260ya(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C2239xg(context));
        arrayList.add(new C2248xp(context));
        arrayList.add(new C2240xh(context));
        arrayList.add(new C2235xc(context));
        arrayList.add(new C2244xl(context));
        arrayList.add(new C2251xs(c2242xj.f13499d, c2261yb));
        this.f13571q = Collections.unmodifiableList(arrayList);
        this.f13560f = c2261yb;
        this.f13561g = new WeakHashMap();
        this.f13562h = new WeakHashMap();
        this.f13565k = z;
        this.f13566l = z2;
        this.f13563i = new ReferenceQueue<>();
        this.f13570p = new b(this.f13563i, f13555a);
        this.f13570p.start();
    }

    /* JADX INFO: renamed from: a */
    public void m12313a(ImageView imageView) {
        m12307a((Object) imageView);
    }

    /* JADX INFO: renamed from: a */
    public C2257xy m12311a(Uri uri) {
        return new C2257xy(this, uri, 0);
    }

    /* JADX INFO: renamed from: a */
    public C2257xy m12312a(String str) {
        if (str == null) {
            return new C2257xy(this, null, 0);
        }
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("Path must not be empty.");
        }
        return m12311a(Uri.parse(str));
    }

    /* JADX INFO: renamed from: a */
    List<AbstractC2258xz> m12309a() {
        return this.f13571q;
    }

    /* JADX INFO: renamed from: a */
    C2256xx m12310a(C2256xx c2256xx) {
        C2256xx c2256xxMo12322a = this.f13569o.mo12322a(c2256xx);
        if (c2256xxMo12322a != null) {
            return c2256xxMo12322a;
        }
        throw new IllegalStateException("Request transformer " + this.f13569o.getClass().getCanonicalName() + " returned null for " + c2256xx);
    }

    /* JADX INFO: renamed from: a */
    void m12314a(ImageView imageView, ViewTreeObserverOnPreDrawListenerC2241xi viewTreeObserverOnPreDrawListenerC2241xi) {
        this.f13562h.put(imageView, viewTreeObserverOnPreDrawListenerC2241xi);
    }

    /* JADX INFO: renamed from: a */
    void m12315a(AbstractC2234xb abstractC2234xb) {
        Object objM12213d = abstractC2234xb.m12213d();
        if (objM12213d != null && this.f13561g.get(objM12213d) != abstractC2234xb) {
            m12307a(objM12213d);
            this.f13561g.put(objM12213d, abstractC2234xb);
        }
        m12318b(abstractC2234xb);
    }

    /* JADX INFO: renamed from: b */
    void m12318b(AbstractC2234xb abstractC2234xb) {
        this.f13558d.m12268a(abstractC2234xb);
    }

    /* JADX INFO: renamed from: b */
    Bitmap m12317b(String str) {
        Bitmap bitmapMo12251a = this.f13559e.mo12251a(str);
        if (bitmapMo12251a != null) {
            this.f13560f.m12363a();
        } else {
            this.f13560f.m12367b();
        }
        return bitmapMo12251a;
    }

    /* JADX INFO: renamed from: a */
    void m12316a(RunnableC2236xd runnableC2236xd) {
        AbstractC2234xb abstractC2234xbM12243i = runnableC2236xd.m12243i();
        List<AbstractC2234xb> listM12245k = runnableC2236xd.m12245k();
        boolean z = true;
        boolean z2 = (listM12245k == null || listM12245k.isEmpty()) ? false : true;
        if (abstractC2234xbM12243i == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = runnableC2236xd.m12242h().f13609d;
            Exception excM12246l = runnableC2236xd.m12246l();
            Bitmap bitmapM12239e = runnableC2236xd.m12239e();
            d dVarM12247m = runnableC2236xd.m12247m();
            if (abstractC2234xbM12243i != null) {
                m12306a(bitmapM12239e, dVarM12247m, abstractC2234xbM12243i);
            }
            if (z2) {
                int size = listM12245k.size();
                for (int i = 0; i < size; i++) {
                    m12306a(bitmapM12239e, dVarM12247m, listM12245k.get(i));
                }
            }
            if (this.f13568n == null || excM12246l == null) {
                return;
            }
            this.f13568n.m12321a(this, uri, excM12246l);
        }
    }

    /* JADX INFO: renamed from: c */
    void m12319c(AbstractC2234xb abstractC2234xb) {
        Bitmap bitmapM12317b = EnumC2249xq.m12296a(abstractC2234xb.f13450e) ? m12317b(abstractC2234xb.m12214e()) : null;
        if (bitmapM12317b != null) {
            m12306a(bitmapM12317b, d.MEMORY, abstractC2234xb);
            if (this.f13566l) {
                C2265yf.m12394a("Main", "completed", abstractC2234xb.f13447b.m12330a(), "from " + d.MEMORY);
                return;
            }
            return;
        }
        m12315a(abstractC2234xb);
        if (this.f13566l) {
            C2265yf.m12393a("Main", "resumed", abstractC2234xb.f13447b.m12330a());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m12306a(Bitmap bitmap, d dVar, AbstractC2234xb abstractC2234xb) {
        if (abstractC2234xb.m12215f()) {
            return;
        }
        if (!abstractC2234xb.m12216g()) {
            this.f13561g.remove(abstractC2234xb.m12213d());
        }
        if (bitmap == null) {
            abstractC2234xb.mo12209a();
            if (this.f13566l) {
                C2265yf.m12393a("Main", "errored", abstractC2234xb.f13447b.m12330a());
                return;
            }
            return;
        }
        if (dVar == null) {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        abstractC2234xb.mo12210a(bitmap, dVar);
        if (this.f13566l) {
            C2265yf.m12394a("Main", "completed", abstractC2234xb.f13447b.m12330a(), "from " + dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m12307a(Object obj) {
        C2265yf.m12390a();
        AbstractC2234xb abstractC2234xbRemove = this.f13561g.remove(obj);
        if (abstractC2234xbRemove != null) {
            abstractC2234xbRemove.mo12211b();
            this.f13558d.m12275b(abstractC2234xbRemove);
        }
        if (obj instanceof ImageView) {
            ViewTreeObserverOnPreDrawListenerC2241xi viewTreeObserverOnPreDrawListenerC2241xiRemove = this.f13562h.remove((ImageView) obj);
            if (viewTreeObserverOnPreDrawListenerC2241xiRemove != null) {
                viewTreeObserverOnPreDrawListenerC2241xiRemove.m12259a();
            }
        }
    }

    /* JADX INFO: renamed from: xu$b */
    /* JADX INFO: compiled from: Picasso.java */
    static class b extends Thread {

        /* JADX INFO: renamed from: a */
        private final ReferenceQueue<Object> f13582a;

        /* JADX INFO: renamed from: b */
        private final Handler f13583b;

        b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f13582a = referenceQueue;
            this.f13583b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    AbstractC2234xb.a aVar = (AbstractC2234xb.a) this.f13582a.remove(1000L);
                    Message messageObtainMessage = this.f13583b.obtainMessage();
                    if (aVar != null) {
                        messageObtainMessage.what = 3;
                        messageObtainMessage.obj = aVar.f13458a;
                        this.f13583b.sendMessage(messageObtainMessage);
                    } else {
                        messageObtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.f13583b.post(new Runnable() { // from class: xu.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static C2253xu m12305a(Context context) {
        if (f13556b == null) {
            synchronized (C2253xu.class) {
                if (f13556b == null) {
                    f13556b = new a(context).m12320a();
                }
            }
        }
        return f13556b;
    }

    /* JADX INFO: renamed from: xu$a */
    /* JADX INFO: compiled from: Picasso.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        private final Context f13572a;

        /* JADX INFO: renamed from: b */
        private InterfaceC2243xk f13573b;

        /* JADX INFO: renamed from: c */
        private ExecutorService f13574c;

        /* JADX INFO: renamed from: d */
        private InterfaceC2237xe f13575d;

        /* JADX INFO: renamed from: e */
        private c f13576e;

        /* JADX INFO: renamed from: f */
        private f f13577f;

        /* JADX INFO: renamed from: g */
        private List<AbstractC2258xz> f13578g;

        /* JADX INFO: renamed from: h */
        private Bitmap.Config f13579h;

        /* JADX INFO: renamed from: i */
        private boolean f13580i;

        /* JADX INFO: renamed from: j */
        private boolean f13581j;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f13572a = context.getApplicationContext();
        }

        /* JADX INFO: renamed from: a */
        public C2253xu m12320a() {
            Context context = this.f13572a;
            if (this.f13573b == null) {
                this.f13573b = C2265yf.m12389a(context);
            }
            if (this.f13575d == null) {
                this.f13575d = new C2246xn(context);
            }
            if (this.f13574c == null) {
                this.f13574c = new C2255xw();
            }
            if (this.f13577f == null) {
                this.f13577f = f.f13595a;
            }
            C2261yb c2261yb = new C2261yb(this.f13575d);
            return new C2253xu(context, new C2242xj(context, this.f13574c, C2253xu.f13555a, this.f13573b, this.f13575d, c2261yb), this.f13575d, this.f13576e, this.f13577f, this.f13578g, c2261yb, this.f13579h, this.f13580i, this.f13581j);
        }
    }

    /* JADX INFO: renamed from: xu$d */
    /* JADX INFO: compiled from: Picasso.java */
    public enum d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);


        /* JADX INFO: renamed from: d */
        final int f13590d;

        d(int i) {
            this.f13590d = i;
        }
    }
}
