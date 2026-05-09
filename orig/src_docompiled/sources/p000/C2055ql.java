package p000;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: ql */
/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
final class C2055ql implements Closeable {

    /* JADX INFO: renamed from: a */
    static final Pattern f12344a = Pattern.compile("[a-z0-9_-]{1,64}");

    /* JADX INFO: renamed from: r */
    private static final OutputStream f12345r = new OutputStream() { // from class: ql.2
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    };

    /* JADX INFO: renamed from: c */
    private final File f12347c;

    /* JADX INFO: renamed from: d */
    private final File f12348d;

    /* JADX INFO: renamed from: e */
    private final File f12349e;

    /* JADX INFO: renamed from: f */
    private final File f12350f;

    /* JADX INFO: renamed from: g */
    private final int f12351g;

    /* JADX INFO: renamed from: h */
    private long f12352h;

    /* JADX INFO: renamed from: i */
    private int f12353i;

    /* JADX INFO: renamed from: j */
    private final int f12354j;

    /* JADX INFO: renamed from: m */
    private Writer f12357m;

    /* JADX INFO: renamed from: o */
    private int f12359o;

    /* JADX INFO: renamed from: k */
    private long f12355k = 0;

    /* JADX INFO: renamed from: l */
    private int f12356l = 0;

    /* JADX INFO: renamed from: n */
    private final LinkedHashMap<String, b> f12358n = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: p */
    private long f12360p = 0;

