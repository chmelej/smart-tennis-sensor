package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.p004b.C0828a;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: renamed from: cn.sharesdk.framework.f */
/* JADX INFO: compiled from: ShareSDKCoreThread.java */
/* JADX INFO: loaded from: classes.dex */
public class C0847f extends SSDKHandlerThread {

    /* JADX INFO: renamed from: b */
    private Context f5675b;

    /* JADX INFO: renamed from: j */
    private String f5683j;

    /* JADX INFO: renamed from: k */
    private boolean f5684k;

    /* JADX INFO: renamed from: l */
    private String f5685l;

    /* JADX INFO: renamed from: m */
    private boolean f5686m;

    /* JADX INFO: renamed from: n */
    private boolean f5687n;

    /* JADX INFO: renamed from: a */
    private a f5674a = a.IDLE;

    /* JADX INFO: renamed from: c */
    private HashMap<String, HashMap<String, String>> f5676c = new HashMap<>();

    /* JADX INFO: renamed from: d */
    private ArrayList<Platform> f5677d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    private HashMap<String, Integer> f5678e = new HashMap<>();

    /* JADX INFO: renamed from: f */
    private HashMap<Integer, String> f5679f = new HashMap<>();

    /* JADX INFO: renamed from: g */
    private HashMap<Integer, CustomPlatform> f5680g = new HashMap<>();

    /* JADX INFO: renamed from: h */
    private HashMap<Integer, HashMap<String, Object>> f5681h = new HashMap<>();

    /* JADX INFO: renamed from: i */
    private HashMap<Integer, Service> f5682i = new HashMap<>();

    /* JADX INFO: renamed from: cn.sharesdk.framework.f$a */
    /* JADX INFO: compiled from: ShareSDKCoreThread.java */
    enum a {
        IDLE,
        INITIALIZING,
        READY
    }

