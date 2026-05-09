package p000;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SubscriberMethodFinder.java */
/* JADX INFO: loaded from: classes.dex */
class akm {

    /* JADX INFO: renamed from: a */
    private static final Map<Class<?>, List<akl>> f1486a = new HashMap();

    /* JADX INFO: renamed from: b */
    private final Map<Class<?>, Class<?>> f1487b = new ConcurrentHashMap();

    akm(List<Class<?>> list) {
        if (list != null) {
            for (Class<?> cls : list) {
                this.f1487b.put(cls, cls);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    List<akl> m1733a(Class<?> cls) {
        List<akl> list;
        synchronized (f1486a) {
            list = f1486a.get(cls);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashMap<String, Class> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }
            try {
                m1732a(arrayList, map, sb, superclass.getDeclaredMethods());
            } catch (Throwable unused) {
                Method[] methods = cls.getMethods();
                arrayList.clear();
                map.clear();
                m1732a(arrayList, map, sb, methods);
            }
        }
        if (arrayList.isEmpty()) {
            throw new akf("Subscriber " + cls + " has no public methods called onEvent");
        }
        synchronized (f1486a) {
            f1486a.put(cls, arrayList);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private void m1732a(List<akl> list, HashMap<String, Class> map, StringBuilder sb, Method[] methodArr) {
        ako akoVarM1731a;
        for (Method method : methodArr) {
            String name = method.getName();
            if (name.startsWith("onEvent")) {
                int modifiers = method.getModifiers();
                Class<?> declaringClass = method.getDeclaringClass();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && (akoVarM1731a = m1731a(declaringClass, method, name)) != null) {
                        Class<?> cls = parameterTypes[0];
                        sb.setLength(0);
                        sb.append(name);
                        sb.append('>');
                        sb.append(cls.getName());
                        String string = sb.toString();
                        Class clsPut = map.put(string, declaringClass);
                        if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                            list.add(new akl(method, akoVarM1731a, cls));
                        } else {
                            map.put(string, clsPut);
                        }
                    }
                } else if (!this.f1487b.containsKey(declaringClass)) {
                    Log.d(akd.f1430a, "Skipping method (not public, static or abstract): " + declaringClass + "." + name);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private ako m1731a(Class<?> cls, Method method, String str) {
        String strSubstring = str.substring("onEvent".length());
        if (strSubstring.length() == 0) {
            return ako.PostThread;
        }
        if (strSubstring.equals("MainThread")) {
            return ako.MainThread;
        }
        if (strSubstring.equals("BackgroundThread")) {
            return ako.BackgroundThread;
        }
        if (strSubstring.equals("Async")) {
            return ako.Async;
        }
        if (this.f1487b.containsKey(cls)) {
            return null;
        }
        throw new akf("Illegal onEvent method, check for typos: " + method);
    }
}
