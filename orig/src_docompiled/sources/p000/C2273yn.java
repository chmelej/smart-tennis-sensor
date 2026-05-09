package p000;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import p000.InterfaceC2271yl;

/* JADX INFO: renamed from: yn */
/* JADX INFO: compiled from: TransactionXMLFile.java */
/* JADX INFO: loaded from: classes.dex */
public class C2273yn {

    /* JADX INFO: renamed from: c */
    private static final Object f13724c = new Object();

    /* JADX INFO: renamed from: b */
    private File f13726b;

    /* JADX INFO: renamed from: a */
    private final Object f13725a = new Object();

    /* JADX INFO: renamed from: d */
    private HashMap<File, a> f13727d = new HashMap<>();

    public C2273yn(String str) {
        if (str != null && str.length() > 0) {
            this.f13726b = new File(str);
            return;
        }
        throw new RuntimeException("Directory can not be empty");
    }

    /* JADX INFO: renamed from: a */
    private File m12452a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    /* JADX INFO: renamed from: b */
    private File m12455b() {
        File file;
        synchronized (this.f13725a) {
            file = this.f13726b;
        }
        return file;
    }

    /* JADX INFO: renamed from: a */
    private File m12453a(String str) {
        return m12452a(m12455b(), str + ".xml");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p000.InterfaceC2271yl m12457a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.io.File r8 = r7.m12453a(r8)
            java.lang.Object r0 = p000.C2273yn.f13724c
            monitor-enter(r0)
            java.util.HashMap<java.io.File, yn$a> r1 = r7.f13727d     // Catch: java.lang.Throwable -> L93
            java.lang.Object r1 = r1.get(r8)     // Catch: java.lang.Throwable -> L93
            yn$a r1 = (p000.C2273yn.a) r1     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L19
            boolean r2 = r1.m12465d()     // Catch: java.lang.Throwable -> L93
            if (r2 != 0) goto L19
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            return r1
        L19:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            java.io.File r0 = m12456b(r8)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L2a
            r8.delete()
            r0.renameTo(r8)
        L2a:
            boolean r0 = r8.exists()
            if (r0 == 0) goto L33
            r8.canRead()
        L33:
            r0 = 0
            boolean r2 = r8.exists()
            if (r2 == 0) goto L70
            boolean r2 = r8.canRead()
            if (r2 == 0) goto L70
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: org.xmlpull.v1.XmlPullParserException -> L4f java.lang.Throwable -> L70
            r2.<init>(r8)     // Catch: org.xmlpull.v1.XmlPullParserException -> L4f java.lang.Throwable -> L70
            java.util.HashMap r3 = p000.C2275yp.m12474a(r2)     // Catch: org.xmlpull.v1.XmlPullParserException -> L4f java.lang.Throwable -> L70
            r2.close()     // Catch: java.lang.Throwable -> L4c org.xmlpull.v1.XmlPullParserException -> L4e
        L4c:
            r0 = r3
            goto L70
        L4e:
            r0 = r3
        L4f:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.IOException -> L67 java.io.FileNotFoundException -> L6c
            r2.<init>(r8)     // Catch: java.io.IOException -> L67 java.io.FileNotFoundException -> L6c
            int r3 = r2.available()     // Catch: java.io.IOException -> L67 java.io.FileNotFoundException -> L6c
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L67 java.io.FileNotFoundException -> L6c
            r2.read(r3)     // Catch: java.io.IOException -> L67 java.io.FileNotFoundException -> L6c
            java.lang.String r2 = new java.lang.String     // Catch: java.io.IOException -> L67 java.io.FileNotFoundException -> L6c
            r4 = 0
            int r5 = r3.length     // Catch: java.io.IOException -> L67 java.io.FileNotFoundException -> L6c
            java.lang.String r6 = "UTF-8"
            r2.<init>(r3, r4, r5, r6)     // Catch: java.io.IOException -> L67 java.io.FileNotFoundException -> L6c
            goto L70
        L67:
            r2 = move-exception
            r2.printStackTrace()
            goto L70
        L6c:
            r2 = move-exception
            r2.printStackTrace()
        L70:
            java.lang.Object r2 = p000.C2273yn.f13724c
            monitor-enter(r2)
            if (r1 == 0) goto L7b
            r1.m12463a(r0)     // Catch: java.lang.Throwable -> L79
            goto L8f
        L79:
            r8 = move-exception
            goto L91
        L7b:
            java.util.HashMap<java.io.File, yn$a> r1 = r7.f13727d     // Catch: java.lang.Throwable -> L79
            java.lang.Object r1 = r1.get(r8)     // Catch: java.lang.Throwable -> L79
            yn$a r1 = (p000.C2273yn.a) r1     // Catch: java.lang.Throwable -> L79
            if (r1 != 0) goto L8f
            yn$a r1 = new yn$a     // Catch: java.lang.Throwable -> L79
            r1.<init>(r8, r9, r0)     // Catch: java.lang.Throwable -> L79
            java.util.HashMap<java.io.File, yn$a> r9 = r7.f13727d     // Catch: java.lang.Throwable -> L79
            r9.put(r8, r1)     // Catch: java.lang.Throwable -> L79
        L8f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L79
            return r1
        L91:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L79
            throw r8
        L93:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2273yn.m12457a(java.lang.String, int):yl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static File m12456b(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX INFO: renamed from: yn$a */
    /* JADX INFO: compiled from: TransactionXMLFile.java */
    static final class a implements InterfaceC2271yl {

        /* JADX INFO: renamed from: f */
        private static final Object f13728f = new Object();

        /* JADX INFO: renamed from: a */
        private final File f13729a;

        /* JADX INFO: renamed from: b */
        private final File f13730b;

        /* JADX INFO: renamed from: c */
        private final int f13731c;

        /* JADX INFO: renamed from: d */
        private Map f13732d;

        /* JADX INFO: renamed from: e */
        private boolean f13733e = false;

        /* JADX INFO: renamed from: g */
        private WeakHashMap<InterfaceC2271yl.b, Object> f13734g;

        a(File file, int i, Map map) {
            this.f13729a = file;
            this.f13730b = C2273yn.m12456b(file);
            this.f13731c = i;
            this.f13732d = map == null ? new HashMap() : map;
            this.f13734g = new WeakHashMap<>();
        }

        @Override // p000.InterfaceC2271yl
        /* JADX INFO: renamed from: a */
        public boolean mo12430a() {
            return this.f13729a != null && new File(this.f13729a.getAbsolutePath()).exists();
        }

        /* JADX INFO: renamed from: a */
        public void m12464a(boolean z) {
            synchronized (this) {
                this.f13733e = z;
            }
        }

        /* JADX INFO: renamed from: d */
        public boolean m12465d() {
            boolean z;
            synchronized (this) {
                z = this.f13733e;
            }
            return z;
        }

        /* JADX INFO: renamed from: a */
        public void m12463a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f13732d = map;
                }
            }
        }

