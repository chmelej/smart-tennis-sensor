package p000;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: renamed from: yo */
/* JADX INFO: compiled from: FastXmlSerializer.java */
/* JADX INFO: loaded from: classes.dex */
class C2274yo implements XmlSerializer {

    /* JADX INFO: renamed from: a */
    private static final String[] f13738a = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* JADX INFO: renamed from: c */
    private int f13740c;

    /* JADX INFO: renamed from: d */
    private Writer f13741d;

    /* JADX INFO: renamed from: e */
    private OutputStream f13742e;

    /* JADX INFO: renamed from: f */
    private CharsetEncoder f13743f;

    /* JADX INFO: renamed from: h */
    private boolean f13745h;

    /* JADX INFO: renamed from: b */
    private final char[] f13739b = new char[8192];

    /* JADX INFO: renamed from: g */
    private ByteBuffer f13744g = ByteBuffer.allocate(8192);

    C2274yo() {
    }

    /* JADX INFO: renamed from: a */
    private void m12467a(char c) throws IOException {
        int i = this.f13740c;
        if (i >= 8191) {
            flush();
            i = this.f13740c;
        }
        this.f13739b[i] = c;
        this.f13740c = i + 1;
    }

    /* JADX INFO: renamed from: a */
    private void m12469a(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                m12469a(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f13740c;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f13740c;
        }
        str.getChars(i, i + i2, this.f13739b, i5);
        this.f13740c = i5 + i2;
    }

    /* JADX INFO: renamed from: a */
    private void m12470a(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                m12470a(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f13740c;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f13740c;
        }
        System.arraycopy(cArr, i, this.f13739b, i5, i2);
        this.f13740c = i5 + i2;
    }

    /* JADX INFO: renamed from: a */
    private void m12468a(String str) throws IOException {
        m12469a(str, 0, str.length());
    }

    /* JADX INFO: renamed from: b */
    private void m12471b(String str) throws IOException {
        String str2;
        int length = str.length();
        char length2 = (char) f13738a.length;
        String[] strArr = f13738a;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < length2 && (str2 = strArr[cCharAt]) != null) {
                if (i2 < i) {
                    m12469a(str, i2, i - i2);
                }
                i2 = i + 1;
                m12468a(str2);
            }
            i++;
        }
        if (i2 < i) {
            m12469a(str, i2, i - i2);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m12472b(char[] cArr, int i, int i2) throws IOException {
        String str;
        char length = (char) f13738a.length;
        String[] strArr = f13738a;
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length && (str = strArr[c]) != null) {
                if (i4 < i) {
                    m12470a(cArr, i4, i - i4);
                }
                i4 = i + 1;
                m12468a(str);
            }
            i++;
        }
        if (i4 < i) {
            m12470a(cArr, i4, i - i4);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        m12467a(' ');
        if (str != null) {
            m12468a(str);
            m12467a(':');
        }
        m12468a(str2);
        m12468a("=\"");
        m12471b(str3);
        m12467a('\"');
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException {
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException {
        if (this.f13745h) {
            m12468a(" />\n");
        } else {
            m12468a("</");
            if (str != null) {
                m12468a(str);
                m12467a(':');
            }
            m12468a(str2);
            m12468a(">\n");
        }
        this.f13745h = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: a */
    private void m12466a() throws IOException {
        int iPosition = this.f13744g.position();
        if (iPosition > 0) {
            this.f13744g.flip();
            this.f13742e.write(this.f13744g.array(), 0, iPosition);
            this.f13744g.clear();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        if (this.f13740c > 0) {
            if (this.f13742e != null) {
                CharBuffer charBufferWrap = CharBuffer.wrap(this.f13739b, 0, this.f13740c);
                CoderResult coderResultEncode = this.f13743f.encode(charBufferWrap, this.f13744g, true);
                while (!coderResultEncode.isError()) {
                    if (coderResultEncode.isOverflow()) {
                        m12466a();
                        coderResultEncode = this.f13743f.encode(charBufferWrap, this.f13744g, true);
                    } else {
                        m12466a();
                        this.f13742e.flush();
                    }
                }
                throw new IOException(coderResultEncode.toString());
            }
            this.f13741d.write(this.f13739b, 0, this.f13740c);
            this.f13741d.flush();
            this.f13740c = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f13743f = Charset.forName(str).newEncoder();
            this.f13742e = outputStream;
        } catch (IllegalCharsetNameException e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
        } catch (UnsupportedCharsetException e2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        this.f13741d = writer;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : "no");
        sb.append("' ?>\n");
        m12468a(sb.toString());
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException {
        if (this.f13745h) {
            m12468a(">\n");
        }
        m12467a('<');
        if (str != null) {
            m12468a(str);
            m12467a(':');
        }
        m12468a(str2);
        this.f13745h = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException {
        if (this.f13745h) {
            m12468a(">");
            this.f13745h = false;
        }
        m12472b(cArr, i, i2);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException {
        if (this.f13745h) {
            m12468a(">");
            this.f13745h = false;
        }
        m12471b(str);
        return this;
    }
}
