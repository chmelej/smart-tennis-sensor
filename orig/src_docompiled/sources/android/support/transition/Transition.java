package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.litepal.util.Const;
import p000.AbstractC1649cx;
import p000.C0791cf;
import p000.C1646cu;
import p000.C1651cz;
import p000.C1653da;
import p000.C1664dl;
import p000.InterfaceC1672dt;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition implements Cloneable {

    /* JADX INFO: renamed from: H */
    private AbstractC0368b f2899H;

    /* JADX INFO: renamed from: I */
    private ArrayMap<String, String> f2900I;

    /* JADX INFO: renamed from: h */
    AbstractC1649cx f2908h;

    /* JADX INFO: renamed from: y */
    private ArrayList<C1651cz> f2924y;

    /* JADX INFO: renamed from: z */
    private ArrayList<C1651cz> f2925z;

    /* JADX INFO: renamed from: a */
    private static final int[] f2891a = {2, 1, 3, 4};

    /* JADX INFO: renamed from: i */
    private static final PathMotion f2892i = new PathMotion() { // from class: android.support.transition.Transition.1
        @Override // android.support.transition.PathMotion
        /* JADX INFO: renamed from: a */
        public Path mo2973a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };

    /* JADX INFO: renamed from: A */
    private static ThreadLocal<ArrayMap<Animator, C0367a>> f2890A = new ThreadLocal<>();

    /* JADX INFO: renamed from: j */
    private String f2909j = getClass().getName();

    /* JADX INFO: renamed from: k */
    private long f2910k = -1;

    /* JADX INFO: renamed from: b */
    long f2902b = -1;

    /* JADX INFO: renamed from: l */
    private TimeInterpolator f2911l = null;

    /* JADX INFO: renamed from: c */
    ArrayList<Integer> f2903c = new ArrayList<>();

    /* JADX INFO: renamed from: d */
    ArrayList<View> f2904d = new ArrayList<>();

    /* JADX INFO: renamed from: m */
    private ArrayList<String> f2912m = null;

    /* JADX INFO: renamed from: n */
    private ArrayList<Class> f2913n = null;

    /* JADX INFO: renamed from: o */
    private ArrayList<Integer> f2914o = null;

    /* JADX INFO: renamed from: p */
    private ArrayList<View> f2915p = null;

    /* JADX INFO: renamed from: q */
    private ArrayList<Class> f2916q = null;

    /* JADX INFO: renamed from: r */
    private ArrayList<String> f2917r = null;

    /* JADX INFO: renamed from: s */
    private ArrayList<Integer> f2918s = null;

    /* JADX INFO: renamed from: t */
    private ArrayList<View> f2919t = null;

    /* JADX INFO: renamed from: u */
    private ArrayList<Class> f2920u = null;

    /* JADX INFO: renamed from: v */
    private C1653da f2921v = new C1653da();

    /* JADX INFO: renamed from: w */
    private C1653da f2922w = new C1653da();

    /* JADX INFO: renamed from: e */
    TransitionSet f2905e = null;

    /* JADX INFO: renamed from: x */
    private int[] f2923x = f2891a;

    /* JADX INFO: renamed from: B */
    private ViewGroup f2893B = null;

    /* JADX INFO: renamed from: f */
    boolean f2906f = false;

    /* JADX INFO: renamed from: g */
    ArrayList<Animator> f2907g = new ArrayList<>();

    /* JADX INFO: renamed from: C */
    private int f2894C = 0;

    /* JADX INFO: renamed from: D */
    private boolean f2895D = false;

    /* JADX INFO: renamed from: E */
    private boolean f2896E = false;

    /* JADX INFO: renamed from: F */
    private ArrayList<InterfaceC0369c> f2897F = null;

    /* JADX INFO: renamed from: G */
    private ArrayList<Animator> f2898G = new ArrayList<>();

    /* JADX INFO: renamed from: J */
    private PathMotion f2901J = f2892i;

    /* JADX INFO: renamed from: android.support.transition.Transition$b */
    public static abstract class AbstractC0368b {
        /* JADX INFO: renamed from: a */
        public abstract Rect mo3040a(Transition transition);
    }

    /* JADX INFO: renamed from: android.support.transition.Transition$c */
    public interface InterfaceC0369c {
        /* JADX INFO: renamed from: a */
        void mo2987a(Transition transition);

        /* JADX INFO: renamed from: b */
        void mo2988b(Transition transition);

        /* JADX INFO: renamed from: c */
        void mo2989c(Transition transition);

        /* JADX INFO: renamed from: d */
        void mo3041d(Transition transition);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3055a(int i) {
        return i >= 1 && i <= 4;
    }

    /* JADX INFO: renamed from: a */
    public Animator mo2980a(ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo2981a(C1651cz c1651cz);

    /* JADX INFO: renamed from: a */
    public String[] mo2983a() {
        return null;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo2984b(C1651cz c1651cz);

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9334c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            mo3062a(namedInt);
        }
        long namedInt2 = TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            mo3077b(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            mo3063a(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            m3074a(m3059b(namedString));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: b */
    private static int[] m3059b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(strTrim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(strTrim)) {
                iArr[i] = 1;
            } else if (Const.TableSchema.COLUMN_NAME.equalsIgnoreCase(strTrim)) {
                iArr[i] = 2;
            } else if ("itemId".equalsIgnoreCase(strTrim)) {
                iArr[i] = 4;
            } else if (strTrim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
            }
            i++;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public Transition mo3062a(long j) {
        this.f2902b = j;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public long m3076b() {
        return this.f2902b;
    }

    /* JADX INFO: renamed from: b */
    public Transition mo3077b(long j) {
        this.f2910k = j;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public long m3082c() {
        return this.f2910k;
    }

    /* JADX INFO: renamed from: a */
    public Transition mo3063a(TimeInterpolator timeInterpolator) {
        this.f2911l = timeInterpolator;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public TimeInterpolator m3085d() {
        return this.f2911l;
    }

    /* JADX INFO: renamed from: a */
    public void m3074a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f2923x = f2891a;
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!m3055a(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (m3057a(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.f2923x = (int[]) iArr.clone();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3057a(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m3049a(ArrayMap<View, C1651cz> arrayMap, ArrayMap<View, C1651cz> arrayMap2) {
        C1651cz c1651czRemove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View viewKeyAt = arrayMap.keyAt(size);
            if (viewKeyAt != null && m3081b(viewKeyAt) && (c1651czRemove = arrayMap2.remove(viewKeyAt)) != null && c1651czRemove.f9357b != null && m3081b(c1651czRemove.f9357b)) {
                this.f2924y.add(arrayMap.removeAt(size));
                this.f2925z.add(c1651czRemove);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3051a(ArrayMap<View, C1651cz> arrayMap, ArrayMap<View, C1651cz> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = longSparseArray.valueAt(i);
            if (viewValueAt != null && m3081b(viewValueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i))) != null && m3081b(view)) {
                C1651cz c1651cz = arrayMap.get(viewValueAt);
                C1651cz c1651cz2 = arrayMap2.get(view);
                if (c1651cz != null && c1651cz2 != null) {
                    this.f2924y.add(c1651cz);
                    this.f2925z.add(c1651cz2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3052a(ArrayMap<View, C1651cz> arrayMap, ArrayMap<View, C1651cz> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null && m3081b(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && m3081b(view)) {
                C1651cz c1651cz = arrayMap.get(viewValueAt);
                C1651cz c1651cz2 = arrayMap2.get(view);
                if (c1651cz != null && c1651cz2 != null) {
                    this.f2924y.add(c1651cz);
                    this.f2925z.add(c1651cz2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3050a(ArrayMap<View, C1651cz> arrayMap, ArrayMap<View, C1651cz> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = arrayMap3.valueAt(i);
            if (viewValueAt != null && m3081b(viewValueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i))) != null && m3081b(view)) {
                C1651cz c1651cz = arrayMap.get(viewValueAt);
                C1651cz c1651cz2 = arrayMap2.get(view);
                if (c1651cz != null && c1651cz2 != null) {
                    this.f2924y.add(c1651cz);
                    this.f2925z.add(c1651cz2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3058b(ArrayMap<View, C1651cz> arrayMap, ArrayMap<View, C1651cz> arrayMap2) {
        for (int i = 0; i < arrayMap.size(); i++) {
            C1651cz c1651czValueAt = arrayMap.valueAt(i);
            if (m3081b(c1651czValueAt.f9357b)) {
                this.f2924y.add(c1651czValueAt);
                this.f2925z.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            C1651cz c1651czValueAt2 = arrayMap2.valueAt(i2);
            if (m3081b(c1651czValueAt2.f9357b)) {
                this.f2925z.add(c1651czValueAt2);
                this.f2924y.add(null);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3054a(C1653da c1653da, C1653da c1653da2) {
        ArrayMap<View, C1651cz> arrayMap = new ArrayMap<>(c1653da.f9360a);
        ArrayMap<View, C1651cz> arrayMap2 = new ArrayMap<>(c1653da2.f9360a);
        for (int i = 0; i < this.f2923x.length; i++) {
            switch (this.f2923x[i]) {
                case 1:
                    m3049a(arrayMap, arrayMap2);
                    break;
                case 2:
                    m3050a(arrayMap, arrayMap2, c1653da.f9363d, c1653da2.f9363d);
                    break;
                case 3:
                    m3052a(arrayMap, arrayMap2, c1653da.f9361b, c1653da2.f9361b);
                    break;
                case 4:
                    m3051a(arrayMap, arrayMap2, c1653da.f9362c, c1653da2.f9362c);
                    break;
            }
        }
        m3058b(arrayMap, arrayMap2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void mo3071a(android.view.ViewGroup r21, p000.C1653da r22, p000.C1653da r23, java.util.ArrayList<p000.C1651cz> r24, java.util.ArrayList<p000.C1651cz> r25) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Transition.mo3071a(android.view.ViewGroup, da, da, java.util.ArrayList, java.util.ArrayList):void");
    }

    /* JADX INFO: renamed from: b */
    boolean m3081b(View view) {
        int id = view.getId();
        if (this.f2914o != null && this.f2914o.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.f2915p != null && this.f2915p.contains(view)) {
            return false;
        }
        if (this.f2916q != null) {
            int size = this.f2916q.size();
            for (int i = 0; i < size; i++) {
                if (this.f2916q.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f2917r != null && ViewCompat.getTransitionName(view) != null && this.f2917r.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.f2903c.size() == 0 && this.f2904d.size() == 0 && ((this.f2913n == null || this.f2913n.isEmpty()) && (this.f2912m == null || this.f2912m.isEmpty()))) || this.f2903c.contains(Integer.valueOf(id)) || this.f2904d.contains(view)) {
            return true;
        }
        if (this.f2912m != null && this.f2912m.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.f2913n != null) {
            for (int i2 = 0; i2 < this.f2913n.size(); i2++) {
                if (this.f2913n.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: r */
    private static ArrayMap<Animator, C0367a> m3061r() {
        ArrayMap<Animator, C0367a> arrayMap = f2890A.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, C0367a> arrayMap2 = new ArrayMap<>();
        f2890A.set(arrayMap2);
        return arrayMap2;
    }

    /* JADX INFO: renamed from: e */
    protected void mo3087e() {
        m3094j();
        ArrayMap<Animator, C0367a> arrayMapM3061r = m3061r();
        for (Animator animator : this.f2898G) {
            if (arrayMapM3061r.containsKey(animator)) {
                m3094j();
                m3048a(animator, arrayMapM3061r);
            }
        }
        this.f2898G.clear();
        m3095k();
    }

    /* JADX INFO: renamed from: a */
    private void m3048a(Animator animator, final ArrayMap<Animator, C0367a> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.Transition.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.f2907g.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.f2907g.remove(animator2);
                }
            });
            m3067a(animator);
        }
    }

    /* JADX INFO: renamed from: c */
    public Transition mo3083c(View view) {
        this.f2904d.add(view);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public Transition mo3086d(View view) {
        this.f2904d.remove(view);
        return this;
    }

    /* JADX INFO: renamed from: f */
    public List<Integer> m3089f() {
        return this.f2903c;
    }

    /* JADX INFO: renamed from: g */
    public List<View> m3091g() {
        return this.f2904d;
    }

    /* JADX INFO: renamed from: h */
    public List<String> m3092h() {
        return this.f2912m;
    }

    /* JADX INFO: renamed from: i */
    public List<Class> m3093i() {
        return this.f2913n;
    }

    /* JADX INFO: renamed from: a */
    public void m3072a(ViewGroup viewGroup, boolean z) {
        m3080b(z);
        if ((this.f2903c.size() > 0 || this.f2904d.size() > 0) && ((this.f2912m == null || this.f2912m.isEmpty()) && (this.f2913n == null || this.f2913n.isEmpty()))) {
            for (int i = 0; i < this.f2903c.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(this.f2903c.get(i).intValue());
                if (viewFindViewById != null) {
                    C1651cz c1651cz = new C1651cz();
                    c1651cz.f9357b = viewFindViewById;
                    if (z) {
                        mo2981a(c1651cz);
                    } else {
                        mo2984b(c1651cz);
                    }
                    c1651cz.f9358c.add(this);
                    mo3084c(c1651cz);
                    if (z) {
                        m3053a(this.f2921v, viewFindViewById, c1651cz);
                    } else {
                        m3053a(this.f2922w, viewFindViewById, c1651cz);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f2904d.size(); i2++) {
                View view = this.f2904d.get(i2);
                C1651cz c1651cz2 = new C1651cz();
                c1651cz2.f9357b = view;
                if (z) {
                    mo2981a(c1651cz2);
                } else {
                    mo2984b(c1651cz2);
                }
                c1651cz2.f9358c.add(this);
                mo3084c(c1651cz2);
                if (z) {
                    m3053a(this.f2921v, view, c1651cz2);
                } else {
                    m3053a(this.f2922w, view, c1651cz2);
                }
            }
        } else {
            m3060c(viewGroup, z);
        }
        if (z || this.f2900I == null) {
            return;
        }
        int size = this.f2900I.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(this.f2921v.f9363d.remove(this.f2900I.keyAt(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList.get(i4);
            if (view2 != null) {
                this.f2921v.f9363d.put(this.f2900I.valueAt(i4), view2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3053a(C1653da c1653da, View view, C1651cz c1651cz) {
        c1653da.f9360a.put(view, c1651cz);
        int id = view.getId();
        if (id >= 0) {
            if (c1653da.f9361b.indexOfKey(id) >= 0) {
                c1653da.f9361b.put(id, null);
            } else {
                c1653da.f9361b.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (c1653da.f9363d.containsKey(transitionName)) {
                c1653da.f9363d.put(transitionName, null);
            } else {
                c1653da.f9363d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (c1653da.f9362c.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = c1653da.f9362c.get(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.setHasTransientState(view2, false);
                        c1653da.f9362c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.setHasTransientState(view, true);
                c1653da.f9362c.put(itemIdAtPosition, view);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3080b(boolean z) {
        if (z) {
            this.f2921v.f9360a.clear();
            this.f2921v.f9361b.clear();
            this.f2921v.f9362c.clear();
        } else {
            this.f2922w.f9360a.clear();
            this.f2922w.f9361b.clear();
            this.f2922w.f9362c.clear();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3060c(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (this.f2914o == null || !this.f2914o.contains(Integer.valueOf(id))) {
            if (this.f2915p == null || !this.f2915p.contains(view)) {
                if (this.f2916q != null) {
                    int size = this.f2916q.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f2916q.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    C1651cz c1651cz = new C1651cz();
                    c1651cz.f9357b = view;
                    if (z) {
                        mo2981a(c1651cz);
                    } else {
                        mo2984b(c1651cz);
                    }
                    c1651cz.f9358c.add(this);
                    mo3084c(c1651cz);
                    if (z) {
                        m3053a(this.f2921v, view, c1651cz);
                    } else {
                        m3053a(this.f2922w, view, c1651cz);
                    }
                }
                if (view instanceof ViewGroup) {
                    if (this.f2918s == null || !this.f2918s.contains(Integer.valueOf(id))) {
                        if (this.f2919t == null || !this.f2919t.contains(view)) {
                            if (this.f2920u != null) {
                                int size2 = this.f2920u.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.f2920u.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                m3060c(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public C1651cz m3065a(View view, boolean z) {
        if (this.f2905e != null) {
            return this.f2905e.m3065a(view, z);
        }
        return (z ? this.f2921v : this.f2922w).f9360a.get(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        if (r3 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:
    
        r7 = r6.f2925z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        r7 = r6.f2924y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        return r7.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return null;
     */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    p000.C1651cz m3079b(android.view.View r7, boolean r8) {
        /*
            r6 = this;
            android.support.transition.TransitionSet r0 = r6.f2905e
            if (r0 == 0) goto Lb
            android.support.transition.TransitionSet r0 = r6.f2905e
            cz r7 = r0.m3079b(r7, r8)
            return r7
        Lb:
            if (r8 == 0) goto L10
            java.util.ArrayList<cz> r0 = r6.f2924y
            goto L12
        L10:
            java.util.ArrayList<cz> r0 = r6.f2925z
        L12:
            r1 = 0
            if (r0 != 0) goto L16
            return r1
        L16:
            int r2 = r0.size()
            r3 = -1
            r4 = 0
        L1c:
            if (r4 >= r2) goto L30
            java.lang.Object r5 = r0.get(r4)
            cz r5 = (p000.C1651cz) r5
            if (r5 != 0) goto L27
            return r1
        L27:
            android.view.View r5 = r5.f9357b
            if (r5 != r7) goto L2d
            r3 = r4
            goto L30
        L2d:
            int r4 = r4 + 1
            goto L1c
        L30:
            if (r3 < 0) goto L40
            if (r8 == 0) goto L37
            java.util.ArrayList<cz> r7 = r6.f2925z
            goto L39
        L37:
            java.util.ArrayList<cz> r7 = r6.f2924y
        L39:
            java.lang.Object r7 = r7.get(r3)
            r1 = r7
            cz r1 = (p000.C1651cz) r1
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Transition.m3079b(android.view.View, boolean):cz");
    }

    /* JADX INFO: renamed from: e */
    public void mo3088e(View view) {
        if (this.f2896E) {
            return;
        }
        ArrayMap<Animator, C0367a> arrayMapM3061r = m3061r();
        int size = arrayMapM3061r.size();
        InterfaceC1672dt interfaceC1672dtM8866b = C1664dl.m8866b(view);
        for (int i = size - 1; i >= 0; i--) {
            C0367a c0367aValueAt = arrayMapM3061r.valueAt(i);
            if (c0367aValueAt.f2929a != null && interfaceC1672dtM8866b.equals(c0367aValueAt.f2932d)) {
                C0791cf.m5779a(arrayMapM3061r.keyAt(i));
            }
        }
        if (this.f2897F != null && this.f2897F.size() > 0) {
            ArrayList arrayList = (ArrayList) this.f2897F.clone();
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((InterfaceC0369c) arrayList.get(i2)).mo2988b(this);
            }
        }
        this.f2895D = true;
    }

    /* JADX INFO: renamed from: f */
    public void mo3090f(View view) {
        if (this.f2895D) {
            if (!this.f2896E) {
                ArrayMap<Animator, C0367a> arrayMapM3061r = m3061r();
                int size = arrayMapM3061r.size();
                InterfaceC1672dt interfaceC1672dtM8866b = C1664dl.m8866b(view);
                for (int i = size - 1; i >= 0; i--) {
                    C0367a c0367aValueAt = arrayMapM3061r.valueAt(i);
                    if (c0367aValueAt.f2929a != null && interfaceC1672dtM8866b.equals(c0367aValueAt.f2932d)) {
                        C0791cf.m5781b(arrayMapM3061r.keyAt(i));
                    }
                }
                if (this.f2897F != null && this.f2897F.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.f2897F.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((InterfaceC0369c) arrayList.get(i2)).mo2989c(this);
                    }
                }
            }
            this.f2895D = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3070a(ViewGroup viewGroup) {
        C0367a c0367a;
        this.f2924y = new ArrayList<>();
        this.f2925z = new ArrayList<>();
        m3054a(this.f2921v, this.f2922w);
        ArrayMap<Animator, C0367a> arrayMapM3061r = m3061r();
        int size = arrayMapM3061r.size();
        InterfaceC1672dt interfaceC1672dtM8866b = C1664dl.m8866b(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animatorKeyAt = arrayMapM3061r.keyAt(i);
            if (animatorKeyAt != null && (c0367a = arrayMapM3061r.get(animatorKeyAt)) != null && c0367a.f2929a != null && interfaceC1672dtM8866b.equals(c0367a.f2932d)) {
                C1651cz c1651cz = c0367a.f2931c;
                View view = c0367a.f2929a;
                C1651cz c1651czM3065a = m3065a(view, true);
                C1651cz c1651czM3079b = m3079b(view, true);
                if (!(c1651czM3065a == null && c1651czM3079b == null) && c0367a.f2933e.mo3075a(c1651cz, c1651czM3079b)) {
                    if (animatorKeyAt.isRunning() || animatorKeyAt.isStarted()) {
                        animatorKeyAt.cancel();
                    } else {
                        arrayMapM3061r.remove(animatorKeyAt);
                    }
                }
            }
        }
        mo3071a(viewGroup, this.f2921v, this.f2922w, this.f2924y, this.f2925z);
        mo3087e();
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3075a(C1651cz c1651cz, C1651cz c1651cz2) {
        if (c1651cz == null || c1651cz2 == null) {
            return false;
        }
        String[] strArrMo2983a = mo2983a();
        if (strArrMo2983a != null) {
            for (String str : strArrMo2983a) {
                if (!m3056a(c1651cz, c1651cz2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = c1651cz.f9356a.keySet().iterator();
        while (it.hasNext()) {
            if (m3056a(c1651cz, c1651cz2, it.next())) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m3056a(C1651cz c1651cz, C1651cz c1651cz2, String str) {
        Object obj = c1651cz.f9356a.get(str);
        Object obj2 = c1651cz2.f9356a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    /* JADX INFO: renamed from: a */
    protected void m3067a(Animator animator) {
        if (animator == null) {
            m3095k();
            return;
        }
        if (m3076b() >= 0) {
            animator.setDuration(m3076b());
        }
        if (m3082c() >= 0) {
            animator.setStartDelay(m3082c());
        }
        if (m3085d() != null) {
            animator.setInterpolator(m3085d());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.m3095k();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* JADX INFO: renamed from: j */
    protected void m3094j() {
        if (this.f2894C == 0) {
            if (this.f2897F != null && this.f2897F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f2897F.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((InterfaceC0369c) arrayList.get(i)).mo3041d(this);
                }
            }
            this.f2896E = false;
        }
        this.f2894C++;
    }

    /* JADX INFO: renamed from: k */
    protected void m3095k() {
        this.f2894C--;
        if (this.f2894C == 0) {
            if (this.f2897F != null && this.f2897F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f2897F.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((InterfaceC0369c) arrayList.get(i)).mo2987a(this);
                }
            }
            for (int i2 = 0; i2 < this.f2921v.f9362c.size(); i2++) {
                View viewValueAt = this.f2921v.f9362c.valueAt(i2);
                if (viewValueAt != null) {
                    ViewCompat.setHasTransientState(viewValueAt, false);
                }
            }
            for (int i3 = 0; i3 < this.f2922w.f9362c.size(); i3++) {
                View viewValueAt2 = this.f2922w.f9362c.valueAt(i3);
                if (viewValueAt2 != null) {
                    ViewCompat.setHasTransientState(viewValueAt2, false);
                }
            }
            this.f2896E = true;
        }
    }

    /* JADX INFO: renamed from: a */
    public Transition mo3064a(InterfaceC0369c interfaceC0369c) {
        if (this.f2897F == null) {
            this.f2897F = new ArrayList<>();
        }
        this.f2897F.add(interfaceC0369c);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public Transition mo3078b(InterfaceC0369c interfaceC0369c) {
        if (this.f2897F == null) {
            return this;
        }
        this.f2897F.remove(interfaceC0369c);
        if (this.f2897F.size() == 0) {
            this.f2897F = null;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void mo3068a(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.f2901J = f2892i;
        } else {
            this.f2901J = pathMotion;
        }
    }

    /* JADX INFO: renamed from: l */
    public PathMotion m3096l() {
        return this.f2901J;
    }

    /* JADX INFO: renamed from: a */
    public void mo3069a(AbstractC0368b abstractC0368b) {
        this.f2899H = abstractC0368b;
    }

    /* JADX INFO: renamed from: m */
    public AbstractC0368b m3097m() {
        return this.f2899H;
    }

    /* JADX INFO: renamed from: n */
    public Rect m3098n() {
        if (this.f2899H == null) {
            return null;
        }
        return this.f2899H.mo3040a(this);
    }

    /* JADX INFO: renamed from: a */
    public void mo3073a(AbstractC1649cx abstractC1649cx) {
        this.f2908h = abstractC1649cx;
    }

    /* JADX INFO: renamed from: o */
    public AbstractC1649cx m3099o() {
        return this.f2908h;
    }

    /* JADX INFO: renamed from: c */
    void mo3084c(C1651cz c1651cz) {
        String[] strArrMo8825a;
        if (this.f2908h == null || c1651cz.f9356a.isEmpty() || (strArrMo8825a = this.f2908h.mo8825a()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strArrMo8825a.length) {
                z = true;
                break;
            } else if (!c1651cz.f9356a.containsKey(strArrMo8825a[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.f2908h.mo8824a(c1651cz);
    }

    public String toString() {
        return mo3066a("");
    }

    @Override // 
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.f2898G = new ArrayList<>();
            transition.f2921v = new C1653da();
            transition.f2922w = new C1653da();
            transition.f2924y = null;
            transition.f2925z = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: q */
    public String m3101q() {
        return this.f2909j;
    }

    /* JADX INFO: renamed from: a */
    String mo3066a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2902b != -1) {
            str2 = str2 + "dur(" + this.f2902b + ") ";
        }
        if (this.f2910k != -1) {
            str2 = str2 + "dly(" + this.f2910k + ") ";
        }
        if (this.f2911l != null) {
            str2 = str2 + "interp(" + this.f2911l + ") ";
        }
        if (this.f2903c.size() <= 0 && this.f2904d.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f2903c.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.f2903c.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.f2903c.get(i);
            }
            str3 = str4;
        }
        if (this.f2904d.size() > 0) {
            for (int i2 = 0; i2 < this.f2904d.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f2904d.get(i2);
            }
        }
        return str3 + ")";
    }

    /* JADX INFO: renamed from: android.support.transition.Transition$a */
    static class C0367a {

        /* JADX INFO: renamed from: a */
        View f2929a;

        /* JADX INFO: renamed from: b */
        String f2930b;

        /* JADX INFO: renamed from: c */
        C1651cz f2931c;

        /* JADX INFO: renamed from: d */
        InterfaceC1672dt f2932d;

        /* JADX INFO: renamed from: e */
        Transition f2933e;

        C0367a(View view, String str, Transition transition, InterfaceC1672dt interfaceC1672dt, C1651cz c1651cz) {
            this.f2929a = view;
            this.f2930b = str;
            this.f2931c = c1651cz;
            this.f2932d = interfaceC1672dt;
            this.f2933e = transition;
        }
    }
}
