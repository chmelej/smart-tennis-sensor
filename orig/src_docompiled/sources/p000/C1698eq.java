package p000;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import p000.AbstractC1694em;

/* JADX INFO: renamed from: eq */
/* JADX INFO: compiled from: SupportActionModeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1698eq extends ActionMode {

    /* JADX INFO: renamed from: a */
    final Context f9624a;

    /* JADX INFO: renamed from: b */
    final AbstractC1694em f9625b;

    public C1698eq(Context context, AbstractC1694em abstractC1694em) {
        this.f9624a = context;
        this.f9625b = abstractC1694em;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f9625b.m9068j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f9625b.m9067a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f9625b.mo8964b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f9625b.mo8960a(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f9625b.mo8966d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f9625b.mo8965c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return C1716fh.m9164a(this.f9624a, (SupportMenu) this.f9625b.mo8962b());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f9625b.mo8968f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f9625b.mo8958a(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f9625b.mo8969g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f9625b.mo8963b(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f9625b.mo8971i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f9625b.mo8959a(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f9625b.mo8957a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f9625b.m9069k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f9625b.mo8961a(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f9625b.mo8970h();
    }

    /* JADX INFO: renamed from: eq$a */
    /* JADX INFO: compiled from: SupportActionModeWrapper.java */
    public static class a implements AbstractC1694em.a {

        /* JADX INFO: renamed from: a */
        final ActionMode.Callback f9626a;

        /* JADX INFO: renamed from: b */
        final Context f9627b;

        /* JADX INFO: renamed from: c */
        final ArrayList<C1698eq> f9628c = new ArrayList<>();

        /* JADX INFO: renamed from: d */
        final SimpleArrayMap<Menu, Menu> f9629d = new SimpleArrayMap<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f9627b = context;
            this.f9626a = callback;
        }

        @Override // p000.AbstractC1694em.a
        /* JADX INFO: renamed from: a */
        public boolean mo3281a(AbstractC1694em abstractC1694em, Menu menu) {
            return this.f9626a.onCreateActionMode(m9075b(abstractC1694em), m9074a(menu));
        }

        @Override // p000.AbstractC1694em.a
        /* JADX INFO: renamed from: b */
        public boolean mo3283b(AbstractC1694em abstractC1694em, Menu menu) {
            return this.f9626a.onPrepareActionMode(m9075b(abstractC1694em), m9074a(menu));
        }

        @Override // p000.AbstractC1694em.a
        /* JADX INFO: renamed from: a */
        public boolean mo3282a(AbstractC1694em abstractC1694em, MenuItem menuItem) {
            return this.f9626a.onActionItemClicked(m9075b(abstractC1694em), C1716fh.m9165a(this.f9627b, (SupportMenuItem) menuItem));
        }

        @Override // p000.AbstractC1694em.a
        /* JADX INFO: renamed from: a */
        public void mo3280a(AbstractC1694em abstractC1694em) {
            this.f9626a.onDestroyActionMode(m9075b(abstractC1694em));
        }

        /* JADX INFO: renamed from: a */
        private Menu m9074a(Menu menu) {
            Menu menu2 = this.f9629d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu menuM9164a = C1716fh.m9164a(this.f9627b, (SupportMenu) menu);
            this.f9629d.put(menu, menuM9164a);
            return menuM9164a;
        }

        /* JADX INFO: renamed from: b */
        public ActionMode m9075b(AbstractC1694em abstractC1694em) {
            int size = this.f9628c.size();
            for (int i = 0; i < size; i++) {
                C1698eq c1698eq = this.f9628c.get(i);
                if (c1698eq != null && c1698eq.f9625b == abstractC1694em) {
                    return c1698eq;
                }
            }
            C1698eq c1698eq2 = new C1698eq(this.f9627b, abstractC1694em);
            this.f9628c.add(c1698eq2);
            return c1698eq2;
        }
    }
}
