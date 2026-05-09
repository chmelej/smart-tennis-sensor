package p000;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: SubscriberMethod.java */
/* JADX INFO: loaded from: classes.dex */
final class akl {

    /* JADX INFO: renamed from: a */
    final Method f1482a;

    /* JADX INFO: renamed from: b */
    final ako f1483b;

    /* JADX INFO: renamed from: c */
    final Class<?> f1484c;

    /* JADX INFO: renamed from: d */
    String f1485d;

    akl(Method method, ako akoVar, Class<?> cls) {
        this.f1482a = method;
        this.f1483b = akoVar;
        this.f1484c = cls;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof akl)) {
            return false;
        }
        m1730a();
        akl aklVar = (akl) obj;
        aklVar.m1730a();
        return this.f1485d.equals(aklVar.f1485d);
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m1730a() {
        if (this.f1485d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f1482a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f1482a.getName());
            sb.append('(');
            sb.append(this.f1484c.getName());
            this.f1485d = sb.toString();
        }
    }

    public int hashCode() {
        return this.f1482a.hashCode();
    }
}
