package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.transition.Transition;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import p000.AbstractC1649cx;
import p000.C1646cu;
import p000.C1647cv;
import p000.C1651cz;
import p000.C1653da;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {

    /* JADX INFO: renamed from: a */
    int f2934a;

    /* JADX INFO: renamed from: i */
    boolean f2935i;

    /* JADX INFO: renamed from: j */
    private ArrayList<Transition> f2936j;

    /* JADX INFO: renamed from: k */
    private boolean f2937k;

    /* JADX INFO: renamed from: l */
    private int f2938l;

    public TransitionSet() {
        this.f2936j = new ArrayList<>();
        this.f2937k = true;
        this.f2935i = false;
        this.f2938l = 0;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2936j = new ArrayList<>();
        this.f2937k = true;
        this.f2935i = false;
        this.f2938l = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9340i);
        m3103a(TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public TransitionSet m3103a(int i) {
        switch (i) {
            case 0:
                this.f2937k = true;
                return this;
            case 1:
                this.f2937k = false;
                return this;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
    }

    /* JADX INFO: renamed from: a */
    public TransitionSet m3104a(Transition transition) {
        this.f2936j.add(transition);
        transition.f2905e = this;
        if (this.f2902b >= 0) {
            transition.mo3062a(this.f2902b);
        }
        if ((this.f2938l & 1) != 0) {
            transition.mo3063a(m3085d());
        }
        if ((this.f2938l & 2) != 0) {
            transition.mo3073a(m3099o());
        }
        if ((this.f2938l & 4) != 0) {
            transition.mo3068a(m3096l());
        }
        if ((this.f2938l & 8) != 0) {
            transition.mo3069a(m3097m());
        }
        return this;
    }

    /* JADX INFO: renamed from: r */
    public int m3113r() {
        return this.f2936j.size();
    }

    /* JADX INFO: renamed from: b */
    public Transition m3106b(int i) {
        if (i < 0 || i >= this.f2936j.size()) {
            return null;
        }
        return this.f2936j.get(i);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo3062a(long j) {
        super.mo3062a(j);
        if (this.f2902b >= 0) {
            int size = this.f2936j.size();
            for (int i = 0; i < size; i++) {
                this.f2936j.get(i).mo3062a(j);
            }
        }
        return this;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo3077b(long j) {
        return (TransitionSet) super.mo3077b(j);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo3063a(TimeInterpolator timeInterpolator) {
        this.f2938l |= 1;
        if (this.f2936j != null) {
            int size = this.f2936j.size();
            for (int i = 0; i < size; i++) {
                this.f2936j.get(i).mo3063a(timeInterpolator);
            }
        }
        return (TransitionSet) super.mo3063a(timeInterpolator);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo3083c(View view) {
        for (int i = 0; i < this.f2936j.size(); i++) {
            this.f2936j.get(i).mo3083c(view);
        }
        return (TransitionSet) super.mo3083c(view);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo3064a(Transition.InterfaceC0369c interfaceC0369c) {
        return (TransitionSet) super.mo3064a(interfaceC0369c);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo3086d(View view) {
        for (int i = 0; i < this.f2936j.size(); i++) {
            this.f2936j.get(i).mo3086d(view);
        }
        return (TransitionSet) super.mo3086d(view);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo3078b(Transition.InterfaceC0369c interfaceC0369c) {
        return (TransitionSet) super.mo3078b(interfaceC0369c);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo3068a(PathMotion pathMotion) {
        super.mo3068a(pathMotion);
        this.f2938l |= 4;
        for (int i = 0; i < this.f2936j.size(); i++) {
            this.f2936j.get(i).mo3068a(pathMotion);
        }
    }

    /* JADX INFO: renamed from: s */
    private void m3102s() {
        C0371a c0371a = new C0371a(this);
        Iterator<Transition> it = this.f2936j.iterator();
        while (it.hasNext()) {
            it.next().mo3064a(c0371a);
        }
        this.f2934a = this.f2936j.size();
    }

    /* JADX INFO: renamed from: android.support.transition.TransitionSet$a */
    static class C0371a extends C1647cv {

        /* JADX INFO: renamed from: a */
        TransitionSet f2941a;

        C0371a(TransitionSet transitionSet) {
            this.f2941a = transitionSet;
        }

        @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: d */
        public void mo3041d(Transition transition) {
            if (this.f2941a.f2935i) {
                return;
            }
            this.f2941a.m3094j();
            this.f2941a.f2935i = true;
        }

        @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: a */
        public void mo2987a(Transition transition) {
            TransitionSet transitionSet = this.f2941a;
            transitionSet.f2934a--;
            if (this.f2941a.f2934a == 0) {
                this.f2941a.f2935i = false;
                this.f2941a.m3095k();
            }
            transition.mo3078b(this);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    protected void mo3071a(ViewGroup viewGroup, C1653da c1653da, C1653da c1653da2, ArrayList<C1651cz> arrayList, ArrayList<C1651cz> arrayList2) {
        long jC = m3082c();
        int size = this.f2936j.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.f2936j.get(i);
            if (jC > 0 && (this.f2937k || i == 0)) {
                long jM3082c = transition.m3082c();
                if (jM3082c > 0) {
                    transition.mo3077b(jC + jM3082c);
                } else {
                    transition.mo3077b(jC);
                }
            }
            transition.mo3071a(viewGroup, c1653da, c1653da2, arrayList, arrayList2);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: e */
    protected void mo3087e() {
        if (this.f2936j.isEmpty()) {
            m3094j();
            m3095k();
            return;
        }
        m3102s();
        if (!this.f2937k) {
            for (int i = 1; i < this.f2936j.size(); i++) {
                Transition transition = this.f2936j.get(i - 1);
                final Transition transition2 = this.f2936j.get(i);
                transition.mo3064a(new C1647cv() { // from class: android.support.transition.TransitionSet.1
                    @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
                    /* JADX INFO: renamed from: a */
                    public void mo2987a(Transition transition3) {
                        transition2.mo3087e();
                        transition3.mo3078b(this);
                    }
                });
            }
            Transition transition3 = this.f2936j.get(0);
            if (transition3 != null) {
                transition3.mo3087e();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.f2936j.iterator();
        while (it.hasNext()) {
            it.next().mo3087e();
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        if (m3081b(c1651cz.f9357b)) {
            for (Transition transition : this.f2936j) {
                if (transition.m3081b(c1651cz.f9357b)) {
                    transition.mo2981a(c1651cz);
                    c1651cz.f9358c.add(transition);
                }
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        if (m3081b(c1651cz.f9357b)) {
            for (Transition transition : this.f2936j) {
                if (transition.m3081b(c1651cz.f9357b)) {
                    transition.mo2984b(c1651cz);
                    c1651cz.f9358c.add(transition);
                }
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: c */
    void mo3084c(C1651cz c1651cz) {
        super.mo3084c(c1651cz);
        int size = this.f2936j.size();
        for (int i = 0; i < size; i++) {
            this.f2936j.get(i).mo3084c(c1651cz);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: e */
    public void mo3088e(View view) {
        super.mo3088e(view);
        int size = this.f2936j.size();
        for (int i = 0; i < size; i++) {
            this.f2936j.get(i).mo3088e(view);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: f */
    public void mo3090f(View view) {
        super.mo3090f(view);
        int size = this.f2936j.size();
        for (int i = 0; i < size; i++) {
            this.f2936j.get(i).mo3090f(view);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo3073a(AbstractC1649cx abstractC1649cx) {
        super.mo3073a(abstractC1649cx);
        this.f2938l |= 2;
        int size = this.f2936j.size();
        for (int i = 0; i < size; i++) {
            this.f2936j.get(i).mo3073a(abstractC1649cx);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo3069a(Transition.AbstractC0368b abstractC0368b) {
        super.mo3069a(abstractC0368b);
        this.f2938l |= 8;
        int size = this.f2936j.size();
        for (int i = 0; i < size; i++) {
            this.f2936j.get(i).mo3069a(abstractC0368b);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    String mo3066a(String str) {
        String strMo3066a = super.mo3066a(str);
        for (int i = 0; i < this.f2936j.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strMo3066a);
            sb.append("\n");
            sb.append(this.f2936j.get(i).mo3066a(str + "  "));
            strMo3066a = sb.toString();
        }
        return strMo3066a;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: p */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f2936j = new ArrayList<>();
        int size = this.f2936j.size();
        for (int i = 0; i < size; i++) {
            transitionSet.m3104a(this.f2936j.get(i).clone());
        }
        return transitionSet;
    }
}
