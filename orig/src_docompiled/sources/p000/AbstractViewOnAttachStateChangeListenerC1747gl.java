package p000;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: renamed from: gl */
/* JADX INFO: compiled from: ForwardingListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnAttachStateChangeListenerC1747gl implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private final float f10020a;

    /* JADX INFO: renamed from: b */
    private final int f10021b;

    /* JADX INFO: renamed from: c */
    final View f10022c;

    /* JADX INFO: renamed from: d */
    private final int f10023d;

    /* JADX INFO: renamed from: e */
    private Runnable f10024e;

    /* JADX INFO: renamed from: f */
    private Runnable f10025f;

    /* JADX INFO: renamed from: g */
    private boolean f10026g;

    /* JADX INFO: renamed from: h */
    private int f10027h;

    /* JADX INFO: renamed from: i */
    private final int[] f10028i = new int[2];

    /* JADX INFO: renamed from: a */
    public abstract InterfaceC1718fj mo3300a();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public AbstractViewOnAttachStateChangeListenerC1747gl(View view) {
        this.f10022c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f10020a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f10021b = ViewConfiguration.getTapTimeout();
        this.f10023d = (this.f10021b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f10026g;
        if (z2) {
            z = m9465b(motionEvent) || !mo3462c();
        } else {
            z = m9462a(motionEvent) && mo3301b();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f10022c.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f10026g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f10026g = false;
        this.f10027h = -1;
        if (this.f10024e != null) {
            this.f10022c.removeCallbacks(this.f10024e);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean mo3301b() {
        InterfaceC1718fj interfaceC1718fjMo3300a = mo3300a();
        if (interfaceC1718fjMo3300a == null || interfaceC1718fjMo3300a.mo3693f()) {
            return true;
        }
        interfaceC1718fjMo3300a.mo3510d();
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo3462c() {
        InterfaceC1718fj interfaceC1718fjMo3300a = mo3300a();
        if (interfaceC1718fjMo3300a == null || !interfaceC1718fjMo3300a.mo3693f()) {
            return true;
        }
        interfaceC1718fjMo3300a.mo3690e();
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: a */
    private boolean m9462a(MotionEvent motionEvent) {
        View view = this.f10022c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f10027h = motionEvent.getPointerId(0);
                if (this.f10024e == null) {
                    this.f10024e = new a();
                }
                view.postDelayed(this.f10024e, this.f10021b);
                if (this.f10025f == null) {
                    this.f10025f = new b();
                }
                view.postDelayed(this.f10025f, this.f10023d);
                return false;
            case 1:
            case 3:
                m9467e();
                return false;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f10027h);
                if (iFindPointerIndex >= 0 && !m9463a(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f10020a)) {
                    m9467e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: e */
    private void m9467e() {
        if (this.f10025f != null) {
            this.f10022c.removeCallbacks(this.f10025f);
        }
        if (this.f10024e != null) {
            this.f10022c.removeCallbacks(this.f10024e);
        }
    }

    /* JADX INFO: renamed from: d */
    void m9468d() {
        m9467e();
        View view = this.f10022c;
        if (view.isEnabled() && !view.isLongClickable() && mo3301b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f10026g = true;
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m9465b(MotionEvent motionEvent) {
        C1744gi c1744gi;
        View view = this.f10022c;
        InterfaceC1718fj interfaceC1718fjMo3300a = mo3300a();
        if (interfaceC1718fjMo3300a == null || !interfaceC1718fjMo3300a.mo3693f() || (c1744gi = (C1744gi) interfaceC1718fjMo3300a.mo3694g()) == null || !c1744gi.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m9466b(view, motionEventObtainNoHistory);
        m9464a(c1744gi, motionEventObtainNoHistory);
        boolean zMo3712a = c1744gi.mo3712a(motionEventObtainNoHistory, this.f10027h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zMo3712a && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9463a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* JADX INFO: renamed from: a */
    private boolean m9464a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f10028i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    /* JADX INFO: renamed from: b */
    private boolean m9466b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f10028i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    /* JADX INFO: renamed from: gl$a */
    /* JADX INFO: compiled from: ForwardingListener.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = AbstractViewOnAttachStateChangeListenerC1747gl.this.f10022c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: renamed from: gl$b */
    /* JADX INFO: compiled from: ForwardingListener.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnAttachStateChangeListenerC1747gl.this.m9468d();
        }
    }
}
