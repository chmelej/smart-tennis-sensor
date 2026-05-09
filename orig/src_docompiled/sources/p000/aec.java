package p000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: DatabaseManager.java */
/* JADX INFO: loaded from: classes.dex */
public class aec {

    /* JADX INFO: renamed from: c */
    private static aec f502c;

    /* JADX INFO: renamed from: d */
    private static SQLiteOpenHelper f503d;

    /* JADX INFO: renamed from: a */
    private AtomicInteger f504a = new AtomicInteger();

    /* JADX INFO: renamed from: b */
    private AtomicInteger f505b = new AtomicInteger();

    /* JADX INFO: renamed from: e */
    private SQLiteDatabase f506e;

    /* JADX INFO: renamed from: b */
    private static synchronized void m456b(Context context) {
        if (f502c == null) {
            f502c = new aec();
            f503d = afb.m798a(context);
        }
    }

    /* JADX INFO: renamed from: a */
    public static synchronized aec m455a(Context context) {
        if (f502c == null) {
            m456b(context);
        }
        return f502c;
    }

    /* JADX INFO: renamed from: a */
    public synchronized SQLiteDatabase m457a() {
        if (this.f504a.incrementAndGet() == 1) {
            this.f506e = f503d.getReadableDatabase();
        }
        return this.f506e;
    }

    /* JADX INFO: renamed from: b */
    public synchronized SQLiteDatabase m458b() {
        if (this.f504a.incrementAndGet() == 1) {
            this.f506e = f503d.getWritableDatabase();
        }
        return this.f506e;
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m459c() {
        if (this.f504a.decrementAndGet() == 0) {
            this.f506e.close();
        }
        if (this.f505b.decrementAndGet() == 0) {
            this.f506e.close();
        }
    }
}
