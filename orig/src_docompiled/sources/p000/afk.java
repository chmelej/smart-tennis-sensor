package p000;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldMetaData.java */
/* JADX INFO: loaded from: classes.dex */
public class afk implements Serializable {

    /* JADX INFO: renamed from: d */
    private static Map<Class<? extends aff>, Map<? extends Object, afk>> f760d = new HashMap();

    /* JADX INFO: renamed from: a */
    public final String f761a;

    /* JADX INFO: renamed from: b */
    public final byte f762b;

    /* JADX INFO: renamed from: c */
    public final afl f763c;

    public afk(String str, byte b, afl aflVar) {
        this.f761a = str;
        this.f762b = b;
        this.f763c = aflVar;
    }

    /* JADX INFO: renamed from: a */
    public static void m843a(Class<? extends aff> cls, Map<? extends Object, afk> map) {
        f760d.put(cls, map);
    }
}
