package p000;

import java.util.Comparator;

/* JADX INFO: renamed from: sj */
/* JADX INFO: compiled from: MemoryCacheUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2107sj {
    /* JADX INFO: renamed from: a */
    public static String m11528a(String str, C2079ri c2079ri) {
        return str + "_" + c2079ri.m11433a() + "x" + c2079ri.m11436b();
    }

    /* JADX INFO: renamed from: a */
    public static Comparator<String> m11529a() {
        return new Comparator<String>() { // from class: sj.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
            }
        };
    }
}
