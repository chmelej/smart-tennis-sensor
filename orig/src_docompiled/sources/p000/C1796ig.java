package p000;

import cn.jeesoft.widget.pickerview.LoopView;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: ig */
/* JADX INFO: compiled from: MTimer.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1796ig extends TimerTask {

    /* JADX INFO: renamed from: a */
    int f10317a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b */
    int f10318b = 0;

    /* JADX INFO: renamed from: c */
    final int f10319c;

    /* JADX INFO: renamed from: d */
    final Timer f10320d;

    /* JADX INFO: renamed from: e */
    final LoopView f10321e;

    public C1796ig(LoopView loopView, int i, Timer timer) {
        this.f10321e = loopView;
        this.f10319c = i;
        this.f10320d = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f10317a == Integer.MAX_VALUE) {
            if (this.f10319c < 0) {
                if ((-this.f10319c) > (this.f10321e.f5375p * this.f10321e.f5371l) / 2.0f) {
                    this.f10317a = (int) (((-this.f10321e.f5375p) * this.f10321e.f5371l) - this.f10319c);
                } else {
                    this.f10317a = -this.f10319c;
                }
            } else if (this.f10319c > (this.f10321e.f5375p * this.f10321e.f5371l) / 2.0f) {
                this.f10317a = (int) ((this.f10321e.f5375p * this.f10321e.f5371l) - this.f10319c);
            } else {
                this.f10317a = -this.f10319c;
            }
        }
        this.f10318b = (int) (this.f10317a * 0.1f);
        if (this.f10318b == 0) {
            if (this.f10317a < 0) {
                this.f10318b = -1;
            } else {
                this.f10318b = 1;
            }
        }
        if (Math.abs(this.f10317a) <= 0) {
            this.f10320d.cancel();
            this.f10321e.f5362c.sendEmptyMessage(3000);
        } else {
            this.f10321e.f5361b += this.f10318b;
            this.f10321e.f5362c.sendEmptyMessage(1000);
            this.f10317a -= this.f10318b;
        }
    }
}
