package p000;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: qu */
/* JADX INFO: compiled from: LruMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C2064qu implements InterfaceC2061qr {

    /* JADX INFO: renamed from: a */
    private final LinkedHashMap<String, Bitmap> f12398a;

    /* JADX INFO: renamed from: b */
    private final int f12399b;

    /* JADX INFO: renamed from: c */
    private int f12400c;

    public C2064qu(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f12399b = i;
        this.f12398a = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // p000.InterfaceC2062qs
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Bitmap mo11264a(String str) {
        Bitmap bitmap;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            bitmap = this.f12398a.get(str);
        }
        return bitmap;
    }

    @Override // p000.InterfaceC2062qs
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final boolean mo11266a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f12400c += m11269b(str, bitmap);
            Bitmap bitmapPut = this.f12398a.put(str, bitmap);
            if (bitmapPut != null) {
                this.f12400c -= m11269b(str, bitmapPut);
            }
        }
        m11268a(this.f12399b);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m11268a(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f12400c     // Catch: java.lang.Throwable -> L70
            if (r0 < 0) goto L51
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f12398a     // Catch: java.lang.Throwable -> L70
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L12
            int r0 = r3.f12400c     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L12
            goto L51
        L12:
            int r0 = r3.f12400c     // Catch: java.lang.Throwable -> L70
            if (r0 <= r4) goto L4f
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f12398a     // Catch: java.lang.Throwable -> L70
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L1f
            goto L4f
        L1f:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f12398a     // Catch: java.lang.Throwable -> L70
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L70
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L70
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L70
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L70
            if (r0 != 0) goto L33
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L70
            goto L50
        L33:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L70
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L70
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L70
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L70
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f12398a     // Catch: java.lang.Throwable -> L70
            r2.remove(r1)     // Catch: java.lang.Throwable -> L70
            int r2 = r3.f12400c     // Catch: java.lang.Throwable -> L70
            int r0 = r3.m11269b(r1, r0)     // Catch: java.lang.Throwable -> L70
            int r2 = r2 - r0
            r3.f12400c = r2     // Catch: java.lang.Throwable -> L70
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L70
            goto L0
        L4f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L70
        L50:
            return
        L51:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L70
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r0.<init>()     // Catch: java.lang.Throwable -> L70
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L70
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L70
            r0.append(r1)     // Catch: java.lang.Throwable -> L70
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L70
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L70
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L70
            throw r4     // Catch: java.lang.Throwable -> L70
        L70:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L70
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2064qu.m11268a(int):void");
    }

    @Override // p000.InterfaceC2062qs
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Bitmap mo11267b(String str) {
        Bitmap bitmapRemove;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            bitmapRemove = this.f12398a.remove(str);
            if (bitmapRemove != null) {
                this.f12400c -= m11269b(str, bitmapRemove);
            }
        }
        return bitmapRemove;
    }

    @Override // p000.InterfaceC2062qs
    /* JADX INFO: renamed from: a */
    public Collection<String> mo11265a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f12398a.keySet());
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: b */
    private int m11269b(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f12399b));
    }
}
