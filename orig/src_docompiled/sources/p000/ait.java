package p000;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: AbstractDistributedLock.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ait implements Lock {

    /* JADX INFO: renamed from: a */
    protected final ReentrantLock f1199a = new ReentrantLock();

    /* JADX INFO: renamed from: a */
    protected abstract void mo1405a();

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo1406a(long j, TimeUnit timeUnit);

    /* JADX INFO: renamed from: b */
    protected abstract void mo1407b();

    /* JADX INFO: renamed from: c */
    protected abstract boolean mo1408c();

    /* JADX INFO: renamed from: d */
    protected abstract void mo1409d();

    @Override // java.util.concurrent.locks.Lock
    public void lock() {
        this.f1199a.lock();
        try {
            mo1405a();
        } finally {
            this.f1199a.unlock();
        }
    }

    @Override // java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws InterruptedException {
        this.f1199a.lockInterruptibly();
        if (this.f1199a.getHoldCount() > 1) {
            return;
        }
        try {
            mo1409d();
        } catch (Throwable th) {
            this.f1199a.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock() {
        this.f1199a.lock();
        try {
            return mo1408c();
        } finally {
            this.f1199a.unlock();
        }
    }

    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock(long j, TimeUnit timeUnit) {
        if (this.f1199a.getHoldCount() > 1) {
            return true;
        }
        this.f1199a.lock();
        try {
            return mo1406a(j, TimeUnit.NANOSECONDS);
        } finally {
            this.f1199a.unlock();
        }
    }

    @Override // java.util.concurrent.locks.Lock
    public void unlock() {
        this.f1199a.lock();
        try {
            mo1407b();
        } finally {
            this.f1199a.unlock();
        }
    }

    @Override // java.util.concurrent.locks.Lock
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }
}
