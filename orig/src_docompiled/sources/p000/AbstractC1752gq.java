package p000;

import android.graphics.Rect;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: renamed from: gq */
/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1752gq {

    /* JADX INFO: renamed from: a */
    protected final RecyclerView.AbstractC0611i f10056a;

    /* JADX INFO: renamed from: b */
    final Rect f10057b;

    /* JADX INFO: renamed from: c */
    private int f10058c;

    /* JADX INFO: renamed from: a */
    public abstract int mo9496a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo9498a(int i);

    /* JADX INFO: renamed from: b */
    public abstract int mo9500b(View view);

    /* JADX INFO: renamed from: c */
    public abstract int mo9501c();

    /* JADX INFO: renamed from: c */
    public abstract int mo9502c(View view);

    /* JADX INFO: renamed from: d */
    public abstract int mo9503d();

    /* JADX INFO: renamed from: d */
    public abstract int mo9504d(View view);

    /* JADX INFO: renamed from: e */
    public abstract int mo9505e();

    /* JADX INFO: renamed from: e */
    public abstract int mo9506e(View view);

    /* JADX INFO: renamed from: f */
    public abstract int mo9507f();

    /* JADX INFO: renamed from: f */
    public abstract int mo9508f(View view);

    /* JADX INFO: renamed from: g */
    public abstract int mo9509g();

    /* JADX INFO: renamed from: h */
    public abstract int mo9510h();

    /* JADX INFO: renamed from: i */
    public abstract int mo9511i();

    private AbstractC1752gq(RecyclerView.AbstractC0611i abstractC0611i) {
        this.f10058c = ExploreByTouchHelper.INVALID_ID;
        this.f10057b = new Rect();
        this.f10056a = abstractC0611i;
    }

    /* JADX INFO: renamed from: a */
    public void m9497a() {
        this.f10058c = mo9507f();
    }

    /* JADX INFO: renamed from: b */
    public int m9499b() {
        if (Integer.MIN_VALUE == this.f10058c) {
            return 0;
        }
        return mo9507f() - this.f10058c;
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC1752gq m9494a(RecyclerView.AbstractC0611i abstractC0611i, int i) {
        switch (i) {
            case 0:
                return m9493a(abstractC0611i);
            case 1:
                return m9495b(abstractC0611i);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC1752gq m9493a(RecyclerView.AbstractC0611i abstractC0611i) {
        return new AbstractC1752gq(abstractC0611i) { // from class: gq.1
            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: d */
            public int mo9503d() {
                return this.f10056a.m4015y() - this.f10056a.m3928C();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: e */
            public int mo9505e() {
                return this.f10056a.m4015y();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: a */
            public void mo9498a(int i) {
                this.f10056a.mo3997j(i);
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: c */
            public int mo9501c() {
                return this.f10056a.m3926A();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: e */
            public int mo9506e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f10056a.m3987f(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: f */
            public int mo9508f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f10056a.m3990g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: b */
            public int mo9500b(View view) {
                return this.f10056a.m3996j(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: a */
            public int mo9496a(View view) {
                return this.f10056a.m3992h(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: c */
            public int mo9502c(View view) {
                this.f10056a.m3952a(view, true, this.f10057b);
                return this.f10057b.right;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: d */
            public int mo9504d(View view) {
                this.f10056a.m3952a(view, true, this.f10057b);
                return this.f10057b.left;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: f */
            public int mo9507f() {
                return (this.f10056a.m4015y() - this.f10056a.m3926A()) - this.f10056a.m3928C();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: g */
            public int mo9509g() {
                return this.f10056a.m3928C();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: h */
            public int mo9510h() {
                return this.f10056a.m4013w();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: i */
            public int mo9511i() {
                return this.f10056a.m4014x();
            }
        };
    }

    /* JADX INFO: renamed from: b */
    public static AbstractC1752gq m9495b(RecyclerView.AbstractC0611i abstractC0611i) {
        return new AbstractC1752gq(abstractC0611i) { // from class: gq.2
            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: d */
            public int mo9503d() {
                return this.f10056a.m4016z() - this.f10056a.m3929D();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: e */
            public int mo9505e() {
                return this.f10056a.m4016z();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: a */
            public void mo9498a(int i) {
                this.f10056a.mo3999k(i);
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: c */
            public int mo9501c() {
                return this.f10056a.m3927B();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: e */
            public int mo9506e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f10056a.m3990g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: f */
            public int mo9508f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f10056a.m3987f(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: b */
            public int mo9500b(View view) {
                return this.f10056a.m3998k(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: a */
            public int mo9496a(View view) {
                return this.f10056a.m3994i(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: c */
            public int mo9502c(View view) {
                this.f10056a.m3952a(view, true, this.f10057b);
                return this.f10057b.bottom;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: d */
            public int mo9504d(View view) {
                this.f10056a.m3952a(view, true, this.f10057b);
                return this.f10057b.top;
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: f */
            public int mo9507f() {
                return (this.f10056a.m4016z() - this.f10056a.m3927B()) - this.f10056a.m3929D();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: g */
            public int mo9509g() {
                return this.f10056a.m3929D();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: h */
            public int mo9510h() {
                return this.f10056a.m4014x();
            }

            @Override // p000.AbstractC1752gq
            /* JADX INFO: renamed from: i */
            public int mo9511i() {
                return this.f10056a.m4013w();
            }
        };
    }
}
