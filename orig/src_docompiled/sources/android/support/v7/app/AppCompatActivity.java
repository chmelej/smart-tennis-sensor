package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import p000.AbstractC1676dx;
import p000.AbstractC1694em;
import p000.C1771hi;
import p000.InterfaceC1675dw;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements TaskStackBuilder.SupportParentable, InterfaceC1675dw {

    /* JADX INFO: renamed from: a */
    private AbstractC1676dx f3088a;

    /* JADX INFO: renamed from: b */
    private int f3089b = 0;

    /* JADX INFO: renamed from: c */
    private Resources f3090c;

    @Override // p000.InterfaceC1675dw
    /* JADX INFO: renamed from: a */
    public AbstractC1694em mo3187a(AbstractC1694em.a aVar) {
        return null;
    }

    @Override // p000.InterfaceC1675dw
    /* JADX INFO: renamed from: a */
    public void mo3189a(AbstractC1694em abstractC1694em) {
    }

    /* JADX INFO: renamed from: b */
    public void m3192b(TaskStackBuilder taskStackBuilder) {
    }

    @Override // p000.InterfaceC1675dw
    /* JADX INFO: renamed from: b */
    public void mo3193b(AbstractC1694em abstractC1694em) {
    }

    @Deprecated
    /* JADX INFO: renamed from: c */
    public void m3195c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AbstractC1676dx abstractC1676dxM3196d = m3196d();
        abstractC1676dxM3196d.mo3254h();
        abstractC1676dxM3196d.mo3226a(bundle);
        if (abstractC1676dxM3196d.mo3256i() && this.f3089b != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f3089b, false);
            } else {
                setTheme(this.f3089b);
            }
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.f3089b = i;
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m3196d().mo3237b(bundle);
    }

    /* JADX INFO: renamed from: a */
    public ActionBar m3186a() {
        return m3196d().mo3218a();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return m3196d().mo3234b();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        m3196d().mo3236b(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        m3196d().mo3228a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m3196d().mo3229a(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m3196d().mo3239b(view, layoutParams);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3196d().mo3225a(configuration);
        if (this.f3090c != null) {
            this.f3090c.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        m3196d().mo3247e();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        m3196d().mo3241c();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        m3196d().mo3245d();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) m3196d().mo3221a(i);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar actionBarM3186a = m3186a();
        if (menuItem.getItemId() != 16908332 || actionBarM3186a == null || (actionBarM3186a.mo3128a() & 4) == 0) {
            return false;
        }
        return m3194b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m3196d().mo3251g();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m3196d().mo3231a(charSequence);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        m3196d().mo3249f();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        m3196d().mo3249f();
    }

    /* JADX INFO: renamed from: a */
    public void m3188a(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack(this);
    }

    /* JADX INFO: renamed from: b */
    public boolean m3194b() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (m3190a(supportParentActivityIntent)) {
            TaskStackBuilder taskStackBuilderCreate = TaskStackBuilder.create(this);
            m3188a(taskStackBuilderCreate);
            m3192b(taskStackBuilderCreate);
            taskStackBuilderCreate.startActivities();
            try {
                ActivityCompat.finishAffinity(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        m3191b(supportParentActivityIntent);
        return true;
    }

    @Override // android.support.v4.app.TaskStackBuilder.SupportParentable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3190a(Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }

    /* JADX INFO: renamed from: b */
    public void m3191b(Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        m3195c();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m3196d().mo3242c(bundle);
    }

    /* JADX INFO: renamed from: d */
    public AbstractC1676dx m3196d() {
        if (this.f3088a == null) {
            this.f3088a = AbstractC1676dx.m8908a(this, this);
        }
        return this.f3088a;
    }

    @Override // android.support.v4.app.SupportActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar actionBarM3186a = m3186a();
        if (keyCode == 82 && actionBarM3186a != null && actionBarM3186a.mo3135a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f3090c == null && C1771hi.m9648a()) {
            this.f3090c = new C1771hi(this, super.getResources());
        }
        return this.f3090c == null ? super.getResources() : this.f3090c;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3185a(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m3185a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar actionBarM3186a = m3186a();
        if (getWindow().hasFeature(0)) {
            if (actionBarM3186a == null || !actionBarM3186a.mo3143e()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar actionBarM3186a = m3186a();
        if (getWindow().hasFeature(0)) {
            if (actionBarM3186a == null || !actionBarM3186a.mo3144f()) {
                super.closeOptionsMenu();
            }
        }
    }
}
