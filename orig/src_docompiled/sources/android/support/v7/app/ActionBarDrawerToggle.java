package android.support.v7.app;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import p000.C1688ei;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* JADX INFO: renamed from: a */
    boolean f2967a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC0526a f2968b;

    /* JADX INFO: renamed from: c */
    private C1688ei f2969c;

    /* JADX INFO: renamed from: d */
    private boolean f2970d;

    /* JADX INFO: renamed from: e */
    private final int f2971e;

    /* JADX INFO: renamed from: f */
    private final int f2972f;

    /* JADX INFO: renamed from: android.support.v7.app.ActionBarDrawerToggle$a */
    public interface InterfaceC0526a {
        /* JADX INFO: renamed from: a */
        void m3156a(int i);
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        if (this.f2970d) {
            m3154a(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            m3154a(0.0f);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        m3154a(1.0f);
        if (this.f2967a) {
            m3155a(this.f2972f);
        }
    }

    @Override // android.support.v4.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        m3154a(0.0f);
        if (this.f2967a) {
            m3155a(this.f2971e);
        }
    }

    /* JADX INFO: renamed from: a */
    void m3155a(int i) {
        this.f2968b.m3156a(i);
    }

    /* JADX INFO: renamed from: a */
    private void m3154a(float f) {
        if (f == 1.0f) {
            this.f2969c.m9044a(true);
        } else if (f == 0.0f) {
            this.f2969c.m9044a(false);
        }
        this.f2969c.m9043a(f);
    }
}
