package p000;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: xn */
/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C2246xn implements InterfaceC2237xe {

    /* JADX INFO: renamed from: b */
    final LinkedHashMap<String, Bitmap> f13523b;

    /* JADX INFO: renamed from: c */
    private final int f13524c;

    /* JADX INFO: renamed from: d */
    private int f13525d;

    /* JADX INFO: renamed from: e */
    private int f13526e;

    /* JADX INFO: renamed from: f */
    private int f13527f;

    /* JADX INFO: renamed from: g */
    private int f13528g;

    /* JADX INFO: renamed from: h */
    private int f13529h;

    public C2246xn(Context context) {
        this(C2265yf.m12400c(context));
    }

    public C2246xn(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f13524c = i;
        this.f13523b = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // p000.InterfaceC2237xe
    /* JADX INFO: renamed from: a */
    public Bitmap mo12251a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = this.f13523b.get(str);
            if (bitmap != null) {
                this.f13528g++;
                return bitmap;
            }
            this.f13529h++;
            return null;
        }
    }

    @Override // p000.InterfaceC2237xe
    /* JADX INFO: renamed from: a */
    public void mo12252a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f13526e++;
            this.f13525d += C2265yf.m12380a(bitmap);
            Bitmap bitmapPut = this.f13523b.put(str, bitmap);
            if (bitmapPut != null) {
                this.f13525d -= C2265yf.m12380a(bitmapPut);
            }
        }
        m12289a(this.f13524c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m12289a(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f13525d     // Catch: java.lang.Throwable -> L72
            if (r0 < 0) goto L53
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f13523b     // Catch: java.lang.Throwable -> L72
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L12
            int r0 = r3.f13525d     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L12
            goto L53
        L12:
            int r0 = r3.f13525d     // Catch: java.lang.Throwable -> L72
            if (r0 <= r4) goto L51
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f13523b     // Catch: java.lang.Throwable -> L72
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L1f
            goto L51
        L1f:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f13523b     // Catch: java.lang.Throwable -> L72
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L72
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L72
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L72
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L72
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L72
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L72
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L72
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L72
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f13523b     // Catch: java.lang.Throwable -> L72
            r2.remove(r1)     // Catch: java.lang.Throwable -> L72
            int r1 = r3.f13525d     // Catch: java.lang.Throwable -> L72
            int r0 = p000.C2265yf.m12380a(r0)     // Catch: java.lang.Throwable -> L72
            int r1 = r1 - r0
            r3.f13525d = r1     // Catch: java.lang.Throwable -> L72
            int r0 = r3.f13527f     // Catch: java.lang.Throwable -> L72
            int r0 = r0 + 1
            r3.f13527f = r0     // Catch: java.lang.Throwable -> L72
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L72
            goto L0
        L51:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L72
            return
        L53:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L72
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72
            r0.<init>()     // Catch: java.lang.Throwable -> L72
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L72
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L72
            r0.append(r1)     // Catch: java.lang.Throwable -> L72
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L72
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L72
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L72
            throw r4     // Catch: java.lang.Throwable -> L72
        L72:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L72
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2246xn.m12289a(int):void");
    }

    @Override // p000.InterfaceC2237xe
    /* JADX INFO: renamed from: a */
    public final synchronized int mo12250a() {
        return this.f13525d;
    }

    @Override // p000.InterfaceC2237xe
    /* JADX INFO: renamed from: b */
    public final synchronized int mo12253b() {
        return this.f13524c;
    }
}
