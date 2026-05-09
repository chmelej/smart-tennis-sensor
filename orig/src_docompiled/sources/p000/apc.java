package p000;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: AndroidPlatform.java */
/* JADX INFO: loaded from: classes.dex */
class apc extends aph {

    /* JADX INFO: renamed from: a */
    private final Class<?> f4560a;

    /* JADX INFO: renamed from: b */
    private final apg<Socket> f4561b;

    /* JADX INFO: renamed from: c */
    private final apg<Socket> f4562c;

    /* JADX INFO: renamed from: d */
    private final apg<Socket> f4563d;

    /* JADX INFO: renamed from: e */
    private final apg<Socket> f4564e;

    /* JADX INFO: renamed from: f */
    private final C0713c f4565f = C0713c.m4834a();

    apc(Class<?> cls, apg<Socket> apgVar, apg<Socket> apgVar2, apg<Socket> apgVar3, apg<Socket> apgVar4) {
        this.f4560a = cls;
        this.f4561b = apgVar;
        this.f4562c = apgVar2;
        this.f4563d = apgVar3;
        this.f4564e = apgVar4;
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public void mo4827a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!anm.m4509a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public void mo4828a(SSLSocket sSLSocket, String str, List<anc> list) {
        if (str != null) {
            this.f4561b.m4847b(sSLSocket, true);
            this.f4562c.m4847b(sSLSocket, str);
        }
        if (this.f4564e == null || !this.f4564e.m4846a(sSLSocket)) {
            return;
        }
        this.f4564e.m4849d(sSLSocket, m4852b(list));
    }

    @Override // p000.aph
    @Nullable
    /* JADX INFO: renamed from: a */
    public String mo4824a(SSLSocket sSLSocket) {
        byte[] bArr;
        if (this.f4563d == null || !this.f4563d.m4846a(sSLSocket) || (bArr = (byte[]) this.f4563d.m4849d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, anm.f4211e);
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public void mo4825a(int i, String str, Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public Object mo4823a(String str) {
        return this.f4565f.m4835a(str);
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public void mo4826a(String str, Object obj) {
        if (this.f4565f.m4836a(obj)) {
            return;
        }
        mo4825a(5, str, (Throwable) null);
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: b */
    public boolean mo4831b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m4819a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo4831b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw anm.m4495a("unable to determine cleartext support", e);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m4819a(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return m4820b(str, cls, obj);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m4820b(String str, Class<?> cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo4831b(str);
        }
    }

    /* JADX INFO: renamed from: e */
    private static boolean m4821e() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public apl mo4822a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0711a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.mo4822a(x509TrustManager);
        }
    }

    /* JADX INFO: renamed from: a */
    public static aph m4818a() {
        Class<?> cls;
        apg apgVar;
        apg apgVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            apg apgVar3 = new apg(null, "setUseSessionTickets", Boolean.TYPE);
            apg apgVar4 = new apg(null, "setHostname", String.class);
            if (m4821e()) {
                apg apgVar5 = new apg(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                apgVar2 = new apg(null, "setAlpnProtocols", byte[].class);
                apgVar = apgVar5;
            } else {
                apgVar = null;
                apgVar2 = null;
            }
            return new apc(cls2, apgVar3, apgVar4, apgVar, apgVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: b */
    public apn mo4829b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new C0712b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo4829b(x509TrustManager);
        }
    }

    /* JADX INFO: renamed from: apc$a */
    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class C0711a extends apl {

        /* JADX INFO: renamed from: a */
        private final Object f4566a;

        /* JADX INFO: renamed from: b */
        private final Method f4567b;

        public int hashCode() {
            return 0;
        }

        C0711a(Object obj, Method method) {
            this.f4566a = obj;
            this.f4567b = method;
        }

        @Override // p000.apl
        /* JADX INFO: renamed from: a */
        public List<Certificate> mo4832a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f4567b.invoke(this.f4566a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0711a;
        }
    }

    /* JADX INFO: renamed from: apc$c */
    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class C0713c {

        /* JADX INFO: renamed from: a */
        private final Method f4570a;

        /* JADX INFO: renamed from: b */
        private final Method f4571b;

        /* JADX INFO: renamed from: c */
        private final Method f4572c;

        C0713c(Method method, Method method2, Method method3) {
            this.f4570a = method;
            this.f4571b = method2;
            this.f4572c = method3;
        }

        /* JADX INFO: renamed from: a */
        Object m4835a(String str) {
            if (this.f4570a != null) {
                try {
                    Object objInvoke = this.f4570a.invoke(null, new Object[0]);
                    this.f4571b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        boolean m4836a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f4572c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX INFO: renamed from: a */
        static C0713c m4834a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new C0713c(method3, method2, method);
        }
    }

    /* JADX INFO: renamed from: apc$b */
    /* JADX INFO: compiled from: AndroidPlatform.java */
    static final class C0712b implements apn {

        /* JADX INFO: renamed from: a */
        private final X509TrustManager f4568a;

        /* JADX INFO: renamed from: b */
        private final Method f4569b;

        C0712b(X509TrustManager x509TrustManager, Method method) {
            this.f4569b = method;
            this.f4568a = x509TrustManager;
        }

        @Override // p000.apn
        /* JADX INFO: renamed from: a */
        public X509Certificate mo4833a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f4569b.invoke(this.f4568a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw anm.m4495a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0712b)) {
                return false;
            }
            C0712b c0712b = (C0712b) obj;
            return this.f4568a.equals(c0712b.f4568a) && this.f4569b.equals(c0712b.f4569b);
        }

        public int hashCode() {
            return this.f4568a.hashCode() + (this.f4569b.hashCode() * 31);
        }
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: b */
    public SSLContext mo4830b() {
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 22) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }
}
