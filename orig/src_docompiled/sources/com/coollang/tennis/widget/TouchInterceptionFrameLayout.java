package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class TouchInterceptionFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private boolean f8796a;

    /* JADX INFO: renamed from: b */
    private boolean f8797b;

    /* JADX INFO: renamed from: c */
    private boolean f8798c;

    /* JADX INFO: renamed from: d */
    private boolean f8799d;

    /* JADX INFO: renamed from: e */
    private PointF f8800e;

    /* JADX INFO: renamed from: f */
    private MotionEvent f8801f;

    /* JADX INFO: renamed from: g */
    private InterfaceC1383a f8802g;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.TouchInterceptionFrameLayout$a */
    public interface InterfaceC1383a {
        /* JADX INFO: renamed from: a */
        void mo7829a(MotionEvent motionEvent);

        /* JADX INFO: renamed from: a */
        void mo7830a(MotionEvent motionEvent, float f, float f2);

        /* JADX INFO: renamed from: a */
        boolean mo7831a(MotionEvent motionEvent, boolean z, float f, float f2);

        /* JADX INFO: renamed from: b */
        void mo7832b(MotionEvent motionEvent);
    }

    public TouchInterceptionFrameLayout(Context context) {
        super(context);
    }

    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public TouchInterceptionFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setScrollInterceptionListener(InterfaceC1383a interfaceC1383a) {
        this.f8802g = interfaceC1383a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f8802g == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8800e = new PointF(motionEvent.getX(), motionEvent.getY());
            this.f8801f = MotionEvent.obtainNoHistory(motionEvent);
            this.f8797b = true;
            this.f8796a = this.f8802g.mo7831a(motionEvent, false, 0.0f, 0.0f);
            this.f8798c = this.f8796a;
            this.f8799d = false;
            return this.f8796a;
        }
        if (actionMasked != 2) {
            return false;
        }
        if (this.f8800e == null) {
            this.f8800e = new PointF(motionEvent.getX(), motionEvent.getY());
        }
        this.f8796a = this.f8802g.mo7831a(motionEvent, true, motionEvent.getX() - this.f8800e.x, motionEvent.getY() - this.f8800e.y);
        return this.f8796a;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8802g != null) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (this.f8796a) {
                        this.f8802g.mo7829a(motionEvent);
                        m8324a(motionEvent, new MotionEvent[0]);
                        return true;
                    }
                    break;
                case 1:
                case 3:
                    this.f8798c = false;
                    if (this.f8796a) {
                        this.f8802g.mo7832b(motionEvent);
                    }
                    if (!this.f8799d) {
                        this.f8799d = true;
                        if (this.f8797b) {
                            this.f8797b = false;
                            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(this.f8801f);
                            motionEventObtainNoHistory.setLocation(motionEvent.getX(), motionEvent.getY());
                            m8324a(motionEvent, motionEventObtainNoHistory);
                        } else {
                            m8324a(motionEvent, new MotionEvent[0]);
                        }
                    }
                    return true;
                case 2:
                    if (this.f8800e == null) {
                        this.f8800e = new PointF(motionEvent.getX(), motionEvent.getY());
                    }
                    float x = motionEvent.getX() - this.f8800e.x;
                    float y = motionEvent.getY() - this.f8800e.y;
                    this.f8796a = this.f8802g.mo7831a(motionEvent, true, x, y);
                    if (this.f8796a) {
                        if (!this.f8798c) {
                            this.f8798c = true;
                            MotionEvent motionEventObtainNoHistory2 = MotionEvent.obtainNoHistory(this.f8801f);
                            motionEventObtainNoHistory2.setLocation(motionEvent.getX(), motionEvent.getY());
                            this.f8802g.mo7829a(motionEventObtainNoHistory2);
                            this.f8800e = new PointF(motionEvent.getX(), motionEvent.getY());
                            x = 0.0f;
                            y = 0.0f;
                        }
                        if (!this.f8799d) {
                            this.f8799d = true;
                            m8324a(m8323a(motionEvent, 3), new MotionEvent[0]);
                        }
                        this.f8802g.mo7830a(motionEvent, x, y);
                        this.f8797b = true;
                        return true;
                    }
                    if (this.f8797b) {
                        this.f8797b = false;
                        MotionEvent motionEventObtainNoHistory3 = MotionEvent.obtainNoHistory(this.f8801f);
                        motionEventObtainNoHistory3.setLocation(motionEvent.getX(), motionEvent.getY());
                        m8324a(motionEvent, motionEventObtainNoHistory3);
                    } else {
                        m8324a(motionEvent, new MotionEvent[0]);
                    }
                    this.f8798c = false;
                    this.f8799d = false;
                    break;
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    private MotionEvent m8323a(MotionEvent motionEvent, int i) {
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        motionEventObtainNoHistory.setAction(i);
        return motionEventObtainNoHistory;
    }

    /* JADX INFO: renamed from: a */
    private void m8324a(MotionEvent motionEvent, MotionEvent... motionEventArr) {
        if (motionEvent == null) {
            return;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != null) {
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                if (rect.contains((int) motionEventObtainNoHistory.getX(), (int) motionEventObtainNoHistory.getY())) {
                    float f = -childAt.getLeft();
                    float f2 = -childAt.getTop();
                    boolean z = false;
                    if (motionEventArr != null) {
                        boolean zDispatchTouchEvent = false;
                        for (MotionEvent motionEvent2 : motionEventArr) {
                            if (motionEvent2 != null) {
                                MotionEvent motionEventObtainNoHistory2 = MotionEvent.obtainNoHistory(motionEvent2);
                                motionEventObtainNoHistory2.offsetLocation(f, f2);
                                zDispatchTouchEvent |= childAt.dispatchTouchEvent(motionEventObtainNoHistory2);
                            }
                        }
                        z = zDispatchTouchEvent;
                    }
                    motionEventObtainNoHistory.offsetLocation(f, f2);
                    if ((childAt.dispatchTouchEvent(motionEventObtainNoHistory) | z) != 0) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
