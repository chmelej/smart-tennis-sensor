package p000;

import cn.jeesoft.widget.pickerview.LoopView;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: ie */
/* JADX INFO: compiled from: LoopTimerTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1794ie extends TimerTask {

    /* JADX INFO: renamed from: a */
    float f10312a = 2.1474839E9f;

    /* JADX INFO: renamed from: b */
    final float f10313b;

    /* JADX INFO: renamed from: c */
    final Timer f10314c;

    /* JADX INFO: renamed from: d */
    final LoopView f10315d;

    public C1794ie(LoopView loopView, float f, Timer timer) {
        this.f10315d = loopView;
        this.f10313b = f;
        this.f10314c = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f10312a == 2.1474839E9f) {
            if (Math.abs(this.f10313b) <= 2000.0f) {
                this.f10312a = this.f10313b;
            } else if (this.f10313b > 0.0f) {
                this.f10312a = 2000.0f;
            } else {
                this.f10312a = -2000.0f;
            }
        }
        if (Math.abs(this.f10312a) >= 0.0f && Math.abs(this.f10312a) <= 20.0f) {
            this.f10314c.cancel();
            this.f10315d.f5362c.sendEmptyMessage(2000);
            return;
        }
        this.f10315d.f5361b -= (int) ((this.f10312a * 10.0f) / 1000.0f);
        if (!this.f10315d.f5376q) {
            if (this.f10315d.f5361b <= ((int) ((-this.f10315d.f5380u) * this.f10315d.f5375p * this.f10315d.f5371l))) {
                this.f10312a = 40.0f;
                this.f10315d.f5361b = (int) ((-this.f10315d.f5380u) * this.f10315d.f5375p * this.f10315d.f5371l);
            } else if (this.f10315d.f5361b >= ((int) (((this.f10315d.f5368i.size() - 1) - this.f10315d.f5380u) * this.f10315d.f5375p * this.f10315d.f5371l))) {
                this.f10315d.f5361b = (int) (((this.f10315d.f5368i.size() - 1) - this.f10315d.f5380u) * this.f10315d.f5375p * this.f10315d.f5371l);
                this.f10312a = -40.0f;
            }
        }
        if (this.f10312a < 0.0f) {
            this.f10312a += 20.0f;
        } else {
            this.f10312a -= 20.0f;
        }
        this.f10315d.f5362c.sendEmptyMessage(1000);
    }
}
