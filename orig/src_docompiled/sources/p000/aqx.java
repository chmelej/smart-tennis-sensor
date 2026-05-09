package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import org.android.spdy.TnetStatusCode;

/* JADX INFO: compiled from: SpdyChannel.java */
/* JADX INFO: loaded from: classes.dex */
public class aqx implements aqq, Spdycb {

    /* JADX INFO: renamed from: b */
    protected volatile Context f4785b;

    /* JADX INFO: renamed from: c */
    private volatile SpdyAgent f4786c;

    /* JADX INFO: renamed from: e */
    private volatile String f4788e;

    /* JADX INFO: renamed from: f */
    private volatile aqs f4789f;

    /* JADX INFO: renamed from: i */
    private AtomicBoolean f4792i;

    /* JADX INFO: renamed from: k */
    private volatile URL f4794k;

    /* JADX INFO: renamed from: d */
    private volatile SpdySession f4787d = null;

    /* JADX INFO: renamed from: g */
    private volatile Map<String, C0738a> f4790g = new HashMap();

    /* JADX INFO: renamed from: h */
    private volatile Map<String, WeakReference<aqr>> f4791h = new HashMap();

    /* JADX INFO: renamed from: j */
    private volatile long f4793j = -1;

    /* JADX INFO: renamed from: l */
    private volatile Object f4795l = null;

    /* JADX INFO: renamed from: a */
    protected volatile aqn f4784a = aqn.DISCONNECTED;

    /* JADX INFO: renamed from: m */
    private volatile long f4796m = -1;

    /* JADX INFO: renamed from: n */
    private volatile long f4797n = -1;

    /* JADX INFO: renamed from: o */
    private final SessionCb f4798o = new SessionCb() { // from class: aqx.2
        @Override // org.android.spdy.SessionCb
        public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
            aqx.this.f4793j = superviseConnectInfo.connectTime;
            aiv.m1418c("SpdyClient", "connect connect_time[" + superviseConnectInfo.connectTime + "] ");
        }

