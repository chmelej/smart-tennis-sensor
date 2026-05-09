package p000;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: JdkWithJettyBootPlatform.java */
/* JADX INFO: loaded from: classes.dex */
class apf extends aph {

    /* JADX INFO: renamed from: a */
    private final Method f4575a;

    /* JADX INFO: renamed from: b */
    private final Method f4576b;

    /* JADX INFO: renamed from: c */
    private final Method f4577c;

    /* JADX INFO: renamed from: d */
    private final Class<?> f4578d;

    /* JADX INFO: renamed from: e */
    private final Class<?> f4579e;

    apf(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f4575a = method;
        this.f4576b = method2;
        this.f4577c = method3;
        this.f4578d = cls;
        this.f4579e = cls2;
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public void mo4828a(SSLSocket sSLSocket, String str, List<anc> list) {
        try {
            this.f4575a.invoke(null, sSLSocket, Proxy.newProxyInstance(aph.class.getClassLoader(), new Class[]{this.f4578d, this.f4579e}, new C0714a(m4851a(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw anm.m4495a("unable to set alpn", (Exception) e);
        }
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: b */
    public void mo4842b(SSLSocket sSLSocket) {
        try {
            this.f4577c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw anm.m4495a("unable to remove alpn", (Exception) e);
        }
    }

    @Override // p000.aph
    @Nullable
    /* JADX INFO: renamed from: a */
    public String mo4824a(SSLSocket sSLSocket) {
        try {
            C0714a c0714a = (C0714a) Proxy.getInvocationHandler(this.f4576b.invoke(null, sSLSocket));
            if (!c0714a.f4580a && c0714a.f4581b == null) {
                aph.m4853c().mo4825a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (c0714a.f4580a) {
                return null;
            }
            return c0714a.f4581b;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw anm.m4495a("unable to get selected protocol", (Exception) e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static aph m4841a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new apf(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: apf$a */
    /* JADX INFO: compiled from: JdkWithJettyBootPlatform.java */
    static class C0714a implements InvocationHandler {

        /* JADX INFO: renamed from: a */
        boolean f4580a;

        /* JADX INFO: renamed from: b */
        String f4581b;

        /* JADX INFO: renamed from: c */
        private final List<String> f4582c;

        C0714a(List<String> list) {
            this.f4582c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = anm.f4208b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f4580a = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f4582c;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.f4582c.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.f4581b = str;
                        return str;
                    }
                }
                String str2 = this.f4582c.get(0);
                this.f4581b = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.f4581b = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