    public C0847f(Context context, String str) {
        this.f5683j = str;
        this.f5675b = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public void m6159a(boolean z) {
        this.f5684k = z;
    }

    @Override // com.mob.tools.SSDKHandlerThread
    public void startThread() {
        this.f5674a = a.INITIALIZING;
        C0851d.m6196a(this.f5675b, 60069, this.f5683j);
        EventRecorder.prepare(this.f5675b);
        m6143f();
        super.startThread();
    }

    /* JADX INFO: renamed from: f */
    private void m6143f() {
        HashMap<String, String> mapRemove;
        synchronized (this.f5676c) {
            this.f5676c.clear();
            m6144g();
            if (this.f5676c.containsKey("ShareSDK") && (mapRemove = this.f5676c.remove("ShareSDK")) != null) {
                if (this.f5683j == null) {
                    this.f5683j = mapRemove.get("AppKey");
                }
                this.f5685l = mapRemove.containsKey("UseVersion") ? mapRemove.get("UseVersion") : "latest";
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m6144g() {
        InputStream inputStreamOpen;
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            try {
                inputStreamOpen = this.f5675b.getAssets().open("ShareSDK.xml");
            } catch (Throwable th) {
                C0851d.m6195a().m8610d(th);
                inputStreamOpen = this.f5675b.getAssets().open("ShareSDK.conf");
            }
            xmlPullParserNewPullParser.setInput(inputStreamOpen, "utf-8");
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 2) {
                    String name = xmlPullParserNewPullParser.getName();
                    HashMap<String, String> map = new HashMap<>();
                    int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        map.put(xmlPullParserNewPullParser.getAttributeName(i), xmlPullParserNewPullParser.getAttributeValue(i).trim());
                    }
                    this.f5676c.put(name, map);
                }
            }
            inputStreamOpen.close();
        } catch (Throwable th2) {
            C0851d.m6195a().m8610d(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.SSDKHandlerThread
    public void onStart(Message message) {
        synchronized (this.f5682i) {
            synchronized (this.f5677d) {
                try {
                    String strCheckRecord = EventRecorder.checkRecord("ShareSDK");
                    if (!TextUtils.isEmpty(strCheckRecord)) {
                        C0828a.m5995a(this.f5675b, this.f5683j).m6009a((HashMap<String, Object>) null);
                        C0851d.m6195a().m8621w("EventRecorder checkRecord result ==" + strCheckRecord, new Object[0]);
                        m6175e();
                    }
                    EventRecorder.clear();
                } catch (Throwable th) {
                    try {
                        C0851d.m6195a().m8622w(th);
                    } catch (Throwable th2) {
                        this.f5674a = a.READY;
                        this.f5677d.notify();
                        this.f5682i.notify();
                        C0851d.m6195a().m8622w(th2);
                    }
                }
                m6146i();
                m6147j();
                this.f5674a = a.READY;
                this.f5677d.notify();
                this.f5682i.notify();
                m6145h();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.framework.f$1] */
    /* JADX INFO: renamed from: h */
    private void m6145h() {
        new Thread() { // from class: cn.sharesdk.framework.f.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    HashMap<String, Object> map = new HashMap<>();
                    if (C0847f.this.m6174d() || !C0847f.this.m6160a(map)) {
                        return;
                    }
                    C0847f.this.m6168b(map);
                } catch (Throwable th) {
                    C0851d.m6195a().m8622w(th);
                }
            }
        }.start();
    }

    /* JADX INFO: renamed from: i */
    private void m6146i() {
        this.f5677d.clear();
        ArrayList<Platform> arrayListM6130a = new C0846e(this.f5675b, this.f5683j).m6130a();
        if (arrayListM6130a != null) {
            this.f5677d.addAll(arrayListM6130a);
        }
        synchronized (this.f5678e) {
            synchronized (this.f5679f) {
                for (Platform platform : this.f5677d) {
                    this.f5679f.put(Integer.valueOf(platform.getPlatformId()), platform.getName());
                    this.f5678e.put(platform.getName(), Integer.valueOf(platform.getPlatformId()));
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    private void m6147j() {
        C0846e c0846e = new C0846e(this.f5675b, this.f5683j);
        c0846e.m6134a(this);
        c0846e.m6133a(this.handler, this.f5684k, 69);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.SSDKHandlerThread
    public void onStop(Message message) {
        synchronized (this.f5682i) {
            Iterator<Map.Entry<Integer, Service>> it = this.f5682i.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onUnbind();
            }
            this.f5682i.clear();
        }
        synchronized (this.f5680g) {
            this.f5680g.clear();
        }
        try {
            new C0846e(this.f5675b, this.f5683j).m6138b();
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
            this.handler.getLooper().quit();
            this.f5674a = a.IDLE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.SSDKHandlerThread
    public void onMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        this.f5674a = a.IDLE;
        this.handler.getLooper().quit();
    }

    /* JADX INFO: renamed from: a */
    public void m6155a(Class<? extends Service> cls) {
        synchronized (this.f5682i) {
            if (this.f5682i.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            try {
                Service serviceNewInstance = cls.newInstance();
                this.f5682i.put(Integer.valueOf(cls.hashCode()), serviceNewInstance);
                serviceNewInstance.m5935a(this.f5675b);
                serviceNewInstance.m5936a(this.f5683j);
                serviceNewInstance.onBind();
            } catch (Throwable th) {
                C0851d.m6195a().m8622w(th);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6166b(Class<? extends Service> cls) {
        synchronized (this.f5682i) {
            int iHashCode = cls.hashCode();
            if (this.f5682i.containsKey(Integer.valueOf(iHashCode))) {
                this.f5682i.get(Integer.valueOf(iHashCode)).onUnbind();
                this.f5682i.remove(Integer.valueOf(iHashCode));
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public <T extends Service> T m6169c(Class<T> cls) {
        synchronized (this.f5682i) {
            if (this.f5674a == a.IDLE) {
                return null;
            }
            if (this.f5674a == a.INITIALIZING) {
                try {
                    this.f5682i.wait();
                } catch (Throwable th) {
                    C0851d.m6195a().m8622w(th);
                }
                try {
                    return cls.cast(this.f5682i.get(Integer.valueOf(cls.hashCode())));
                } catch (Throwable th2) {
                    C0851d.m6195a().m8622w(th2);
                    return null;
                }
            }
            return cls.cast(this.f5682i.get(Integer.valueOf(cls.hashCode())));
        }
    }

    /* JADX INFO: renamed from: d */
    public void m6173d(Class<? extends CustomPlatform> cls) {
        synchronized (this.f5680g) {
            if (this.f5680g.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            try {
                CustomPlatform customPlatformNewInstance = cls.getConstructor(Context.class).newInstance(this.f5675b);
                this.f5680g.put(Integer.valueOf(cls.hashCode()), customPlatformNewInstance);
                synchronized (this.f5678e) {
                    synchronized (this.f5679f) {
                        if (customPlatformNewInstance != null) {
                            try {
                                if (customPlatformNewInstance.m5933b()) {
                                    this.f5679f.put(Integer.valueOf(customPlatformNewInstance.getPlatformId()), customPlatformNewInstance.getName());
                                    this.f5678e.put(customPlatformNewInstance.getName(), Integer.valueOf(customPlatformNewInstance.getPlatformId()));
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                C0851d.m6195a().m8622w(th2);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public void m6176e(Class<? extends CustomPlatform> cls) {
        int iHashCode = cls.hashCode();
        synchronized (this.f5680g) {
            this.f5680g.remove(Integer.valueOf(iHashCode));
        }
    }

    /* JADX INFO: renamed from: a */
    public Platform m6148a(String str) {
        Platform[] platformArrM6161a;
        if (str == null || (platformArrM6161a = m6161a()) == null) {
            return null;
        }
        for (Platform platform : platformArrM6161a) {
            if (str.equals(platform.getName())) {
                return platform;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public Platform[] m6161a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f5677d) {
            if (this.f5674a == a.IDLE) {
                return null;
            }
            if (this.f5674a == a.INITIALIZING) {
                try {
                    this.f5677d.wait();
                } catch (Throwable th) {
                    C0851d.m6195a().m8622w(th);
                }
            }
            ArrayList<Platform> arrayList = new ArrayList<>();
            for (Platform platform : this.f5677d) {
                if (platform != null && platform.m5933b()) {
                    platform.m5932a();
                    arrayList.add(platform);
                }
            }
            new C0846e(this.f5675b, this.f5683j).m6136a(arrayList);
            Iterator<Map.Entry<Integer, CustomPlatform>> it = this.f5680g.entrySet().iterator();
            while (it.hasNext()) {
                CustomPlatform value = it.next().getValue();
                if (value != null && value.m5933b()) {
                    arrayList.add(value);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            Platform[] platformArr = new Platform[arrayList.size()];
            for (int i = 0; i < platformArr.length; i++) {
                platformArr[i] = arrayList.get(i);
            }
            C0851d.m6195a().m8615i("sort list use time: %s", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            return platformArr;
        }
    }

    /* JADX INFO: renamed from: b */
    public String m6163b() {
        try {
            return new C0846e(this.f5675b, this.f5683j).m6139c();
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
            return "2.8.0";
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6152a(int i) {
        NetworkHelper.connectionTimeout = i;
    }

    /* JADX INFO: renamed from: b */
    public void m6165b(int i) {
        NetworkHelper.readTimout = i;
    }

    /* JADX INFO: renamed from: b */
    public void m6167b(boolean z) {
        this.f5686m = z;
    }

    /* JADX INFO: renamed from: c */
    public boolean m6172c() {
        return this.f5686m;
    }

    /* JADX INFO: renamed from: a */
    public void m6154a(int i, Platform platform) {
        new C0846e(this.f5675b, this.f5683j).m6132a(i, platform);
    }

    /* JADX INFO: renamed from: a */
    public void m6156a(String str, int i) {
        new C0846e(this.f5675b, this.f5683j).m6135a(str, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[Catch: all -> 0x007c, TryCatch #2 {, blocks: (B:19:0x0045, B:21:0x004b, B:25:0x0059, B:26:0x005f, B:28:0x0065, B:30:0x006d, B:32:0x0077, B:33:0x007a, B:24:0x0052), top: B:47:0x0045, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x007a A[EDGE_INSN: B:56:0x007a->B:33:0x007a BREAK  A[LOOP:1: B:26:0x005f->B:59:0x005f], SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m6158a(java.lang.String r5, java.util.HashMap<java.lang.String, java.lang.Object> r6) {
        /*
            r4 = this;
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> r0 = r4.f5676c
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> r1 = r4.f5676c     // Catch: java.lang.Throwable -> L82
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L82
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch: java.lang.Throwable -> L82
            if (r1 != 0) goto L12
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L82
            r1.<init>()     // Catch: java.lang.Throwable -> L82
        L12:
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L82
            java.util.Set r6 = r6.entrySet()     // Catch: java.lang.Throwable -> L7f
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L7f
        L1b:
            boolean r2 = r6.hasNext()     // Catch: java.lang.Throwable -> L7f
            if (r2 == 0) goto L3b
            java.lang.Object r2 = r6.next()     // Catch: java.lang.Throwable -> L7f
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r3 = r2.getKey()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> L7f
            if (r2 == 0) goto L1b
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L7f
            r1.put(r3, r2)     // Catch: java.lang.Throwable -> L7f
            goto L1b
        L3b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L7f
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> r6 = r4.f5676c     // Catch: java.lang.Throwable -> L82
            r6.put(r5, r1)     // Catch: java.lang.Throwable -> L82
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            java.util.ArrayList<cn.sharesdk.framework.Platform> r6 = r4.f5677d
            monitor-enter(r6)
            cn.sharesdk.framework.f$a r0 = r4.f5674a     // Catch: java.lang.Throwable -> L7c
            cn.sharesdk.framework.f$a r1 = cn.sharesdk.framework.C0847f.a.INITIALIZING     // Catch: java.lang.Throwable -> L7c
            if (r0 != r1) goto L59
            java.util.ArrayList<cn.sharesdk.framework.Platform> r0 = r4.f5677d     // Catch: java.lang.Throwable -> L51 java.lang.Throwable -> L7c
            r0.wait()     // Catch: java.lang.Throwable -> L51 java.lang.Throwable -> L7c
            goto L59
        L51:
            r0 = move-exception
            com.mob.tools.log.NLog r1 = cn.sharesdk.framework.utils.C0851d.m6195a()     // Catch: java.lang.Throwable -> L7c
            r1.m8622w(r0)     // Catch: java.lang.Throwable -> L7c
        L59:
            java.util.ArrayList<cn.sharesdk.framework.Platform> r0 = r4.f5677d     // Catch: java.lang.Throwable -> L7c
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L7c
        L5f:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L7a
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L7c
            cn.sharesdk.framework.Platform r1 = (cn.sharesdk.framework.Platform) r1     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L5f
            java.lang.String r2 = r1.getName()     // Catch: java.lang.Throwable -> L7c
            boolean r2 = r2.equals(r5)     // Catch: java.lang.Throwable -> L7c
            if (r2 == 0) goto L5f
            r1.m5932a()     // Catch: java.lang.Throwable -> L7c
        L7a:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7c
            return
        L7c:
            r5 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L7c
            throw r5
        L7f:
            r5 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L7f
            throw r5     // Catch: java.lang.Throwable -> L82
        L82:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.C0847f.m6158a(java.lang.String, java.util.HashMap):void");
    }

    /* JADX INFO: renamed from: c */
    public String m6170c(int i) {
        String str;
        synchronized (this.f5679f) {
            str = this.f5679f.get(Integer.valueOf(i));
        }
        return str;
    }

    /* JADX INFO: renamed from: b */
    public int m6162b(String str) {
        synchronized (this.f5678e) {
            if (!this.f5678e.containsKey(str)) {
                return 0;
            }
            return this.f5678e.get(str).intValue();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6157a(String str, String str2) {
        synchronized (this.f5676c) {
            this.f5676c.put(str2, this.f5676c.get(str));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6153a(int i, int i2) {
        synchronized (this.f5681h) {
            new C0846e(this.f5675b, this.f5683j).m6131a(i, i2, this.f5681h);
        }
    }

    /* JADX INFO: renamed from: b */
    public String m6164b(String str, String str2) {
        synchronized (this.f5676c) {
            HashMap<String, String> map = this.f5676c.get(str);
            if (map == null) {
                return null;
            }
            return map.get(str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m6149a(int i, String str) {
        String strM6126a;
        synchronized (this.f5681h) {
            strM6126a = new C0846e(this.f5675b, this.f5683j).m6126a(i, str, this.f5681h);
        }
        return strM6126a;
    }

    /* JADX INFO: renamed from: d */
    public boolean m6174d() {
        synchronized (this.f5681h) {
            if (this.f5681h != null && this.f5681h.size() > 0) {
                return true;
            }
            return this.f5687n;
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [cn.sharesdk.framework.f$2] */
    /* JADX INFO: renamed from: a */
    public boolean m6160a(HashMap<String, Object> map) {
        if (a.READY != this.f5674a) {
            C0851d.m6195a().m8609d("Statistics module unopened", new Object[0]);
            return false;
        }
        final C0828a c0828aM5995a = C0828a.m5995a(this.f5675b, this.f5683j);
        boolean zM6141a = m6141a(c0828aM5995a, c0828aM5995a.m6014d(), map);
        if (zM6141a) {
            this.f5687n = true;
            new Thread() { // from class: cn.sharesdk.framework.f.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        HashMap<String, Object> mapM6015e = c0828aM5995a.m6015e();
                        HashMap<String, Object> map2 = new HashMap<>();
                        if (C0847f.this.m6141a(c0828aM5995a, mapM6015e, map2)) {
                            C0847f.this.m6168b(map2);
                        }
                        c0828aM5995a.m6009a(mapM6015e);
                    } catch (Throwable th) {
                        C0851d.m6195a().m8622w(th);
                    }
                }
            }.start();
            return zM6141a;
        }
        try {
            HashMap<String, Object> mapM6015e = c0828aM5995a.m6015e();
            boolean zM6141a2 = m6141a(c0828aM5995a, mapM6015e, map);
            if (zM6141a2) {
                try {
                    c0828aM5995a.m6009a(mapM6015e);
                } catch (Throwable th) {
                    th = th;
                    zM6141a = zM6141a2;
                    C0851d.m6195a().m8622w(th);
                    this.f5687n = false;
                    return zM6141a;
                }
            }
            this.f5687n = true;
            return zM6141a2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m6141a(C0828a c0828a, HashMap<String, Object> map, HashMap<String, Object> map2) {
        try {
            if (map.containsKey("error")) {
                C0851d.m6195a().m8615i("ShareSDK parse sns config ==>>", new Hashon().fromHashMap(map));
                return false;
            }
            if (!map.containsKey("res")) {
                C0851d.m6195a().m8609d("ShareSDK platform config result ==>>", "SNS configuration is empty");
                return false;
            }
            String str = (String) map.get("res");
            if (str == null) {
                return false;
            }
            map2.putAll(c0828a.m6011b(str));
            return true;
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m6168b(HashMap<String, Object> map) {
        boolean zM6137a;
        synchronized (this.f5681h) {
            this.f5681h.clear();
            zM6137a = new C0846e(this.f5675b, this.f5683j).m6137a(map, this.f5681h);
        }
        return zM6137a;
    }

    /* JADX INFO: renamed from: a */
    public String m6151a(String str, boolean z, int i, String str2) {
        return a.READY != this.f5674a ? str : new C0846e(this.f5675b, this.f5683j).m6129a(str, z, i, str2);
    }

    /* JADX INFO: renamed from: c */
    public String m6171c(String str) {
        if (a.READY != this.f5674a) {
            return null;
        }
        return new C0846e(this.f5675b, this.f5683j).m6128a(str);
    }

    /* JADX INFO: renamed from: a */
    public String m6150a(Bitmap bitmap) {
        if (a.READY != this.f5674a) {
            return null;
        }
        return new C0846e(this.f5675b, this.f5683j).m6127a(bitmap);
    }

    /* JADX INFO: renamed from: e */
    public void m6175e() {
        try {
            ResHelper.clearCache(this.f5675b);
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
        }
    }
}
