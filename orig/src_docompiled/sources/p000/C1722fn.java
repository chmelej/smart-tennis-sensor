package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: fn */
/* JADX INFO: compiled from: ActivityChooserModel.java */
/* JADX INFO: loaded from: classes.dex */
public class C1722fn extends DataSetObservable {

    /* JADX INFO: renamed from: a */
    static final String f9807a = "fn";

    /* JADX INFO: renamed from: e */
    private static final Object f9808e = new Object();

    /* JADX INFO: renamed from: f */
    private static final Map<String, C1722fn> f9809f = new HashMap();

    /* JADX INFO: renamed from: b */
    final Context f9810b;

    /* JADX INFO: renamed from: c */
    final String f9811c;

    /* JADX INFO: renamed from: j */
    private Intent f9816j;

    /* JADX INFO: renamed from: p */
    private e f9822p;

    /* JADX INFO: renamed from: g */
    private final Object f9813g = new Object();

    /* JADX INFO: renamed from: h */
    private final List<a> f9814h = new ArrayList();

    /* JADX INFO: renamed from: i */
    private final List<d> f9815i = new ArrayList();

    /* JADX INFO: renamed from: k */
    private b f9817k = new c();

    /* JADX INFO: renamed from: l */
    private int f9818l = 50;

    /* JADX INFO: renamed from: d */
    boolean f9812d = true;

    /* JADX INFO: renamed from: m */
    private boolean f9819m = false;

    /* JADX INFO: renamed from: n */
    private boolean f9820n = true;

    /* JADX INFO: renamed from: o */
    private boolean f9821o = false;

    /* JADX INFO: renamed from: fn$b */
    /* JADX INFO: compiled from: ActivityChooserModel.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo9186a(Intent intent, List<a> list, List<d> list2);
    }

    /* JADX INFO: renamed from: fn$e */
    /* JADX INFO: compiled from: ActivityChooserModel.java */
    public interface e {
        /* JADX INFO: renamed from: a */
        boolean m9187a(C1722fn c1722fn, Intent intent);
    }

    /* JADX INFO: renamed from: a */
    public static C1722fn m9169a(Context context, String str) {
        C1722fn c1722fn;
        synchronized (f9808e) {
            c1722fn = f9809f.get(str);
            if (c1722fn == null) {
                c1722fn = new C1722fn(context, str);
                f9809f.put(str, c1722fn);
            }
        }
        return c1722fn;
    }

