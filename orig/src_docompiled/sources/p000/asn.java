package p000;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SubscriberMethodFinder.java */
/* JADX INFO: loaded from: classes.dex */
class asn {

    /* JADX INFO: renamed from: a */
    private static final Map<Class<?>, List<asm>> f4974a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e */
    private static final C0748a[] f4975e = new C0748a[4];

    /* JADX INFO: renamed from: b */
    private List<asr> f4976b;

    /* JADX INFO: renamed from: c */
    private final boolean f4977c;

    /* JADX INFO: renamed from: d */
    private final boolean f4978d;

    asn(List<asr> list, boolean z, boolean z2) {
        this.f4976b = list;
        this.f4977c = z;
        this.f4978d = z2;
    }

    /* JADX INFO: renamed from: a */
    List<asm> m5356a(Class<?> cls) {
        List<asm> listM5353b;
        List<asm> list = f4974a.get(cls);
        if (list != null) {
            return list;
        }
        if (this.f4978d) {
            listM5353b = m5354c(cls);
        } else {
            listM5353b = m5353b(cls);
        }
        if (listM5353b.isEmpty()) {
            throw new asf("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
        }
        f4974a.put(cls, listM5353b);
        return listM5353b;
    }

    /* JADX INFO: renamed from: b */
    private List<asm> m5353b(Class<?> cls) {
        C0748a c0748aM5350a = m5350a();
        c0748aM5350a.m5359a(cls);
        while (c0748aM5350a.f4984f != null) {
            c0748aM5350a.f4986h = m5352b(c0748aM5350a);
            if (c0748aM5350a.f4986h != null) {
                for (asm asmVar : c0748aM5350a.f4986h.m5363b()) {
                    if (c0748aM5350a.m5360a(asmVar.f4968a, asmVar.f4970c)) {
                        c0748aM5350a.f4979a.add(asmVar);
                    }
                }
            } else {
                m5355c(c0748aM5350a);
            }
            c0748aM5350a.m5361b();
        }
        return m5351a(c0748aM5350a);
    }

    /* JADX INFO: renamed from: a */
    private List<asm> m5351a(C0748a c0748a) {
        ArrayList arrayList = new ArrayList(c0748a.f4979a);
        c0748a.m5358a();
        synchronized (f4975e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    if (f4975e[i] == null) {
                        f4975e[i] = c0748a;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private C0748a m5350a() {
        synchronized (f4975e) {
            for (int i = 0; i < 4; i++) {
                try {
                    C0748a c0748a = f4975e[i];
                    if (c0748a != null) {
                        f4975e[i] = null;
                        return c0748a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new C0748a();
        }
    }

    /* JADX INFO: renamed from: b */
    private asq m5352b(C0748a c0748a) {
        if (c0748a.f4986h != null && c0748a.f4986h.m5364c() != null) {
            asq asqVarM5364c = c0748a.f4986h.m5364c();
            if (c0748a.f4984f == asqVarM5364c.m5362a()) {
                return asqVarM5364c;
            }
        }
        if (this.f4976b == null) {
            return null;
        }
        Iterator<asr> it = this.f4976b.iterator();
        while (it.hasNext()) {
            asq asqVarM5365a = it.next().m5365a(c0748a.f4984f);
            if (asqVarM5365a != null) {
                return asqVarM5365a;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private List<asm> m5354c(Class<?> cls) {
        C0748a c0748aM5350a = m5350a();
        c0748aM5350a.m5359a(cls);
        while (c0748aM5350a.f4984f != null) {
            m5355c(c0748aM5350a);
            c0748aM5350a.m5361b();
        }
        return m5351a(c0748aM5350a);
    }

    /* JADX INFO: renamed from: c */
    private void m5355c(C0748a c0748a) {
        Method[] methods;
        try {
            methods = c0748a.f4984f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = c0748a.f4984f.getMethods();
            c0748a.f4985g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    ask askVar = (ask) method.getAnnotation(ask.class);
                    if (askVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (c0748a.m5360a(method, cls)) {
                            c0748a.f4979a.add(new asm(method, cls, askVar.m5346a(), askVar.m5348c(), askVar.m5347b()));
                        }
                    }
                } else if (this.f4977c && method.isAnnotationPresent(ask.class)) {
                    throw new asf("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f4977c && method.isAnnotationPresent(ask.class)) {
                throw new asf((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    /* JADX INFO: renamed from: asn$a */
    /* JADX INFO: compiled from: SubscriberMethodFinder.java */
    static class C0748a {

        /* JADX INFO: renamed from: a */
        final List<asm> f4979a = new ArrayList();

        /* JADX INFO: renamed from: b */
        final Map<Class, Object> f4980b = new HashMap();

        /* JADX INFO: renamed from: c */
        final Map<String, Class> f4981c = new HashMap();

        /* JADX INFO: renamed from: d */
        final StringBuilder f4982d = new StringBuilder(128);

        /* JADX INFO: renamed from: e */
        Class<?> f4983e;

        /* JADX INFO: renamed from: f */
        Class<?> f4984f;

        /* JADX INFO: renamed from: g */
        boolean f4985g;

        /* JADX INFO: renamed from: h */
        asq f4986h;

        C0748a() {
        }

        /* JADX INFO: renamed from: a */
        void m5359a(Class<?> cls) {
            this.f4984f = cls;
            this.f4983e = cls;
            this.f4985g = false;
            this.f4986h = null;
        }

        /* JADX INFO: renamed from: a */
        void m5358a() {
            this.f4979a.clear();
            this.f4980b.clear();
            this.f4981c.clear();
            this.f4982d.setLength(0);
            this.f4983e = null;
            this.f4984f = null;
            this.f4985g = false;
            this.f4986h = null;
        }

        /* JADX INFO: renamed from: a */
        boolean m5360a(Method method, Class<?> cls) {
            Object objPut = this.f4980b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!m5357b((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.f4980b.put(cls, this);
            }
            return m5357b(method, cls);
        }

        /* JADX INFO: renamed from: b */
        private boolean m5357b(Method method, Class<?> cls) {
            this.f4982d.setLength(0);
            this.f4982d.append(method.getName());
            StringBuilder sb = this.f4982d;
            sb.append('>');
            sb.append(cls.getName());
            String string = this.f4982d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.f4981c.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f4981c.put(string, clsPut);
            return false;
        }

        /* JADX INFO: renamed from: b */
        void m5361b() {
            if (this.f4985g) {
                this.f4984f = null;
                return;
            }
            this.f4984f = this.f4984f.getSuperclass();
            String name = this.f4984f.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f4984f = null;
            }
        }
    }
}
