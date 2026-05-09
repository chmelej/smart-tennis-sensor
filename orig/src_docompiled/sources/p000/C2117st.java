package p000;

import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import p000.InterfaceC2114sq;

/* JADX INFO: renamed from: st */
/* JADX INFO: compiled from: CountingRequestBody.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2117st extends anf {

    /* JADX INFO: renamed from: a */
    private final anf f12692a;

    /* JADX INFO: renamed from: b */
    private final InterfaceC2122sy f12693b;

    /* JADX INFO: renamed from: c */
    private final long f12694c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC2114sq f12695d;

    public C2117st(anf anfVar, InterfaceC2122sy interfaceC2122sy, long j, InterfaceC2114sq interfaceC2114sq) {
        this.f12692a = anfVar;
        this.f12693b = interfaceC2122sy;
        this.f12694c = j;
        this.f12695d = interfaceC2114sq;
    }

    @Override // p000.anf
    /* JADX INFO: renamed from: a */
    public long mo4445a() {
        return this.f12692a.mo4445a();
    }

    @Override // p000.anf
    /* JADX INFO: renamed from: b */
    public ana mo4447b() {
        return this.f12692a.mo4447b();
    }

    @Override // p000.anf
    /* JADX INFO: renamed from: a */
    public void mo4446a(BufferedSink bufferedSink) {
        BufferedSink bufferedSinkBuffer = Okio.buffer(new a(bufferedSink));
        this.f12692a.mo4446a(bufferedSinkBuffer);
        bufferedSinkBuffer.flush();
    }

    /* JADX INFO: renamed from: st$a */
    /* JADX INFO: compiled from: CountingRequestBody.java */
    public final class a extends ForwardingSink {

        /* JADX INFO: renamed from: b */
        private int f12697b;

        public a(Sink sink) {
            super(sink);
            this.f12697b = 0;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws InterfaceC2114sq.a {
            if (C2117st.this.f12695d != null || C2117st.this.f12693b != null) {
                if (C2117st.this.f12695d != null && C2117st.this.f12695d.mo11568a()) {
                    throw new InterfaceC2114sq.a();
                }
                super.write(buffer, j);
                this.f12697b = (int) (((long) this.f12697b) + j);
                if (C2117st.this.f12693b != null) {
                    C2142tr.m11707a(new Runnable() { // from class: st.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C2117st.this.f12693b.mo11603a(a.this.f12697b, C2117st.this.f12694c);
                        }
                    });
                    return;
                }
                return;
            }
            super.write(buffer, j);
        }
    }
}
