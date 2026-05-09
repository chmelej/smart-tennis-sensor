package com.coollang.tennis.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import com.coollang.tennis.R;
import com.coollang.tennis.fragment.PersonalMainFramgent;
import p000.C1834jr;
import p000.ada;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a */
    private String f7397a;

    /* JADX INFO: renamed from: a */
    public abstract void mo6860a();

    /* JADX INFO: renamed from: b */
    public abstract void mo6861b();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            PersonalMainFramgent.f7519b = true;
            PersonalMainFramgent.f7520c = true;
        }
        this.f7397a = getClass().getSimpleName();
        Log.d("BaseActivity", "当前活动的Activity:" + getClass().getSimpleName());
        C1834jr.m10011a(this);
        mo6860a();
        mo6861b();
    }

    /* JADX INFO: renamed from: j */
    public void m7733j() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            m7733j();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: renamed from: c */
    public void m7732c(int i) {
        if (C1834jr.f10797a.size() < i) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            C1834jr.f10797a.pop().finish();
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1834jr.m10012b(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        ada.m302b(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ada.m301a(this);
    }

    /* JADX INFO: renamed from: k */
    public void m7734k() {
        if (getWindow().getAttributes().softInputMode == 2 || getCurrentFocus() == null) {
            return;
        }
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }
}
