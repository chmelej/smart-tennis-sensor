package com.coollang.tennis.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.coollang.tennis.R;
import com.coollang.tennis.widget.AnimationView;
import p000.C1900mc;

/* JADX INFO: loaded from: classes.dex */
public class CircleRefreshLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private static String f8124a = "pullToRefresh";

    /* JADX INFO: renamed from: b */
    private int f8125b;

    /* JADX INFO: renamed from: c */
    private int f8126c;

    /* JADX INFO: renamed from: d */
    private int f8127d;

    /* JADX INFO: renamed from: e */
    private float f8128e;

    /* JADX INFO: renamed from: f */
    private float f8129f;

    /* JADX INFO: renamed from: g */
    private View f8130g;

    /* JADX INFO: renamed from: h */
    private AnimationView f8131h;

    /* JADX INFO: renamed from: i */
    private boolean f8132i;

    /* JADX INFO: renamed from: j */
    private float f8133j;

    /* JADX INFO: renamed from: k */
    private float f8134k;

    /* JADX INFO: renamed from: l */
    private ValueAnimator f8135l;

    /* JADX INFO: renamed from: m */
    private ValueAnimator f8136m;

    /* JADX INFO: renamed from: n */
    private DecelerateInterpolator f8137n;

    /* JADX INFO: renamed from: o */
    private InterfaceC1318a f8138o;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CircleRefreshLayout$a */
    public interface InterfaceC1318a {
        /* JADX INFO: renamed from: a */
        void m8086a();
    }

    public CircleRefreshLayout(Context context) {
        this(context, null, 0);
    }

    public CircleRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8125b = -7630673;
        this.f8126c = -1;
        this.f8127d = 6;
        this.f8137n = new DecelerateInterpolator(10.0f);
        m8077a(context, attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    private void m8077a(Context context, AttributeSet attributeSet, int i) {
        if (getChildCount() > 1) {
            throw new RuntimeException("you can only attach one child");
        }
        setAttrs(attributeSet);
        this.f8128e = TypedValue.applyDimension(1, 150.0f, context.getResources().getDisplayMetrics());
        this.f8129f = TypedValue.applyDimension(1, 100.0f, context.getResources().getDisplayMetrics());
        post(new Runnable() { // from class: com.coollang.tennis.widget.CircleRefreshLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CircleRefreshLayout.this.f8130g = CircleRefreshLayout.this.getChildAt(0);
                CircleRefreshLayout.this.m8076a();
            }
        });
    }

    private void setAttrs(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CirCleRefreshLayout);
        this.f8125b = typedArrayObtainStyledAttributes.getColor(0, this.f8125b);
        this.f8126c = typedArrayObtainStyledAttributes.getColor(1, this.f8126c);
        this.f8127d = typedArrayObtainStyledAttributes.getInt(2, this.f8127d);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m8076a() {
        this.f8131h = new AnimationView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 48;
        this.f8131h.setLayoutParams(layoutParams);
        m8078a(this.f8131h);
        this.f8131h.setAniBackColor(this.f8125b);
        this.f8131h.setAniForeColor(this.f8126c);
        m8081b();
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: b */
    private void m8081b() {
        if (this.f8130g == null) {
            return;
        }
        this.f8135l = ValueAnimator.ofFloat(this.f8128e, this.f8129f);
        this.f8135l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.CircleRefreshLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (CircleRefreshLayout.this.f8130g != null) {
                    CircleRefreshLayout.this.f8130g.setTranslationY(fFloatValue);
                }
            }
        });
        this.f8135l.setDuration(200L);
        this.f8136m = ValueAnimator.ofFloat(this.f8129f, 0.0f);
        this.f8136m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.CircleRefreshLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float interpolation = CircleRefreshLayout.this.f8137n.getInterpolation(fFloatValue / CircleRefreshLayout.this.f8129f) * fFloatValue;
                if (CircleRefreshLayout.this.f8130g != null) {
                    CircleRefreshLayout.this.f8130g.setTranslationY(interpolation);
                }
                CircleRefreshLayout.this.f8131h.getLayoutParams().height = (int) interpolation;
                CircleRefreshLayout.this.f8131h.requestLayout();
            }
        });
        this.f8136m.setDuration(600L);
        this.f8131h.setOnViewAniDone(new AnimationView.InterfaceC1307b() { // from class: com.coollang.tennis.widget.CircleRefreshLayout.4
        });
    }

    /* JADX INFO: renamed from: a */
    private void m8078a(View view) {
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() >= 1) {
            throw new RuntimeException("you can only attach one child");
        }
        this.f8130g = view;
        super.addView(view);
        m8081b();
    }

    /* JADX INFO: renamed from: c */
    private boolean m8083c() {
        if (this.f8130g == null) {
            return false;
        }
        return ViewCompat.canScrollVertically(this.f8130g, -1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f8132i) {
            return true;
        }
        C1900mc.m10474b("ev.getAction()==", " " + motionEvent.getAction());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f8133j = motionEvent.getY();
            this.f8134k = this.f8133j;
        } else if (action == 2 && motionEvent.getY() - this.f8133j > 0.0f && !m8083c()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8132i) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.f8130g != null) {
                    if (this.f8130g.getTranslationY() >= this.f8129f) {
                        this.f8135l.start();
                        this.f8131h.m8018a();
                        this.f8132i = true;
                        if (this.f8138o != null) {
                            this.f8138o.m8086a();
                        }
                    } else {
                        float translationY = this.f8130g.getTranslationY();
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(translationY, 0.0f);
                        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.CircleRefreshLayout.5
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (CircleRefreshLayout.this.f8130g != null) {
                                    CircleRefreshLayout.this.f8130g.setTranslationY(fFloatValue);
                                }
                                CircleRefreshLayout.this.f8131h.getLayoutParams().height = (int) fFloatValue;
                                CircleRefreshLayout.this.f8131h.requestLayout();
                            }
                        });
                        valueAnimatorOfFloat.setInterpolator(new BounceInterpolator());
                        valueAnimatorOfFloat.setDuration((long) ((translationY * 600.0f) / this.f8129f));
                        valueAnimatorOfFloat.start();
                    }
                }
                break;
            case 2:
                this.f8134k = motionEvent.getY();
                float fMax = Math.max(0.0f, Math.min(this.f8128e * 2.0f, this.f8134k - this.f8133j));
                C1900mc.m10474b("action", "dy==========" + fMax + "-----mPullHeight * 2======" + (this.f8128e * 2.0f));
                if (this.f8130g != null) {
                    float interpolation = ((this.f8137n.getInterpolation((fMax / 2.0f) / this.f8128e) * fMax) / 2.0f) * 0.5f;
                    this.f8130g.setTranslationY(interpolation);
                    this.f8131h.getLayoutParams().height = (int) interpolation;
                    this.f8131h.requestLayout();
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnRefreshListener(InterfaceC1318a interfaceC1318a) {
        this.f8138o = interfaceC1318a;
    }
}
