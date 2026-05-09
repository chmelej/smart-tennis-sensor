package p000;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import p000.C0185al;

/* JADX INFO: renamed from: am */
/* JADX INFO: compiled from: CircularRevealWidget.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0194am extends C0185al.a {
    /* JADX INFO: renamed from: a */
    void mo1912a();

    /* JADX INFO: renamed from: b */
    void mo1913b();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(d dVar);

    /* JADX INFO: renamed from: am$d */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class d {

        /* JADX INFO: renamed from: a */
        public float f1694a;

        /* JADX INFO: renamed from: b */
        public float f1695b;

        /* JADX INFO: renamed from: c */
        public float f1696c;

        private d() {
        }

        public d(float f, float f2, float f3) {
            this.f1694a = f;
            this.f1695b = f2;
            this.f1696c = f3;
        }

        public d(d dVar) {
            this(dVar.f1694a, dVar.f1695b, dVar.f1696c);
        }

        /* JADX INFO: renamed from: a */
        public void m1919a(float f, float f2, float f3) {
            this.f1694a = f;
            this.f1695b = f2;
            this.f1696c = f3;
        }

        /* JADX INFO: renamed from: a */
        public void m1920a(d dVar) {
            m1919a(dVar.f1694a, dVar.f1695b, dVar.f1696c);
        }

        /* JADX INFO: renamed from: a */
        public boolean m1921a() {
            return this.f1696c == Float.MAX_VALUE;
        }
    }

    /* JADX INFO: renamed from: am$b */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class b extends Property<InterfaceC0194am, d> {

        /* JADX INFO: renamed from: a */
        public static final Property<InterfaceC0194am, d> f1692a = new b("circularReveal");

        private b(String str) {
            super(d.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d get(InterfaceC0194am interfaceC0194am) {
            return interfaceC0194am.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(InterfaceC0194am interfaceC0194am, d dVar) {
            interfaceC0194am.setRevealInfo(dVar);
        }
    }

    /* JADX INFO: renamed from: am$a */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class a implements TypeEvaluator<d> {

        /* JADX INFO: renamed from: a */
        public static final TypeEvaluator<d> f1690a = new a();

        /* JADX INFO: renamed from: b */
        private final d f1691b = new d();

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d evaluate(float f, d dVar, d dVar2) {
            this.f1691b.m1919a(C0773bo.m5670a(dVar.f1694a, dVar2.f1694a, f), C0773bo.m5670a(dVar.f1695b, dVar2.f1695b, f), C0773bo.m5670a(dVar.f1696c, dVar2.f1696c, f));
            return this.f1691b;
        }
    }

    /* JADX INFO: renamed from: am$c */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class c extends Property<InterfaceC0194am, Integer> {

        /* JADX INFO: renamed from: a */
        public static final Property<InterfaceC0194am, Integer> f1693a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(InterfaceC0194am interfaceC0194am) {
            return Integer.valueOf(interfaceC0194am.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(InterfaceC0194am interfaceC0194am, Integer num) {
            interfaceC0194am.setCircularRevealScrimColor(num.intValue());
        }
    }
}
