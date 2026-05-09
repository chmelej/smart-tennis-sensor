package p000;

import android.util.Log;
import android.view.View;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: TagAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class aka<T> {

    /* JADX INFO: renamed from: a */
    private List<T> f1422a;

    /* JADX INFO: renamed from: b */
    private InterfaceC0176a f1423b;

    /* JADX INFO: renamed from: c */
    @Deprecated
    private HashSet<Integer> f1424c = new HashSet<>();

    /* JADX INFO: renamed from: aka$a */
    /* JADX INFO: compiled from: TagAdapter.java */
    public interface InterfaceC0176a {
    }

    /* JADX INFO: renamed from: a */
    public abstract View mo1696a(FlowLayout flowLayout, int i, T t);

    /* JADX INFO: renamed from: a */
    public boolean m1701a(int i, T t) {
        return false;
    }

    @Deprecated
    public aka(T[] tArr) {
        this.f1422a = new ArrayList(Arrays.asList(tArr));
    }

    /* JADX INFO: renamed from: a */
    public void m1700a(InterfaceC0176a interfaceC0176a) {
        this.f1423b = interfaceC0176a;
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public HashSet<Integer> m1698a() {
        return this.f1424c;
    }

    /* JADX INFO: renamed from: b */
    public int m1702b() {
        if (this.f1422a == null) {
            return 0;
        }
        return this.f1422a.size();
    }

    /* JADX INFO: renamed from: a */
    public T m1697a(int i) {
        return this.f1422a.get(i);
    }

    /* JADX INFO: renamed from: a */
    public void m1699a(int i, View view) {
        Log.d("zhy", "onSelected " + i);
    }

    /* JADX INFO: renamed from: b */
    public void m1703b(int i, View view) {
        Log.d("zhy", "unSelected " + i);
    }
}
