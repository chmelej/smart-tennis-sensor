package p000;

import android.support.v4.widget.ExploreByTouchHelper;

/* JADX INFO: renamed from: gu */
/* JADX INFO: compiled from: RtlSpacingHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1756gu {

    /* JADX INFO: renamed from: a */
    private int f10089a = 0;

    /* JADX INFO: renamed from: b */
    private int f10090b = 0;

    /* JADX INFO: renamed from: c */
    private int f10091c = ExploreByTouchHelper.INVALID_ID;

    /* JADX INFO: renamed from: d */
    private int f10092d = ExploreByTouchHelper.INVALID_ID;

    /* JADX INFO: renamed from: e */
    private int f10093e = 0;

    /* JADX INFO: renamed from: f */
    private int f10094f = 0;

    /* JADX INFO: renamed from: g */
    private boolean f10095g = false;

    /* JADX INFO: renamed from: h */
    private boolean f10096h = false;

    /* JADX INFO: renamed from: a */
    public int m9541a() {
        return this.f10089a;
    }

    /* JADX INFO: renamed from: b */
    public int m9544b() {
        return this.f10090b;
    }

    /* JADX INFO: renamed from: c */
    public int m9546c() {
        return this.f10095g ? this.f10090b : this.f10089a;
    }

    /* JADX INFO: renamed from: d */
    public int m9547d() {
        return this.f10095g ? this.f10089a : this.f10090b;
    }

    /* JADX INFO: renamed from: a */
    public void m9542a(int i, int i2) {
        this.f10091c = i;
        this.f10092d = i2;
        this.f10096h = true;
        if (this.f10095g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f10089a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f10090b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f10089a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f10090b = i2;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m9545b(int i, int i2) {
        this.f10096h = false;
        if (i != Integer.MIN_VALUE) {
            this.f10093e = i;
            this.f10089a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f10094f = i2;
            this.f10090b = i2;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9543a(boolean z) {
        if (z == this.f10095g) {
            return;
        }
        this.f10095g = z;
        if (!this.f10096h) {
            this.f10089a = this.f10093e;
            this.f10090b = this.f10094f;
        } else if (z) {
            this.f10089a = this.f10092d != Integer.MIN_VALUE ? this.f10092d : this.f10093e;
            this.f10090b = this.f10091c != Integer.MIN_VALUE ? this.f10091c : this.f10094f;
        } else {
            this.f10089a = this.f10091c != Integer.MIN_VALUE ? this.f10091c : this.f10093e;
            this.f10090b = this.f10092d != Integer.MIN_VALUE ? this.f10092d : this.f10094f;
        }
    }
}
