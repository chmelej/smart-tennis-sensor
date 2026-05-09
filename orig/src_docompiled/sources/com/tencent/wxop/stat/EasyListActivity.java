package com.tencent.wxop.stat;

import android.app.ListActivity;
import p000.acd;

/* JADX INFO: loaded from: classes.dex */
public class EasyListActivity extends ListActivity {
    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        acd.m207b(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        acd.m198a(this);
    }
}
