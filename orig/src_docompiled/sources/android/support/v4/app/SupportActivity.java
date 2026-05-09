package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.ReportFragment;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.KeyEventDispatcher;
import android.view.KeyEvent;
import android.view.View;
import p000.AbstractC1762h;
import p000.C1843k;
import p000.InterfaceC1816j;

/* JADX INFO: compiled from: ComponentActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class SupportActivity extends Activity implements KeyEventDispatcher.Component, InterfaceC1816j {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap<>();
    private C1843k mLifecycleRegistry = new C1843k(this);

    /* JADX INFO: compiled from: ComponentActivity.java */
    public static class ExtraData {
    }

    public void putExtraData(ExtraData extraData) {
        this.mExtraDataMap.put((Class<? extends ExtraData>) extraData.getClass(), extraData);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.m2196a(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.m10071a(AbstractC1762h.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    public AbstractC1762h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.support.v4.view.KeyEventDispatcher.Component
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return KeyEventDispatcher.dispatchKeyEvent(this, decorView, this, keyEvent);
        }
        return true;
    }
}
