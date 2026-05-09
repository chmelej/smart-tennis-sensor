package cn.smssdk;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class ReflectableEnventHandler extends EventHandler {

    /* JADX INFO: renamed from: a */
    private int f5952a;

    /* JADX INFO: renamed from: b */
    private Handler.Callback f5953b;

    /* JADX INFO: renamed from: c */
    private int f5954c;

    /* JADX INFO: renamed from: d */
    private Handler.Callback f5955d;

    /* JADX INFO: renamed from: e */
    private int f5956e;

    /* JADX INFO: renamed from: f */
    private Handler.Callback f5957f;

    /* JADX INFO: renamed from: g */
    private int f5958g;

    /* JADX INFO: renamed from: h */
    private Handler.Callback f5959h;

    public void setOnRegisterCallback(int i, Handler.Callback callback) {
        this.f5952a = i;
        this.f5953b = callback;
    }

    @Override // cn.smssdk.EventHandler
    public void onRegister() {
        if (this.f5953b != null) {
            Message message = new Message();
            message.what = this.f5952a;
            this.f5953b.handleMessage(message);
        }
    }

    public void setBeforeEventCallback(int i, Handler.Callback callback) {
        this.f5954c = i;
        this.f5955d = callback;
    }

    @Override // cn.smssdk.EventHandler
    public void beforeEvent(int i, Object obj) {
        if (this.f5955d != null) {
            Message message = new Message();
            message.what = this.f5954c;
            message.obj = new Object[]{Integer.valueOf(i), obj};
            this.f5955d.handleMessage(message);
        }
    }

    public void setAfterEventCallback(int i, Handler.Callback callback) {
        this.f5956e = i;
        this.f5957f = callback;
    }

    @Override // cn.smssdk.EventHandler
    public void afterEvent(int i, int i2, Object obj) {
        if (this.f5957f != null) {
            Message message = new Message();
            message.what = this.f5956e;
            message.obj = new Object[]{Integer.valueOf(i), Integer.valueOf(i2), obj};
            this.f5957f.handleMessage(message);
        }
    }

    public void setOnUnregisterCallback(int i, Handler.Callback callback) {
        this.f5958g = i;
        this.f5959h = callback;
    }

    @Override // cn.smssdk.EventHandler
    public void onUnregister() {
        if (this.f5959h != null) {
            Message message = new Message();
            message.what = this.f5958g;
            this.f5959h.handleMessage(message);
        }
    }
}
