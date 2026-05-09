package p000;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AbstractC0624v;
import android.view.View;

/* JADX INFO: renamed from: js */
/* JADX INFO: compiled from: CommonAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1835js<T extends RecyclerView.AbstractC0624v> extends RecyclerView.AbstractC0603a<T> {

    /* JADX INFO: renamed from: a */
    private b f10798a = null;

    /* JADX INFO: renamed from: c */
    protected final Context f10799c;

    /* JADX INFO: renamed from: d */
    protected final int f10800d;

    /* JADX INFO: renamed from: e */
    protected int f10801e;

    /* JADX INFO: renamed from: js$b */
    /* JADX INFO: compiled from: CommonAdapter.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void m10013a(View view, int i);
    }

    public AbstractC1835js(Context context, int i, int i2) {
        this.f10799c = context;
        this.f10800d = i;
        this.f10801e = i2;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a */
    public void mo3867a(T t, int i) {
        t.f3823a.setOnClickListener(new a(i, this.f10798a));
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a */
    public int mo3863a() {
        return this.f10801e;
    }

    /* JADX INFO: renamed from: js$a */
    /* JADX INFO: compiled from: CommonAdapter.java */
    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        final int f10802a;

        /* JADX INFO: renamed from: b */
        final b f10803b;

        public a(int i, b bVar) {
            this.f10802a = i;
            this.f10803b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10803b != null) {
                this.f10803b.m10013a(view, this.f10802a);
            }
        }
    }
}
