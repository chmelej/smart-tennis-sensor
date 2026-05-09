package p000;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: SubscriberMethod.java */
/* JADX INFO: loaded from: classes.dex */
public class asm {

    /* JADX INFO: renamed from: a */
    final Method f4968a;

    /* JADX INFO: renamed from: b */
    final asp f4969b;

    /* JADX INFO: renamed from: c */
    final Class<?> f4970c;

    /* JADX INFO: renamed from: d */
    final int f4971d;

    /* JADX INFO: renamed from: e */
    final boolean f4972e;

    /* JADX INFO: renamed from: f */
    String f4973f;

    public asm(Method method, Class<?> cls, asp aspVar, int i, boolean z) {
        this.f4968a = method;
        this.f4969b = aspVar;
        this.f4970c = cls;
        this.f4971d = i;
        this.f4972e = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof asm)) {
            return false;
        }
        m5349a();
        asm asmVar = (asm) obj;
        asmVar.m5349a();
        return this.f4973f.equals(asmVar.f4973f);
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m5349a() {
        if (this.f4973f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f4968a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f4968a.getName());
            sb.append('(');
            sb.append(this.f4970c.getName());
            this.f4973f = sb.toString();
        }
    }

    public int hashCode() {
        return this.f4968a.hashCode();
    }
}
