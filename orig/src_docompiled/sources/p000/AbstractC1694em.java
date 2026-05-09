package p000;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: renamed from: em */
/* JADX INFO: compiled from: ActionMode.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1694em {

    /* JADX INFO: renamed from: a */
    private Object f9610a;

    /* JADX INFO: renamed from: b */
    private boolean f9611b;

    /* JADX INFO: renamed from: em$a */
    /* JADX INFO: compiled from: ActionMode.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo3280a(AbstractC1694em abstractC1694em);

        /* JADX INFO: renamed from: a */
        boolean mo3281a(AbstractC1694em abstractC1694em, Menu menu);

        /* JADX INFO: renamed from: a */
        boolean mo3282a(AbstractC1694em abstractC1694em, MenuItem menuItem);

        /* JADX INFO: renamed from: b */
        boolean mo3283b(AbstractC1694em abstractC1694em, Menu menu);
    }

    /* JADX INFO: renamed from: a */
    public abstract MenuInflater mo8957a();

    /* JADX INFO: renamed from: a */
    public abstract void mo8958a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo8959a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo8960a(CharSequence charSequence);

    /* JADX INFO: renamed from: b */
    public abstract Menu mo8962b();

    /* JADX INFO: renamed from: b */
    public abstract void mo8963b(int i);

    /* JADX INFO: renamed from: b */
    public abstract void mo8964b(CharSequence charSequence);

    /* JADX INFO: renamed from: c */
    public abstract void mo8965c();

    /* JADX INFO: renamed from: d */
    public abstract void mo8966d();

    /* JADX INFO: renamed from: f */
    public abstract CharSequence mo8968f();

    /* JADX INFO: renamed from: g */
    public abstract CharSequence mo8969g();

    /* JADX INFO: renamed from: h */
    public boolean mo8970h() {
        return false;
    }

    /* JADX INFO: renamed from: i */
    public abstract View mo8971i();

    /* JADX INFO: renamed from: a */
    public void m9067a(Object obj) {
        this.f9610a = obj;
    }

    /* JADX INFO: renamed from: j */
    public Object m9068j() {
        return this.f9610a;
    }

    /* JADX INFO: renamed from: a */
    public void mo8961a(boolean z) {
        this.f9611b = z;
    }

    /* JADX INFO: renamed from: k */
    public boolean m9069k() {
        return this.f9611b;
    }
}
