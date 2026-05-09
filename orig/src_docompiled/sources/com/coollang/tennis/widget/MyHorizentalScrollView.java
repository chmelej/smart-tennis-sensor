package com.coollang.tennis.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import p000.InterfaceC1879li;

/* JADX INFO: loaded from: classes.dex */
public class MyHorizentalScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a */
    InterfaceC1879li f8444a;

    /* JADX INFO: renamed from: b */
    int f8445b;

    /* JADX INFO: renamed from: c */
    int f8446c;

    /* JADX INFO: renamed from: d */
    Runnable f8447d;

    /* JADX INFO: renamed from: e */
    private Handler f8448e;

    /* JADX INFO: renamed from: f */
    private boolean f8449f;

    /* JADX INFO: renamed from: g */
    private boolean f8450g;

    /* JADX INFO: renamed from: h */
    private boolean f8451h;

    public MyHorizentalScrollView(Context context) {
        super(context);
        this.f8445b = 0;
        this.f8446c = 0;
        this.f8450g = false;
        this.f8451h = false;
        this.f8447d = new Runnable() { // from class: com.coollang.tennis.widget.MyHorizentalScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MyHorizentalScrollView.this.f8451h) {
                    MyHorizentalScrollView.this.f8448e.postDelayed(this, 50L);
                }
                if (MyHorizentalScrollView.this.f8446c != MyHorizentalScrollView.this.f8445b) {
                    MyHorizentalScrollView.this.f8450g = true;
                    MyHorizentalScrollView.this.f8446c = MyHorizentalScrollView.this.f8445b;
                } else if (MyHorizentalScrollView.this.f8445b != 0) {
                    MyHorizentalScrollView.this.f8444a.mo6951a(MyHorizentalScrollView.this.f8445b);
                    MyHorizentalScrollView.this.f8446c = 0;
                } else if (MyHorizentalScrollView.this.f8445b == 0 && MyHorizentalScrollView.this.f8450g) {
                    MyHorizentalScrollView.this.f8450g = false;
                    MyHorizentalScrollView.this.f8444a.mo6951a(MyHorizentalScrollView.this.f8445b);
                }
            }
        };
        m8175a();
    }

    public MyHorizentalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8445b = 0;
        this.f8446c = 0;
        this.f8450g = false;
        this.f8451h = false;
        this.f8447d = new Runnable() { // from class: com.coollang.tennis.widget.MyHorizentalScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MyHorizentalScrollView.this.f8451h) {
                    MyHorizentalScrollView.this.f8448e.postDelayed(this, 50L);
                }
                if (MyHorizentalScrollView.this.f8446c != MyHorizentalScrollView.this.f8445b) {
                    MyHorizentalScrollView.this.f8450g = true;
                    MyHorizentalScrollView.this.f8446c = MyHorizentalScrollView.this.f8445b;
                } else if (MyHorizentalScrollView.this.f8445b != 0) {
                    MyHorizentalScrollView.this.f8444a.mo6951a(MyHorizentalScrollView.this.f8445b);
                    MyHorizentalScrollView.this.f8446c = 0;
                } else if (MyHorizentalScrollView.this.f8445b == 0 && MyHorizentalScrollView.this.f8450g) {
                    MyHorizentalScrollView.this.f8450g = false;
                    MyHorizentalScrollView.this.f8444a.mo6951a(MyHorizentalScrollView.this.f8445b);
                }
            }
        };
        m8175a();
    }

    public MyHorizentalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8445b = 0;
        this.f8446c = 0;
        this.f8450g = false;
        this.f8451h = false;
        this.f8447d = new Runnable() { // from class: com.coollang.tennis.widget.MyHorizentalScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!MyHorizentalScrollView.this.f8451h) {
                    MyHorizentalScrollView.this.f8448e.postDelayed(this, 50L);
                }
                if (MyHorizentalScrollView.this.f8446c != MyHorizentalScrollView.this.f8445b) {
                    MyHorizentalScrollView.this.f8450g = true;
                    MyHorizentalScrollView.this.f8446c = MyHorizentalScrollView.this.f8445b;
                } else if (MyHorizentalScrollView.this.f8445b != 0) {
                    MyHorizentalScrollView.this.f8444a.mo6951a(MyHorizentalScrollView.this.f8445b);
                    MyHorizentalScrollView.this.f8446c = 0;
                } else if (MyHorizentalScrollView.this.f8445b == 0 && MyHorizentalScrollView.this.f8450g) {
                    MyHorizentalScrollView.this.f8450g = false;
                    MyHorizentalScrollView.this.f8444a.mo6951a(MyHorizentalScrollView.this.f8445b);
                }
            }
        };
        m8175a();
    }

    /* JADX INFO: renamed from: a */
    public void m8175a() {
        this.f8448e = new Handler();
        this.f8449f = this.f8448e.postDelayed(this.f8447d, 50L);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.f8445b = i;
        if (this.f8449f) {
            return;
        }
        this.f8449f = this.f8448e.postDelayed(this.f8447d, 50L);
    }

    public void setOnScrollListener(InterfaceC1879li interfaceC1879li) {
        this.f8444a = interfaceC1879li;
    }

    /* JADX INFO: renamed from: b */
    public void m8176b() {
        this.f8448e.removeCallbacks(this.f8447d);
        this.f8449f = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f8451h = true;
        super.onDetachedFromWindow();
    }
}