        @Override // p000.InterfaceC2271yl
        /* JADX INFO: renamed from: b */
        public Map<String, ?> mo12431b() {
            HashMap map;
            synchronized (this) {
                map = new HashMap(this.f13732d);
            }
            return map;
        }

        @Override // p000.InterfaceC2271yl
        /* JADX INFO: renamed from: a */
        public String mo12429a(String str, String str2) {
            String str3;
            synchronized (this) {
                str3 = (String) this.f13732d.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            }
            return str3;
        }

        @Override // p000.InterfaceC2271yl
        /* JADX INFO: renamed from: a */
        public long mo12428a(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.f13732d.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        /* JADX INFO: renamed from: yn$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TransactionXMLFile.java */
        public final class C2325a implements InterfaceC2271yl.a {

            /* JADX INFO: renamed from: b */
            private final Map<String, Object> f13736b = new HashMap();

            /* JADX INFO: renamed from: c */
            private boolean f13737c = false;

            public C2325a() {
            }

            @Override // p000.InterfaceC2271yl.a
            /* JADX INFO: renamed from: a */
            public InterfaceC2271yl.a mo12437a(String str, String str2) {
                synchronized (this) {
                    this.f13736b.put(str, str2);
                }
                return this;
            }

            @Override // p000.InterfaceC2271yl.a
            /* JADX INFO: renamed from: a */
            public InterfaceC2271yl.a mo12435a(String str, int i) {
                synchronized (this) {
                    this.f13736b.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // p000.InterfaceC2271yl.a
            /* JADX INFO: renamed from: a */
            public InterfaceC2271yl.a mo12436a(String str, long j) {
                synchronized (this) {
                    this.f13736b.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // p000.InterfaceC2271yl.a
            /* JADX INFO: renamed from: a */
            public InterfaceC2271yl.a mo12434a(String str, float f) {
                synchronized (this) {
                    this.f13736b.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // p000.InterfaceC2271yl.a
            /* JADX INFO: renamed from: a */
            public InterfaceC2271yl.a mo12438a(String str, boolean z) {
                synchronized (this) {
                    this.f13736b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // p000.InterfaceC2271yl.a
            /* JADX INFO: renamed from: a */
            public InterfaceC2271yl.a mo12433a() {
                synchronized (this) {
                    this.f13737c = true;
                }
                return this;
            }

            @Override // p000.InterfaceC2271yl.a
            /* JADX INFO: renamed from: b */
            public boolean mo12439b() {
                boolean z;
                ArrayList arrayList;
                HashSet<InterfaceC2271yl.b> hashSet;
                boolean zM12462e;
                synchronized (C2273yn.f13724c) {
                    z = a.this.f13734g.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f13734g.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.f13737c) {
                            a.this.f13732d.clear();
                            this.f13737c = false;
                        }
                        for (Map.Entry<String, Object> entry : this.f13736b.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.f13732d.remove(key);
                            } else {
                                a.this.f13732d.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.f13736b.clear();
                    }
                    zM12462e = a.this.m12462e();
                    if (zM12462e) {
                        a.this.m12464a(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (InterfaceC2271yl.b bVar : hashSet) {
                            if (bVar != null) {
                                bVar.m12440a(a.this, str);
                            }
                        }
                    }
                }
                return zM12462e;
            }
        }

        @Override // p000.InterfaceC2271yl
        /* JADX INFO: renamed from: c */
        public InterfaceC2271yl.a mo12432c() {
            return new C2325a();
        }

        /* JADX INFO: renamed from: a */
        private FileOutputStream m12458a(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: e */
        public boolean m12462e() {
            if (this.f13729a.exists()) {
                if (!this.f13730b.exists()) {
                    if (!this.f13729a.renameTo(this.f13730b)) {
                        return false;
                    }
                } else {
                    this.f13729a.delete();
                }
            }
            try {
                FileOutputStream fileOutputStreamM12458a = m12458a(this.f13729a);
                if (fileOutputStreamM12458a == null) {
                    return false;
                }
                C2275yp.m12478a(this.f13732d, fileOutputStreamM12458a);
                fileOutputStreamM12458a.close();
                this.f13730b.delete();
                return true;
            } catch (IOException | XmlPullParserException unused) {
                if (this.f13729a.exists()) {
                    this.f13729a.delete();
                }
                return false;
            }
        }
    }
}