        @Override // org.android.spdy.SessionCb
        public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
            String str = (String) obj;
            if (TextUtils.equals(aqx.this.f4788e, str)) {
                aiv.m1418c("SpdyClient", "spdySessionFailedError[" + i + "][" + obj + "]");
                aqx.this.f4784a = aqn.DISCONNECTING;
                aqx.this.m5173g();
                try {
                    aqx.this.m5162a(aqx.this.f4785b, Integer.toString(i), str);
                    aqx.this.m5163a(aql.m5025a(i), new HashMap(), (Throwable) null);
                } catch (Throwable unused) {
                }
                aqx.this.f4784a = aqn.DISCONNECTED;
            }
        }

        @Override // org.android.spdy.SessionCb
        public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
            try {
                aiv.m1418c("SpdyClient", "spdyPingRecvCallback[" + j + "]");
                if (aqx.this.f4797n == j) {
                    return;
                }
                aqx.this.f4797n = j;
                aqx.this.f4789f.mo1229a(aqx.this.f4795l, j);
            } catch (Throwable unused) {
                aqx.this.m5163a(aql.SPDY_PING_THROWABLE, new HashMap(), (Throwable) null);
            }
        }

        @Override // org.android.spdy.SessionCb
        public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
            if (TextUtils.equals(aqx.this.f4788e, (String) obj)) {
                aqx.this.f4784a = aqn.DISCONNECTING;
                try {
                    aqx.this.f4789f.mo1233b(aqx.this.f4795l, aqx.this.f4796m);
                } catch (Throwable unused) {
                }
                aqx.this.f4784a = aqn.DISCONNECTED;
            }
        }
    };

    @Override // org.android.spdy.Spdycb
    public final void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
    }

    @Override // org.android.spdy.Spdycb
    @Deprecated
    public final void spdyRequestRecvCallback(SpdySession spdySession, long j, Object obj) {
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
    }

    public aqx() {
        this.f4786c = null;
        try {
            this.f4792i = new AtomicBoolean(false);
            this.f4786c = SpdyAgent.getInstance(this.f4785b, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        } catch (UnsatisfiedLinkError e) {
            m5163a(aql.SPDY_INIT_NOT_FOUND_SO, new HashMap(), e);
        } catch (Throwable th) {
            m5163a(aql.SPDY_INIT_THROWABLE, new HashMap(), th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m5174a(boolean z) {
        this.f4792i.set(z);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m5176f() {
        return this.f4792i.get();
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: a */
    public final void mo5116a(Object obj, Context context, String str, Map<String, String> map, long j, aqs aqsVar, String str2) {
        if (obj == null || TextUtils.isEmpty(str) || aqsVar == null) {
            throw new NullPointerException("connectContext==null||url==null || eventHandler==null");
        }
        this.f4785b = context;
        this.f4795l = obj;
        m5174a(true);
        this.f4789f = aqsVar;
        try {
            SharedPreferences.Editor editorEdit = this.f4785b.getSharedPreferences("AppStore", 4).edit();
            editorEdit.putString("agoo_connect_type", "spdy");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
        try {
            m5166a(str, map);
            this.f4784a = aqn.CONNECTING;
            if (this.f4786c != null) {
                this.f4788e = str;
                this.f4794k = new URL(str);
                SpdyRequest spdyRequest = new SpdyRequest(this.f4794k, SpdyRequest.GET_METHOD, RequestPriority.DEFAULT_PRIORITY);
                if (map != null && map.size() > 0) {
                    spdyRequest.addHeaders(map);
                }
                this.f4787d = this.f4786c.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), this.f4788e, this.f4788e, this, this.f4798o, 2);
            }
        } catch (UnsatisfiedLinkError e) {
            m5163a(aql.SPDY_INIT_NOT_FOUND_SO, new HashMap(), e);
        } catch (Throwable th) {
            m5163a(aql.SPDY_CONNECT_THROWABLE, new HashMap(), th);
        }
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: b */
    public final long mo5117b() {
        int iSubmitPing = -1;
        try {
            if (this.f4787d != null) {
                iSubmitPing = this.f4787d.submitPing();
            }
        } catch (Throwable th) {
            m5163a(aql.SPDY_PING_THROWABLE, new HashMap(), th);
        }
        return iSubmitPing;
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: a */
    public final int mo5114a(String str, byte[] bArr, aqr aqrVar) {
        SpdyDataProvider spdyDataProvider;
        int iHashCode;
        try {
            if (this.f4784a != aqn.OPEN || this.f4787d == null || this.f4794k == null || TextUtils.isEmpty(str)) {
                return -1;
            }
            String str2 = String.format("http://%s:%d%s", this.f4794k.getHost(), Integer.valueOf(this.f4794k.getPort()), str);
            aiv.m1418c("SpdyClient", "send[baseUrl:" + str2 + "]");
            SpdyRequest spdyRequest = new SpdyRequest(new URL(str2), SpdyRequest.POST_METHOD, RequestPriority.DEFAULT_PRIORITY);
            if (bArr == null || bArr.length <= 0) {
                spdyDataProvider = null;
                iHashCode = 0;
            } else {
                spdyDataProvider = new SpdyDataProvider(bArr);
                iHashCode = Arrays.hashCode(bArr);
            }
            String str3 = String.format("%s_%d", str2, Integer.valueOf(iHashCode));
            if (aqrVar != null) {
                this.f4791h.put(str3, new WeakReference<>(aqrVar));
            }
            return this.f4787d.submitRequest(spdyRequest, spdyDataProvider, str3, this);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public final void m5173g() {
        if (this.f4787d != null) {
            try {
                aiv.m1420d("SpdyClient", "session.streamReset(" + this.f4796m + ")");
                this.f4787d.streamReset(this.f4796m, TnetStatusCode.EASY_SPDY_CANCEL);
            } catch (Throwable unused) {
            }
            try {
                aiv.m1420d("SpdyClient", "session.close()");
                this.f4787d.closeSession();
            } catch (Throwable th) {
                aiv.m1419c("SpdyClient", "disconnect", th);
            }
            this.f4787d = null;
        }
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: a */
    public final void mo5115a() {
        this.f4784a = aqn.DISCONNECTING;
        m5173g();
        m5174a(false);
        this.f4784a = aqn.DISCONNECTED;
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: c */
    public final void mo5118c() {
        try {
            if (this.f4786c != null) {
                aiv.m1420d("SpdyClient", "closing");
                m5173g();
                this.f4786c.close();
                this.f4786c = null;
                aiv.m1420d("SpdyClient", "closed");
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: d */
    public final void mo5119d() {
        aiv.m1420d("SpdyClient", "shutdown.....");
        aif.m1311a(new Runnable() { // from class: aqx.1
            @Override // java.lang.Runnable
            public void run() {
                aiv.m1420d("SpdyClient", "shutdown");
                aqx.this.mo5118c();
            }
        });
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: e */
    public final aqn mo5120e() {
        return this.f4784a;
    }

    @Override // org.android.spdy.Spdycb
    public final void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        WeakReference<aqr> weakReference;
        aqr aqrVar;
        C0738a c0738a;
        try {
            String str = (String) obj;
            if (TextUtils.isEmpty(str) || (weakReference = this.f4791h.get(str)) == null || (aqrVar = weakReference.get()) == null || (c0738a = this.f4790g.get(str)) == null) {
                return;
            }
            aqrVar.mo1234a(this.f4795l, str, c0738a.m5179b(), c0738a.m5180c(), c0738a.m5178a());
            this.f4791h.remove(str);
            this.f4790g.remove(str);
        } catch (Throwable th) {
            aiv.m1421d("SpdyClient", "spdyDataRecvCallback", th);
        }
    }

    @Override // org.android.spdy.Spdycb
    public final void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, byte[] bArr, int i, Object obj) {
        try {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (bArr == null) {
                Log.d("SpdyClient", "spdyDataChunkRecvCB,data=null,streamId=" + j);
            }
            Log.d("SpdyClient", "spdyDataChunkRecvCB,data=" + bArr);
            if (TextUtils.equals(str, this.f4788e)) {
                if (m5176f()) {
                    this.f4789f.mo1232a(this.f4795l, j, str, bArr);
                }
            } else {
                C0738a c0738a = this.f4790g.get(str);
                if (c0738a != null) {
                    c0738a.m5177a(bArr);
                    this.f4790g.put(str, c0738a);
                }
            }
        } catch (Throwable th) {
            m5163a(aql.SPDY_DATACHUNK_THROWABLE, new HashMap(), th);
        }
    }

    @Override // org.android.spdy.Spdycb
    public final void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
        Map<String, String> mapM5161a = m5161a(map);
        try {
            String str = (String) obj;
            int i = mapM5161a.get(":status") != null ? Integer.parseInt(mapM5161a.get(":status")) : -1;
            aiv.m1418c("SpdyClient", "spdyOnStreamResponse PATH[" + str + "][" + i + "]");
            if (m5175a(str)) {
                this.f4796m = j;
                if (i == 200) {
                    this.f4784a = aqn.OPEN;
                    this.f4789f.mo1230a(this.f4795l, j, this.f4793j, mapM5161a);
                } else {
                    m5163a(aql.m5026b(i), mapM5161a, new Throwable("http httpStatusCode[" + str + "]==" + i));
                }
                map.remove(":status");
                return;
            }
            C0738a c0738a = this.f4790g.get(str);
            if (c0738a == null) {
                c0738a = new C0738a(i, mapM5161a);
            }
            this.f4790g.put(str, c0738a);
        } catch (Throwable th) {
            m5163a(aql.SPDY_STREAM_RESPONSE_THROWABLE, mapM5161a, th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m5175a(String str) {
        return TextUtils.equals(this.f4788e, str);
    }

    /* JADX INFO: renamed from: a */
    private final void m5166a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            aiv.m1418c("SpdyClient", "connect url[" + str + "]");
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        aiv.m1418c("SpdyClient", "header--->[" + key + ":" + value + "]");
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final Map<String, String> m5161a(Map<String, List<String>> map) {
        HashMap map2 = new HashMap();
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String strM5160a = m5160a(entry.getValue());
                    if (!TextUtils.isEmpty(strM5160a)) {
                        if (!key.startsWith(":")) {
                            key = key.toLowerCase();
                        }
                        map2.put(key, strM5160a);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return map2;
    }

    /* JADX INFO: renamed from: a */
    private final String m5160a(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(list.get(i));
            if (i < size - 1) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5162a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("AppStore", 4).edit();
            editorEdit.putString("agoo_push_errorid", str);
            editorEdit.putString("agoo_push_path", str2);
            editorEdit.putString("agoo_connect_type", "spdy");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: aqx$a */
    /* JADX INFO: compiled from: SpdyChannel.java */
    class C0738a {

        /* JADX INFO: renamed from: b */
        private int f4802b;

        /* JADX INFO: renamed from: c */
        private Map<String, String> f4803c;

        /* JADX INFO: renamed from: d */
        private ByteArrayOutputStream f4804d;

        public C0738a(int i, Map<String, String> map) {
            this.f4804d = null;
            this.f4802b = i;
            this.f4803c = map;
            this.f4804d = new ByteArrayOutputStream();
        }

        /* JADX INFO: renamed from: a */
        public void m5177a(byte[] bArr) {
            this.f4804d.write(bArr);
        }

        /* JADX INFO: renamed from: a */
        public byte[] m5178a() {
            try {
                return this.f4804d.toByteArray();
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX INFO: renamed from: b */
        public int m5179b() {
            return this.f4802b;
        }

        /* JADX INFO: renamed from: c */
        public Map<String, String> m5180c() {
            return this.f4803c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m5163a(aql aqlVar, Map<String, String> map, Throwable th) {
        if (this.f4789f == null || !m5176f()) {
            return;
        }
        m5174a(false);
        this.f4784a = aqn.DISCONNECTED;
        this.f4789f.mo1231a(this.f4795l, this.f4796m, aqlVar, map, th);
    }
}
