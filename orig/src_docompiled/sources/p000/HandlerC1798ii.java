package p000;

import android.os.Handler;
import android.os.Message;
import cn.jeesoft.widget.pickerview.LoopView;

/* JADX INFO: renamed from: ii */
/* JADX INFO: compiled from: MessageHandler.java */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC1798ii extends Handler {

    /* JADX INFO: renamed from: a */
    final LoopView f10333a;

    public HandlerC1798ii(LoopView loopView) {
        this.f10333a = loopView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1000) {
            this.f10333a.invalidate();
        }
        if (message.what == 2000) {
            LoopView.m5808b(this.f10333a);
        } else if (message.what == 3000) {
            this.f10333a.m5811a();
        }
        super.handleMessage(message);
    }
}
