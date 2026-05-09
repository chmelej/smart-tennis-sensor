package p000;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import p000.AbstractC1694em;

/* JADX INFO: renamed from: dy */
/* JADX INFO: compiled from: AppCompatDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC1677dy extends Dialog implements InterfaceC1675dw {

    /* JADX INFO: renamed from: a */
    private AbstractC1676dx f9427a;

    /* JADX INFO: renamed from: b */
    private final KeyEventDispatcher.Component f9428b;

    @Override // p000.InterfaceC1675dw
    /* JADX INFO: renamed from: a */
    public AbstractC1694em mo3187a(AbstractC1694em.a aVar) {
        return null;
    }

    @Override // p000.InterfaceC1675dw
    /* JADX INFO: renamed from: a */
    public void mo3189a(AbstractC1694em abstractC1694em) {
    }

    @Override // p000.InterfaceC1675dw
    /* JADX INFO: renamed from: b */
    public void mo3193b(AbstractC1694em abstractC1694em) {
    }

    public DialogC1677dy(Context context, int i) {
        super(context, m8911a(context, i));
        this.f9428b = new KeyEventDispatcher.Component() { // from class: dy.1
            @Override // android.support.v4.view.KeyEventDispatcher.Component
            public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return DialogC1677dy.this.m8913a(keyEvent);
            }
        };
        m8914b().mo3226a((Bundle) null);
        m8914b().mo3256i();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        m8914b().mo3254h();
        super.onCreate(bundle);
        m8914b().mo3226a(bundle);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        m8914b().mo3236b(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        m8914b().mo3228a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m8914b().mo3229a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) m8914b().mo3221a(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m8914b().mo3231a(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        m8914b().mo3231a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m8914b().mo3239b(view, layoutParams);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        m8914b().mo3245d();
    }

    /* JADX INFO: renamed from: a */
    public boolean m8912a(int i) {
        return m8914b().mo3243c(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        m8914b().mo3249f();
    }

    /* JADX INFO: renamed from: b */
    public AbstractC1676dx m8914b() {
        if (this.f9427a == null) {
            this.f9427a = AbstractC1676dx.m8909a(this, this);
        }
        return this.f9427a;
    }

    /* JADX INFO: renamed from: a */
    private static int m8911a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX INFO: renamed from: a */
    boolean m8913a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.dispatchKeyEvent(this.f9428b, getWindow().getDecorView(), this, keyEvent);
    }
}
