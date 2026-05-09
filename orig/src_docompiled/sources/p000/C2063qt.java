package p000;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: renamed from: qt */
/* JADX INFO: compiled from: FuzzyKeyMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C2063qt implements InterfaceC2061qr {

    /* JADX INFO: renamed from: a */
    private final InterfaceC2061qr f12396a;

    /* JADX INFO: renamed from: b */
    private final Comparator<String> f12397b;

    public C2063qt(InterfaceC2061qr interfaceC2061qr, Comparator<String> comparator) {
        this.f12396a = interfaceC2061qr;
        this.f12397b = comparator;
    }

    @Override // p000.InterfaceC2062qs
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo11266a(String str, Bitmap bitmap) {
        synchronized (this.f12396a) {
            String str2 = null;
            Iterator<String> it = this.f12396a.mo11265a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.f12397b.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.f12396a.mo11267b(str2);
            }
        }
        return this.f12396a.mo11266a(str, bitmap);
    }

    @Override // p000.InterfaceC2062qs
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Bitmap mo11264a(String str) {
        return this.f12396a.mo11264a(str);
    }

    @Override // p000.InterfaceC2062qs
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Bitmap mo11267b(String str) {
        return this.f12396a.mo11267b(str);
    }

    @Override // p000.InterfaceC2062qs
    /* JADX INFO: renamed from: a */
    public Collection<String> mo11265a() {
        return this.f12396a.mo11265a();
    }
}
