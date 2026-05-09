package com.coollang.tennis.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class MyScrollView extends ScrollView {

    /* JADX INFO: renamed from: a */
    Context f8467a;

    /* JADX INFO: renamed from: b */
    @SuppressLint({"HandlerLeak"})
    Handler f8468b;

    /* JADX INFO: renamed from: c */
    private View f8469c;

    /* JADX INFO: renamed from: d */
    private float f8470d;

    /* JADX INFO: renamed from: e */
    private int f8471e;

    /* JADX INFO: renamed from: f */
    private boolean f8472f;

    /* JADX INFO: renamed from: g */
    private int f8473g;

    public MyScrollView(Context context) {
        super(context);
        this.f8471e = 0;
        this.f8472f = false;
        this.f8473g = 0;
        this.f8468b = new Handler() { // from class: com.coollang.tennis.widget.MyScrollView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (MyScrollView.this.f8471e == 0 || !MyScrollView.this.f8472f) {
                    return;
                }
                MyScrollView.this.f8471e -= MyScrollView.this.f8473g;
                if ((MyScrollView.this.f8473g < 0 && MyScrollView.this.f8471e > 0) || (MyScrollView.this.f8473g > 0 && MyScrollView.this.f8471e < 0)) {
                    MyScrollView.this.f8471e = 0;
                }
                MyScrollView.this.f8469c.scrollTo(0, MyScrollView.this.f8471e);
                sendEmptyMessageDelayed(0, 5L);
            }
        };
        this.f8467a = context;
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8471e = 0;
        this.f8472f = false;
        this.f8473g = 0;
        this.f8468b = new Handler() { // from class: com.coollang.tennis.widget.MyScrollView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (MyScrollView.this.f8471e == 0 || !MyScrollView.this.f8472f) {
                    return;
                }
                MyScrollView.this.f8471e -= MyScrollView.this.f8473g;
                if ((MyScrollView.this.f8473g < 0 && MyScrollView.this.f8471e > 0) || (MyScrollView.this.f8473g > 0 && MyScrollView.this.f8471e < 0)) {
                    MyScrollView.this.f8471e = 0;
                }
                MyScrollView.this.f8469c.scrollTo(0, MyScrollView.this.f8471e);
                sendEmptyMessageDelayed(0, 5L);
            }
        };
        this.f8467a = context;
    }

    public MyScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8471e = 0;
        this.f8472f = false;
        this.f8473g = 0;
        this.f8468b = new Handler() { // from class: com.coollang.tennis.widget.MyScrollView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (MyScrollView.this.f8471e == 0 || !MyScrollView.this.f8472f) {
                    return;
                }
                MyScrollView.this.f8471e -= MyScrollView.this.f8473g;
                if ((MyScrollView.this.f8473g < 0 && MyScrollView.this.f8471e > 0) || (MyScrollView.this.f8473g > 0 && MyScrollView.this.f8471e < 0)) {
                    MyScrollView.this.f8471e = 0;
                }
                MyScrollView.this.f8469c.scrollTo(0, MyScrollView.this.f8471e);
                sendEmptyMessageDelayed(0, 5L);
            }
        };
        this.f8467a = context;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.f8469c = getChildAt(0);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f8470d = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8469c == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.f8470d = motionEvent.getY();
        }
        m8183a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    private void m8183a(MotionEvent motionEvent) {
        int scrollY;
        switch (motionEvent.getAction()) {
            case 1:
                if (this.f8469c.getScrollY() != 0) {
                    this.f8472f = true;
                    m8185b();
                }
                break;
            case 2:
                float y = motionEvent.getY();
                int i = (int) (this.f8470d - y);
                this.f8470d = y;
                if (m8184a() && (scrollY = this.f8469c.getScrollY()) < 500 && scrollY > -500) {
                    this.f8469c.scrollBy(0, (int) (i * 0.4f));
                    this.f8472f = false;
                    break;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m8184a() {
        int measuredHeight = this.f8469c.getMeasuredHeight() - getHeight();
        int scrollY = getScrollY();
        return scrollY == 0 || scrollY == measuredHeight;
    }

    /* JADX INFO: renamed from: b */
    private void m8185b() {
        this.f8471e = this.f8469c.getScrollY();
        this.f8473g = this.f8471e / 10;
        this.f8468b.sendEmptyMessage(0);
    }
}
