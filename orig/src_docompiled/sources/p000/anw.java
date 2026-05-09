package p000;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: RouteDatabase.java */
/* JADX INFO: loaded from: classes.dex */
public final class anw {

    /* JADX INFO: renamed from: a */
    private final Set<ani> f4293a = new LinkedHashSet();

    /* JADX INFO: renamed from: a */
    public synchronized void m4574a(ani aniVar) {
        this.f4293a.add(aniVar);
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m4575b(ani aniVar) {
        this.f4293a.remove(aniVar);
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m4576c(ani aniVar) {
        return this.f4293a.contains(aniVar);
    }
}
