package p000;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: op */
/* JADX INFO: compiled from: BasicContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1986op implements Closeable, Iterator<InterfaceC1938nj>, InterfaceC1940nl {

    /* JADX INFO: renamed from: a */
    private static final InterfaceC1938nj f11962a = new AbstractC1983om("eof ") { // from class: op.1
        @Override // p000.AbstractC1983om
        /* JADX INFO: renamed from: a */
        protected void mo10760a(ByteBuffer byteBuffer) {
        }

        @Override // p000.AbstractC1983om
        /* JADX INFO: renamed from: a_ */
        protected long mo10761a_() {
            return 0L;
        }

        @Override // p000.AbstractC1983om
        /* JADX INFO: renamed from: b */
        protected void mo10762b(ByteBuffer byteBuffer) {
        }
    };

    /* JADX INFO: renamed from: b */
    private static AbstractC2029po f11963b = AbstractC2029po.m11097a(C1986op.class);

    /* JADX INFO: renamed from: f */
    protected InterfaceC1931nc f11965f;

    /* JADX INFO: renamed from: g */
    protected InterfaceC1987oq f11966g;

    /* JADX INFO: renamed from: h */
    InterfaceC1938nj f11967h = null;

    /* JADX INFO: renamed from: i */
    long f11968i = 0;

    /* JADX INFO: renamed from: j */
    long f11969j = 0;

    /* JADX INFO: renamed from: k */
    long f11970k = 0;

    /* JADX INFO: renamed from: c */
    private List<InterfaceC1938nj> f11964c = new ArrayList();

    /* JADX INFO: renamed from: j */
    public List<InterfaceC1938nj> m10912j() {
        if (this.f11966g != null && this.f11967h != f11962a) {
            return new C2028pn(this.f11964c, this);
        }
        return this.f11964c;
    }

    /* JADX INFO: renamed from: k */
    protected long m10913k() {
        long j = 0;
        int i = 0;
        while (i < m10912j().size()) {
            long jMo1637a = j + this.f11964c.get(i).mo1637a();
            i++;
            j = jMo1637a;
        }
        return j;
    }

    /* JADX INFO: renamed from: a */
    public void m10910a(InterfaceC1938nj interfaceC1938nj) {
        if (interfaceC1938nj != null) {
            this.f11964c = new ArrayList(m10912j());
            interfaceC1938nj.mo1640a(this);
            this.f11964c.add(interfaceC1938nj);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f11967h == f11962a) {
            return false;
        }
        if (this.f11967h != null) {
            return true;
        }
        try {
            this.f11967h = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.f11967h = f11962a;
            return false;
        }
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public InterfaceC1938nj next() {
        InterfaceC1938nj interfaceC1938njM10728a;
        if (this.f11967h != null && this.f11967h != f11962a) {
            InterfaceC1938nj interfaceC1938nj = this.f11967h;
            this.f11967h = null;
            return interfaceC1938nj;
        }
        if (this.f11966g == null || this.f11968i >= this.f11970k) {
            this.f11967h = f11962a;
            throw new NoSuchElementException();
        }
        try {
            synchronized (this.f11966g) {
                this.f11966g.m10918a(this.f11968i);
                interfaceC1938njM10728a = this.f11965f.m10728a(this.f11966g, this);
                this.f11968i = this.f11966g.m10915a();
            }
            return interfaceC1938njM10728a;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.f11964c.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.f11964c.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    public final void m10911b(WritableByteChannel writableByteChannel) {
        Iterator<InterfaceC1938nj> it = m10912j().iterator();
        while (it.hasNext()) {
            it.next().mo1639a(writableByteChannel);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11966g.close();
    }
}