    private C1722fn(Context context, String str) {
        this.f9810b = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !str.endsWith(".xml")) {
            this.f9811c = str + ".xml";
            return;
        }
        this.f9811c = str;
    }

    /* JADX INFO: renamed from: a */
    public int m9178a() {
        int size;
        synchronized (this.f9813g) {
            m9172e();
            size = this.f9814h.size();
        }
        return size;
    }

    /* JADX INFO: renamed from: a */
    public ResolveInfo m9180a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f9813g) {
            m9172e();
            resolveInfo = this.f9814h.get(i).f9823a;
        }
        return resolveInfo;
    }

    /* JADX INFO: renamed from: a */
    public int m9179a(ResolveInfo resolveInfo) {
        synchronized (this.f9813g) {
            m9172e();
            List<a> list = this.f9814h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f9823a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public Intent m9181b(int i) {
        synchronized (this.f9813g) {
            if (this.f9816j == null) {
                return null;
            }
            m9172e();
            a aVar = this.f9814h.get(i);
            ComponentName componentName = new ComponentName(aVar.f9823a.activityInfo.packageName, aVar.f9823a.activityInfo.name);
            Intent intent = new Intent(this.f9816j);
            intent.setComponent(componentName);
            if (this.f9822p != null) {
                if (this.f9822p.m9187a(this, new Intent(intent))) {
                    return null;
                }
            }
            m9170a(new d(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* JADX INFO: renamed from: b */
    public ResolveInfo m9182b() {
        synchronized (this.f9813g) {
            m9172e();
            if (this.f9814h.isEmpty()) {
                return null;
            }
            return this.f9814h.get(0).f9823a;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m9184c(int i) {
        synchronized (this.f9813g) {
            m9172e();
            a aVar = this.f9814h.get(i);
            a aVar2 = this.f9814h.get(0);
            m9170a(new d(new ComponentName(aVar.f9823a.activityInfo.packageName, aVar.f9823a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f9824b - aVar.f9824b) + 5.0f : 1.0f));
        }
    }

    /* JADX INFO: renamed from: d */
    private void m9171d() {
        if (!this.f9819m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f9820n) {
            this.f9820n = false;
            if (TextUtils.isEmpty(this.f9811c)) {
                return;
            }
            new f().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f9815i), this.f9811c);
        }
    }

    /* JADX INFO: renamed from: c */
    public int m9183c() {
        int size;
        synchronized (this.f9813g) {
            m9172e();
            size = this.f9815i.size();
        }
        return size;
    }

    /* JADX INFO: renamed from: e */
    private void m9172e() {
        boolean zM9174g = m9174g() | m9175h();
        m9176i();
        if (zM9174g) {
            m9173f();
            notifyChanged();
        }
    }

    /* JADX INFO: renamed from: f */
    private boolean m9173f() {
        if (this.f9817k == null || this.f9816j == null || this.f9814h.isEmpty() || this.f9815i.isEmpty()) {
            return false;
        }
        this.f9817k.mo9186a(this.f9816j, this.f9814h, Collections.unmodifiableList(this.f9815i));
        return true;
    }

    /* JADX INFO: renamed from: g */
    private boolean m9174g() {
        if (!this.f9821o || this.f9816j == null) {
            return false;
        }
        this.f9821o = false;
        this.f9814h.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f9810b.getPackageManager().queryIntentActivities(this.f9816j, 0);
        int size = listQueryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f9814h.add(new a(listQueryIntentActivities.get(i)));
        }
        return true;
    }

    /* JADX INFO: renamed from: h */
    private boolean m9175h() {
        if (!this.f9812d || !this.f9820n || TextUtils.isEmpty(this.f9811c)) {
            return false;
        }
        this.f9812d = false;
        this.f9819m = true;
        m9177j();
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m9170a(d dVar) {
        boolean zAdd = this.f9815i.add(dVar);
        if (zAdd) {
            this.f9820n = true;
            m9176i();
            m9171d();
            m9173f();
            notifyChanged();
        }
        return zAdd;
    }

    /* JADX INFO: renamed from: i */
    private void m9176i() {
        int size = this.f9815i.size() - this.f9818l;
        if (size <= 0) {
            return;
        }
        this.f9820n = true;
        for (int i = 0; i < size; i++) {
            this.f9815i.remove(0);
        }
    }

    /* JADX INFO: renamed from: fn$d */
    /* JADX INFO: compiled from: ActivityChooserModel.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final ComponentName f9826a;

        /* JADX INFO: renamed from: b */
        public final long f9827b;

        /* JADX INFO: renamed from: c */
        public final float f9828c;

        public d(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public d(ComponentName componentName, long j, float f) {
            this.f9826a = componentName;
            this.f9827b = j;
            this.f9828c = f;
        }

        public int hashCode() {
            return (((((this.f9826a == null ? 0 : this.f9826a.hashCode()) + 31) * 31) + ((int) (this.f9827b ^ (this.f9827b >>> 32)))) * 31) + Float.floatToIntBits(this.f9828c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f9826a == null) {
                if (dVar.f9826a != null) {
                    return false;
                }
            } else if (!this.f9826a.equals(dVar.f9826a)) {
                return false;
            }
            return this.f9827b == dVar.f9827b && Float.floatToIntBits(this.f9828c) == Float.floatToIntBits(dVar.f9828c);
        }

        public String toString() {
            return "[; activity:" + this.f9826a + "; time:" + this.f9827b + "; weight:" + new BigDecimal(this.f9828c) + "]";
        }
    }

    /* JADX INFO: renamed from: fn$a */
    /* JADX INFO: compiled from: ActivityChooserModel.java */
    public static final class a implements Comparable<a> {

        /* JADX INFO: renamed from: a */
        public final ResolveInfo f9823a;

        /* JADX INFO: renamed from: b */
        public float f9824b;

        public a(ResolveInfo resolveInfo) {
            this.f9823a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f9824b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f9824b) == Float.floatToIntBits(((a) obj).f9824b);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f9824b) - Float.floatToIntBits(this.f9824b);
        }

        public String toString() {
            return "[resolveInfo:" + this.f9823a.toString() + "; weight:" + new BigDecimal(this.f9824b) + "]";
        }
    }

    /* JADX INFO: renamed from: fn$c */
    /* JADX INFO: compiled from: ActivityChooserModel.java */
    static final class c implements b {

        /* JADX INFO: renamed from: a */
        private final Map<ComponentName, a> f9825a = new HashMap();

        c() {
        }

        @Override // p000.C1722fn.b
        /* JADX INFO: renamed from: a */
        public void mo9186a(Intent intent, List<a> list, List<d> list2) {
            Map<ComponentName, a> map = this.f9825a;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a aVar = list.get(i);
                aVar.f9824b = 0.0f;
                map.put(new ComponentName(aVar.f9823a.activityInfo.packageName, aVar.f9823a.activityInfo.name), aVar);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                d dVar = list2.get(size2);
                a aVar2 = map.get(dVar.f9826a);
                if (aVar2 != null) {
                    aVar2.f9824b += dVar.f9828c * f;
                    f *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m9177j() {
        /*
            r9 = this;
            android.content.Context r0 = r9.f9810b     // Catch: java.io.FileNotFoundException -> Lc3
            java.lang.String r1 = r9.f9811c     // Catch: java.io.FileNotFoundException -> Lc3
            java.io.FileInputStream r0 = r0.openFileInput(r1)     // Catch: java.io.FileNotFoundException -> Lc3
            org.xmlpull.v1.XmlPullParser r1 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r2 = "UTF-8"
            r1.setInput(r0, r2)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            r2 = 0
        L12:
            r3 = 1
            if (r2 == r3) goto L1d
            r4 = 2
            if (r2 == r4) goto L1d
            int r2 = r1.next()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            goto L12
        L1d:
            java.lang.String r2 = "historical-records"
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            if (r2 != 0) goto L31
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r2 = "Share records file does not start with historical-records tag."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            throw r1     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
        L31:
            java.util.List<fn$d> r2 = r9.f9815i     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            r2.clear()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
        L36:
            int r4 = r1.next()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            if (r4 != r3) goto L43
            if (r0 == 0) goto Lbc
        L3e:
            r0.close()     // Catch: java.io.IOException -> Lbc
            goto Lbc
        L43:
            r5 = 3
            if (r4 == r5) goto L36
            r5 = 4
            if (r4 != r5) goto L4a
            goto L36
        L4a:
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r5 = "historical-record"
            boolean r4 = r5.equals(r4)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            if (r4 != 0) goto L5e
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r2 = "Share records file not well-formed."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            throw r1     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
        L5e:
            java.lang.String r4 = "activity"
            r5 = 0
            java.lang.String r4 = r1.getAttributeValue(r5, r4)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r6 = "time"
            java.lang.String r6 = r1.getAttributeValue(r5, r6)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            long r6 = java.lang.Long.parseLong(r6)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r8 = "weight"
            java.lang.String r5 = r1.getAttributeValue(r5, r8)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            float r5 = java.lang.Float.parseFloat(r5)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            fn$d r8 = new fn$d     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            r8.<init>(r4, r6, r5)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            r2.add(r8)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L84 org.xmlpull.v1.XmlPullParserException -> La0
            goto L36
        L82:
            r1 = move-exception
            goto Lbd
        L84:
            r1 = move-exception
            java.lang.String r2 = p000.C1722fn.f9807a     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r3.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "Error reading historical recrod file: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r9.f9811c     // Catch: java.lang.Throwable -> L82
            r3.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L82
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto Lbc
            goto L3e
        La0:
            r1 = move-exception
            java.lang.String r2 = p000.C1722fn.f9807a     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r3.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "Error reading historical recrod file: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r9.f9811c     // Catch: java.lang.Throwable -> L82
            r3.append(r4)     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L82
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto Lbc
            goto L3e
        Lbc:
            return
        Lbd:
            if (r0 == 0) goto Lc2
            r0.close()     // Catch: java.io.IOException -> Lc2
        Lc2:
            throw r1
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1722fn.m9177j():void");
    }

    /* JADX INFO: renamed from: fn$f */
    /* JADX INFO: compiled from: ActivityChooserModel.java */
    final class f extends AsyncTask<Object, Void, Void> {
        f() {
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Object... r12) {
            /*
                Method dump skipped, instruction units count: 256
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C1722fn.f.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }
}
