package p000;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import java.util.ArrayList;
import p000.InterfaceC1714ff;

/* JADX INFO: renamed from: ea */
/* JADX INFO: compiled from: ToolbarActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public class C1680ea extends ActionBar {

    /* JADX INFO: renamed from: a */
    InterfaceC1741gf f9451a;

    /* JADX INFO: renamed from: b */
    Window.Callback f9452b;

    /* JADX INFO: renamed from: c */
    private boolean f9453c;

    /* JADX INFO: renamed from: d */
    private boolean f9454d;

    /* JADX INFO: renamed from: e */
    private ArrayList<ActionBar.InterfaceC0524a> f9455e;

    /* JADX INFO: renamed from: f */
    private final Runnable f9456f;

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public void mo3133a(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: c */
    public void mo3139c(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: d */
    public void mo3141d(boolean z) {
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public void mo3130a(float f) {
        ViewCompat.setElevation(this.f9451a.mo9382a(), f);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: d */
    public Context mo3140d() {
        return this.f9451a.mo9391b();
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public void mo3131a(Configuration configuration) {
        super.mo3131a(configuration);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public void mo3132a(CharSequence charSequence) {
        this.f9451a.mo9389a(charSequence);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public int mo3128a() {
        return this.f9451a.mo9408o();
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: b */
    public void mo3136b() {
        this.f9451a.mo9397d(0);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: c */
    public void mo3138c() {
        this.f9451a.mo9397d(8);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: e */
    public boolean mo3143e() {
        return this.f9451a.mo9404k();
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: f */
    public boolean mo3144f() {
        return this.f9451a.mo9405l();
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: g */
    public boolean mo3145g() {
        this.f9451a.mo9382a().removeCallbacks(this.f9456f);
        ViewCompat.postOnAnimation(this.f9451a.mo9382a(), this.f9456f);
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: h */
    public boolean mo3146h() {
        if (!this.f9451a.mo9395c()) {
            return false;
        }
        this.f9451a.mo9396d();
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public boolean mo3135a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo3143e();
        }
        return true;
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: a */
    public boolean mo3134a(int i, KeyEvent keyEvent) {
        Menu menuM8933j = m8933j();
        if (menuM8933j == null) {
            return false;
        }
        menuM8933j.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuM8933j.performShortcut(i, keyEvent, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: i */
    public void mo3147i() {
        this.f9451a.mo9382a().removeCallbacks(this.f9456f);
    }

    @Override // android.support.v7.app.ActionBar
    /* JADX INFO: renamed from: e */
    public void mo3142e(boolean z) {
        if (z == this.f9454d) {
            return;
        }
        this.f9454d = z;
        int size = this.f9455e.size();
        for (int i = 0; i < size; i++) {
            this.f9455e.get(i).m3148a(z);
        }
    }

    /* JADX INFO: renamed from: j */
    private Menu m8933j() {
        if (!this.f9453c) {
            this.f9451a.mo9388a(new a(), new b());
            this.f9453c = true;
        }
        return this.f9451a.mo9410q();
    }

    /* JADX INFO: renamed from: ea$a */
    /* JADX INFO: compiled from: ToolbarActionBar.java */
    final class a implements InterfaceC1714ff.a {

        /* JADX INFO: renamed from: b */
        private boolean f9458b;

        a() {
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public boolean mo3279a(MenuBuilder menuBuilder) {
            if (C1680ea.this.f9452b == null) {
                return false;
            }
            C1680ea.this.f9452b.onMenuOpened(108, menuBuilder);
            return true;
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public void mo3278a(MenuBuilder menuBuilder, boolean z) {
            if (this.f9458b) {
                return;
            }
            this.f9458b = true;
            C1680ea.this.f9451a.mo9407n();
            if (C1680ea.this.f9452b != null) {
                C1680ea.this.f9452b.onPanelClosed(108, menuBuilder);
            }
            this.f9458b = false;
        }
    }

    /* JADX INFO: renamed from: ea$b */
    /* JADX INFO: compiled from: ToolbarActionBar.java */
    final class b implements MenuBuilder.InterfaceC0552a {
        @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
        /* JADX INFO: renamed from: a */
        public boolean mo2622a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        b() {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
        /* JADX INFO: renamed from: a */
        public void mo2621a(MenuBuilder menuBuilder) {
            if (C1680ea.this.f9452b != null) {
                if (C1680ea.this.f9451a.mo9402i()) {
                    C1680ea.this.f9452b.onPanelClosed(108, menuBuilder);
                } else if (C1680ea.this.f9452b.onPreparePanel(0, null, menuBuilder)) {
                    C1680ea.this.f9452b.onMenuOpened(108, menuBuilder);
                }
            }
        }
    }
}
