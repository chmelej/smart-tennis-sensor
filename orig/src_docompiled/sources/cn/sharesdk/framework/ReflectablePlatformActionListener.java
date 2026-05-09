package cn.sharesdk.framework;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ReflectablePlatformActionListener implements PlatformActionListener {

    /* JADX INFO: renamed from: a */
    private int f5515a;

    /* JADX INFO: renamed from: b */
    private Handler.Callback f5516b;

    /* JADX INFO: renamed from: c */
    private int f5517c;

    /* JADX INFO: renamed from: d */
    private Handler.Callback f5518d;

    /* JADX INFO: renamed from: e */
    private int f5519e;

    /* JADX INFO: renamed from: f */
    private Handler.Callback f5520f;

    public void setOnCompleteCallback(int i, Handler.Callback callback) {
        this.f5515a = i;
        this.f5516b = callback;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
        if (this.f5516b != null) {
            Message message = new Message();
            message.what = this.f5515a;
            message.obj = new Object[]{platform, Integer.valueOf(i), map};
            UIHandler.sendMessage(message, this.f5516b);
        }
    }

    public void setOnErrorCallback(int i, Handler.Callback callback) {
        this.f5517c = i;
        this.f5518d = callback;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i, Throwable th) {
        if (this.f5518d != null) {
            Message message = new Message();
            message.what = this.f5517c;
            message.obj = new Object[]{platform, Integer.valueOf(i), th};
            UIHandler.sendMessage(message, this.f5518d);
        }
    }

    public void setOnCancelCallback(int i, Handler.Callback callback) {
        this.f5519e = i;
        this.f5520f = callback;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i) {
        if (this.f5520f != null) {
            Message message = new Message();
            message.what = this.f5519e;
            message.obj = new Object[]{platform, Integer.valueOf(i)};
            UIHandler.sendMessage(message, this.f5520f);
        }
    }
}
