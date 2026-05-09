package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: gg */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class C1742gg extends AbstractC1758gw {

    /* JADX INFO: renamed from: i */
    private static TimeInterpolator f9915i;

    /* JADX INFO: renamed from: j */
    private ArrayList<RecyclerView.AbstractC0624v> f9923j = new ArrayList<>();

    /* JADX INFO: renamed from: k */
    private ArrayList<RecyclerView.AbstractC0624v> f9924k = new ArrayList<>();

    /* JADX INFO: renamed from: l */
    private ArrayList<b> f9925l = new ArrayList<>();

    /* JADX INFO: renamed from: m */
    private ArrayList<a> f9926m = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    ArrayList<ArrayList<RecyclerView.AbstractC0624v>> f9916a = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    ArrayList<ArrayList<b>> f9917b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    ArrayList<ArrayList<a>> f9918c = new ArrayList<>();

    /* JADX INFO: renamed from: d */
    ArrayList<RecyclerView.AbstractC0624v> f9919d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    ArrayList<RecyclerView.AbstractC0624v> f9920e = new ArrayList<>();

    /* JADX INFO: renamed from: f */
    ArrayList<RecyclerView.AbstractC0624v> f9921f = new ArrayList<>();

    /* JADX INFO: renamed from: g */
    ArrayList<RecyclerView.AbstractC0624v> f9922g = new ArrayList<>();

    /* JADX INFO: renamed from: gg$b */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    static class b {

        /* JADX INFO: renamed from: a */
        public RecyclerView.AbstractC0624v f9961a;

        /* JADX INFO: renamed from: b */
        public int f9962b;

        /* JADX INFO: renamed from: c */
        public int f9963c;

        /* JADX INFO: renamed from: d */
        public int f9964d;

        /* JADX INFO: renamed from: e */
        public int f9965e;

        b(RecyclerView.AbstractC0624v abstractC0624v, int i, int i2, int i3, int i4) {
            this.f9961a = abstractC0624v;
            this.f9962b = i;
            this.f9963c = i2;
            this.f9964d = i3;
            this.f9965e = i4;
        }
    }

    /* JADX INFO: renamed from: gg$a */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    static class a {

        /* JADX INFO: renamed from: a */
        public RecyclerView.AbstractC0624v f9955a;

        /* JADX INFO: renamed from: b */
        public RecyclerView.AbstractC0624v f9956b;

        /* JADX INFO: renamed from: c */
        public int f9957c;

        /* JADX INFO: renamed from: d */
        public int f9958d;

        /* JADX INFO: renamed from: e */
        public int f9959e;

        /* JADX INFO: renamed from: f */
        public int f9960f;

        private a(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0624v abstractC0624v2) {
            this.f9955a = abstractC0624v;
            this.f9956b = abstractC0624v2;
        }

        a(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0624v abstractC0624v2, int i, int i2, int i3, int i4) {
            this(abstractC0624v, abstractC0624v2);
            this.f9957c = i;
            this.f9958d = i2;
            this.f9959e = i3;
            this.f9960f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f9955a + ", newHolder=" + this.f9956b + ", fromX=" + this.f9957c + ", fromY=" + this.f9958d + ", toX=" + this.f9959e + ", toY=" + this.f9960f + '}';
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: a */
    public void mo3888a() {
        boolean z = !this.f9923j.isEmpty();
        boolean z2 = !this.f9925l.isEmpty();
        boolean z3 = !this.f9926m.isEmpty();
        boolean z4 = !this.f9924k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.AbstractC0624v> it = this.f9923j.iterator();
            while (it.hasNext()) {
                m9414u(it.next());
            }
            this.f9923j.clear();
            if (z2) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.f9925l);
                this.f9917b.add(arrayList);
                this.f9925l.clear();
                Runnable runnable = new Runnable() { // from class: gg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (b bVar : arrayList) {
                            C1742gg.this.m9421b(bVar.f9961a, bVar.f9962b, bVar.f9963c, bVar.f9964d, bVar.f9965e);
                        }
                        arrayList.clear();
                        C1742gg.this.f9917b.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).f9961a.f3823a, runnable, m3901g());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f9926m);
                this.f9918c.add(arrayList2);
                this.f9926m.clear();
                Runnable runnable2 = new Runnable() { // from class: gg.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            C1742gg.this.m9416a((a) it2.next());
                        }
                        arrayList2.clear();
                        C1742gg.this.f9918c.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).f9955a.f3823a, runnable2, m3901g());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.AbstractC0624v> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f9924k);
                this.f9916a.add(arrayList3);
                this.f9924k.clear();
                Runnable runnable3 = new Runnable() { // from class: gg.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            C1742gg.this.m9424c((RecyclerView.AbstractC0624v) it2.next());
                        }
                        arrayList3.clear();
                        C1742gg.this.f9916a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.postOnAnimationDelayed(arrayList3.get(0).f3823a, runnable3, (z ? m3901g() : 0L) + Math.max(z2 ? m3898e() : 0L, z3 ? m3903h() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // p000.AbstractC1758gw
    /* JADX INFO: renamed from: a */
    public boolean mo9418a(RecyclerView.AbstractC0624v abstractC0624v) {
        m9415v(abstractC0624v);
        this.f9923j.add(abstractC0624v);
        return true;
    }

    /* JADX INFO: renamed from: u */
    private void m9414u(final RecyclerView.AbstractC0624v abstractC0624v) {
        final View view = abstractC0624v.f3823a;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f9921f.add(abstractC0624v);
        viewPropertyAnimatorAnimate.setDuration(m3901g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: gg.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                C1742gg.this.m9558l(abstractC0624v);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                C1742gg.this.m9555i(abstractC0624v);
                C1742gg.this.f9921f.remove(abstractC0624v);
                C1742gg.this.m9423c();
            }
        }).start();
    }

    @Override // p000.AbstractC1758gw
    /* JADX INFO: renamed from: b */
    public boolean mo9422b(RecyclerView.AbstractC0624v abstractC0624v) {
        m9415v(abstractC0624v);
        abstractC0624v.f3823a.setAlpha(0.0f);
        this.f9924k.add(abstractC0624v);
        return true;
    }

    /* JADX INFO: renamed from: c */
    void m9424c(final RecyclerView.AbstractC0624v abstractC0624v) {
        final View view = abstractC0624v.f3823a;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f9919d.add(abstractC0624v);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(m3899f()).setListener(new AnimatorListenerAdapter() { // from class: gg.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                C1742gg.this.m9560n(abstractC0624v);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                C1742gg.this.m9557k(abstractC0624v);
                C1742gg.this.f9919d.remove(abstractC0624v);
                C1742gg.this.m9423c();
            }
        }).start();
    }

    @Override // p000.AbstractC1758gw
    /* JADX INFO: renamed from: a */
    public boolean mo9419a(RecyclerView.AbstractC0624v abstractC0624v, int i, int i2, int i3, int i4) {
        View view = abstractC0624v.f3823a;
        int translationX = i + ((int) abstractC0624v.f3823a.getTranslationX());
        int translationY = i2 + ((int) abstractC0624v.f3823a.getTranslationY());
        m9415v(abstractC0624v);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            m9556j(abstractC0624v);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.f9925l.add(new b(abstractC0624v, translationX, translationY, i3, i4));
        return true;
    }

    /* JADX INFO: renamed from: b */
    void m9421b(final RecyclerView.AbstractC0624v abstractC0624v, int i, int i2, int i3, int i4) {
        final View view = abstractC0624v.f3823a;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f9920e.add(abstractC0624v);
        viewPropertyAnimatorAnimate.setDuration(m3898e()).setListener(new AnimatorListenerAdapter() { // from class: gg.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                C1742gg.this.m9559m(abstractC0624v);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                C1742gg.this.m9556j(abstractC0624v);
                C1742gg.this.f9920e.remove(abstractC0624v);
                C1742gg.this.m9423c();
            }
        }).start();
    }

    @Override // p000.AbstractC1758gw
    /* JADX INFO: renamed from: a */
    public boolean mo9420a(RecyclerView.AbstractC0624v abstractC0624v, RecyclerView.AbstractC0624v abstractC0624v2, int i, int i2, int i3, int i4) {
        if (abstractC0624v == abstractC0624v2) {
            return mo9419a(abstractC0624v, i, i2, i3, i4);
        }
        float translationX = abstractC0624v.f3823a.getTranslationX();
        float translationY = abstractC0624v.f3823a.getTranslationY();
        float alpha = abstractC0624v.f3823a.getAlpha();
        m9415v(abstractC0624v);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        abstractC0624v.f3823a.setTranslationX(translationX);
        abstractC0624v.f3823a.setTranslationY(translationY);
        abstractC0624v.f3823a.setAlpha(alpha);
        if (abstractC0624v2 != null) {
            m9415v(abstractC0624v2);
            abstractC0624v2.f3823a.setTranslationX(-i5);
            abstractC0624v2.f3823a.setTranslationY(-i6);
            abstractC0624v2.f3823a.setAlpha(0.0f);
        }
        this.f9926m.add(new a(abstractC0624v, abstractC0624v2, i, i2, i3, i4));
        return true;
    }

    /* JADX INFO: renamed from: a */
    void m9416a(final a aVar) {
        RecyclerView.AbstractC0624v abstractC0624v = aVar.f9955a;
        final View view = abstractC0624v == null ? null : abstractC0624v.f3823a;
        RecyclerView.AbstractC0624v abstractC0624v2 = aVar.f9956b;
        final View view2 = abstractC0624v2 != null ? abstractC0624v2.f3823a : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(m3903h());
            this.f9922g.add(aVar.f9955a);
            duration.translationX(aVar.f9959e - aVar.f9957c);
            duration.translationY(aVar.f9960f - aVar.f9958d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: gg.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    C1742gg.this.m9552b(aVar.f9955a, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    C1742gg.this.m9551a(aVar.f9955a, true);
                    C1742gg.this.f9922g.remove(aVar.f9955a);
                    C1742gg.this.m9423c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f9922g.add(aVar.f9956b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m3903h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: gg.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    C1742gg.this.m9552b(aVar.f9956b, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    C1742gg.this.m9551a(aVar.f9956b, false);
                    C1742gg.this.f9922g.remove(aVar.f9956b);
                    C1742gg.this.m9423c();
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9411a(List<a> list, RecyclerView.AbstractC0624v abstractC0624v) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (m9412a(aVar, abstractC0624v) && aVar.f9955a == null && aVar.f9956b == null) {
                list.remove(aVar);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m9413b(a aVar) {
        if (aVar.f9955a != null) {
            m9412a(aVar, aVar.f9955a);
        }
        if (aVar.f9956b != null) {
            m9412a(aVar, aVar.f9956b);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m9412a(a aVar, RecyclerView.AbstractC0624v abstractC0624v) {
        boolean z = false;
        if (aVar.f9956b == abstractC0624v) {
            aVar.f9956b = null;
        } else {
            if (aVar.f9955a != abstractC0624v) {
                return false;
            }
            aVar.f9955a = null;
            z = true;
        }
        abstractC0624v.f3823a.setAlpha(1.0f);
        abstractC0624v.f3823a.setTranslationX(0.0f);
        abstractC0624v.f3823a.setTranslationY(0.0f);
        m9551a(abstractC0624v, z);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: d */
    public void mo3897d(RecyclerView.AbstractC0624v abstractC0624v) {
        View view = abstractC0624v.f3823a;
        view.animate().cancel();
        int size = this.f9925l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f9925l.get(size).f9961a == abstractC0624v) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m9556j(abstractC0624v);
                this.f9925l.remove(size);
            }
        }
        m9411a(this.f9926m, abstractC0624v);
        if (this.f9923j.remove(abstractC0624v)) {
            view.setAlpha(1.0f);
            m9555i(abstractC0624v);
        }
        if (this.f9924k.remove(abstractC0624v)) {
            view.setAlpha(1.0f);
            m9557k(abstractC0624v);
        }
        for (int size2 = this.f9918c.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.f9918c.get(size2);
            m9411a(arrayList, abstractC0624v);
            if (arrayList.isEmpty()) {
                this.f9918c.remove(size2);
            }
        }
        for (int size3 = this.f9917b.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.f9917b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f9961a == abstractC0624v) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m9556j(abstractC0624v);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f9917b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f9916a.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.AbstractC0624v> arrayList3 = this.f9916a.get(size5);
            if (arrayList3.remove(abstractC0624v)) {
                view.setAlpha(1.0f);
                m9557k(abstractC0624v);
                if (arrayList3.isEmpty()) {
                    this.f9916a.remove(size5);
                }
            }
        }
        this.f9921f.remove(abstractC0624v);
        this.f9919d.remove(abstractC0624v);
        this.f9922g.remove(abstractC0624v);
        this.f9920e.remove(abstractC0624v);
        m9423c();
    }

    /* JADX INFO: renamed from: v */
    private void m9415v(RecyclerView.AbstractC0624v abstractC0624v) {
        if (f9915i == null) {
            f9915i = new ValueAnimator().getInterpolator();
        }
        abstractC0624v.f3823a.animate().setInterpolator(f9915i);
        mo3897d(abstractC0624v);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: b */
    public boolean mo3893b() {
        return (this.f9924k.isEmpty() && this.f9926m.isEmpty() && this.f9925l.isEmpty() && this.f9923j.isEmpty() && this.f9920e.isEmpty() && this.f9921f.isEmpty() && this.f9919d.isEmpty() && this.f9922g.isEmpty() && this.f9917b.isEmpty() && this.f9916a.isEmpty() && this.f9918c.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    void m9423c() {
        if (mo3893b()) {
            return;
        }
        m3905i();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: d */
    public void mo3896d() {
        int size = this.f9925l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.f9925l.get(size);
            View view = bVar.f9961a.f3823a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m9556j(bVar.f9961a);
            this.f9925l.remove(size);
        }
        for (int size2 = this.f9923j.size() - 1; size2 >= 0; size2--) {
            m9555i(this.f9923j.get(size2));
            this.f9923j.remove(size2);
        }
        int size3 = this.f9924k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.AbstractC0624v abstractC0624v = this.f9924k.get(size3);
            abstractC0624v.f3823a.setAlpha(1.0f);
            m9557k(abstractC0624v);
            this.f9924k.remove(size3);
        }
        for (int size4 = this.f9926m.size() - 1; size4 >= 0; size4--) {
            m9413b(this.f9926m.get(size4));
        }
        this.f9926m.clear();
        if (mo3893b()) {
            for (int size5 = this.f9917b.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.f9917b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.f9961a.f3823a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m9556j(bVar2.f9961a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f9917b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f9916a.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.AbstractC0624v> arrayList2 = this.f9916a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.AbstractC0624v abstractC0624v2 = arrayList2.get(size8);
                    abstractC0624v2.f3823a.setAlpha(1.0f);
                    m9557k(abstractC0624v2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f9916a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f9918c.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.f9918c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m9413b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f9918c.remove(arrayList3);
                    }
                }
            }
            m9417a(this.f9921f);
            m9417a(this.f9920e);
            m9417a(this.f9919d);
            m9417a(this.f9922g);
            m3905i();
        }
    }

    /* JADX INFO: renamed from: a */
    void m9417a(List<RecyclerView.AbstractC0624v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f3823a.animate().cancel();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0608f
    /* JADX INFO: renamed from: a */
    public boolean mo3892a(RecyclerView.AbstractC0624v abstractC0624v, List<Object> list) {
        return !list.isEmpty() || super.mo3892a(abstractC0624v, list);
    }
}
