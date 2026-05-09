package me.maxwin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import me.maxwin.R;

/* JADX INFO: loaded from: classes.dex */
public class XListView extends ListView implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a */
    private float f11463a;

    /* JADX INFO: renamed from: b */
    private Scroller f11464b;

    /* JADX INFO: renamed from: c */
    private AbsListView.OnScrollListener f11465c;

    /* JADX INFO: renamed from: d */
    private InterfaceC1905a f11466d;

    /* JADX INFO: renamed from: e */
    private XListViewHeader f11467e;

    /* JADX INFO: renamed from: f */
    private RelativeLayout f11468f;

    /* JADX INFO: renamed from: g */
    private TextView f11469g;

    /* JADX INFO: renamed from: h */
    private boolean f11470h;

    /* JADX INFO: renamed from: i */
    private boolean f11471i;

    /* JADX INFO: renamed from: j */
    private XListViewFooter f11472j;

    /* JADX INFO: renamed from: k */
    private boolean f11473k;

    /* JADX INFO: renamed from: l */
    private boolean f11474l;

    /* JADX INFO: renamed from: m */
    private boolean f11475m;

    /* JADX INFO: renamed from: n */
    private int f11476n;

    /* JADX INFO: renamed from: o */
    private int f11477o;

    /* JADX INFO: renamed from: me.maxwin.view.XListView$a */
    public interface InterfaceC1905a {
        /* JADX INFO: renamed from: a */
        void mo10501a();

        /* JADX INFO: renamed from: b */
        void mo10502b();
    }

    /* JADX INFO: renamed from: me.maxwin.view.XListView$b */
    public interface InterfaceC1906b extends AbsListView.OnScrollListener {
        /* JADX INFO: renamed from: a */
        void m10512a(View view);
    }

    /* JADX INFO: renamed from: b */
    private void m10505b(float f) {
    }

    /* JADX INFO: renamed from: e */
    private void m10508e() {
    }

    public XListView(Context context) {
        super(context);
        this.f11463a = -1.0f;
        this.f11470h = true;
        this.f11471i = false;
        this.f11475m = false;
        m10504a(context);
    }

    public XListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11463a = -1.0f;
        this.f11470h = true;
        this.f11471i = false;
        this.f11475m = false;
        m10504a(context);
    }

    public XListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11463a = -1.0f;
        this.f11470h = true;
        this.f11471i = false;
        this.f11475m = false;
        m10504a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m10504a(Context context) {
        this.f11464b = new Scroller(context, new DecelerateInterpolator());
        super.setOnScrollListener(this);
        this.f11467e = new XListViewHeader(context);
        this.f11468f = (RelativeLayout) this.f11467e.findViewById(R.id.xlistview_header_content);
        this.f11469g = (TextView) this.f11467e.findViewById(R.id.xlistview_header_time);
        this.f11472j = new XListViewFooter(context);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (!this.f11475m) {
            this.f11475m = true;
        }
        super.setAdapter(listAdapter);
    }

    public int getcountfootview() {
        Log.e("TAG", "getFooterViewsCount: " + getFooterViewsCount());
        return getFooterViewsCount();
    }

    public void setPullRefreshEnable(boolean z) {
        this.f11470h = z;
        if (!this.f11470h) {
            this.f11468f.setVisibility(4);
        } else {
            this.f11468f.setVisibility(0);
        }
    }

    public void setPullLoadEnable(boolean z) {
        this.f11473k = z;
        if (!this.f11473k) {
            setFooterDividersEnabled(false);
        } else {
            this.f11474l = false;
            setFooterDividersEnabled(true);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10510a() {
        if (this.f11471i) {
            this.f11471i = false;
            m10507d();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10511b() {
        if (this.f11474l) {
            this.f11474l = false;
        }
    }

    public void setRefreshTime(String str) {
        this.f11469g.setText(str);
    }

    /* JADX INFO: renamed from: c */
    private void m10506c() {
        if (this.f11465c instanceof InterfaceC1906b) {
            ((InterfaceC1906b) this.f11465c).m10512a(this);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10503a(float f) {
        if (this.f11470h) {
            boolean z = this.f11471i;
        }
        setSelection(0);
    }

    /* JADX INFO: renamed from: d */
    private void m10507d() {
        invalidate();
    }

    /* JADX INFO: renamed from: f */
    private void m10509f() {
        this.f11474l = true;
        if (this.f11466d != null) {
            this.f11466d.mo10502b();
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11463a == -1.0f) {
            this.f11463a = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11463a = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.f11463a;
            this.f11463a = motionEvent.getRawY();
            if (getFirstVisiblePosition() == 0) {
                m10503a(rawY / 1.8f);
                m10506c();
            } else if (getLastVisiblePosition() == this.f11476n - 1) {
                m10505b((-rawY) / 1.8f);
            }
        } else {
            this.f11463a = -1.0f;
            if (getFirstVisiblePosition() == 0) {
                if (this.f11470h) {
                    this.f11471i = true;
                    if (this.f11466d != null) {
                        this.f11466d.mo10501a();
                    }
                }
                m10507d();
            } else if (getLastVisiblePosition() == this.f11476n - 1) {
                if (this.f11473k && !this.f11474l) {
                    m10509f();
                }
                m10508e();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f11464b.computeScrollOffset()) {
            int i = this.f11477o;
            postInvalidate();
            m10506c();
        }
        super.computeScroll();
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f11465c = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.f11465c != null) {
            this.f11465c.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f11476n = i3;
        if (this.f11465c != null) {
            this.f11465c.onScroll(absListView, i, i2, i3);
        }
    }

    public void setXListViewListener(InterfaceC1905a interfaceC1905a) {
        this.f11466d = interfaceC1905a;
    }
}
