package p000;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/* JADX INFO: renamed from: gj */
/* JADX INFO: compiled from: FastScroller.java */
/* JADX INFO: loaded from: classes.dex */
public class C1745gj extends RecyclerView.AbstractC0610h implements RecyclerView.InterfaceC0614l {

    /* JADX INFO: renamed from: k */
    private static final int[] f9984k = {R.attr.state_pressed};

    /* JADX INFO: renamed from: l */
    private static final int[] f9985l = new int[0];

    /* JADX INFO: renamed from: a */
    final StateListDrawable f9991a;

    /* JADX INFO: renamed from: b */
    final Drawable f9992b;

    /* JADX INFO: renamed from: c */
    int f9993c;

    /* JADX INFO: renamed from: d */
    int f9994d;

    /* JADX INFO: renamed from: e */
    float f9995e;

    /* JADX INFO: renamed from: f */
    int f9996f;

    /* JADX INFO: renamed from: g */
    int f9997g;

    /* JADX INFO: renamed from: h */
    float f9998h;

    /* JADX INFO: renamed from: m */
    private final int f10001m;

    /* JADX INFO: renamed from: n */
    private final int f10002n;

    /* JADX INFO: renamed from: o */
    private final int f10003o;

    /* JADX INFO: renamed from: p */
    private final int f10004p;

    /* JADX INFO: renamed from: q */
    private final StateListDrawable f10005q;

    /* JADX INFO: renamed from: r */
    private final Drawable f10006r;

    /* JADX INFO: renamed from: s */
    private final int f10007s;

    /* JADX INFO: renamed from: t */
    private final int f10008t;

    /* JADX INFO: renamed from: w */
    private RecyclerView f10011w;

    /* JADX INFO: renamed from: u */
    private int f10009u = 0;

    /* JADX INFO: renamed from: v */
    private int f10010v = 0;

    /* JADX INFO: renamed from: x */
    private boolean f10012x = false;

    /* JADX INFO: renamed from: y */
    private boolean f10013y = false;

    /* JADX INFO: renamed from: z */
    private int f10014z = 0;

    /* JADX INFO: renamed from: A */
    private int f9986A = 0;

    /* JADX INFO: renamed from: B */
    private final int[] f9987B = new int[2];

    /* JADX INFO: renamed from: C */
    private final int[] f9988C = new int[2];

    /* JADX INFO: renamed from: i */
    final ValueAnimator f9999i = ValueAnimator.ofFloat(0.0f, 1.0f);

    /* JADX INFO: renamed from: j */
    int f10000j = 0;

    /* JADX INFO: renamed from: D */
    private final Runnable f9989D = new Runnable() { // from class: gj.1
        @Override // java.lang.Runnable
        public void run() {
            C1745gj.this.m9460b(500);
        }
    };