    /* JADX INFO: renamed from: b */
    final ThreadPoolExecutor f12346b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: q */
    private final Callable<Void> f12361q = new Callable<Void>() { // from class: ql.1
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (C2055ql.this) {
                if (C2055ql.this.f12357m == null) {
                    return null;
                }
                C2055ql.this.m11228h();
                C2055ql.this.m11229i();
                if (C2055ql.this.m11225f()) {
                    C2055ql.this.m11221e();
                    C2055ql.this.f12359o = 0;
                }
                return null;
            }
        }
    };

    private C2055ql(File file, int i, int i2, long j, int i3) {
        this.f12347c = file;
        this.f12351g = i;
        this.f12348d = new File(file, "journal");
        this.f12349e = new File(file, "journal.tmp");
        this.f12350f = new File(file, "journal.bkp");
        this.f12354j = i2;
        this.f12352h = j;
        this.f12353i = i3;
    }

    /* JADX INFO: renamed from: a */
    public static C2055ql m11209a(File file, int i, int i2, long j, int i3) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m11211a(file2, file3, false);
            }
        }
        C2055ql c2055ql = new C2055ql(file, i, i2, j, i3);
        if (c2055ql.f12348d.exists()) {
            try {
                c2055ql.m11216c();
                c2055ql.m11218d();
                c2055ql.f12357m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c2055ql.f12348d, true), C2058qo.f12394a));
                return c2055ql;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                c2055ql.m11231a();
            }
        }
        file.mkdirs();
        C2055ql c2055ql2 = new C2055ql(file, i, i2, j, i3);
        c2055ql2.m11221e();
        return c2055ql2;
    }

    /* JADX INFO: renamed from: c */
    private void m11216c() {
        C2057qn c2057qn = new C2057qn(new FileInputStream(this.f12348d), C2058qo.f12394a);
        try {
            String strM11260a = c2057qn.m11260a();
            String strM11260a2 = c2057qn.m11260a();
            String strM11260a3 = c2057qn.m11260a();
            String strM11260a4 = c2057qn.m11260a();
            String strM11260a5 = c2057qn.m11260a();
            if (!"libcore.io.DiskLruCache".equals(strM11260a) || !"1".equals(strM11260a2) || !Integer.toString(this.f12351g).equals(strM11260a3) || !Integer.toString(this.f12354j).equals(strM11260a4) || !"".equals(strM11260a5)) {
                throw new IOException("unexpected journal header: [" + strM11260a + ", " + strM11260a2 + ", " + strM11260a4 + ", " + strM11260a5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    m11219d(c2057qn.m11260a());
                    i++;
                } catch (EOFException unused) {
                    this.f12359o = i - this.f12358n.size();
                    C2058qo.m11261a(c2057qn);
                    return;
                }
            }
        } catch (Throwable th) {
            C2058qo.m11261a(c2057qn);
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m11219d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f12358n.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.f12358n.get(strSubstring);
        if (bVar == null) {
            bVar = new b(strSubstring);
            this.f12358n.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bVar.f12372d = true;
            bVar.f12373e = null;
            bVar.m11245a(strArrSplit);
            return;
        }
        if (iIndexOf2 != -1 || iIndexOf != "DIRTY".length() || !str.startsWith("DIRTY")) {
            if (iIndexOf2 == -1 && iIndexOf == "READ".length() && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        bVar.f12373e = new a(bVar);
    }

    /* JADX INFO: renamed from: d */
    private void m11218d() throws IOException {
        m11210a(this.f12349e);
        Iterator<b> it = this.f12358n.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.f12373e == null) {
                while (i < this.f12354j) {
                    this.f12355k += next.f12371c[i];
                    this.f12356l++;
                    i++;
                }
            } else {
                next.f12373e = null;
                while (i < this.f12354j) {
                    m11210a(next.m11252a(i));
                    m11210a(next.m11254b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public synchronized void m11221e() {
        if (this.f12357m != null) {
            this.f12357m.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12349e), C2058qo.f12394a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f12351g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f12354j));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.f12358n.values()) {
                if (bVar.f12373e != null) {
                    bufferedWriter.write("DIRTY " + bVar.f12370b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.f12370b + bVar.m11253a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f12348d.exists()) {
                m11211a(this.f12348d, this.f12350f, true);
            }
            m11211a(this.f12349e, this.f12348d, false);
            this.f12350f.delete();
            this.f12357m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12348d, true), C2058qo.f12394a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m11210a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m11211a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m11210a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized c m11230a(String str) {
        m11227g();
        m11222e(str);
        b bVar = this.f12358n.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.f12372d) {
            return null;
        }
        File[] fileArr = new File[this.f12354j];
        InputStream[] inputStreamArr = new InputStream[this.f12354j];
        for (int i = 0; i < this.f12354j; i++) {
            try {
                File fileM11252a = bVar.m11252a(i);
                fileArr[i] = fileM11252a;
                inputStreamArr[i] = new FileInputStream(fileM11252a);
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.f12354j && inputStreamArr[i2] != null; i2++) {
                    C2058qo.m11261a(inputStreamArr[i2]);
                }
                return null;
            }
        }
        this.f12359o++;
        this.f12357m.append((CharSequence) ("READ " + str + '\n'));
        if (m11225f()) {
            this.f12346b.submit(this.f12361q);
        }
        return new c(str, bVar.f12374f, fileArr, inputStreamArr, bVar.f12371c);
    }

    /* JADX INFO: renamed from: b */
    public a m11232b(String str) {
        return m11208a(str, -1L);
    }

    /* JADX INFO: renamed from: a */
    private synchronized a m11208a(String str, long j) {
        m11227g();
        m11222e(str);
        b bVar = this.f12358n.get(str);
        if (j != -1 && (bVar == null || bVar.f12374f != j)) {
            return null;
        }
        if (bVar == null) {
            bVar = new b(str);
            this.f12358n.put(str, bVar);
        } else if (bVar.f12373e != null) {
            return null;
        }
        a aVar = new a(bVar);
        bVar.f12373e = aVar;
        this.f12357m.write("DIRTY " + str + '\n');
        this.f12357m.flush();
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public synchronized void m11212a(a aVar, boolean z) {
        b bVar = aVar.f12364b;
        if (bVar.f12373e != aVar) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f12372d) {
            for (int i = 0; i < this.f12354j; i++) {
                if (!aVar.f12365c[i]) {
                    aVar.m11240b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!bVar.m11254b(i).exists()) {
                    aVar.m11240b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f12354j; i2++) {
            File fileM11254b = bVar.m11254b(i2);
            if (z) {
                if (fileM11254b.exists()) {
                    File fileM11252a = bVar.m11252a(i2);
                    fileM11254b.renameTo(fileM11252a);
                    long j = bVar.f12371c[i2];
                    long length = fileM11252a.length();
                    bVar.f12371c[i2] = length;
                    this.f12355k = (this.f12355k - j) + length;
                    this.f12356l++;
                }
            } else {
                m11210a(fileM11254b);
            }
        }
        this.f12359o++;
        bVar.f12373e = null;
        if (bVar.f12372d | z) {
            bVar.f12372d = true;
            this.f12357m.write("CLEAN " + bVar.f12370b + bVar.m11253a() + '\n');
            if (z) {
                long j2 = this.f12360p;
                this.f12360p = j2 + 1;
                bVar.f12374f = j2;
            }
        } else {
            this.f12358n.remove(bVar.f12370b);
            this.f12357m.write("REMOVE " + bVar.f12370b + '\n');
        }
        this.f12357m.flush();
        if (this.f12355k > this.f12352h || this.f12356l > this.f12353i || m11225f()) {
            this.f12346b.submit(this.f12361q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public boolean m11225f() {
        return this.f12359o >= 2000 && this.f12359o >= this.f12358n.size();
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m11233c(String str) {
        m11227g();
        m11222e(str);
        b bVar = this.f12358n.get(str);
        if (bVar != null && bVar.f12373e == null) {
            for (int i = 0; i < this.f12354j; i++) {
                File fileM11252a = bVar.m11252a(i);
                if (fileM11252a.exists() && !fileM11252a.delete()) {
                    throw new IOException("failed to delete " + fileM11252a);
                }
                this.f12355k -= bVar.f12371c[i];
                this.f12356l--;
                bVar.f12371c[i] = 0;
            }
            this.f12359o++;
            this.f12357m.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f12358n.remove(str);
            if (m11225f()) {
                this.f12346b.submit(this.f12361q);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    private void m11227g() {
        if (this.f12357m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f12357m == null) {
            return;
        }
        for (b bVar : new ArrayList(this.f12358n.values())) {
            if (bVar.f12373e != null) {
                bVar.f12373e.m11240b();
            }
        }
        m11228h();
        m11229i();
        this.f12357m.close();
        this.f12357m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m11228h() {
        while (this.f12355k > this.f12352h) {
            m11233c(this.f12358n.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m11229i() {
        while (this.f12356l > this.f12353i) {
            m11233c(this.f12358n.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11231a() throws IOException {
        close();
        C2058qo.m11262a(this.f12347c);
    }

    /* JADX INFO: renamed from: e */
    private void m11222e(String str) {
        if (f12344a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    /* JADX INFO: renamed from: ql$c */
    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class c implements Closeable {

        /* JADX INFO: renamed from: b */
        private final String f12376b;

        /* JADX INFO: renamed from: c */
        private final long f12377c;

        /* JADX INFO: renamed from: d */
        private File[] f12378d;

        /* JADX INFO: renamed from: e */
        private final InputStream[] f12379e;

        /* JADX INFO: renamed from: f */
        private final long[] f12380f;

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.f12376b = str;
            this.f12377c = j;
            this.f12378d = fileArr;
            this.f12379e = inputStreamArr;
            this.f12380f = jArr;
        }

        /* JADX INFO: renamed from: a */
        public File m11255a(int i) {
            return this.f12378d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f12379e) {
                C2058qo.m11261a(inputStream);
            }
        }
    }

    /* JADX INFO: renamed from: ql$a */
    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class a {

        /* JADX INFO: renamed from: b */
        private final b f12364b;

        /* JADX INFO: renamed from: c */
        private final boolean[] f12365c;

        /* JADX INFO: renamed from: d */
        private boolean f12366d;

        /* JADX INFO: renamed from: e */
        private boolean f12367e;

        private a(b bVar) {
            this.f12364b = bVar;
            this.f12365c = bVar.f12372d ? null : new boolean[C2055ql.this.f12354j];
        }

        /* JADX INFO: renamed from: a */
        public OutputStream m11238a(int i) {
            FileOutputStream fileOutputStream;
            C2322a c2322a;
            synchronized (C2055ql.this) {
                if (this.f12364b.f12373e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f12364b.f12372d) {
                    this.f12365c[i] = true;
                }
                File fileM11254b = this.f12364b.m11254b(i);
                try {
                    fileOutputStream = new FileOutputStream(fileM11254b);
                } catch (FileNotFoundException unused) {
                    C2055ql.this.f12347c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileM11254b);
                    } catch (FileNotFoundException unused2) {
                        return C2055ql.f12345r;
                    }
                }
                c2322a = new C2322a(fileOutputStream);
            }
            return c2322a;
        }

        /* JADX INFO: renamed from: a */
        public void m11239a() {
            if (this.f12366d) {
                C2055ql.this.m11212a(this, false);
                C2055ql.this.m11233c(this.f12364b.f12370b);
            } else {
                C2055ql.this.m11212a(this, true);
            }
            this.f12367e = true;
        }

        /* JADX INFO: renamed from: b */
        public void m11240b() {
            C2055ql.this.m11212a(this, false);
        }

        /* JADX INFO: renamed from: ql$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DiskLruCache.java */
        class C2322a extends FilterOutputStream {
            private C2322a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    a.this.f12366d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    a.this.f12366d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    a.this.f12366d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    a.this.f12366d = true;
                }
            }
        }
    }

    /* JADX INFO: renamed from: ql$b */
    /* JADX INFO: compiled from: DiskLruCache.java */
    final class b {

        /* JADX INFO: renamed from: b */
        private final String f12370b;

        /* JADX INFO: renamed from: c */
        private final long[] f12371c;

        /* JADX INFO: renamed from: d */
        private boolean f12372d;

        /* JADX INFO: renamed from: e */
        private a f12373e;

        /* JADX INFO: renamed from: f */
        private long f12374f;

        private b(String str) {
            this.f12370b = str;
            this.f12371c = new long[C2055ql.this.f12354j];
        }

        /* JADX INFO: renamed from: a */
        public String m11253a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f12371c) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m11245a(String[] strArr) throws IOException {
            if (strArr.length != C2055ql.this.f12354j) {
                throw m11247b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f12371c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m11247b(strArr);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        private IOException m11247b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: renamed from: a */
        public File m11252a(int i) {
            return new File(C2055ql.this.f12347c, this.f12370b + "." + i);
        }

        /* JADX INFO: renamed from: b */
        public File m11254b(int i) {
            return new File(C2055ql.this.f12347c, this.f12370b + "." + i + ".tmp");
        }
    }
}
