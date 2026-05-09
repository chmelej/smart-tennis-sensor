package android.support.transition;

import android.graphics.Rect;
import android.support.transition.Transition;
import android.support.v4.app.FragmentTransitionImpl;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import p000.C1648cw;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    @Override // android.support.v4.app.FragmentTransitionImpl
    public boolean canHandle(Object obj) {
        return obj instanceof Transition;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.m3104a((Transition) obj);
        return transitionSet;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> listG = transitionSet.m3091g();
        listG.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bfsAddViewChildren(listG, arrayList.get(i));
        }
        listG.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((Transition) obj).mo3069a(new Transition.AbstractC0368b() { // from class: android.support.transition.FragmentTransitionSupport.1
                @Override // android.support.transition.Transition.AbstractC0368b
                /* JADX INFO: renamed from: a */
                public Rect mo3040a(Transition transition) {
                    return rect;
                }
            });
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iM3113r = transitionSet.m3113r();
            while (i < iM3113r) {
                addTargets(transitionSet.m3106b(i), arrayList);
                i++;
            }
            return;
        }
        if (m3039a(transition) || !isNullOrEmpty(transition.m3091g())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.mo3083c(arrayList.get(i));
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3039a(Transition transition) {
        return (isNullOrEmpty(transition.m3089f()) && isNullOrEmpty(transition.m3092h()) && isNullOrEmpty(transition.m3093i())) ? false : true;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.m3104a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.m3104a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.m3104a((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).mo3064a(new Transition.InterfaceC0369c() { // from class: android.support.transition.FragmentTransitionSupport.2
            @Override // android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: b */
            public void mo2988b(Transition transition) {
            }

            @Override // android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: c */
            public void mo2989c(Transition transition) {
            }

            @Override // android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: d */
            public void mo3041d(Transition transition) {
            }

            @Override // android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: a */
            public void mo2987a(Transition transition) {
                transition.mo3078b(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transitionM3103a = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (transitionM3103a != null && transition != null) {
            transitionM3103a = new TransitionSet().m3104a(transitionM3103a).m3104a(transition).m3103a(1);
        } else if (transitionM3103a == null) {
            transitionM3103a = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return transitionM3103a;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transitionM3103a != null) {
            transitionSet.m3104a(transitionM3103a);
        }
        transitionSet.m3104a(transition2);
        return transitionSet;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        C1648cw.m8820a(viewGroup, (Transition) obj);
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((Transition) obj).mo3064a(new Transition.InterfaceC0369c() { // from class: android.support.transition.FragmentTransitionSupport.3
            @Override // android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: a */
            public void mo2987a(Transition transition) {
            }

            @Override // android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: b */
            public void mo2988b(Transition transition) {
            }

            @Override // android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: c */
            public void mo2989c(Transition transition) {
            }

            @Override // android.support.transition.Transition.InterfaceC0369c
            /* JADX INFO: renamed from: d */
            public void mo3041d(Transition transition) {
                if (obj2 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj2, arrayList, null);
                }
                if (obj3 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj3, arrayList2, null);
                }
                if (obj4 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj4, arrayList3, null);
                }
            }
        });
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.m3091g().clear();
            transitionSet.m3091g().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iM3113r = transitionSet.m3113r();
            while (i < iM3113r) {
                replaceTargets(transitionSet.m3106b(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (m3039a(transition)) {
            return;
        }
        List<View> listM3091g = transition.m3091g();
        if (listM3091g.size() == arrayList.size() && listM3091g.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.mo3083c(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.mo3086d(arrayList.get(size2));
            }
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo3083c(view);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo3086d(view);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).mo3069a(new Transition.AbstractC0368b() { // from class: android.support.transition.FragmentTransitionSupport.4
                @Override // android.support.transition.Transition.AbstractC0368b
                /* JADX INFO: renamed from: a */
                public Rect mo3040a(Transition transition) {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
