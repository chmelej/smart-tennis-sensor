package p000;

/* JADX INFO: compiled from: SourceLocationImpl.java */
/* JADX INFO: loaded from: classes.dex */
class arz implements arr {

    /* JADX INFO: renamed from: a */
    Class f4891a;

    /* JADX INFO: renamed from: b */
    String f4892b;

    /* JADX INFO: renamed from: c */
    int f4893c;

    arz(Class cls, String str, int i) {
        this.f4891a = cls;
        this.f4892b = str;
        this.f4893c = i;
    }

    /* JADX INFO: renamed from: a */
    public String m5309a() {
        return this.f4892b;
    }

    /* JADX INFO: renamed from: b */
    public int m5310b() {
        return this.f4893c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m5309a());
        stringBuffer.append(":");
        stringBuffer.append(m5310b());
        return stringBuffer.toString();
    }
}
