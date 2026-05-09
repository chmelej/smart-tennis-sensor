package p000;

import android.arch.lifecycle.CompositeGeneratedAdaptersObserver;
import android.arch.lifecycle.FullLifecycleObserver;
import android.arch.lifecycle.FullLifecycleObserverAdapter;
import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.ReflectiveGenericLifecycleObserver;
import android.arch.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: m */
/* JADX INFO: compiled from: Lifecycling.java */
/* JADX INFO: loaded from: classes.dex */
public class C1897m {

    /* JADX INFO: renamed from: a */
    private static Map<Class, Integer> f11443a = new HashMap();

    /* JADX INFO: renamed from: b */
    private static Map<Class, List<Constructor<? extends InterfaceC1735g>>> f11444b = new HashMap();

    /* JADX INFO: renamed from: a */
    static GenericLifecycleObserver m10464a(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (m10468b(cls) == 2) {
            List<Constructor<? extends InterfaceC1735g>> list = f11444b.get(cls);
            if (list.size() == 1) {
                return new SingleGeneratedAdapterObserver(m10465a(list.get(0), obj));
            }
            InterfaceC1735g[] interfaceC1735gArr = new InterfaceC1735g[list.size()];
            for (int i = 0; i < list.size(); i++) {
                interfaceC1735gArr[i] = m10465a(list.get(i), obj);
            }
            return new CompositeGeneratedAdaptersObserver(interfaceC1735gArr);
        }
        return new ReflectiveGenericLifecycleObserver(obj);
    }

    /* JADX INFO: renamed from: a */
    private static InterfaceC1735g m10465a(Constructor<? extends InterfaceC1735g> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Constructor<? extends InterfaceC1735g> m10467a(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strM10466a = m10466a(canonicalName);
            if (!name.isEmpty()) {
                strM10466a = name + "." + strM10466a;
            }
            Constructor declaredConstructor = Class.forName(strM10466a).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private static int m10468b(Class<?> cls) {
        if (f11443a.containsKey(cls)) {
            return f11443a.get(cls).intValue();
        }
        int iM10469c = m10469c(cls);
        f11443a.put(cls, Integer.valueOf(iM10469c));
        return iM10469c;
    }

    /* JADX INFO: renamed from: c */
    private static int m10469c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends InterfaceC1735g> constructorM10467a = m10467a(cls);
        if (constructorM10467a != null) {
            f11444b.put(cls, Collections.singletonList(constructorM10467a));
            return 2;
        }
        if (C1708f.f9750a.m9136a(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (m10470d(superclass)) {
            if (m10468b(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f11444b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (m10470d(cls2)) {
                if (m10468b(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f11444b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f11444b.put(cls, arrayList);
        return 2;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m10470d(Class<?> cls) {
        return cls != null && InterfaceC1789i.class.isAssignableFrom(cls);
    }

    /* JADX INFO: renamed from: a */
    public static String m10466a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
