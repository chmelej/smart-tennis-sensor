package p000;

import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;

/* JADX INFO: compiled from: ArchiveInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class alo extends ZipInputStream {

    /* JADX INFO: renamed from: a */
    private Map<String, byte[]> f1657a;

    /* JADX INFO: renamed from: b */
    private Manifest f1658b;

    /* JADX INFO: renamed from: c */
    private CRC32 f1659c;

    /* JADX INFO: renamed from: d */
    private byte[] f1660d;

    /* JADX INFO: renamed from: e */
    private byte[] f1661e;

    /* JADX INFO: renamed from: f */
    private byte[] f1662f;

    /* JADX INFO: renamed from: g */
    private byte[] f1663g;

    /* JADX INFO: renamed from: h */
    private byte[] f1664h;

    /* JADX INFO: renamed from: i */
    private byte[] f1665i;

    /* JADX INFO: renamed from: j */
    private byte[] f1666j;

    /* JADX INFO: renamed from: k */
    private int f1667k;

    /* JADX INFO: renamed from: l */
    private int f1668l;

    /* JADX INFO: renamed from: m */
    private int f1669m;

    /* JADX INFO: renamed from: n */
    private int f1670n;

    /* JADX INFO: renamed from: o */
    private int f1671o;

    /* JADX INFO: renamed from: p */
    private byte[] f1672p;

    /* JADX INFO: renamed from: q */
    private int f1673q;

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public alo(java.io.InputStream r4, int r5, int r6) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.alo.<init>(java.io.InputStream, int, int):void");
    }

    /* JADX INFO: renamed from: b */
    private void m1887b(int i) {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i2 = super.read(bArr);
                if (i2 == -1) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (name.toLowerCase(Locale.US).endsWith("hex")) {
                alp alpVar = new alp(byteArray, i);
                byteArray = new byte[alpVar.available()];
                alpVar.read(byteArray);
                alpVar.close();
            }
            if ("manifest.json".equals(name)) {
                str = new String(byteArray, "UTF-8");
            } else {
                this.f1657a.put(name, byteArray);
            }
        }
        if (str != null) {
            this.f1658b = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
        }
    }

    @Override // java.util.zip.ZipInputStream, java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1661e = null;
        this.f1662f = null;
        this.f1661e = null;
        this.f1663g = null;
        this.f1670n = 0;
        this.f1669m = 0;
        this.f1668l = 0;
        this.f1666j = null;
        this.f1667k = 0;
        this.f1671o = 0;
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int length = this.f1666j.length - this.f1667k;
        if (bArr.length <= length) {
            length = bArr.length;
        }
        System.arraycopy(this.f1666j, this.f1667k, bArr, 0, length);
        this.f1667k += length;
        if (bArr.length > length) {
            if (m1888i() == null) {
                this.f1671o += length;
                this.f1659c.update(bArr, 0, length);
                return length;
            }
            int length2 = this.f1666j.length;
            if (bArr.length - length <= length2) {
                length2 = bArr.length - length;
            }
            System.arraycopy(this.f1666j, 0, bArr, length, length2);
            this.f1667k += length2;
            length += length2;
        }
        this.f1671o += length;
        this.f1659c.update(bArr, 0, length);
        return length;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        this.f1672p = this.f1666j;
        this.f1673q = this.f1667k;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        if (this.f1660d != null && (this.f1661e != null || this.f1662f != null || this.f1663g != null)) {
            throw new UnsupportedOperationException("Application must be sent in a separate connection.");
        }
        this.f1666j = this.f1672p;
        int i = this.f1673q;
        this.f1667k = i;
        this.f1671o = i;
        this.f1659c.reset();
        if (this.f1666j == this.f1662f && this.f1661e != null) {
            this.f1659c.update(this.f1661e);
            this.f1671o += this.f1668l;
        }
        this.f1659c.update(this.f1666j, 0, this.f1667k);
    }

    /* JADX INFO: renamed from: a */
    public long m1890a() {
        return this.f1659c.getValue();
    }

    /* JADX INFO: renamed from: b */
    public int m1891b() {
        byte b = this.f1663g != null ? (byte) 3 : (byte) 0;
        if (this.f1668l > 0) {
            b = (byte) (b | 1);
        }
        if (this.f1669m > 0) {
            b = (byte) (b | 2);
        }
        return this.f1670n > 0 ? (byte) (b | 4) : b;
    }

    /* JADX INFO: renamed from: a */
    public int m1889a(int i) {
        if (this.f1671o > 0) {
            throw new UnsupportedOperationException("Content type must not be change after reading content");
        }
        int iM1891b = i & m1891b();
        if ((iM1891b & 1) == 0) {
            this.f1661e = null;
            if (this.f1663g != null) {
                this.f1663g = null;
                this.f1669m = 0;
            }
            this.f1668l = 0;
        }
        if ((iM1891b & 2) == 0) {
            this.f1662f = null;
            if (this.f1663g != null) {
                this.f1663g = null;
                this.f1668l = 0;
            }
            this.f1669m = 0;
        }
        if ((iM1891b & 4) == 0) {
            this.f1660d = null;
            this.f1670n = 0;
        }
        mark(0);
        return iM1891b;
    }

    /* JADX INFO: renamed from: i */
    private byte[] m1888i() {
        byte[] bArr;
        if (this.f1666j == this.f1661e && this.f1662f != null) {
            bArr = this.f1662f;
            this.f1666j = bArr;
        } else if (this.f1666j != this.f1660d && this.f1660d != null) {
            bArr = this.f1660d;
            this.f1666j = bArr;
        } else {
            bArr = null;
            this.f1666j = null;
        }
        this.f1667k = 0;
        return bArr;
    }

    @Override // java.util.zip.ZipInputStream, java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() {
        if (this.f1663g != null && this.f1668l == 0 && this.f1669m == 0) {
            return (this.f1663g.length + this.f1670n) - this.f1671o;
        }
        return ((this.f1668l + this.f1669m) + this.f1670n) - this.f1671o;
    }

    /* JADX INFO: renamed from: c */
    public int m1892c() {
        return this.f1668l;
    }

    /* JADX INFO: renamed from: d */
    public int m1893d() {
        return this.f1669m;
    }

    /* JADX INFO: renamed from: e */
    public int m1894e() {
        return this.f1670n;
    }

    /* JADX INFO: renamed from: f */
    public byte[] m1895f() {
        return this.f1664h;
    }

    /* JADX INFO: renamed from: g */
    public byte[] m1896g() {
        return this.f1665i;
    }

    /* JADX INFO: renamed from: h */
    public boolean m1897h() {
        return this.f1658b != null && this.f1658b.isSecureDfuRequired();
    }
}
