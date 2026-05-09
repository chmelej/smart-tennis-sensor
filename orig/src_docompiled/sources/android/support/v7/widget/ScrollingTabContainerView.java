package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import p000.C1693el;
import p000.C1766hd;
import p000.C1768hf;

/* JADX INFO: loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: l */
    private static final Interpolator f3844l = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a */
    Runnable f3845a;

    /* JADX INFO: renamed from: b */
    LinearLayoutCompat f3846b;

    /* JADX INFO: renamed from: c */
    int f3847c;

    /* JADX INFO: renamed from: d */
    int f3848d;

    /* JADX INFO: renamed from: e */
    protected ViewPropertyAnimator f3849e;

    /* JADX INFO: renamed from: f */
    protected final C0629d f3850f;

    /* JADX INFO: renamed from: g */
    private ViewOnClickListenerC0627b f3851g;

    /* JADX INFO: renamed from: h */
    private Spinner f3852h;

    /* JADX INFO: renamed from: i */
    private boolean f3853i;

    /* JADX INFO: renamed from: j */
    private int f3854j;

    /* JADX INFO: renamed from: k */
    private int f3855k;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.f3850f = new C0629d();
        setHorizontalScrollBarEnabled(false);
        C1693el c1693elM9059a = C1693el.m9059a(context);
        setContentHeight(c1693elM9059a.m9064e());
        this.f3848d = c1693elM9059a.m9066g();
        this.f3846b = m4161d();
        addView(this.f3846b, new ViewGroup.LayoutParams(-2, -1));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f3846b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f3847c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f3847c = View.MeasureSpec.getSize(i) / 2;
            }
            this.f3847c = Math.min(this.f3847c, this.f3848d);
        } else {
            this.f3847c = -1;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f3854j, 1073741824);
        if (!z && this.f3853i) {
            this.f3846b.measure(0, iMakeMeasureSpec);
            if (this.f3846b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m4159b();
            } else {
                m4160c();
            }
        } else {
            m4160c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f3855k);
    }

    /* JADX INFO: renamed from: a */
    private boolean m4158a() {
        return this.f3852h != null && this.f3852h.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f3853i = z;
    }

    /* JADX INFO: renamed from: b */
    private void m4159b() {
        if (m4158a()) {
            return;
        }
        if (this.f3852h == null) {
            this.f3852h = m4162e();
        }
        removeView(this.f3846b);
        addView(this.f3852h, new ViewGroup.LayoutParams(-2, -1));
        if (this.f3852h.getAdapter() == null) {
            this.f3852h.setAdapter((SpinnerAdapter) new C0626a());
        }
        if (this.f3845a != null) {
            removeCallbacks(this.f3845a);
            this.f3845a = null;
        }
        this.f3852h.setSelection(this.f3855k);
    }

    /* JADX INFO: renamed from: c */
    private boolean m4160c() {
        if (!m4158a()) {
            return false;
        }
        removeView(this.f3852h);
        addView(this.f3846b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f3852h.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        this.f3855k = i;
        int childCount = this.f3846b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f3846b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m4164a(i);
            }
            i2++;
        }
        if (this.f3852h == null || i < 0) {
            return;
        }
        this.f3852h.setSelection(i);
    }

    public void setContentHeight(int i) {
        this.f3854j = i;
        requestLayout();
    }

    /* JADX INFO: renamed from: d */
    private LinearLayoutCompat m4161d() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    /* JADX INFO: renamed from: e */
    private Spinner m4162e() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C1693el c1693elM9059a = C1693el.m9059a(getContext());
        setContentHeight(c1693elM9059a.m9064e());
        this.f3848d = c1693elM9059a.m9066g();
    }

    /* JADX INFO: renamed from: a */
    public void m4164a(int i) {
        final View childAt = this.f3846b.getChildAt(i);
        if (this.f3845a != null) {
            removeCallbacks(this.f3845a);
        }
        this.f3845a = new Runnable() { // from class: android.support.v7.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f3845a = null;
            }
        };
        post(this.f3845a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3845a != null) {
            post(this.f3845a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3845a != null) {
            removeCallbacks(this.f3845a);
        }
    }

    /* JADX INFO: renamed from: a */
    C0628c m4163a(ActionBar.AbstractC0525b abstractC0525b, boolean z) {
        C0628c c0628c = new C0628c(getContext(), abstractC0525b, z);
        if (z) {
            c0628c.setBackgroundDrawable(null);
            c0628c.setLayoutParams(new AbsListView.LayoutParams(-1, this.f3854j));
        } else {
            c0628c.setFocusable(true);
            if (this.f3851g == null) {
                this.f3851g = new ViewOnClickListenerC0627b();
            }
            c0628c.setOnClickListener(this.f3851g);
        }
        return c0628c;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0628c) view).m4167b().m3152d();
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ScrollingTabContainerView$c */
    class C0628c extends LinearLayout {

        /* JADX INFO: renamed from: b */
        private final int[] f3861b;

        /* JADX INFO: renamed from: c */
        private ActionBar.AbstractC0525b f3862c;

        /* JADX INFO: renamed from: d */
        private TextView f3863d;

        /* JADX INFO: renamed from: e */
        private ImageView f3864e;

        /* JADX INFO: renamed from: f */
        private View f3865f;

        public C0628c(Context context, ActionBar.AbstractC0525b abstractC0525b, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            this.f3861b = new int[]{android.R.attr.background};
            this.f3862c = abstractC0525b;
            C1766hd c1766hdM9601a = C1766hd.m9601a(context, null, this.f3861b, R.attr.actionBarTabStyle, 0);
            if (c1766hdM9601a.m9620g(0)) {
                setBackgroundDrawable(c1766hdM9601a.m9605a(0));
            }
            c1766hdM9601a.m9606a();
            if (z) {
                setGravity(8388627);
            }
            m4165a();
        }

        /* JADX INFO: renamed from: a */
        public void m4166a(ActionBar.AbstractC0525b abstractC0525b) {
            this.f3862c = abstractC0525b;
            m4165a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.AbstractC0525b.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.AbstractC0525b.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.f3847c <= 0 || getMeasuredWidth() <= ScrollingTabContainerView.this.f3847c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.f3847c, 1073741824), i2);
        }

        /* JADX INFO: renamed from: a */
        public void m4165a() {
            ActionBar.AbstractC0525b abstractC0525b = this.f3862c;
            View viewM3151c = abstractC0525b.m3151c();
            if (viewM3151c != null) {
                ViewParent parent = viewM3151c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewM3151c);
                    }
                    addView(viewM3151c);
                }
                this.f3865f = viewM3151c;
                if (this.f3863d != null) {
                    this.f3863d.setVisibility(8);
                }
                if (this.f3864e != null) {
                    this.f3864e.setVisibility(8);
                    this.f3864e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f3865f != null) {
                removeView(this.f3865f);
                this.f3865f = null;
            }
            Drawable drawableM3149a = abstractC0525b.m3149a();
            CharSequence charSequenceM3150b = abstractC0525b.m3150b();
            if (drawableM3149a != null) {
                if (this.f3864e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f3864e = appCompatImageView;
                }
                this.f3864e.setImageDrawable(drawableM3149a);
                this.f3864e.setVisibility(0);
            } else if (this.f3864e != null) {
                this.f3864e.setVisibility(8);
                this.f3864e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(charSequenceM3150b);
            if (z) {
                if (this.f3863d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f3863d = appCompatTextView;
                }
                this.f3863d.setText(charSequenceM3150b);
                this.f3863d.setVisibility(0);
            } else if (this.f3863d != null) {
                this.f3863d.setVisibility(8);
                this.f3863d.setText((CharSequence) null);
            }
            if (this.f3864e != null) {
                this.f3864e.setContentDescription(abstractC0525b.m3153e());
            }
            C1768hf.m9634a(this, z ? null : abstractC0525b.m3153e());
        }

        /* JADX INFO: renamed from: b */
        public ActionBar.AbstractC0525b m4167b() {
            return this.f3862c;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ScrollingTabContainerView$a */
    class C0626a extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        C0626a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f3846b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((C0628c) ScrollingTabContainerView.this.f3846b.getChildAt(i)).m4167b();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.m4163a((ActionBar.AbstractC0525b) getItem(i), true);
            }
            ((C0628c) view).m4166a((ActionBar.AbstractC0525b) getItem(i));
            return view;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ScrollingTabContainerView$b */
    class ViewOnClickListenerC0627b implements View.OnClickListener {
        ViewOnClickListenerC0627b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((C0628c) view).m4167b().m3152d();
            int childCount = ScrollingTabContainerView.this.f3846b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.f3846b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ScrollingTabContainerView$d */
    public class C0629d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b */
        private boolean f3867b = false;

        /* JADX INFO: renamed from: c */
        private int f3868c;

        protected C0629d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f3867b = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3867b) {
                return;
            }
            ScrollingTabContainerView.this.f3849e = null;
            ScrollingTabContainerView.this.setVisibility(this.f3868c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3867b = true;
        }
    }
}
