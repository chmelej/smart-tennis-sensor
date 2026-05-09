package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import p000.C1744gi;
import p000.InterfaceC1718fj;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements InterfaceC1718fj {

    /* JADX INFO: renamed from: a */
    private static Method f3588a;

    /* JADX INFO: renamed from: b */
    private static Method f3589b;

    /* JADX INFO: renamed from: h */
    private static Method f3590h;

    /* JADX INFO: renamed from: A */
    private Drawable f3591A;

    /* JADX INFO: renamed from: B */
    private AdapterView.OnItemClickListener f3592B;

    /* JADX INFO: renamed from: C */
    private AdapterView.OnItemSelectedListener f3593C;

    /* JADX INFO: renamed from: D */
    private final ViewOnTouchListenerC0594d f3594D;

    /* JADX INFO: renamed from: E */
    private final C0593c f3595E;

    /* JADX INFO: renamed from: F */
    private final RunnableC0591a f3596F;

    /* JADX INFO: renamed from: G */
    private Runnable f3597G;

    /* JADX INFO: renamed from: H */
    private final Rect f3598H;

    /* JADX INFO: renamed from: I */
    private Rect f3599I;

    /* JADX INFO: renamed from: J */
    private boolean f3600J;

    /* JADX INFO: renamed from: c */
    C1744gi f3601c;

    /* JADX INFO: renamed from: d */
    int f3602d;

    /* JADX INFO: renamed from: e */
    final RunnableC0595e f3603e;

    /* JADX INFO: renamed from: f */
    final Handler f3604f;

    /* JADX INFO: renamed from: g */
    PopupWindow f3605g;

    /* JADX INFO: renamed from: i */
    private Context f3606i;

    /* JADX INFO: renamed from: j */
    private ListAdapter f3607j;

    /* JADX INFO: renamed from: k */
    private int f3608k;

    /* JADX INFO: renamed from: l */
    private int f3609l;

    /* JADX INFO: renamed from: m */
    private int f3610m;

    /* JADX INFO: renamed from: n */
    private int f3611n;

    /* JADX INFO: renamed from: o */
    private int f3612o;

    /* JADX INFO: renamed from: p */
    private boolean f3613p;

    /* JADX INFO: renamed from: q */
    private boolean f3614q;

    /* JADX INFO: renamed from: r */
    private boolean f3615r;

    /* JADX INFO: renamed from: s */
    private boolean f3616s;

    /* JADX INFO: renamed from: t */
    private int f3617t;

    /* JADX INFO: renamed from: u */
    private boolean f3618u;

    /* JADX INFO: renamed from: v */
    private boolean f3619v;

    /* JADX INFO: renamed from: w */
    private View f3620w;

    /* JADX INFO: renamed from: x */
    private int f3621x;

    /* JADX INFO: renamed from: y */
    private DataSetObserver f3622y;

    /* JADX INFO: renamed from: z */
    private View f3623z;

    static {
        try {
            f3588a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f3589b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f3590h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f3608k = -2;
        this.f3609l = -2;
        this.f3612o = PointerIconCompat.TYPE_HAND;
        this.f3614q = true;
        this.f3617t = 0;
        this.f3618u = false;
        this.f3619v = false;
        this.f3602d = Integer.MAX_VALUE;
        this.f3621x = 0;
        this.f3603e = new RunnableC0595e();
        this.f3594D = new ViewOnTouchListenerC0594d();
        this.f3595E = new C0593c();
        this.f3596F = new RunnableC0591a();
        this.f3598H = new Rect();
        this.f3606i = context;
        this.f3604f = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.f3610m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f3611n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f3611n != 0) {
            this.f3613p = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f3605g = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.f3605g.setInputMethodMode(1);
    }

    /* JADX INFO: renamed from: a */
    public void mo3506a(ListAdapter listAdapter) {
        if (this.f3622y == null) {
            this.f3622y = new C0592b();
        } else if (this.f3607j != null) {
            this.f3607j.unregisterDataSetObserver(this.f3622y);
        }
        this.f3607j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f3622y);
        }
        if (this.f3601c != null) {
            this.f3601c.setAdapter(this.f3607j);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3678a(int i) {
        this.f3621x = i;
    }

    /* JADX INFO: renamed from: a */
    public void m3683a(boolean z) {
        this.f3600J = z;
        this.f3605g.setFocusable(z);
    }

    /* JADX INFO: renamed from: c */
    public boolean m3688c() {
        return this.f3600J;
    }

    /* JADX INFO: renamed from: h */
    public Drawable m3696h() {
        return this.f3605g.getBackground();
    }

    /* JADX INFO: renamed from: a */
    public void m3680a(Drawable drawable) {
        this.f3605g.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: renamed from: b */
    public void m3684b(int i) {
        this.f3605g.setAnimationStyle(i);
    }

    /* JADX INFO: renamed from: i */
    public View m3698i() {
        return this.f3623z;
    }

    /* JADX INFO: renamed from: b */
    public void m3685b(View view) {
        this.f3623z = view;
    }

    /* JADX INFO: renamed from: j */
    public int m3700j() {
        return this.f3610m;
    }

    /* JADX INFO: renamed from: c */
    public void m3687c(int i) {
        this.f3610m = i;
    }

    /* JADX INFO: renamed from: k */
    public int m3701k() {
        if (this.f3613p) {
            return this.f3611n;
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public void m3689d(int i) {
        this.f3611n = i;
        this.f3613p = true;
    }

    /* JADX INFO: renamed from: a */
    public void m3679a(Rect rect) {
        this.f3599I = rect;
    }

    /* JADX INFO: renamed from: e */
    public void m3691e(int i) {
        this.f3617t = i;
    }

    /* JADX INFO: renamed from: l */
    public int m3702l() {
        return this.f3609l;
    }

    /* JADX INFO: renamed from: f */
    public void m3692f(int i) {
        this.f3609l = i;
    }

    /* JADX INFO: renamed from: g */
    public void m3695g(int i) {
        Drawable background = this.f3605g.getBackground();
        if (background != null) {
            background.getPadding(this.f3598H);
            this.f3609l = this.f3598H.left + this.f3598H.right + i;
        } else {
            m3692f(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3681a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f3592B = onItemClickListener;
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: d */
    public void mo3510d() {
        int width;
        int width2;
        int iM3675b = m3675b();
        boolean zM3704n = m3704n();
        PopupWindowCompat.setWindowLayoutType(this.f3605g, this.f3612o);
        if (this.f3605g.isShowing()) {
            if (ViewCompat.isAttachedToWindow(m3698i())) {
                if (this.f3609l == -1) {
                    width2 = -1;
                } else if (this.f3609l == -2) {
                    width2 = m3698i().getWidth();
                } else {
                    width2 = this.f3609l;
                }
                if (this.f3608k == -1) {
                    if (!zM3704n) {
                        iM3675b = -1;
                    }
                    if (zM3704n) {
                        this.f3605g.setWidth(this.f3609l == -1 ? -1 : 0);
                        this.f3605g.setHeight(0);
                    } else {
                        this.f3605g.setWidth(this.f3609l == -1 ? -1 : 0);
                        this.f3605g.setHeight(-1);
                    }
                } else if (this.f3608k != -2) {
                    iM3675b = this.f3608k;
                }
                this.f3605g.setOutsideTouchable((this.f3619v || this.f3618u) ? false : true);
                this.f3605g.update(m3698i(), this.f3610m, this.f3611n, width2 < 0 ? -1 : width2, iM3675b < 0 ? -1 : iM3675b);
                return;
            }
            return;
        }
        if (this.f3609l == -1) {
            width = -1;
        } else if (this.f3609l == -2) {
            width = m3698i().getWidth();
        } else {
            width = this.f3609l;
        }
        if (this.f3608k == -1) {
            iM3675b = -1;
        } else if (this.f3608k != -2) {
            iM3675b = this.f3608k;
        }
        this.f3605g.setWidth(width);
        this.f3605g.setHeight(iM3675b);
        m3676c(true);
        this.f3605g.setOutsideTouchable((this.f3619v || this.f3618u) ? false : true);
        this.f3605g.setTouchInterceptor(this.f3594D);
        if (this.f3616s) {
            PopupWindowCompat.setOverlapAnchor(this.f3605g, this.f3615r);
        }
        if (f3590h != null) {
            try {
                f3590h.invoke(this.f3605g, this.f3599I);
            } catch (Exception e) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
            }
        }
        PopupWindowCompat.showAsDropDown(this.f3605g, m3698i(), this.f3610m, this.f3611n, this.f3617t);
        this.f3601c.setSelection(-1);
        if (!this.f3600J || this.f3601c.isInTouchMode()) {
            m3703m();
        }
        if (this.f3600J) {
            return;
        }
        this.f3604f.post(this.f3596F);
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: e */
    public void mo3690e() {
        this.f3605g.dismiss();
        m3674a();
        this.f3605g.setContentView(null);
        this.f3601c = null;
        this.f3604f.removeCallbacks(this.f3603e);
    }

    /* JADX INFO: renamed from: a */
    public void m3682a(PopupWindow.OnDismissListener onDismissListener) {
        this.f3605g.setOnDismissListener(onDismissListener);
    }

    /* JADX INFO: renamed from: a */
    private void m3674a() {
        if (this.f3620w != null) {
            ViewParent parent = this.f3620w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f3620w);
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public void m3697h(int i) {
        this.f3605g.setInputMethodMode(i);
    }

    /* JADX INFO: renamed from: i */
    public void m3699i(int i) {
        C1744gi c1744gi = this.f3601c;
        if (!mo3693f() || c1744gi == null) {
            return;
        }
        c1744gi.setListSelectionHidden(false);
        c1744gi.setSelection(i);
        if (c1744gi.getChoiceMode() != 0) {
            c1744gi.setItemChecked(i, true);
        }
    }

    /* JADX INFO: renamed from: m */
    public void m3703m() {
        C1744gi c1744gi = this.f3601c;
        if (c1744gi != null) {
            c1744gi.setListSelectionHidden(true);
            c1744gi.requestLayout();
        }
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: f */
    public boolean mo3693f() {
        return this.f3605g.isShowing();
    }

    /* JADX INFO: renamed from: n */
    public boolean m3704n() {
        return this.f3605g.getInputMethodMode() == 2;
    }

    @Override // p000.InterfaceC1718fj
    /* JADX INFO: renamed from: g */
    public ListView mo3694g() {
        return this.f3601c;
    }

    /* JADX INFO: renamed from: a */
    C1744gi mo3677a(Context context, boolean z) {
        return new C1744gi(context, z);
    }

    /* JADX INFO: renamed from: b */
    private int m3675b() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        View view;
        int i2;
        int i3;
        if (this.f3601c == null) {
            Context context = this.f3606i;
            this.f3597G = new Runnable() { // from class: android.support.v7.widget.ListPopupWindow.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewM3698i = ListPopupWindow.this.m3698i();
                    if (viewM3698i == null || viewM3698i.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.mo3510d();
                }
            };
            this.f3601c = mo3677a(context, !this.f3600J);
            if (this.f3591A != null) {
                this.f3601c.setSelector(this.f3591A);
            }
            this.f3601c.setAdapter(this.f3607j);
            this.f3601c.setOnItemClickListener(this.f3592B);
            this.f3601c.setFocusable(true);
            this.f3601c.setFocusableInTouchMode(true);
            this.f3601c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ListPopupWindow.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i4, long j) {
                    C1744gi c1744gi;
                    if (i4 == -1 || (c1744gi = ListPopupWindow.this.f3601c) == null) {
                        return;
                    }
                    c1744gi.setListSelectionHidden(false);
                }
            });
            this.f3601c.setOnScrollListener(this.f3595E);
            if (this.f3593C != null) {
                this.f3601c.setOnItemSelectedListener(this.f3593C);
            }
            C1744gi c1744gi = this.f3601c;
            View view2 = this.f3620w;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.f3621x) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(c1744gi, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(c1744gi, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f3621x);
                        break;
                }
                if (this.f3609l >= 0) {
                    i2 = this.f3609l;
                    i3 = ExploreByTouchHelper.INVALID_ID;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i2, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = c1744gi;
            }
            this.f3605g.setContentView(view);
        } else {
            View view3 = this.f3620w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f3605g.getBackground();
        if (background != null) {
            background.getPadding(this.f3598H);
            i = this.f3598H.top + this.f3598H.bottom;
            if (!this.f3613p) {
                this.f3611n = -this.f3598H.top;
            }
        } else {
            this.f3598H.setEmpty();
            i = 0;
        }
        int iM3673a = m3673a(m3698i(), this.f3611n, this.f3605g.getInputMethodMode() == 2);
        if (this.f3618u || this.f3608k == -1) {
            return iM3673a + i;
        }
        switch (this.f3609l) {
            case -2:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f3606i.getResources().getDisplayMetrics().widthPixels - (this.f3598H.left + this.f3598H.right), ExploreByTouchHelper.INVALID_ID);
                break;
            case -1:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f3606i.getResources().getDisplayMetrics().widthPixels - (this.f3598H.left + this.f3598H.right), 1073741824);
                break;
            default:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f3609l, 1073741824);
                break;
        }
        int iMo3711a = this.f3601c.mo3711a(iMakeMeasureSpec, 0, -1, iM3673a - measuredHeight, -1);
        if (iMo3711a > 0) {
            measuredHeight += i + this.f3601c.getPaddingTop() + this.f3601c.getPaddingBottom();
        }
        return iMo3711a + measuredHeight;
    }

    /* JADX INFO: renamed from: b */
    public void m3686b(boolean z) {
        this.f3616s = true;
        this.f3615r = z;
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ListPopupWindow$b */
    class C0592b extends DataSetObserver {
        C0592b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.mo3693f()) {
                ListPopupWindow.this.mo3510d();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.mo3690e();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ListPopupWindow$a */
    class RunnableC0591a implements Runnable {
        RunnableC0591a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.m3703m();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ListPopupWindow$e */
    class RunnableC0595e implements Runnable {
        RunnableC0595e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ListPopupWindow.this.f3601c == null || !ViewCompat.isAttachedToWindow(ListPopupWindow.this.f3601c) || ListPopupWindow.this.f3601c.getCount() <= ListPopupWindow.this.f3601c.getChildCount() || ListPopupWindow.this.f3601c.getChildCount() > ListPopupWindow.this.f3602d) {
                return;
            }
            ListPopupWindow.this.f3605g.setInputMethodMode(2);
            ListPopupWindow.this.mo3510d();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ListPopupWindow$d */
    class ViewOnTouchListenerC0594d implements View.OnTouchListener {
        ViewOnTouchListenerC0594d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.f3605g != null && ListPopupWindow.this.f3605g.isShowing() && x >= 0 && x < ListPopupWindow.this.f3605g.getWidth() && y >= 0 && y < ListPopupWindow.this.f3605g.getHeight()) {
                ListPopupWindow.this.f3604f.postDelayed(ListPopupWindow.this.f3603e, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow.this.f3604f.removeCallbacks(ListPopupWindow.this.f3603e);
            return false;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ListPopupWindow$c */
    class C0593c implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        C0593c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.m3704n() || ListPopupWindow.this.f3605g.getContentView() == null) {
                return;
            }
            ListPopupWindow.this.f3604f.removeCallbacks(ListPopupWindow.this.f3603e);
            ListPopupWindow.this.f3603e.run();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3676c(boolean z) {
        if (f3588a != null) {
            try {
                f3588a.invoke(this.f3605g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m3673a(View view, int i, boolean z) {
        if (f3589b != null) {
            try {
                return ((Integer) f3589b.invoke(this.f3605g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f3605g.getMaxAvailableHeight(view, i);
    }
}
