package p000;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: gm */
/* JADX INFO: compiled from: GapWorker.java */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1748gm implements Runnable {

    /* JADX INFO: renamed from: a */
    public static final ThreadLocal<RunnableC1748gm> f10031a = new ThreadLocal<>();

    /* JADX INFO: renamed from: e */
    static Comparator<b> f10032e = new Comparator<b>() { // from class: gm.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            if ((bVar.f10044d == null) != (bVar2.f10044d == null)) {
                return bVar.f10044d == null ? 1 : -1;
            }
            if (bVar.f10041a != bVar2.f10041a) {
                return bVar.f10041a ? -1 : 1;
            }
            int i = bVar2.f10042b - bVar.f10042b;
            if (i != 0) {
                return i;
            }
            int i2 = bVar.f10043c - bVar2.f10043c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };

    /* JADX INFO: renamed from: c */
    long f10034c;

    /* JADX INFO: renamed from: d */
    public long f10035d;

    /* JADX INFO: renamed from: b */
    ArrayList<RecyclerView> f10033b = new ArrayList<>();

    /* JADX INFO: renamed from: f */
    private ArrayList<b> f10036f = new ArrayList<>();

    /* JADX INFO: renamed from: gm$b */
    /* JADX INFO: compiled from: GapWorker.java */
    static class b {

        /* JADX INFO: renamed from: a */
        public boolean f10041a;

        /* JADX INFO: renamed from: b */
        public int f10042b;

        /* JADX INFO: renamed from: c */
        public int f10043c;

        /* JADX INFO: renamed from: d */
        public RecyclerView f10044d;

        /* JADX INFO: renamed from: e */
        public int f10045e;

        b() {
        }

        /* JADX INFO: renamed from: a */
        public void m9484a() {
            this.f10041a = false;
            this.f10042b = 0;
            this.f10043c = 0;
            this.f10044d = null;
            this.f10045e = 0;
        }
    }

    /* JADX INFO: renamed from: gm$a */
    /* JADX INFO: compiled from: GapWorker.java */
    public static class a implements RecyclerView.AbstractC0611i.a {

        /* JADX INFO: renamed from: a */
        int f10037a;

        /* JADX INFO: renamed from: b */
        int f10038b;

        /* JADX INFO: renamed from: c */
        int[] f10039c;

        /* JADX INFO: renamed from: d */
        int f10040d;

        /* JADX INFO: renamed from: a */
        void m9481a(int i, int i2) {
            this.f10037a = i;
            this.f10038b = i2;
        }

        /* JADX INFO: renamed from: a */
        void m9482a(RecyclerView recyclerView, boolean z) {
            this.f10040d = 0;
            if (this.f10039c != null) {
                Arrays.fill(this.f10039c, -1);
            }
            RecyclerView.AbstractC0611i abstractC0611i = recyclerView.f3708n;
            if (recyclerView.f3707m == null || abstractC0611i == null || !abstractC0611i.m4006p()) {
                return;
            }
            if (z) {
                if (!recyclerView.f3700f.m9208d()) {
                    abstractC0611i.mo3625a(recyclerView.f3707m.mo3863a(), this);
                }
            } else if (!recyclerView.m3828v()) {
                abstractC0611i.mo3624a(this.f10037a, this.f10038b, recyclerView.f3650D, this);
            }
            if (this.f10040d > abstractC0611i.f3760x) {
                abstractC0611i.f3760x = this.f10040d;
                abstractC0611i.f3761y = z;
                recyclerView.f3699e.m4062b();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AbstractC0611i.a
        /* JADX INFO: renamed from: b */
        public void mo4022b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f10040d * 2;
            if (this.f10039c == null) {
                this.f10039c = new int[4];
                Arrays.fill(this.f10039c, -1);
            } else if (i3 >= this.f10039c.length) {
                int[] iArr = this.f10039c;
                this.f10039c = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.f10039c, 0, iArr.length);
            }
            this.f10039c[i3] = i;
            this.f10039c[i3 + 1] = i2;
            this.f10040d++;
        }

        /* JADX INFO: renamed from: a */
        public boolean m9483a(int i) {
            if (this.f10039c != null) {
                int i2 = this.f10040d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f10039c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void m9480a() {
            if (this.f10039c != null) {
                Arrays.fill(this.f10039c, -1);
            }
            this.f10040d = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9476a(RecyclerView recyclerView) {
        this.f10033b.add(recyclerView);
    }

    /* JADX INFO: renamed from: b */
    public void m9478b(RecyclerView recyclerView) {
        this.f10033b.remove(recyclerView);
    }

    /* JADX INFO: renamed from: a */
    public void m9477a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f10034c == 0) {
            this.f10034c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f3649C.m9481a(i, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m9470a() {
        b bVar;
        int size = this.f10033b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f10033b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f3649C.m9482a(recyclerView, false);
                i += recyclerView.f3649C.f10040d;
            }
        }
        this.f10036f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f10033b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.f3649C;
                int iAbs = Math.abs(aVar.f10037a) + Math.abs(aVar.f10038b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.f10040d * 2; i6 += 2) {
                    if (i5 >= this.f10036f.size()) {
                        bVar = new b();
                        this.f10036f.add(bVar);
                    } else {
                        bVar = this.f10036f.get(i5);
                    }
                    int i7 = aVar.f10039c[i6 + 1];
                    bVar.f10041a = i7 <= iAbs;
                    bVar.f10042b = iAbs;
                    bVar.f10043c = i7;
                    bVar.f10044d = recyclerView2;
                    bVar.f10045e = aVar.f10039c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f10036f, f10032e);
    }

    /* JADX INFO: renamed from: a */
    static boolean m9473a(RecyclerView recyclerView, int i) {
        int iM9365c = recyclerView.f3701g.m9365c();
        for (int i2 = 0; i2 < iM9365c; i2++) {
            RecyclerView.AbstractC0624v abstractC0624vM3746e = RecyclerView.m3746e(recyclerView.f3701g.m9368d(i2));
            if (abstractC0624vM3746e.f3825c == i && !abstractC0624vM3746e.m4143n()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private RecyclerView.AbstractC0624v m9469a(RecyclerView recyclerView, int i, long j) {
        if (m9473a(recyclerView, i)) {
            return null;
        }
        RecyclerView.C0617o c0617o = recyclerView.f3699e;
        try {
            recyclerView.m3817l();
            RecyclerView.AbstractC0624v abstractC0624vM4047a = c0617o.m4047a(i, false, j);
            if (abstractC0624vM4047a != null) {
                if (abstractC0624vM4047a.m4145p() && !abstractC0624vM4047a.m4143n()) {
                    c0617o.m4058a(abstractC0624vM4047a.f3823a);
                } else {
                    c0617o.m4057a(abstractC0624vM4047a, false);
                }
            }
            return abstractC0624vM4047a;
        } finally {
            recyclerView.m3784b(false);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9471a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.f3718x && recyclerView.f3701g.m9365c() != 0) {
            recyclerView.m3789c();
        }
        a aVar = recyclerView.f3649C;
        aVar.m9482a(recyclerView, true);
        if (aVar.f10040d != 0) {
            try {
                TraceCompat.beginSection("RV Nested Prefetch");
                recyclerView.f3650D.m4100a(recyclerView.f3707m);
                for (int i = 0; i < aVar.f10040d * 2; i += 2) {
                    m9469a(recyclerView, aVar.f10039c[i], j);
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9472a(b bVar, long j) {
        RecyclerView.AbstractC0624v abstractC0624vM9469a = m9469a(bVar.f10044d, bVar.f10045e, bVar.f10041a ? Long.MAX_VALUE : j);
        if (abstractC0624vM9469a == null || abstractC0624vM9469a.f3824b == null || !abstractC0624vM9469a.m4145p() || abstractC0624vM9469a.m4143n()) {
            return;
        }
        m9471a(abstractC0624vM9469a.f3824b.get(), j);
    }

    /* JADX INFO: renamed from: b */
    private void m9474b(long j) {
        for (int i = 0; i < this.f10036f.size(); i++) {
            b bVar = this.f10036f.get(i);
            if (bVar.f10044d == null) {
                return;
            }
            m9472a(bVar, j);
            bVar.m9484a();
        }
    }

    /* JADX INFO: renamed from: a */
    void m9475a(long j) {
        m9470a();
        m9474b(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (this.f10033b.isEmpty()) {
                return;
            }
            int size = this.f10033b.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.f10033b.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                return;
            }
            m9475a(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f10035d);
        } finally {
            this.f10034c = 0L;
            TraceCompat.endSection();
        }
    }
}
