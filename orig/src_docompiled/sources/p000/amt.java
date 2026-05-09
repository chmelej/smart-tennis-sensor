package p000;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import p000.and;

/* JADX INFO: compiled from: Dispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public final class amt {

    /* JADX INFO: renamed from: c */
    @Nullable
    private Runnable f1909c;

    /* JADX INFO: renamed from: d */
    @Nullable
    private ExecutorService f1910d;

    /* JADX INFO: renamed from: a */
    private int f1907a = 64;

    /* JADX INFO: renamed from: b */
    private int f1908b = 5;

    /* JADX INFO: renamed from: e */
    private final Deque<and.C0215a> f1911e = new ArrayDeque();

    /* JADX INFO: renamed from: f */
    private final Deque<and.C0215a> f1912f = new ArrayDeque();

    /* JADX INFO: renamed from: g */
    private final Deque<and> f1913g = new ArrayDeque();

    /* JADX INFO: renamed from: a */
    public synchronized ExecutorService m2019a() {
        if (this.f1910d == null) {
            this.f1910d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), anm.m4503a("OkHttp Dispatcher", false));
        }
        return this.f1910d;
    }

    /* JADX INFO: renamed from: a */
    synchronized void m2020a(and.C0215a c0215a) {
        if (this.f1912f.size() < this.f1907a && m2017c(c0215a) < this.f1908b) {
            this.f1912f.add(c0215a);
            m2019a().execute(c0215a);
        } else {
            this.f1911e.add(c0215a);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2018c() {
        if (this.f1912f.size() < this.f1907a && !this.f1911e.isEmpty()) {
            Iterator<and.C0215a> it = this.f1911e.iterator();
            while (it.hasNext()) {
                and.C0215a next = it.next();
                if (m2017c(next) < this.f1908b) {
                    it.remove();
                    this.f1912f.add(next);
                    m2019a().execute(next);
                }
                if (this.f1912f.size() >= this.f1907a) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private int m2017c(and.C0215a c0215a) {
        int i = 0;
        for (and.C0215a c0215a2 : this.f1912f) {
            if (!c0215a2.m2183b().f2014d && c0215a2.m2182a().equals(c0215a.m2182a())) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    synchronized void m2021a(and andVar) {
        this.f1913g.add(andVar);
    }

    /* JADX INFO: renamed from: b */
    void m2023b(and.C0215a c0215a) {
        m2016a(this.f1912f, c0215a, true);
    }

    /* JADX INFO: renamed from: b */
    void m2024b(and andVar) {
        m2016a(this.f1913g, andVar, false);
    }

    /* JADX INFO: renamed from: a */
    private <T> void m2016a(Deque<T> deque, T t, boolean z) {
        int iM2022b;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                m2018c();
            }
            iM2022b = m2022b();
            runnable = this.f1909c;
        }
        if (iM2022b != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: renamed from: b */
    public synchronized int m2022b() {
        return this.f1912f.size() + this.f1913g.size();
    }
}
