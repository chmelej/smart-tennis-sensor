package cn.sharesdk.framework.authorize;

import android.content.Intent;

/* JADX INFO: renamed from: cn.sharesdk.framework.authorize.d */
/* JADX INFO: compiled from: SSOProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0825d {

    /* JADX INFO: renamed from: a */
    protected C0824c f5552a;

    /* JADX INFO: renamed from: b */
    protected int f5553b;

    /* JADX INFO: renamed from: c */
    protected SSOListener f5554c;

    /* JADX INFO: renamed from: a */
    public abstract void mo5905a();

    /* JADX INFO: renamed from: a */
    public void mo5906a(int i, int i2, Intent intent) {
    }

    /* JADX INFO: renamed from: a */
    protected void m5986a(Intent intent) {
    }

    public AbstractC0825d(C0824c c0824c) {
        this.f5552a = c0824c;
        this.f5554c = c0824c.m5982a().getSSOListener();
    }

    /* JADX INFO: renamed from: a */
    public void m5985a(int i) {
        this.f5553b = i;
    }
}
