package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: OptionalMethod.java */
/* JADX INFO: loaded from: classes.dex */
class apg<T> {

    /* JADX INFO: renamed from: a */
    private final Class<?> f4583a;

    /* JADX INFO: renamed from: b */
    private final String f4584b;

    /* JADX INFO: renamed from: c */
    private final Class[] f4585c;

    apg(Class<?> cls, String str, Class... clsArr) {
        this.f4583a = cls;
        this.f4584b = str;
        this.f4585c = clsArr;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4846a(T t) {
        return m4843a(t.getClass()) != null;
    }

    /* JADX INFO: renamed from: a */
    public Object m4845a(T t, Object... objArr) {
        Method methodM4843a = m4843a(t.getClass());
        if (methodM4843a == null) {
            return null;
        }
        try {
            return methodM4843a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public Object m4847b(T t, Object... objArr) {
        try {
            return m4845a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* JADX INFO: renamed from: c */
    public Object m4848c(T t, Object... objArr) {
        Method methodM4843a = m4843a(t.getClass());
        if (methodM4843a == null) {
            throw new AssertionError("Method " + this.f4584b + " not supported for object " + t);
        }
        try {
            return methodM4843a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodM4843a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    /* JADX INFO: renamed from: d */
    public Object m4849d(T t, Object... objArr) {
        try {
            return m4848c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* JADX INFO: renamed from: a */
    private Method m4843a(Class<?> cls) {
        if (this.f4584b == null) {
            return null;
        }
        Method methodM4844a = m4844a(cls, this.f4584b, this.f4585c);
        if (methodM4844a == null || this.f4583a == null || this.f4583a.isAssignableFrom(methodM4844a.getReturnType())) {
            return methodM4844a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static Method m4844a(Class<?> cls, String str, Class[] clsArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) != 0) {
                return method;
            }
            return null;
        } catch (NoSuchMethodException unused2) {
            return method;
        }
    }
}
