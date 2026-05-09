package p000;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PendingPost.java */
/* JADX INFO: loaded from: classes.dex */
final class asi {

    /* JADX INFO: renamed from: d */
    private static final List<asi> f4958d = new ArrayList();

    /* JADX INFO: renamed from: a */
    Object f4959a;

    /* JADX INFO: renamed from: b */
    aso f4960b;

    /* JADX INFO: renamed from: c */
    asi f4961c;

    private asi(Object obj, aso asoVar) {
        this.f4959a = obj;
        this.f4960b = asoVar;
    }

    /* JADX INFO: renamed from: a */
    static asi m5341a(aso asoVar, Object obj) {
        synchronized (f4958d) {
            int size = f4958d.size();
            if (size > 0) {
                asi asiVarRemove = f4958d.remove(size - 1);
                asiVarRemove.f4959a = obj;
                asiVarRemove.f4960b = asoVar;
                asiVarRemove.f4961c = null;
                return asiVarRemove;
            }
            return new asi(obj, asoVar);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m5342a(asi asiVar) {
        asiVar.f4959a = null;
        asiVar.f4960b = null;
        asiVar.f4961c = null;
        synchronized (f4958d) {
            if (f4958d.size() < 10000) {
                f4958d.add(asiVar);
            }
        }
    }
}
