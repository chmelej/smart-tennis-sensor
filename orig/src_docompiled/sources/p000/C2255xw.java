package p000;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.C2253xu;
import p000.C2265yf;

/* JADX INFO: renamed from: xw */
/* JADX INFO: compiled from: PicassoExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
class C2255xw extends ThreadPoolExecutor {
    C2255xw() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C2265yf.e());
    }

    /* JADX INFO: renamed from: a */
    void m12328a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            m12327a(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 6 && type != 9) {
            switch (type) {
                case 0:
                    int subtype = networkInfo.getSubtype();
                    switch (subtype) {
                        case 1:
                        case 2:
                            m12327a(1);
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            break;
                        default:
                            switch (subtype) {
                                case 12:
                                    break;
                                case 13:
                                case 14:
                                case 15:
                                    m12327a(3);
                                    break;
                                default:
                                    m12327a(3);
                                    break;
                            }
                            break;
                    }
                    m12327a(2);
                    break;
                case 1:
                    break;
                default:
                    m12327a(3);
                    break;
            }
        }
        m12327a(4);
    }

    /* JADX INFO: renamed from: a */
    private void m12327a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((RunnableC2236xd) runnable);
        execute(aVar);
        return aVar;
    }

    /* JADX INFO: renamed from: xw$a */
    /* JADX INFO: compiled from: PicassoExecutorService.java */
    static final class a extends FutureTask<RunnableC2236xd> implements Comparable<a> {

        /* JADX INFO: renamed from: a */
        private final RunnableC2236xd f13604a;

        public a(RunnableC2236xd runnableC2236xd) {
            super(runnableC2236xd, null);
            this.f13604a = runnableC2236xd;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            C2253xu.e eVarM12248n = this.f13604a.m12248n();
            C2253xu.e eVarM12248n2 = aVar.f13604a.m12248n();
            return eVarM12248n == eVarM12248n2 ? this.f13604a.f13465a - aVar.f13604a.f13465a : eVarM12248n2.ordinal() - eVarM12248n.ordinal();
        }
    }
}
