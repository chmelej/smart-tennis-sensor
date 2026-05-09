package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: renamed from: vt */
/* JADX INFO: compiled from: Draft.java */
/* JADX INFO: loaded from: classes.dex */
public class C2198vt {

    /* JADX INFO: renamed from: a */
    private String f13195a;

    /* JADX INFO: renamed from: b */
    private List<C2184vf> f13196b;

    /* JADX INFO: renamed from: c */
    private C2155ud f13197c;

    /* JADX INFO: renamed from: d */
    private C2161uj f13198d;

    /* JADX INFO: renamed from: e */
    private C2169ur f13199e;

    /* JADX INFO: renamed from: f */
    private C2150tz f13200f;

    /* JADX INFO: renamed from: g */
    private C2158ug f13201g;

    /* JADX INFO: renamed from: h */
    private C2162uk f13202h;

    public C2198vt() {
        this(null);
    }

    public C2198vt(String str) {
        this.f13195a = str;
        this.f13196b = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    public String m12022a() {
        return this.f13195a;
    }

    /* JADX INFO: renamed from: b */
    public Stack<C2184vf> m12031b() {
        Stack<C2184vf> stack = new Stack<>();
        Iterator<C2184vf> it = this.f13196b.iterator();
        while (it.hasNext()) {
            stack.push(it.next());
        }
        return stack;
    }

    /* JADX INFO: renamed from: a */
    public void m12023a(String str) {
        this.f13195a = str;
    }

    /* JADX INFO: renamed from: a */
    public void m12024a(Stack<C2184vf> stack) {
        this.f13196b.clear();
        this.f13196b.addAll(stack);
    }

    /* JADX INFO: renamed from: a */
    public void m12026a(C2155ud c2155ud) {
        this.f13197c = c2155ud;
    }

    /* JADX INFO: renamed from: a */
    public void m12028a(C2161uj c2161uj) {
        this.f13198d = c2161uj;
    }

    /* JADX INFO: renamed from: a */
    public void m12030a(C2169ur c2169ur) {
        this.f13199e = c2169ur;
    }

    /* JADX INFO: renamed from: a */
    public void m12025a(C2150tz c2150tz) {
        this.f13200f = c2150tz;
    }

    /* JADX INFO: renamed from: a */
    public void m12027a(C2158ug c2158ug) {
        this.f13201g = c2158ug;
    }

    /* JADX INFO: renamed from: a */
    public void m12029a(C2162uk c2162uk) {
        this.f13202h = c2162uk;
    }
}