    /* JADX INFO: renamed from: E */
    private final RecyclerView.AbstractC0615m f9990E = new RecyclerView.AbstractC0615m() { // from class: gj.2
        @Override // android.support.v7.widget.RecyclerView.AbstractC0615m
        /* JADX INFO: renamed from: a */
        public void mo4030a(RecyclerView recyclerView, int i, int i2) {
            C1745gj.this.m9456a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    @Override // android.support.v7.widget.RecyclerView.InterfaceC0614l
    /* JADX INFO: renamed from: a */
    public void mo4026a(boolean z) {
    }

    public C1745gj(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f9991a = stateListDrawable;
        this.f9992b = drawable;
        this.f10005q = stateListDrawable2;
        this.f10006r = drawable2;
        this.f10003o = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f10004p = Math.max(i, drawable.getIntrinsicWidth());
        this.f10007s = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f10008t = Math.max(i, drawable2.getIntrinsicWidth());
        this.f10001m = i2;
        this.f10002n = i3;
        this.f9991a.setAlpha(255);
        this.f9992b.setAlpha(255);
        this.f9999i.addListener(new a());
        this.f9999i.addUpdateListener(new b());
        m9457a(recyclerView);
    }

    /* JADX INFO: renamed from: a */
    public void m9457a(RecyclerView recyclerView) {
        if (this.f10011w == recyclerView) {
            return;
        }
        if (this.f10011w != null) {
            m9449d();
        }
        this.f10011w = recyclerView;
        if (this.f10011w != null) {
            m9447c();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m9447c() {
        this.f10011w.m3764a((RecyclerView.AbstractC0610h) this);
        this.f10011w.m3766a((RecyclerView.InterfaceC0614l) this);
        this.f10011w.m3767a(this.f9990E);
    }

    /* JADX INFO: renamed from: d */
    private void m9449d() {
        this.f10011w.m3780b((RecyclerView.AbstractC0610h) this);
        this.f10011w.m3781b((RecyclerView.InterfaceC0614l) this);
        this.f10011w.m3782b(this.f9990E);
        m9451f();
    }

    /* JADX INFO: renamed from: a */
    void m9454a() {
        this.f10011w.invalidate();
    }

    /* JADX INFO: renamed from: a */
    void m9455a(int i) {
        if (i == 2 && this.f10014z != 2) {
            this.f9991a.setState(f9984k);
            m9451f();
        }
        if (i == 0) {
            m9454a();
        } else {
            m9459b();
        }
        if (this.f10014z == 2 && i != 2) {
            this.f9991a.setState(f9985l);
            m9448c(1200);
        } else if (i == 1) {
            m9448c(1500);
        }
        this.f10014z = i;
    }

    /* JADX INFO: renamed from: e */
    private boolean m9450e() {
        return ViewCompat.getLayoutDirection(this.f10011w) == 1;
    }

    /* JADX INFO: renamed from: b */
    public void m9459b() {
        int i = this.f10000j;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.f9999i.cancel();
            }
        }
        this.f10000j = 1;
        this.f9999i.setFloatValues(((Float) this.f9999i.getAnimatedValue()).floatValue(), 1.0f);
        this.f9999i.setDuration(500L);
        this.f9999i.setStartDelay(0L);
        this.f9999i.start();
    }

    /* JADX INFO: renamed from: b */
    void m9460b(int i) {
        switch (this.f10000j) {
            case 1:
                this.f9999i.cancel();
                break;
            case 2:
                break;
            default:
                return;
        }
        this.f10000j = 3;
        this.f9999i.setFloatValues(((Float) this.f9999i.getAnimatedValue()).floatValue(), 0.0f);
        this.f9999i.setDuration(i);
        this.f9999i.start();
    }

    /* JADX INFO: renamed from: f */
    private void m9451f() {
        this.f10011w.removeCallbacks(this.f9989D);
    }

    /* JADX INFO: renamed from: c */
    private void m9448c(int i) {
        m9451f();
        this.f10011w.postDelayed(this.f9989D, i);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0610h
    /* JADX INFO: renamed from: a */
    public void mo3912a(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0621s c0621s) {
        if (this.f10009u != this.f10011w.getWidth() || this.f10010v != this.f10011w.getHeight()) {
            this.f10009u = this.f10011w.getWidth();
            this.f10010v = this.f10011w.getHeight();
            m9455a(0);
        } else if (this.f10000j != 0) {
            if (this.f10012x) {
                m9444a(canvas);
            }
            if (this.f10013y) {
                m9446b(canvas);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9444a(Canvas canvas) {
        int i = this.f10009u - this.f10003o;
        int i2 = this.f9994d - (this.f9993c / 2);
        this.f9991a.setBounds(0, 0, this.f10003o, this.f9993c);
        this.f9992b.setBounds(0, 0, this.f10004p, this.f10010v);
        if (m9450e()) {
            this.f9992b.draw(canvas);
            canvas.translate(this.f10003o, i2);
            canvas.scale(-1.0f, 1.0f);
            this.f9991a.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.f10003o, -i2);
            return;
        }
        canvas.translate(i, 0.0f);
        this.f9992b.draw(canvas);
        canvas.translate(0.0f, i2);
        this.f9991a.draw(canvas);
        canvas.translate(-i, -i2);
    }

    /* JADX INFO: renamed from: b */
    private void m9446b(Canvas canvas) {
        int i = this.f10010v - this.f10007s;
        int i2 = this.f9997g - (this.f9996f / 2);
        this.f10005q.setBounds(0, 0, this.f9996f, this.f10007s);
        this.f10006r.setBounds(0, 0, this.f10009u, this.f10008t);
        canvas.translate(0.0f, i);
        this.f10006r.draw(canvas);
        canvas.translate(i2, 0.0f);
        this.f10005q.draw(canvas);
        canvas.translate(-i2, -i);
    }

    /* JADX INFO: renamed from: a */
    void m9456a(int i, int i2) {
        int iComputeVerticalScrollRange = this.f10011w.computeVerticalScrollRange();
        int i3 = this.f10010v;
        this.f10012x = iComputeVerticalScrollRange - i3 > 0 && this.f10010v >= this.f10001m;
        int iComputeHorizontalScrollRange = this.f10011w.computeHorizontalScrollRange();
        int i4 = this.f10009u;
        this.f10013y = iComputeHorizontalScrollRange - i4 > 0 && this.f10009u >= this.f10001m;
        if (!this.f10012x && !this.f10013y) {
            if (this.f10014z != 0) {
                m9455a(0);
                return;
            }
            return;
        }
        if (this.f10012x) {
            float f = i3;
            this.f9994d = (int) ((f * (i2 + (f / 2.0f))) / iComputeVerticalScrollRange);
            this.f9993c = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.f10013y) {
            float f2 = i4;
            this.f9997g = (int) ((f2 * (i + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f9996f = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        if (this.f10014z == 0 || this.f10014z == 1) {
            m9455a(1);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.InterfaceC0614l
    /* JADX INFO: renamed from: a */
    public boolean mo4027a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f10014z == 1) {
            boolean zM9458a = m9458a(motionEvent.getX(), motionEvent.getY());
            boolean zM9461b = m9461b(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zM9458a && !zM9461b) {
                return false;
            }
            if (zM9461b) {
                this.f9986A = 1;
                this.f9998h = (int) motionEvent.getX();
            } else if (zM9458a) {
                this.f9986A = 2;
                this.f9995e = (int) motionEvent.getY();
            }
            m9455a(2);
        } else if (this.f10014z != 2) {
            return false;
        }
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.InterfaceC0614l
    /* JADX INFO: renamed from: b */
    public void mo4028b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f10014z == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zM9458a = m9458a(motionEvent.getX(), motionEvent.getY());
            boolean zM9461b = m9461b(motionEvent.getX(), motionEvent.getY());
            if (zM9458a || zM9461b) {
                if (zM9461b) {
                    this.f9986A = 1;
                    this.f9998h = (int) motionEvent.getX();
                } else if (zM9458a) {
                    this.f9986A = 2;
                    this.f9995e = (int) motionEvent.getY();
                }
                m9455a(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f10014z == 2) {
            this.f9995e = 0.0f;
            this.f9998h = 0.0f;
            m9455a(1);
            this.f9986A = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f10014z == 2) {
            m9459b();
            if (this.f9986A == 1) {
                m9445b(motionEvent.getX());
            }
            if (this.f9986A == 2) {
                m9443a(motionEvent.getY());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9443a(float f) {
        int[] iArrM9452g = m9452g();
        float fMax = Math.max(iArrM9452g[0], Math.min(iArrM9452g[1], f));
        if (Math.abs(this.f9994d - fMax) < 2.0f) {
            return;
        }
        int iM9442a = m9442a(this.f9995e, fMax, iArrM9452g, this.f10011w.computeVerticalScrollRange(), this.f10011w.computeVerticalScrollOffset(), this.f10010v);
        if (iM9442a != 0) {
            this.f10011w.scrollBy(0, iM9442a);
        }
        this.f9995e = fMax;
    }

    /* JADX INFO: renamed from: b */
    private void m9445b(float f) {
        int[] iArrM9453h = m9453h();
        float fMax = Math.max(iArrM9453h[0], Math.min(iArrM9453h[1], f));
        if (Math.abs(this.f9997g - fMax) < 2.0f) {
            return;
        }
        int iM9442a = m9442a(this.f9998h, fMax, iArrM9453h, this.f10011w.computeHorizontalScrollRange(), this.f10011w.computeHorizontalScrollOffset(), this.f10009u);
        if (iM9442a != 0) {
            this.f10011w.scrollBy(iM9442a, 0);
        }
        this.f9998h = fMax;
    }

    /* JADX INFO: renamed from: a */
    private int m9442a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* JADX INFO: renamed from: a */
    boolean m9458a(float f, float f2) {
        if (!m9450e() ? f >= this.f10009u - this.f10003o : f <= this.f10003o / 2) {
            if (f2 >= this.f9994d - (this.f9993c / 2) && f2 <= this.f9994d + (this.f9993c / 2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    boolean m9461b(float f, float f2) {
        return f2 >= ((float) (this.f10010v - this.f10007s)) && f >= ((float) (this.f9997g - (this.f9996f / 2))) && f <= ((float) (this.f9997g + (this.f9996f / 2)));
    }

    /* JADX INFO: renamed from: g */
    private int[] m9452g() {
        this.f9987B[0] = this.f10002n;
        this.f9987B[1] = this.f10010v - this.f10002n;
        return this.f9987B;
    }

    /* JADX INFO: renamed from: h */
    private int[] m9453h() {
        this.f9988C[0] = this.f10002n;
        this.f9988C[1] = this.f10009u - this.f10002n;
        return this.f9988C;
    }

    /* JADX INFO: renamed from: gj$a */
    /* JADX INFO: compiled from: FastScroller.java */
    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b */
        private boolean f10018b = false;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f10018b) {
                this.f10018b = false;
            } else if (((Float) C1745gj.this.f9999i.getAnimatedValue()).floatValue() == 0.0f) {
                C1745gj.this.f10000j = 0;
                C1745gj.this.m9455a(0);
            } else {
                C1745gj.this.f10000j = 2;
                C1745gj.this.m9454a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10018b = true;
        }
    }

    /* JADX INFO: renamed from: gj$b */
    /* JADX INFO: compiled from: FastScroller.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C1745gj.this.f9991a.setAlpha(iFloatValue);
            C1745gj.this.f9992b.setAlpha(iFloatValue);
            C1745gj.this.m9454a();
        }
    }
}
