package p000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMDBManager.java */
/* JADX INFO: loaded from: classes.dex */
class agw {

    /* JADX INFO: renamed from: c */
    private static agw f865c;

    /* JADX INFO: renamed from: d */
    private static SQLiteOpenHelper f866d;

    /* JADX INFO: renamed from: a */
    private AtomicInteger f867a = new AtomicInteger();

    /* JADX INFO: renamed from: b */
    private AtomicInteger f868b = new AtomicInteger();

    /* JADX INFO: renamed from: e */
    private SQLiteDatabase f869e;

    agw() {
    }

    /* JADX INFO: renamed from: b */
    private static synchronized void m985b(Context context) {
        if (f865c == null) {
            f865c = new agw();
            f866d = agv.m977a(context);
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized agw m984a(Context context) {
        if (f865c == null) {
            m985b(context);
        }
        return f865c;
    }

    /* JADX INFO: renamed from: a */
    public synchronized SQLiteDatabase m986a() {
        if (this.f867a.incrementAndGet() == 1) {
            this.f869e = f866d.getWritableDatabase();
        }
        return this.f869e;
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m987b() {
        try {
            if (this.f867a.decrementAndGet() == 0) {
                this.f869e.close();
            }
            if (this.f868b.decrementAndGet() == 0) {
                this.f869e.close();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
