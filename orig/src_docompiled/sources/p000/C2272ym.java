package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import java.io.File;
import java.util.Map;
import p000.InterfaceC2271yl;

/* JADX INFO: renamed from: ym */
/* JADX INFO: compiled from: PersistentConfiguration.java */
/* JADX INFO: loaded from: classes.dex */
public class C2272ym {

    /* JADX INFO: renamed from: a */
    private String f13712a;

    /* JADX INFO: renamed from: b */
    private String f13713b;

    /* JADX INFO: renamed from: c */
    private boolean f13714c;

    /* JADX INFO: renamed from: d */
    private boolean f13715d;

    /* JADX INFO: renamed from: e */
    private boolean f13716e;

    /* JADX INFO: renamed from: f */
    private SharedPreferences f13717f;

    /* JADX INFO: renamed from: g */
    private InterfaceC2271yl f13718g;

    /* JADX INFO: renamed from: h */
    private SharedPreferences.Editor f13719h = null;

    /* JADX INFO: renamed from: i */
    private InterfaceC2271yl.a f13720i = null;

    /* JADX INFO: renamed from: j */
    private Context f13721j;

    /* JADX INFO: renamed from: k */
    private C2273yn f13722k;

    /* JADX INFO: renamed from: l */
    private boolean f13723l;

    /* JADX WARN: Removed duplicated region for block: B:63:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C2272ym(android.content.Context r8, java.lang.String r9, java.lang.String r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2272ym.<init>(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    /* JADX INFO: renamed from: b */
    private C2273yn m12443b(String str) {
        File fileM12445c = m12445c(str);
        if (fileM12445c == null) {
            return null;
        }
        this.f13722k = new C2273yn(fileM12445c.getAbsolutePath());
        return this.f13722k;
    }

    /* JADX INFO: renamed from: c */
    private File m12445c(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: renamed from: a */
    private void m12441a(SharedPreferences sharedPreferences, InterfaceC2271yl interfaceC2271yl) {
        InterfaceC2271yl.a aVarMo12432c;
        if (sharedPreferences == null || interfaceC2271yl == null || (aVarMo12432c = interfaceC2271yl.mo12432c()) == null) {
            return;
        }
        aVarMo12432c.mo12433a();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                aVarMo12432c.mo12437a(key, (String) value);
            } else if (value instanceof Integer) {
                aVarMo12432c.mo12435a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                aVarMo12432c.mo12436a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                aVarMo12432c.mo12434a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                aVarMo12432c.mo12438a(key, ((Boolean) value).booleanValue());
            }
        }
        aVarMo12432c.mo12439b();
    }

    /* JADX INFO: renamed from: a */
    private void m12442a(InterfaceC2271yl interfaceC2271yl, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit;
        if (interfaceC2271yl == null || sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.clear();
        for (Map.Entry<String, ?> entry : interfaceC2271yl.mo12431b().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                editorEdit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                editorEdit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                editorEdit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    private boolean m12444b() {
        if (this.f13718g == null) {
            return false;
        }
        boolean zMo12430a = this.f13718g.mo12430a();
        if (!zMo12430a) {
            m12450a();
        }
        return zMo12430a;
    }

    /* JADX INFO: renamed from: c */
    private void m12446c() {
        if (this.f13719h == null && this.f13717f != null) {
            this.f13719h = this.f13717f.edit();
        }
        if (this.f13716e && this.f13720i == null && this.f13718g != null) {
            this.f13720i = this.f13718g.mo12432c();
        }
        m12444b();
    }

    /* JADX INFO: renamed from: a */
    public void m12448a(String str, long j) {
        if (C2270yk.m12426a(str) || str.equals("t")) {
            return;
        }
        m12446c();
        if (this.f13719h != null) {
            this.f13719h.putLong(str, j);
        }
        if (this.f13720i != null) {
            this.f13720i.mo12436a(str, j);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12449a(String str, String str2) {
        if (C2270yk.m12426a(str) || str.equals("t")) {
            return;
        }
        m12446c();
        if (this.f13719h != null) {
            this.f13719h.putString(str, str2);
        }
        if (this.f13720i != null) {
            this.f13720i.mo12437a(str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m12450a() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r5.f13719h
            r3 = 0
            if (r2 == 0) goto L22
            boolean r2 = r5.f13723l
            if (r2 != 0) goto L18
            android.content.SharedPreferences r2 = r5.f13717f
            if (r2 == 0) goto L18
            android.content.SharedPreferences$Editor r2 = r5.f13719h
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L18:
            android.content.SharedPreferences$Editor r0 = r5.f13719h
            boolean r0 = r0.commit()
            if (r0 != 0) goto L22
            r0 = 0
            goto L23
        L22:
            r0 = 1
        L23:
            android.content.SharedPreferences r1 = r5.f13717f
            if (r1 == 0) goto L35
            android.content.Context r1 = r5.f13721j
            if (r1 == 0) goto L35
            android.content.Context r1 = r5.f13721j
            java.lang.String r2 = r5.f13712a
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r5.f13717f = r1
        L35:
            java.lang.String r1 = android.os.Environment.getExternalStorageState()
            boolean r2 = p000.C2270yk.m12426a(r1)
            if (r2 != 0) goto La6
            java.lang.String r2 = "mounted"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L84
            yl r2 = r5.f13718g
            if (r2 != 0) goto L77
            java.lang.String r2 = r5.f13713b
            yn r2 = r5.m12443b(r2)
            if (r2 == 0) goto L84
            java.lang.String r4 = r5.f13712a
            yl r2 = r2.m12457a(r4, r3)
            r5.f13718g = r2
            boolean r2 = r5.f13723l
            if (r2 != 0) goto L67
            android.content.SharedPreferences r2 = r5.f13717f
            yl r4 = r5.f13718g
            r5.m12441a(r2, r4)
            goto L6e
        L67:
            yl r2 = r5.f13718g
            android.content.SharedPreferences r4 = r5.f13717f
            r5.m12442a(r2, r4)
        L6e:
            yl r2 = r5.f13718g
            yl$a r2 = r2.mo12432c()
            r5.f13720i = r2
            goto L84
        L77:
            yl$a r2 = r5.f13720i
            if (r2 == 0) goto L84
            yl$a r2 = r5.f13720i
            boolean r2 = r2.mo12439b()
            if (r2 != 0) goto L84
            r0 = 0
        L84:
            java.lang.String r2 = "mounted"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L98
            java.lang.String r2 = "mounted_ro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto La6
            yl r1 = r5.f13718g
            if (r1 == 0) goto La6
        L98:
            yn r1 = r5.f13722k     // Catch: java.lang.Exception -> La6
            if (r1 == 0) goto La6
            yn r1 = r5.f13722k     // Catch: java.lang.Exception -> La6
            java.lang.String r2 = r5.f13712a     // Catch: java.lang.Exception -> La6
            yl r1 = r1.m12457a(r2, r3)     // Catch: java.lang.Exception -> La6
            r5.f13718g = r1     // Catch: java.lang.Exception -> La6
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2272ym.m12450a():boolean");
    }

    /* JADX INFO: renamed from: a */
    public String m12447a(String str) {
        m12444b();
        if (this.f13717f != null) {
            String string = this.f13717f.getString(str, "");
            if (!C2270yk.m12426a(string)) {
                return string;
            }
        }
        return this.f13718g != null ? this.f13718g.mo12429a(str, "") : "";
    }
}
