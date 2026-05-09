package p000;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PendingPost.java */
/* JADX INFO: loaded from: classes.dex */
final class aki {

    /* JADX INFO: renamed from: d */
    private static final List<aki> f1472d = new ArrayList();

    /* JADX INFO: renamed from: a */
    Object f1473a;

    /* JADX INFO: renamed from: b */
    akn f1474b;

    /* JADX INFO: renamed from: c */
    aki f1475c;

    private aki(Object obj, akn aknVar) {
        this.f1473a = obj;
        this.f1474b = aknVar;
    }

    /* JADX INFO: renamed from: a */
    static aki m1725a(akn aknVar, Object obj) {
        synchronized (f1472d) {
            int size = f1472d.size();
            if (size > 0) {
                aki akiVarRemove = f1472d.remove(size - 1);
                akiVarRemove.f1473a = obj;
                akiVarRemove.f1474b = aknVar;
                akiVarRemove.f1475c = null;
                return akiVarRemove;
            }
            return new aki(obj, aknVar);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m1726a(aki akiVar) {
        akiVar.f1473a = null;
        akiVar.f1474b = null;
        akiVar.f1475c = null;
        synchronized (f1472d) {
            if (f1472d.size() < 10000) {
                f1472d.add(akiVar);
            }
        }
    }
}
