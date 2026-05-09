package p000;

import java.io.File;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: RequestBody.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class anf {
    /* JADX INFO: renamed from: a */
    public long mo4445a() {
        return -1L;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo4446a(BufferedSink bufferedSink);

    @Nullable
    /* JADX INFO: renamed from: b */
    public abstract ana mo4447b();

    /* JADX INFO: renamed from: a */
    public static anf m4442a(@Nullable ana anaVar, String str) {
        Charset charsetM2127c = anm.f4211e;
        if (anaVar != null && (charsetM2127c = anaVar.m2127c()) == null) {
            charsetM2127c = anm.f4211e;
            anaVar = ana.m2123b(anaVar + "; charset=utf-8");
        }
        return m4443a(anaVar, str.getBytes(charsetM2127c));
    }

    /* JADX INFO: renamed from: a */
    public static anf m4443a(@Nullable ana anaVar, byte[] bArr) {
        return m4444a(anaVar, bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public static anf m4444a(@Nullable final ana anaVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        anm.m4505a(bArr.length, i, i2);
        return new anf() { // from class: anf.1
            @Override // p000.anf
            @Nullable
            /* JADX INFO: renamed from: b */
            public ana mo4447b() {
                return anaVar;
            }

            @Override // p000.anf
            /* JADX INFO: renamed from: a */
            public long mo4445a() {
                return i2;
            }

            @Override // p000.anf
            /* JADX INFO: renamed from: a */
            public void mo4446a(BufferedSink bufferedSink) {
                bufferedSink.write(bArr, i, i2);
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static anf m4441a(@Nullable final ana anaVar, final File file) {
        if (file == null) {
            throw new NullPointerException("content == null");
        }
        return new anf() { // from class: anf.2
            @Override // p000.anf
            @Nullable
            /* JADX INFO: renamed from: b */
            public ana mo4447b() {
                return anaVar;
            }

            @Override // p000.anf
            /* JADX INFO: renamed from: a */
            public long mo4445a() {
                return file.length();
            }

            @Override // p000.anf
            /* JADX INFO: renamed from: a */
            public void mo4446a(BufferedSink bufferedSink) throws Throwable {
                Source source;
                Source source2 = null;
                try {
                    source = Okio.source(file);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bufferedSink.writeAll(source);
                    anm.m4506a(source);
                } catch (Throwable th2) {
                    th = th2;
                    source2 = source;
                    anm.m4506a(source2);
                    throw th;
                }
            }
        };
    }
}
