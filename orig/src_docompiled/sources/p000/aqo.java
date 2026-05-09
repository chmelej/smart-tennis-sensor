package p000;

/* JADX INFO: compiled from: ChannelType.java */
/* JADX INFO: loaded from: classes.dex */
public enum aqo {
    CHUNKED(0, "chunked"),
    SPDY(1, "spdy");


    /* JADX INFO: renamed from: c */
    private int f4729c;

    /* JADX INFO: renamed from: d */
    private String f4730d;

    aqo(int i, String str) {
        this.f4729c = i;
        this.f4730d = str;
    }

    /* JADX INFO: renamed from: a */
    public String m5091a() {
        return this.f4730d;
    }

    /* JADX INFO: renamed from: b */
    public int m5092b() {
        return this.f4729c;
    }

    /* JADX INFO: renamed from: a */
    public static aqo m5090a(int i) {
        switch (i) {
            case 0:
                return CHUNKED;
            case 1:
                return SPDY;
            default:
                return CHUNKED;
        }
    }
}
