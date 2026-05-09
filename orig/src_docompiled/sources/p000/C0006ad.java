package p000;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: ad */
/* JADX INFO: compiled from: MotionTiming.java */
/* JADX INFO: loaded from: classes.dex */
public class C0006ad {

    /* JADX INFO: renamed from: a */
    private long f351a;

    /* JADX INFO: renamed from: b */
    private long f352b;

    /* JADX INFO: renamed from: c */
    private TimeInterpolator f353c;

    /* JADX INFO: renamed from: d */
    private int f354d;

    /* JADX INFO: renamed from: e */
    private int f355e;

    public C0006ad(long j, long j2) {
        this.f351a = 0L;
        this.f352b = 300L;
        this.f353c = null;
        this.f354d = 0;
        this.f355e = 1;
        this.f351a = j;
        this.f352b = j2;
    }

    public C0006ad(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f351a = 0L;
        this.f352b = 300L;
        this.f353c = null;
        this.f354d = 0;
        this.f355e = 1;
        this.f351a = j;
        this.f352b = j2;
        this.f353c = timeInterpolator;
    }

    /* JADX INFO: renamed from: a */
    public void m296a(Animator animator) {
        animator.setStartDelay(m295a());
        animator.setDuration(m297b());
        animator.setInterpolator(m298c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(m299d());
            valueAnimator.setRepeatMode(m300e());
        }
    }

    /* JADX INFO: renamed from: a */
    public long m295a() {
        return this.f351a;
    }

    /* JADX INFO: renamed from: b */
    public long m297b() {
        return this.f352b;
    }

    /* JADX INFO: renamed from: c */
    public TimeInterpolator m298c() {
        return this.f353c != null ? this.f353c : C2178v.f13000b;
    }

    /* JADX INFO: renamed from: d */
    public int m299d() {
        return this.f354d;
    }

    /* JADX INFO: renamed from: e */
    public int m300e() {
        return this.f355e;
    }

    /* JADX INFO: renamed from: a */
    static C0006ad m293a(ValueAnimator valueAnimator) {
        C0006ad c0006ad = new C0006ad(valueAnimator.getStartDelay(), valueAnimator.getDuration(), m294b(valueAnimator));
        c0006ad.f354d = valueAnimator.getRepeatCount();
        c0006ad.f355e = valueAnimator.getRepeatMode();
        return c0006ad;
    }

    /* JADX INFO: renamed from: b */
    private static TimeInterpolator m294b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return C2178v.f13000b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return C2178v.f13001c;
        }
        return interpolator instanceof DecelerateInterpolator ? C2178v.f13002d : interpolator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0006ad c0006ad = (C0006ad) obj;
        if (m295a() == c0006ad.m295a() && m297b() == c0006ad.m297b() && m299d() == c0006ad.m299d() && m300e() == c0006ad.m300e()) {
            return m298c().getClass().equals(c0006ad.m298c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (m295a() ^ (m295a() >>> 32))) * 31) + ((int) (m297b() ^ (m297b() >>> 32)))) * 31) + m298c().getClass().hashCode()) * 31) + m299d()) * 31) + m300e();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + m295a() + " duration: " + m297b() + " interpolator: " + m298c().getClass() + " repeatCount: " + m299d() + " repeatMode: " + m300e() + "}\n";
    }
}
