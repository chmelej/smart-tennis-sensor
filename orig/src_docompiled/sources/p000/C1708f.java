package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000.AbstractC1762h;

/* JADX INFO: renamed from: f */
/* JADX INFO: compiled from: ClassesInfoCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1708f {

    /* JADX INFO: renamed from: a */
    public static C1708f f9750a = new C1708f();

    /* JADX INFO: renamed from: b */
    private final Map<Class, a> f9751b = new HashMap();

    /* JADX INFO: renamed from: c */
    private final Map<Class, Boolean> f9752c = new HashMap();

    C1708f() {
    }

    /* JADX INFO: renamed from: a */
    boolean m9136a(Class cls) {
        if (this.f9752c.containsKey(cls)) {
            return this.f9752c.get(cls).booleanValue();
        }
        Method[] methodArrM9135c = m9135c(cls);
        for (Method method : methodArrM9135c) {
            if (((InterfaceC2043q) method.getAnnotation(InterfaceC2043q.class)) != null) {
                m9133a(cls, methodArrM9135c);
                return true;
            }
        }
        this.f9752c.put(cls, false);
        return false;
    }

    /* JADX INFO: renamed from: c */
    private Method[] m9135c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* JADX INFO: renamed from: b */
    public a m9137b(Class cls) {
        a aVar = this.f9751b.get(cls);
        return aVar != null ? aVar : m9133a(cls, null);
    }

    /* JADX INFO: renamed from: a */
    private void m9134a(Map<b, AbstractC1762h.a> map, b bVar, AbstractC1762h.a aVar, Class cls) {
        AbstractC1762h.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f9756b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* JADX INFO: renamed from: a */
    private a m9133a(Class cls, Method[] methodArr) {
        int i;
        a aVarM9137b;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarM9137b = m9137b(superclass)) != null) {
            map.putAll(aVarM9137b.f9754b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, AbstractC1762h.a> entry : m9137b(cls2).f9754b.entrySet()) {
                m9134a(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m9135c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            InterfaceC2043q interfaceC2043q = (InterfaceC2043q) method.getAnnotation(InterfaceC2043q.class);
            if (interfaceC2043q != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(InterfaceC1816j.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                AbstractC1762h.a aVarM11163a = interfaceC2043q.m11163a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(AbstractC1762h.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarM11163a != AbstractC1762h.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m9134a(map, new b(i, method), aVarM11163a, cls);
                z = true;
            }
        }
        a aVar = new a(map);
        this.f9751b.put(cls, aVar);
        this.f9752c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* JADX INFO: renamed from: f$a */
    /* JADX INFO: compiled from: ClassesInfoCache.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        final Map<AbstractC1762h.a, List<b>> f9753a = new HashMap();

        /* JADX INFO: renamed from: b */
        final Map<b, AbstractC1762h.a> f9754b;

        a(Map<b, AbstractC1762h.a> map) {
            this.f9754b = map;
            for (Map.Entry<b, AbstractC1762h.a> entry : map.entrySet()) {
                AbstractC1762h.a value = entry.getValue();
                List<b> arrayList = this.f9753a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f9753a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        /* JADX INFO: renamed from: a */
        public void m9139a(InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar, Object obj) {
            m9138a(this.f9753a.get(aVar), interfaceC1816j, aVar, obj);
            m9138a(this.f9753a.get(AbstractC1762h.a.ON_ANY), interfaceC1816j, aVar, obj);
        }

        /* JADX INFO: renamed from: a */
        private static void m9138a(List<b> list, InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).m9140a(interfaceC1816j, aVar, obj);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f$b */
    /* JADX INFO: compiled from: ClassesInfoCache.java */
    static class b {

        /* JADX INFO: renamed from: a */
        final int f9755a;

        /* JADX INFO: renamed from: b */
        final Method f9756b;

        b(int i, Method method) {
            this.f9755a = i;
            this.f9756b = method;
            this.f9756b.setAccessible(true);
        }

        /* JADX INFO: renamed from: a */
        void m9140a(InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar, Object obj) {
            try {
                switch (this.f9755a) {
                    case 0:
                        this.f9756b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f9756b.invoke(obj, interfaceC1816j);
                        return;
                    case 2:
                        this.f9756b.invoke(obj, interfaceC1816j, aVar);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9755a == bVar.f9755a && this.f9756b.getName().equals(bVar.f9756b.getName());
        }

        public int hashCode() {
            return (this.f9755a * 31) + this.f9756b.getName().hashCode();
        }
    }
}
