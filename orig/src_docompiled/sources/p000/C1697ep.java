package p000;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import p000.AbstractC1694em;

/* JADX INFO: renamed from: ep */
/* JADX INFO: compiled from: StandaloneActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public class C1697ep extends AbstractC1694em implements MenuBuilder.InterfaceC0552a {

    /* JADX INFO: renamed from: a */
    private Context f9617a;

    /* JADX INFO: renamed from: b */
    private ActionBarContextView f9618b;

    /* JADX INFO: renamed from: c */
    private AbstractC1694em.a f9619c;

    /* JADX INFO: renamed from: d */
    private WeakReference<View> f9620d;

    /* JADX INFO: renamed from: e */
    private boolean f9621e;

    /* JADX INFO: renamed from: f */
    private boolean f9622f;

    /* JADX INFO: renamed from: g */
    private MenuBuilder f9623g;

    public C1697ep(Context context, ActionBarContextView actionBarContextView, AbstractC1694em.a aVar, boolean z) {
        this.f9617a = context;
        this.f9618b = actionBarContextView;
        this.f9619c = aVar;
        this.f9623g = new MenuBuilder(actionBarContextView.getContext()).m3320a(1);
        this.f9623g.mo3327a(this);
        this.f9622f = z;
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: b */
    public void mo8964b(CharSequence charSequence) {
        this.f9618b.setTitle(charSequence);
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: a */
    public void mo8960a(CharSequence charSequence) {
        this.f9618b.setSubtitle(charSequence);
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: a */
    public void mo8958a(int i) {
        mo8964b(this.f9617a.getString(i));
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: b */
    public void mo8963b(int i) {
        mo8960a((CharSequence) this.f9617a.getString(i));
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: a */
    public void mo8961a(boolean z) {
        super.mo8961a(z);
        this.f9618b.setTitleOptional(z);
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: h */
    public boolean mo8970h() {
        return this.f9618b.m3408d();
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: a */
    public void mo8959a(View view) {
        this.f9618b.setCustomView(view);
        this.f9620d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: d */
    public void mo8966d() {
        this.f9619c.mo3283b(this, this.f9623g);
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: c */
    public void mo8965c() {
        if (this.f9621e) {
            return;
        }
        this.f9621e = true;
        this.f9618b.sendAccessibilityEvent(32);
        this.f9619c.mo3280a(this);
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: b */
    public Menu mo8962b() {
        return this.f9623g;
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: f */
    public CharSequence mo8968f() {
        return this.f9618b.getTitle();
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: g */
    public CharSequence mo8969g() {
        return this.f9618b.getSubtitle();
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: i */
    public View mo8971i() {
        if (this.f9620d != null) {
            return this.f9620d.get();
        }
        return null;
    }

    @Override // p000.AbstractC1694em
    /* JADX INFO: renamed from: a */
    public MenuInflater mo8957a() {
        return new C1699er(this.f9618b.getContext());
    }

    @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
    /* JADX INFO: renamed from: a */
    public boolean mo2622a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f9619c.mo3282a(this, menuItem);
    }

    @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
    /* JADX INFO: renamed from: a */
    public void mo2621a(MenuBuilder menuBuilder) {
        mo8966d();
        this.f9618b.mo3400a();
    }
}
