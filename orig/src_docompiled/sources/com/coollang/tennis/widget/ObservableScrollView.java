package com.coollang.tennis.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.coollang.tennis.beans.ScrollState;
import java.util.List;
import p000.InterfaceC1877lg;
import p000.InterfaceC1882ll;

/* JADX INFO: loaded from: classes.dex */
public class ObservableScrollView extends ScrollView implements InterfaceC1882ll {

    /* JADX INFO: renamed from: a */
    private int f8562a;

    /* JADX INFO: renamed from: b */
    private int f8563b;

    /* JADX INFO: renamed from: c */
    private InterfaceC1877lg f8564c;

    /* JADX INFO: renamed from: d */
    private List<InterfaceC1877lg> f8565d;

    /* JADX INFO: renamed from: e */
    private ScrollState f8566e;

    /* JADX INFO: renamed from: f */
    private boolean f8567f;

    /* JADX INFO: renamed from: g */
    private boolean f8568g;

    /* JADX INFO: renamed from: h */
    private boolean f8569h;

    /* JADX INFO: renamed from: i */
    private MotionEvent f8570i;

    /* JADX INFO: renamed from: j */
    private ViewGroup f8571j;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.f8562a = savedState.f8575a;
        this.f8563b = savedState.f8576b;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.widget.ScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8575a = this.f8562a;
        savedState.f8576b = this.f8563b;
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (m8237b()) {
            return;
        }
        this.f8563b = i2;
        m8235a(i2, this.f8567f, this.f8568g);
        if (this.f8567f) {
            this.f8567f = false;
        }
        if (this.f8562a < i2) {
            this.f8566e = ScrollState.UP;
        } else if (i2 < this.f8562a) {
            this.f8566e = ScrollState.DOWN;
        }
        this.f8562a = i2;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (m8237b()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f8568g = true;
            this.f8567f = true;
            m8234a();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        final ViewGroup viewGroup;
        if (m8237b()) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getActionMasked()) {
            case 1:
            case 3:
                this.f8569h = false;
                this.f8568g = false;
                m8236a(this.f8566e);
                break;
            case 2:
                if (this.f8570i == null) {
                    this.f8570i = motionEvent;
                }
                float y = motionEvent.getY() - this.f8570i.getY();
                this.f8570i = MotionEvent.obtainNoHistory(motionEvent);
                if (getCurrentScrollY() - y <= 0.0f) {
                    if (this.f8569h) {
                        return false;
                    }
                    if (this.f8571j == null) {
                        viewGroup = (ViewGroup) getParent();
                    } else {
                        viewGroup = this.f8571j;
                    }
                    float left = 0.0f;
                    float top = 0.0f;
                    for (View view = this; view != null && view != viewGroup; view = (View) view.getParent()) {
                        left += view.getLeft() - view.getScrollX();
                        top += view.getTop() - view.getScrollY();
                    }
                    final MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                    motionEventObtainNoHistory.offsetLocation(left, top);
                    if (viewGroup.onInterceptTouchEvent(motionEventObtainNoHistory)) {
                        this.f8569h = true;
                        motionEventObtainNoHistory.setAction(0);
                        post(new Runnable() { // from class: com.coollang.tennis.widget.ObservableScrollView.1
                            @Override // java.lang.Runnable
                            public void run() {
                                viewGroup.dispatchTouchEvent(motionEventObtainNoHistory);
                            }
                        });
                        return false;
                    }
                    return super.onTouchEvent(motionEvent);
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollViewCallbacks(InterfaceC1877lg interfaceC1877lg) {
        this.f8564c = interfaceC1877lg;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.f8571j = viewGroup;
    }

    public int getCurrentScrollY() {
        return this.f8563b;
    }

    /* JADX INFO: renamed from: a */
    private void m8234a() {
        if (this.f8564c != null) {
            this.f8564c.mo7825c();
        }
        if (this.f8565d != null) {
            for (int i = 0; i < this.f8565d.size(); i++) {
                this.f8565d.get(i).mo7825c();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8235a(int i, boolean z, boolean z2) {
        if (this.f8564c != null) {
            this.f8564c.mo7821a(i, z, z2);
        }
        if (this.f8565d != null) {
            for (int i2 = 0; i2 < this.f8565d.size(); i2++) {
                this.f8565d.get(i2).mo7821a(i, z, z2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8236a(ScrollState scrollState) {
        if (this.f8564c != null) {
            this.f8564c.mo7823a(scrollState);
        }
        if (this.f8565d != null) {
            for (int i = 0; i < this.f8565d.size(); i++) {
                this.f8565d.get(i).mo7823a(scrollState);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m8237b() {
        return this.f8564c == null && this.f8565d == null;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coollang.tennis.widget.ObservableScrollView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        int f8575a;

        /* JADX INFO: renamed from: b */
        int f8576b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f8575a = parcel.readInt();
            this.f8576b = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8575a);
            parcel.writeInt(this.f8576b);
        }
    }
}
