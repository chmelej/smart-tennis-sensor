package p000;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: t */
/* JADX INFO: compiled from: ViewModelStore.java */
/* JADX INFO: loaded from: classes.dex */
public class C2124t {

    /* JADX INFO: renamed from: a */
    private final HashMap<String, AbstractC2070r> f12729a = new HashMap<>();

    /* JADX INFO: renamed from: a */
    final void m11608a(String str, AbstractC2070r abstractC2070r) {
        AbstractC2070r abstractC2070rPut = this.f12729a.put(str, abstractC2070r);
        if (abstractC2070rPut != null) {
            abstractC2070rPut.onCleared();
        }
    }

    /* JADX INFO: renamed from: a */
    final AbstractC2070r m11606a(String str) {
        return this.f12729a.get(str);
    }

    /* JADX INFO: renamed from: a */
    public final void m11607a() {
        Iterator<AbstractC2070r> it = this.f12729a.values().iterator();
        while (it.hasNext()) {
            it.next().onCleared();
        }
        this.f12729a.clear();
    }
}
