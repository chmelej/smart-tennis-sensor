package p000;

import android.view.GestureDetector;
import android.view.MotionEvent;
import cn.jeesoft.widget.pickerview.LoopView;

/* JADX INFO: renamed from: if */
/* JADX INFO: compiled from: LoopViewGestureListener.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1795if extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a */
    final LoopView f10316a;

    public C1795if(LoopView loopView) {
        this.f10316a = loopView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        if (this.f10316a.f5360a == null) {
            return true;
        }
        this.f10316a.f5360a.cancel();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f10316a.m5812a(f2);
        return true;
    }
}
