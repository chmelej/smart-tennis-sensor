package p000;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.view.LayoutInflater;

/* JADX INFO: renamed from: eo */
/* JADX INFO: compiled from: ContextThemeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1696eo extends ContextWrapper {

    /* JADX INFO: renamed from: a */
    private int f9612a;

    /* JADX INFO: renamed from: b */
    private Resources.Theme f9613b;

    /* JADX INFO: renamed from: c */
    private LayoutInflater f9614c;

    /* JADX INFO: renamed from: d */
    private Configuration f9615d;

    /* JADX INFO: renamed from: e */
    private Resources f9616e;

    public C1696eo() {
        super(null);
    }

    public C1696eo(Context context, int i) {
        super(context);
        this.f9612a = i;
    }

    public C1696eo(Context context, Resources.Theme theme) {
        super(context);
        this.f9613b = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return m9070b();
    }

    /* JADX INFO: renamed from: b */
    private Resources m9070b() {
        if (this.f9616e == null) {
            if (this.f9615d == null) {
                this.f9616e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f9616e = createConfigurationContext(this.f9615d).getResources();
            }
        }
        return this.f9616e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f9612a != i) {
            this.f9612a = i;
            m9071c();
        }
    }

    /* JADX INFO: renamed from: a */
    public int m9072a() {
        return this.f9612a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.f9613b != null) {
            return this.f9613b;
        }
        if (this.f9612a == 0) {
            this.f9612a = R.style.Theme_AppCompat_Light;
        }
        m9071c();
        return this.f9613b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f9614c == null) {
                this.f9614c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f9614c;
        }
        return getBaseContext().getSystemService(str);
    }

    /* JADX INFO: renamed from: a */
    protected void m9073a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* JADX INFO: renamed from: c */
    private void m9071c() {
        boolean z = this.f9613b == null;
        if (z) {
            this.f9613b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f9613b.setTo(theme);
            }
        }
        m9073a(this.f9613b, this.f9612a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
