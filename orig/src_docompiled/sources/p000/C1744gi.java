package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: gi */
/* JADX INFO: compiled from: DropDownListView.java */
/* JADX INFO: loaded from: classes.dex */
public class C1744gi extends ListView {

    /* JADX INFO: renamed from: a */
    b f9968a;

    /* JADX INFO: renamed from: b */
    private final Rect f9969b;

    /* JADX INFO: renamed from: c */
    private int f9970c;

    /* JADX INFO: renamed from: d */
    private int f9971d;

    /* JADX INFO: renamed from: e */
    private int f9972e;

    /* JADX INFO: renamed from: f */
    private int f9973f;

    /* JADX INFO: renamed from: g */
    private int f9974g;

    /* JADX INFO: renamed from: h */
    private Field f9975h;

    /* JADX INFO: renamed from: i */
    private a f9976i;

    /* JADX INFO: renamed from: j */
    private boolean f9977j;

    /* JADX INFO: renamed from: k */
    private boolean f9978k;

    /* JADX INFO: renamed from: l */
    private boolean f9979l;

    /* JADX INFO: renamed from: m */
    private ViewPropertyAnimatorCompat f9980m;

    /* JADX INFO: renamed from: n */
    private ListViewAutoScrollHelper f9981n;

    public C1744gi(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f9969b = new Rect();
        this.f9970c = 0;
        this.f9971d = 0;
        this.f9972e = 0;
        this.f9973f = 0;
        this.f9978k = z;
        setCacheColorHint(0);
        try {
            this.f9975h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f9975h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f9978k && this.f9977j) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f9978k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f9978k || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f9978k || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.f9976i = drawable != null ? new a(drawable) : null;
        super.setSelector(this.f9976i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f9970c = rect.left;
        this.f9971d = rect.top;
        this.f9972e = rect.right;
        this.f9973f = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f9968a != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m9430a();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        m9433a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f9974g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f9968a != null) {
            this.f9968a.m9440a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    public int mo3711a(int i, int i2, int i3, int i4, int i5) {
        int iMakeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int measuredHeight = i6;
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, iMakeMeasureSpec);
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i7 <= i5 || i9 <= 0 || measuredHeight == i4) ? i4 : i9;
            }
            if (i5 >= 0 && i7 >= i5) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.f9976i != null) {
            this.f9976i.m9439a(z);
        }
    }

    /* JADX INFO: renamed from: gi$a */
    /* JADX INFO: compiled from: DropDownListView.java */
    static class a extends C1687eh {

        /* JADX INFO: renamed from: a */
        private boolean f9982a;

        a(Drawable drawable) {
            super(drawable);
            this.f9982a = true;
        }

        /* JADX INFO: renamed from: a */
        void m9439a(boolean z) {
            this.f9982a = z;
        }

        @Override // p000.C1687eh, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f9982a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // p000.C1687eh, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f9982a) {
                super.draw(canvas);
            }
        }

        @Override // p000.C1687eh, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f9982a) {
                super.setHotspot(f, f2);
            }
        }

        @Override // p000.C1687eh, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f9982a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // p000.C1687eh, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f9982a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f9968a == null) {
            this.f9968a = new b();
            this.f9968a.m9441b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                m9430a();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f9968a = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo3712a(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            switch(r0) {
                case 1: goto L11;
                case 2: goto Lf;
                case 3: goto Lc;
                default: goto L9;
            }
        L9:
            r9 = 0
            r3 = 1
            goto L41
        Lc:
            r9 = 0
            r3 = 0
            goto L41
        Lf:
            r3 = 1
            goto L12
        L11:
            r3 = 0
        L12:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L19
            goto Lc
        L19:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L2c
            r9 = 1
            goto L41
        L2c:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.m9435a(r3, r5, r4, r9)
            if (r0 != r2) goto L9
            r7.m9434a(r3, r5)
            goto L9
        L41:
            if (r3 == 0) goto L45
            if (r9 == 0) goto L48
        L45:
            r7.m9436b()
        L48:
            if (r3 == 0) goto L60
            android.support.v4.widget.ListViewAutoScrollHelper r9 = r7.f9981n
            if (r9 != 0) goto L55
            android.support.v4.widget.ListViewAutoScrollHelper r9 = new android.support.v4.widget.ListViewAutoScrollHelper
            r9.<init>(r7)
            r7.f9981n = r9
        L55:
            android.support.v4.widget.ListViewAutoScrollHelper r9 = r7.f9981n
            r9.setEnabled(r2)
            android.support.v4.widget.ListViewAutoScrollHelper r9 = r7.f9981n
            r9.onTouch(r7, r8)
            goto L69
        L60:
            android.support.v4.widget.ListViewAutoScrollHelper r8 = r7.f9981n
            if (r8 == 0) goto L69
            android.support.v4.widget.ListViewAutoScrollHelper r8 = r7.f9981n
            r8.setEnabled(r1)
        L69:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1744gi.mo3712a(android.view.MotionEvent, int):boolean");
    }

    /* JADX INFO: renamed from: a */
    private void m9434a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    public void setListSelectionHidden(boolean z) {
        this.f9977j = z;
    }

    /* JADX INFO: renamed from: a */
    private void m9430a() {
        Drawable selector = getSelector();
        if (selector != null && m9438c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9433a(Canvas canvas) {
        Drawable selector;
        if (this.f9969b.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f9969b);
        selector.draw(canvas);
    }

    /* JADX INFO: renamed from: a */
    private void m9432a(int i, View view, float f, float f2) {
        m9431a(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        DrawableCompat.setHotspot(selector, f, f2);
    }

    /* JADX INFO: renamed from: a */
    private void m9431a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m9437b(i, view);
        if (z) {
            Rect rect = this.f9969b;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.setHotspot(selector, fExactCenterX, fExactCenterY);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m9437b(int i, View view) {
        Rect rect = this.f9969b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f9970c;
        rect.top -= this.f9971d;
        rect.right += this.f9972e;
        rect.bottom += this.f9973f;
        try {
            boolean z = this.f9975h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f9975h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m9436b() {
        this.f9979l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f9974g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f9980m != null) {
            this.f9980m.cancel();
            this.f9980m = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9435a(View view, int i, float f, float f2) {
        View childAt;
        this.f9979l = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f9974g != -1 && (childAt = getChildAt(this.f9974g - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f9974g = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m9432a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* JADX INFO: renamed from: c */
    private boolean m9438c() {
        return this.f9979l;
    }

    /* JADX INFO: renamed from: gi$b */
    /* JADX INFO: compiled from: DropDownListView.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1744gi.this.f9968a = null;
            C1744gi.this.drawableStateChanged();
        }

        /* JADX INFO: renamed from: a */
        public void m9440a() {
            C1744gi.this.f9968a = null;
            C1744gi.this.removeCallbacks(this);
        }

        /* JADX INFO: renamed from: b */
        public void m9441b() {
            C1744gi.this.post(this);
        }
    }
}
