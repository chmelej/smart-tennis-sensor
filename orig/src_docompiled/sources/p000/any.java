package p000;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: RouteSelector.java */
/* JADX INFO: loaded from: classes.dex */
public final class any {

    /* JADX INFO: renamed from: a */
    private final amf f4296a;

    /* JADX INFO: renamed from: b */
    private final anw f4297b;

    /* JADX INFO: renamed from: c */
    private final amj f4298c;

    /* JADX INFO: renamed from: d */
    private final amv f4299d;

    /* JADX INFO: renamed from: f */
    private int f4301f;

    /* JADX INFO: renamed from: e */
    private List<Proxy> f4300e = Collections.emptyList();

    /* JADX INFO: renamed from: g */
    private List<InetSocketAddress> f4302g = Collections.emptyList();

    /* JADX INFO: renamed from: h */
    private final List<ani> f4303h = new ArrayList();

    public any(amf amfVar, anw anwVar, amj amjVar, amv amvVar) {
        this.f4296a = amfVar;
        this.f4297b = anwVar;
        this.f4298c = amjVar;
        this.f4299d = amvVar;
        m4581a(amfVar.m1935a(), amfVar.m1943h());
    }

    /* JADX INFO: renamed from: a */
    public boolean m4586a() {
        return m4583c() || !this.f4303h.isEmpty();
    }

    /* JADX INFO: renamed from: b */
    public C0677a m4587b() throws SocketException, UnknownHostException {
        if (!m4586a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (m4583c()) {
            Proxy proxyM4584d = m4584d();
            int size = this.f4302g.size();
            for (int i = 0; i < size; i++) {
                ani aniVar = new ani(this.f4296a, proxyM4584d, this.f4302g.get(i));
                if (this.f4297b.m4576c(aniVar)) {
                    this.f4303h.add(aniVar);
                } else {
                    arrayList.add(aniVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f4303h);
            this.f4303h.clear();
        }
        return new C0677a(arrayList);
    }

    /* JADX INFO: renamed from: a */
    public void m4585a(ani aniVar, IOException iOException) {
        if (aniVar.m4484b().type() != Proxy.Type.DIRECT && this.f4296a.m1942g() != null) {
            this.f4296a.m1942g().connectFailed(this.f4296a.m1935a().m2078a(), aniVar.m4484b().address(), iOException);
        }
        this.f4297b.m4574a(aniVar);
    }

    /* JADX INFO: renamed from: a */
    private void m4581a(amy amyVar, Proxy proxy) {
        List<Proxy> listM4501a;
        if (proxy != null) {
            this.f4300e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f4296a.m1942g().select(amyVar.m2078a());
            if (listSelect != null && !listSelect.isEmpty()) {
                listM4501a = anm.m4500a(listSelect);
            } else {
                listM4501a = anm.m4501a(Proxy.NO_PROXY);
            }
            this.f4300e = listM4501a;
        }
        this.f4301f = 0;
    }

    /* JADX INFO: renamed from: c */
    private boolean m4583c() {
        return this.f4301f < this.f4300e.size();
    }

    /* JADX INFO: renamed from: d */
    private Proxy m4584d() throws SocketException, UnknownHostException {
        if (!m4583c()) {
            throw new SocketException("No route to " + this.f4296a.m1935a().m2085f() + "; exhausted proxy configurations: " + this.f4300e);
        }
        List<Proxy> list = this.f4300e;
        int i = this.f4301f;
        this.f4301f = i + 1;
        Proxy proxy = list.get(i);
        m4582a(proxy);
        return proxy;
    }

    /* JADX INFO: renamed from: a */
    private void m4582a(Proxy proxy) throws SocketException, UnknownHostException {
        String strM2085f;
        int iM2086g;
        this.f4302g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strM2085f = this.f4296a.m1935a().m2085f();
            iM2086g = this.f4296a.m1935a().m2086g();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strM2085f = m4580a(inetSocketAddress);
            iM2086g = inetSocketAddress.getPort();
        }
        if (iM2086g < 1 || iM2086g > 65535) {
            throw new SocketException("No route to " + strM2085f + ":" + iM2086g + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f4302g.add(InetSocketAddress.createUnresolved(strM2085f, iM2086g));
            return;
        }
        this.f4299d.m2034a(this.f4298c, strM2085f);
        List<InetAddress> listMo2025a = this.f4296a.m1937b().mo2025a(strM2085f);
        if (listMo2025a.isEmpty()) {
            throw new UnknownHostException(this.f4296a.m1937b() + " returned no addresses for " + strM2085f);
        }
        this.f4299d.m2035a(this.f4298c, strM2085f, listMo2025a);
        int size = listMo2025a.size();
        for (int i = 0; i < size; i++) {
            this.f4302g.add(new InetSocketAddress(listMo2025a.get(i), iM2086g));
        }
    }

    /* JADX INFO: renamed from: a */
    static String m4580a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* JADX INFO: renamed from: any$a */
    /* JADX INFO: compiled from: RouteSelector.java */
    public static final class C0677a {

        /* JADX INFO: renamed from: a */
        private final List<ani> f4304a;

        /* JADX INFO: renamed from: b */
        private int f4305b = 0;

        C0677a(List<ani> list) {
            this.f4304a = list;
        }

        /* JADX INFO: renamed from: a */
        public boolean m4588a() {
            return this.f4305b < this.f4304a.size();
        }

        /* JADX INFO: renamed from: b */
        public ani m4589b() {
            if (!m4588a()) {
                throw new NoSuchElementException();
            }
            List<ani> list = this.f4304a;
            int i = this.f4305b;
            this.f4305b = i + 1;
            return list.get(i);
        }

        /* JADX INFO: renamed from: c */
        public List<ani> m4590c() {
            return new ArrayList(this.f4304a);
        }
    }
}
