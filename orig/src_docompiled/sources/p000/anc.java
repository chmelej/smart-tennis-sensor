package p000;

import java.io.IOException;

/* JADX INFO: compiled from: Protocol.java */
/* JADX INFO: loaded from: classes.dex */
public enum anc {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* JADX INFO: renamed from: g */
    private final String f2010g;

    anc(String str) {
        this.f2010g = str;
    }

    /* JADX INFO: renamed from: a */
    public static anc m2173a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f2010g)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f2010g)) {
            return HTTP_1_1;
        }
        if (str.equals(H2_PRIOR_KNOWLEDGE.f2010g)) {
            return H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals(HTTP_2.f2010g)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f2010g)) {
            return SPDY_3;
        }
        if (str.equals(QUIC.f2010g)) {
            return QUIC;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f2010g;
    }
}
