package p000;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import p000.InterfaceC1714ff;

/* JADX INFO: renamed from: fe */
/* JADX INFO: compiled from: MenuPopupHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1713fe {

    /* JADX INFO: renamed from: a */
    private final Context f9770a;

    /* JADX INFO: renamed from: b */
    private final MenuBuilder f9771b;

    /* JADX INFO: renamed from: c */
    private final boolean f9772c;

    /* JADX INFO: renamed from: d */
    private final int f9773d;

    /* JADX INFO: renamed from: e */
    private final int f9774e;

    /* JADX INFO: renamed from: f */
    private View f9775f;

    /* JADX INFO: renamed from: g */
    private int f9776g;

    /* JADX INFO: renamed from: h */
    private boolean f9777h;

    /* JADX INFO: renamed from: i */
    private InterfaceC1714ff.a f9778i;

    /* JADX INFO: renamed from: j */
    private AbstractC1712fd f9779j;

    /* JADX INFO: renamed from: k */
    private PopupWindow.OnDismissListener f9780k;

    /* JADX INFO: renamed from: l */
    private final PopupWindow.OnDismissListener f9781l;

    public C1713fe(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public C1713fe(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.f9776g = GravityCompat.START;
        this.f9781l = new PopupWindow.OnDismissListener() { // from class: fe.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                C1713fe.this.mo3461e();
            }
        };
        this.f9770a = context;
        this.f9771b = menuBuilder;
        this.f9775f = view;
        this.f9772c = z;
        this.f9773d = i;
        this.f9774e = i2;
    }

    /* JADX INFO: renamed from: a */
    public void m9156a(PopupWindow.OnDismissListener onDismissListener) {
        this.f9780k = onDismissListener;
    }

    /* JADX INFO: renamed from: a */
    public void m9155a(View view) {
        this.f9775f = view;
    }

    /* JADX INFO: renamed from: a */
    public void m9158a(boolean z) {
        this.f9777h = z;
        if (this.f9779j != null) {
            this.f9779j.mo9118b(z);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9154a(int i) {
        this.f9776g = i;
    }

    /* JADX INFO: renamed from: a */
    public void m9153a() {
        if (!m9161c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* JADX INFO: renamed from: b */
    public AbstractC1712fd m9160b() {
        if (this.f9779j == null) {
            this.f9779j = m9152g();
        }
        return this.f9779j;
    }

    /* JADX INFO: renamed from: c */
    public boolean m9161c() {
        if (m9163f()) {
            return true;
        }
        if (this.f9775f == null) {
            return false;
        }
        m9151a(0, 0, false, false);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9159a(int i, int i2) {
        if (m9163f()) {
            return true;
        }
        if (this.f9775f == null) {
            return false;
        }
        m9151a(i, i2, true, true);
        return true;
    }

    /* JADX INFO: renamed from: g */
    private AbstractC1712fd m9152g() {
        AbstractC1712fd viewOnKeyListenerC1719fk;
        Display defaultDisplay = ((WindowManager) this.f9770a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f9770a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
            viewOnKeyListenerC1719fk = new ViewOnKeyListenerC1705ex(this.f9770a, this.f9775f, this.f9773d, this.f9774e, this.f9772c);
        } else {
            viewOnKeyListenerC1719fk = new ViewOnKeyListenerC1719fk(this.f9770a, this.f9771b, this.f9775f, this.f9773d, this.f9774e, this.f9772c);
        }
        viewOnKeyListenerC1719fk.mo9114a(this.f9771b);
        viewOnKeyListenerC1719fk.mo9116a(this.f9781l);
        viewOnKeyListenerC1719fk.mo9115a(this.f9775f);
        viewOnKeyListenerC1719fk.mo2440a(this.f9778i);
        viewOnKeyListenerC1719fk.mo9118b(this.f9777h);
        viewOnKeyListenerC1719fk.mo9113a(this.f9776g);
        return viewOnKeyListenerC1719fk;
    }

    /* JADX INFO: renamed from: a */
    private void m9151a(int i, int i2, boolean z, boolean z2) {
        AbstractC1712fd abstractC1712fdM9160b = m9160b();
        abstractC1712fdM9160b.mo9120c(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.f9776g, ViewCompat.getLayoutDirection(this.f9775f)) & 7) == 5) {
                i -= this.f9775f.getWidth();
            }
            abstractC1712fdM9160b.mo9117b(i);
            abstractC1712fdM9160b.mo9119c(i2);
            int i3 = (int) ((this.f9770a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC1712fdM9160b.m9149a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        abstractC1712fdM9160b.mo3510d();
    }

    /* JADX INFO: renamed from: d */
    public void m9162d() {
        if (m9163f()) {
            this.f9779j.mo3690e();
        }
    }

    /* JADX INFO: renamed from: e */
    protected void mo3461e() {
        this.f9779j = null;
        if (this.f9780k != null) {
            this.f9780k.onDismiss();
        }
    }

    /* JADX INFO: renamed from: f */
    public boolean m9163f() {
        return this.f9779j != null && this.f9779j.mo3693f();
    }

    /* JADX INFO: renamed from: a */
    public void m9157a(InterfaceC1714ff.a aVar) {
        this.f9778i = aVar;
        if (this.f9779j != null) {
            this.f9779j.mo2440a(aVar);
        }
    }
}
