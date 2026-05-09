package p000;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: es */
/* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
/* JADX INFO: loaded from: classes.dex */
public class C1700es {

    /* JADX INFO: renamed from: b */
    ViewPropertyAnimatorListener f9672b;

    /* JADX INFO: renamed from: d */
    private Interpolator f9674d;

    /* JADX INFO: renamed from: e */
    private boolean f9675e;

    /* JADX INFO: renamed from: c */
    private long f9673c = -1;

    /* JADX INFO: renamed from: f */
    private final ViewPropertyAnimatorListenerAdapter f9676f = new ViewPropertyAnimatorListenerAdapter() { // from class: es.1

        /* JADX INFO: renamed from: b */
        private boolean f9678b = false;

        /* JADX INFO: renamed from: c */
        private int f9679c = 0;

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.f9678b) {
                return;
            }
            this.f9678b = true;
            if (C1700es.this.f9672b != null) {
                C1700es.this.f9672b.onAnimationStart(null);
            }
        }

        /* JADX INFO: renamed from: a */
        void m9096a() {
            this.f9679c = 0;
            this.f9678b = false;
            C1700es.this.m9094b();
        }

        @Override // android.support.v4.view.ViewPropertyAnimatorListenerAdapter, android.support.v4.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i = this.f9679c + 1;
            this.f9679c = i;
            if (i == C1700es.this.f9671a.size()) {
                if (C1700es.this.f9672b != null) {
                    C1700es.this.f9672b.onAnimationEnd(null);
                }
                m9096a();
            }
        }
    };

    /* JADX INFO: renamed from: a */
    final ArrayList<ViewPropertyAnimatorCompat> f9671a = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    public C1700es m9089a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f9675e) {
            this.f9671a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C1700es m9090a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f9671a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f9671a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m9093a() {
        if (this.f9675e) {
            return;
        }
        for (ViewPropertyAnimatorCompat viewPropertyAnimatorCompat : this.f9671a) {
            if (this.f9673c >= 0) {
                viewPropertyAnimatorCompat.setDuration(this.f9673c);
            }
            if (this.f9674d != null) {
                viewPropertyAnimatorCompat.setInterpolator(this.f9674d);
            }
            if (this.f9672b != null) {
                viewPropertyAnimatorCompat.setListener(this.f9676f);
            }
            viewPropertyAnimatorCompat.start();
        }
        this.f9675e = true;
    }

    /* JADX INFO: renamed from: b */
    void m9094b() {
        this.f9675e = false;
    }

    /* JADX INFO: renamed from: c */
    public void m9095c() {
        if (this.f9675e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f9671a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f9675e = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public C1700es m9088a(long j) {
        if (!this.f9675e) {
            this.f9673c = j;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C1700es m9092a(Interpolator interpolator) {
        if (!this.f9675e) {
            this.f9674d = interpolator;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C1700es m9091a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f9675e) {
            this.f9672b = viewPropertyAnimatorListener;
        }
        return this;
    }
}
