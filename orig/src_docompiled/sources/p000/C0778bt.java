package p000;

import android.support.v4.view.ViewCompat;
import android.view.View;

/* JADX INFO: renamed from: bt */
/* JADX INFO: compiled from: ViewOffsetHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0778bt {

    /* JADX INFO: renamed from: a */
    private final View f5298a;

    /* JADX INFO: renamed from: b */
    private int f5299b;

    /* JADX INFO: renamed from: c */
    private int f5300c;

    /* JADX INFO: renamed from: d */
    private int f5301d;

    /* JADX INFO: renamed from: e */
    private int f5302e;

    public C0778bt(View view) {
        this.f5298a = view;
    }

    /* JADX INFO: renamed from: a */
    public void m5708a() {
        this.f5299b = this.f5298a.getTop();
        this.f5300c = this.f5298a.getLeft();
        m5707d();
    }

    /* JADX INFO: renamed from: d */
    private void m5707d() {
        ViewCompat.offsetTopAndBottom(this.f5298a, this.f5301d - (this.f5298a.getTop() - this.f5299b));
        ViewCompat.offsetLeftAndRight(this.f5298a, this.f5302e - (this.f5298a.getLeft() - this.f5300c));
    }

    /* JADX INFO: renamed from: a */
    public boolean m5709a(int i) {
        if (this.f5301d == i) {
            return false;
        }
        this.f5301d = i;
        m5707d();
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m5711b(int i) {
        if (this.f5302e == i) {
            return false;
        }
        this.f5302e = i;
        m5707d();
        return true;
    }

    /* JADX INFO: renamed from: b */
    public int m5710b() {
        return this.f5301d;
    }

    /* JADX INFO: renamed from: c */
    public int m5712c() {
        return this.f5299b;
    }
}
