package p000;

import android.support.transition.AutoTransition;
import android.support.transition.Transition;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: cw */
/* JADX INFO: compiled from: TransitionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C1648cw {

    /* JADX INFO: renamed from: b */
    private static Transition f9344b = new AutoTransition();

    /* JADX INFO: renamed from: c */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f9345c = new ThreadLocal<>();

    /* JADX INFO: renamed from: a */
    static ArrayList<ViewGroup> f9343a = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    static ArrayMap<ViewGroup, ArrayList<Transition>> m8819a() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = f9345c.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        f9345c.set(new WeakReference<>(arrayMap2));
        return arrayMap2;
    }

    /* JADX INFO: renamed from: b */
    private static void m8821b(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        a aVar = new a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* JADX INFO: renamed from: cw$a */
    /* JADX INFO: compiled from: TransitionManager.java */
    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a */
        Transition f9346a;

        /* JADX INFO: renamed from: b */
        ViewGroup f9347b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        a(Transition transition, ViewGroup viewGroup) {
            this.f9346a = transition;
            this.f9347b = viewGroup;
        }

        /* JADX INFO: renamed from: a */
        private void m8823a() {
            this.f9347b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f9347b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            m8823a();
            C1648cw.f9343a.remove(this.f9347b);
            ArrayList<Transition> arrayList = C1648cw.m8819a().get(this.f9347b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().mo3090f(this.f9347b);
                }
            }
            this.f9346a.m3080b(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            m8823a();
            if (!C1648cw.f9343a.remove(this.f9347b)) {
                return true;
            }
            final ArrayMap<ViewGroup, ArrayList<Transition>> arrayMapM8819a = C1648cw.m8819a();
            ArrayList<Transition> arrayList = arrayMapM8819a.get(this.f9347b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                arrayMapM8819a.put(this.f9347b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f9346a);
            this.f9346a.mo3064a(new C1647cv() { // from class: cw.a.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
                /* JADX INFO: renamed from: a */
                public void mo2987a(Transition transition) {
                    ((ArrayList) arrayMapM8819a.get(a.this.f9347b)).remove(transition);
                }
            });
            this.f9346a.m3072a(this.f9347b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).mo3090f(this.f9347b);
                }
            }
            this.f9346a.m3070a(this.f9347b);
            return true;
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m8822c(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = m8819a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo3088e(viewGroup);
            }
        }
        if (transition != null) {
            transition.m3072a(viewGroup, true);
        }
        C1644cs c1644csM8813a = C1644cs.m8813a(viewGroup);
        if (c1644csM8813a != null) {
            c1644csM8813a.m8815a();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m8820a(ViewGroup viewGroup, Transition transition) {
        if (f9343a.contains(viewGroup) || !ViewCompat.isLaidOut(viewGroup)) {
            return;
        }
        f9343a.add(viewGroup);
        if (transition == null) {
            transition = f9344b;
        }
        Transition transitionClone = transition.clone();
        m8822c(viewGroup, transitionClone);
        C1644cs.m8814a(viewGroup, null);
        m8821b(viewGroup, transitionClone);
    }
}
