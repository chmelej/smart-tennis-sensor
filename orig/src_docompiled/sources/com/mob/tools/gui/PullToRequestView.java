package com.mob.tools.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public class PullToRequestView extends RelativeLayout {
    private static final long MIN_REF_TIME = 1000;
    private PullToRequestAdatper adapter;
    private View bodyView;
    private float downY;
    private int footerHeight;
    private View footerView;
    private int headerHeight;
    private View headerView;
    private long pullTime;
    private boolean pullingDownLock;
    private boolean pullingUpLock;
    private int state;
    private Runnable stopAct;
    private int top;

    public PullToRequestView(Context context) {
        super(context);
        init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.stopAct = new Runnable() { // from class: com.mob.tools.gui.PullToRequestView.1
            @Override // java.lang.Runnable
            public void run() {
                PullToRequestView.this.reversePulling();
            }
        };
    }

    public void setAdapter(PullToRequestAdatper pullToRequestAdatper) {
        this.adapter = pullToRequestAdatper;
        removeAllViews();
        this.bodyView = (View) pullToRequestAdatper.getBodyView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(9);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        addView(this.bodyView, layoutParams);
        this.headerView = pullToRequestAdatper.getHeaderView();
        this.headerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.headerView.measure(0, 0);
        this.headerHeight = this.headerView.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams2.addRule(9);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = -this.headerHeight;
        addView(this.headerView, layoutParams2);
        this.footerView = pullToRequestAdatper.getFooterView();
        this.footerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.footerView.measure(0, 0);
        this.footerHeight = this.footerView.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams3.addRule(9);
        layoutParams3.addRule(11);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = -this.headerHeight;
        addView(this.footerView, layoutParams3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.downY = motionEvent.getY();
                break;
            case 1:
            case 3:
                switch (this.state) {
                    case -1:
                        this.top = -this.footerHeight;
                        scrollTo(0, -this.top);
                        break;
                    case 0:
                        if (this.top > this.headerHeight) {
                            this.top = this.headerHeight;
                            scrollTo(0, -this.top);
                            if (this.adapter != null) {
                                this.adapter.onPullDown(100);
                            }
                            performFresh();
                            motionEvent = getCancelEvent(motionEvent);
                        } else if (this.top < (-this.footerHeight)) {
                            this.top = -this.footerHeight;
                            scrollTo(0, -this.top);
                            if (this.adapter != null) {
                                this.adapter.onPullUp(100);
                            }
                            performRequestNext();
                            motionEvent = getCancelEvent(motionEvent);
                        } else if (this.top != 0) {
                            scrollTo(0, 0);
                            if (this.adapter != null) {
                                if (this.top > 0) {
                                    this.adapter.onPullDown(0);
                                } else {
                                    this.adapter.onPullUp(0);
                                }
                            }
                            this.top = 0;
                        }
                        break;
                    case 1:
                        this.top = this.headerHeight;
                        scrollTo(0, -this.top);
                        break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                int i = this.state;
                if (i == -1) {
                    this.top = (int) (this.top + ((y - this.downY) / 2.0f));
                    if (this.top > 0) {
                        this.top = 0;
                    }
                    scrollTo(0, -this.top);
                    motionEvent = getCancelEvent(motionEvent);
                } else if (i == 1) {
                    this.top = (int) (this.top + ((y - this.downY) / 2.0f));
                    if (this.top < 0) {
                        this.top = 0;
                    }
                    scrollTo(0, -this.top);
                    motionEvent = getCancelEvent(motionEvent);
                } else if (this.top > 0) {
                    this.top = (int) (this.top + ((y - this.downY) / 2.0f));
                    if (this.top < 0) {
                        this.top = 0;
                    }
                    scrollTo(0, -this.top);
                    if (this.adapter != null && this.headerHeight != 0) {
                        this.adapter.onPullDown((this.top * 100) / this.headerHeight);
                    }
                    motionEvent = getCancelEvent(motionEvent);
                } else if (this.top < 0) {
                    this.top = (int) (this.top + ((y - this.downY) / 2.0f));
                    if (this.top > 0) {
                        this.top = 0;
                    }
                    scrollTo(0, -this.top);
                    if (this.adapter != null && this.footerHeight != 0) {
                        this.adapter.onPullUp(((-this.top) * 100) / this.footerHeight);
                    }
                    motionEvent = getCancelEvent(motionEvent);
                } else if (y > this.downY) {
                    if (canPullDown()) {
                        this.top = (int) (this.top + ((y - this.downY) / 2.0f));
                        scrollTo(0, -this.top);
                        if (this.adapter != null && this.headerHeight != 0) {
                            this.adapter.onPullUp(((-this.top) * 100) / this.headerHeight);
                        }
                        motionEvent = getCancelEvent(motionEvent);
                    }
                } else if (y < this.downY && canPullUp()) {
                    this.top = (int) (this.top + ((y - this.downY) / 2.0f));
                    scrollTo(0, -this.top);
                    if (this.adapter != null && this.footerHeight != 0) {
                        this.adapter.onPullUp(((-this.top) * 100) / this.footerHeight);
                    }
                    motionEvent = getCancelEvent(motionEvent);
                }
                this.downY = y;
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private MotionEvent getCancelEvent(MotionEvent motionEvent) {
        return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    public void performPullingDown(boolean z) {
        this.top = this.headerHeight;
        scrollTo(0, -this.top);
        if (z) {
            performFresh();
        }
    }

    private void performFresh() {
        this.pullTime = System.currentTimeMillis();
        this.state = 1;
        if (this.adapter != null) {
            this.adapter.onRefresh();
        }
    }

    public void performPullingUp(boolean z) {
        this.top = -this.footerHeight;
        scrollTo(0, -this.top);
        if (z) {
            performRequestNext();
        }
    }

    private void performRequestNext() {
        this.pullTime = System.currentTimeMillis();
        this.state = -1;
        if (this.adapter != null) {
            this.adapter.onRequestNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reversePulling() {
        this.top = 0;
        scrollTo(0, 0);
        this.state = 0;
        if (this.adapter != null) {
            this.adapter.onReversed();
        }
    }

    public void stopPulling() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.pullTime;
        if (jCurrentTimeMillis < MIN_REF_TIME) {
            postDelayed(this.stopAct, MIN_REF_TIME - jCurrentTimeMillis);
        } else {
            post(this.stopAct);
        }
    }

    public void lockPullingDown() {
        this.pullingDownLock = true;
    }

    public void lockPullingUp() {
        this.pullingUpLock = true;
    }

    public void releasePullingDownLock() {
        this.pullingDownLock = false;
    }

    public void releasePullingUpLock() {
        this.pullingUpLock = false;
    }

    private boolean canPullDown() {
        return !this.pullingDownLock && this.adapter.isPullDownReady() && this.state == 0;
    }

    private boolean canPullUp() {
        return !this.pullingUpLock && this.adapter.isPullUpReady() && this.state == 0;
    }
}
