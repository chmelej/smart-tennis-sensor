package p000;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.ark;

/* JADX INFO: renamed from: os */
/* JADX INFO: compiled from: AbstractDescriptorBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C2006os extends AbstractC1985oo {

    /* JADX INFO: renamed from: c */
    private static Logger f12060c;

    /* JADX INFO: renamed from: k */
    private static final /* synthetic */ ark.InterfaceC0740a f12061k = null;

    /* JADX INFO: renamed from: l */
    private static final /* synthetic */ ark.InterfaceC0740a f12062l = null;

    /* JADX INFO: renamed from: m */
    private static final /* synthetic */ ark.InterfaceC0740a f12063m = null;

    /* JADX INFO: renamed from: n */
    private static final /* synthetic */ ark.InterfaceC0740a f12064n = null;

    /* JADX INFO: renamed from: o */
    private static final /* synthetic */ ark.InterfaceC0740a f12065o = null;

    /* JADX INFO: renamed from: a */
    protected AbstractC2009ov f12066a;

    /* JADX INFO: renamed from: b */
    protected ByteBuffer f12067b;

    /* JADX INFO: renamed from: c */
    private static /* synthetic */ void m11044c() {
        aru aruVar = new aru("AbstractDescriptorBox.java", C2006os.class);
        f12061k = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 42);
        f12062l = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor"), 58);
        f12063m = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getDescriptorAsString", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.lang.String"), 62);
        f12064n = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 66);
        f12065o = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 70);
    }

    static {
        m11044c();
        f12060c = Logger.getLogger(C2006os.class.getName());
    }

    public C2006os(String str) {
        super(str);
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        this.f12067b.rewind();
        byteBuffer.put(this.f12067b);
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        return this.f12067b.limit() + 4;
    }

    /* JADX INFO: renamed from: a */
    public void m11045a(AbstractC2009ov abstractC2009ov) {
        C1988or.m10919a().m10921a(aru.m5284a(f12064n, this, this, abstractC2009ov));
        this.f12066a = abstractC2009ov;
    }

    /* JADX INFO: renamed from: e */
    public void m11046e(ByteBuffer byteBuffer) {
        C1988or.m10919a().m10921a(aru.m5284a(f12065o, this, this, byteBuffer));
        this.f12067b = byteBuffer;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        this.f12067b = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        try {
            this.f12067b.rewind();
            this.f12066a = C2020pf.m11087a(-1, this.f12067b);
        } catch (IOException e) {
            f12060c.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e);
        } catch (IndexOutOfBoundsException e2) {
            f12060c.log(Level.WARNING, "Error parsing ObjectDescriptor", (Throwable) e2);
        }
    }
}
