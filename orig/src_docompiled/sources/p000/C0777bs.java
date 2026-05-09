package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* JADX INFO: renamed from: bs */
/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0777bs {

    /* JADX INFO: renamed from: b */
    private final ArrayList<a> f5292b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    private a f5293c = null;

    /* JADX INFO: renamed from: a */
    ValueAnimator f5291a = null;

    /* JADX INFO: renamed from: d */
    private final Animator.AnimatorListener f5294d = new AnimatorListenerAdapter() { // from class: bs.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (C0777bs.this.f5291a == animator) {
                C0777bs.this.f5291a = null;
            }
        }
    };

    /* JADX INFO: renamed from: a */
    public void m5706a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.f5294d);
        this.f5292b.add(aVar);
    }

    /* JADX INFO: renamed from: a */
    public void m5705a(int[] iArr) {
        a aVar;
        int size = this.f5292b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f5292b.get(i);
            if (StateSet.stateSetMatches(aVar.f5296a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        if (aVar == this.f5293c) {
            return;
        }
        if (this.f5293c != null) {
            m5703b();
        }
        this.f5293c = aVar;
        if (aVar != null) {
            m5702a(aVar);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5702a(a aVar) {
        this.f5291a = aVar.f5297b;
        this.f5291a.start();
    }

    /* JADX INFO: renamed from: b */
    private void m5703b() {
        if (this.f5291a != null) {
            this.f5291a.cancel();
            this.f5291a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5704a() {
        if (this.f5291a != null) {
            this.f5291a.end();
            this.f5291a = null;
        }
    }

    /* JADX INFO: renamed from: bs$a */
    /* JADX INFO: compiled from: StateListAnimator.java */
    static class a {

        /* JADX INFO: renamed from: a */
        final int[] f5296a;

        /* JADX INFO: renamed from: b */
        final ValueAnimator f5297b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f5296a = iArr;
            this.f5297b = valueAnimator;
        }
    }
}
