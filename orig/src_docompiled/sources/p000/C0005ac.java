package p000;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ac */
/* JADX INFO: compiled from: MotionSpec.java */
/* JADX INFO: loaded from: classes.dex */
public class C0005ac {

    /* JADX INFO: renamed from: a */
    private final SimpleArrayMap<String, C0006ad> f192a = new SimpleArrayMap<>();

    /* JADX INFO: renamed from: a */
    public boolean m149a(String str) {
        return this.f192a.get(str) != null;
    }

    /* JADX INFO: renamed from: b */
    public C0006ad m150b(String str) {
        if (!m149a(str)) {
            throw new IllegalArgumentException();
        }
        return this.f192a.get(str);
    }

    /* JADX INFO: renamed from: a */
    public void m148a(String str, C0006ad c0006ad) {
        this.f192a.put(str, c0006ad);
    }

    /* JADX INFO: renamed from: a */
    public long m147a() {
        int size = this.f192a.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            C0006ad c0006adValueAt = this.f192a.valueAt(i);
            jMax = Math.max(jMax, c0006adValueAt.m295a() + c0006adValueAt.m297b());
        }
        return jMax;
    }

    /* JADX INFO: renamed from: a */
    public static C0005ac m144a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return m143a(context, resourceId);
    }

    /* JADX INFO: renamed from: a */
    public static C0005ac m143a(Context context, int i) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return m145a(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return m145a(arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static C0005ac m145a(List<Animator> list) {
        C0005ac c0005ac = new C0005ac();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m146a(c0005ac, list.get(i));
        }
        return c0005ac;
    }

    /* JADX INFO: renamed from: a */
    private static void m146a(C0005ac c0005ac, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c0005ac.m148a(objectAnimator.getPropertyName(), C0006ad.m293a((ValueAnimator) objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f192a.equals(((C0005ac) obj).f192a);
    }

    public int hashCode() {
        return this.f192a.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f192a + "}\n";
    }
}
