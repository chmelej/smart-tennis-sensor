package p000;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: renamed from: hg */
/* JADX INFO: compiled from: TooltipCompatHandler.java */
/* JADX INFO: loaded from: classes.dex */
class ViewOnAttachStateChangeListenerC1769hg implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: j */
    private static ViewOnAttachStateChangeListenerC1769hg f10168j;

    /* JADX INFO: renamed from: k */
    private static ViewOnAttachStateChangeListenerC1769hg f10169k;

    /* JADX INFO: renamed from: a */
    private final View f10170a;

    /* JADX INFO: renamed from: b */
    private final CharSequence f10171b;

    /* JADX INFO: renamed from: c */
    private final int f10172c;

    /* JADX INFO: renamed from: d */
    private final Runnable f10173d = new Runnable() { // from class: hg.1
        @Override // java.lang.Runnable
        public void run() {
            ViewOnAttachStateChangeListenerC1769hg.this.m9642a(false);
        }
    };

    /* JADX INFO: renamed from: e */
    private final Runnable f10174e = new Runnable() { // from class: hg.2
        @Override // java.lang.Runnable
        public void run() {
            ViewOnAttachStateChangeListenerC1769hg.this.m9641a();
        }
    };

    /* JADX INFO: renamed from: f */
    private int f10175f;

    /* JADX INFO: renamed from: g */
    private int f10176g;

    /* JADX INFO: renamed from: h */
    private C1770hh f10177h;

    /* JADX INFO: renamed from: i */
    private boolean f10178i;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    /* JADX INFO: renamed from: a */
    public static void m9635a(View view, CharSequence charSequence) {
        if (f10168j != null && f10168j.f10170a == view) {
            m9636a((ViewOnAttachStateChangeListenerC1769hg) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (f10169k != null && f10169k.f10170a == view) {
                f10169k.m9641a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new ViewOnAttachStateChangeListenerC1769hg(view, charSequence);
    }

    private ViewOnAttachStateChangeListenerC1769hg(View view, CharSequence charSequence) {
        this.f10170a = view;
        this.f10171b = charSequence;
        this.f10172c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(this.f10170a.getContext()));
        m9640d();
        this.f10170a.setOnLongClickListener(this);
        this.f10170a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f10175f = view.getWidth() / 2;
        this.f10176g = view.getHeight() / 2;
        m9642a(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f10177h != null && this.f10178i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f10170a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                m9640d();
                m9641a();
            }
        } else if (this.f10170a.isEnabled() && this.f10177h == null && m9637a(motionEvent)) {
            m9636a(this);
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m9641a();
    }

    /* JADX INFO: renamed from: a */
    void m9642a(boolean z) {
        long longPressTimeout;
        if (ViewCompat.isAttachedToWindow(this.f10170a)) {
            m9636a((ViewOnAttachStateChangeListenerC1769hg) null);
            if (f10169k != null) {
                f10169k.m9641a();
            }
            f10169k = this;
            this.f10178i = z;
            this.f10177h = new C1770hh(this.f10170a.getContext());
            this.f10177h.m9646a(this.f10170a, this.f10175f, this.f10176g, this.f10178i, this.f10171b);
            this.f10170a.addOnAttachStateChangeListener(this);
            if (this.f10178i) {
                longPressTimeout = 2500;
            } else if ((ViewCompat.getWindowSystemUiVisibility(this.f10170a) & 1) == 1) {
                longPressTimeout = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                longPressTimeout = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f10170a.removeCallbacks(this.f10174e);
            this.f10170a.postDelayed(this.f10174e, longPressTimeout);
        }
    }

    /* JADX INFO: renamed from: a */
    void m9641a() {
        if (f10169k == this) {
            f10169k = null;
            if (this.f10177h != null) {
                this.f10177h.m9645a();
                this.f10177h = null;
                m9640d();
                this.f10170a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f10168j == this) {
            m9636a((ViewOnAttachStateChangeListenerC1769hg) null);
        }
        this.f10170a.removeCallbacks(this.f10174e);
    }

    /* JADX INFO: renamed from: a */
    private static void m9636a(ViewOnAttachStateChangeListenerC1769hg viewOnAttachStateChangeListenerC1769hg) {
        if (f10168j != null) {
            f10168j.m9639c();
        }
        f10168j = viewOnAttachStateChangeListenerC1769hg;
        if (f10168j != null) {
            f10168j.m9638b();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m9638b() {
        this.f10170a.postDelayed(this.f10173d, ViewConfiguration.getLongPressTimeout());
    }

    /* JADX INFO: renamed from: c */
    private void m9639c() {
        this.f10170a.removeCallbacks(this.f10173d);
    }

    /* JADX INFO: renamed from: a */
    private boolean m9637a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f10175f) <= this.f10172c && Math.abs(y - this.f10176g) <= this.f10172c) {
            return false;
        }
        this.f10175f = x;
        this.f10176g = y;
        return true;
    }

    /* JADX INFO: renamed from: d */
    private void m9640d() {
        this.f10175f = Integer.MAX_VALUE;
        this.f10176g = Integer.MAX_VALUE;
    }
}
